
package views.html.adminUsers

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
object modify extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(username:String)(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.77*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("Modify Admin User: " + username)/*3.48*/ {_display_(Seq[Any](format.raw/*3.50*/("""

    """),_display_(Seq[Any](/*5.6*/if(flash.get("errorMessage"))/*5.35*/ {_display_(Seq[Any](format.raw/*5.37*/("""
    	<div class="errorMessage">
    		<div style="font-weight:bold">Error:</div>
    		"""),_display_(Seq[Any](/*8.8*/for(s<-models.Errors.show(flash.get("errorMessage"))) yield /*8.61*/{_display_(Seq[Any](format.raw/*8.62*/("""
    			<div>"""),_display_(Seq[Any](/*9.14*/s)),format.raw/*9.15*/("""</div>
    		""")))})),format.raw/*10.8*/("""
    	</div>	
    """)))})),format.raw/*12.6*/("""

	<form method="post" action="test">
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
    
    def render(username:String,flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply(username)(flash,request)
    
    def f:((String) => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = (username) => (flash,request) => apply(username)(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 12:51:41 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/adminUsers/modify.scala.html
                    HASH: c48b10bc75b1bd41ebf8815466d0c7fb73630b3c
                    MATRIX: 600->1|769->76|806->79|860->125|899->127|940->134|977->163|1016->165|1139->254|1207->307|1245->308|1294->322|1316->323|1361->337|1411->356|1630->540|1664->565|1703->566|1755->582|1769->587|1807->603|1847->612|2196->930
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5|26->5|29->8|29->8|29->8|30->9|30->9|31->10|33->12|43->22|43->22|43->22|44->23|44->23|44->23|45->24|69->48
                    -- GENERATED --
                */
            