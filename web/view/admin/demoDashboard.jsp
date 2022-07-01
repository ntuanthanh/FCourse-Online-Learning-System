<%-- 
    Document   : test
    Created on : Jun 16, 2022, 10:40:11 AM
    Author     : pv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.Console"%>
<%@page import="model.ParentCategory"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/color/color-1.css">
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>-->

        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>

        <style>
            .des-date{
                margin-left: 30px;
            }
            .merge-inline{
                display: flex;
            }
            .des-date input{
                width: 8.5rem;
            }
            .des-date input{
                color: #0083d4;
            }


        </style>

        <% ArrayList<Integer> status = (ArrayList<Integer>) request.getAttribute("status"); %>
        <% ArrayList<Integer> bought = (ArrayList<Integer>) request.getAttribute("bought"); %>
        <% ArrayList<Integer> regis = (ArrayList<Integer>) request.getAttribute("regis"); %>
        <% ArrayList<Integer> orde = (ArrayList<Integer>) request.getAttribute("orde"); %>
        <% ArrayList<Integer> days = (ArrayList<Integer>) request.getAttribute("days"); %>
        <% ArrayList<String> time = (ArrayList<String>) request.getAttribute("time"); %>
        <% ArrayList<Integer> orderss = (ArrayList<Integer>) request.getAttribute("orderss"); %>

        <% ArrayList<ParentCategory> category = (ArrayList<ParentCategory>) request.getAttribute("category"); %>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <jsp:include page="../../view/admin/header_admin.jsp" /> 
        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Dashboard</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Dashboard</li>
                    </ul>
                </div>	
                <!-- Card -->
                <div class="row">
                    <div class="col-md-6 col-lg-4 col-xl-4 col-sm-6 col-12">
                        <div class="widget-card widget-bg1">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    Total Courses
                                </h4>
                                <span class="wc-des">
                                    ${rateCourse}%
                                </span>
                                <span class="wc-stats">
                                    <span class="counter">${totalCourse}</span> 
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: ${rateCourse}%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Last 7 days
                                    </span>
                                    <span class="wc-number ml-auto">
                                        ${newCourse}
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4 col-xl-4 col-sm-6 col-12">
                        <div class="widget-card widget-bg2">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    Total Revenues
                                </h4>
                                <span class="wc-des">
                                    ${rateReve}%
                                </span>
                                <span class="wc-stats counter">
                                    $<span class="counter"> ${totalRevenues}</span>
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: ${rateReve}%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Last 7 days
                                    </span>
                                    <span class="wc-number ml-auto">
                                        ${newRevenues}
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4 col-xl-4 col-sm-6 col-12">
                        <div class="widget-card widget-bg3">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    Total Customers 
                                </h4>
                                <span class="wc-des">
                                    ${rateCus}%
                                </span>
                                <span class="wc-stats counter">
                                    ${totalCustomer}
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: ${rateCus}%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Last 7 days
                                    </span>
                                    <span class="wc-number ml-auto">
                                        ${newCustomer}
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>

                </div>
                <!-- Card END -->

                <div class="row">
                    <!--<div class="col-lg-8 m-b30">-->
                    <form action="../admin/dashboard" method="GET">
                        <div class="des-date">
                            Date From:<input class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm ml-2" 
                                             type="text" name="from" id="txtFrom" value="${from}">
                            Date To:<input class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm ml-2"
                                           type="text" name="to" id="txtTo" value="${to}">
                            <input class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm ml-2" style="background-color: #005cbf; color: white;" type="submit" value="Filter" />
                        </div>
                    </form>
                    <!--</div>-->

                </div>

                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Trend of order counts</h4>
                            </div>
                            <div class="widget-inner">
                                <canvas id="myLinechart" width="100" height="45"></canvas>
                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->


                    <div class="col-lg-6 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Customers </h4>
                            </div>
                            <div class="widget-inner">
                                <canvas id="myBarChart" width="100" height="45"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Registrations </h4>
                            </div>
                            <div class="widget-inner">
                                <canvas id="myPieChart" width="100" height="45"></canvas>
                            </div>
                        </div>
                    </div>

                   
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="/summer2022-se1616-g4/view/admin/assets/js/jquery.min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/counter/waypoints-min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/counter/counterup.min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/masonry/masonry.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/masonry/filter.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='/summer2022-se1616-g4/view/admin/assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/js/functions.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/chart/chart.min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/js/admin.js"></script>
        <script src='/summer2022-se1616-g4/view/admin/assets/vendors/calendar/moment.min.js'></script>
        <script src='/summer2022-se1616-g4/view/admin/assets/vendors/calendar/fullcalendar.js'></script>
        <script src='/summer2022-se1616-g4/view/admin/assets/vendors/switcher/switcher.js'></script>
        <!--         <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
                  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>-->
        <script> // Set new default font family and font color to mimic Bootstrap's default styling

            var data = [];
            <% for (Integer elem : status) {%>

            data.push(<%=elem%>);
            <%   }
            %>

            Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
            Chart.defaults.global.defaultFontColor = '#292b2c';

            // Pie Chart Example
            var ctx = document.getElementById("myPieChart");
            var myPieChart = new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: ["Success", "Cancelled", "Submitted"],
                    datasets: [{
                            data: data,
                            backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745']
                        }]
                }
            });

            var regis = [];
            <% for (Integer elem : regis) {%>
            regis.push(<%=elem%>);
            <%   }
            %>

            var bought = [];
            <% for (Integer elem : bought) {%>
            bought.push(<%=elem%>);
            <%   }
            %>
            var cty = document.getElementById("myBarChart");
            var myLineChart = new Chart(document.getElementById("myBarChart"), {
                type: 'bar',
                data: {
                    labels: ["Software", "Math", "Life Skill", "Design"],
                    datasets: [
                        {
                            label: "Registered",
                            backgroundColor: "#3e95cd",
                            data: regis
                        }, {
                            label: "Bought",
                            backgroundColor: "#8e5ea2",
                            data: bought
                        }
                    ]
                },
                options: {
                    title: {
                        display: true,
                        text: 'Registration '
                    }
                }
            });

            var order = [];
            <% for (Integer elem : orde) {%>
            order.push(<%=elem%>);
            <%   }
            %>
