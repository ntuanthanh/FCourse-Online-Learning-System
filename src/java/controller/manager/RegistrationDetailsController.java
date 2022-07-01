/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.CourseDBContext;
import dal.PricePackageDBContext;
import dal.UserCourseDBContext;
import dal.UserDBContext;
import dal.UserRoleDBContext;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.PricePackage;
import model.Status;
import model.User;
import model.UserCourse;
import utility.SendEmail;

/**
 *
 * @author thand
 */
public class RegistrationDetailsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ucid = request.getParameter("ucid");
        LocalDate a = java.time.LocalDate.now();
//        ucid = "1";
        if (ucid != null && ucid.trim().length() > 0) {
            UserCourseDBContext ucdbc = new UserCourseDBContext();
            UserCourse uc = ucdbc.geUCourses(Integer.parseInt(ucid));

            UserDBContext udbc = new UserDBContext();
            User create = uc.getCreateBy();

            String p = request.getParameter("pid");
            int pid = 1;
            if (p != null && p.trim().length() > 0) {
                pid = Integer.parseInt(p);
            }
            // get pid
            PricePackageDBContext pdb = new PricePackageDBContext();
            PricePackage pr = pdb.getPackage(pid);
            request.setAttribute("pr", pr);
            Date startdate = uc.getStartDate();
            Date endate = uc.getEndDate();
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
            String edate = dt1.format(endate);
            request.getSession().setAttribute("a", a);
            request.setAttribute("date", startdate);
            request.setAttribute("pid", uc.getPricePackage().getId());
            request.setAttribute("enddate", edate);
            Course Course = uc.getCourse();
            User user = uc.getUser();
            request.setAttribute("uc", uc);
            request.setAttribute("user", user);
            request.getSession().setAttribute("create", create);
            request.setAttribute("Course", Course);
            request.getSession().setAttribute("ucid", ucid);
            request.setAttribute("ucid", ucid);
        } else {
            String cid = request.getParameter("cid");
            String p = request.getParameter("pid");
            int pid = 1;
            if (p != null && p.trim().length() > 0) {
                pid = Integer.parseInt(p);
            }
            // get pid
            PricePackageDBContext pdb = new PricePackageDBContext();
            PricePackage pr = pdb.getPackage(pid);
            request.setAttribute("pr", pr);

            Course Course = new Course();
            if (cid != null && cid.trim().length() > 0) {
                CourseDBContext cdb = new CourseDBContext();
                int x = Integer.parseInt(cid);
                Course = cdb.getSubjectById(x);

            }
            Date date = Date.valueOf(a);
            Calendar c1 = Calendar.getInstance();
            c1.setTime(date);
            c1.add(Calendar.MONTH, (pr.getDuration()));

            TimeZone tz = c1.getTimeZone();
            // Getting zone id
            ZoneId zoneId = tz.toZoneId();
            // conversion
            LocalDateTime localDateTime = LocalDateTime.ofInstant(c1.toInstant(), zoneId);
            String z = localDateTime.toString();
            String[] time = z.split("T");
            Date dates = Date.valueOf(time[0]);
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
            String endate = dt1.format(dates);
            request.getSession().setAttribute("a", a);
            request.setAttribute("date", a);
            request.setAttribute("pid", pid);
            request.setAttribute("enddate", endate);
            request.setAttribute("Course", Course);
        }
        request.getRequestDispatcher("view/admin/RegistrationDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User usersale = (User) request.getSession().getAttribute("user");

        String cid = request.getParameter("cid");
        String sta = request.getParameter("status");

        String p = request.getParameter("package");
        int pid = 1;
        if (p != null && p.trim().length() > 0) {
            pid = Integer.parseInt(p);
        }
        PricePackageDBContext pdb = new PricePackageDBContext();
        PricePackage pr = pdb.getPackage(pid);
        String sdate = request.getParameter("sdate");
        Date starDate = Date.valueOf(sdate);
        String edate = request.getParameter("edate");
        System.out.println("aaadd" + edate);
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
        String zz = "2022-08-01";
        try {
            java.util.Date y = dt1.parse(edate);
            SimpleDateFormat dt2 = new SimpleDateFormat("yyyy-mm-dd");
            zz = dt2.format(y);
        } catch (ParseException ex) {
            Logger.getLogger(RegistrationDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date endDate = Date.valueOf(zz);
        String cname = request.getParameter("cname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String gen = request.getParameter("gender");
        boolean gender = true;
        if (gen.equals("female")) {
            gender = false;
        }
        User user = new User();
        user.setEmail(email);
        UserCourse uc = new UserCourse();
        UserDBContext udb = new UserDBContext();
        Course c = new Course();
        UserCourseDBContext ucdb = new UserCourseDBContext();
        c.setCourseId(Integer.parseInt(cid));
        if (udb.CheckEmailExist(email.trim()) == true) {
            User u = udb.getUserr(email);
            UserCourse userc = ucdb.getUserCouByUidCid1(u.getId(), Integer.parseInt(cid));
            if (userc == null) {
                System.out.println("1111");
                uc.setUser(u);
                uc.setCourse(c);
                uc.setStartDate(starDate);
                uc.setEndDate(endDate);
                uc.setPricePackage(pr);
                Status st1 = new Status();

                if (sta.equalsIgnoreCase("Success")) {
                    st1.setId(3);
                } else if (sta.equalsIgnoreCase("Submitted")) {
                    st1.setId(5);
                } else {
                    st1.setId(4);
                }
                uc.setRegistration_status(st1);
                uc.setCreateBy(usersale);
                uc.setUpdateBy(usersale);
                ucdb.insertUcDetail(uc);
            } else {
                if (userc.getRegistration_status().getId()==5 || userc.getRegistration_status().getId()==3 ) {
                    System.out.println("2222");
                    Date dateBefore = userc.getEndDate();
                    Date startdates = dateBefore;
                    Calendar c1 = Calendar.getInstance();
                    c1.setTime(startdates);
                    c1.add(Calendar.MONTH, (pr.getDuration()));
                    TimeZone tz = c1.getTimeZone();
                    // Getting zone id
                    ZoneId zoneId = tz.toZoneId();
                    // conversion
                    LocalDateTime localDateTime = LocalDateTime.ofInstant(c1.toInstant(), zoneId);
                    String z = localDateTime.toString();
                    String[] time = z.split("T");
                    Date edates = Date.valueOf(time[0]);
//                        userc.setStartDate(startdates);
                    userc.setEndDate(edates);
                    Status st2 = new Status();
                    if (sta.equalsIgnoreCase("success")) {
                        st2.setId(3);
                    } else if (sta.equalsIgnoreCase("submitted")) {
                        st2.setId(5);
                    } else {
                        st2.setId(4);
                    }
                    uc.setRegistration_status(st2);
                    userc.setCreateBy(usersale);
                    userc.setUpdateBy(usersale);
                    ucdb.updateUcDetail2(userc, userc.getUserCourseId());
                } else {
//                    update ngay thang
                }
            }

        } else {
            user.setFullName(cname);
            user.setPhone(mobile);
            user.setGender(gender);
            String password = "123@123";
            user.setPassword(password);
            Status s = new Status();
            s.setId(1);
            user.setStatus(s);
            user.setAvatarImage("non-avatar.png");
            UserDBContext db = new UserDBContext();
            int userid = db.insertUser(user);
            String link = "";
            link = "http://localhost:8080" + request.getContextPath() + "/user/verify?id=" + userid;
            SendEmail y = new SendEmail();
            y.send(email, content(link, password), "Action Required: Confirm your email.");
//            role
            UserRoleDBContext urdb = new UserRoleDBContext();
            urdb.insertUR(userid, 3);
//            tạo uc
            UserCourse ucx = new UserCourse();
            user.setId(userid);
            ucx.setUser(user);
            ucx.setCourse(c);
            ucx.setStartDate(starDate);
            ucx.setEndDate(endDate);
            ucx.setPricePackage(pr);
            Status st2 = new Status();
            if (sta.equalsIgnoreCase("success")) {
                st2.setId(3);

            } else if (sta.equalsIgnoreCase("submitted")) {
                st2.setId(5);
            } else {
                st2.setId(4);
            }
            uc.setRegistration_status(st2);
            ucx.setCreateBy(usersale);
            ucx.setUpdateBy(usersale);
            ucdb.insertUcDetail(ucx);
        }

        request.getSession().setAttribute("successful", "successful");
        response.sendRedirect("RegistrationDetails?cid="+cid);
    }

    String content(String a, String password) {
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
                + "                        </tr>\n"
                + "                        <!-- === //NEVIGATION SECTION === -->\n"
                + "                        <!-- === IMG WITH TEXT AND COUPEN CODE SECTION === -->\n"
                + "                        <tr>\n"
                + "                            <td valign=\"top\" class=\"em_aside\">\n"
                + "                                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
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
                + "                                        <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:18px; line-height:20px; \"> Password: " + password + "</td><br>\n"
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
                + "                                                        <a href=\"" + a + "\" >CONFIRM MAIL </a>\n"
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
