package org.apache.jsp.view.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _404page_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!-- W3hubs.com - Download Free Responsive Website Layout Templates designed on HTML5 CSS3,Bootstrap which are 100% Mobile friendly. w3Hubs all Layouts are responsive cross browser supported, best quality world class designs. -->\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>404 Error Page In Bootstrap 4</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            @import url('https://fonts.googleapis.com/css?family=Sniglet:400,800');\n");
      out.write("            body{\n");
      out.write("                background: #95A5A6;\n");
      out.write("                font-family: 'Sniglet', cursive;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            h1{\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 190px;\n");
      out.write("                font-weight: 400;\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("            .fa{\n");
      out.write("                font-size: 120px;\n");
      out.write("                text-align: center;\n");
      out.write("                display: block;\n");
      out.write("                padding-top: 100px;\n");
      out.write("                margin: 0 auto;\n");
      out.write("                color: #A93226;\n");
      out.write("            }\n");
      out.write("            #error p{\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 36px;\n");
      out.write("                color: #4A235A;\n");
      out.write("            }\n");
      out.write("            a.back{\n");
      out.write("                text-align: center;\n");
      out.write("                margin: 0 auto;\n");
      out.write("                display: block;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 24px;\n");
      out.write("                background: #BA4A00;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                width: 10%;\n");
      out.write("                padding: 4px;\n");
      out.write("                color: #fff; \n");
      out.write("\n");
      out.write("            }\n");
      out.write("            @media(max-width: 550px){\n");
      out.write("                a.back{\n");
      out.write("                    width: 20%;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            @media(max-width: 425px){\n");
      out.write("                h1{\n");
      out.write("                    padding-top: 20px;\n");
      out.write("                }\n");
      out.write("                .fa{\n");
      out.write("                    padding-top: 100px;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section id=\"error\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <i class=\"fa fa-warning\"></i>\n");
      out.write("                <h1>404</h1>\n");
      out.write("                <p>Error occurred! - File not Found</p>\n");
      out.write("                <a class=\"back\" href=\"#\">Back</a>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
