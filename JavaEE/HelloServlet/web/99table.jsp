<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/13
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <% for(int i = 1; i <= 9; i++){ %>
            <tr>
                <% for(int j = 1; j <= i; j++){ %>
                    <td> <%= j + "*" + i + "=" + (i*j) %> </td>
                <% } %>
            </tr>
        <% } %>
    </table>
</body>
</html>
