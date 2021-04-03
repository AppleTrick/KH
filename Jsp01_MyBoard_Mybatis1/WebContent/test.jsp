<%@page import="com.board.dao.MyBoardDao"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.board.dto.MyBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
a:link {
   text-decoration: none;
   color: black;
}

a:visited {
   text-decoration: none;
   color: black;
}
</style>
</head>
<body>

   <h1>글 전체 보기</h1>

   <article>
      <table border="1px">
         <col width="70px">
         <col width="100px">
         <col width="300px">
         <col width="300px">

         <thead>
            <tr>
               <td colspan="4" align="right"><input type="button" value="글쓰기"
                  onclick="location.href='./myinsert.jsp'"></td>
            </tr>



            <tr>
               <th>글번호</th>
               <th>작성자</th>
               <th>제목</th>
               <th>작성 날짜</th>
            </tr>


            <%
               MyBoardDao dao = new MyBoardDao();
            List<MyBoardDto> list = dao.selectList();
			int count = 0;
            for (count = 0; count < 50; count++) {
            %>
            <tr>
               <td><%=list.get(count).getNo() %></td>
               <td><%=list.get(count).getWriter()%></td>
               <td><a href="myselect.jsp?seq=<%=list.get(count).getNo()%>"><%=list.get(count).getTitle()%></a></td>
               <td><%=list.get(count).getDate()%></td>
            </tr>
         </thead>
         <%
            }
         %>
         <tbody id="addpage">
         </tbody>
      </table>
   </article>
   
   <script type="text/javascript">

   var newBody = document.getElementById("addpage");
   
   var data = [];
   
   <%
   for(int a=50; a < list.size(); a++){
   %>
		var inputData = [];
		inputData.push(<%=list.get(a).getNo() %>);
		inputData.push("<%=list.get(a).getWriter()%>");
		inputData.push(<%=list.get(a).getNo()%>);
		inputData.push("<%=list.get(a).getTitle()%>");
		inputData.push("<%=list.get(a).getDate()%>");

		data.push(inputData);
   <%
   }
   %>
   
   console.log(data);
   
   console.log("스크립트 카운트 " + ScriptCount);
 
   var a = window.innerHeight;
   var b = window.scrollY;
   var c = document.body.offsetHeight;
   
   window.onscroll = function(){
      if((window.innerHeight + window.scrollY) >= document.body.offsetHeight ){
    	//window.innerHeight 브라우저에서 실제로 표시되고 있는 영역의 높이 
        //window.scrolly 스크롤이 세로로 얼마나 이동했는지를 px로 나타냄 0부터 시작해서 스크롤 내릴수록 증가
        //offsetheight 요소의 실제 높이 = 보이는 높이 + 가려진 영역
         
    	console.log(a,b,c); 
        createRow();
        <% count = count + 1; %>
      }
   }
	   
	   function createRow(){	    	  
	     	 
	       var tr = document.createElement("tr");
	       var td = document.createElement("td");

	       newBody.append(tr);
	   } 
   
   
   </script>
</body>
</html>