package com.zout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.itheima.web.servlet.BaseServlet;

/**
 * Servlet implementation class UploadServlet
 */
public class nextServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------- postnextservlet");
		HttpSession session = request.getSession();
		// String usrename = (String) session.getAttribute("username");
		String usrename = request.getParameter("user");
		System.out.println(usrename
				+ "-----------------------name11111111111111");
		String pathString_1 = "/home/wangning/" + usrename + "_path.txt";
		String jpg_1 = "/home/wangning/" + usrename + "_001.jpg";
		String tmp_1 = "/home/wangning/" + usrename + "_tmppath.txt";

		FileReader tmpfileReader = new FileReader(tmp_1);
		FileReader pathfileReader = new FileReader(pathString_1);
		BufferedReader pathBufferedReader = new BufferedReader(pathfileReader);
		BufferedReader tmpBufferedReader = new BufferedReader(tmpfileReader);
		String line = "";
		String tmp = tmpBufferedReader.readLine();
		String res = null;
		while ((line = pathBufferedReader.readLine()) != null) {
			if (tmp != null && tmp.equals(line)) {
				res = pathBufferedReader.readLine();
				// System.out.println(res+"-----------res---------------"+tmp);
			}
		}
		//
		if (res == null) {
			// 最后一张
			response.sendRedirect("http://localhost:8080/AB_/jsp/index.jsp?path="
					+ "last");
			return;
		}
		pathBufferedReader.close();
		tmpBufferedReader.close();
		pathfileReader.close();
		tmpfileReader.close();
		// 更新tmp下的目录
		FileWriter fileWriter = new FileWriter(tmp_1);
		fileWriter.write(res);
		fileWriter.close();
		// 复制图片
		FileInputStream input = new FileInputStream(res);

		File oldFile = new File(jpg_1);
		if (oldFile.exists()) {
			oldFile.delete();
		}
		FileOutputStream output = new FileOutputStream(oldFile);
		byte[] b = new byte[1024 * 2];
		int len;
		while ((len = input.read(b)) != -1) {
			output.write(b, 0, len);
		}
		FileDescriptor fd = output.getFD();
		fd.sync();
		output.flush();
		output.close();
		input.close();

		// request.("path", res);
		// request.setAttribute("path", res);
		// request.getRequestDispatcher("/index.jsp").forward(request,
		// response);
		// --response.sendRedirect("http://localhost:8080/AB_/jsp/index.jsp?path="+res);
		// System.out.println("111111111111111111111"+response.toString());
		response.addHeader("status","200");
		response.getWriter().print(
				"This is some text from an external ASP file.");
		return;

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("--------------- getnextservlet");
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doPost(req, resp);
	}
}