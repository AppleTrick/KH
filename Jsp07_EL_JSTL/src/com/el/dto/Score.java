package com.el.dto;

public class Score {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String grade;
	
	public Score() {
		super();
	}
	
	
	
	public Score(String name, int kor, int eng, int math, int sum, double avg, String grade) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = sum;
		this.avg = avg;
		this.grade = grade;
	}



	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		setSum();
		setAvg();
		setGrade();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum() {
		this.sum = getKor() + getEng() + getMath();
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg() {
		this.avg = getSum()/3.0;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade() {
		
		switch((int)getAvg()/10) {
		case 10:
			System.out.println("A등급");
			this.grade = "A";
			break;
			
		case 9:
			System.out.println("B등급");
			this.grade = "B";
			break;
			
		case 8:
			System.out.println("C등급");
			this.grade = "C";
			break;
			
		case 7:
			System.out.println("D등급");
			this.grade = "D";
			break;
			
		default:
			System.out.println("학점 망.");
			this.grade = "F";
			break;
		}
	}

	
}
