package com.hoomsun.entity;

import java.io.Serializable;

public class frequency_details implements Serializable {
	
	private String id;
	private String check_item_id;
	private String detail;
	private String data;
	
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}


}
