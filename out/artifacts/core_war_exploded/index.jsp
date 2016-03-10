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

    <link rel="stylesheet" href="css/main.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <title>SP</title>
</head>

<body>
<style>
    .secHeader {
        width: 60%;
        margin: 0 auto;
    }
    .secHeader h1 {
        text-transform: uppercase;
        color: #00ACE9;
        letter-spacing: 2px;
        font-size: 42px;
        font-weight: 600;
        margin-bottom: 20px;
    }
    .secHeader h2 {
        text-transform: uppercase;
        color: #00ACE9;
        letter-spacing: 2px;
        font-size: 21px;
        font-weight: 600;
        margin-bottom: 20px;
    }
</style>
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="secHeader">
                    <h1 class="text-center">Server Predictor</h1>
                    <!--<h2 class="text-center"><small>project</small></h2>-->
                </div>
            </div>
        </div>
    </div>
</header>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-6">
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <div class="row">
                    <div class="col-md-5">
                        <button class="btn-sm">Sign in</button>
                    </div>
                    <div class="col-md-5">
                        <button class="btn-sm">Registration</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

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

<footer>
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
