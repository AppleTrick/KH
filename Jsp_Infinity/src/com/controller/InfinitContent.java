package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/infinitContent.do")
public class InfinitContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int infinityNumber = Integer.parseInt(request.getParameter("infinityNumber"));
		
		
		try {
			String resp = "";
			for (int i = 1; i <= 10; i++) {
				resp += "<p><span>"
						+ infinityNumber++
						+ "</span>  This is the dynamic content served freshly from server </p>";
			}
			out.write(resp);
		} catch (Exception e) {
			// TODO: handle exception
			out.close();
		}
	}

}
