package controllers

import play.api._
import play.api.mvc._
import models.LuceneService

object Application extends Controller {
  
  val v = org.apache.lucene.util.Version.LUCENE_47
  
  def index = Action { implicit request => 
    if (LuceneService.noIndexExists) {
    	Ok(views.html.noIndex())
    }
    else {
    	Ok(views.html.index("Welcome to PBS"))
    }
    
  }
}