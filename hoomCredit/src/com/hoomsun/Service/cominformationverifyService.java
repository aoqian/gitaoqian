package com.hoomsun.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoomsun.Dao.cominformationverifyDao;
import com.hoomsun.entity.cominformationverify;
@Service
public class cominformationverifyService {
	@Autowired
	  private  cominformationverifyDao dao;
	   //插入实名认证信息
		public void in_civ(cominformationverify cv){
			dao.in_civ(cv);
		}

}
