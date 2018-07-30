<%@ page import="ru.job4j.httpprotocol.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>login</td>
            <td>email</td>
            <td>Date of created</td>
        </tr>
        <% for (User el : (List<User>) request.getAttribute("users")) {
        %>
        <tr>
            <td><%= el.getId()%></td>
            <td><%= el.getName()%></td>
            <td><%= el.getLogin()%></td>
            <td><%= el.getEmail()%>l</td>
            <td><%= el.getCreateDate()%></td>
        </tr>
        <%
        }
        %>
    </table>

</body>
</html>