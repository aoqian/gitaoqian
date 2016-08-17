package com.hoomsun.Service.creditImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hoomsun.Dao.EnterprisebusinessdataDao;
import com.hoomsun.entity.Enterprisebusinessdata;

/**
 * @author aoqian
 * 
 * @time 2016-7-12 下午6:50:47
 */
@Service
public class EnterprisebusinessdataImpl {

	@Autowired
	private EnterprisebusinessdataDao dao;

	public void insertEnterprisebusinessdata(Enterprisebusinessdata enterprisebusinessdata) {
		dao.insertEnterprisebusinessdata(enterprisebusinessdata);
	}
	
	public List<Enterprisebusinessdata>  sel_keyword(String key){
		List<Enterprisebusinessdata> list=dao.sel_keyword(key);
		return list;
	}
	
	
	
}
