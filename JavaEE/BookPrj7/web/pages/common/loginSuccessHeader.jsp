<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/30
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
        <a href="OrderServlet?action=showMyOrders">我的订单</a>
        <a href="UserServlet?action=loginout">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</div>
