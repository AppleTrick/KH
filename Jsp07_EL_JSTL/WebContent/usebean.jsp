<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text.html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<h1> useBean을 통한 객체 생성</h1>
		
		<!-- Score sc = new Score() 와 같은 뜻이다. -->
		<jsp:useBean id="sc" class="com.el.dto.Score" scope="session"></jsp:useBean>
		
		<!-- 해당 객체의 getter setter -->
		<!-- sc.setName("홍길동"); -->
		<jsp:setProperty property="name" name="sc" value="홍길동"/>
		<!-- sc.getName(); -->
		<jsp:getProperty property="name" name="sc"/>
		
		<button onclick="location.href='result.jsp'">result</button>
		
</body>
</html>