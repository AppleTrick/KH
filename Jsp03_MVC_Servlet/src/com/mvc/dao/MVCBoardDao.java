package com.mvc.dao;

import java.util.List;
import com.mvc.dto.MVCBoardDto;

public interface MVCBoardDao {
	String MVC_SELECT_LIST = "SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE " +
							" FROM MVCBOARD " + 
							" ORDER BY SEQ DESC ";
	String MVC_SELECT_ONE= " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE " +
							" FROM MVCBOARD " +
							" WHERE SEQ = ? ";
	String MVC_UPDATE= " UPDATE MVCBOARD " +
						" SET TITLE = ?, CONTENT = ? " +
						" WHERE SEQ = ? ";
	String MVC_INSERT= " INSERT INTO MVCBOARD " +
						" VALUES(MVCBOARDSEQ.NEXTVAL,?,?,?,SYSDATE) " ;
	String MVC_DELETE= " DELETE FROM MVCBOARD " +
						" WHERE SEQ = ? ";
	
	public List<MVCBoardDto> selectList();
	public MVCBoardDto selectOne(int seq);
	public int insert(MVCBoardDto dto);
	public int update(MVCBoardDto dto);
	public int delete(int seq);
	public int multiDelete(String[] seq);

}
