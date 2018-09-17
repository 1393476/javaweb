package com.runoob.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileTree {

	public FileTree() {

	}

	static String spaceStr = "<a href = \"http://192.168.222.141:8080/test_tomcat/HelloServlet?";
	static String css = "<style type=\"text/css\">#top,#bottom{clear:both;width:100%;height:auto;padding:20px 0;}</style>";
	public static String tree(File f, String[] parameter,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		String tree = "<div id = \"top\" align=\"center\"><h1>MEUN</h1></div><div><table width=\"1400\"  border=\"1\" align=\"center\">";
		int j;

		for (j = 0; j < 6; j++) {
			if (parameter[j] != null) {

				if (parameter[j].equals("000")) {
					break;
				}
			}
		}
		
		File[] childs = f.listFiles(); // key point!
		int m=0;
		if (childs==null) {
			File parent=f.getParentFile();
			File[] parChilds=parent.listFiles();
			//设置上下页的路径
			String pre="";
			String next="";
			int cur=0;
			for (File file : parChilds) {
				if (file.getAbsoluteFile().equals(f.getAbsoluteFile())) {			
					break;
				}
				cur++;
			}
			
			if (cur==0 && cur!=(parChilds.length-1)) {
				next=parChilds[cur+1].getAbsolutePath();
			}else if (cur>0 && cur==(parChilds.length-1)) {
				pre=parChilds[cur-1].getAbsolutePath();
			}else {
				next=parChilds[cur+1].getAbsolutePath();
				pre=parChilds[cur-1].getAbsolutePath();
			}
			//System.out.println("cur-----------"+f.getAbsolutePath()+"--"+pre+"----"+next);
			//System.out.println(f.getAbsolutePath()+"-----path");
			//response.addHeader("path", f.getAbsolutePath());
			String path=f.getAbsolutePath();
			if (pre!=null) {
				FileInputStream input = new FileInputStream(pre);
				FileOutputStream output = new FileOutputStream(
						"/home/wangning/000.jpg");
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
				}
				output.flush();
				output.close();
				input.close();
			}
			if (next!=null) {
				FileInputStream input = new FileInputStream(next);
				FileOutputStream output = new FileOutputStream(
						"/home/wangning/002.jpg");
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
				}
				output.flush();
				output.close();
				input.close();
			}
			if(path!=null){			
				FileInputStream input = new FileInputStream(path);
				FileOutputStream output = new FileOutputStream(
						"/home/wangning/001.jpg");
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
				}
				output.flush();
				output.close();
				input.close();
			}
			response.sendRedirect("http://localhost:8080/AB_/jsp/index_1.jsp?path="+f.getAbsolutePath());
			
			return f.getAbsolutePath();
		}
		for (int i = 0; i < childs.length; i++) { // 构造第i个文件的超链接
			//System.out.println("111111111111");
			parameter[j] = childs[i].getName();

			if(m==0){
				tree = tree + "<tr align=\"center\" valign=\"middle\" height=\"50\">";
			}
			String name = "0123456789";
			if(childs[i].getName().length()>=10){
				name = childs[i].getName().substring(0, 5);
			
			tree = tree + "<td width=\"200\" bgcolor=\"#FFFFFF\">" + spaceStr
					+ "param0=" + parameter[0] +"&"
					+ "param1=" + parameter[1] +"&"
					+ "param2=" + parameter[2] +"&"
					+ "param3=" + parameter[3] +"&"
					+ "param4=" + parameter[4] +"\">" + name + "...." + "</a></td>";}
			else{
				tree = tree + "<td width=\"200\" bgcolor=\"#FFFFFF\">" + spaceStr
						+ "param0=" + parameter[0] +"&"
						+ "param1=" + parameter[1] +"&"
						+ "param2=" + parameter[2] +"&"
						+ "param3=" + parameter[3] +"&"
						+ "param4=" + parameter[4] +"\">" + childs[i].getName() + "</a></td>";
			}
			
			if(m==5){
				tree = tree +"</tr>";
				m=-1;
			}
		}
		if(m<4){
			tree= tree +"</tr>";
			}
		tree = tree + "</table></div>";
		tree = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><title></title>"+css+"</head><body bgcolor=\"#87CEEB\">"+tree+"</body></html>";
		return tree;
		}
		

	
}
