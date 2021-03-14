package com.board.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.db.SqlMapConfig;
import com.board.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig{

	// 전체를 출력
	public List<MyBoardDto> selectList(){
		
		SqlSession session = null;
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		session = getSessionFactory().openSession(true);
		list = session.selectList("boardmapper.selectList");
		
		session.close();
		
		
		return list;
	}
	
	// 내용 하나만 출력하는 방법
	public MyBoardDto selectOne(int no) {
		
		SqlSession session = null;
		
		MyBoardDto dto = new MyBoardDto();
		
		try {
			session = getSessionFactory().openSession(true);
			dto = session.selectOne("boardmapper.selectOne",no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return dto;
	}
	public int insert(MyBoardDto dto) {
		int res = 0;
		
		/// try with resource // try() 안에 넣으면 close 구문이 필요 없어짐
		try(SqlSession session = getSessionFactory().openSession(true);){
			res = session.insert("boardmapper.insert",dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return res;
		
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
