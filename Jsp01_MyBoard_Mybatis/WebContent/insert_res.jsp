<%@page import="com.board.dao.MyBoardDaoOld"%>
<%@page import="com.board.dto.MyBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
		String writer = request.getParameter("writer");
			System.out.println(writer);
			String title = request.getParameter("title");
			System.out.println(title);
			String content = request.getParameter("content");
			System.out.println(content);
			
			MyBoardDto dto = new MyBoardDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			MyBoardDaoOld dao = new MyBoardDaoOld();
			
			int res = dao.insert(dto);
			
			if(res > 0) {
	%>
		<script type="text/javascript">
			alert("글작성 완료");
			location.href="list.jsp"
		</script>
	
	<%
		} else {
	
	%>
		<script type="text/javascript">
			alert("글작성 실패");
			location.href="list.jsp"
		</script>
	
	<%
	
		}
	%>
</body>
</html>