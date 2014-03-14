
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object loggedOut extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("You have logged out.")/*3.38*/ {_display_(Seq[Any](format.raw/*3.40*/("""
    You have successfully logged out.
""")))})),format.raw/*5.2*/("""
"""))}
    }
    
    def render(flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply()(flash,request)
    
    def f:(() => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = () => (flash,request) => apply()(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 12:51:40 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/loggedOut.scala.html
                    HASH: f0f76bd271d667c1c69b7cef90693ac813d657dc
                    MATRIX: 585->1|739->61|776->64|820->100|859->102|929->142
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5
                    -- GENERATED --
                */
            