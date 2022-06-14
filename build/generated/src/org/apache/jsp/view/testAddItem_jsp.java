package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testAddItem_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form>\n");
      out.write("            <input type = \"text\" name = \"text\" id = \"txt\"> <br>\n");
      out.write("            <button type=\"submit\" class = \"btn-list\">X</button>\n");
      out.write("        </form>\n");
      out.write("        <div class =\"container\">\n");
      out.write("            <ul>\n");
      out.write("                <li>Dev at <span>x</span></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            const inputText = document.querySelector('#txt');\n");
      out.write("            const myButton = document.querySelector('.btn-list');\n");
      out.write("            const list = document.querySelector('.container ul');\n");
      out.write("            myButton.addEventListener('click', (e)=>{\n");
      out.write("              if(inputText.value != \"\"){\n");
      out.write("                e.preventDefault();\n");
      out.write("                const myLi = document.createElement('li');\n");
      out.write("                myLi.innerHTML = inputText.value;\n");
      out.write("                list.appendChild(myLi);\n");
      out.write("                const mySpan = document.createElement('span');\n");
      out.write("                mySpan.innerHTML = 'x';\n");
      out.write("                myLi.appendChild(mySpan);\n");
      out.write("\n");
      out.write("              }\n");
      out.write("            var close = document.querySelectorAll('span');\n");
      out.write("                    var num = close.length;\n");
      out.write("                    for (let i in close) {\n");
      out.write("                        close[i].addEventListener('click', () => {\n");
      out.write("                            close[i].parentElement.style.opacity = 0;\n");
      out.write("                            setTimeout(() => {\n");
      out.write("                                close[i].parentElement.style.display = \"none\";\n");
      out.write("                            }, 500);\n");
      out.write("                        });\n");
      out.write("                        inputText.value = \"\";\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                });\n");
      out.write("        </script>\n");
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
