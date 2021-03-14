package com.board.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSessionFactory() {
		
		String resource = "com/board/db/mybatis-config.xml";
		// 경로를 의미할 경우 / 를 사용해야 한다.
		
		// mybatis-config.xml 를 inputstream 에서 읽어들여서
		// 읽어드린 설정을 가지고 SqlSessionFactoryBuilder()를 통해 
		// sqlSessionFactory 객체를 생성
		
		try {
			// InputStream import &  org.apache.ibatis.io.Resources import
			InputStream inputStream = Resources.getResourceAsStream(resource);	
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			inputStream.close();
			
		} catch (IOException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return sqlSessionFactory;
	}
}
