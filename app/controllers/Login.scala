package controllers

import play.api._
import play.api.mvc._
import models.CurrentUser
import play.api.data._
import play.api.data.Forms._

object Login extends Controller {

  def form = Action { implicit request =>
    Ok(views.html.loginForm())
  }

  def loginSuccess = Action {
    implicit request =>
      Ok(views.html.loginSuccess())
  }

  def logout = Action { implicit request => 
    Redirect("loggedOut").withNewSession
  }
  
  def loggedOut = Action { implicit request => 
    Ok(views.html.loggedOut())
  } 
  
  def processLogin = Action(parse.tolerantFormUrlEncoded) { implicit request =>
    val (username, password) = loginForm.bindFromRequest.get
    val user = CurrentUser.getUser(username, password)
    user match {
      case None => Redirect(routes.Login.form).flashing("errorMessage" -> "bad credentials", "username" -> username)
      case Some(u) => {
        Redirect("loginSuccess").withSession("username" -> u.name, "roles" -> u.roles.mkString(","))
      }
    }
  }
  
  val loginForm = Form(tuple("username"-> text, "password" -> text))
}
