package com.hoomsun.entity;

import java.io.Serializable;

public class overdue_details implements Serializable {

	private String id;
	private String check_item_id;
	private String overdue_amount; // 逾期金额
	private String overdue_count; // 逾期笔数
	private String overdue_day; // 逾期天数

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

	public String getOverdue_amount() {
		return overdue_amount;
	}

	public void setOverdue_amount(String overdue_amount) {
		this.overdue_amount = overdue_amount;
	}

	public String getOverdue_count() {
		return overdue_count;
	}

	public void setOverdue_count(String overdue_count) {
		this.overdue_count = overdue_count;
	}

	public String getOverdue_day() {
		return overdue_day;
	}

	public void setOverdue_day(String overdue_day) {
		this.overdue_day = overdue_day;
	}

}
