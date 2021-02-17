<%@page import="com.dao.MDBoardDaoImpl"%>
<%@page import="com.dao.MDBoardDao"%>
<%@page import="com.dto.MDBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	MDBoardDto dto = new MDBoardDto();
	MDBoardDao dao = new MDBoardDaoImpl();
	dto = dao.selectOne(seq);
	
%>
<body>
	<h1>글 내용</h1>
	<form action="updatelist_res.jsp" method="post">
	<input type="hidden" name="seq" value="<%=dto.getSeq() %>">
	<table>
		<col width="100px">
		<col width="900px">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
		<tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" readonly="readonly" value="<%=dto.getWriter() %>"></td>
		<tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" cols="60" name="content"><%=dto.getContent()%></textarea></td>
		<tr>
		<tr> 
			<td colspan="2">
				<input type="submit" value="글수정하기">
				<input type="button" value="목록으로" onclick="location.href='./boardlist.jsp'">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>