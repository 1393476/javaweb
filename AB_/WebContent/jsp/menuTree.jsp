<%@page import="com.runoob.test.FileTree"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%


response.setCharacterEncoding("GBK");

String parameter[] = { "LUNA2016/", "000", "000", "000", "000","000" };
String path = "/home/wangning/";
int i;

for (i = 0; i < 6; i++) {
	parameter[i] = request.getParameter("param" + i);
	System.out.println(parameter[i]+"----parameter");
	if(parameter[i]==null){
		break;
	}
	if (parameter[i]!=null) {
		if (parameter[i].equals("000"))
			break;
		path = path + "/" + parameter[i];
		System.out.println(path+"-----path");
	}
}
//System.out.println(i);

File f = new File(path);
String menu = FileTree.tree(f, parameter,request,response);
System.out.println(menu+"--menu");
String ab="<html><head></head><body>" +"<div style='text-align:center'>"+path+"</div>"+ menu + "</body></html>";
response.getWriter().write(
		"<html><head></head><body>" +"<div style='text-align:center'>"+path+"</div>"+ menu + "</body></html>");

out.print(ab);

%>

</body>
</html>