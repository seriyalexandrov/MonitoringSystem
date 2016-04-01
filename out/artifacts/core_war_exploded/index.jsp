<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 19.02.2016
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/templatemo_style.css" rel="stylesheet">
    <link href="css/denisStylesheet.css" rel="stylesheet">
    <title>SP</title>
</head>

<body>

<div class="col-md-12">
    <div class="secHeader">
        <h1 class="text-center">Monitoring System</h1>
    </div>
</div>
<div class="mWrapper">
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-md-4">
                <div class="secHeader">
                    <h3 class="text-center">Navigation</h3>
                </div>
            </div>
            <div class="col-sm-8 col-md-8">
                <nav class="mainMenu">
                    <ul class="nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="settings.jsp">Settings</a></li>
                        <li><a href="profile.jsp">Profile</a></li>
                        <li><a href="#about">About</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row-fluid">
        <h3>Hello, guest!</h3>
        <form class="form-inline">
            <div class="form-group">
                <label for="InputName">Name</label>
                <input type="text" class="form-control" id="InputName" placeholder="Jane Doe">
            </div>
            <div class="form-group">
                <label for="InputEmail">Email</label>
                <input type="email" class="form-control" id="InputEmail" placeholder="jane.doe@example.com">
            </div>
            <button class="btn btn-success">Sign in</button>
            <button class="btn btn-success">Registration</button>
        </form>
    </div>

    <div class="row-fluid">
        <div class="span2">
            <div class="col-md-2">
                <h1 class="text-lg-left"> Here should be information about graphics</h1>
            </div>
        </div>
        <div class="col-md-10">
            <div class="container">
                <div class="container">
                    <div id="1plot" class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <h1 class="text-md-center">f(x) = cos(x) </h1>
                                <div class="media-heading">
                                    <img src="images/proj/plot.png" class="img-responsive center-block">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="container">
                    <div id="2plot" class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <h1 class="text-md-center">f(x) = sin(x) </h1>
                                <div class="media-heading">
                                    <img src="images/proj/plot.png" class="img-responsive center-block">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<footer id="about" class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <img src="images/proj/KDV.jpg" class="img-responsive">
            </div>
            <div class="col-md-3">
                <img src="images/proj/EPa.jpg" class="img-responsive">
            </div>
            <div class="col-md-3">
                <img src="images/proj/BigBoss.jpg" class="img-responsive">
            </div>
            <div class="col-md-3">
                <img src="images/proj/YAN.jpg" class="img-responsive">
            </div>
        </div>
    </div>
</footer>
</body>
</html>
