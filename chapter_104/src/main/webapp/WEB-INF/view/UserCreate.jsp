<%--
  Created by IntelliJ IDEA.
  User: 9eldi
  Date: 02.08.2018
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
<h2>Create User</h2>
    <div>
        <form action="./create" method="post">
            <p><b>Role</b></p>
            <select name="role">
                <option value="user">User</option>
                <option value="moderator">Moderator</option>
                <option value="administrator">Administrator</option>
            </select>
            <p><b>Login</b></p>
            <input type="text" name="txtName" />
            <p><b>Password</b></p>
            <input type="password" name="password" />
            <input type="submit" value="register" />
        </form>
    </div>
<h2>You already have an account?</h2>
    <form action="./singin" method="get">
        <input type="submit" value="sing in"/>
    </form>
</body>
</html>