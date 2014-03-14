// @SOURCE:/Users/vfwood/learn-play/pbs/conf/routes
// @HASH:a6304ece4499bc6a707d02b8286f9bda860091ec
// @DATE:Mon Mar 10 18:33:48 GMT 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Login_form1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("loginForm"))))
        

// @LINE:9
private[this] lazy val controllers_Login_loginSuccess2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("loginSuccess"))))
        

// @LINE:10
private[this] lazy val controllers_Login_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:11
private[this] lazy val controllers_Login_loggedOut4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("loggedOut"))))
        

// @LINE:12
private[this] lazy val controllers_Login_processLogin5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("processLogin"))))
        

// @LINE:13
private[this] lazy val controllers_About_index6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("about"))))
        

// @LINE:15
private[this] lazy val controllers_Users_index7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users"))))
        

// @LINE:16
private[this] lazy val controllers_Users_newAdmin8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userNewAdmin"))))
        

// @LINE:17
private[this] lazy val controllers_Users_processNewAdmin9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("processNewAdmin"))))
        

// @LINE:18
private[this] lazy val controllers_Users_adminUsers10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("adminUsers"))))
        

// @LINE:19
private[this] lazy val controllers_Users_adminUserModify11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("adminUserModify/"),DynamicPart("username", """[^/]+""",true))))
        

// @LINE:21
private[this] lazy val controllers_Search_index12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search"))))
        

// @LINE:22
private[this] lazy val controllers_Search_performSearch13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("performSearch"))))
        

// @LINE:23
private[this] lazy val controllers_Search_showFile14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("showFile/"),DynamicPart("filename", """[^/]+""",true))))
        

// @LINE:25
private[this] lazy val controllers_Indexing_form15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("indexForm"))))
        

// @LINE:26
private[this] lazy val controllers_Indexing_addSite16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("indexing/addSite"))))
        

// @LINE:27
private[this] lazy val controllers_Indexing_delete17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("indexing/delete"))))
        

// @LINE:28
private[this] lazy val controllers_Indexing_refresh18 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("indexing/refresh"))))
        

// @LINE:29
private[this] lazy val controllers_Indexing_clearIndex19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("indexing/clearIndex"))))
        

