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
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MyBoardDto dto = new MyBoardDto();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setNo(no);
		
		MyBoardDao dao = new MyBoardDao();
		
		int res = dao.update(dto);
		
		if(res > 0){
	
	%>
		<script type="text/javascript">
			alert("내용 수정 성공");
			location.href="list.jsp"
		</script>
	<%
		} else {
	%>
		<script type="text/javascript">
			alert("내용 수정 실패");
			location.href="list.jsp"
		</script>
	<%
		}
	%>
</body>
</html>