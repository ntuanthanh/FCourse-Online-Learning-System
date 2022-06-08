/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import utility.SendEmail;

/**
 *
 * @author ADMIN
 */
public class UserRegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String raw_email = request.getParameter("email");
        String raw_name = request.getParameter("fullname");
        String raw_phone = request.getParameter("phone");
        String raw_gender = request.getParameter("gender");
        String password = request.getParameter("password");

        String phone = raw_phone;
        boolean gender = raw_gender.equals("male");

        User s = new User();

        s.setEmail(raw_email);
        s.setFullName(raw_name);
        s.setPhone(phone);
        s.setPassword(password);
        s.setGender(gender);
        s.setAvatarImage("non-avatar.png");
        UserDBContext db = new UserDBContext();
        int userid = db.insertUser(s);

        String link = "";
        if (userid != 0) {
            link = "http://localhost:8080" + request.getContextPath() + "/user/verify?id=" + userid;
            SendEmail y = new SendEmail();
            y.send(raw_email, content(link), "Action Required: Confirm your email.");
            response.sendRedirect("../view/user/signup_success.jsp");
        } else {
            request.setAttribute("mess", "Đăng ký không thành công. Email đã tồn tại.");  
            request.setAttribute("alerterror",1 );
            request.getRequestDispatcher("../login").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    String content(String a) {
        String ct = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>WELCOME</title>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
                + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0 \" />\n"
                + "        <meta name=\"format-detection\" content=\"telephone=no\" />\n"
                + "        <!--[if !mso]><!-->\n"
                + "        <!--<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700\" rel=\"stylesheet\" />-->\n"
                + "        <!--<![endif]-->\n"
                + "        <style type=\"text/css\">\n"
                + "            body {\n"
                + "                -webkit-text-size-adjust: 100% !important;\n"
                + "                -ms-text-size-adjust: 100% !important;\n"
                + "                -webkit-font-smoothing: antialiased !important;\n"
                + "            }\n"
                + "            img {\n"
                + "                border: 0 !important;\n"
                + "                outline: none !important;\n"
                + "            }\n"
                + "            p {\n"
                + "                Margin: 0px !important;\n"
                + "                Padding: 0px !important;\n"
                + "            }\n"
                + "            table {\n"
                + "                border-collapse: collapse;\n"
                + "                mso-table-lspace: 0px;\n"
                + "                mso-table-rspace: 0px;\n"
                + "            }\n"
                + "            td, a, span {\n"
                + "                border-collapse: collapse;\n"
                + "                mso-line-height-rule: exactly;\n"
                + "            }\n"
                + "            .ExternalClass * {\n"
                + "                line-height: 100%;\n"
                + "            }\n"
                + "            span.MsoHyperlink {\n"
                + "                mso-style-priority:99;\n"
                + "                color:inherit;}\n"
                + "            span.MsoHyperlinkFollowed {\n"
                + "                mso-style-priority:99;\n"
                + "                color:inherit;}\n"
                + "            </style>\n"
                + "            <style media=\"only screen and (min-width:481px) and (max-width:599px)\" type=\"text/css\">\n"
                + "            @media only screen and (min-width:481px) and (max-width:599px) {\n"
                + "                table[class=em_main_table] {\n"
                + "                    width: 100% !important;\n"
                + "                }\n"
                + "                table[class=em_wrapper] {\n"
                + "                    width: 100% !important;\n"
                + "                }\n"
                + "                td[class=em_hide], br[class=em_hide] {\n"
                + "                    display: none !important;\n"
                + "                }\n"
                + "                img[class=em_full_img] {\n"
                + "                    width: 100% !important;\n"
                + "                    height: auto !important;\n"
                + "                }\n"
                + "                td[class=em_align_cent] {\n"
                + "                    text-align: center !important;\n"
                + "                }\n"
                + "                td[class=em_aside]{\n"
                + "                    padding-left:10px !important;\n"
                + "                    padding-right:10px !important;\n"
                + "                }\n"
                + "                td[class=em_height]{\n"
                + "                    height: 20px !important;\n"
                + "                }\n"
                + "                td[class=em_font]{\n"
                + "                    font-size:14px !important;	\n"
                + "                }\n"
                + "                td[class=em_align_cent1] {\n"
                + "                    text-align: center !important;\n"
                + "                    padding-bottom: 10px !important;\n"
                + "                }\n"
                + "            }\n"
                + "        </style>\n"
                + "        <style media=\"only screen and (max-width:480px)\" type=\"text/css\">\n"
                + "            @media only screen and (max-width:480px) {\n"
                + "                table[class=em_main_table] {\n"
                + "                    width: 100% !important;\n"
                + "                }\n"
                + "                table[class=em_wrapper] {\n"
                + "                    width: 100% !important;\n"
                + "                }\n"
                + "                td[class=em_hide], br[class=em_hide], span[class=em_hide] {\n"
                + "                    display: none !important;\n"
                + "                }\n"
                + "                img[class=em_full_img] {\n"
                + "                    width: 100% !important;\n"
                + "                    height: auto !important;\n"
                + "                }\n"
                + "                td[class=em_align_cent] {\n"
                + "                    text-align: center !important;\n"
                + "                }\n"
                + "                td[class=em_align_cent1] {\n"
                + "                    text-align: center !important;\n"
                + "                    padding-bottom: 10px !important;\n"
                + "                }\n"
                + "                td[class=em_height]{\n"
                + "                    height: 20px !important;\n"
                + "                }\n"
                + "                td[class=em_aside]{\n"
                + "                    padding-left:10px !important;\n"
                + "                    padding-right:10px !important;\n"
                + "                } \n"
                + "                td[class=em_font]{\n"
                + "                    font-size:14px !important;\n"
                + "                    line-height:28px !important;\n"
                + "                }\n"
                + "                span[class=em_br]{\n"
                + "                    display:block !important;\n"
                + "                }\n"
                + "            }\n"
                + "        </style>\n"
                + "    </head>\n"
                + "    <body style=\"margin:0px; padding:0px;\" bgcolor=\"#ffffff\">\n"
                + "        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\">\n"
                + "            <!-- === PRE HEADER SECTION=== -->  \n"
                + "           \n"
                + "            <!-- === //PRE HEADER SECTION=== -->  \n"
                + "            <!-- === BODY SECTION=== --> \n"
                + "            <tr>\n"
                + "                <td align=\"center\" valign=\"top\"  bgcolor=\"#ffffff\">\n"
                + "                    <table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" class=\"em_main_table\" style=\"table-layout:fixed;\">\n"
                + "                        <!-- === LOGO SECTION === -->\n"
                + "                        <tr>\n"
                + "                            <td height=\"40\" class=\"em_height\">&nbsp;</td>\n"
                + "                        </tr>\n"
                + "                       \n"
                + "                        <tr>\n"
                + "                            <td height=\"30\" class=\"em_height\">&nbsp;</td>\n"
                + "                        </tr>\n"
                + "                        <!-- === //LOGO SECTION === -->\n"
                + "                        <!-- === NEVIGATION SECTION === -->\n"
                + "                        <tr>\n"
                + "                            <td height=\"1\" bgcolor=\"#fed69c\" style=\"font-size:0px; line-height:0px;\"><img src=\"https://www.sendwithus.com/assets/img/emailmonks/images/spacer.gif\" width=\"1\" height=\"1\" style=\"display:block;\" border=\"0\" alt=\"\" /></td>\n"
                + "                        </tr>\n"
                + "                        <tr>\n"
                + "                            <td height=\"14\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n"
                + "                        </tr>\n"
                + "                       \n"
                + "                        <tr>\n"
                + "                            <td height=\"14\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n"
                + "                        </tr>\n"
                + "                        <tr>\n"
                + "                            <td height=\"1\" bgcolor=\"#fed69c\" style=\"font-size:0px; line-height:0px;\"><img src=\"https://www.sendwithus.com/assets/img/emailmonks/images/spacer.gif\" width=\"1\" height=\"1\" style=\"display:block;\" border=\"0\" alt=\"\" /></td>\n"
                + "                        </tr>\n"
                + "                        <!-- === //NEVIGATION SECTION === -->\n"
                + "                        <!-- === IMG WITH TEXT AND COUPEN CODE SECTION === -->\n"
                + "                        <tr>\n"
                + "                            <td valign=\"top\" class=\"em_aside\">\n"
                + "                                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                + "                                    <tr>\n"
                + "                                        <td height=\"36\" class=\"em_height\">&nbsp;</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td valign=\"middle\" align=\"center\"><img src=\"https://www.sendwithus.com/assets/img/emailmonks/images/banner.jpg\" width=\"333\" height=\"303\" alt=\"WELCOME\" style=\"display:block; font-family:Arial, sans-serif; font-size:25px; line-height:303px; color:#c27cbb;max-width:333px;\" class=\"em_full_img\" border=\"0\" /></td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td height=\"41\" class=\"em_height\">&nbsp;</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td height=\"1\" bgcolor=\"#d8e4f0\" style=\"font-size:0px;line-height:0px;\"><img src=\"https://www.sendwithus.com/assets/img/emailmonks/images/spacer.gif\" width=\"1\" height=\"1\" alt=\"\" style=\"display:block;\" border=\"0\" /></td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td height=\"35\" class=\"em_height\">&nbsp;</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:15px; font-weight:bold; line-height:18px; color:#30373b;\">Welcome &lt; to F-Course&gt;</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td height=\"22\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:18px; font-weight:bold; line-height:20px; color:#feae39;\">We created an account for you. Please confirm your email address and get ready to start learning!</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td height=\"20\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:18px; line-height:20px; color:#feae39;\">Verify Email</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td height=\"12\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td valign=\"top\" align=\"center\">\n"
                + "                                            <table width=\"210\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
                + "                                                <tr>\n"
                + "                                                    <td valign=\"middle\" align=\"center\" height=\"45\" bgcolor=\"#feae39\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:17px; font-weight:bold; color:#ffffff; text-transform:uppercase;\">\n"
                + "                                                        <a href=\""+a+"\" >CONFIRM MAIL </a>\n"
                + "                                                    </td>\n"
                + "                                                </tr>\n"
                + "                                            </table>\n"
                + "                                        </td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td height=\"34\" class=\"em_height\">&nbsp;</td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:15px; line-height:22px; color:#999999;\">\n"
                + "                                            Introduction of F-Course <br class=\"em_hide\"/>\n"
                + "                                            Introduction of F-Course Introduction of F-Course Introduction of F-Course<br class=\"em_hide\" />\n"
                + "                                            Introduction of F-Course<br class=\"em_hide\" />\n"
                + "                                            Thank you.\n"
                + "                                        </td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td height=\"31\" class=\"em_height\">&nbsp;</td>\n"
                + "                                    </tr>\n"
                + "                                </table>\n"
                + "                            </td>\n"
                + "                        </tr>\n"
                + "                        <!-- === //IMG WITH TEXT AND COUPEN CODE SECTION === -->\n"
                + "                    </table>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            <!-- === //BODY SECTION=== -->\n"
                + "            <!-- === FOOTER SECTION === -->\n"
                + "           \n"
                + "            <!-- === //FOOTER SECTION === -->\n"
                + "        </table>\n"
                + "        <div style=\"display:none; white-space:nowrap; font:20px courier; color:#ffffff; background-color:#ffffff;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</div>\n"
                + "    </body>\n"
                + "</html>\n"
                + "";
        return ct;

    }
}
