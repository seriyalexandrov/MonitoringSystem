<%--
  Created by IntelliJ IDEA.
  User: Evgeny
  Date: 26.02.2016
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Selected settings</title>
</head>
<body>
<%
  String algorithm = request.getParameter("algorithm");
  String timeSeriesInterval = request.getParameter("timeSeriesInterval");
  String predictionTimeInterval = request.getParameter("predictionTimeInterval");
  String numberOfPeriods = request.getParameter("numberOfPeriods");
  String packetLimit = request.getParameter("packetLimit");
%>
<p>
  <b>Algorithm: </b><%= algorithm %> <br>
  <b>Time series interval: </b><%= timeSeriesInterval %> <br>
  <b>Prediction time interval: </b><%= predictionTimeInterval %> <br>
  <b>Number of periods: </b><%= numberOfPeriods %> <br>
  <b>Packet limit: </b><%= packetLimit %> <br>

</p>
<form action = "index.jsp" method="get">
  If you want to edit settings:<br>
  <input type="submit" value="Settings">
</form>
</body>
</html>
