package com.rjxy.myexam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rjxy.dao.UserDao;
import com.rjxy.entity.User;
import com.rjxy.util.MybatisUtil;

public class Test1 {
	public static void main(String[] args) {
		SqlSession session = MybatisUtil.openSession();
		UserDao userDao = session.getMapper(UserDao.class);
		List<User> l = userDao.findUsersByCreateGmtCreate("2010-01-01", "2017-01-01");
		for(User u:l){
			System.out.println(u);
		}
	}
}
