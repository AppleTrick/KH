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
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MDBoardDto dto = new MDBoardDto();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		
		MDBoardDao dao = new MDBoardDaoImpl();
		int res = dao.insert(dto);
		
		if(res > 0) {
			
			%>
				<script type="text/javascript">
					alert("글작성 완료");
					location.href="boardlist.jsp"
				</script>
			
			<%
				} else {
			
			%>
				<script type="text/javascript">
					alert("글작성 실패");
					location.href="boardlist.jsp"
				</script>
			
			<%
			
				}
			%>
</body>
</html>