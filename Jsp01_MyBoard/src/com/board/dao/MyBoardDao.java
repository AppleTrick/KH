package com.board.dao;

import static com.board.db.JDBCTemplete.*;
// JDBC 에 있는 모든 함수를 사용할 수 있게 한다.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.MyBoardDto;

public class MyBoardDao {

	// 전체를 출력하는 방법
	public List<MyBoardDto> selectList(){
		
		Connection con = getConnection();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				+ " FROM MYBOARD "
				+ " ORDER BY SEQ DESC ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 를 준비 " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("query를 실행시키고 이에대한 값을 리턴");
			
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto();
				dto.setNo(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setDate(rs.getDate(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		// 쿼리에 대한 내용을 가지고 오고 이를 값을 반환해주는 내용
		return list;
	}
	
	public MyBoardDto selectOne(int no) {
		Connection con = getConnection();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE " +
					" FROM MYBOARD " +
					" WHERE SEQ = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		MyBoardDto dto = new MyBoardDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setNo(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setDate(rs.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
				
		
		return dto;
	}
}
