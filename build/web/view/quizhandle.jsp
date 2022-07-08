<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

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
        <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
            <script src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>
            <script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
            <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/color/color-1.css">
        <!-- my style -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/question.css">
        <link rel="stylesheet" type="text/css" href="../css/registerCourse.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <style>


            /* CSS */
            .button-64 {
                align-items: center;
                background-image: linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB);
                border: 0;
                border-radius: 8px;
                box-shadow: rgba(151, 65, 252, 0.2) 0 15px 30px -5px;
                box-sizing: border-box;
                color: #FFFFFF;
                display: flex;
                font-family: Phantomsans, sans-serif;
                font-size: 20px;
                justify-content: center;
                line-height: 0.5em;
                max-width: 60px;
                min-width: 100px;
                padding: 3px;
                text-decoration: none;
                user-select: none;
                -webkit-user-select: none;
                touch-action: manipulation;
                white-space: nowrap;
                cursor: pointer;
                text-align: center;
            }

            .button-64:active,
            .button-64:hover {
                outline: 0;
            }

            .button-64 span {
                background-color: rgb(5, 6, 45);
                padding: 16px 10px;
                border-radius: 6px;
                width: 100%;
                height: 100%;
                transition: 300ms;
            }

            .button-64:hover span {
                background: none;
            }

            .number-question{
                margin-bottom: 15px;
            }

            @media (min-width: 768px) {
                .button-64 {
                    font-size: 20px;
                    min-width: 150px;
                }
            }

            #sub{
                padding: 8px;
                border-radius: 5px;
                border: none;
                background-image: linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB);
                color: white;

            }
            #sub:hover{
                transform: scale(1.1);
            }
        </style>
        <!-- Nhung Alert-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="sweetalert2.all.min.js"></script>
        <script src="sweetalert2.min.js"></script>
        <link rel="stylesheet" href="sweetalert2.min.css"> 
        <script src="/summer2022-se1616-g4/js/validationForm/validateForm.js" type="text/javascript"></script>
    </head>

    <body id="bg">
        <c:set var="quiz" value="${requestScope.quiz}" />
        <c:set var="questions" value="${requestScope.questions}" />
        <c:set var="check" value="${requestScope.choose}" />
          <c:set var="alphabet" value="ABCDEFGHIJKLMNOPQRSTUVWXYZ" />
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <jsp:include page="../view/base/header_t.jsp" /> 
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->

                <!-- Breadcrumb row END -->
                <!-- contact area -->
                <div class="content-block">
                    <!-- Your Faq -->

                    <div class="section-area section-sp1">
                        <div class="container">
                            <h2>${quiz.name}</h2>
                            <div class="row">
                                <div class="col-lg-8 col-md-12">


                                    <h5 id="questionPos">Question: <span id="curQues">1</span>/${questions.size()}</h5>

                                    <form id="quizForm" action="handle" method="post">
                                        <input type="hidden" name="quiz" value="${quiz.id}">
                                        <div class="index" ></div>
                                        <c:forEach items="${questions}" var="i" varStatus="stt">
                                            <div class="${stt.index == 0 ? 'quiz show' : 'quiz hidden'}">

                                                <input type="hidden" name="question${stt.index}" value="${i.id}" />
                                                <p style="min-height: 100px; border-bottom: 1px solid gray">${i.content}</p>

                                                <ul class="option-card">
                                                    <c:if test="${i.options.size()>0}">
                                                        <c:forEach begin="0" end="${i.options.size()-1}" var="j">
                                                            <c:set var="flag"  value="${false}"/>

                                                            <c:if test="${check.size()>0}">
                                                                <c:forEach begin="0" end="${check.size()-1}" var="k">
                                                                    <div style="display: none">${check.get(k).id==i.options.get(j).id?(flag=true):""}</div>

                                                                </c:forEach>  
                                                            </c:if>

                                                            <li class="option-item">
                                                                <div class="cate-card">
                                                                    <label class="cate-item">
                                                                        <input onclick="countcheck()" type="checkbox" id="option${i.options.get(j).id}" ${flag?"checked":""} name="answer${stt.index}" value="${i.options.get(j).id}"/>
                                                                        <span>${alphabet.charAt(j)}. ${i.options.get(j).content}</span>
                                                                    </label>
                                                                </div>
                                                            </li>
                                                        </c:forEach>
                                                    </c:if>
                                                </ul>

                                            </div>
                                        </c:forEach>

                                        <div class="button">
                                            <c:if test="${questions.size()!=1}">
                                                <button class="button-36 hidden" id="previous" type="button" onclick="preQuestion(); autoSave()"> < Previous </button>
                                                <button class="button-36" id="next" type="button" onclick="nextQuestion(); autoSave()">Next ></button>
                                            </c:if>
                                        </div>

                                        <br/>
                                        <br/>
                                        <div data-toggle="modal" data-target="#myModal" class="button-64 open-modal-btn" onclick="autoSave();" ><span>submit</span></div>

                                    </form>


                                </div>
                                <div class="col-lg-4 col-md-12">
                                    <div class="quiz_timer">
                                        <i class="fa-solid fa-clock"></i>
                                        <h4 id="TimeSpan"> Time remaining: <span id="timeDisplay" ><span id="hour"></span>:<span id="min"></span>:<span id="sec"></span></span>  </h4>

                                    </div>
                                    <div class="pagination-bx rounded-sm gray clearfix">
                                        <ul class="pagination row">      
                                            <c:forEach  items="${questions}" var="i" varStatus="stt">
                                                <input id="${stt.index}" type="hidden" value="${stt.index}">
                                                <li   class="col-sm-2 number-question "><a id="k${stt.index}"  class="${stt.index == 0 ? 'pageI active-page' : 'pageI inactive-page'}" onclick="chooseQuestion('${stt.index}'); autoSave()"> ${stt.index+1}</a></li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!-- Your Faq End -->
                </div>
                <!-- contact area END -->
            </div>
            <!-- Content END-->
            <!-- Footer ==== -->

            <!-- Footer END ==== -->

            <div style="top: 150px" class="modal fade" id="myModal">
                <div style="max-width: 500px"class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="row">

                            <div class="col-lg-12">
                                <div class="columns">
                                    <ul class="price">
                                        <li style="background-color: #D2691E; color: white;"> <span id="total"> </span> /<span> ${questions.size()} </span></li>
                                        <li class="grey">do you want submit</li>


                                        <li> <button id="sub" onclick="finish();">comfirm</button></li>




                                    </ul>
                                </div>
                            </div>

                        </div>
                        <!-- Modal footer -->
                        <div class="modal-footer col-12">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-2.2.3.min.js">
        </script>

        <script>
             
