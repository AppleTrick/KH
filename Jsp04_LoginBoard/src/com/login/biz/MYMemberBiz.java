package com.login.biz;

import java.util.List;

import com.login.dao.MYMemberDao;
import com.login.dto.MYMemberDto;

public class MYMemberBiz {
	
	MYMemberDao dao;
	/*
	 * 
	 *  관리자 admin 기능
	 *  1. 회원 전체 정보확인 탈퇴한 회원도 포함
	 *  2. 회원 전체 정보 확인 myenabled='y' 인 ->탙퇴안한 회원들의 정보
	 *  3. 회원 등급 조정 (admin <-> user) 
	 * 
	 */
	//0. 생성자
	public MYMemberBiz() {
		dao = new MYMemberDao();
	}
	//1. 전체 정보
	public List<MYMemberDto> selectAllUser(){
		return null;
	}	
	//2. 전체 정보 (탈퇴 안한)
	public List<MYMemberDto> selectEnabledUser(){
		
		return null;
	}
	//3. 회원 등급 조정
	public int updateRole(int myno, String myrole) {
		
		return 0;
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
		return dao.login(myid, mypw);
	}
	//2. 중복체크
	public MYMemberDto idCheck(String myid) {
		
		return null;
	}
	
	//3. 회원가입
	public int insertUser(MYMemberDto dto) {
		return 0;
	}
	//4. 정보조회
	public MYMemberDto selectUser(int myno) {
		return null;
	}
	
	//5. 정보수정
	public int updateUser(MYMemberDto dto) {
		
		return 0;
	}
	
	public int deleteUser(int myno) {
		return 0;
	}
}
