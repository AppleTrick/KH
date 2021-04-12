package com.dto;

public class testDto {
	int testNo;
	String testName;
	String testPhone;
	
	public testDto(int testNo, String testName, String testPhone) {
		this.testNo = testNo;
		this.testName = testName;
		this.testPhone = testPhone;
	}
	public testDto() {
		super();
	}
	public int getTestNo() {
		return testNo;
	}
	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestPhone() {
		return testPhone;
	}
	public void setTestPhone(String testPhone) {
		this.testPhone = testPhone;
	}
}
