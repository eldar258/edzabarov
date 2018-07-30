<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
        <form action="./edit" method="post">
            <input type=hidden name="id" value=<%= request.getParameter("id")%>>
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