package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.db.SqlMapConfig;
import com.dto.MDBoardDto;


public class MDBoardDaoImpl extends SqlMapConfig implements MDBoardDao {

	private String namespace = "com.mapper.";
	
	@Override
	public List<MDBoardDto> selectList() {
		
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false); // autocommit 값
			
			list = session.selectList(namespace+"selectList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public MDBoardDto selectOne(int seq) {
		
		return null;
	}

	@Override
	public int insert(MDBoardDto dto) {
		
		return 0;
	}

	@Override
	public int update(MDBoardDto dto) {
		
		return 0;
	}

	@Override
	public int delete(int seq) {
		
		return 0;
	}

	@Override
	public int multiDelete(String[] seqs) {
		
		int count = 0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs",seqs);
		
		try(SqlSession session = getSqlSessionFactory().openSession(false);) {
			count = session.delete(namespace+"multiDelete",map);
			
			if(count == seqs.length) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	

}
