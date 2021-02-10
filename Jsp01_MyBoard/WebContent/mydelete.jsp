<%@page import="com.myboard.dao.MyBoardDao"%>
<%@page import="com.myboard.dto.MyBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int myno = Integer.parseInt(request.getParameter("myno"));
	
	MyBoardDao dao = new MyBoardDao();
	int res = dao.delete(myno);
	
	if(res>0){
%>

	<script>
		alert("삭제 성공!");
		location.href="mylist.jsp";
	</script>

<%
	}else{
		
%>
	<script>
		alert("삭제");
		location.href="mylist.jsp";
	</script>

<%
	}
%>
</body>
</html>