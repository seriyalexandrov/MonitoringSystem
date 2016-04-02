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
    <div class="container">
        <div class="row-fluid">
            <h3>Please enter login and password or <a href="index.jsp">return to home page</a>.</h3>
            <form method="post" action="j_security_check">
                <div class="form-group">
                    Username:<input type="text" class="form-control" name="j_username" id="InputLogin" placeholder="bigboss">
                </div>
                <div class="form-group">
                    Password:<input type="password" class="form-control" name="j_password" id="InputPassword" placeholder="******">
                </div>
                <button type="submit" class="btn btn-success">Sign in</button>
            </form>
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