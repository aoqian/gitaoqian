package com.hoomsun.Dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.hoomsun.entity.First;
import com.hoomsun.entity.analysis_of_home_ownership;
import com.hoomsun.entity.associated_information;
import com.hoomsun.entity.check_item_details;
import com.hoomsun.entity.court_information_field_table;
import com.hoomsun.entity.frequency_details;
import com.hoomsun.entity.overdue_details;
import com.hoomsun.entity.plat;
import com.hoomsun.entity.risk_check_item_list;
import com.hoomsun.util.MyBatisDao;

@MyBatisDao
public interface FirstDao {

	public void in_fi(First f);

	public void in_address(analysis_of_home_ownership adr);

	public void in_risk(risk_check_item_list ri);

	public void in_ch(check_item_details ch);

	public void in_overdue(overdue_details ov);

	public void in_plat(plat pl);

	public void in_court(court_information_field_table co);

	public void in_fre(frequency_details fr);

	public void in_ass(associated_information as);
	
	public First sel_first(String s);
	
	public List<analysis_of_home_ownership> sel_address(String s);
	
	public List<risk_check_item_list>  sel_risk(String s);
	
	public List<Map<String,Object>>  sel_risk_count(String s);
	
	public check_item_details sel_ch(String s);
	
	public List<plat>  sel_pl(String s);
	
	public List<frequency_details>  sel_fre(String s);
	
	public List<associated_information> sel_ass(String s);
	
	public List<court_information_field_table> sel_courts(String s);
	
	int count(First first);

	// 查询
	@Select("SELECT id from first WHERE name=#{name} and id_number=#{id_number} and phone_number=#{phone_number}")
	public First se_fi(First f);

	@Select("select id from analysis_of_home_ownership where #{f_address_detect_id}=analysis_of_home_ownership.f_address_detect_id")
	public analysis_of_home_ownership se_address(analysis_of_home_ownership adr);

	@Select("select id from risk_check_item_list where #{f_risk_items_id}=risk_check_item_list.f_risk_items_id")
	public List<risk_check_item_list> se_risk(risk_check_item_list ri);

	@Select("select id from check_item_details where #{risk_item_id}=check_item_details.risk_item_id")
	public List<check_item_details> se_ch(check_item_details ch);

	@Select("select id from overdue_details where #{check_item_id}=overdue_details.check_item_id")
	public List<overdue_details> se_overdue(overdue_details ov);

	@Select("select id from plat where #{check_item_id}=plat.check_item_id")
	public List<plat> se_plat(plat pl);

	@Select("select id from court_information_field_table where #{check_item_id}=court_information_field_table.check_item_id")
	public List<court_information_field_table> se_court(
			court_information_field_table co);

	@Select("select id from frequency_details where #{check_item_id}=frequency_details.check_item_id")
	public List<frequency_details> se_fre(frequency_details fr);

	@Select("select id from associated_information where #{frequency_details_id}=associated_information.frequency_details_id")
	public List<associated_information> se_ass(associated_information as);

	// 删除
	@Delete("delete from first WHERE id=#{id}")
	public void de_fi(First f);

	@Delete("delete from analysis_of_home_ownership where #{f_address_detect_id}=analysis_of_home_ownership.f_address_detect_id")
	public void de_address(analysis_of_home_ownership adr);

	@Delete("delete from risk_check_item_list where #{f_risk_items_id}=risk_check_item_list.f_risk_items_id")
	public void de_risk(risk_check_item_list ri);

	@Delete("delete from check_item_details where #{risk_item_id}=check_item_details.risk_item_id")
	public void de_ch(check_item_details ch);

	@Delete("delete from overdue_details where #{check_item_id}=overdue_details.check_item_id")
	public void de_overdue(overdue_details ov);

	@Delete("delete from plat where #{check_item_id}=plat.check_item_id")
	public void de_plat(plat pl);

	@Delete("delete from court_information_field_table where #{check_item_id}=court_information_field_table.check_item_id")
	public void de_court(court_information_field_table co);

	@Delete("delete from frequency_details where #{check_item_id}=frequency_details.check_item_id")
	public void de_fre(frequency_details fr);

	@Delete("delete from associated_information where #{frequency_details_id}=associated_information.frequency_details_id")
	public void de_ass(associated_information as);
	

}
