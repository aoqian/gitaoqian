package com.hoomsun.Service;

import java.util.List;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoomsun.Dao.FirstDao;
import com.hoomsun.entity.First;
import com.hoomsun.entity.analysis_of_home_ownership;
import com.hoomsun.entity.associated_information;
import com.hoomsun.entity.check_item_details;
import com.hoomsun.entity.court_information_field_table;
import com.hoomsun.entity.frequency_details;
import com.hoomsun.entity.overdue_details;
import com.hoomsun.entity.plat;
import com.hoomsun.entity.risk_check_item_list;

@Service
public class FirstService {

	@Autowired
	private FirstDao dao;

	public void in_fi(First f) {
		dao.in_fi(f);

	}

	public void in_address(analysis_of_home_ownership adr) {
		dao.in_address(adr);
	}

	public void in_risk(risk_check_item_list ri) {
		dao.in_risk(ri);
	}

	public void in_ch(check_item_details ch) {
		dao.in_ch(ch);
	}

	public void in_overdue(overdue_details ov) {
		dao.in_overdue(ov);
	}

	public void in_plat(plat pl) {
		dao.in_plat(pl);
	}

	public void in_court(court_information_field_table co) {
		dao.in_court(co);
	}

	public void in_fre(frequency_details fr) {
		dao.in_fre(fr);
	}

	public void in_ass(associated_information as) {
		dao.in_ass(as);
	}
	
   public First sel_first(String s){
	  First fi= dao.sel_first(s);
	  return fi;
   }
	
	public List<analysis_of_home_ownership> sel_address(String s){
		List<analysis_of_home_ownership> an=dao.sel_address(s);
		return an;
	}
	
	public List<risk_check_item_list>  sel_risk(String s){
		List<risk_check_item_list>  re=dao.sel_risk(s);
		return re;
	}
	
	public List<Map<String,Object>>  sel_risk_count(String s){
		List<Map<String,Object>> li=dao.sel_risk_count(s);
		return li;
	}
	
	public check_item_details sel_ch(String s){
		check_item_details ch=dao.sel_ch(s);
	
		return ch;
	}
	
	public List<plat>  sel_pl(String s){
		List<plat> pls=dao.sel_pl(s);
		
		return pls;
	}
	
    public List<frequency_details>  sel_fre(String s){
    	List<frequency_details> lif1=dao.sel_fre(s);
    	return lif1;
    }
	
	public List<associated_information> sel_ass(String s){
		List<associated_information> lie=dao.sel_ass(s);
		return lie;
	}
	
	public List<court_information_field_table> courts(String co){
		List<court_information_field_table> courts=dao.sel_courts(co);
		return courts;
	}

	// 查询
	public First se_fi(First f) {
		return dao.se_fi(f);
	};

	public analysis_of_home_ownership se_address(analysis_of_home_ownership adr) {
		return dao.se_address(adr);
	};

	public List<risk_check_item_list> se_risk(risk_check_item_list ri) {
		return dao.se_risk(ri);
	};

	public List<check_item_details> se_ch(check_item_details ch) {
		return dao.se_ch(ch);
	};

	public List<overdue_details> se_overdue(overdue_details ov) {
		return dao.se_overdue(ov);
	};

	public List<plat> se_plat(plat pl) {
		return dao.se_plat(pl);
	};

	public List<court_information_field_table> se_court(
			court_information_field_table co) {
		return dao.se_court(co);
	};

	public List<frequency_details> se_fre(frequency_details fr) {
		return dao.se_fre(fr);
	};

	public List<associated_information> se_ass(associated_information as) {
		return dao.se_ass(as);
	};

	// 删除
	public void de_fi(First f) {
		dao.de_fi(f);
	};

	public void de_address(analysis_of_home_ownership adr) {
		dao.de_address(adr);
	};

	public void de_risk(risk_check_item_list ri) {
		dao.de_risk(ri);
	};

	public void de_ch(check_item_details ch) {
		dao.de_ch(ch);
	};

	public void de_overdue(overdue_details ov) {
		dao.de_overdue(ov);
	};

	public void de_plat(plat pl) {
		dao.de_plat(pl);
	};

	public void de_court(court_information_field_table co) {
		dao.de_court(co);
	};

	public void de_fre(frequency_details fr) {
		dao.de_fre(fr);
	};

	public void de_ass(associated_information as) {
		dao.de_ass(as);
	};

}
