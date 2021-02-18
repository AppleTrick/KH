<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
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
<%
	// object 파일로 받는다.
	// 형변환의 이유 부모타입은 자식의 객체를 받을 수 있지만 자식타입은 부모 타입을 받을 수 있다.
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");
%>
<body>
	<h1>List</h1>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>			
		</tr>
		
		<%
		
		for(MVCBoardDto dto :list){
		
		%>
		<tr>
			<th><%=dto.getSeq() %></th>
			<th><%=dto.getWriter() %></th>
			<th><a href=""><%=dto.getTitle() %></a></th>
			<th><%=dto.getRegdate() %></th>
		</tr>
		<%
		}
		%>
		
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='mycontroller.jsp?command=insertform'">
			</td>
		</tr>
	</table>

</body>
</html>