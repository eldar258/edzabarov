<%--
  Created by IntelliJ IDEA.
  User: 9eldi
  Date: 02.08.2018
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<body>
<form action="./edit" method="post">
    <input type=hidden name="id" value="${id}">
    <table>
        <tr>
            <td>name</td>
        </tr>
        <tr>
            <input type="text" name="txtName" />
        </tr>
    </table>
    <input type="submit" />
</form>
</body>
</html>
