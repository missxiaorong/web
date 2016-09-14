package com.rjxy.dao;

import java.util.List;

import com.rjxy.entity.User;

public interface UserDao {
	User findUserByLogin(String Login);//根据用户名查找一个用户
	List<User> findUsersByType(int type);//根据用户类型查找用户
	List<User> findUsersByStatus(int status);//根据用户状态查找用户
	List<User> findUsersByCreateById(int createById);//根据创建人id查找用户
	List<User> findUsersByCreateGmtCreate(String start,String end);//根据创建时间查找用户
	List<User> findUsers();//查找所有用户
	int addUser(User user);//增加用户
	int deleteUser(User user);//删除用户
	int updateUser(User user);//修改用户

}
