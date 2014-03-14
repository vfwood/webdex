package controllers

import play.api._
import play.api.mvc._
import models.CurrentUser

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
    val username = request.body.get("username").map(_.head).getOrElse("not set")
    val password = request.body.get("password").map(_.head).getOrElse("not set")
    println("Username: " + username)
    val user = CurrentUser.getUser(username, password)
    user match {
      case None => Redirect(routes.Login.form).flashing("errorMessage" -> "bad credentials", "username" -> username)
      case Some(u) => {
        val loginId = CurrentUser.generateLoginId.toString()
        u.loginId = loginId
        Redirect("loginSuccess").withSession("username" -> u.name, "loginId" -> u.loginId, "roles" -> u.roles.mkString(","))
      }
    }
  }
}