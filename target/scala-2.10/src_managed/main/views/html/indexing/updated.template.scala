
package views.html.indexing

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
object updated extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("Entry refreshed.")/*3.34*/ {_display_(Seq[Any](format.raw/*3.36*/("""

	Your content has been refreshed successfully.
""")))})),format.raw/*6.2*/("""
"""))}
    }
    
    def render(flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply()(flash,request)
    
    def f:(() => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = () => (flash,request) => apply()(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Mar 11 20:53:18 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/indexing/updated.scala.html
                    HASH: f3146b44d054f3b962f36bea4ddf10b33ad17cab
                    MATRIX: 592->1|746->61|783->64|823->96|862->98|942->148
                    LINES: 19->1|22->1|24->3|24->3|24->3|27->6
                    -- GENERATED --
                */
            