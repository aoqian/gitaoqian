package com.hoomsun.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.hoomsun.entity.Record;
import com.hoomsun.entity.breakonespromise;
import com.hoomsun.util.MyBatisDao;

@MyBatisDao
public interface BreakonespromiseDao {

	public void in_br(breakonespromise br);

	// @Select("select * from  breakonespromise  where Name=#{Name}   limit 0,5")

	@Select("select * from  breakonespromise  where Name=#{Name}")
	public List<breakonespromise> sel_br(breakonespromise br);

	@Insert("INSERT INTO breakonespromise (a1, Id, Sourceid, Name, Liandate, Anno, Biaodi, Status, Orgno, Uniqueno, Ownername, Executegov, Province, Executeunite, Yiwu, Executestatus, Actionremark, Publicdate, Follows, Age, Sexy, Createdate, Updatedate, Executeno, Performedpart, Unperformpart, Isperson,Cate) VALUES (#{a1}, #{Id}, #{Sourceid}, #{Name}, #{Liandate}, #{Anno}, #{Biaodi}, #{Status}, #{Orgno}, #{Uniqueno}, #{Ownername}, #{Executegov}, #{Province}, #{Executeunite}, #{Yiwu}, #{Executestatus}, #{Actionremark}, #{Publicdate}, #{Follows}, #{Age}, #{Sexy}, #{Createdate}, #{Updatedate}, #{Executeno}, #{Performedpart}, #{Unperformpart}, #{Isperson},#{Cate})")
	void insertBreakonespromise(breakonespromise breakonespromise);

	@Update("UPDATE breakonespromise SET Sourceid=#{Sourceid}, Name=#{Name}, Liandate=#{Liandate},Follows=#{Follows},Executegov=#{Executegov},Biaodi=#{Biaodi},Status=#{Status},Orgno=#{Orgno},Createdate=#{Createdate},Updatedate=#{Updatedate},Cate=#{Cate} WHERE Id =#{Id}")
	void updateBreakonespromise(breakonespromise breakonespromise);

	@Update("UPDATE breakonespromise SET Sourceid=#{Sourceid}, Uniqueno=#{Uniqueno}, Name=#{Name}, Liandate=#{Liandate}, Anno=#{Anno}, Orgno=#{Orgno}, Ownername=#{Ownername}, Executegov=#{Executegov}, Province=#{Province}, Executeunite=#{Executeunite}, Yiwu=#{Yiwu}, Executestatus=#{Executestatus}, Actionremark=#{Actionremark}, Publicdate=#{Publicdate}, Follows=#{Follows}, Age=#{Age}, Sexy=#{Sexy}, Createdate=#{Createdate}, Updatedate=#{Updatedate},Executeno=#{Executeno}, Performedpart=#{Performedpart}, Unperformpart=#{Unperformpart}, Isperson=#{Isperson},Cate=#{Cate} WHERE Id =#{Id}")
	void updateBreakonespromises(breakonespromise breakonespromise);

	@Update("UPDATE breakonespromise SET Sourceid=#{Sourceid}, Name=#{Name}, Liandate=#{Liandate}, Anno=#{Anno}, Biaodi=#{Biaodi}, Status=#{Status}, Orgno=#{Orgno}, Uniqueno=#{Uniqueno}, Ownername=#{Ownername}, Executegov=#{Executegov}, Province=#{Province}, Executeunite=#{Executeunite}, Yiwu=#{Yiwu}, Executestatus=#{Executestatus}, Actionremark=#{Actionremark}, Publicdate=#{Publicdate}, Follows=#{Follows}, Age=#{Age}, Sexy=#{Sexy}, Createdate=#{Createdate}, Updatedate=#{Updatedate}, Executeno=#{Executeno}, Performedpart=#{Performedpart}, Unperformpart=#{Unperformpart}, Isperson=#{Isperson},Cate=#{Cate} WHERE Id =#{id}")
	void updateBreakonespromisess(breakonespromise breakonespromise);

	@Select("select * from  breakonespromise  where a1=#{a1}")
	public breakonespromise sel_a1(String a1);

	@Insert("INSERT INTO record (keyword, type, time, rank, port, userid, num) VALUES (#{keyword}, #{type}, #{time}, #{rank}, #{port}, #{userid}, #{num})")
	void insertRecord(Record record);

	// @Select("SELECT id, keyword, type, time, rank, port, userid, num FROM record WHERE userid=#{userid} GROUP BY keyword")
	// @Select("SELECT id, keyword, type, time, rank, port, userid, num FROM record WHERE userid=#{userid} AND to_days(now())-to_days(time)>=2 and rank='1'GROUP BY keyword")
	//@Select("select * from (SELECT id, keyword, type, time, rank, port, userid, num FROM record WHERE userid=#{userid} AND to_days(now())-to_days(time)>=2 and rank='1' UNION SELECT id, keyword, type, time, rank, port, userid, num FROM record WHERE userid=#{userid} and rank='0') a1 GROUP BY a1.keyword")
	@Select("SELECT id, keyword, type, time, rank, port, userid, num, to_days(now())-to_days(time) AS other FROM record WHERE userid=#{userid} GROUP BY keyword")
	public List<Record> selectRecord(String a1);

	// @Select("SELECT  count(distinct keyword) FROM record WHERE userid=#{userid}")
	//@Select("SELECT COUNT(distinct keyword) FROM record WHERE userid=#{userid} AND to_days(now())-to_days(time)>=2")
	@Select("SELECT count(distinct keyword) FROM record WHERE userid=#{userid}")
	int SelCountWhere(String string);

	@Select("SELECT COUNT(*) FROM record WHERE userid=#{userid} AND keyword=#{keyword}")
	int SelCountMore(Record record);

	@Select("SELECT id, keyword, type, time, rank, port, userid, num, to_days(now())-to_days(time) AS other FROM record WHERE userid=#{userid} AND keyword=#{keyword}")
	public List<Record> selectRecorMore(Record record);

	@Select("SELECT id,keyword,type,time,rank,port,userid,num FROM record WHERE rank=#{rank} AND userid=#{userid} and num=#{num}")
	Record se_CountRecord(Record record);

	@Update("UPDATE record SET time=#{time} WHERE userid=#{userid}")
	void updateDate_Record(Record record);

}
