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
    <div>
        <form action="./create" method="post">
            <input type="text" name="txtName" />
            <input type="submit" />
        </form>
    </div>
</body>
</html>