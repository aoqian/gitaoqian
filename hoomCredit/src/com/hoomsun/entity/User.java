package com.hoomsun.entity;

public class User {
	private String id;
	private String Name;
	private String Telphone;
	private String Code;
	private String usertype;
	private String registerDate;
	
	
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTelphone() {
		return Telphone;
	}
	public void setTelphone(String telphone) {
		Telphone = telphone;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	/**
	 * @return the usertype
	 */
	public String getUsertype() {
		return usertype;
	}
	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	/**
	 *@param id
	 *@param name
	 *@param telphone
	 *@param code
	 *@param usertype
	 */
	public User(String id, String name, String telphone, String code,
			String usertype,String registerdate) {
		super();
		this.id = id;
		Name = name;
		Telphone = telphone;
		Code = code;
		this.usertype = usertype;
		registerDate=registerdate;
	}
	public User(String name, String telphone, String code,
			String usertype,String registerdate) {
		super();
		Name = name;
		Telphone = telphone;
		Code = code;
		this.usertype = usertype;
		registerDate=registerdate;
	}
	/**
	 *
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


}