//            var checkboxValues = JSON.parse(localStorage.getItem('checkboxValues')) || {},
//                    $checkboxes = $("#quizForm :checkbox");
//
//            $checkboxes.on("change", function () {
//                $checkboxes.each(function () {
//                    checkboxValues[this.id] = this.checked;
//                });
//
//                localStorage.setItem("checkboxValues", JSON.stringify(checkboxValues));
//            });
//
//            // On page load
//            $.each(checkboxValues, function (key, value) {
//                $("#" + key).prop('checked', value);
//            });


//            setInterval(function () {
//                console.log("dmmm");
//            }, 1000);



//            var textinputs = document.querySelectorAll('input[type=checkbox]'); 
//            for(let i = 0; i < textinputs.length; i++){
//                
//            } 


            function color() {

                var ids = [];
                var inputs = document.querySelectorAll("input[type='checkbox']");
                for (let i = 0; i < inputs.length; i++) {
                    if (inputs[i].checked == true) {
                        var name = inputs[i].name;
                        var id = name.replace("answer", "");
                        ids.push(parseInt(id));

                    }
                }
                var checked = [];
                var j = 0;
                for (let i = 0; i < ids.length; i++) {
                    if (checking(checked, ids[i])) {
                        checked[j] = ids[i];
                        console.log(ids[i]);
                        j++;
                    }
                }
//              var inputs = document.querySelectorAll("input[type='checkbox']");
                for (let i = 0; i < size; i++) {
                    if (!checking(checked, i)) {
                        var x = document.getElementById("k" + i);
                        x.style.backgroundColor = 'yellow';
                    } else {
                        var note = document.getElementById("k" + i);

                        note.style.backgroundColor = '#f6f7f8';
                    }
                }
                var total = checked.length.toString();
                return total;
            }

            function countcheck() {
                color();
                var number = document.getElementById("total");
                number.innerHTML = color();
            }



            function checking(arr, x) {
                for (let i = 0; i < arr.length; i++) {
                    if (arr[i] === x) {
                        return false;
                    }
                }
                return true;
            }
            var size = parseInt(${questions.size()});
