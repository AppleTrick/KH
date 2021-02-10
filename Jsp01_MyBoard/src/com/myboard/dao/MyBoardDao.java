package com.myboard.dao;

// jdbc 를 임포트하지 않고사용하는 법  import static
import static com.myboard.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myboard.dto.MyBoardDto;


public class MyBoardDao {
	
	//전체 출력
	public List<MyBoardDto> selectList(){
		Connection con = getConnection();
		
		String sql = " SELECT MYNO , MYNAME, MYTITLE, MYCONTENT, MYDATE " +
					" FROM MYBOARD " +
					" ORDER BY MYNO DESC ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비" + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 준비 및 리턴");
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString("MYNAME"));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString("MYCONTENT"));
				dto.setMydate(rs.getDate(5));
				
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
	
	public MyBoardDto selectOne(int myno) {
		
		Connection con = getConnection();
		
		String sql = "SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE"+
					" FROM MYBOARD " +
					" WHERE MYNO = ? ";
				
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		MyBoardDto dto = new MyBoardDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("3. query 준비 : "+sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			//while 없앨 경우 rs.next() 하나를 무조건 해줘야된다.
			while(rs.next()) {
				dto.setMyno(rs.getInt("MYNO"));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString("MYTITLE"));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate("MYDATE"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		
		
		return dto;
	}
	
	public int insert(MyBoardDto dto) {
		
		Connection con = getConnection();
		String sql = " INSERT INTO MYBOARD " +
				" VALUES(MYBOARDSEQ.NEXTVAL, ? , ? , ? , SYSDATE) ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			System.out.println("3. query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");;
			
			// select 는 db 자체의 변동이 없다.
			// insert 의 경우에는 db 자체의 변동으로 위에 autocommit을 false로 해줬기에 commit 을 해줘야 db에 정상적으로 적용이된다.
			if(res > 0) {
				commit(con);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return res;
	}
	
	public int delete(int myno) {
		
		Connection con = getConnection();
		
		String sql = " DELETE FROM MYBOARD " +
					" WHERE MYNO = ? ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("3. query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");;
			
			if(res > 0) {
				commit(con);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		
		return res;
	}
	
	public int update(MyBoardDto dto) {
		
		Connection con = getConnection();
		
		String sql = " UPDATE MYBOARD " +
					" SET MYTITLE = ?, MYCONTENT = ? " +
					" WHERE MYNO = ? ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyno());
			System.out.println("3. query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");;
			
			if(res > 0) {
				commit(con);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return res;
	}

}
