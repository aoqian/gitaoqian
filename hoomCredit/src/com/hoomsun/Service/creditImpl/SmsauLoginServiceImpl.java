package com.hoomsun.Service.creditImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoomsun.Dao.UserDao;
import com.hoomsun.entity.User;

/**
 * @author aoqian
 * 
 * @time 2016-7-25 上午10:28:21
 */

@Service
public class SmsauLoginServiceImpl {

	@Autowired
	private UserDao userDao;

	public void in_user(User user) {
		userDao.in_user(user);
	}

}
