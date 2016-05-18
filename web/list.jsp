<%@ page import="com.kalashnikov.monitoring.servlets.UsersEntityAndSettings" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/dataTables.css">
    <title>List of users</title>
</head>
<body>
<%
    ArrayList<UsersEntityAndSettings> infoList = (ArrayList<UsersEntityAndSettings>) request.getAttribute("infoList");
    List<String> settingsNames = (List<String>) request.getAttribute("settingsNames");
%>

<h3>All users:</h3>(<a href="add">add</a>)
<table id="example" class="display">
    <thead>
    <tr>
        <th>Name</th>
        <%--<th>Password</th>--%>
        <th>Enable</th>
        <th>Delete</th>
        <% for (String settingName : settingsNames) {
        %>
        <th><%=settingName%>
        </th>
        <% } %>
    </tr>
    </thead>
    <tbody>
    <% for (UsersEntityAndSettings user : infoList) {%>
    <tr>
        <td><%=user.getUsersEntity().getUserName()%>
        </td>
        <%--<td><%=user.getUsersEntity().getPassword()%>--%>
        </td>
        <td><a href="add?edit=<%=user.getUsersEntity().getUserId()%>">edit</a></td>
        <td><a href="delete?id=<%=user.getUsersEntity().getUserId()%>">delete</a></td>
        <% for (String settingName : settingsNames) {
            if (user.getSettingsMap().get(settingName) == null) {
        %>
        <td><%=""%>
        </td>
        <%} else {%>
        <td><%=user.getSettingsMap().get(settingName)%>
        </td>
        <% } %>
        <% } %>
        <% } %>
    </tr>
    <%--<% for (UsersEntityAndSettings user : infoList) {%>--%>
    <%--<%=user.getSettingsMap()%>--%>
    <%--<%=user.getUsersEntity().getSettings().size()%>--%>
    <%--<% } %>--%>

    </tbody>
    <script type="text/javascript" charset="utf8" src="js/jquery-2.2.0.js"></script>
    <script type="text/javascript" charset="utf8" src="js/dataTables.js"></script>
    <script>
        $(function () {
            $("#example").dataTable();
        })
    </script>
</table>
</body>
</html>
