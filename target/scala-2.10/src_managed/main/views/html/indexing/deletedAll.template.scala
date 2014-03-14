
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
object deletedAll extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("Index emptied.")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

	All content has been removed from the Information Retrieval System.
""")))})),format.raw/*6.2*/("""
"""))}
    }
    
    def render(flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply()(flash,request)
    
    def f:(() => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = () => (flash,request) => apply()(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 10 18:38:38 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/indexing/deletedAll.scala.html
                    HASH: 3762e1c826d700ea3295ca3b77842f4a4b5c42d0
                    MATRIX: 595->1|749->61|786->64|824->94|863->96|965->168
                    LINES: 19->1|22->1|24->3|24->3|24->3|27->6
                    -- GENERATED --
                */
            