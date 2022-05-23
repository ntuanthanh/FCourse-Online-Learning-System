package org.apache.jsp.view.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <link href=\"/OnlineLearning/css/header.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"header-frist\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-7\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-3\">\n");
      out.write("                                    <img src=\"/OnlineLearning/images/header/logo-main.png\" width=\"50px\" height=\"50px\" alt=\"\" />\n");
      out.write("                                    <span class=\"name-banner\">Edu-FCourse</span>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-9\">\n");
      out.write("                                    <ul class=\"nav\">\n");
      out.write("                                        <li class=\"nav-item\">\n");
      out.write("                                            <a class=\"nav-link\" href=\"#\">Ask a Question<img src=\"/OnlineLearning/images/header/ask.png\" style=\"margin-bottom: 6px; margin-left: 2px;\" width=\"20px\" height=\"20px\" alt=\"\"/></a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"nav-item\">\n");
      out.write("                                            <a class=\"nav-link\" href=\"#\">Course@gmail.com<img src=\"/OnlineLearning/images/header/email.png\" style=\"margin-bottom: 6px; margin-left: 2px;\" width=\"20px\" height=\"20px\" alt=\"\"/></a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-5\">\n");
      out.write("                            <!--  Da login -->\n");
      out.write("                            <!--                        <ul class=\"nav\">\n");
      out.write("                                                       <li class=\"nav-item\"> \n");
      out.write("                                                        <a class=\"nav-link\" href=\"#\">My Course<img src=\"/OnlineLearning/images/header/online-course.png\" style=\"margin-bottom: 6px; margin-left: 2px;\" width=\"20px\" height=\"20px\" alt=\"\"/></a>\n");
      out.write("                                                       </li>       \n");
      out.write("                                                        <li class=\"nav-item\">\n");
      out.write("                                                            <a class=\"nav-link\" href=\"#\">Nguyen Tuan Thanh<img src=\"/OnlineLearning/images/header/icons8-user.png\" style=\"margin-bottom: 8px;\" width=\"20px\" height=\"20px\" alt=\"\"/></a> \n");
      out.write("                                                        </li>   \n");
      out.write("                                                        <li class=\"nav-item\">\n");
      out.write("                                                            <a class=\"nav-link\" href=\"logout\">Logout<img src=\"/OnlineLearning/images/header/icons8-logout-16.png\" width=\"20px\" style=\"margin-bottom: 6px;\" height=\"20px\" alt=\"\"/></a>\n");
      out.write("                                                        </li>\n");
      out.write("                                                    </ul>-->\n");
      out.write("                            <!-- Chua login-->\n");
      out.write("                            <div style=\"display: flex; justify-content: flex-end\">\n");
      out.write("                                <img src=\"/OnlineLearning/images/header/user.png\" width=\"20px\" height=\"20px\" style=\"margin-top: 10px; margin-right: 5px\" alt=\"\" />\n");
      out.write("                                <a class=\" btn btn-primary\" href=\"/OnlineLearning/login\">Login</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row header-second\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <nav class=\"navbar navbar-expand-lg navbar-light\">\n");
      out.write("                            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\n");
      out.write("                                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                            </button>\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\n");
      out.write("                                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"/OnlineLearning/home\">Home</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"#\">Our Courses</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"#\">Blogs</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"#\">About Us</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"#\">References</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"/OnlineLearning/admin/dashboard\">Admin site(link tam)</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <form class=\"form-inline\">\n");
      out.write("                                    <input class=\"form-control mr-sm-2\" placeholder=\"Search Courses\">\n");
      out.write("                                    <button class=\"btn btn-warning\" type=\"submit\">Search</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>     \n");
      out.write("        </header>\n");
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
}
