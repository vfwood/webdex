
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
object results extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,scala.collection.mutable.ListBuffer[controllers.FetchedDocument],Flash,play.api.mvc.Request[Any],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(term:String, results:scala.collection.mutable.ListBuffer[controllers.FetchedDocument])(implicit flash:Flash, request: play.api.mvc.Request[Any]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.147*/("""

"""),_display_(Seq[Any](/*3.2*/mainTemplate(s"${results.length} Search Results for '$term'")/*3.63*/ {_display_(Seq[Any](format.raw/*3.65*/("""
	
	<form method="post" action="performSearch" style="margin:10px 0px">
		<input type="text" name="term" value=""""),_display_(Seq[Any](/*6.42*/term)),format.raw/*6.46*/("""" style="width:600px">
		<input type="submit" value="Search">
	</form>
	
	<table class="table table-striped table-bordered table-condensed">
	<thead class="thead" style="background:limegreen">
		<tr>
			<th>
				Document
			</th>
			<th>
				Document Id
			</th>
			<th>
				Date Added
			</th>
			<th>
				Options
			</th>
		</tr></thead>
		"""),_display_(Seq[Any](/*26.4*/for(doc <- results) yield /*26.23*/{_display_(Seq[Any](format.raw/*26.24*/("""
			<tr>
				<td>
					<a href=""""),_display_(Seq[Any](/*29.16*/doc/*29.19*/.uri)),format.raw/*29.23*/("""" target="blank">"""),_display_(Seq[Any](/*29.41*/doc/*29.44*/.uri)),format.raw/*29.48*/("""</a>
				</td>
				<td>
					"""),_display_(Seq[Any](/*32.7*/doc/*32.10*/.id)),format.raw/*32.13*/("""
				</td>
				<td>
					"""),_display_(Seq[Any](/*35.7*/doc/*35.10*/.added)),format.raw/*35.16*/("""
				</td>
				<td>
					<form method="post" action=""""),_display_(Seq[Any](/*38.35*/routes/*38.41*/.Indexing.refresh)),format.raw/*38.58*/("""" style="display:inline">
						<input type="hidden" name="id" value=""""),_display_(Seq[Any](/*39.46*/doc/*39.49*/.id)),format.raw/*39.52*/("""">
						<input type="hidden" name="url" value=""""),_display_(Seq[Any](/*40.47*/doc/*40.50*/.uri)),format.raw/*40.54*/("""">
						<input type="submit" value="refresh">
					</form>
					<form method="post" action=""""),_display_(Seq[Any](/*43.35*/routes/*43.41*/.Indexing.delete)),format.raw/*43.57*/("""" style="display:inline">
						<input type="hidden" name="id" value=""""),_display_(Seq[Any](/*44.46*/doc/*44.49*/.id)),format.raw/*44.52*/("""">
						<input type="submit" value="delete">
					</form>
				</td>
			</tr>
		""")))})),format.raw/*49.4*/("""
	</table>
""")))})),format.raw/*51.2*/("""
"""))}
    }
    
    def render(term:String,results:scala.collection.mutable.ListBuffer[controllers.FetchedDocument],flash:Flash,request:play.api.mvc.Request[Any]): play.api.templates.HtmlFormat.Appendable = apply(term,results)(flash,request)
    
    def f:((String,scala.collection.mutable.ListBuffer[controllers.FetchedDocument]) => (Flash,play.api.mvc.Request[Any]) => play.api.templates.HtmlFormat.Appendable) = (term,results) => (flash,request) => apply(term,results)(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Mar 11 20:55:24 GMT 2014
                    SOURCE: /Users/vfwood/learn-play/pbs/app/views/search/results.scala.html
                    HASH: 0093ec6674881cef04b0e1055e4a917bf63ae5c2
                    MATRIX: 662->1|902->146|939->149|1008->210|1047->212|1195->325|1220->329|1598->672|1633->691|1672->692|1741->725|1753->728|1779->732|1833->750|1845->753|1871->757|1936->787|1948->790|1973->793|2034->819|2046->822|2074->828|2164->882|2179->888|2218->905|2325->976|2337->979|2362->982|2447->1031|2459->1034|2485->1038|2615->1132|2630->1138|2668->1154|2775->1225|2787->1228|2812->1231|2924->1312|2967->1324
                    LINES: 19->1|22->1|24->3|24->3|24->3|27->6|27->6|47->26|47->26|47->26|50->29|50->29|50->29|50->29|50->29|50->29|53->32|53->32|53->32|56->35|56->35|56->35|59->38|59->38|59->38|60->39|60->39|60->39|61->40|61->40|61->40|64->43|64->43|64->43|65->44|65->44|65->44|70->49|72->51
                    -- GENERATED --
                */
            