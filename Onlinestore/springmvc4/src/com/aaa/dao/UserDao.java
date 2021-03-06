package com.aaa.dao;

import java.util.List;
import com.aaa.vo.User;
//DAO层的接口
public interface UserDao {
	//任务：查询所有用户,返回到List<User>集合
	public List<User>search();
	public int insertUser(User user); 
	public int insertUser2(User user); 
	public int deleteUser(int uid);
	public int updateUser(User user);
	public User searchUser(int uid);
	public User selectByUsernameAndPwd(User user);
}