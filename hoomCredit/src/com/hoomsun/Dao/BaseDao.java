package com.hoomsun.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.apache.poi.ss.formula.functions.T;

import com.hoomsun.entity.breakonespromise;
import com.hoomsun.util.MyBatisDao;

/**
 * Dao层的基本封装接口
 * 
 * @author aoqian
 * 
 * @time 2016-7-12 下午2:10:57
 */
@MyBatisDao
public interface BaseDao {

	/**
	 * 根据条件查询数据的记录数
	 * 
	 * @param map
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM ${from} WHERE ${Column1} = #{Column2}")
	int SelCount(Map<String, String> map);
	
	@Select("SELECT * FROM ${from} WHERE ${Column1} = #{Column2}")
     List<Map<String, Object>> SelAll(Map<String, String> map);
	
	@Select("SELECT * FROM ${from}")
    List<Map<String, Object>> SelAlls(Map<String, String> map);
	
	
}
