package controllers

import play.api._
import play.api.mvc._
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.util.Version
import org.apache.lucene.store.FSDirectory
import java.io.File
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.document.Document
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import java.util.Date
import org.apache.lucene.document.Field
import org.apache.lucene.index.IndexReader
import org.apache.lucene.index.DirectoryReader
import models.LuceneService

object Indexing extends Controller {

  def form = Action { implicit request =>
    Ok(views.html.indexing.form())
  }

  def addSite = Action(parse.tolerantFormUrlEncoded) { implicit request =>
    val site = request.body.get("url").map(_.head).getOrElse("")
    if (!site.isEmpty()) {
      LuceneService.addSiteToIndex(site)
    }
    Ok(views.html.indexing.indexed())
  }
  
  def refresh() = Action(parse.tolerantFormUrlEncoded) { implicit request => 
    val id = request.body.get("id").map(_.head).getOrElse("")
    if (id.isEmpty()) {
      NotFound("No doc id passed")
    } else {
      val url = request.body.get("url").map(_.head).getOrElse("")
      LuceneService.delete(id)
      LuceneService.addSiteToIndex(url)
      println(s"Refreshing document $id")
      Ok(views.html.indexing.updated())
    }
  }
  
  def delete() = Action(parse.tolerantFormUrlEncoded) { implicit request => 
    val id = request.body.get("id").map(_.head).getOrElse("")
    if (id.isEmpty()) {
      NotFound("No doc id passed")
    } else {
      LuceneService.delete(id)
      println(s"Deleting document $id")
      Ok(views.html.indexing.deleted())
    }
  }
  
  def clearIndex = Action { implicit request =>
    LuceneService.clearIndex()
    Ok(views.html.indexing.deletedAll())
  }
}