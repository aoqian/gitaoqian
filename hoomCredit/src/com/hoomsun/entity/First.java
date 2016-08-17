package com.hoomsun.entity;

import java.io.Serializable;

public class First implements Serializable {
	private String id;
	private String success; // 接口调用是否成功
	private String reason_code; // 错误代码
	private String reason_desc; // 错误描述
	private String final_score; // 风险分数
	private String final_decision; // 风险结果
	private String report_id; // 报告编号
	private String device_type; // 设备类型
	private String proxy_info; // 代理信息
	private String apply_time; // 扫描时间
	private String device_info; // 设备环境信息
	private String geo_ip; // 地理位置信息
	private String geo_trueip; // 真实地理位置信息
	private String risk_items; // 扫描出来的风险项
	private String kunta_call_result; // 第三方数据源调用详情
	private String address_detect; // 归属地解析
	private String relevance_id;
	private String report_time; // 报告时间
	private String name; // 姓名
	private String id_number; // 身份证号
	private String phone_number;// 手机号码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public String getReason_desc() {
		return reason_desc;
	}

	public void setReason_desc(String reason_desc) {
		this.reason_desc = reason_desc;
	}

	public String getFinal_score() {
		return final_score;
	}

	public void setFinal_score(String final_score) {
		this.final_score = final_score;
	}

	public String getFinal_decision() {
		return final_decision;
	}

	public void setFinal_decision(String final_decision) {
		this.final_decision = final_decision;
	}

	public String getReport_id() {
		return report_id;
	}

	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	public String getProxy_info() {
		return proxy_info;
	}

	public void setProxy_info(String proxy_info) {
		this.proxy_info = proxy_info;
	}

	public String getApply_time() {
		return apply_time;
	}

	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}

	public String getReport_time() {
		return report_time;
	}

	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getGeo_ip() {
		return geo_ip;
	}

	public void setGeo_ip(String geo_ip) {
		this.geo_ip = geo_ip;
	}

	public String getGeo_trueip() {
		return geo_trueip;
	}

	public void setGeo_trueip(String geo_trueip) {
		this.geo_trueip = geo_trueip;
	}

	public String getRisk_items() {
		return risk_items;
	}

	public void setRisk_items(String risk_items) {
		this.risk_items = risk_items;
	}

	public String getKunta_call_result() {
		return kunta_call_result;
	}

	public void setKunta_call_result(String kunta_call_result) {
		this.kunta_call_result = kunta_call_result;
	}

	public String getAddress_detect() {
		return address_detect;
	}

	public void setAddress_detect(String address_detect) {
		this.address_detect = address_detect;
	}

	public String getRelevance_id() {
		return relevance_id;
	}

	public void setRelevance_id(String relevance_id) {
		this.relevance_id = relevance_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id_number
	 */
	public String getId_number() {
		return id_number;
	}

	/**
	 * @param id_number
	 *            the id_number to set
	 */
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	/**
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * @param phone_number
	 *            the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * @param id
	 * @param success
	 * @param reason_code
	 * @param reason_desc
	 * @param final_score
	 * @param final_decision
	 * @param report_id
	 * @param device_type
	 * @param proxy_info
	 * @param apply_time
	 * @param device_info
	 * @param geo_ip
	 * @param geo_trueip
	 * @param risk_items
	 * @param kunta_call_result
	 * @param address_detect
	 * @param relevance_id
	 * @param report_time
	 * @param name
	 * @param id_number
	 * @param phone_number
	 */
	public First(String id, String success, String reason_code,
			String reason_desc, String final_score, String final_decision,
			String report_id, String device_type, String proxy_info,
			String apply_time, String device_info, String geo_ip,
			String geo_trueip, String risk_items, String kunta_call_result,
			String address_detect, String relevance_id, String report_time,
			String name, String id_number, String phone_number) {
		super();
		this.id = id;
		this.success = success;
		this.reason_code = reason_code;
		this.reason_desc = reason_desc;
		this.final_score = final_score;
		this.final_decision = final_decision;
		this.report_id = report_id;
		this.device_type = device_type;
		this.proxy_info = proxy_info;
		this.apply_time = apply_time;
		this.device_info = device_info;
		this.geo_ip = geo_ip;
		this.geo_trueip = geo_trueip;
		this.risk_items = risk_items;
		this.kunta_call_result = kunta_call_result;
		this.address_detect = address_detect;
		this.relevance_id = relevance_id;
		this.report_time = report_time;
		this.name = name;
		this.id_number = id_number;
		this.phone_number = phone_number;
	}

	/**
	 *
	 */
	public First() {
		super();
		// TODO Auto-generated constructor stub
	}

}
