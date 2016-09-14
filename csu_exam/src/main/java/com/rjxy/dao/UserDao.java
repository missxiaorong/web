package com.rjxy.dao;

import java.util.List;

import com.rjxy.entity.User;

public interface UserDao {
	User findUserByLogin(String Login);//�����û�������һ���û�
	List<User> findUsersByType(int type);//�����û����Ͳ����û�
	List<User> findUsersByStatus(int status);//�����û�״̬�����û�
	List<User> findUsersByCreateById(int createById);//���ݴ�����id�����û�
	List<User> findUsersByCreateGmtCreate(String start,String end);//���ݴ���ʱ������û�
	List<User> findUsers();//���������û�
	int addUser(User user);//�����û�
	int deleteUser(User user);//ɾ���û�
	int updateUser(User user);//�޸��û�

}
