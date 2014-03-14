package controllers

import play.api._
import play.api.mvc._
import play.api.db.DB

object About extends Controller {

  def index = Action { implicit request => 
  	Ok(views.html.about())
  }
}