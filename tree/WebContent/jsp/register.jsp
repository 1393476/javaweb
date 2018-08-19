<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script>
	function addCheck() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var newword = document.getElementById("newword").value;
		if (username == "") {
			alert("用户名不能为空!");
			document.getElementById("username").focus();
			return false;
		}
		if (password == "") {
			alert("密码不能为空!");
			document.getElementById("password").focus();
			return false;
		}
		if (password != newword) {
			alert("两次输入密码不相同!");
			document.getElementById("newword").focus();
			return false;
		}
	}
	function validate() {
		var flag = addCheck();
		if (flag == false)
			return false;
		return true;
	}
</script>
<body>
	<center>
		<font face="楷体" size="6" color="#000">注册界面</font>
		<form action="CheckRegister.jsp" method="post"
			onsubmit="return validate()">
			<table width="300" height="180" border="5" bordercolor="#A0A0A0">
				<tr>
					<th>用户名：</th>
					<td><input type="text" name="username" value="输入16个字符以内"
						maxlength="16"
						onfocus="if(this.value == '输入16个字符以内') this.value =''"></td>
				</tr>
				<tr>
					<th>输入密码：</th>
					<td><input type="text" name="password" value="输入20个字符以内"
						maxlength="20"
						onfocus="if(this.value == '输入20个字符以内') this.value =''"></td>
				</tr>
				<tr>
					<th>确认密码：</th>
					<td><input type="text" name="newword" value="请再次输入密码"
						maxlength="20"
						onfocus="if(this.value == '请再次输入密码') this.value =''"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="注  册"> <input type="reset" value="重  置"></td>
				</tr>
			</table>
		</form>
	</center>
	
</body>
</html>