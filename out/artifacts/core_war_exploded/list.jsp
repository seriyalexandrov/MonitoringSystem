<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>

<h3>All users:</h3>(<a href="add">add</a>)
<ol>
  <c:forEach items="${users}" var="user">
    <li>
        ${user.userName} - ${user.password}
      <a href="add?edit=${user.userId}">edit</a> | <a href="delete?id=${user.userId}">delete</a>
    </li>
  </c:forEach>
</ol>
</body>
</html>
