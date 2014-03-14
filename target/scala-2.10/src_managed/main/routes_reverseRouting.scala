// @SOURCE:/Users/vfwood/learn-play/pbs/conf/routes
// @HASH:a6304ece4499bc6a707d02b8286f9bda860091ec
// @DATE:Mon Mar 10 18:33:48 GMT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:32
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:32
class ReverseAssets {
    

// @LINE:32
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
class ReverseUsers {
    

// @LINE:16
def newAdmin(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "userNewAdmin")
}
                                                

// @LINE:17
def processNewAdmin(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "processNewAdmin")
}
                                                

// @LINE:19
def adminUserModify(username:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "adminUserModify/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)))
}
                                                

// @LINE:18
def adminUsers(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "adminUsers")
}
                                                

// @LINE:15
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "users")
}
                                                
    
}
                          

// @LINE:13
class ReverseAbout {
    

// @LINE:13
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "about")
}
                                                
    
}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
class ReverseIndexing {
    

// @LINE:27
def delete(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "indexing/delete")
}
                                                

// @LINE:26
def addSite(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "indexing/addSite")
}
                                                

// @LINE:28
def refresh(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "indexing/refresh")
}
                                                

// @LINE:29
def clearIndex(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "indexing/clearIndex")
}
                                                

// @LINE:25
def form(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "indexForm")
}
                                                
    
}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
class ReverseLogin {
    

// @LINE:12
def processLogin(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "processLogin")
}
                                                

// @LINE:11
def loggedOut(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "loggedOut")
}
                                                

// @LINE:8
def form(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "loginForm")
}
                                                

// @LINE:9
def loginSuccess(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "loginSuccess")
}
                                                

// @LINE:10
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:23
// @LINE:22
// @LINE:21
class ReverseSearch {
    

// @LINE:21
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search")
}
                                                

// @LINE:22
def performSearch(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "performSearch")
}
                                                

// @LINE:23
def showFile(filename:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "showFile/" + implicitly[PathBindable[String]].unbind("filename", dynamicString(filename)))
}
                                                
    
}
                          
}
                  


// @LINE:32
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:32
class ReverseAssets {
    

// @LINE:32
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
class ReverseUsers {
    

// @LINE:16
def newAdmin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.newAdmin",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userNewAdmin"})
      }
   """
)
                        

// @LINE:17
def processNewAdmin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.processNewAdmin",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "processNewAdmin"})
      }
   """
)
                        

// @LINE:19
def adminUserModify : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.adminUserModify",
   """
      function(username) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminUserModify/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username))})
      }
   """
)
                        

// @LINE:18
def adminUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.adminUsers",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminUsers"})
      }
   """
)
                        

// @LINE:15
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
      }
   """
)
                        
    
}
              

// @LINE:13
class ReverseAbout {
    

// @LINE:13
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.About.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "about"})
      }
   """
)
                        
    
}
              

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
class ReverseIndexing {
    

// @LINE:27
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Indexing.delete",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "indexing/delete"})
      }
   """
)
                        

// @LINE:26
def addSite : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Indexing.addSite",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "indexing/addSite"})
      }
   """
)
                        

// @LINE:28
def refresh : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Indexing.refresh",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "indexing/refresh"})
      }
   """
)
                        

// @LINE:29
def clearIndex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Indexing.clearIndex",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "indexing/clearIndex"})
      }
   """
)
                        

// @LINE:25
def form : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Indexing.form",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "indexForm"})
      }
   """
)
                        
    
}
              

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
class ReverseLogin {
    

// @LINE:12
def processLogin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Login.processLogin",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "processLogin"})
      }
   """
)
                        

// @LINE:11
def loggedOut : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Login.loggedOut",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loggedOut"})
      }
   """
)
                        

// @LINE:8
def form : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Login.form",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loginForm"})
      }
   """
)
                        

// @LINE:9
def loginSuccess : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Login.loginSuccess",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loginSuccess"})
      }
   """
)
                        

// @LINE:10
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Login.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:23
// @LINE:22
// @LINE:21
class ReverseSearch {
    

// @LINE:21
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Search.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search"})
      }
   """
)
                        

// @LINE:22
def performSearch : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Search.performSearch",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "performSearch"})
      }
   """
)
                        

