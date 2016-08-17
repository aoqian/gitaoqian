package com.hoomsun.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoomsun.Dao.EnterprisebusinessdataDao;
import com.hoomsun.entity.Enterprisebusinessdata;


@Service
public class EnterprisebusinessdataService {
	
	@Autowired
	private EnterprisebusinessdataDao enterprisebusinessdataDao;
	

	
	
	public void in_gs(Enterprisebusinessdata gs){
		enterprisebusinessdataDao.in_gs(gs);
	}

}
