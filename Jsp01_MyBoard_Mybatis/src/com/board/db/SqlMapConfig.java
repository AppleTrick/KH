package com.board.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		// 경로 일때 는 / 로 해준다.
		String resource = "com/board/db/mybatis-config.xml";
		
		//1. config.xml 을 가지고 와서

	
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 2. config.xml 을 읽는다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 3. SqlSessionFactoryBuilder로 객체를 생성
			// 4. sqlSessionFactory 객체 생성
			
			inputStream.close();
			// 원래는 파이널에서 닫아야하는데 지금 닫는다.
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sqlSessionFactory;
	}
}
