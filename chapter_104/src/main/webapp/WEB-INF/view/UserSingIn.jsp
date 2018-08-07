<%--
  Created by IntelliJ IDEA.
  User: 9eldi
  Date: 04.08.2018
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>SingIn</h2>
    <form name="singin" action="./singin" method="post">
        <p><b>Login</b></p>
        <input type="text" name="login" size="40" />
        <p><b>Password</b></p>
        <input type="password" name="password" size="40" />
        <input type="submit" value = "sing in"/>
    </form>
<h2>Do not have an account yet?</h2>
<form action="./create" method="get">
    <input type="submit" value="create"/>
</form>
</body>
</html>
