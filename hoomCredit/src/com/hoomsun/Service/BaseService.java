package com.hoomsun.Service;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import com.hoomsun.Dao.BaseDao;
import com.hoomsun.entity.breakonespromise;

/**
 * 实现该接口
 * 
 * @author aoqian
 * 
 * @time 2016-7-12 下午1:52:54
 */
public class BaseService {

	@Autowired
	private BaseDao baseDao;

	public int SelCount(Map<String, String> map) {
		int count = baseDao.SelCount(map);
		return count;
	}// 计数
	
	
	
	public List<Map<String, Object>> SelAll(Map<String, String> map){
		List<Map<String, Object>> list=(List<Map<String, Object>>) baseDao.SelAll(map);
		return list;
	}
	
	public List<Map<String, Object>> SelAlls(Map<String, String> map){
		List<Map<String, Object>> list=(List<Map<String, Object>>) baseDao.SelAlls(map);
		return list;
	}

}
