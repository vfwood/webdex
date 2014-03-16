package models

import java.io.File
import java.util.Date
import java.util.concurrent.atomic.AtomicLong

import scala.collection.JavaConversions
import scala.collection.mutable.ListBuffer

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser
import org.apache.lucene.queryparser.classic.ParseException
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.queryparser.flexible.standard.QueryParserUtil
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.TopScoreDocCollector
import org.apache.lucene.store.FSDirectory
import org.apache.lucene.util.Version

object LuceneService {

  val indexDir = System.getProperty("user.home") + File.separator + "webdex-data"
  val idSource = new AtomicLong()
  val version = Version.LUCENE_47

  def index = { FSDirectory.open(new File(indexDir)) }

  def analyser = { new StandardAnalyzer(version) }

  def clearIndex() = {
    withIndexWriter {
      indexWriter => indexWriter.deleteAll
    }
  }

  def createWriterConfig = { new IndexWriterConfig(version, analyser) }

  def addSiteToIndex(uri: String, title: String = "") = {
    withIndexWriter {
      indexWriter =>
        val doc = new Document()
        val id = nextId
        println("Using id " + id)
        val contents = read(uri)
        val indexTitle = if (title.isEmpty()) titleFrom(contents) else title
        println(s"Using title [$indexTitle]")
        doc.add(new StringField("id", id, Field.Store.YES))
        doc.add(new TextField("added", new Date().toString(), Field.Store.YES))
        doc.add(new TextField("contents", contents, Field.Store.NO))
        doc.add(new TextField("title", indexTitle, Field.Store.YES))
        doc.add(new TextField("uri", uri, Field.Store.YES))
        doc.add(new StringField("type", "web-url", Field.Store.YES))
        indexWriter.addDocument(doc)
    }
  }

  def titleFrom(content: String) = {
    try {
      val from = content.indexOf("title") + 6
      val to = content.substring(from).indexOf("</title>")
      content.substring(from, from + to).trim
    } catch {
      case e: Exception => e.printStackTrace(); "error"
    }
  }

  def delete(id: String) = {
    withIndexWriter {
      indexWriter =>
        val queryParser = new QueryParser(version, "id", analyser)
        val q = queryParser.parse(id)
        indexWriter.deleteDocuments(q)
    }
  }

  def performSearch(term: String) = {
    val fields = Array("contents", "title")
    val queryParser = new MultiFieldQueryParser(version, fields, analyser)
    var q: Query = null
    try {
      q = queryParser.parse(term)
    } catch {
      case e: ParseException => q = queryParser.parse(QueryParserUtil.escape(term))
    }
    val hitsPerPage = 100;
    val reader = DirectoryReader.open(index)
    val searcher = new IndexSearcher(reader)
    val collector = TopScoreDocCollector.create(hitsPerPage, true)
    searcher.search(q, collector)
    val hits = collector.topDocs().scoreDocs

    // display results
    val results = new ListBuffer[FetchedDocument]
    println("Found " + hits.length + " hits.")
    for (i <- 0.until(hits.length)) {
      val docId = hits(i).doc;
      val score = hits(i).score
      val d = searcher.doc(docId)
      val fields = JavaConversions.collectionAsScalaIterable(d.getFields())
      results.append(FetchedDocument(d.get("uri"), d.get("added"), d.get("id"), d.get("title"), score))
    }
    reader.close()
    results
  }

  def noIndexExists = {
    val file = new java.io.File(indexDir)
    !file.exists
  }

  def createIndex() = {
    new File(indexDir).mkdir()
    withIndexWriter {
      indexWriter =>
    }
  }

  def nextId = System.currentTimeMillis() + "." + idSource.incrementAndGet()

  def read(uri: String) = scala.io.Source.fromURL(uri).mkString

  def withIndexWriter(f: IndexWriter => Unit) = {
    val indexWriter = new IndexWriter(index, new IndexWriterConfig(version, analyser))
    try {
      f(indexWriter); indexWriter.close()
    } catch {
      case e: Exception => e.printStackTrace(); indexWriter.rollback(); indexWriter.close()
    }
  }
}