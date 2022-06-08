package org.apache.jsp.view.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_005ft_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!-- FAVICONS ICON ============================================= -->\n");
      out.write("\t<link rel=\"icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/images/favicon.ico\" type=\"image/x-icon\" />\n");
      out.write("\t<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/images/favicon.png\" />\n");
      out.write("\t\t\n");
      out.write("\t<!-- MOBILE SPECIFIC ============================================= -->\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t<!-- All PLUGINS CSS ============================================= -->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/assets.css\">\n");
      out.write("\t\n");
      out.write("\t<!-- TYPOGRAPHY ============================================= -->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/typography.css\">\n");
      out.write("\t\n");
      out.write("\t<!-- SHORTCODES ============================================= -->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/shortcodes/shortcodes.css\">\n");
      out.write("\t\n");
      out.write("\t<!-- STYLESHEETS ============================================= -->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/style.css\">\n");
      out.write("\t<link class=\"skin\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/color/color-1.css\">\n");
      out.write("        <!-- header css -->\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <!-- JavaScripts -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/bootstrap/js/popper.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/bootstrap-select/bootstrap-select.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/magnific-popup/magnific-popup.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/counter/waypoints-min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/counter/counterup.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/imagesloaded/imagesloaded.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/masonry/masonry.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/masonry/filter.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/owl-carousel/owl.carousel.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/functions.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/contact.js\"></script>\n");
      out.write("        <script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/switcher/switcher.js'></script>\n");
      out.write("        <!-- Bootstrap 4.6.1 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("<!--         End Bootstrap 4.6.1 -->\n");
      out.write("        <script src =\"https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Header Top ==== -->\n");
      out.write("        <header class=\"header rs-nav\">\n");
      out.write("            <div class=\"top-bar\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row d-flex justify-content-between\">\n");
      out.write("                        <div class=\"topbar-left\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"faq-1.html\"><i class=\"fa fa-question-circle\"></i>Ask a Question</a></li>\n");
      out.write("                                <li><a href=\"javascript:;\"><i class=\"fa fa-envelope-o\"></i>FCourse@edu.com</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"topbar-right\">\n");
      out.write("                            <ul>\n");
      out.write("                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"sticky-header navbar-expand-lg\">\n");
      out.write("                <div class=\"menu-bar clearfix\">\n");
      out.write("                    <div class=\"container clearfix\">\n");
      out.write("                        <!-- Header Logo ==== -->\n");
      out.write("                        <div class=\"menu-logo\">\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/home\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/header/logo-main2_1.png\" alt=\"\"></a>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Mobile Nav Button ==== -->\n");
      out.write("                        <button class=\"navbar-toggler collapsed menuicon justify-content-end\" type=\"button\" data-toggle=\"collapse\" data-target=\"#menuDropdown\" aria-controls=\"menuDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                            <span></span>\n");
      out.write("                            <span></span>\n");
      out.write("                            <span></span>\n");
      out.write("                        </button>\n");
      out.write("                        <!-- Author Nav ==== -->\n");
      out.write("                        <div class=\"secondary-menu\">\n");
      out.write("                            <div class=\"secondary-inner\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#\" class=\"btn-link\"><i class=\"fa fa-facebook\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\" class=\"btn-link\"><i class=\"fa fa-google-plus\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\" class=\"btn-link\"><i class=\"fa fa-linkedin\"></i></a></li>\n");
      out.write("                                    <!-- Search Button ==== -->\n");
      out.write("                                    <li class=\"search-btn\"><button id=\"quik-search-btn\" type=\"button\" class=\"btn-link\"><i class=\"fa fa-search\"></i></button></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Search Box ==== -->\n");
      out.write("                        <div class=\"nav-search-bar\">\n");
      out.write("                            <form action=\"#\">\n");
      out.write("                                <input name=\"search\" value=\"\" type=\"text\" class=\"form-control\" placeholder=\"Type to search\">\n");
      out.write("                                <span><i class=\"ti-search\"></i></span>\n");
      out.write("                            </form>\n");
      out.write("                            <span id=\"search-remove\"><i class=\"ti-close\"></i></span>\n");
      out.write("                        </div>\n");
      out.write("<!--                         Navigation Menu ==== -->\n");
      out.write("                        <div class=\"menu-links navbar-collapse collapse justify-content-start\" id=\"menuDropdown\">\n");
      out.write("                            <div class=\"menu-logo\">\n");
      out.write("                                <a href=\"#\"><img src=\"assets/images/logo.png\" alt=\"\"></a>\n");
      out.write("                            </div>\n");
      out.write("                            <ul class=\"nav navbar-nav\">\t\n");
      out.write("                                <li class=\"active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/home\">Home</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/course/list\">Our Course</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/blog/list\">Blogs</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/home\">About us</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"javascript:;\">Contact <i class=\"fa fa-chevron-down\"></i></a>\n");
      out.write("                                    <ul class=\"sub-menu\">\n");
      out.write("                                        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/contact\">Contact Link</a></li>\n");
      out.write("                                        <li><a href=\"#\">Help</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <div class=\"nav-social-link\">\n");
      out.write("                                <a href=\"javascript:;\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                                <a href=\"javascript:;\"><i class=\"fa fa-google-plus\"></i></a>\n");
      out.write("                                <a href=\"javascript:;\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Navigation Menu END ==== -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--login-->\n");
      out.write("            <div class=\"modal fade\" id=\"myModal-login\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <h5 class=\"modal-title\" id=\"exampleModalLabel\">LOGIN</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form id =\"validate-form-login\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login\" method=\"post\">\n");
      out.write("                                <div class=\"alert-danger\" role=\"alert\">\n");
      out.write("                                    <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                </div>\n");
      out.write("                                <span id=\"errorlogin\"></span>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"form__input-group\">\n");
      out.write("                                    <label for=\"username\">Email: </label>\n");
      out.write("                                    <input type=\"text\" class=\"form__input\" name=\"email\" id=\"email\" > \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form__input-group\">\n");
      out.write("                                    <label for=\"pass\">Password: </label>\n");
      out.write("                                    <input type=\"password\" class=\"form__input\" name=\"password\" id=\"password\" > \n");
      out.write("                                </div>\n");
      out.write("                                <p><input type=\"checkbox\" value=\"remember\" name=\"remember\"/> Remember Me! </p>\n");
      out.write("                                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/reset/lostpassword\">Forgot password?</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                                <div class = \"edit-profile-submit\" style = \"display: flex; justify-content: center\">\n");
      out.write("                                    <button class=\"btn btn-success\" style=\"margin: auto;\" type=\"submit\">Login</button>\n");
      out.write("                                </div>                            \n");
      out.write("\n");
      out.write("                                <div class=\"modal-footer d-block\">\n");
      out.write("                                    <a href=\"#\" data-target=\"#myModal-signup\" data-toggle=\"modal\" class=\"text-info\" type=\"button\">Do you have an account?Create Account</a>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("             <!--        Modal-->\n");
      out.write("             <div class=\"modal fade\" id=\"myModal-signup\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                 <div class=\"modal-dialog modal-xl\">\n");
      out.write("                     <div class=\"modal-content\">\n");
      out.write("                         <div class=\"modal-header\">\n");
      out.write("                             <h5 class=\"modal-title\" id=\"exampleModalLabel\">SIGN UP</h5>\n");
      out.write("                         </div>\n");
      out.write("                         <div class=\"modal-body\">\n");
      out.write("                             <form id =\"validate-form-sign-up\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/user/register\" method=\"POST\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("                                 <input id=\"email\" type=\"email\" placeholder=\"Email\" name=\"email\" />\n");
      out.write("                                 <input id=\"fullname\" type=\"text\" placeholder=\"User\" name=\"fullname\" />\n");
      out.write("                                 <input id=\"password\" type=\"password\" placeholder=\"Password\" name=\"password\"/>\n");
      out.write("                                 <input id=\"phone\" type=\"tel\" placeholder=\"Phone\" name=\"phone\" />\n");
      out.write("                                 <br/>\n");
      out.write("                                 <div style=\"display: flex;\">                     \n");
      out.write("                                     <input  style=\"width: 15px; margin-left: 20px; \" type=\"radio\" name=\"gender\" value=\"male\"/> Male   <br/>                            \n");
      out.write("                                     <input   style=\"width: 15px; margin-left: 50px; \" type=\"radio\" name=\"gender\" value=\"female\"/> Female <br/>\n");
      out.write("                                 </div>\n");
      out.write("                                 <div class = \"edit-profile-submit\" style =\"display: flex; justify-content: center\">\n");
      out.write("                                     <button class=\"btn btn-success\" type=\"submit\">SIGN UP</button>\n");
      out.write("                                 </div>\n");
      out.write("\n");
      out.write("                             </form>\n");
      out.write("                         </div>\n");
      out.write("                     </div>\n");
      out.write("                 </div>\n");
      out.write("             </div>\n");
      out.write("            <script>\n");
      out.write("            var hidden = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.alerterror}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\n");
      out.write("            if (hidden <= 1) {\n");
      out.write("            $('#myModal-login').modal('show');\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            validate_form_login();\n");
      out.write("            validate_form_sign_up();\n");
      out.write("            </script>        \n");
      out.write("        </header>\n");
      out.write("        <!-- header END ==== -->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/myregistration\">My Registration<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/images/header/shopping-cart.png\" style=\"margin-bottom: 6px; margin-left: 2px;\" width=\"20px\" height=\"20px\" alt=\"\"/></a></li>\n");
        out.write("                                    <li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/mycourse\">My Course<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/images/header/online-course.png\" style=\"margin-bottom: 6px; margin-left: 2px;\" width=\"20px\" height=\"20px\" alt=\"\"/></a></li>\n");
        out.write("                                    <li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/user/profile\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/images/header/icons8-user.png\" style=\"margin-bottom: 8px;\" width=\"20px\" height=\"20px\" alt=\"\"/></a></li>\n");
        out.write("                                    <li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/logout\">Logout<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/images/header/icons8-logout-16.png\" width=\"20px\" style=\"margin-bottom: 6px;\" height=\"20px\" alt=\"\"/></a></li>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/images/header/user.png\" width=\"20px\" height=\"20px\" style=\"margin-top: 10px; margin-right: 5px\" alt=\"\" />\n");
        out.write("                                    <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal-login\">\n");
        out.write("                                        Login\n");
        out.write("                                    </button>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
