package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  val v = org.apache.lucene.util.Version.LUCENE_47
  
  def index = Action { implicit request => 
    Ok(views.html.index("Welcome to PBS"))
  }
}