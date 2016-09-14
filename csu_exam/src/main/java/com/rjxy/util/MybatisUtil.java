package com.rjxy.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	public static SqlSessionFactory factory;
	static{
		try{
			Reader reader = Resources.getResourceAsReader("configuration.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static SqlSession openSession(){
		return factory.openSession();
	}
}
