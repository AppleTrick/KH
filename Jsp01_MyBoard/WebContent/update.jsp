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
	
	<h1> 글 작성</h1>
	
	<form action="update_res.jsp" method="post">
		<input type="hidden" name="no" value="<%=dto.getNo() %>">
		<span> 작성자 : <%=dto.getWriter() %> </span>
		<br>
		<span> 제목 </span>
		<input type="text" name="title" value="<%=dto.getTitle() %>>">
		<br>
		<span> 내용 </span>
		<textarea rows="10" cols="60" name="content"> <%=dto.getContent() %></textarea>
		<br>
		<input type="submit" value="작성">
		<input type="button" value="취소" onclick="">
	</form>
</body>
</html>