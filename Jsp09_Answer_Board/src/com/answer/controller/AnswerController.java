package com.answer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.biz.AnswerBiz;
import com.answer.biz.AnswerBizImpl;
import com.answer.dto.AnswerDto;

/**
 * Servlet implementation class AnswerController
 */
@WebServlet("/AnswerController")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		AnswerBiz biz = new AnswerBizImpl();
		
		String command = request.getParameter("command");
		
		if(command.equals("list")) {
			
			
			List<AnswerDto> list = biz.selectList();
			
			request.setAttribute("list", list);
			
			dispatch(request, response, "boardlist.jsp");
		}
		
		response.getWriter().append("<a href='index.jsp'><h1>잘못왔다</h1></a>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
	private void jsResponse(HttpServletResponse response, String url, String msg) throws IOException {
		String s = "<script type='text/javascript'>" +
					"alert('" + msg + "');" +
					"location.href='" + url + "';" +
					" </script> ";
		
		response.getWriter().print(s);
					
	}

}
