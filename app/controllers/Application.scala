package controllers

import play.api._
import play.api.mvc._
import models.LuceneService

/** Front page. */
object Application extends Controller {
  
  def index = Action { implicit request =>
    // If no index show page allowing creation.
    if (LuceneService.noIndexExists) {
    	Ok(views.html.noIndex())
    } else {
    	Ok(views.html.index("Welcome to PBS"))
    }
    
  }
}