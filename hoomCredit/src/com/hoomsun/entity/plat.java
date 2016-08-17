package com.hoomsun.entity;

import java.io.Serializable;

public class plat implements Serializable{
	
	private String id;
	private String check_item_id;
	private String plat_type;
	private String count;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCheck_item_id() {
		return check_item_id;
	}
	public void setCheck_item_id(String check_item_id) {
		this.check_item_id = check_item_id;
	}
	public String getPlat_type() {
		return plat_type;
	}
	public void setPlat_type(String plat_type) {
		this.plat_type = plat_type;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	


}
