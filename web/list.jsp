<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/dataTables.css">
    <title>List of users</title>
</head>
<body>

<h3>All users:</h3>(<a href="add">add</a>)
<table id="example" class="display">
    <thead>
    <tr>
        <th>Name</th>
        <th>Password</th>
        <th>Enable</th>
        <th>Delete</th>
        <c:forEach items="${settingsNames}" var="setName">
            <th>${setName}</th>
        </c:forEach>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.userName}</td>
            <td>${user.password}</td>
            <td><a href="add?edit=${user.userId}">edit</a></td>
            <td><a href="delete?id=${user.userId}">delete</a></td>
            <td>${user.settings[0]}</td>
        </tr>
    </c:forEach>
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
