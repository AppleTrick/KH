package com.mvc.dao;

import java.util.List;
import com.mvc.dto.MVCBoardDto;

public interface MVCBoardDao {
	String MVC_SELECT_LIST = "SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE " +
							" FROM MVCBOARD ";
	String MVC_SELECT_ONE= "";
	String MVC_UPDATE= "";
	String MVC_INSERT= "";
	String MVC_DELETE= "";
	
	public List<MVCBoardDto> selectList();
	public MVCBoardDto selectOne(int seq);
	public int insert(MVCBoardDto dto);
	public int update(MVCBoardDto dto);
	public int delete(int seq);
	public int multiDelete(String[] seq);

}
