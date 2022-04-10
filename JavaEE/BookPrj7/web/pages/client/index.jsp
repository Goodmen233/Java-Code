<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/26
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@include file="/pages/common/header.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <script>
        $(function () {
            $("#query").click(function () {
                var min = $("#min").val();
                var max = $("#max").val();
                if(min!="" && max!=""){
                    if(min > max) {
                        alert("输入有误");
                        return false;
                    }
                }
            });
            $(".addCart").click(function () {
                // $(this).attr("url") + "CartServlet
                $.getJSON("http://localhost:8080/BookPrj7/CartServlet", "action=addItem&id=" + $(this).attr("bookId"), function (data) {
                    // console.log(data);
                    $("#totalCount").text("您的购物车中有" + data.totalCount + "件商品");
                    $("#lastBookname").text(data.book);
                })
            });
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${sessionScope.user == null}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;
        </c:if>
        <c:if test="${sessionScope.user != null}">
            欢迎${sessionScope.user.username}光临
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/ClientBookServlet?action=pageByPrice" method="post">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input id="query" type="submit" value="查询" />
            </form>
        </div>
        <c:if test="${sessionScope.cart != null}">
            <div style="text-align: center">
                <span id="totalCount"></span>
                <div>
                    您刚刚将<span id="lastBookname" style="color: red"></span>加入到了购物车中
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.cart == null}">
            <div style="text-align: center">
                <span id="totalCount"></span>
                <div>
                    您刚刚将<span id="lastBookname" style="color: red"></span>加入到了购物车中
                </div>
            </div>
        </c:if>
        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}" />
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.bname}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button url="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" %>"
                                bookId="${book.id}" class="addCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <%@include file="/pages/common/page.jsp"%>
</div>
    <%@include file="/pages/common/footer.jsp"%>
</body>
</html>
