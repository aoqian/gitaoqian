package com.hoomsun.Service.creditImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoomsun.Dao.BreakonespromiseDao;
import com.hoomsun.Service.BaseService;

import com.hoomsun.entity.Record;
import com.hoomsun.entity.breakonespromise;

/**
 * @author aoqian
 * 
 * @time 2016-7-13 上午9:58:25
 */
@Service
public class BreakonespromiseServiceImpl extends BaseService {

	@Autowired
	private BreakonespromiseDao dao;

	public void insertBreakonespromise(breakonespromise breakonespromise) {
		dao.insertBreakonespromise(breakonespromise);
	}

	public List<breakonespromise> sel_br(breakonespromise br) {
		List<breakonespromise> list = dao.sel_br(br);

		return list;

	}

	public breakonespromise sel_a1(String a1) {
		breakonespromise br = dao.sel_a1(a1);
		return br;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hoomsun.Service.BaseService#SelCount(java.util.Map)
	 */
	@Override
	public int SelCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return super.SelCount(map);
	}

	@Override
	public List<Map<String, Object>> SelAll(Map<String, String> map) {
		// TODO Auto-generated method stub
		return super.SelAll(map);
	}

	@Override
	public List<Map<String, Object>> SelAlls(Map<String, String> map) {
		// TODO Auto-generated method stub
		return super.SelAlls(map);
	}

	public void updateBreakonespromise(breakonespromise breakonespromise) {
		dao.updateBreakonespromise(breakonespromise);
	}

	public void updateBreakonespromises(breakonespromise breakonespromise) {
		dao.updateBreakonespromises(breakonespromise);
	}

	public void updateBreakonespromisess(breakonespromise breakonespromise) {
		dao.updateBreakonespromisess(breakonespromise);
	}

	public void insertRecord(Record record) {
		dao.insertRecord(record);
	}

	public List<Record> selectRecord(String record) {

		return dao.selectRecord(record);
	}

	public int SelCountWhere(String string) {
		// TODO Auto-generated method stub

		return dao.SelCountWhere(string);
	}

	public int SelCountMore(Record record) {

		return dao.SelCountMore(record);
	};

	public List<Record> selectRecorMore(Record record) {
		return dao.selectRecorMore(record);
	};

	public Record se_CountRecord(Record record) {
		return dao.se_CountRecord(record);
	};

	public void updateDate_Record(Record record) {
		dao.updateDate_Record(record);
	}
}
