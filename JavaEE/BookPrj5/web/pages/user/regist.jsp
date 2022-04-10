<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@include file="/pages/common/header.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
	<script src="static/resource/jquery-3.5.1.min.js"></script>
	<script>
		$(function () {
			// 绑定按钮事件
			$("#sub_btn").click(function () {
				// 验证用户名，必须由字母、数字下划线组成，并且长度为5到12位
				var reg = /^\w{5,12}$/;
				var username = $("#username").val();
				if(! reg.test(username)){
					$(".errorMsg").text("用户名不合法");
					return false;
				}
				// 验证密码，必须由字母，数字下划线组成，并且长度为5到12位
				var reg = /^\w{5,12}$/;
				var pass = $("#password").val();
				if(! reg.test(pass)){
					$(".errorMsg").text("密码不合法");
					return false;
				}
				// 验证确认密码，
				var pass = $("#password").val();
				var repass = $("#repwd").val();
				if(! (pass == repass)){
					$(".errorMsg").text("两次密码不相同");
					return false;
				}
				// 邮箱验证，xxxxx@xxx.com
				var regExp = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
				var email = $("#email").val();
				if(! regExp.test(email)){
					$(".errorMsg").text("邮箱不合法");
					return false;
				}
				// 验证码，有输入就行
				var code = $("#code").val();
				if(code == "") {
					$(".errorMsg").text("验证码不正确");
					return false;
				}
				$("#errorMsg").text("");
			});
		})
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${empty requestScope.msg ?"请输入信息":requestScope.msg}</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<input type="hidden" name="action" value="regist" />
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
										   id="username" value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email"
										   id="email" value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>