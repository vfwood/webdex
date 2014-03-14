
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
object userNewAdmin extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("New Admin User")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

    """),_display_(Seq[Any](/*5.6*/if(flash.get("errorMessage"))/*5.35*/ {_display_(Seq[Any](format.raw/*5.37*/("""
    	<div class="errorMessage">
    		<div style="font-weight:bold">Error:</div>
    		"""),_display_(Seq[Any](/*8.8*/for(s<-models.Errors.show(flash.get("errorMessage"))) yield /*8.61*/{_display_(Seq[Any](format.raw/*8.62*/("""
    			<div>"""),_display_(Seq[Any](/*9.14*/s)),format.raw/*9.15*/("""</div>
    		""")))})),format.raw/*10.8*/("""
    	</div>	
    """)))})),format.raw/*12.6*/("""

	<form method="post" action="processNewAdmin">
		<table class="formTable">
			<tr>
				<td>
					Username:
				</td>
				<td>
					<input type="text" name="username" autocomplete="off" 
						"""),_display_(Seq[Any](/*22.8*/if(flash.get("username"))/*22.33*/{_display_(Seq[Any](format.raw/*22.34*/("""
							value=""""),_display_(Seq[Any](/*23.16*/flash/*23.21*/.get("username"))),format.raw/*23.37*/(""""
						""")))})),format.raw/*24.8*/(""" 
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
			<tr>
				<td>
					Confirm Password:
				</td>
				<td>
					<input type="password" name="password2"/>
				</td>
			</tr>
		</table>
		<input type="submit"/>
	</form>

""")))})),format.raw/*48.2*/("""
"""))}
    }
    
    def render(flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply()(flash,request)
    
    def f:(() => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = () => (flash,request) => apply()(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 12:51:41 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/userNewAdmin.scala.html
                    HASH: 41389efa7518994e91e9d6f37c1b038fef7e6bdf
                    MATRIX: 588->1|742->61|779->64|817->94|856->96|897->103|934->132|973->134|1096->223|1164->276|1202->277|1251->291|1273->292|1318->306|1368->325|1598->520|1632->545|1671->546|1723->562|1737->567|1775->583|1815->592|2164->910
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5|26->5|29->8|29->8|29->8|30->9|30->9|31->10|33->12|43->22|43->22|43->22|44->23|44->23|44->23|45->24|69->48
                    -- GENERATED --
                */
            