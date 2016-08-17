package com.hoomsun.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoomsun.Dao.nationbreakspromiseDao;
import com.hoomsun.entity.nationbreakspromise;

@Service
public class nationbreakspromiseService {
	@Autowired
	private nationbreakspromiseDao dao;
	
	public void in_nb(nationbreakspromise na){
		dao.in_nb(na);
		
	}
	
	public void up_nb(nationbreakspromise na){
		dao.up_nb(na);
	}
	

}
