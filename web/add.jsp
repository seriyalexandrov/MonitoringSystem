
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addition | Editing</title>
</head>
<body>
<form action="add" method="post">
    <label for="userName" >Enter name:
        <input type="text" id="userName" value="${user.userName}" name="userName"/>
    </label> <br/>
    <label for="password">Enter password:
        <input type="text" id="password" value="${user.password}" name="password"/>
    </label> <br/>
    <input type="hidden" name="userId" value="${user.userId}"/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
