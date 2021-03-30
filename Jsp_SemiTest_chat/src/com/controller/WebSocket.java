package com.controller;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint("/websocket")
public class WebSocket {
	
	// websocket으로 브라우저가 접속하면 요청되는 함수	
	@OnOpen
	public void handleOpen() {
		// 콘솔에 접속 로그 출력
		System.out.println("클라이언트 접속중입니다");
	}
	
	//websocket으로 메세지가 오면 요청되는 함수
	@OnMessage
	public String handleMessage(String message) {
		// 메세지 내용을 콘솔에 출력
		System.out.println("클라이언트에게 받는 메세지 : " + message);
		
		// 에코 메세지 작성
		String replymessage = "echo " + message;
		
		// 에코메세지 콘솔에 출력
		System.out.println("클라이언트에 보내는 메세지 : " + replymessage );
		
		// 에코메세지 브라우저에 보낸다
		return replymessage;
	}
	
	//webSocket과 브라우저가 접속이 끊기면 요청되는 함수
	@OnClose
	public void handleClose() {
		// 콘솔에 접속 끊김 로그를 출력
		System.out.println("접속이 끊겼습니다.");
	}
	
	//webSocket과 브라우저 간에 통신 에러가 발생하면 요청되는 함수
	@OnError
	public void handleError(Throwable t) {
		// 콘솔에 에러를 표시한다.
		t.printStackTrace();
	}
	

}
