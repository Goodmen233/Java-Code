<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/header.jsp"%>
	<script>
		$(function () {
			$("#delA").click(function () {
				return confirm("你确定要删除" + $(this).parent().parent().find("td:first").text() + "吗");
			})
			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车吗");
			})
			$("#itemCount").change(function () {//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				var bname = $(this).parent().parent().find("td:first").text();
				var bookId = $(this).attr("bookId");
				var count = $(this).val();
				if(confirm("你确定要修改" + bname + "的数量为" + count + "吗？")){
					location.href=$(this).attr("url") +  "/CartServlet?action=updateCartItem&id=" + bookId + "&count=" + count;
				}else{
					$(this).val(this.defaultValue);
				}
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/loginSuccessHeader.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${sessionScope.cart != null}">
				<c:forEach items="${sessionScope.cart.items}" var="item">
					<tr>
						<td>${item.value.name}</td>
						<td><input url="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" %>"
								bookId = "${item.value.id}" id="itemCount" type="text" value="${item.value.count}" style="width: 50px"/></td>
						<td>${item.value.price}</td>
						<td>${item.value.totalPrice}</td>
						<td><a id="delA" href="CartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${sessionScope.cart == null}">
				<tr>
					<td colspan="5"><a href="#">你的购物车为空，点击进入首页浏览图书</a></td>
				</tr>
			</c:if>

		</table>
		<c:if test="${sessionScope.cart != null}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="CartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="OrderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>