// @LINE:23
def showFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Search.showFile",
   """
      function(filename) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "showFile/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filename", encodeURIComponent(filename))})
      }
   """
)
                        
    
}
              
}
        


// @LINE:32
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:32
class ReverseAssets {
    

// @LINE:32
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
class ReverseUsers {
    

// @LINE:16
def newAdmin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.newAdmin(), HandlerDef(this, "controllers.Users", "newAdmin", Seq(), "GET", """""", _prefix + """userNewAdmin""")
)
                      

// @LINE:17
def processNewAdmin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.processNewAdmin(), HandlerDef(this, "controllers.Users", "processNewAdmin", Seq(), "POST", """""", _prefix + """processNewAdmin""")
)
                      

// @LINE:19
def adminUserModify(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.adminUserModify(username), HandlerDef(this, "controllers.Users", "adminUserModify", Seq(classOf[String]), "GET", """""", _prefix + """adminUserModify/$username<[^/]+>""")
)
                      

// @LINE:18
def adminUsers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.adminUsers(), HandlerDef(this, "controllers.Users", "adminUsers", Seq(), "GET", """""", _prefix + """adminUsers""")
)
                      

// @LINE:15
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.index(), HandlerDef(this, "controllers.Users", "index", Seq(), "GET", """""", _prefix + """users""")
)
                      
    
}
                          

// @LINE:13
class ReverseAbout {
    

// @LINE:13
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.About.index(), HandlerDef(this, "controllers.About", "index", Seq(), "GET", """""", _prefix + """about""")
)
                      
    
}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
class ReverseIndexing {
    

// @LINE:27
def delete(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Indexing.delete(), HandlerDef(this, "controllers.Indexing", "delete", Seq(), "POST", """""", _prefix + """indexing/delete""")
)
                      

// @LINE:26
def addSite(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Indexing.addSite(), HandlerDef(this, "controllers.Indexing", "addSite", Seq(), "POST", """""", _prefix + """indexing/addSite""")
)
                      

// @LINE:28
def refresh(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Indexing.refresh(), HandlerDef(this, "controllers.Indexing", "refresh", Seq(), "POST", """""", _prefix + """indexing/refresh""")
)
                      

// @LINE:29
def clearIndex(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Indexing.clearIndex(), HandlerDef(this, "controllers.Indexing", "clearIndex", Seq(), "POST", """""", _prefix + """indexing/clearIndex""")
)
                      

// @LINE:25
def form(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Indexing.form(), HandlerDef(this, "controllers.Indexing", "form", Seq(), "GET", """""", _prefix + """indexForm""")
)
                      
    
}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
class ReverseLogin {
    

// @LINE:12
def processLogin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Login.processLogin(), HandlerDef(this, "controllers.Login", "processLogin", Seq(), "POST", """""", _prefix + """processLogin""")
)
                      

// @LINE:11
def loggedOut(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Login.loggedOut(), HandlerDef(this, "controllers.Login", "loggedOut", Seq(), "GET", """""", _prefix + """loggedOut""")
)
                      

// @LINE:8
def form(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Login.form(), HandlerDef(this, "controllers.Login", "form", Seq(), "GET", """""", _prefix + """loginForm""")
)
                      

// @LINE:9
def loginSuccess(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Login.loginSuccess(), HandlerDef(this, "controllers.Login", "loginSuccess", Seq(), "GET", """""", _prefix + """loginSuccess""")
)
                      

// @LINE:10
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Login.logout(), HandlerDef(this, "controllers.Login", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:23
// @LINE:22
// @LINE:21
class ReverseSearch {
    

// @LINE:21
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Search.index(), HandlerDef(this, "controllers.Search", "index", Seq(), "GET", """""", _prefix + """search""")
)
                      

// @LINE:22
def performSearch(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Search.performSearch(), HandlerDef(this, "controllers.Search", "performSearch", Seq(), "POST", """""", _prefix + """performSearch""")
)
                      

// @LINE:23
def showFile(filename:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Search.showFile(filename), HandlerDef(this, "controllers.Search", "showFile", Seq(classOf[String]), "GET", """""", _prefix + """showFile/$filename<[^/]+>""")
)
                      
    
}
                          
}
        
    