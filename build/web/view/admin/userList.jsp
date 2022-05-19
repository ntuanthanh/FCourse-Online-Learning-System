<%-- 
    Document   : userList
    Created on : May 20, 2022, 2:12:17 AM
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
    <link rel="stylesheet" href="adminsite.css">
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
                    <li class="nav-item">
                        <a class="nav-link" href="../admin/dashboard">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Sale</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#">Marketting</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="userlist">User list</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Setting list</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>

        </nav>
        <section class="py-5">

            <div class="">
                <div class="user">
                    <h3>Danh sách người dùng</h3>
                </div>

                <div class="search">
                    <form class="form-inline" class="search">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1">@</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                        </div>
                    </form>
                </div>

                <div class="table">

                    <table border="1px">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Ảnh đại diện</th>
                                <th scope="col">Tên người dùng</th>
                                <th scope="col">Số điện thoại </th>
                                <th scope="col">Email</th>
                                <th scope="col">vai trò</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>

                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="1">
                                <th scope="row">1</th>
                                <td><img src="http://dummyimage.com/124x100.png/5fa2dd/ffffff" width="50"></td>
                                <td>Alix Lydford</td>
                                <td>+46 255 474 4244</td>
                                <td>alydford0@photobucket.com</td>
                                <td>Admin</td>
                                <td><a href="#" class="btn btn-outline-danger"><i
                                class="bi bi-trash"></i>Cập nhật</a>


                                </td>
                            </tr>



                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="2">
                                <th scope="row">2</th>
                                <td><img src="http://dummyimage.com/198x100.png/dddddd/000000" width="50"></td>
                                <td>Petey Blondin</td>
                                <td>+33 111 191 8926</td>
                                <td>ppblondin1@reddit.com</td>
                                <td>Admin</td>
                                <td><a href="#" class="btn btn-outline-danger"><i
                                class="bi bi-trash"></i>Cập nhật</a>


                                </td>
                            </tr>



                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="5">
                                <th scope="row">5</th>
                                <td><img src="http://dummyimage.com/155x100.png/ff4444/ffffff" width="50"></td>
                                <td>Vally Maddick</td>
                                <td>+48 831 574 9312</td>
                                <td>vmaddick4@squarespace.com</td>

                                <td>Admin</td>
                                <td><a href="#" class="btn btn-outline-danger"><i
                                class="bi bi-trash"></i>Cập nhật</a>


                                </td>

                            </tr>



                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="6">
                                <th scope="row">6</th>
                                <td><img src="http://dummyimage.com/117x100.png/ff4444/ffffff" width="50"></td>
                                <td>Flem Eyree</td>
                                <td>+81 228 773 2443</td>
                                <td>feyree5@guardian.co.uk</td>

                                <td>User</td>





                                <td><a href="#" class="btn btn-outline-danger"><i
                                        class="bi bi-trash"></i>Cập nhật</a>


                                </td>
                            </tr>



                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="7">
                                <th scope="row">7</th>
                                <td><img src="http://dummyimage.com/145x100.png/ff4444/ffffff" width="50"></td>
                                <td>Rosy Kemshell</td>
                                <td>+49 894 484 8654</td>
                                <td>rkemshell6@google.com.au</td>

                                <td>User</td>





                                <td><a href="#" class="btn btn-outline-danger"><i
                                        class="bi bi-trash"></i>Cập nhật</a>


                                </td>
                            </tr>



                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="8">
                                <th scope="row">8</th>
                                <td><img src="http://dummyimage.com/126x100.png/5fa2dd/ffffff" width="50"></td>
                                <td>Valida Drinkale</td>
                                <td>+880 308 604 7021</td>
                                <td>vdrinkale7@engadget.com</td>

                                <td>User</td>





                                <td><a href="#" class="btn btn-outline-danger"><i
                                        class="bi bi-trash"></i>Cập nhật</a>


                                </td>
                            </tr>



                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="9">
                                <th scope="row">9</th>
                                <td><img src="http://dummyimage.com/140x100.png/dddddd/000000" width="50"></td>
                                <td>Rubin Scriviner</td>
                                <td>+1 280 887 2581</td>
                                <td>rscriviner8@de.vu</td>

                                <td>User</td>





                                <td><a href="#" class="btn btn-outline-danger"><i
                                        class="bi bi-trash"></i>Cập nhật</a>


                                </td>
                            </tr>



                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="10">
                                <th scope="row">10</th>
                                <td><img src="http://dummyimage.com/128x100.png/5fa2dd/ffffff" width="50"></td>
                                <td>Janith Dealtry</td>
                                <td>+53 284 947 7670</td>
                                <td>jdealtry9@uiuc.edu</td>

                                <td>User</td>





                                <td><a href="#" class="btn btn-outline-danger"><i
                                        class="bi bi-trash"></i>Cập nhật</a>


                                </td>
                            </tr>



                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="11">
                                <th scope="row">11</th>
                                <td><img src="http://dummyimage.com/245x100.png/dddddd/000000" width="50"></td>
                                <td>Kelci Berendsen</td>
                                <td>+48 844 102 9498</td>
                                <td>kberendsena@unesco.org</td>

                                <td>User</td>





                                <td><a href="#" class="btn btn-outline-danger"><i
                                        class="bi bi-trash"></i>Cập nhật</a>


                                </td>
                            </tr>



                            <form action="controlluser"></form>
                            <tr>
                                <input type="hidden" name="userId" value="12">
                                <th scope="row">12</th>
                                <td><img src="http://dummyimage.com/161x100.png/cc0000/ffffff" width="50"></td>
                                <td>Vally Claye</td>
                                <td>+62 572 340 6951</td>
                                <td>vclayeb@diigo.com</td>

                                <td>User</td>





                                <td><a href="#" class="btn btn-outline-danger"><i
                                        class="bi bi-trash"></i>Cập nhật</a>


                                </td>
                            </tr>



                        </tbody>
                    </table>
                </div>

            </div>
        </section>

    </div>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js " integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN " crossorigin="anonymous "></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js " integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q " crossorigin="anonymous "></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js " integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl " crossorigin="anonymous "></script>
</body>

</html>
