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
	
	<h1>글 내용</h1>
	<form action="insert_res.jsp" method="post">
	<table>
		<col width="100px">
		<col width="700px">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		<tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer"></td>
		<tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" cols="60" name="content"></textarea></td>
		<tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="글작성하기" onclick="">
				<input type="button" value="목록으로" onclick="location.href='./boardlist.jsp'">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>