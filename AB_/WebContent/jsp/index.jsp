<%@page import="com.itheima.domain.User"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WEB01</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>

</head>

<body>
	<div class="container-fluid">

		<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->
		<div class="container-fluid">

			<div class="col-md-3" style="padding-top: 20px">
				<ol class="list-inline">
					<c:if test="${empty user }">
						<li><a
							href="${pageContext.request.contextPath }/user?method=loginUI">登录</a></li>
						<li><a
							href="${pageContext.request.contextPath }/user?method=registUI">注册</a></li>
					</c:if>
					<c:if test="${not empty user }">
						<%=session.getAttribute("username")%>您好
							<li><a
							href="${pageContext.request.contextPath }/user?method=logout">退出</a></li>

					</c:if>

				</ol>
			</div>
		</div>
		
        <%-- aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		<%!public String path = null;%>
		<%
			path = request.getParameter("path");
		%>
		<%
			String path = request.getParameter("path");
			FileInputStream input = new FileInputStream(path);
			FileOutputStream output = new FileOutputStream(
					"/home/wangning/myworkspace/AB_/WebContent/jsp/001.jpg");
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = input.read(b)) != -1) {
				output.write(b, 0, len);
			}
			output.flush();
			output.close();
			input.close();
		%>  --%>
		<jsp:include page="upload.jsp" flush="ture">
			<jsp:param value="${path}" name="path" />
		</jsp:include>
        


	</div>
	</div>
</body>

</html>