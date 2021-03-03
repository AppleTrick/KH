package com.answer.dao;

import static com.answer.db.JDBCTemplete.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;

public class AnswerDaoImpl implements AnswerDao {

	@Override
	public List<AnswerDto> selectList() {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				AnswerDto dto = new AnswerDto();
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setWriter(rs.getString(7));
				dto.setRegdate(rs.getDate(8));

				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs, pstm, con);
		}
		
		
		return list;
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		AnswerDto dto = new AnswerDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, boardno);
			System.out.println("3.query 준비 : " + SELECT_ONE_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			while(rs.next()) {
				// 위에서 널로 했으면 여기서 객체 생성했어야 한다.
				dto.setBoardno(rs.getInt("BOARDNO"));
				dto.setGroupno(rs.getInt("GROUPNO"));
				dto.setGroupseq(rs.getInt("GROUPSEQ"));
				dto.setTitletab(rs.getInt("TITLETAB"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setRegdate(rs.getDate("REGDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs, pstm, con);
			System.out.println("5. db종료");
		}
		
		
		return dto;
	}

	@Override
	public int boardInsert(AnswerDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(AnswerDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(int boardno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int answerUpdate(int parentBoardNo) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(ANSWER_UPDATE_SQL);
			pstm.setInt(1, parentBoardNo);
			pstm.setInt(2, parentBoardNo);
			System.out.println("3. query 준비 : " +ANSWER_UPDATE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴 ");
			
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm, con);
			System.out.println("5. db 종료");
		}
		return res;
	}

	@Override
	public int answerInsert(AnswerDto dto) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(ANSWER_INSERT_SQL);
			pstm.setInt(1, dto.getBoardno());
			pstm.setInt(2, dto.getBoardno());
			pstm.setInt(3, dto.getBoardno());
			
			pstm.setString(4, dto.getTitle());
			pstm.setString(5, dto.getContent());
			pstm.setString(6, dto.getWriter());
			
			System.out.println("3. query 준비 : " +ANSWER_UPDATE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴 ");
			
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm, con);
			System.out.println("5. db 종료");
		}
		return res;
	}

}
