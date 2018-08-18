<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String test = request.getParameter("test"); // 
		System.out.println(test+"test");

		Map<String,String[]> maps=request.getParameterMap();
		for (Map.Entry<String,String[]> entry:maps.entrySet()){
			for (String i : entry.getValue()){
		System.out.println("Key = " + entry.getKey() + ", Value = " + i);
			}
		}
		String l=request.getParameter("name1");
		System.out.println(l+"name1");
		request.setAttribute("firstDir", test);

		//response.sendRedirect("upload.jsp");
		request.getRequestDispatcher("upload_menu.jsp").forward(request, response);
	%>
</body>
</html>