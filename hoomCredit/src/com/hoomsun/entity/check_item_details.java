package com.hoomsun.entity;

import java.io.Serializable;

public class check_item_details implements Serializable{
	
	private String id;
	private String risk_item_id;

	private String discredit_times;//信贷逾期次数
	private String overdue_details;//逾期详情
	private String platform_count;//多头借贷
	private String platform_detail;//借贷详情
	private String high_risk_areas;//高风险区域
	private String hit_list_datas;//中介关键词
	private String court_details;//法院详情信息列表
	private String fraud_type;//风险类型
	private String frequency_detail_list;//频度详情

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRisk_item_id() {
		return risk_item_id;
	}
	public void setRisk_item_id(String risk_item_id) {
		this.risk_item_id = risk_item_id;
	}
	public String getDiscredit_times() {
		return discredit_times;
	}
	public void setDiscredit_times(String discredit_times) {
		this.discredit_times = discredit_times;
	}
	public String getOverdue_details() {
		return overdue_details;
	}
	public void setOverdue_details(String overdue_details) {
		this.overdue_details = overdue_details;
	}
	public String getPlatform_count() {
		return platform_count;
	}
	public void setPlatform_count(String platform_count) {
		this.platform_count = platform_count;
	}
	public String getPlatform_detail() {
		return platform_detail;
	}
	public void setPlatform_detail(String platform_detail) {
		this.platform_detail = platform_detail;
	}
	public String getHigh_risk_areas() {
		return high_risk_areas;
	}
	public void setHigh_risk_areas(String high_risk_areas) {
		this.high_risk_areas = high_risk_areas;
	}
	public String getHit_list_datas() {
		return hit_list_datas;
	}
	public void setHit_list_datas(String hit_list_datas) {
		this.hit_list_datas = hit_list_datas;
	}
	public String getCourt_details() {
		return court_details;
	}
	public void setCourt_details(String court_details) {
		this.court_details = court_details;
	}
	public String getFraud_type() {
		return fraud_type;
	}
	public void setFraud_type(String fraud_type) {
		this.fraud_type = fraud_type;
	}
	public String getFrequency_detail_list() {
		return frequency_detail_list;
	}
	public void setFrequency_detail_list(String frequency_detail_list) {
		this.frequency_detail_list = frequency_detail_list;
	}


}
