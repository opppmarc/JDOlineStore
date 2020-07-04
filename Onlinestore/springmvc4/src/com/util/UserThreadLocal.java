package com.util;

import com.aaa.vo.User;

//线程级别类
public class UserThreadLocal {
	private static ThreadLocal<User>USER_LOCAL=new ThreadLocal<User>();
	//对外提供set/get方法
	public static void set(User user){
		USER_LOCAL.set(user);
	}
	public static User get(){
		return USER_LOCAL.get();
	}
	//在登录的拦截器中，将用户数据放入ThreadLocal
	//USER_LOCAL.set(user);
	//在service中取得user
	//User user=USER_LOCAL.get();
}