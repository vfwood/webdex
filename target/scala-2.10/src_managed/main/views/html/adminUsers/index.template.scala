
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[scala.collection.mutable.ListBuffer[User],Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(users:scala.collection.mutable.ListBuffer[User])(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.109*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("User Maintenance.")/*3.35*/ {_display_(Seq[Any](format.raw/*3.37*/("""

	<h1>
		Edit / Delete an Administrator Login
	</h1>
	<table class="table">
		<tr>
			<th>Username</th>
			<th colspan="2">Options</th>
		</tr>
		"""),_display_(Seq[Any](/*13.4*/for(user <- users) yield /*13.22*/{_display_(Seq[Any](format.raw/*13.23*/("""
		<tr>
			<td>
				"""),_display_(Seq[Any](/*16.6*/user/*16.10*/.name)),format.raw/*16.15*/("""
			</td>
			<td class="optionCell">
				<a href="adminUserModify/"""),_display_(Seq[Any](/*19.31*/user/*19.35*/.name)),format.raw/*19.40*/("""">
					edit
				</a>
			</td>
			<td class="optionCell">
				<a href="javascript:deleteUser('42');">
					delete
				</a>
			</td>
		</tr>        
		""")))})),format.raw/*29.4*/("""
	</table>
""")))})),format.raw/*31.2*/("""
"""))}
    }
    
    def render(users:scala.collection.mutable.ListBuffer[User],flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply(users)(flash,request)
    
    def f:((scala.collection.mutable.ListBuffer[User]) => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = (users) => (flash,request) => apply(users)(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 12:51:41 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/adminUsers/index.scala.html
                    HASH: c786b41951deb18d5613e088c18b00a6d22d7aec
                    MATRIX: 634->1|836->108|873->111|914->144|953->146|1136->294|1170->312|1209->313|1265->334|1278->338|1305->343|1408->410|1421->414|1448->419|1630->570|1673->582
                    LINES: 19->1|22->1|24->3|24->3|24->3|34->13|34->13|34->13|37->16|37->16|37->16|40->19|40->19|40->19|50->29|52->31
                    -- GENERATED --
                */
            