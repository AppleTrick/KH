package com.board.dto;

import java.util.Date;

public class MyBoardDto {
	
//	계층간의 데이터 교환을 위한 자바빈즈를 의미한다.
//
//	여기서 계층은 Controller , View Business Layer , Persistent Layer 이다
//
//	DTO 는 로직을 가지지 않는 순수한 데이터 객체이고 getter setter 만을 가진다.
	
	private int no;
	private String writer;
	private String title;
	private String content;
	private Date date;
	// Date 의 경우에는 java util에서 추가해 준다.
	
	public MyBoardDto() {
		
	}
	
	public MyBoardDto(int no, String writer, String title, String content, Date date) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
