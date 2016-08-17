package com.hoomsun.Dao;

import com.hoomsun.entity.cominformationverify;
import com.hoomsun.util.MyBatisDao;

@MyBatisDao
public interface cominformationverifyDao {
	
	//插入实名认证信息
	public void in_civ(cominformationverify cv);

}
