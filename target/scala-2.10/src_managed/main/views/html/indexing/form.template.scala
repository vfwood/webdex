
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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("Index Content.")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

	<form method="post" action=""""),_display_(Seq[Any](/*5.31*/routes/*5.37*/.Indexing.addSite)),format.raw/*5.54*/("""">
		URL to index: <input type="text" name="url" style="width:400px">
		<input type="submit" value="Add to index">
	</form>

	<form method="post" action=""""),_display_(Seq[Any](/*10.31*/routes/*10.37*/.Indexing.clearIndex)),format.raw/*10.57*/("""">
		<input type="submit" value="Clear index">
	</form>

""")))})),format.raw/*14.2*/("""
"""))}
    }
    
    def render(flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply()(flash,request)
    
    def f:(() => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = () => (flash,request) => apply()(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 10 18:33:48 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/indexing/form.scala.html
                    HASH: 80b0705e6121cd78e8dea8332883b495a4bd9401
                    MATRIX: 589->1|743->61|780->64|818->94|857->96|924->128|938->134|976->151|1167->306|1182->312|1224->332|1313->390
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5|26->5|31->10|31->10|31->10|35->14
                    -- GENERATED --
                */
            