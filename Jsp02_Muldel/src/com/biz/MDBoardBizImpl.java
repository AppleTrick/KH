package com.biz;

import java.util.List;

import com.dao.MDBoardDao;
import com.dao.MDBoardDaoImpl;
import com.dto.MDBoardDto;

public class MDBoardBizImpl implements MDBoardBiz {
	
	MDBoardDao dao = new MDBoardDaoImpl();
	
	@Override
	public List<MDBoardDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public MDBoardDto selectOne(int seq) {
		// TODO Auto-generated method stub
		return dao.selectOne(seq);
	}

	@Override
	public int insert(MDBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(MDBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return dao.delete(seq);
	}

	@Override
	public int multiDelete(String[] seq) {
		// TODO Auto-generated method stub
		return dao.multiDelete(seq);
	}

}
