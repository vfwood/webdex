
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String)(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.77*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("Welcome to PBS")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

    Please choose an option from the Main Menu.

""")))})),format.raw/*7.2*/("""
"""))}
    }
    
    def render(message:String,flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply(message)(flash,request)
    
    def f:((String) => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = (message) => (flash,request) => apply(message)(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 12:51:40 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/index.scala.html
                    HASH: 8fd23cadb6da1ab5fec188125d23d3b3b0c0127d
                    MATRIX: 588->1|757->76|794->79|832->109|871->111|953->163
                    LINES: 19->1|22->1|24->3|24->3|24->3|28->7
                    -- GENERATED --
                */
            