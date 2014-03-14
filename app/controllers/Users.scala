package controllers

import play.api._
import play.api.mvc._
import play.api.db.DB
import models.CurrentUser
import models.Errors
import models.User

/** UserManagement functionality. */
object Users extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.users())
  }

  def newAdmin = Action { implicit request =>
    Ok(views.html.userNewAdmin())
  }
  
  def adminUsers = Action { implicit request =>
    val users = CurrentUser.getUsers()
    Ok(views.html.adminUsers.index(users))
  }
  
  def adminUserModify(username:String) = Action { implicit request =>
    
    Ok(views.html.adminUsers.modify(username))
  }

  def processNewAdmin = Action(parse.tolerantFormUrlEncoded) { implicit request =>
    val username = request.body.get("username").map(_.head).getOrElse("")
    val password = request.body.get("password").map(_.head).getOrElse("")
    val password2 = request.body.get("password2").map(_.head).getOrElse("")

    // Build up errors.
    val errors = new Errors()
    if (CurrentUser.getUsers().exists(_.name == username)) {
      errors.add("Username exists")
    }
    if (username.isEmpty) errors.add("Username cannot be empty")
    if (password.isEmpty) errors.add("Password cannot be empty")
    if (password != password2) errors.add(s"Passwords do not match")

    if (!errors.hasErrors) {
      try {
        CurrentUser.insertUser(User(username, password, ""))
      } catch {
        case e: Throwable => errors.add("Error inserting user into the database: " + e.getMessage())
      }
    }

    errors.hasErrors match {
      case true => Redirect(routes.Users.newAdmin).flashing("errorMessage" -> errors.asErrorMessage, "username" -> username)
      case _ => Ok(views.html.adminAdded())
    }
  }
}