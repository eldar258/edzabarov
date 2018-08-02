<%@ page import="ru.job4j.httpprotocol.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
    <table id = "customers">
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