//            function find() {
//               
//
//
//                
//                var inputs = document.querySelectorAll("input[type='checkbox']");
//                for (let i = 0; i < inputs.length; i++) {
//                   
//                }
//
//            }

            function autoSave() {
                var frm = $('#quizForm');

                $.ajax({
                    type: frm.attr('method'),
                    url: '/summer2022-se1616-g4/autosubmit',
                    data: frm.serialize(),
                    success: function (data) {
                        console.log("ok");
//                            $('#autoSave').text("Post save as draft");
////                            setInterval(function (frm.serialize()) {
////                                console.log();
////                            }, 5000);
//                            setInterval(function () {
//                                $('#autoSave').text('');
//                            }, 5000);
                    }
                });

            }


            var questions = document.getElementsByClassName('quiz');
            var currentIndex;
            var activePage;
            var preButton = document.getElementById('previous');
            var nextButton = document.getElementById('next');
            var currentText = document.getElementById('curQues');
            var pages = document.getElementsByClassName('pageI');
            function chooseQuestion(id) {
                var currentQuestion = document.getElementsByClassName('show')[0];
                for (var i = 0; i < questions.length; i++) {
                    if (questions[i] === currentQuestion) {
                        currentIndex = i;
                        break;
                    }
                }
                pages[currentIndex].className = pages[currentIndex].className.replace('active-page', 'inactive-page');
                questions[currentIndex].className = questions[currentIndex].className.replace('show', 'hidden');
                var x = document.getElementById(id).value;
                currentIndex = parseInt(x);


                pages[currentIndex].className = pages[currentIndex].className.replace('inactive-page', 'active-page');
                questions[currentIndex].className = questions[currentIndex].className.replace('hidden', 'show');
                if (currentIndex === 0) {
                    preButton.className = 'hidden';
                    nextButton.className = 'show';
                } else if (currentIndex === questions.length - 1) {
                    preButton.className = 'show';
                    nextButton.className = 'hidden';
                } else {
                    preButton.className = 'show';
                    nextButton.className = 'show';
                }
                currentText.textContent = currentIndex + 1;
            }
            function nextQuestion() {
                var currentQuestion = document.getElementsByClassName('show')[0];
                for (var i = 0; i < questions.length; i++) {
                    if (questions[i] === currentQuestion) {
                        currentIndex = i;
                        break;
                    }
                }

                pages[currentIndex].className = pages[currentIndex].className.replace('active-page', 'inactive-page');
                questions[currentIndex].className = questions[currentIndex].className.replace('show', 'hidden');

                currentIndex = currentIndex + 1;
                pages[currentIndex].className = pages[currentIndex].className.replace('inactive-page', 'active-page');
                questions[currentIndex].className = questions[currentIndex].className.replace('hidden', 'show');
                if (currentIndex === 0) {
                    preButton.className = 'hidden';
                    nextButton.className = 'show';
                } else if (currentIndex === questions.length - 1) {
                    preButton.className = 'show';
                    nextButton.className = 'hidden';
                } else {
                    preButton.className = 'show';
                    nextButton.className = 'show';
                }
                currentText.textContent = currentIndex + 1;

            }

            function preQuestion() {
                var currentQuestion = document.getElementsByClassName('show')[0];
                for (var i = 0; i < questions.length; i++) {
                    if (questions[i] === currentQuestion) {
                        currentIndex = i;
                        break;
                    }
                }
                pages[currentIndex].className = pages[currentIndex].className.replace('active-page', 'inactive-page');
                questions[currentIndex].className = questions[currentIndex].className.replace('show', 'hidden');

                currentIndex = currentIndex - 1;
                pages[currentIndex].className = pages[currentIndex].className.replace('inactive-page', 'active-page');
                questions[currentIndex].className = questions[currentIndex].className.replace('hidden', 'show');
                if (currentIndex === 0) {
                    preButton.className = 'hidden';
                    nextButton.className = 'show';
                } else if (currentIndex === questions.length - 1) {
                    preButton.className = 'show';
                    nextButton.className = 'hidden';
                } else {
                    preButton.className = 'show';
                    nextButton.className = 'show';
                }
                currentText.textContent = currentIndex + 1;
            }
            function resetTime() {
                localStorage.clear();
            }
            function submitBtn() {
                resetTime();
                document.getElementById('quizForm').submit();

            }



