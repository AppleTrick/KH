<%@page import="com.myboard.dto.MyBoardDto"%>
<%@page import="com.myboard.dao.MyBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	//request.getParameter(key) :queryString 으로 넘어온 key = Value 의 형태에서, 넣어준 key에 맞는 value return
	// 클라이언트와 서버간의 데이터 교환은 모드 문자열로 통신하게 된다.
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(myno);
%>

<body>

	<h1>글쓰기</h1>
	<!-- 글 작성할때 post 인 이유 : queryString 이 허용범위 이상 길어지면 request불가 -->
	<form action="myupdate_res.jsp?myno=<%=dto.getMyno()%>" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname" value="<%=dto.getMyname() %>" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" value="<%=dto.getMytitle() %>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="mycontent"><%=dto.getMycontent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성">
					<input type="button" value="취소" onclick="">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>