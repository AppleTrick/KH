package com.mvc.controller;

import java.io.IOException;
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
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MVCBoardBiz biz = new MVCBoardBizImpl();
		
		String command = request.getParameter("command");
		System.out.println("[ " + command + " ]");
		
		if (command.equals("list")) {
			//1. 보내준 값 있으면 받기
			//2. db 호출 (전달할 값 있으면 전달)
			List<MVCBoardDto> list = biz.selectList();
			//3. 화면에 보내줄 값 있으면 request 객체에 담기
			request.setAttribute("list", list);
			//4. 보내기
			dispatch(request, response, "mylist.jsp");
			
		} else if(command.equals("insertform")) {
			//1
			//2
			//3
			//4.
			response.sendRedirect("myinsert.jsp");
		} else if(command.equals("insertres")) {
			//1.
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content =request.getParameter("content");
			//2.
			MVCBoardDto dto = new MVCBoardDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.insert(dto);
			//3.
			//4.
			if (res > 0) {
				// 무한요청을 막기위해서. sendRedirect 로..
//				request.setAttribute("list", biz.selectList());
//				dispatch(request, response, "mylist.jsp");
				response.sendRedirect("myservlet.do?command=list");
			} else {
//				response.sendRedirect("myinsert.jsp");
				response.sendRedirect("myservlet.do?command=insertform");
			}
		} else if(command.equals("selectone")) {
			//1. 보내준 값.
			int seq = Integer.parseInt(request.getParameter("seq"));
			//2. db 연결 , 값 전달 및 호출
			MVCBoardDto dto = biz.selectOne(seq);
			//3.
			request.setAttribute("dto", dto);
			//4. 보낸다.
			dispatch(request, response, "myselect.jsp");
		} else if(command.equals("updateform")) {
			//1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			//2.
			MVCBoardDto dto = biz.selectOne(seq);
			//3.
			request.setAttribute("dto", dto);
			//4
			dispatch(request, response, "myupdate.jsp");
		} else if(command.equals("updateres")) {
			//1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			//2.
			
			MVCBoardDto dto = new MVCBoardDto(seq,null,title,content,null);
			int res = biz.update(dto);
			
			//3.
			
			//4.
			
			if (res > 0) {
				response.sendRedirect("myservlet.do?command=selectone&seq="+seq);
			} else {
				response.sendRedirect("myservlet.do?command=updateform&seq="+seq);
			}
		} else if(command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int res = biz.delete(seq);
			
			if (res > 0) {
				response.sendRedirect("myservlet.do?command=list");
			} else {
				response.sendRedirect("myservlet.do?command=selectone&seq="+seq);
			}
		}
		
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}
