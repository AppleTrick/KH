<%@page import="com.board.dto.MyBoardDto"%>
<%@page import="com.board.dao.MyBoardDao"%>
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
		// 넘어온 값
		int no = Integer.parseInt(request.getParameter("no"));
		MyBoardDao dao = new MyBoardDao();
		MyBoardDto dto = dao.selectOne(no);
	%>
	<h1>글</h1>
	<h2> 글번호 : <%=dto.getNo() %></h2>
	<h2> 작성자 : <%=dto.getWriter() %></h2>
	<h2> 글제목 : <%=dto.getTitle() %></h2>
	<h2> 글 내용 </h2>
	<span style="width: 500px"><%=dto.getContent() %></span>
	<h2> 글 작성 시간 : <%=dto.getDate() %></h2>
	<button onclick="location.href='./update.jsp?no=<%=no%>'">수정</button>
	<button onclick="delete_check();">삭제</button>
	<button onclick="location.href='./list.jsp'">목록</button>
	<script type="text/javascript">
		function delete_check(){
			if (confirm("삭제하시겠습니까?")==true) {
				location.href="./delete.jsp?no=<%=no%>";
			}
		}
	</script>
</body>
</html>