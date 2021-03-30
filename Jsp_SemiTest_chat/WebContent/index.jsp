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
	<form action="">
		<input id="textMessage" type="text">
		<input onclick="sendMessage()" value="전송" type="button">
		<input onclick="disconnect()" value="Disconnect" type="button">
	</form>
	<br>
	
	<textarea id="messageTextArea"rows="10" cols="50"></textarea>
	
	<script type="text/javascript">
	
	var webSocket = new WebSocket("ws://localhost:8787/Jsp_SemiTest_chat/websocket");
	
	var messageTextArea = document.getElementById("messageTextArea");
	
	webSocket.onopen = function(message) {
		messageTextArea.value += "Server connect...\n";
	};

	webSocket.onclose = function(message) {
		messageTextArea.value += "Server Disconnect...\n";
	};

	webSocket.onerror = function(message) {
		messageTextArea.value += "error...\n";
	};

	webSocket.onmessage = function(message) {
		messageTextArea.value += "Recieve From Server => "+message.data+"\n";
	};
	
	function sendMessage() {
		var message = document.getElementById("textMessage");
		messageTextArea.value += "Send to Server => "+message.value+"\n";
		message.value = "";
	}
	
	function disconnect() {
		webSocket.close();
	}
	
	
	</script>
	
</body>
</html>