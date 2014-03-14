
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
object loginForm extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("Please log in to PBS")/*3.38*/ {_display_(Seq[Any](format.raw/*3.40*/("""

    """),_display_(Seq[Any](/*5.6*/if(flash.get("errorMessage"))/*5.35*/ {_display_(Seq[Any](format.raw/*5.37*/("""
    	<div class="errorMessage">
    		"""),_display_(Seq[Any](/*7.8*/flash/*7.13*/.get("errorMessage"))),format.raw/*7.33*/("""
    	</div>	
    """)))})),format.raw/*9.6*/("""

	<form method="post" action="processLogin">
		<table class="formTable">
			<tr>
				<td>
					Username:
				</td>
				<td>
					<input type="text" name="username" autocomplete="off" 
						"""),_display_(Seq[Any](/*19.8*/if(flash.get("username"))/*19.33*/{_display_(Seq[Any](format.raw/*19.34*/("""
							value=""""),_display_(Seq[Any](/*20.16*/flash/*20.21*/.get("username"))),format.raw/*20.37*/(""""
						""")))})),format.raw/*21.8*/(""" 
						/>
				</td>
			</tr>
			<tr>
				<td>
					Password:
				</td>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
		</table>
		<input type="submit"/>
	</form>

""")))})),format.raw/*37.2*/("""
"""))}
    }
    
    def render(flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply()(flash,request)
    
    def f:(() => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = () => (flash,request) => apply()(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 12:51:40 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/loginForm.scala.html
                    HASH: eccbe034b1529265dcbe84a14d5ac73b0c6b8953
                    MATRIX: 585->1|739->61|776->64|820->100|859->102|900->109|937->138|976->140|1050->180|1063->185|1104->205|1153->224|1380->416|1414->441|1453->442|1505->458|1519->463|1557->479|1597->488|1821->681
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5|26->5|28->7|28->7|28->7|30->9|40->19|40->19|40->19|41->20|41->20|41->20|42->21|58->37
                    -- GENERATED --
                */
            