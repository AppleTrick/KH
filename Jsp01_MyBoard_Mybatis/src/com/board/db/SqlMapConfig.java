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
		//String resource = "org/mybatis/example/mybatis-config.xml";
	
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			inputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sqlSessionFactory;
	}
}
