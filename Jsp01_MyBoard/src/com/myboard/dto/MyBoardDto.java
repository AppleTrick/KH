package com.myboard.dto;

import java.util.Date;

//db 안에 잇는 row 하나를 저장해서 전달(전송)
public class MyBoardDto {

	
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	// util  을 쓰는 이유?
	private Date mydate;

	// alt + shift + s 자동완성
	public MyBoardDto() {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
	
	
}
