<%-- 
    Document   : adminSite
    Created on : May 20, 2022, 2:06:23 AM
    Author     : pv
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../adminsite.css">
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
</head>

<body>
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class='bx bxs-user'></i>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">profile</a>
                    <a class="dropdown-item" href="#">setting</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">logout</a>
                </div>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="dashboard">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">sale</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">marketting</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../admin/userlist">User List</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="#">Setting List</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>

        </nav>

        <div class="estimate row">
            <div class="col-md-3 box-es">
                <div class="estimate-item row">
                    <div class="col-md-4"><i class='bx bx-task icon-task'></i></div>
                </div>
            </div>
            <div class="col-md-3 box-es">
                <div class="estimate-item row">
                    <div class="col-md-4"><i class='bx bx-task icon-task'></i></div>
                </div>
            </div>
            <div class="col-md-3 box-es">
                <div class="estimate-item row">
                    <div class="col-md-4"><i class='bx bx-task icon-task'></i></div>
                </div>
            </div>
            <div class="col-md-3 box-es">
                <div class="estimate-item row">
                    <div class="col-md-4"><i class='bx bx-task icon-task'></i></div>
                </div>
            </div>
        </div>

        <div class="row content">
            <div class="col-md-8 chart">
                <canvas id="myChart" style="width:100%;"></canvas>
            </div>
            <div class="col-md-4 notify">
                <p class="notify-title">Notification</p>
                <div class="notify-item">
                    aaaaaaa
                </div>
                <div class="notify-item">
                    bbbbbbbbb
                </div>
                <div class="notify-item">

                </div>
            </div>

        </div>
        <div class="card-footer text-muted">
            2 days ago
        </div>
    </div>
    <script>
        var xValues = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000];

        new Chart("myChart", {
            type: "line",
            data: {
                labels: xValues,
                datasets: [{
                    data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
                    borderColor: "red",
                    fill: false
                }, {
                    data: [1600, 1700, 1700, 1900, 2000, 2700, 4000, 5000, 6000, 7000],
                    borderColor: "green",
                    fill: false
                }, {
                    data: [300, 700, 2000, 5000, 6000, 4000, 2000, 1000, 200, 100],
                    borderColor: "blue",
                    fill: false
                }]
            },
            options: {
                legend: {
                    display: false
                }
            }
        });
    </script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js " integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN " crossorigin="anonymous "></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js " integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q " crossorigin="anonymous "></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js " integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl " crossorigin="anonymous "></script>
</body>

</html>
