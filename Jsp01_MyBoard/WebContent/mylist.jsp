<%@page import="com.myboard.dto.MyBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.myboard.dao.MyBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- SCRIPTLET -->
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
	//객체 선언 밑 내용을 가지고옴
	
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectList();
%>
	<h1> 글 전체 보기</h1>
	<table border="1">
		<col width="50px"/>
		<col width="100px"/>
		<col width="300px"/>
		<col width="100px"/>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
<%
	// java 영역
		for(int i = 0; i<list.size(); i++){
%>
	<!-- html 영역 -->
		<tr>
			<td><%=list.get(i).getMyno()%></td>
			<td><%=list.get(i).getMyname()%></td>
			<td><a href="./myselect.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle()%></a></td>
			<td><%=list.get(i).getMydate()%></td>
		</tr>
<%
	//java 영역
		}
%>
	<tr>
		<td colspan="4" align="right">
			<button onclick="location.href='./myinsert.jsp'">글쓰기</button>
		</td>
	</tr>
	</table>

</body>
</html>