<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
<ol>
  <c:forEach items="${users}" var="user">
    <li>
        ${user.userName}
      <a href="add?edit=${user.userId}">edit</a> | <a href="delete?id=${user.userId}">delete</a>
    </li>
  </c:forEach>
</ol>
</body>
</html>
