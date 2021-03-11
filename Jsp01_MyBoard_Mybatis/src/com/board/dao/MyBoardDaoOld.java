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

public class MyBoardDaoOld {

	// 전체를 출력
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
	
	// 내용 하나만 출력하는 방법
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
			System.out.println("3. query 를 준비 " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("query를 실행시키고 이에대한 값을 리턴");
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
	public int insert(MyBoardDto dto) {
		
		Connection con = getConnection();
		String sql = " INSERT INTO MYBOARD "+
					" VALUES(MYBOARDSEQ.NEXTVAL,?,?,?,SYSDATE)";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("3. query 를 준비 " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("query를 실행시키고 이에대한 값을 리턴");
			
			if(res > 0) {
				commit(con);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
		
	}
	
	
	// 내용 수정
	public int update(MyBoardDto dto) {
		
		Connection con = getConnection();
		String sql = " UPDATE MYBOARD " + 
					" SET TITLE = ? , CONTENT = ? " +
					" WHERE SEQ = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getNo());
			System.out.println("3. query 를 준비 " + sql);
			
			
			res = pstm.executeUpdate();
			System.out.println("query를 실행시키고 이에대한 값을 리턴");
			
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	// 내용 삭제
	public int delete(int no) {
		
		Connection con = getConnection();
		String sql = " DELETE FROM MYBOARD " + 
					" WHERE SEQ = ? ";
		
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			System.out.println("3. query 를 준비 " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("query를 실행시키고 이에대한 값을 리턴");
			
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		
		return res;
	}
}
