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
<body>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao = new MDBoardDaoImpl();
	MDBoardDto dto = dao.selectOne(seq);
%>
	<h1>글 내용</h1>
	
	<table>
		<col width="100px">
		<col width="700px">
		<tr>
			<td>글 번호</td>
			<td><%=dto.getSeq() %></td>
		<tr>
		<tr>
			<td>제목</td>
			<td><%=dto.getTitle() %></td>
		<tr>
		<tr>
			<td>작성자</td>
			<td><%=dto.getWriter() %></td>
		<tr>
		<tr>
			<td>내용</td>
			<td><%=dto.getContent() %></td>
		<tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정하기" onclick="location.href='./updatelist.jsp?seq=<%=dto.getSeq() %>'">
				<input type="button" value="삭제하기" onclick="location.href='./deletelist.jsp?seq=<%=dto.getSeq() %>'">
				<input type="button" value="목록으로" onclick="location.href='./boardlist.jsp'">
			</td>
		</tr>
	</table>
</body>
</html>