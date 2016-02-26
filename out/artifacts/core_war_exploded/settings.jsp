
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Settings</title>
</head>
<body>

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

</body>
</html>
