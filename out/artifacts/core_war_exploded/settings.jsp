
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/templatemo_style.css" rel="stylesheet">
    <link href="css/denisStylesheet.css" rel="stylesheet">
    <title>Settings</title>

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
                        <li><a href="./LogoutServlet">Logout</a></li>
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="settings.jsp">Settings</a></li>
                        <li><a href="profile.jsp">Profile</a></li>
                        <li><a href="about.jsp">About</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>


<div class="container">
  <form action="selectedSettings.jsp" method="post">

    <p><b>Select algorithm:</b><Br>
      <input type="radio" name="algorithm"  value="Double exponential smoothing"> Double exponential smoothing <Br>
      <input type="radio" name="algorithm" value="Linear trend"> Linear trend<Br>
    </p>

    <p><b>Time series interval:</b><br>
      <input type="text" pattern="^[ 0-9]+$" name = "timeSeriesInterval" size="20">
    </p>


    <p><b>Prediction time interval:</b><br>
      <input type="text" pattern = "^[ 0-9]+$" name = "predictionTimeInterval" size="20">
    </p>

    <p><b>Number of periods:</b><br>
      <input type="text" pattern = "^[ 0-9]+$" name = "numberOfPeriods" size="20">
    </p>

    <p><b>Packet limit:</b><br>
      <input type="text" pattern = "^[ 0-9]+$" name = "packetLimit" size="20">
    </p>

    <p><input type="submit" value="   Submit  ">
      <input type="reset" value="   Reset   "></p>
  </form>
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
