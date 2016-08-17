package com.hoomsun.entity;

public class cominformationverify {
 private int id;
 
 private String	num;//公司营业执照编号
 private String imgcompany;//营业执照照片
 private String namecompany;//公司全称
 private String	imgperson;//法人身份证照片
 private String	nameperson;//法人姓名
 private String userid;//用户id
 
 public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getImgcompany() {
	return imgcompany;
}
public void setImgcompany(String imgcompany) {
	this.imgcompany = imgcompany;
}
public String getNamecompany() {
	return namecompany;
}
public void setNamecompany(String namecompany) {
	this.namecompany = namecompany;
}
public String getImgperson() {
	return imgperson;
}
public void setImgperson(String imgperson) {
	this.imgperson = imgperson;
}
public String getNameperson() {
	return nameperson;
}
public void setNameperson(String nameperson) {
	this.nameperson = nameperson;
}

}
