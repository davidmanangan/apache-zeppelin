/* NOTE this file is autogenerated by Scalate : see http://scalate.fusesource.org/ */

import _root_.scala.collection.JavaConversions._
import _root_.org.fusesource.scalate.support.TemplateConversions._
import _root_.org.fusesource.scalate.util.Measurements._

object $_scalate_$materializedViewDetails_ssp {
  def $_scalate_$render($_scalate_$_context: _root_.org.fusesource.scalate.RenderContext): Unit = {
    ;{
      implicit val context: org.fusesource.scalate.DefaultRenderContext = $_scalate_$_context.attribute("context")
      import context._
      
      
      $_scalate_$_context << ( "\n" );
      import       org.apache.zeppelin.cassandra.MetaDataHierarchy._

      $_scalate_$_context << ( "\n" );
      ;{
        val mvDetails: MaterializedViewDetails = $_scalate_$_context.attribute("mvDetails")
        ;{
          val withCaption: Boolean = $_scalate_$_context.attribute("withCaption")
          $_scalate_$_context << ( "<div class=\"row\">\n    <div class=\"col-md-2\"></div>\n    <div class=\"col-md-8 col-offset-md-2\">\n        <div class=\"panel panel-default table-responsive table-bordered\">\n            <table class=\"table\">\n                " );
          if (withCaption) {
            $_scalate_$_context << ( "\n                <caption>\n                    <h4 class=\"text-primary\">\n                        <span class=\"glyphicon glyphicon-eye-open\"></span>\n                        &nbsp;" );
            $_scalate_$_context <<< (             mvDetails.name
 );
            $_scalate_$_context << ( "\n                        &nbsp;<span class=\"glyphicon glyphicon-arrow-right\"></span>\n                        &nbsp;<span class=\"glyphicon glyphicon-th-list\"></span>\n                        &nbsp;" );
            $_scalate_$_context <<< (             mvDetails.baseTable
 );
            $_scalate_$_context << ( "&nbsp;\n                    </h4>\n                </caption>\n                " );
          }
          $_scalate_$_context << ( "                <thead>\n                    <tr>\n                        <th class=\"col-md-4\" width=\"10%\">Column Type</th>\n                        <th class=\"col-md-4\">Column Name</th>\n                        <th class=\"col-md-4\" style=\"text-align:left\">Data Type</th>\n                    </tr>\n                </thead>\n                <tbody>\n                    " );
          for (          column <- mvDetails.columns
) {
            $_scalate_$_context << ( "                        " );
            (            column.columnType
) match {
            case             PartitionKey
 =>
              $_scalate_$_context << ( "\n\n                    <tr class=\"info\">\n                        <td class=\"col-md-4\" width=\"10%\">\n                            <span class=\"glyphicon glyphicon-fullscreen\" title=\"Partition Key\"></span>\n                        </td>\n                        <td class=\"col-md-4\">" );
              $_scalate_$_context <<< (               column.name
 );
              $_scalate_$_context << ( "</td>\n                        <td class=\"col-md-4\" style=\"text-align:left\">" );
              $_scalate_$_context <<< (               column.dataType.asCql(true,true)
 );
              $_scalate_$_context << ( "</td>\n                    </tr>\n                        " );
            case             StaticColumn
 =>
              $_scalate_$_context << ( "\n                    <tr class=\"warning\">\n                        <td class=\"col-md-4\" width=\"10%\">\n                            <span class=\"glyphicon glyphicon-pushpin\" title=\"Static Column\"></span>\n                        </td>\n                        <td class=\"col-md-4\">" );
              $_scalate_$_context <<< (               column.name
 );
              $_scalate_$_context << ( "</td>\n                        <td class=\"col-md-4\" style=\"text-align:left\">" );
              $_scalate_$_context <<< (               column.dataType.asCql(true,true)
 );
              $_scalate_$_context << ( "</td>\n                    </tr>\n                        " );
            case             ClusteringColumn(ASC)
 =>
              $_scalate_$_context << ( "\n                    <tr class=\"success\">\n                        <td class=\"col-md-4\" width=\"10%\">\n                            <span class=\"glyphicon glyphicon-sort\" title=\"Clustering Column\"></span>\n                            &nbsp;\n                            <span class=\"glyphicon glyphicon-sort-by-attributes\" title=\"Sort ASC\"></span>\n                        </td>\n                        <td class=\"col-md-4\">" );
              $_scalate_$_context <<< (               column.name
 );
              $_scalate_$_context << ( "</td>\n                        <td class=\"col-md-4\" style=\"text-align:left\">" );
              $_scalate_$_context <<< (               column.dataType.asCql(true,true)
 );
              $_scalate_$_context << ( "</td>\n                    </tr>\n                        " );
            case             ClusteringColumn(DESC)
 =>
              $_scalate_$_context << ( "\n                    <tr class=\"success\">\n                        <td class=\"col-md-4\" width=\"10%\">\n                            <span class=\"glyphicon glyphicon-sort\" title=\"Clustering Column\"></span>\n                            &nbsp;\n                            <span class=\"glyphicon glyphicon-sort-by-attributes-alt\" title=\"Sort DESC\"></span>\n                        </td>\n                        <td class=\"col-md-4\">" );
              $_scalate_$_context <<< (               column.name
 );
              $_scalate_$_context << ( "</td>\n                        <td class=\"col-md-4\" style=\"text-align:left\">" );
              $_scalate_$_context <<< (               column.dataType.asCql(true,true)
 );
              $_scalate_$_context << ( "</td>\n                    </tr>\n                        " );
            case _ =>
              $_scalate_$_context << ( "\n                    <tr>\n                        <td class=\"col-md-4\" width=\"10%\"></td>\n                        <td class=\"col-md-4\">" );
              $_scalate_$_context <<< (               column.name
 );
              $_scalate_$_context << ( "</td>\n                        <td class=\"col-md-4\" style=\"text-align:left\">" );
              $_scalate_$_context <<< (               column.dataType.asCql(true,true)
 );
              $_scalate_$_context << ( "</td>\n                    </tr>\n                        " );
            }
            $_scalate_$_context << ( "                    " );
          }
          $_scalate_$_context << ( "\n                </tbody>\n            </table>\n            <div class=\"panel-footer\">\n                <a data-toggle=\"collapse\" data-target=\"#" );
          $_scalate_$_context <<< (           mvDetails.uniqueId
 );
          $_scalate_$_context << ( "_asCQL\" class=\"text-primary\">\n                    <strong>As CQL statement</strong>\n                    <span class=\"caret\"></span>\n                </a>\n                <br/><br/>\n                <div class=\"collapse\" id=\"" );
          $_scalate_$_context <<< (           mvDetails.uniqueId
 );
          $_scalate_$_context << ( "_asCQL\">\n                    <pre class=\"well\">" );
          $_scalate_$_context <<< (           mvDetails.asCQL
 );
          $_scalate_$_context << ( "</pre>\n                </div>\n            </div>\n        </div>\n    </div>\n    <div class=\"col-md-2\"></div>\n</div>" );
        }
      }
    }
  }
}


class $_scalate_$materializedViewDetails_ssp extends _root_.org.fusesource.scalate.Template {
  def render(context: _root_.org.fusesource.scalate.RenderContext): Unit = $_scalate_$materializedViewDetails_ssp.$_scalate_$render(context)
}