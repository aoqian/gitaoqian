package com.hoomsun.entity;

import java.io.Serializable;

public class analysis_of_home_ownership implements Serializable {
	private String id;
	private String f_address_detect_id;
	private String id_card_address; // 身份证所属地地
	private String mobile_address; // 手机所属地地址
	private String true_ip_address; // ip所属地地址
	private String wifi_address; // wifi所属地地址
	private String cell_address; // 基站所属地地址

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getF_address_detect_id() {
		return f_address_detect_id;
	}

	public void setF_address_detect_id(String f_address_detect_id) {
		this.f_address_detect_id = f_address_detect_id;
	}

	public String getId_card_address() {
		return id_card_address;
	}

	public void setId_card_address(String id_card_address) {
		this.id_card_address = id_card_address;
	}

	public String getMobile_address() {
		return mobile_address;
	}

	public void setMobile_address(String mobile_address) {
		this.mobile_address = mobile_address;
	}

	public String getTrue_ip_address() {
		return true_ip_address;
	}

	public void setTrue_ip_address(String true_ip_address) {
		this.true_ip_address = true_ip_address;
	}

	public String getWifi_address() {
		return wifi_address;
	}

	public void setWifi_address(String wifi_address) {
		this.wifi_address = wifi_address;
	}

	public String getCell_address() {
		return cell_address;
	}

	public void setCell_address(String cell_address) {
		this.cell_address = cell_address;
	}

}
