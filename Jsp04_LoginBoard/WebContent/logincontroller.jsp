<%@page import="java.util.List"%>
<%@page import="com.login.dto.MYMemberDto"%>
<%@page import="com.login.biz.MYMemberBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text.html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	System.out.println("[" + command + "]");
	
	MYMemberBiz biz = new MYMemberBiz();
	
	if(command.equals("login")){
		
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYMemberDto dto = biz.login(myid,mypw);
		
		if(dto != null ){
			
			//session scope에 객체 담기
			session.setAttribute("dto", dto);
			//만료되는 시간 설정(defualt: 30분);
			session.setMaxInactiveInterval(10*60);
			// 음수면 무한..
			
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			} else if(dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}
			
		} else {
%>
		<script type="text/javascript">
			alert("로그인 실패");
			location.href="index.html";
		</script>
<%			
		}
	} else if(command.equals("logout")){
		// session scope에서 값 삭제 만료
		session.invalidate();
		
		response.sendRedirect("index.html");
		
	} else if(command.equals("listall")){
		List<MYMemberDto> list = biz.selectAllUser();
		
		request.setAttribute("list", list);
		
		pageContext.forward("userlistall.jsp");
	} else if(command.equals("listenabled")){
		List<MYMemberDto> list = biz.selectEnabledUser();
		
		request.setAttribute("list", list);
		
		pageContext.forward("userlisten.jsp");
		
	} else if(command.equals("updateroleform")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("updaterole.jsp");
		
	} else if(command.equals("updaterole")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		
		int res = biz.updateRole(myno, myrole);
		if(res > 0){
		%>
			<script type="text/javascript">
			alert("등급 변경 성공")
			location.href="logincontroller.jsp?command=listen";
			</script>
		<%	
			
		} else {
			
		%>
			<script type="text/javascript">
			alert("등급 변경 실패")
			location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
			</script>
		<%
		}
	} else if(command.equals("registform")){
		response.sendRedirect("regist.jsp");
	} else if(command.equals("idchk")){
		String myid = request.getParameter("myid");
		MYMemberDto dto = biz.idCheck(myid);
		
		boolean idnotused = true;
		
		if(dto.getMyid() != null){
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
	}
		
		
%>


	<h1 style="color : red">잘못왓다.</h1>
</body>
</html>