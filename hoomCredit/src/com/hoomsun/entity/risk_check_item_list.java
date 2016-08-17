package com.hoomsun.entity;

import java.io.Serializable;

public class risk_check_item_list implements Serializable{
	
	private String id;
	private String f_risk_items_id;
	private String item_id;		  //	检查项编号
	private String item_name;	  //	检查项名称
	private String risk_level;	  //	风险等级
	private String groups;		  //	检查项分组
	private String item_detail;	  //	检查详情
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getF_risk_items_id() {
		return f_risk_items_id;
	}
	public void setF_risk_items_id(String f_risk_items_id) {
		this.f_risk_items_id = f_risk_items_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getRisk_level() {
		return risk_level;
	}
	public void setRisk_level(String risk_level) {
		this.risk_level = risk_level;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public String getItem_detail() {
		return item_detail;
	}
	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}



}
