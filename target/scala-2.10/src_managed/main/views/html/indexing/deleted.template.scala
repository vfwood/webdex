
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
object deleted extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("Entry deleted.")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

	Your content has been removed successfully.
""")))})),format.raw/*6.2*/("""
"""))}
    }
    
    def render(flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply()(flash,request)
    
    def f:(() => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = () => (flash,request) => apply()(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 10 04:11:33 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/indexing/deleted.scala.html
                    HASH: 8220c0daa37dff331d740a563e7f0c9195e63dbc
                    MATRIX: 592->1|746->61|783->64|821->94|860->96|938->144
                    LINES: 19->1|22->1|24->3|24->3|24->3|27->6
                    -- GENERATED --
                */
            