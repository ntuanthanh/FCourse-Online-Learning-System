<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Course Detail|Edu-FCourse</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/home.css"/>
     <Style>
        .content-detail {
            margin: 3%;
        }

        .content-detail .carousel {
            margin: 1%;
        }
        #featuredsubjects{
            background-color: blanchedalmond;
            border: 10px;
            border-color: black;
        }
    </Style>
</head>

<body>
    <!-- Header side -->
    <jsp:include page="../view/base/header.jsp" /> 
    <!-- Slider side -->
    <div class = "slider">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="../images/slider/slider1.jpg" alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="../images/slider/slider2.jpg" alt="Second slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <div>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="../home">Home</a></li>
                    <li class="breadcrumb-item active"><a href="#">Course Detail</a></li>
                </ol>
            </nav>
        </div>
    </div>
    <!--Content course detail-->
    <div class="row text-center content-detail">
        <div class="col-lg-8 col-sm-12">
            <a href="#">
                <div id="carouselExampleControls" class="carousel" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="../images/courses/anh_course_temp.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="../images/courses/anh_course_temp.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="../images/courses/anh_course_temp.jpg" alt="Third slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </a>
            <div class="ttr-post-title ">
                <h1 class="post-title">Project Management Principles and Practices</h1>
            </div>
            <div>
                <p>
                <div class="course-price text-center">

                    original price <del>$190</del>
                    <h4 class="price"> sale price $120</h4>
                </div>
                <div class="course-buy-now text-center">
                    <input type="button" value="Register This Courses">
                    <p>starting May 15</p>    

                </div>
                <h4> About this Specialization</h4>

                This specialization is a precursor to the Applied Project Management Certificate.
                Project management has been proven to be the most effective method of delivering products within cost,
                schedule, and resource constraints.
                This intensive and hands-on series of courses gives you the skills to ensure your projects are completed
                on time and on budget while giving the user the product they expect.
                You will gain a strong working knowledge of the basics of project management and be able to immediately
                use that knowledge to effectively manage work projects. At the end of
                the series you will be able to identify and manage the product scope, build a work breakdown structure,
                create a project plan, create the project budget, define and allocate
                resources, manage the project development, identify and manage risks, and understand the project
                procurement process.</p>
            </div>
        </div>
        <div class="col-lg-4 col-sm-12  " id="featuredsubjects">
            <h1>featured subjects</h1>

        </div>
    </div>
    <!-- footer side -->
    <jsp:include page="../view/base/footer.jsp" />    
</body>

</html>