//            function reset()
//            {
//                localStorage.endTime = +new Date + interval;
//            }
//
//            if (!localStorage.endTime)
//            {
//                reset();
//            }
//            var time = document.getElementById('timeDisplay');
//            var interval = parseInt('${sessionScope.doingQuiz.quiz.duration}') * 60 * 1000;

//      time
            function finish() {
                resetTime();
                document.getElementById('quizForm').submit();
                resetTime();
            }
            var duration = parseInt(${sessionScope.doingQuiz.quiz.duration}) * 60;

            function resetTime() {
                localStorage.clear();
            }
            var today = new Date();
            var minutesLabel = document.getElementById("min");
            var secondsLabel = document.getElementById("sec");
            var hoursLabel = document.getElementById("hour");
            var totalSecond;

            var startMilisecond = parseInt(${sessionScope.doingQuiz.time});
//            if (localStorage.getItem("startMiliseconds") != null) {
//                startMilisecond = localStorage.getItem("startMiliseconds");
//            } else {
//                startMilisecond = today.getTime();
//            }
//            localStorage.setItem('startMiliseconds', startMilisecond);



            function setTime() {
                var today2 = new Date();
                var presentMilisecond = today2.getTime();
                totalSecond = duration - ((presentMilisecond - startMilisecond) / 1000);
                displayTime();
            }

            setInterval(autoSubmit, 1000);

            function autoSubmit() {
                if (totalSecond <= 0) {
                    resetTime();
                    document.getElementById('quizForm').submit();
                    resetTime();
                }
            }

            function pad(val) {
                var valString = val + "";
                if (valString.length < 2) {
                    return "0" + valString;
                } else {
                    return valString;
                }
            }
            setInterval(setTime, 100);

            function displayTime() {
                var totalMinute = (totalSecond / 60) % 60;
                var totalHour = totalSecond / 60 / 60;
                var totalSec = totalSecond % 60;
                secondsLabel.innerHTML = pad(parseInt(totalSec));
                minutesLabel.innerHTML = pad(parseInt(totalMinute));
                hoursLabel.innerHTML = pad(parseInt(totalHour));

            }


            function confirmSubmit() {
                var result = confirm("Do you want to submit?");
                return result;
            }
        </script>
        <!-- External JavaScripts -->

        <script src="${pageContext.request.contextPath}/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/counter/waypoints-min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/counter/counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/masonry/masonry.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/masonry/filter.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/functions.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/contact.js"></script>
        <script src='${pageContext.request.contextPath}/assets/vendors/switcher/switcher.js'></script>
    </body>

</html>