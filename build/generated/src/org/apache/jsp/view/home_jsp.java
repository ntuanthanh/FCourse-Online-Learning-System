package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Course;
import java.util.ArrayList;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Home|Edu-FCourse</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/blog.css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/tagline.css\"/>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <!-- FAVICONS ICON ============================================= -->\r\n");
      out.write("        <link rel=\"icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/images/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/images/favicon.png\" />\r\n");
      out.write("\r\n");
      out.write("        <!-- MOBILE SPECIFIC ============================================= -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <!-- All PLUGINS CSS ============================================= -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/assets.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- TYPOGRAPHY ============================================= -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/typography.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- SHORTCODES ============================================= -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/shortcodes/shortcodes.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- STYLESHEETS ============================================= -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/style.css\">\r\n");
      out.write("        <link class=\"skin\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/color/color-1.css\">\r\n");
      out.write("        <!-- header css -->\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/header.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <!-- JavaScripts -->\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/bootstrap/js/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/bootstrap-select/bootstrap-select.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/magnific-popup/magnific-popup.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/counter/waypoints-min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/counter/counterup.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/imagesloaded/imagesloaded.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/masonry/masonry.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/masonry/filter.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/owl-carousel/owl.carousel.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/functions.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/contact.js\"></script>\r\n");
      out.write("        <script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/vendors/switcher/switcher.js'></script>\r\n");
      out.write("        <!-- Bootstrap 4.6.1 -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("        <!--         End Bootstrap 4.6.1 -->\r\n");
      out.write("        <script src =\"https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/home.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href=\"css/slider.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <noscript>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/nojs.css\" />\r\n");
      out.write("        </noscript>\r\n");
      out.write("        <!--        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\r\n");
      out.write("                <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Oswald:700|Montserrat:700'>-->\r\n");
      out.write("        ");

            ArrayList<Course> coursesSlider = (ArrayList<Course>) request.getAttribute("coursesSlider");
        
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("            .da-img img{\r\n");
      out.write("                height: 256px;\r\n");
      out.write("                width: 256px;\r\n");
      out.write("                object-fit: cover;\r\n");
      out.write("            }\r\n");
      out.write("            .action-box img{\r\n");
      out.write("\r\n");
      out.write("                height: 150px;\r\n");
      out.write("                object-fit:cover;\r\n");
      out.write("            }\r\n");
      out.write("            .title-course{\r\n");
      out.write("                height: 60px;\r\n");
      out.write("            }\r\n");
      out.write("            .text-center{\r\n");
      out.write("                text-align: left;\r\n");
      out.write("                font-weight: 500;\r\n");
      out.write("                height: 100px;\r\n");
      out.write("                font-size: 110%;\r\n");
      out.write("\r\n");
      out.write("                padding: 0px 5px;\r\n");
      out.write("                display: -webkit-box;\r\n");
      out.write("                -webkit-line-clamp: 2;\r\n");
      out.write("                -webkit-box-orient: vertical;\r\n");
      out.write("                overflow: hidden;\r\n");
      out.write("            }\r\n");
      out.write("            .recent-post img{\r\n");
      out.write("                width: 100px;\r\n");
      out.write("                height: 100px;\r\n");
      out.write("                object-fit:cover;\r\n");
      out.write("            }\r\n");
      out.write("            .register:hover {\r\n");
      out.write("                color:white;\r\n");
      out.write("                background-color: purple: \r\n");
      out.write("            }\r\n");
      out.write("            .register{\r\n");
      out.write("                color:white;\r\n");
      out.write("                background-color: orange; \r\n");
      out.write("            }\r\n");
      out.write("            .card-feature{\r\n");
      out.write("                height: 50px;\r\n");
      out.write("            }\r\n");
      out.write("            .card-price > del{\r\n");
      out.write("                display: inline-block;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body id=\"bg\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../view/base/header_t.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- SLIDER-->\r\n");
      out.write("        <div id=\"da-slider\" class=\"da-slider\">\r\n");
      out.write("            <div class=\"da-slide\">\r\n");
      out.write("                <h2>AI Blogs</h2>\r\n");
      out.write("                <p>Artificial intelligence (AI) is a wide-ranging branch of computer science concerned with building smart machines capable of performing tasks that typically require human intelligence. See AI blogs now</p>\r\n");
      out.write("                <a href=\"#\" class=\"da-link\">Read More</a>\r\n");
      out.write("                <div class=\"da-img\"><img src=\"images/slider/1.png\" alt=\"image01\" /></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"da-slide\">\r\n");
      out.write("                <h2>How to save money</h2>\r\n");
      out.write("                <p>Sometimes the hardest thing about saving money is just getting started. This step-by-step guide can help you develop a simple and realistic strategy, so that you can save for all your short- and long-term goals.</p>\r\n");
      out.write("                <a href=\"#\" class=\"da-link\">Read more</a>\r\n");
      out.write("                <div class=\"da-img\"><img src=\"images/slider/3.png\" alt=\"image01\"  /></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"da-slide\">\r\n");
      out.write("                <h2>How to learn Math fast</h2>\r\n");
      out.write("                <p>Many people struggle with math. It tends to be one of the most common subjects that people have trouble with. But with the right training, practice and effort, it can become easier. For those who want to learn how to be good at math, it may require extra practice. Here are a few best practices to learn math fast.</p>\r\n");
      out.write("                <a href=\"#\" class=\"da-link\">Read more</a>\r\n");
      out.write("                <div class=\"da-img\"><img src=\"images/slider/2.png\" alt=\"image01\" /></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"da-slide\">\r\n");
      out.write("                <h2>What is the internet of things?</h2>\r\n");
      out.write("                <p>The internet of things, or IoT, is a system of interrelated computing devices, mechanical and digital machines, objects, animals or people that are provided with unique identifiers (UIDs) and the ability to transfer data over a network without requiring human-to-human or human-to-computer interaction.</p>\r\n");
      out.write("                <a href=\"#\" class=\"da-link\">Read more</a>\r\n");
      out.write("                <div class=\"da-img\"><img src=\"images/slider/4.png\" alt=\"image01\" /></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <nav class=\"da-arrows\">\r\n");
      out.write("                <span class=\"da-arrows-prev\"></span>\r\n");
      out.write("                <span class=\"da-arrows-next\"></span>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- SLIDER END-->\r\n");
      out.write("        <div class=\"content-block\">\r\n");
      out.write("            <!-- About Us -->\r\n");
      out.write("            <div class=\"section-area section-sp1\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-3 col-md-4 col-sm-12 m-b30\">\r\n");
      out.write("                            <h4>LATEST POST</h4>\r\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-9 col-md-8 col-sm-12\">\r\n");
      out.write("                            <h4 class=\"title-home\">Featured Courses</h4>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <h4 class=\"title-home\">Hot Posts</h4>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>                   \r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- contact area END -->    \r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- footer side --> \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base/footer_t.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--    <script src=\"../js/slider.js\" type=\"text/javascript\"></script>-->\r\n");
      out.write("<div class=\"page-wraper\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Header Top ==== -->\r\n");
      out.write("\r\n");
      out.write("    <!-- header END ==== -->\r\n");
      out.write("    <!-- Content -->\r\n");
      out.write("\r\n");
      out.write("    <!-- inner page banner -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Content END-->\r\n");
      out.write("\r\n");
      out.write("<!-- scroll top button -->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- External JavaScripts -->\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/bootstrap/js/popper.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/bootstrap-select/bootstrap-select.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/magnific-popup/magnific-popup.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/counter/waypoints-min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/counter/counterup.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/imagesloaded/imagesloaded.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/masonry/masonry.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/masonry/filter.js\"></script>\r\n");
      out.write("<script src=\"assets/vendors/owl-carousel/owl.carousel.js\"></script>\r\n");
      out.write("<script src=\"assets/js/functions.js\"></script>\r\n");
      out.write("<script src=\"assets/js/contact.js\"></script>\r\n");
      out.write("<script src='assets/vendors/switcher/switcher.js'></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.cslider.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(function () {\r\n");
      out.write("\r\n");
      out.write("        $('#da-slider').cslider({\r\n");
      out.write("            autoplay: true,\r\n");
      out.write("            bgincrement: 450\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/modernizr.custom.28468.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.blognews}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("b");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                <div class=\"recent-post\">\r\n");
          out.write("                                    <img src=\"images/blogdetail/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.thumbnail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\"/>\r\n");
          out.write("                                    <div>\r\n");
          out.write("                                        <h5>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h5>\r\n");
          out.write("                                        <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.brief}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                </div>\r\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.courses}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("course");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                    <div class=\"col-md-6 col-lg-4 col-sm-6 m-b30\">\r\n");
          out.write("                                        <div class=\"cours-bx\">\r\n");
          out.write("                                            <div class=\"action-box\">\r\n");
          out.write("                                                <img  src=\"images/courses/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.thumnailURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\r\n");
          out.write("                                                <a href=\"#\" class=\"btn register\">resgister</a>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                            <div class=\"info-bx text-center\">\r\n");
          out.write("                                                <div class=\"title-course\"> <h5><a href=\"../coursedetail?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.courseId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h5></div>\r\n");
          out.write("                                                <span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.category.value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\r\n");
          out.write("\r\n");
          out.write("                                                <!--                                                <ul class=\"tag\">\r\n");
          out.write("                                                ");
          if (_jspx_meth_c_forEach_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("                                            </ul>-->\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                            <div class=\"cours-more-info card-feature\">\r\n");
          out.write("                                                <div class=\"review\">\r\n");
          out.write("                                                    <span>Feature</span>\r\n");
          out.write("\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div class=\"card-price\">\r\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("  \r\n");
          out.write("                                                </div>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                        </div>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.getTags()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("tag");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\r\n");
          out.write("                                                     <li class=\"tag-item\"  style=\"margin-bottom: 20px\"><a href=\"list?tagId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tag.tagId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tag.getTagname()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\r\n");
          out.write("                                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.pricePackage.size()>0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <del>$");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.pricePackage[0].listPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</del>\r\n");
        out.write("\r\n");
        out.write("                                                        <h5>$");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.pricePackage[0].salePrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</h5>\r\n");
        out.write("                                                    ");
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

  private boolean _jspx_meth_c_forEach_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent(null);
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.blogs}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_3.setVar("b");
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                    <div class=\"col-md-6 col-lg-4 col-sm-6 m-b30\">\r\n");
          out.write("                                        <div class=\"cours-bx\">\r\n");
          out.write("                                            <div class=\"action-box\">\r\n");
          out.write("                                                <img src=\"images/blogdetail/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.thumbnail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\"/>\r\n");
          out.write("                                                <a  href=\"blog/detail?bid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"btn register\">See Now</a>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                            <div class=\"info-bx text-center\">\r\n");
          out.write("                                                <div class=\"title-course\"> <h5><a href=\"../coursedetail?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.courseId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h5></div>\r\n");
          out.write("\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                            <div class=\"cours-more-info\">\r\n");
          out.write("                                                <div class=\"info-blog\">\r\n");
          out.write("                                                    <p><i class=\"fa fa-calendar\"></i> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.createdate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" | <i class=\"fa fa-user\"></i>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.user.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <!--                                                    <div class=\"review\">\r\n");
          out.write("                                                                                        </div>-->\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                        </div>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }
}
