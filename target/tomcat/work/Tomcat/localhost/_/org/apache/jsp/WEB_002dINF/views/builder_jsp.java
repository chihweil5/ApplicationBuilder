/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-01-25 20:33:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class builder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/footer.jspf", Long.valueOf(1485370342000L));
    _jspx_dependants.put("/WEB-INF/views/common/header.jspf", Long.valueOf(1485371477000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fid_005fcommandName_005fclass;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fid_005fcommandName_005fclass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fid_005fcommandName_005fclass.release();
    _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Application Builder</title>\n");
      out.write("<link href=\"webjars/bootstrap/3.3.6/css/bootstrap.min.css\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css\" />\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js\"></script>\n");
      out.write("<script src=\"http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js\"></script>\n");
      out.write("<script src=\"http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("<!--  \n");
      out.write("<script>\n");
      out.write("window.onload = function() {\n");
      out.write("    if (window.jQuery) {  \n");
      out.write("        // jQuery is loaded  \n");
      out.write("        alert(\"Yeah!\");\n");
      out.write("    } else {\n");
      out.write("        // jQuery is not loaded\n");
      out.write("        alert(\"Doesn't Work\");\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("$(document).ready(function() {\n");
      out.write("alert(\"Hiiii\"); \n");
      out.write("}); \n");
      out.write("</script>\n");
      out.write("-->\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("\t<h1>Android Application Builder</h1>\n");
      out.write("<br>\n");
      out.write("\t");
      if (_jspx_meth_form_005fform_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("$(document).ready(function() {\n");
      out.write("\tconsole.log( \"ready!\" );\n");
      out.write("    var usernameValidators = {\n");
      out.write("            row: '.col-xs-2',   // The title is placed inside a <div class=\"col-xs-4\"> element\n");
      out.write("            validators: {\n");
      out.write("                notEmpty: {\n");
      out.write("                    message: 'The user name is required'\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        },\n");
      out.write("        reponameValidators = {\n");
      out.write("            row: '.col-xs-2',\n");
      out.write("            validators: {\n");
      out.write("                notEmpty: {\n");
      out.write("                    message: 'The repository name is required'\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        },\n");
      out.write("        pathValidators = {\n");
      out.write("            row: '.col-xs-3',\n");
      out.write("            validators: {\n");
      out.write("                notEmpty: {\n");
      out.write("                    message: 'The local path is required'\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        },\n");
      out.write("        githubIndex = 0;\n");
      out.write("\n");
      out.write("    $('#githubForm')\n");
      out.write("        .formValidation({\n");
      out.write("            framework: 'bootstrap',\n");
      out.write("            icon: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                'github[0].username': usernameValidators,\n");
      out.write("                'github[0].reponame': reponameValidators,\n");
      out.write("                'github[0].path': pathValidators\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("\n");
      out.write("        // Add button click handler\n");
      out.write("        .on('click', '.addButton', function() {\n");
      out.write("        \tgithubIndex++;\n");
      out.write("            var $template = $('#githubTemplate'),\n");
      out.write("                $clone    = $template\n");
      out.write("                                .clone()\n");
      out.write("                                .removeClass('hide')\n");
      out.write("                                .removeAttr('id')\n");
      out.write("                                .attr('data-github-index', githubIndex)\n");
      out.write("                                .insertBefore($template);\n");
      out.write("\n");
      out.write("            // Update the name attributes\n");
      out.write("            $clone\n");
      out.write("                .find('[name=\"username\"]').attr('name', 'github[' + githubIndex + '].username').end()\n");
      out.write("                .find('[name=\"reponame\"]').attr('name', 'github[' + githubIndex + '].reponame').end()\n");
      out.write("                .find('[name=\"tags\"]').attr('name', 'github[' + githubIndex + '].tags').end()\n");
      out.write("                .find('[name=\"path\"]').attr('name', 'github[' + githubIndex + '].path').end();\n");
      out.write("\n");
      out.write("            // Add new fields\n");
      out.write("            // Note that we also pass the validator rules for new field as the third parameter\n");
      out.write("            $('#githubForm')\n");
      out.write("                .formValidation('addField', 'github[' + githubIndex + '].username', usernameValidators)\n");
      out.write("                .formValidation('addField', 'github[' + githubIndex + '].reponame', reponameValidators)\n");
      out.write("                .formValidation('addField', 'github[' + githubIndex + '].path', pathValidators);\n");
      out.write("        })\n");
      out.write("\n");
      out.write("        // Remove button click handler\n");
      out.write("        .on('click', '.removeButton', function() {\n");
      out.write("            var $row  = $(this).parents('.form-group'),\n");
      out.write("                index = $row.attr('data-github-index');\n");
      out.write("\n");
      out.write("            // Remove fields\n");
      out.write("            $('#githubForm')\n");
      out.write("                .formValidation('removeField', $row.find('[name=\"github[' + index + '].username\"]'))\n");
      out.write("                .formValidation('removeField', $row.find('[name=\"github[' + index + '].reponame\"]'))\n");
      out.write("                .formValidation('removeField', $row.find('[name=\"github[' + index + '].path\"]'));\n");
      out.write("\n");
      out.write("            // Remove element containing the fields\n");
      out.write("            $row.remove();\n");
      out.write("        });\n");
      out.write("    \n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_form_005fform_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  form:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_005fform_005f0 = (org.springframework.web.servlet.tags.form.FormTag) _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fid_005fcommandName_005fclass.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_form_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_form_005fform_005f0.setParent(null);
    // /WEB-INF/views/builder.jsp(7,1) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setId("githubForm");
    // /WEB-INF/views/builder.jsp(7,1) name = method type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setMethod("post");
    // /WEB-INF/views/builder.jsp(7,1) null
    _jspx_th_form_005fform_005f0.setDynamicAttribute(null, "class", "form-horizontal");
    // /WEB-INF/views/builder.jsp(7,1) name = commandName type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setCommandName("githubInfo");
    int[] _jspx_push_body_count_form_005fform_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_form_005fform_005f0 = _jspx_th_form_005fform_005f0.doStartTag();
      if (_jspx_eval_form_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t<div class=\"form-group\">\n");
          out.write("\t\t\t<label class=\"col-xs-1 control-label\">Project</label>\n");
          out.write("\t\t\t<div class=\"col-xs-2\">\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_form_005finput_005f0(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"col-xs-2\">\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_form_005finput_005f1(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"col-xs-3\">\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_form_005finput_005f2(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"col-xs-3\">\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_form_005finput_005f3(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t\n");
          out.write("\t\t\t<div class=\"col-xs-1\">\n");
          out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default addButton\"><i class=\"fa fa-plus\" aria-hidden=\"true\"></i></button>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t</div>\n");
          out.write("\n");
          out.write("\t\t<!-- The template for adding new field -->\n");
          out.write("\t\t<div class=\"form-group hide\" id=\"githubTemplate\">\n");
          out.write("\t\t\t<div class=\"col-xs-2 col-xs-offset-1\">\n");
          out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"username\"\n");
          out.write("\t\t\t\t\tplaceholder=\"GitHub User Name\" />\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"col-xs-2\">\n");
          out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"reponame\"\n");
          out.write("\t\t\t\t\tplaceholder=\"Repository Name\" />\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"col-xs-3\">\n");
          out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"tags\"\n");
          out.write("\t\t\t\t\tplaceholder=\"SHA Tag\" />\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"col-xs-3\">\n");
          out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=path\n");
          out.write("\t\t\t\t\tplaceholder=\"Local Path\" />\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"col-xs-1\">\n");
          out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default removeButton\">\n");
          out.write("\t\t\t\t\t<i class=\"fa fa-minus\"></i>\n");
          out.write("\t\t\t\t</button>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t</div>\n");
          out.write("\n");
          out.write("\t\t<div class=\"form-group\">\n");
          out.write("\t\t\t<div class=\"col-xs-5 col-xs-offset-1\">\n");
          out.write("\t\t\t\t<button id=\"CloneBtn\" type=\"submit\" class=\"btn btn-primary btn-md\">Clone and Build</button>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t</div>\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_form_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_form_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005fform_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005fform_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005fform_005f0.doFinally();
      _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fid_005fcommandName_005fclass.reuse(_jspx_th_form_005fform_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_form_005finput_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_005finput_005f0 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_005finput_005f0.setPageContext(_jspx_page_context);
    _jspx_th_form_005finput_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/builder.jsp(11,4) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f0.setPath("userName");
    // /WEB-INF/views/builder.jsp(11,4) null
    _jspx_th_form_005finput_005f0.setDynamicAttribute(null, "type", "text");
    // /WEB-INF/views/builder.jsp(11,4) null
    _jspx_th_form_005finput_005f0.setDynamicAttribute(null, "class", "form-control");
    // /WEB-INF/views/builder.jsp(11,4) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f0.setId("github[0].username");
    // /WEB-INF/views/builder.jsp(11,4) null
    _jspx_th_form_005finput_005f0.setDynamicAttribute(null, "name", "github[0].username");
    // /WEB-INF/views/builder.jsp(11,4) null
    _jspx_th_form_005finput_005f0.setDynamicAttribute(null, "placeholder", "GitHub User Name");
    int[] _jspx_push_body_count_form_005finput_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_form_005finput_005f0 = _jspx_th_form_005finput_005f0.doStartTag();
      if (_jspx_th_form_005finput_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005finput_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005finput_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005finput_005f0.doFinally();
      _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody.reuse(_jspx_th_form_005finput_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_form_005finput_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_005finput_005f1 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_005finput_005f1.setPageContext(_jspx_page_context);
    _jspx_th_form_005finput_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/builder.jsp(15,4) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f1.setPath("repoName");
    // /WEB-INF/views/builder.jsp(15,4) null
    _jspx_th_form_005finput_005f1.setDynamicAttribute(null, "type", "text");
    // /WEB-INF/views/builder.jsp(15,4) null
    _jspx_th_form_005finput_005f1.setDynamicAttribute(null, "class", "form-control");
    // /WEB-INF/views/builder.jsp(15,4) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f1.setId("github[0].reponame");
    // /WEB-INF/views/builder.jsp(15,4) null
    _jspx_th_form_005finput_005f1.setDynamicAttribute(null, "name", "github[0].reponame");
    // /WEB-INF/views/builder.jsp(15,4) null
    _jspx_th_form_005finput_005f1.setDynamicAttribute(null, "placeholder", "Repository Name");
    int[] _jspx_push_body_count_form_005finput_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_form_005finput_005f1 = _jspx_th_form_005finput_005f1.doStartTag();
      if (_jspx_th_form_005finput_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005finput_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005finput_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005finput_005f1.doFinally();
      _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody.reuse(_jspx_th_form_005finput_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_form_005finput_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_005finput_005f2 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_005finput_005f2.setPageContext(_jspx_page_context);
    _jspx_th_form_005finput_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/builder.jsp(19,4) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f2.setPath("tags");
    // /WEB-INF/views/builder.jsp(19,4) null
    _jspx_th_form_005finput_005f2.setDynamicAttribute(null, "type", "text");
    // /WEB-INF/views/builder.jsp(19,4) null
    _jspx_th_form_005finput_005f2.setDynamicAttribute(null, "class", "form-control");
    // /WEB-INF/views/builder.jsp(19,4) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f2.setId("github[0].tags");
    // /WEB-INF/views/builder.jsp(19,4) null
    _jspx_th_form_005finput_005f2.setDynamicAttribute(null, "name", "github[0].tags");
    // /WEB-INF/views/builder.jsp(19,4) null
    _jspx_th_form_005finput_005f2.setDynamicAttribute(null, "placeholder", "SHA Tag");
    int[] _jspx_push_body_count_form_005finput_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_form_005finput_005f2 = _jspx_th_form_005finput_005f2.doStartTag();
      if (_jspx_th_form_005finput_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005finput_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005finput_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005finput_005f2.doFinally();
      _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody.reuse(_jspx_th_form_005finput_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_form_005finput_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_005finput_005f3 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_005finput_005f3.setPageContext(_jspx_page_context);
    _jspx_th_form_005finput_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/builder.jsp(23,4) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f3.setPath("localpath");
    // /WEB-INF/views/builder.jsp(23,4) null
    _jspx_th_form_005finput_005f3.setDynamicAttribute(null, "type", "text");
    // /WEB-INF/views/builder.jsp(23,4) null
    _jspx_th_form_005finput_005f3.setDynamicAttribute(null, "class", "form-control");
    // /WEB-INF/views/builder.jsp(23,4) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f3.setId("github[0].path");
    // /WEB-INF/views/builder.jsp(23,4) null
    _jspx_th_form_005finput_005f3.setDynamicAttribute(null, "name", "github[0].path");
    // /WEB-INF/views/builder.jsp(23,4) null
    _jspx_th_form_005finput_005f3.setDynamicAttribute(null, "placeholder", "Local Path");
    int[] _jspx_push_body_count_form_005finput_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_form_005finput_005f3 = _jspx_th_form_005finput_005f3.doStartTag();
      if (_jspx_th_form_005finput_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005finput_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005finput_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005finput_005f3.doFinally();
      _005fjspx_005ftagPool_005fform_005finput_0026_005ftype_005fplaceholder_005fpath_005fname_005fid_005fclass_005fnobody.reuse(_jspx_th_form_005finput_005f3);
    }
    return false;
  }
}
