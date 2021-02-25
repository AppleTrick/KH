package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MVCBoardBiz;
import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

/**
 * Servlet implementation class MVCController
 */
@WebServlet("/MVCController")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MVCBoardBiz biz = new MVCBoardBizImpl();
		
		String command = request.getParameter("command");
		System.out.println(command);
		
		if (command.equals("list")) {
			
			List<MVCBoardDto> list = biz.selectList();
			
			request.setAttribute("list", list);

			dispatch(request,response,"mvclist.jsp");
			
		} else if(command.equals("insert")) {
	
			response.sendRedirect("insert.jsp");
			
		} else if(command.equals("insertres")) {
			
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCBoardDto dto = new MVCBoardDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
					
			int res = biz.insert(dto);
			
			
			if (res > 0) {
				request.setAttribute("res", res);
				response.sendRedirect("mycontroller.do?command=list");
			} else {
				response.sendRedirect("insert.jsp");
			}
			
			
		} else if (command.equals("selectone")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCBoardDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "selectone.jsp");
			
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}
