package com.cal.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cal.dto.CalDto;

public class Util {
	
	
	private String todates;
	
	public String getTodates() {
		return todates;
	}
	
	public void setTodates(String mdate) {
		// INPUT yyyyMMddhhmm00 형식(String 형식)
		
		// yyyy-MM-dd hh:mm:00 형태로 변환
		
		String temp = mdate.substring(0,4)+"-"
					+ mdate.substring(4,6)+"-"
					+ mdate.substring(6,8)+" "
					+ mdate.substring(8,10)+":"
					+ mdate.substring(10)+":00";
		// TEMP 는 형식 변환 yyyy-MM-dd hh:mm:00 (String) 형식
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		// 시간을 새롭게 포맷팅는 방법 선언
		
		Timestamp tm = Timestamp.valueOf(temp); //java.sql 파일
		// yyyy-MM-dd hh:mm:00(String) 을 -> yyyy-MM-dd hh:mm:00(timestamp 형식으로)
		
		todates = sdf.format(tm);
		// sdf.format(tm) 는 yyyy-MM-dd hh:mm:00 (타임 스탬프 형식) -> yyyy년MM월dd일 HH시mm분 (타임 스탬프 형식)  
		
		
		// yyyy년MM월dd일 HH시mm분 (문자열로 저장)
		
		// 정리하자면  바로 못바꿔주니까
		//yyyyMMddhhmm00 ->  yyyy-MM-dd hh:mm:00 -> yyyy년MM월dd일 HH시mm분
				
	}
		
	
	
	// 토요일 , 일요일, 평일 색상
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		
		if((dayOfWeek -1 + date)%7 == 0) {
			color = "blue";
		} else if ((dayOfWeek-1 + date)%7 == 1) {
			color = "red";
		} else {
			color = "black";
		}
		
		return color;
	}
	
	// 일정의 한자리수 -> 두자리수 변환
	public static String isTwo(String msg) {
		return (msg.length()<2)?"0"+msg:msg;
				
	}
	
	// 일정 제목이 긴 경우 뒷부분을 ... 으로
	public static String getCalView(int i,List<CalDto> list) { //날짜와 / SQL결과창의 dto 배열 형태가 오게 된다.
		// sql 에서 출력한 부분을 html형식으로 res 에 저장
		String d = isTwo(i+"");
		String res ="";
		
		for (CalDto dto : list) {
			//year + Util.isTwo(month) + Util.isTwo(date) + Util.isTwo(hour) + Util.isTwo(min); 
			if (dto.getMdate().substring(6,8).equals(d)) { // yyyyMMddhhmm 까지된 부분에서 dd 부분을 위에 변수 d(날짜) 와 비교한다.
				
				
				// sql 문장때문에 1~4 만큼만 출력 한다
				res += "<p>"
						+((dto.getTitle().length() > 6 ) ? dto.getTitle().substring(0,6) + "..." : dto.getTitle())
						+"<p>";
			}
				
		}
		
		return res;
	}
	
}
