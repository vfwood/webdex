
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
object users extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate("User Maintenance.")/*3.35*/ {_display_(Seq[Any](format.raw/*3.37*/("""

	<p>
		Please choose an option.
	</p>
	<ul>
		<li>
			<a href=""""),_display_(Seq[Any](/*10.14*/routes/*10.20*/.Users.newAdmin())),format.raw/*10.37*/("""">
				Create an Administrator login.
			</a>
		</li>
		<li>
			<a href=""""),_display_(Seq[Any](/*15.14*/routes/*15.20*/.Users.adminUsers())),format.raw/*15.39*/("""">
				Edit or Delete an Administrator login
			</a>
		</li>
		<li>
			<a href="loginsPending.php">
				Customer Logins Pending
			</a>
		</li>
		<li>
			<a href="customerLoginNew.php">
				New Customer Login
			</a>
		</li>
		<li>
			<a href="customerLoginEdit.php">
				Edit / Delete a Customer Login
			</a>
		</li>
	    <li>
			<a href="passwordSettings.php">
	        	Maintain Password Settings
	    	</a>
		</li>
	</ul>
        
""")))})),format.raw/*41.2*/("""
"""))}
    }
    
    def render(flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply()(flash,request)
    
    def f:(() => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = () => (flash,request) => apply()(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 12:51:41 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/users.scala.html
                    HASH: db9b1a369a4002a238c35d5161a26124bbd0f9d9
                    MATRIX: 581->1|735->61|772->64|813->97|852->99|954->165|969->171|1008->188|1118->262|1133->268|1174->287|1642->724
                    LINES: 19->1|22->1|24->3|24->3|24->3|31->10|31->10|31->10|36->15|36->15|36->15|62->41
                    -- GENERATED --
                */
            