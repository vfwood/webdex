package controllers

import java.io.File
import scala.collection.mutable.ListBuffer
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.index._
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search._
import org.apache.lucene.store.FSDirectory
import org.apache.lucene.util.Version
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import scala.collection.JavaConversions
import models.LuceneService

object Search extends Controller {

  val indexDir = "/Users/vfwood/pbs-search";
  val luceneVersion = Version.LUCENE_47

  def index = Action { implicit request =>
    Ok(views.html.search.index())
  }

  def performSearch = Action(parse.tolerantFormUrlEncoded) { implicit request =>
    val term = request.body.get("term").map(_.head).getOrElse("")
    println(s"search term = '$term'")
    val results = LuceneService.performSearch(term: String)
    Ok(views.html.search.results(term, results))
  }
  
  def getSearch = Action { implicit request =>
    val term = request.getQueryString("term").getOrElse("")
    println(s"search term = '$term'")
    val results = LuceneService.performSearch(term: String)
    Ok(views.html.search.results(term, results))
  }

  def showFile(filename: String) = Action(parse.tolerantFormUrlEncoded) { implicit request =>
    val uri = "/Users/vfwood/learn-play/pbs/data/" + filename
    Ok.sendFile(
      content = new java.io.File(uri),
      inline = true)
  }
  
  def explain = Action(parse.tolerantFormUrlEncoded)  { implicit request =>
    val (id, term) = Form(tuple("id" -> text, "term" -> text)).bindFromRequest.get
    val explanation:String = LuceneService.explain(id, term)
    Ok(explanation)
  }
}