<%@page import="com.board.dao.MyBoardDao"%>
<%@page import="com.board.dto.MyBoardDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	
		int no = Integer.parseInt(request.getParameter("no"));
		MyBoardDao dao = new MyBoardDao();
		MyBoardDto dto = dao.selectOne(no);
		
	%>
	
	<h1> �� �ۼ�</h1>
	
	<form action="update_res.jsp" method="post">
		<input type="hidden" name="no" value="<%=dto.getNo() %>">
		<span> �ۼ��� : <%=dto.getWriter() %> </span>
		<br>
		<span> ���� </span>
		<input type="text" name="title" value="<%=dto.getTitle() %>>">
		<br>
		<span> ���� </span>
		<textarea rows="10" cols="60" name="content"> <%=dto.getContent() %></textarea>
		<br>
		<input type="submit" value="�ۼ�">
		<input type="button" value="���" onclick="">
	</form>
</body>
</html>