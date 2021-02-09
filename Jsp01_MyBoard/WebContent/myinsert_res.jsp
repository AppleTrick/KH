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

	String myname = request.getParameter("myname");
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyBoardDto dto = new MyBoardDto();
	dto.setMyname(myname);
	dto.setMytitle(mytitle);
	dto.setMycontent(mycontent);
	
	MyBoardDao dao = new MyBoardDao();
	
	int res = dao.insert(dto);
	//res > 0 
	//insert라는 메소드가 정확히 동작했다.
	
	if(res>0){
%>

	<script>
		alert("글쓰기 성공!");
		location.href="mylist.jsp";
	</script>

<%
	}else{
		
%>
	<script>
		alert("글쓰기 실패");
		location.href="mylist.jsp";
	</script>

<%
	}
%>
</body>
</html>