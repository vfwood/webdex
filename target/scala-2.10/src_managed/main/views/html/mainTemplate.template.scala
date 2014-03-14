
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
object mainTemplate extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,Html,Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pageTitle:String)(content: Html)(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.93*/("""

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.48*/routes/*7.54*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.97*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.48*/routes/*8.54*/.Assets.at("stylesheets/main.css"))),format.raw/*8.88*/("""">		
		<title>webdex Web Indexer</title>
		<script type="text/javascript" src="js/jquery-1.2.1.pack.js"></script>
		<script type="text/javascript" src=""""),_display_(Seq[Any](/*11.40*/routes/*11.46*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*11.88*/(""""></script>
	</head>
	<body style="background:#fff" class="body">
		<div style="padding:5px">
		</div>
		<div class="container-fluid">
			<nav class="navbar navbar-default" role="navigation">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#"><i>webdex Web Indexer</i></a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
					
					
			        <li><a href=""""),_display_(Seq[Any](/*35.26*/routes/*35.32*/.Application.index())),format.raw/*35.52*/("""">Home</a></li>
					"""),_display_(Seq[Any](/*36.7*/Roles/*36.12*/.protect("admin", request)/*36.38*/{_display_(Seq[Any](format.raw/*36.39*/("""
						<li><a href=""""),_display_(Seq[Any](/*37.21*/routes/*37.27*/.Users.index())),format.raw/*37.41*/("""">Users</a></li>
					""")))})),format.raw/*38.7*/("""
		  			<li><a href=""""),_display_(Seq[Any](/*39.22*/routes/*39.28*/.Login.form())),format.raw/*39.41*/("""">Login</a></li>
				
					"""),_display_(Seq[Any](/*41.7*/Roles/*41.12*/.protect("customer", request)/*41.41*/{_display_(Seq[Any](format.raw/*41.42*/("""
						<li><a href=""""),_display_(Seq[Any](/*42.21*/routes/*42.27*/.About.index())),format.raw/*42.41*/("""">About</a></li>
					""")))})),format.raw/*43.7*/("""
				
					"""),_display_(Seq[Any](/*45.7*/if(request.session.get("username"))/*45.42*/{_display_(Seq[Any](format.raw/*45.43*/("""
						<li><a href=""""),_display_(Seq[Any](/*46.21*/routes/*46.27*/.Login.logout())),format.raw/*46.42*/("""">Log Out</a></li>
					""")))})),format.raw/*47.7*/("""
					"""),_display_(Seq[Any](/*48.7*/Roles/*48.12*/.protect("search", request)/*48.39*/{_display_(Seq[Any](format.raw/*48.40*/("""
						<li><a href=""""),_display_(Seq[Any](/*49.21*/routes/*49.27*/.Search.index())),format.raw/*49.42*/("""">Search</a></li>
					""")))})),format.raw/*50.7*/("""
					"""),_display_(Seq[Any](/*51.7*/Roles/*51.12*/.protect("search", request)/*51.39*/{_display_(Seq[Any](format.raw/*51.40*/("""
						<li><a href=""""),_display_(Seq[Any](/*52.21*/routes/*52.27*/.Indexing.form())),format.raw/*52.43*/("""">Index</a></li>
					""")))})),format.raw/*53.7*/("""
			      </ul>
			      
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
			
			<div id="pageTemplate" class="hero-unit">
				<h1 id="pageTitle">"""),_display_(Seq[Any](/*61.25*/pageTitle)),format.raw/*61.34*/("""</h1>
				"""),_display_(Seq[Any](/*62.6*/content)),format.raw/*62.13*/("""
			</div>
		</div>
	</body>
</html>

"""))}
    }
    
    def render(pageTitle:String,content:Html,flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply(pageTitle)(content)(flash,request)
    
    def f:((String) => (Html) => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = (pageTitle) => (content) => (flash,request) => apply(pageTitle)(content)(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 14 03:42:04 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/mainTemplate.scala.html
                    HASH: 8ef37f592b917d83eef1fe33d09d87b89bdb95d0
                    MATRIX: 600->1|785->92|972->244|986->250|1050->293|1135->343|1149->349|1204->383|1393->536|1408->542|1472->584|2486->1562|2501->1568|2543->1588|2600->1610|2614->1615|2649->1641|2688->1642|2745->1663|2760->1669|2796->1683|2850->1706|2908->1728|2923->1734|2958->1747|3021->1775|3035->1780|3073->1809|3112->1810|3169->1831|3184->1837|3220->1851|3274->1874|3321->1886|3365->1921|3404->1922|3461->1943|3476->1949|3513->1964|3569->1989|3611->1996|3625->2001|3661->2028|3700->2029|3757->2050|3772->2056|3809->2071|3864->2095|3906->2102|3920->2107|3956->2134|3995->2135|4052->2156|4067->2162|4105->2178|4159->2201|4382->2388|4413->2397|4459->2408|4488->2415
                    LINES: 19->1|22->1|28->7|28->7|28->7|29->8|29->8|29->8|32->11|32->11|32->11|56->35|56->35|56->35|57->36|57->36|57->36|57->36|58->37|58->37|58->37|59->38|60->39|60->39|60->39|62->41|62->41|62->41|62->41|63->42|63->42|63->42|64->43|66->45|66->45|66->45|67->46|67->46|67->46|68->47|69->48|69->48|69->48|69->48|70->49|70->49|70->49|71->50|72->51|72->51|72->51|72->51|73->52|73->52|73->52|74->53|82->61|82->61|83->62|83->62
                    -- GENERATED --
                */
            