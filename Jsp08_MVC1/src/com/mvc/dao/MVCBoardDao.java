package com.mvc.dao;

import java.util.List;

import com.mvc.dto.MVCBoardDto;

public interface MVCBoardDao {
	
	String SELECT_LIST = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE " +
						" FROM MVCBOARD " +
						" ORDER BY SEQ DESC ";
	
	String SELECT_ONE = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE " +
						" FROM MVCBOARD " +
						" WHERE SEQ = ? ";
	String UPDATE = " UPDATE MVCBOARD " +
					" SET TITLE = ? , CONTENT = ? " +
					" WHERE SEQ = ? ";
	String INSERT = " INSERT INTO MVCBOARD " +
					" VALUES (MVCBOARDSEQ.NEXTVAL,?,?,?,SYSDATE) ";
	String DELETE = " DELETE FROM MVCBOARD " +
					" WHERE SEQ = ? ";
	
	public List<MVCBoardDto> selectList();
	public MVCBoardDto selectOne(int seq);
	public int insert(MVCBoardDto dto);
	public int update(MVCBoardDto dto);
	public int delete(int seq);
}
