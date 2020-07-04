package com.aaa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.dao.UserDao;
import com.aaa.service.IUserService;
import com.aaa.vo.User;

@Service("userService")
public class UserService implements IUserService {
	@Resource
	private UserDao userDao;
//查询	
	public List<User> search() {
		return userDao.search();
	}
//增加
	public int insertUser(User user) {
		return userDao.insertUser2(user);
	}
//删除
	public int deleteUser(int uid) {
		return userDao.deleteUser(uid);
	}
	//
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
	public User searchUser(int uid) {
		return userDao.searchUser(uid);
	}
	public User selectByUsernameAndPwd(User user) {
		// TODO Auto-generated method stub
		return userDao.selectByUsernameAndPwd(user);
	}

}