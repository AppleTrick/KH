package com.answer.biz;

import java.util.List;

import com.answer.dao.AnswerDao;
import com.answer.dao.AnswerDaoImpl;
import com.answer.dto.AnswerDto;

public class AnswerBizImpl implements AnswerBiz {

	
	AnswerDao dao = new AnswerDaoImpl();
	@Override
	public List<AnswerDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		// TODO Auto-generated method stub
		return null;
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
	public int answerProc(AnswerDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
