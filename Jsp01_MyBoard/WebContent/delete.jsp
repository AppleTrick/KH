<%@page import="com.board.dao.MyBoardDao"%>
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
		
		int res = dao.delete(no);
		
		if(res > 0 ) {
	%>
		<script type="text/javascript">
			alert("삭제 성공");
			location.href="./list.jsp";
		</script>
	
	<%
		} else {
	%>
		<script type="text/javascript">
			alert("삭제 실패");
			location.href="./list.jsp";
		</script>
	<%
		}
	
	%>
</body>
</html>