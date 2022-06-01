package org.apache.jsp.view.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class send_005freset_005fpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src =\"https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color: #9999FF;\n");
      out.write("            }\n");
      out.write("            .content-send-reset-password{\n");
      out.write("                margin-left: 20%; \n");
      out.write("                margin-right: 20%; \n");
      out.write("                margin-top: 100px;\n");
      out.write("                background-color: #FFFFFF;\n");
      out.write("                border: 2px solid white;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow: 0 0 10px 5px #D6D8DB;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .content-send-reset-password img{\n");
      out.write("                margin-top: 30px;\n");
      out.write("                margin-bottom: 6px;\n");
      out.write("                width: 100px; \n");
      out.write("                height: 100px;\n");
      out.write("            }\n");
      out.write("            .form-send-reset-password-item{\n");
      out.write("                margin-left: 30%;\n");
      out.write("                margin-right: 30%;\n");
      out.write("            }\n");
      out.write("            .send-reset-password-profile-submit{ \n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("            @media (max-width: 900px){\n");
      out.write("                .form-send-reset-password-item{\n");
      out.write("                    margin-left: 0;\n");
      out.write("                    margin-right: 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class = \"content-send-reset-password\">\n");
      out.write("            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/reset/padlock.png\"/>\n");
      out.write("            <h2>Reset Password?</h2>\n");
      out.write("            <p>You can reset your password here.</p>\n");
      out.write("            <form>\n");
      out.write("                <div class = \"form-send-reset-password\">\n");
      out.write("                    <div class = \"form-group form-send-reset-password-item\">\n");
      out.write("                        <input type=\"text\" id = \"email\" class=\"form-control\" name =\"email\" placeholder=\"Enter your email\" value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class = \"send-reset-password-profile-submit\">\n");
      out.write("                    <button class=\"btn btn-primary\" type=\"submit\">Send</button>\n");
      out.write("                </div>    \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
