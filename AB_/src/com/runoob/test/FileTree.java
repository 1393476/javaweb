package com.runoob.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FileTree {

	public FileTree() {

	}

	static String spaceStr = "<a href = \"http://192.168.222.141:8080/AB_/TomcatTest/HelloServlet?";
	static String css = "<style type=\"text/css\">#top,#bottom{clear:both;width:100%;height:auto;padding:20px 0;}</style>";

	public static String tree(File f, String[] parameter,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tree = "<div id = \"top\" align=\"center\"><h1>MEUN</h1></div><div><table width=\"1400\"  border=\"1\" align=\"center\">";
		int j;
		HttpSession session = request.getSession();
		String usrename = (String) session.getAttribute("username");
		System.out.println(usrename + "------------------name wai");

		for (j = 0; j < 6; j++) {
			if (parameter[j] != null) {

				if (parameter[j].equals("000")) {
					break;
				}
			}
		}

		File[] childs = f.listFiles(); // key point!
		int m = 0;
		if (childs == null) {
			System.out.println(usrename + "------------------name nei");
			File parent = f.getParentFile();
			File[] parChilds = parent.listFiles();
			int cur = 0;
			String pathString_1 = "/home/wangning/" + usrename + "_path.txt";
			FileWriter output_path = new FileWriter(pathString_1);
			ArrayList<String> paths = new ArrayList<>();
			for (File file : parChilds) {
				paths.add(file.getAbsolutePath());
				cur++;
				output_path.write(file.getAbsolutePath() + "\n");

			}
			output_path.close();
			String path = f.getAbsolutePath();

			if (path != null) {
				FileInputStream input = new FileInputStream(path);
				String jpg_1 = "/home/wangning/" + usrename + "_001.jpg";
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
				String tmp_1 = "/home/wangning/" + usrename + "_tmppath.txt";
				FileWriter fileWriter = new FileWriter(tmp_1);
				fileWriter.write(f.getAbsolutePath());
				fileWriter.close();
			}
			// request.setAttribute("path", f.getAbsolutePath());
			// request.getRequestDispatcher("/index.jsp").forward(request,
			// response);;
			request.setAttribute("curPath", f.getAbsolutePath());
			session.setAttribute("cur_Path", f.getAbsolutePath());
			session.setAttribute("cur_paths", paths);	
			//System.out.println(paths+"------------------------paths222222222"+f.getAbsolutePath()+session.getAttribute("username"));
			response.sendRedirect("http://localhost:8080/AB_/jsp/index.jsp?path="
				+ f.getAbsolutePath());
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			return f.getAbsolutePath();
		}
		
		
		for (int i = 0; i < childs.length; i++) { // 构造第i个文件的超链接
			// System.out.println("111111111111");
			// System.out.println("errror------------"+ childs[i].getName());
			parameter[j] = childs[i].getName();

			if (m == 0) {
				tree = tree
						+ "<tr align=\"center\" valign=\"middle\" height=\"50\">";
			}
			String name = "0123456789";
			if (childs[i].getName().length() >= 10) {
				name = childs[i].getName().substring(0, 5);

				tree = tree + "<td width=\"200\" bgcolor=\"#FFFFFF\">"
						+ spaceStr + "param0=" + parameter[0] + "&" + "param1="
						+ parameter[1] + "&" + "param2=" + parameter[2] + "&"
						+ "param3=" + parameter[3] + "&" + "param4="
						+ parameter[4] + "\">" + name + "...." + "</a></td>";
			} else {
				tree = tree + "<td width=\"200\" bgcolor=\"#FFFFFF\">"
						+ spaceStr + "param0=" + parameter[0] + "&" + "param1="
						+ parameter[1] + "&" + "param2=" + parameter[2] + "&"
						+ "param3=" + parameter[3] + "&" + "param4="
						+ parameter[4] + "\">" + childs[i].getName()
						+ "</a></td>";
			}

			if (m == 5) {
				tree = tree + "</tr>";
				m = -1;
			}
		}
		if (m < 4) {
			tree = tree + "</tr>";
		}
		tree = tree + "</table></div>";
		tree = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><title></title>"
				+ css
				+ "</head><body bgcolor=\"#87CEEB\">"
				+ tree
				+ "</body></html>";
		return tree;
	}
}
