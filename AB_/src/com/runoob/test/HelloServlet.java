package com.runoob.test;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 使用 GBK 设置中文正常显示

		//response.setCharacterEncoding("GBK");

		String parameter[] = { "000", "000", "000", "000", "000","000" };
		String path = "/home/wangning/";
		int i;
		String htmlName=request.getParameter("name");
		System.out.println(htmlName+"------------html222222");
		for (i = 0; i < 6; i++) {
			parameter[i] = request.getParameter("param" + i);
			//System.out.println(parameter[i]+"----parameter");
			if (parameter[i]!=null) {
				if (parameter[i].equals("000"))
					break;
				path = path + "/" + parameter[i];
				//System.out.println(path+"-----path");
			}
		}
		//System.out.println(i);

		File f = new File(path);
		String menu = FileTree.tree(f, parameter,request,response,htmlName);
		//System.out.println(menu+"--menu");
		HttpSession session = request.getSession();
		String nameString=(String) session.getAttribute("username");
		response.setContentType("text/HTML; charset=utf-8");
		response.getWriter().print(
				"<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"pageEncoding=\"UTF-8\"%><html><head></head><body>" +"<div style='text-align:center'>"+nameString+"</div>"+ menu + "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("aaaaaaaaaaaaaaaaaaa");
		//System.out.println(request.toString());
		doGet(request, response);
	}

}