package com.hoomsun.entity;

import java.io.Serializable;

public class associated_information implements Serializable {
	
	private String id;
	private String frequency_details_id;
	private String data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrequency_details_id() {
		return frequency_details_id;
	}
	public void setFrequency_details_id(String frequency_details_id) {
		this.frequency_details_id = frequency_details_id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
