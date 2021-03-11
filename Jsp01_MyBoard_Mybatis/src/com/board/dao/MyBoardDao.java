package com.board.dao;

// JDBC 에 있는 모든 함수를 사용할 수 있게 한다.

import java.util.List;

import com.board.dto.MyBoardDto;

public class MyBoardDao {

	// 전체를 출력
	public List<MyBoardDto> selectList(){
		
		return null;
	}
	
	// 내용 하나만 출력하는 방법
	public MyBoardDto selectOne(int no) {
		
		return null;
	}
	public int insert(MyBoardDto dto) {
		
		
		
		return 0;
		
	}
	
	
	// 내용 수정
	public int update(MyBoardDto dto) {
		
		
		
		return 0;
	}
	// 내용 삭제
	public int delete(int no) {
		
		
		
		return 0;
	}
}
