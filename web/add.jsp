<%@ page import="com.kalashnikov.monitoring.entities.UsersEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addition | Editing</title>
</head>
<body>
<%
    UsersEntity user = (UsersEntity) request.getAttribute("user");
    String userName = "";
    String password = "";
    String userId = "";
    if(user != null){
        userName = user.getUserName();
        password = user.getPassword();
        userId =   Integer.toString(user.getUserId());
    }
%>
<form action="add" method="post">
    <label for="userName" >Enter name:
        <input type="text" id="userName" value="<%=userName%>" name="userName"/>
    </label> <br/>
    <label for="password">Enter password:
        <input type="text" id="password" value="<%=password%>"  name="password"/>
    </label> <br/>
    <label for="newSettingName">Enter setting name:
        <input type="text" id="newSettingName"  name="newSettingName"/>
    </label> <br/>
    <label for="newSettingValue">Enter setting value:
        <input type="text" id="newSettingValue"  name="newSettingValue"/>
    </label> <br/>
    <input type="hidden" name="userId" value="<%=userId%>"/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
