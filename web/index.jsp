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
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://code.highcharts.com/highcharts.js"></script>
    <script type="text/javascript" src="https://code.highcharts.com/modules/exporting.js"></script>
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
        <form class="form-inline" method="post" action="j_security_check">
            <div class="form-group">
                <label for="InputLogin">Login</label>
                <input type="text" class="form-control" name="j_username" id="InputLogin" placeholder="bigboss">
            </div>
            <div class="form-group">
                <label for="InputPassword">Password</label>
                <input type="password" class="form-control" name="j_password" id="InputPassword" placeholder="******">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
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
                                <h1 class="text-md-center">First chart</h1>
                                <div class="media-heading" id="container1"> </div>
                            </div>
                        </div>
                    </div>
                </div>


                <script type="text/javascript">
                    $(function () {
                        $('#container1').highcharts({
                            chart: {
                                type: 'bar'
                            },
                            title: {
                                text: 'Example'
                            },
                            xAxis: {
                                categories: ['First', 'Second']
                            },
                            yAxis: {
                                title: {
                                    text: 'Value'
                                }
                            },
                            series: [{
                                name: '1',
                                data: [1, 2]
                            }, {
                                name: '2',
                                data: [39.37, 40]
                            }]
                        });
                    });
                </script>

                <div class="container">
                    <div id="2plot" class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <h1 class="text-md-center">Second Chart</h1>
                                <div class="media-heading" id="container2"> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#container2').highcharts({
            xAxis: {
                min: -0.5,
                max: 5.5
            },
            yAxis: {
                min: 0
            },
            title: {
                text: 'Example'
            },
            series: [{
                type: 'line',
                name: 'Regression Line',
                data: [[0, 1.11], [5, 4.51]],
                marker: {
                    enabled: false
                },
                states: {
                    hover: {
                        lineWidth: 0
                    }
                },
                enableMouseTracking: false
            }, {
                type: 'scatter',
                name: 'Observations',
                data: [1, 1.5, 2.8, 3.5, 3.9, 4.2],
                marker: {
                    radius: 4
                }
            }]
        });
    });
</script>



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
