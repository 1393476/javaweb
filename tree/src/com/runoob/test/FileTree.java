package com.runoob.test;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileTree {

	public FileTree() {

	}

	static String spaceStr = "<a href = \"http://192.168.222.141:8080/test_tomcat/HelloServlet?";

	public static String tree(File f, String[] parameter,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		String tree = "";
		int j;

		for (j = 0; j < 6; j++) {
			if (parameter[j] != null) {

				if (parameter[j].equals("000")) {
					break;
				}
			}
		}

		File[] childs = f.listFiles(); // key point!
		if (childs==null) {
			System.out.println(f.getAbsolutePath()+"-----path");
			//response.addHeader("path", f.getAbsolutePath());
			response.sendRedirect("http://localhost:8080/AB_/jsp/index_1.jsp?path="+f.getAbsolutePath());
			
			return f.getAbsolutePath();
		}
		for (int i = 0; i < childs.length; i++) { // 构造第i个文件的超链接
			//System.out.println("111111111111");
			parameter[j] = childs[i].getName();

			tree = tree + spaceStr + "param0=" + parameter[0] + "&" + "param1="
					+ parameter[1] + "&" + "param2=" + parameter[2] + "&"
					+ "param3=" + parameter[3] + "&" + "param4=" + parameter[4]+ "&" + "param5=" + parameter[5]
					+ "\">" + childs[i].getName() + "</a><br>";

		}
		return tree;

	}
}
