<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.FileWriter"%>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
<%! String websit="http://localhost:8080/AB_/jsp/tree2.jsp?";%>
<%! int fontSize=0; %>
<%! int number=0; %>
<%! String name; %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<style type="text/css">
#top,#bottom{
    clear:both;
    width:100%;
    height:auto;
    padding:20px 0;}
   
    
</style></head>
<body bgcolor="#87CEEB">
    <div id = "top" align="center">
        <h1>大智慧医疗数据库</h1>
    </div>
     <% System.out.println(request.getParameter("index"));%>
    <div>
        <table width="1400"  border="1" align="center">
        
        <%! %>
        <%!  int i;%>
        
        <%!  String path = "/home/wangning/";  %>
        
        
        <%   String parameter[] = {"000","000","000","000","000","000"}; 
             name = request.getParameter("name");      //通过login获取name
             System.out.println(name+"------------------------"+session.getAttribute("username"));
             
             
             for(i = 0 ; i <= 5 ; i++){
            	
            	parameter[i] = new String(request.getParameter("param" + i).getBytes(
            	        "ISO-8859-1"), "gbk");//request.getParameter("param" + i);
            	System.out.println(path+"---------------childpath----------------"+parameter[i]);
        	    if("000".equals(parameter[i]))
        		    break;
        	    path = path + "/" + parameter[i];
        	   
            }
            
            System.out.println("path is------:"+path); %>
            
        <%!  File file = null; %>
        <%!  File[] childs = null; %>
        <%!  int j=0,m=0;%>
        <%!  String short_name = "0123456789";%>
             
             
        <%   
             file = new File(path);
              
             childs =file.listFiles();
             if(childs!=null){
             System.out.println(path+"----------------2path"+childs.length);
             }
             if (childs == null) {
				
     			File parent = file.getParentFile();
     			File[] parChilds = parent.listFiles();
     			int cur = 0;
     			String pathString_1 = "/home/wangning/" + session.getAttribute("username") + "_path.txt";
     			FileWriter output_path = new FileWriter(pathString_1);
     			ArrayList<String> paths = new ArrayList<String>();
     			for (File file_1 : parChilds) {
     				paths.add(file_1.getAbsolutePath());
     				cur++;
     				output_path.write(file_1.getAbsolutePath() + "\n");

     			}
     			output_path.close();
     			String path_2 = file.getAbsolutePath();

     			if (path_2 != null) {
     				FileInputStream input = new FileInputStream(path);
     				String jpg_1 = "/home/wangning/" + session.getAttribute("username") + "_001.jpg";
     				FileOutputStream output = new FileOutputStream(jpg_1);
     				byte[] b = new byte[1024 * 5];
     				int len;

     				while ((len = input.read(b)) != -1) {
     					output.write(b, 0, len);
     				}
     				output.flush();
     				output.close();
     				input.close();
     				// 更新tmp下的目录
     				String tmp_1 = "/home/wangning/" + session.getAttribute("username") + "_tmppath.txt";
     				FileWriter fileWriter = new FileWriter(tmp_1);
     				fileWriter.write(file.getAbsolutePath());
     				fileWriter.close();
     			}
     			// request.setAttribute("path", f.getAbsolutePath());
     			// request.getRequestDispatcher("/index.jsp").forward(request,
     			// response);;
     			request.setAttribute("curPath", file.getAbsolutePath());
     			session.setAttribute("cur_Path", file.getAbsolutePath());
     			session.setAttribute("cur_paths", paths);	
     			//System.out.println(paths+"------------------------paths222222222"+f.getAbsolutePath()+session.getAttribute("username"));
     			path = "/home/wangning/";
     			response.sendRedirect("http://localhost:8080/AB_/jsp/index.jsp?path="
     				+ file.getAbsolutePath());
    			
     			return;
     			//request.getRequestDispatcher("/index.jsp").forward(request, response);
     			//return file.getAbsolutePath();
     		}
     		
        path = "/home/wangning/";
        
        
         for(j=0; j <= 5;j++){
			
			if("000".equals(parameter[j]))
			{
				break;
			}	
		}%>
        
        
        
        
        <%
        
        for (i = 0,m = 0; i < childs.length; i++,m++) {
        	
        	parameter[j]=childs[i].getName();
        	//System.out.print(parameter[j]);
        	if(m==0){%>
        	<tr align="center" valign="middle" height="50">
        	
        	<%}
        	
        	if(childs[i].getName().length()>=10){
        		short_name = childs[i].getName().substring(0, 5);%>
				<td width="200" bgcolor="#FFFFFF">
                    <a href = <%=websit
                            + "name=" + name + "&"
                            + "param0=" + parameter[0] +"&"
        					+ "param1=" + parameter[1] +"&"
        					+ "param2=" + parameter[2] +"&"
        					+ "param3=" + parameter[3] +"&"
        					+ "param4=" + parameter[4] +"&"
                        	+ "param5=" + parameter[5] %>><%=short_name+"..." %></a>
                </td>
       <%  	}else{  %>
        		<td width="200" bgcolor="#FFFFFF">
                    <a href = <%=websit
                            + "name=" + name + "&"
                            + "param0=" + parameter[0] +"&"
        					+ "param1=" + parameter[1] +"&"
        					+ "param2=" + parameter[2] +"&"
        					+ "param3=" + parameter[3] +"&"
        					+ "param4=" + parameter[4] +"&"
                			+ "param5=" + parameter[5] %>><%=childs[i].getName() %></a>
       <% 	}
        	
        	if(m == 5) m=-1;
            }
            m=0;file=null;childs=null;
            for(i = 0;i <= 5;i++){
            	parameter[i]="000";
            }%>

        </table>
    </div>
</body>
</html>