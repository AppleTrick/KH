<%@page import="com.board.dto.MyBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.board.dao.MyBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    	// 자바 코드를 사용할 수 있는 방법
    %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		MyBoardDao dao = new MyBoardDao();
		List<MyBoardDto> list = dao.selectList();
	%>
	
	<h1>게시판</h1>
	
	<table border="1">
		<col width="50px">
		<col width="100px">
		<col width="300px">
		<col width="100px">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		<%
			for(int i = 0; i < list.size(); i++){
		%>
			<!--html 영역을 for문에 넣어서 반복한다.-->
			<!-- 값만 가지고 올때는 = 을 붙임으로써 자바에서 변수 하나만 가지고 올 수 있다. -->
		<tr>
			<td><%=list.get(i).getNo()%></td>
			<td><%=list.get(i).getWriter() %></td>
			<td><a href="./selectlist.jsp?no=<%=list.get(i).getNo()%>"><%=list.get(i).getTitle() %></a></td>
			<td><%=list.get(i).getDate() %></td>
		</tr>
		<%
			}
		%>
	
	</table>
	
	<button onclick="location.href='./insert.jsp'">글쓰기</button>
</body>
</html>