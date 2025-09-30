package com.app.myBatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource = "com/app/myBatis/config/config.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);
//			리더의 설정파일을 읽어와서 읽어온 객체를 이용해서 세션팩토리를 만듬
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
