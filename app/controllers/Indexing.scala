package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.future

import models.LuceneService
import play.api.data.Form
import play.api.data.Forms.text
import play.api.data.Forms.tuple
import play.api.mvc.Action
import play.api.mvc.Controller

object Indexing extends Controller {

  def form = Action { implicit request =>
    Ok(views.html.indexing.form())
  }

  def createIndex = Action { implicit request =>
    if (LuceneService.noIndexExists) {
      LuceneService.createIndex()
    }
    Ok(views.html.indexCreated())
  }

  def addSite = Action(parse.tolerantFormUrlEncoded) { implicit request =>
    val (site, title, withLinks) = Form(tuple("url" -> text, "title" -> text, "chkLinks" -> text)).bindFromRequest.get
    if (!site.isEmpty()) {
      future {
        LuceneService.addSiteToIndex(site, title, withLinks == "on")
      }
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