//           
            var days = [];
            <% for (int idx = days.size() - 1; idx >= 0; idx--) {
                    int elem = days.get(idx);%>
            days.push(<%=elem%>);
            <%   }
            %>
            var ctk = document.getElementById('myLinechart').getContext('2d');

            var times = [];
            <% for (int idx = time.size() - 1; idx >= 0; idx--) {                   
                    String elem = "'"+ time.get(idx) + "'" ;%>

                    times.push (String(<%=elem%>));
            <%   }
            %>
                
          
          

            var orderss = [];
            <% for (Integer elem : orderss) {%>
                orderss.push(<%=elem%>);
            <%   }
            %>

            var myLinechart = new Chart(ctk, {
                type: 'line',

                // The data for our dataset
                data: {
                    labels: times,
                    // Information about the dataset
                    datasets: [{
                            label: "All",
                            backgroundColor: 'rgba(0,0,0,0.05)',
                            borderColor: '#4c1864',
                            borderWidth: "3",
                            data: order,
                            pointRadius: 4,
                            pointHoverRadius: 4,
                            pointHitRadius: 10,
                            pointBackgroundColor: "#fff",
                            pointHoverBackgroundColor: "#fff",
                            pointBorderWidth: "3",
                        }
                        ,
                        {
                            label: "Success",
                            backgroundColor: 'rgba(0,0,1,0.05)',
                            borderColor: '#3e95cd',
                            borderWidth: "3",
                            data: orderss,
                            pointRadius: 4,
                            pointHoverRadius: 4,
                            pointHitRadius: 10,
                            pointBackgroundColor: "#fff",
                            pointHoverBackgroundColor: "#fff",
                            pointBorderWidth: "3",
                        }

                    ]
                },

                // Configuration options
                options: {

                    layout: {
                        padding: 0,
                    },

                    legend: {display: true},
                    title: {display: true},

                    scales: {
                        yAxes: [{
                                scaleLabel: {
                                    display: false
                                },
                                gridLines: {
                                    borderDash: [6, 6],
                                    color: "#ebebeb",
                                    lineWidth: 1,
                                },
                            }],
                        xAxes: [{
                                scaleLabel: {display: false},
                                gridLines: {display: false},
                            }],
                    },

                    tooltips: {
                        backgroundColor: '#333',
                        titleFontSize: 12,
                        titleFontColor: '#fff',
                        bodyFontColor: '#fff',
                        bodyFontSize: 12,
                        displayColors: false,
                        xPadding: 10,
                        yPadding: 10,
                        intersect: false
                    }
                },
            });

        </script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
        type="text/javascript"></script>
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
              rel="Stylesheet"type="text/css"/>
        <script type="text/javascript">
            $(document).ready(function () {
//                $('#txtFrom').on("click", function () {
//                    alert($("#txtFrom").val());
//                    alert($("#txtTo").val());
//                });
//                $('#txtFrom').datepicker( 'getDate' );
                $("#txtFrom").datepicker({
                    numberOfMonths: 1,
                    onSelect: function (selected) {
                        var dt = new Date(selected);
                        dt.setDate(dt.getDate() + 1);
                        $("#txtTo").datepicker("option", "minDate", dt);
                    }
                });
                $("#txtTo").datepicker({
                    numberOfMonths: 1,
                    onSelect: function (selected) {
                        var dt = new Date(selected);
                        dt.setDate(dt.getDate() - 1);
                        $("#txtFrom").datepicker("option", "maxDate", dt);
                    }
                });

                $('#txtFrom').on("click", function () {
                    alert($(this).getDate());
                });
            });


        </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../js/datatables-simple-demo.js"></script>


    </body>
</html>