// @LINE:32
private[this] lazy val controllers_Assets_at20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """loginForm""","""controllers.Login.form"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """loginSuccess""","""controllers.Login.loginSuccess"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Login.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """loggedOut""","""controllers.Login.loggedOut"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """processLogin""","""controllers.Login.processLogin"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """about""","""controllers.About.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users""","""controllers.Users.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userNewAdmin""","""controllers.Users.newAdmin"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """processNewAdmin""","""controllers.Users.processNewAdmin"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """adminUsers""","""controllers.Users.adminUsers"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """adminUserModify/$username<[^/]+>""","""controllers.Users.adminUserModify(username:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search""","""controllers.Search.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """performSearch""","""controllers.Search.performSearch"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """showFile/$filename<[^/]+>""","""controllers.Search.showFile(filename:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """indexForm""","""controllers.Indexing.form"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """indexing/addSite""","""controllers.Indexing.addSite"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """indexing/delete""","""controllers.Indexing.delete"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """indexing/refresh""","""controllers.Indexing.refresh"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """indexing/clearIndex""","""controllers.Indexing.clearIndex"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Login_form1(params) => {
   call { 
        invokeHandler(controllers.Login.form, HandlerDef(this, "controllers.Login", "form", Nil,"GET", """""", Routes.prefix + """loginForm"""))
   }
}
        

// @LINE:9
case controllers_Login_loginSuccess2(params) => {
   call { 
        invokeHandler(controllers.Login.loginSuccess, HandlerDef(this, "controllers.Login", "loginSuccess", Nil,"GET", """""", Routes.prefix + """loginSuccess"""))
   }
}
        

// @LINE:10
case controllers_Login_logout3(params) => {
   call { 
        invokeHandler(controllers.Login.logout, HandlerDef(this, "controllers.Login", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:11
case controllers_Login_loggedOut4(params) => {
   call { 
        invokeHandler(controllers.Login.loggedOut, HandlerDef(this, "controllers.Login", "loggedOut", Nil,"GET", """""", Routes.prefix + """loggedOut"""))
   }
}
        

// @LINE:12
case controllers_Login_processLogin5(params) => {
   call { 
        invokeHandler(controllers.Login.processLogin, HandlerDef(this, "controllers.Login", "processLogin", Nil,"POST", """""", Routes.prefix + """processLogin"""))
   }
}
        

// @LINE:13
case controllers_About_index6(params) => {
   call { 
        invokeHandler(controllers.About.index, HandlerDef(this, "controllers.About", "index", Nil,"GET", """""", Routes.prefix + """about"""))
   }
}
        

// @LINE:15
case controllers_Users_index7(params) => {
   call { 
        invokeHandler(controllers.Users.index, HandlerDef(this, "controllers.Users", "index", Nil,"GET", """""", Routes.prefix + """users"""))
   }
}
        

// @LINE:16
case controllers_Users_newAdmin8(params) => {
   call { 
        invokeHandler(controllers.Users.newAdmin, HandlerDef(this, "controllers.Users", "newAdmin", Nil,"GET", """""", Routes.prefix + """userNewAdmin"""))
   }
}
        

// @LINE:17
case controllers_Users_processNewAdmin9(params) => {
   call { 
        invokeHandler(controllers.Users.processNewAdmin, HandlerDef(this, "controllers.Users", "processNewAdmin", Nil,"POST", """""", Routes.prefix + """processNewAdmin"""))
   }
}
        

// @LINE:18
case controllers_Users_adminUsers10(params) => {
   call { 
        invokeHandler(controllers.Users.adminUsers, HandlerDef(this, "controllers.Users", "adminUsers", Nil,"GET", """""", Routes.prefix + """adminUsers"""))
   }
}
        

// @LINE:19
case controllers_Users_adminUserModify11(params) => {
   call(params.fromPath[String]("username", None)) { (username) =>
        invokeHandler(controllers.Users.adminUserModify(username), HandlerDef(this, "controllers.Users", "adminUserModify", Seq(classOf[String]),"GET", """""", Routes.prefix + """adminUserModify/$username<[^/]+>"""))
   }
}
        

// @LINE:21
case controllers_Search_index12(params) => {
   call { 
        invokeHandler(controllers.Search.index, HandlerDef(this, "controllers.Search", "index", Nil,"GET", """""", Routes.prefix + """search"""))
   }
}
        

// @LINE:22
case controllers_Search_performSearch13(params) => {
   call { 
        invokeHandler(controllers.Search.performSearch, HandlerDef(this, "controllers.Search", "performSearch", Nil,"POST", """""", Routes.prefix + """performSearch"""))
   }
}
        

// @LINE:23
case controllers_Search_showFile14(params) => {
   call(params.fromPath[String]("filename", None)) { (filename) =>
        invokeHandler(controllers.Search.showFile(filename), HandlerDef(this, "controllers.Search", "showFile", Seq(classOf[String]),"GET", """""", Routes.prefix + """showFile/$filename<[^/]+>"""))
   }
}
        

// @LINE:25
case controllers_Indexing_form15(params) => {
   call { 
        invokeHandler(controllers.Indexing.form, HandlerDef(this, "controllers.Indexing", "form", Nil,"GET", """""", Routes.prefix + """indexForm"""))
   }
}
        

// @LINE:26
case controllers_Indexing_addSite16(params) => {
   call { 
        invokeHandler(controllers.Indexing.addSite, HandlerDef(this, "controllers.Indexing", "addSite", Nil,"POST", """""", Routes.prefix + """indexing/addSite"""))
   }
}
        

// @LINE:27
case controllers_Indexing_delete17(params) => {
   call { 
        invokeHandler(controllers.Indexing.delete, HandlerDef(this, "controllers.Indexing", "delete", Nil,"POST", """""", Routes.prefix + """indexing/delete"""))
   }
}
        

// @LINE:28
case controllers_Indexing_refresh18(params) => {
   call { 
        invokeHandler(controllers.Indexing.refresh, HandlerDef(this, "controllers.Indexing", "refresh", Nil,"POST", """""", Routes.prefix + """indexing/refresh"""))
   }
}
        

// @LINE:29
case controllers_Indexing_clearIndex19(params) => {
   call { 
        invokeHandler(controllers.Indexing.clearIndex, HandlerDef(this, "controllers.Indexing", "clearIndex", Nil,"POST", """""", Routes.prefix + """indexing/clearIndex"""))
   }
}
        

// @LINE:32
case controllers_Assets_at20(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     