package com.hoomsun.Dao;

import java.util.List;

import com.hoomsun.entity.User;
import com.hoomsun.util.MyBatisDao;

@MyBatisDao
public interface UserDao {
	//注册用户
	public void in_user(User user);
	//登录时查询是否有此人
	public User isexist(User user);
	//查询此手机号是否已被注册
	public List<User> isexist_tel(String tel);
	
	

}
