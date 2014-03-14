
package views.html.search

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("This is the Search page.")/*3.42*/ {_display_(Seq[Any](format.raw/*3.44*/("""

	<form method="post" action="performSearch">
		<input type="text" name="term">
		<input type="submit" value="Search">
	</form>
""")))})),format.raw/*9.2*/("""
"""))}
    }
    
    def render(flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply()(flash,request)
    
    def f:(() => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = () => (flash,request) => apply()(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 12:51:41 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/search/index.scala.html
                    HASH: bd1e5791361671d9f6dfe53a51ce653d5c1a85d4
                    MATRIX: 588->1|742->61|779->64|827->104|866->106|1026->236
                    LINES: 19->1|22->1|24->3|24->3|24->3|30->9
                    -- GENERATED --
                */
            