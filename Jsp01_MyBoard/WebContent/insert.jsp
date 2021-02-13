<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용작성</title>
</head>
<body>
	<h1> 글 작성</h1>
	
	<!-- post인 이유 : queryString 이 허용범위 이상으로 길어지면 request 불가  -->
	<form action="insert_res.jsp" method="post">
		<span> 작성자 </span>
		<input type="text" name="writer">
		<br>
		<span> 제목 </span>
		<input type="text" name="title">
		<br>
		<span> 내용 </span>
		<textarea rows="10" cols="60" name="content"></textarea>
		<br>
		<input type="submit" value="작성">
		<input type="button" value="취소" onclick="">
	</form>
</body>
</html>