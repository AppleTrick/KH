<%@page import="com.cal.dto.CalDto"%>
<%@page import="java.util.List"%>
<%@page import="com.cal.dao.CalDao"%>
<%@page import="com.cal.common.Util"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text.html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	#calendar {
		board-collapse : collapse;
		border : 1px solid gray;
	}
	
	#calendar th{
		width: 80px;
		border: 1px solid gray;
	}
	
	#calendar td{
		width : 80px;
		height: 80px;
		border : 1px solid gray;
		text-align: left;
		vertical-align : top;
		position : relative;
	}
	a{
		text-decoration: none;
	}
	.list > p {
	
		font-size : 5px;
		margin: 1px;
		background-color : skyblue;
	}
	
	.preview {
		position : absolute;
		top : -30px;
		left : 10px;
		background-color: skyblue;
		width: 40px;
		height: 40px;
		text-align: center;
		line-height: 40px;
		border-radius : 40px 40px 40px 1px;
	}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function isTwo(n) {
		return (n.length<2) ? "0"+n : n;
	}
	
	$(function () {
		$(".countview").hover(function () {
			console.log("hover 작동");
			// handle in
			var countView = $(this); // i 값
			var year = $(".y").text().trim();
			var month = $(".m").text().trim();
			var date = countView.text().trim();
			var yyyyMMdd = year + isTwo(month) + isTwo(date);
			
			
			$.ajax({
				type: "post",
				url : "count.do?id=kh&yyyyMMdd="+yyyyMMdd,
				dataType : "json",
				async : false,
				success : function (msg) {
					var count = msg.calcount;
					countView.after("<div class='preview'>"+count+"</div>");
				},
				error : function () {
					alert("통신 실패");
				}
			})
		},
		function name() {
			// handle out
			$(".preview").remove();
		})
		
	})

</script>


</head>
<body>

<%
	Calendar cal = Calendar.getInstance();

	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	
	String paramYear = request.getParameter("year");
	// 처음에 널 값이 들어옴, 달력 버튼 바뀔때 값이 들어오게됨
	if(paramYear != null){	// null 이 아닐경우 달력에 year을 바꿈
		year = Integer.parseInt(paramYear);
	}
	System.out.println("1" + paramYear);
	
	String paramMonth = request.getParameter("month");
	// 처음에 널 값이 들어옴, 달력 버튼 바뀔때 값이 들어오게됨
	if(paramMonth != null){ // null 이 아닐경우 달력에 month를 바꿈
		month = Integer.parseInt(paramMonth);
	}	
	System.out.println("2" + paramMonth);
	
	
	if(month > 12){
		month = 1;
		year++;
	}
	// 달 초과할 경우
	
	if(month < 1){
		month = 12;
		year--;
	}
	// 달이 미만 날경우
	
	cal.set(year, month-1,1);
	// 달력의 값을 새롭게 새팅합니다. 년도 / 월 /  일
	
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	System.out.println("dayOfWeek : " + dayOfWeek);
	// 달력 시작 요일 요일
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	System.out.println("lastDay : " + lastDay);
	// 달력의 마지막날
	
	
	//========================================================
	CalDao dao = new CalDao();
	// dao 설정 설정
	
	String yyyyMM = year + Util.isTwo(String.valueOf(month));
	// yyyyMM 형시의 값을 뽑아준다.	
	
	List<CalDto> list= dao.getCalViewList("kh", yyyyMM);
	// id가 kh 이고 yyyyMM 은 현재페이지의 해당 연도월
	// 일 마다의 항목을 보여줌
	
	// sql 결과 값 어레이
	
	
%>
	<table id="calendar">
		<caption>
			<a href="calendar.jsp?year=<%=year-1%>&month=<%=month%>">◁</a>
			<a href="calendar.jsp?year=<%=year%>&month=<%=month-1%>">◀</a>
			
			<span class="y"><%=year %></span>년
			<span class="m"><%=month %></span>월
			
			<a href="calendar.jsp?year=<%=year%>&month=<%=month+1%>">▶</a>
			<a href="calendar.jsp?year=<%=year+1%>&month=<%=month%>">▷</a>
		</caption>
		<tr>
			<th>일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
		</tr>
		
		<!-- 달력값 시작하는부분 -->
		<tr>
		<%
			// 앞에 처음 빈칸 생성
			for(int i = 0; i <dayOfWeek-1;i++){
				out.print("<td></td>");
			}
			
		
			// 존재하는 값들을 생성
			for(int i = 1; i <= lastDay; i++){
		%>
			<td>
				<!-- 눌럿을 경우 일정을 보여주는 페이지 list.jsp 로 이동 -->
				<a class="countview" href="cal.do?command=list&year=<%=year %>&month=<%=month %>&date=<%=i %>" style="color : <%=Util.fontColor(i,dayOfWeek) %>"><%=i %></a>
				<!-- 눌럿을 경우 바로 추가해주는 페이지 insert.jsp 로 이동 -->
				<a href="insert.jsp?year=<%=year %>&month=<%=month %>&date=<%=i %>&lastDay=<%=lastDay %>">
					<!--  이미지는 덤... -->
					<img alt="" src="image/pen.png" style="width: 10px; height : 10px;">
				</a>
				
				
				
				<div class="list">
					<%=Util.getCalView(i, list) %>
					<!-- 결과적으로 여에 올수 있는 것은 html 내용 /  i는 날짜 list는 sql 결과 값을 가지고온 sql 결과값-->
				</div>
				
				
				
				
				
			</td>
		<%	// 토요일일 경우 한칸 tr 생성한다.
				if((dayOfWeek-1+i)%7 == 0){
					out.print("</tr><tr>");
				}
			}
			// 마지막 빈칸생성
			for( int i = 0; i < (7-(dayOfWeek -1 + lastDay)%7)%7; i++){
				out.print("<td></td>");
			}
		%>
		</tr>
		
	</table>
</body>
</html>