<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/24
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath }/show.jsp" method="post">
    姓名:<input type="text" name="name" /><br>
    年龄:<input type="text" name="age" /><br>
    <input type="checkbox" name="hobby" value="reading"> 阅读
    <input type="checkbox" name="hobby" value="climbing"> 爬山
    <input type="checkbox" name="hobby" value="swimming"> 游泳
    <input type="submit" value="register">
  </form>
  </body>
</html>
