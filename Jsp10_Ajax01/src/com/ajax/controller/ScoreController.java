package com.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


@WebServlet("/ScoreController")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		int sum = kor + eng + math;
		double avg = (double)sum /3;
		
		
		
		// json - simple - 1.1.1 jar 파일에 존재
		// json object를 생성
		
		JSONObject obj = new JSONObject();
		obj.put("name",name);
		obj.put("sum",sum);
		obj.put("avg",String.format("%.2f", avg));
		
		//{"name" : name , "sum" : sum , "math" : math } 형태로 존재하게 된다.
		
		System.out.println("server에서 보내는 데이터 : " + obj.toJSONString());
		//toJSONString() : json 형식의 문자열로 만듬  - toJSONString 을 안할 경우 주소 값이 보내지게된다.
		
		PrintWriter out = response.getWriter();
		out.println(obj.toJSONString());
		// msg에 {"avg":"100.00","name":"박창희","sum":300} json 객체로 넘어간다 이는 dataType 의 형태로 지정된다.
		
		
		
	}

}
