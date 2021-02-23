package com.login.dao;

import static com.login.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.dto.MYMemberDto;

public class MYMemberDao {
	
	
	/*
	 * 
	 *  관리자 admin 기능
	 *  1. 회원 전체 정보확인 탈퇴한 회원도 포함
	 *  2. 회원 전체 정보 확인 myenabled='y' 인 ->탙퇴안한 회원들의 정보
	 *  3. 회원 등급 조정 (admin <-> user) 
	 * 
	 */
	
	//1. 전체 정보
	public List<MYMemberDto> selectAllUser(){
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE " +
					" FROM MYMEMBER " +
					" ORDER BY MYNO DESC ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. 쿼리 준비");
			rs = pstm.executeQuery();
			System.out.println("4. 쿼리 실행");
			while(rs.next()) {
				MYMemberDto dto = new MYMemberDto(
						rs.getInt("MYNO"),
						rs.getString("MYID"),
						rs.getString("MYPW"),
						rs.getString("MYNAME"),
						rs.getString("MYADDR"),
						rs.getString("MYPHONE"),
						rs.getString("MYEMAIL"),
						rs.getString("MYENABLED"),
						rs.getString("MYROLE"));
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
		}
		
		
		return list;
	}	
	//2. 전체 정보 (탈퇴 안한)
	public List<MYMemberDto> selectEnabledUser(){
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE " +
					" FROM MYMEMBER " +
					" WHERE MYENABLED = 'Y' ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. 쿼리 준비");
			rs = pstm.executeQuery();
			System.out.println("4. 쿼리 실행");
			while(rs.next()) {
				MYMemberDto dto = new MYMemberDto(
						rs.getInt("MYNO"),
						rs.getString("MYID"),
						rs.getString("MYPW"),
						rs.getString("MYNAME"),
						rs.getString("MYADDR"),
						rs.getString("MYPHONE"),
						rs.getString("MYEMAIL"),
						rs.getString("MYENABLED"),
						rs.getString("MYROLE"));
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
		}
		
		
		return list;
	}
	//3. 회원 등급 조정
	public int updateRole(int myno, String myrole) {
		
		Connection con = getConnection();
		String sql = " UPDATE MYMEMBER " +
					" SET MYROLE = ? " +
					" WHERE MYNO = ? ";
		PreparedStatement pstm = null;
		
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myrole);
			pstm.setInt(2, myno);;
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm, con);
		}
		
	
		return res;
	}
	
	
	/*
	 *사용자 기능 
	 *  1. 로그인
	 *  3. 회원가입 <-2. 아이디 중복 체크
	 *	4. 내 정보 조회
	 *  5. 내 정보 수정
	 * 	6. 회원 탈퇴 (delete 안쓸것 ! update : myenabled를 n으로 바꾸자.)
	 */
	
	//1. 로그인
	public MYMemberDto login (String myid, String mypw) {
		
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
					+" FROM MYMEMBER "
					+" WHERE MYID = ? "
					+" AND MYPW = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		//side effect
		MYMemberDto dto = null;
				
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			pstm.setString(2, mypw);
			System.out.println("3. 쿼리 준비");
			rs = pstm.executeQuery();
			System.out.println("4. 쿼리 실행");
			while(rs.next()){
				dto = new MYMemberDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
		}
		
		return dto;
	}
	//2. 중복체크
	public MYMemberDto idCheck(String myid) {
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "+
					" FROM MYMEMBER " +
					" WHERE MYID = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// 무조건 null 이 아니여야한다. logincontroller 에 널이 아니면을 정의했기 때문에
		MYMemberDto dto = new MYMemberDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto = new MYMemberDto(
						rs.getInt("MYNO"),
						rs.getString("MYID"),
						rs.getString("MYPW"),
						rs.getString("MYNAME"),
						rs.getString("MYADDR"),
						rs.getString("MYPHONE"),
						rs.getString("MYEMAIL"),
						rs.getString("MYENABLED"),
						rs.getString("MYROLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
		}
				
		return dto;
	}
	
	//3. 회원가입
	public int insertUser(MYMemberDto dto) {
		return 0;
	}
	//4. 정보조회
	public MYMemberDto selectUser(int myno) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				+" FROM MYMEMBER "
				+" WHERE MYNO = ? ";
		
		MYMemberDto dto = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("3. 쿼리 준비");
			rs = pstm.executeQuery();
			System.out.println("4. 쿼리 실행");
			while(rs.next()) {
				dto = new MYMemberDto(
						rs.getInt("MYNO"),
						rs.getString("MYID"),
						rs.getString("MYPW"),
						rs.getString("MYNAME"),
						rs.getString("MYADDR"),
						rs.getString("MYPHONE"),
						rs.getString("MYEMAIL"),
						rs.getString("MYENABLED"),
						rs.getString("MYROLE"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
		}
		
		return dto;
	}
	
	//5. 정보수정
	public int updateUser(MYMemberDto dto) {
		
		return 0;
	}
	
	public int deleteUser(int myno) {
		return 0;
	}	
}
