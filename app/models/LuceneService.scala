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
import org.apache.lucene.queryparser.classic.ParseException
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.TopScoreDocCollector
import org.apache.lucene.store.FSDirectory
import org.apache.lucene.util.Version
import controllers.FetchedDocument
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.queryparser.flexible.standard.QueryParserUtil

object LuceneService {

  val indexDir = "/Users/vfwood/pbs-search"
  val idSource = new AtomicLong()
  val version = Version.LUCENE_47

  def index = { FSDirectory.open(new File(indexDir)) }

  def getIndexWriter() = {
    new IndexWriter(index, new IndexWriterConfig(version, analyser))
  }

  def analyser = { new StandardAnalyzer(version) }

  def clearIndex() = {
    val indexWriter = getIndexWriter()
    indexWriter.deleteAll
    indexWriter.close
  }

  def createWriterConfig = { new IndexWriterConfig(version, analyser) }

  def addSiteToIndex(uri: String) = {
    val indexWriter = getIndexWriter()
    try {
      val doc = new Document()
      val id = nextId
      println("Using id " + id)
      doc.add(new StringField("id", id, Field.Store.YES))
      doc.add(new TextField("added", new Date().toString(), Field.Store.YES))
      doc.add(new TextField("contents", read(uri), Field.Store.NO))
      doc.add(new StringField("uri", uri, Field.Store.YES))
      doc.add(new StringField("type", "web-url", Field.Store.YES))
      indexWriter.addDocument(doc)
    } finally {
      indexWriter.close()
    }
  }

  def delete(id: String) = {
    val queryParser = new QueryParser(version, "id", analyser)
    val q = queryParser.parse(id)
    val indexWriter = getIndexWriter()
    indexWriter.deleteDocuments(q)
    indexWriter.close
  }

  def performSearch(term: String) = {
    val queryParser = new QueryParser(version, "contents", analyser)
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
      val d = searcher.doc(docId)
      val fields = JavaConversions.collectionAsScalaIterable(d.getFields())
      results.append(FetchedDocument(d.get("uri"), d.get("added"), d.get("id")))
    }
    reader.close()
    results
  }

  def nextId = System.currentTimeMillis() + "." + idSource.incrementAndGet()

  def read(uri: String) = scala.io.Source.fromURL(uri).mkString
}