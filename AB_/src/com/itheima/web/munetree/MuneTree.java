package com.itheima.web.munetree;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.MeunTreeUtils;

public class MuneTree extends HttpServlet {
	String first="";
	String sencodString="";
	String _3nd="";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pathString="";
		if (first!="") {
			pathString=first;
			if (sencodString!="") {
				pathString+="/"+sencodString;
				if (_3nd!="") {
					pathString+="/"+_3nd;
				}
			}
		} 
		String[] filenameStrings = null;
		if (pathString!="") {
			filenameStrings=MeunTreeUtils.firstDir(pathString);
		} else {
			System.out.println("目录树路径为空");
		}
		req.setAttribute("filenames", filenameStrings);
		req.getRequestDispatcher("/upload.jsp").forward(req, resp);
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doGet(req, resp);
	}

}
