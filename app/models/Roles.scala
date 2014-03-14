package models

import scala.collection.JavaConversions._
import play.api.mvc.SimpleResult
import views.html.defaultpages.notFound
import play.api._
import play.api.mvc._
import views.html.defaultpages.unauthorized

object Roles {

  def protect(role: String, request: play.api.mvc.Request[Any])(body: => play.api.templates.Html) = {
    if (request.session.get("roles").getOrElse("").split(",").contains(role)) {
      body
    }
  }

  def authorised(role: String, request: play.api.mvc.Request[Any]):Boolean = {
    request.session.get("roles").getOrElse("").split(",").contains(role)
  }
}