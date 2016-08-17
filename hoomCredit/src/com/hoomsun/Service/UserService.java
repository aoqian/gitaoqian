package com.hoomsun.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoomsun.Dao.UserDao;
import com.hoomsun.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	//注册用户
	public void in_user(User user){
		
		dao.in_user(user);
	}
	
	//登录时查询是否有此人
		public User isexist(User user){
		User u1=	dao.isexist(user);
		
		return u1;
	  }
   //查询此手机号是否已被注册
   public List<User> isexist_tel(String tel){
	   List<User> list=dao.isexist_tel(tel);
	   
	   return list;
   }

}
