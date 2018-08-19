<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script language="javascript">
	function validateLogin() {
		var userName = document.frmLogin.username.value;
		var password = document.frmLogin.password.value;
		if ((userName == "") || (userName == "输入您的用户名")) {
			alert("请输入用户名!");
			return false;
		}
		if ((password == "") || (password == "输入您的密码")) {
			alert("请输入密码!");
			return false;
		}
	}
</script>
<body>
	<center>
		<font face="楷体" size="6" color="#000">登录界面</font>
		<form action="CheckLogin.jsp" method="post" name="frmLogin">
			<table width="300" height="180" border="5" bordercolor="#A0A0A0">
				<tr>
					<th>用户名：</th>
					<td><input type="text" name="username" value="输入您的用户名"
						maxlength="16"
						onfocus="if(this.value == '输入您的用户名') this.value =''"></td>
				</tr>
				<tr>
					<th>密 码：</th>
					<td><input type="text" name="password" value="输入您的密码"
						maxlength="20" onfocus="if(this.value == '输入您的密码') this.value =''"></td>
				</tr>
				<tr>
					<!-- 当点击登录则需要在CheckLogin.jsp进行判断,点击注册会跳转到注册界面 -->
					<td colspan="2" align="center"><input type="submit" value="登录"
						onclick="return validateLogin()"> <input type="button"
						value="注 册" onclick="window.open('register.jsp')"> <input
						type="reset" value="重  置"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>