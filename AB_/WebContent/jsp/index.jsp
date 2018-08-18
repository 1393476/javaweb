<%@page import="com.itheima.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>WEB01</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		
	</head>

	<body>
		<div class="container-fluid">

			<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->
			<div class="container-fluid">
				
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<c:if test="${empty user }">
							<li><a href="${pageContext.request.contextPath }/user?method=loginUI">登录</a></li>
							<li><a href="${pageContext.request.contextPath }/user?method=registUI">注册</a></li>
						</c:if>
						<c:if test="${not empty user }">
							<%=session.getAttribute("username") %>您好
							<li><a href="${pageContext.request.contextPath }/user?method=logout">退出</a></li>
							
						</c:if>
					
					</ol>
				</div>
			</div>
		
		    <jsp:include page="upload_2.jsp" />
				
				
			</div>
		</div>
	</body>

</html>