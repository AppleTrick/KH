package com.dao;

import static com.db.JDBCTemplete.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.MDBoardDto;


public class MDBoardDaoImpl implements MDBoardDao {

	@Override
	public List<MDBoardDto> selectList() {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. 쿼리문 생성 "  + SELECT_LIST_SQL);
			rs = pstm.executeQuery();
			System.out.println("4. 쿼리문 실행 ");
			
			while(rs.next()) {
				MDBoardDto dto = new MDBoardDto();
				dto.setSeq(rs.getInt("SEQ"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setDate(rs.getDate("REGDATE"));
				
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
		
		return list;
	}

	@Override
	public MDBoardDto selectOne(int seq) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MDBoardDto dto = new MDBoardDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			System.out.println("3. 쿼리문 생성 "  + SELECT_ONE_SQL);
			
			
			rs = pstm.executeQuery();
			System.out.println("4. 쿼리문 실행 ");
			while(rs.next()) {
				dto.setSeq(rs.getInt("SEQ"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setDate(rs.getDate("REGDATE"));
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

	@Override
	public int insert(MDBoardDto dto) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("3. 쿼리문 생성 "  + INSERT_SQL);
			
			
			res = pstm.executeUpdate();
			System.out.println("4. 쿼리문 실행 ");
			
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

	@Override
	public int update(MDBoardDto dto) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			System.out.println("3. 쿼리문 생성 "  + UPDATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
			res = pstm.executeUpdate();
			System.out.println("4. 쿼리문 실행 ");
			
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

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, seq);
			System.out.println("3. 쿼리문 생성 "  + DELETE_SQL);
			
			
			res = pstm.executeUpdate();
			System.out.println("4. 쿼리문 실행 ");
			
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

	@Override
	public int multiDelete(String[] seq) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		
		int res = 0;
		int[] cnt = null;
		
		try {
			pstm =con.prepareStatement(DELETE_SQL);
			for(int i = 0; i < seq.length; i++) {
				pstm.setString(1, seq[i]);
				pstm.addBatch();
				System.out.println("3. query 준비 : " + DELETE_SQL + " (삭제할 번호 : "+seq[i]+" )");
			}
			
			cnt = pstm.executeBatch();
			System.out.println("4. query 실행 및 리턴 ");
			
			for(int i =0; i < cnt.length; i++) {
				if(cnt[i]== -2) {
					// -2 로 정의한다.
					res++; 
				}
			}
			
			// 갯수
			if(seq.length == res) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return res;
	}

	

}
