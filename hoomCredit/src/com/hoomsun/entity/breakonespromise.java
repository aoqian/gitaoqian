package com.hoomsun.entity;

import java.io.Serializable;

/**
 * 失信被执行人查询
 * @author Administrator
 *
 */
public class breakonespromise implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String a1;
	private String Id;//ID
	private String Sourceid;//官网系统ID
	private String Name;//名称
	private String Liandate;//立案时间
	private String Anno;//立案号
	private String Biaodi;//标地
	private String Status;//状态
	private String Orgno;//身份证号码/组织机构代码
	private String Uniqueno;//唯一编号
	private String Ownername;//法定代表人或者负责人姓名
	private String Executegov;//执行法院
	private String Province;//所在省份缩写
	private String Executeunite;//做出执行依据单位
	private String Yiwu;//生效法律文书确定的义务
	private String Executestatus;//被执行人的履行情况
	private String Actionremark;//失信被执行人行为具体情形
	private String Publicdate;//发布时间
	private String Follows;//关注次数（现在官网返回全部为0）
	private String Age;//年龄
	private String Sexy;//性别
	private String Createdate;//数据创建时间
	private String Updatedate;//数据更新时间
	private String Executeno;//执行依据文号
	private String Performedpart;//已履行
	private String Unperformpart;//未履行
	private String Isperson;//公司或个人
	private String Cate;//失信人/被执行人

	public String getCate() {
		return Cate;
	}
	public void setCate(String cate) {
		Cate = cate;
	}
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getSourceid() {
		return Sourceid;
	}
	public void setSourceid(String sourceid) {
		Sourceid = sourceid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLiandate() {
		return Liandate;
	}
	public void setLiandate(String liandate) {
		Liandate = liandate;
	}
	public String getAnno() {
		return Anno;
	}
	public void setAnno(String anno) {
		Anno = anno;
	}
	public String getBiaodi() {
		return Biaodi;
	}
	public void setBiaodi(String biaodi) {
		Biaodi = biaodi;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getOrgno() {
		return Orgno;
	}
	public void setOrgno(String orgno) {
		Orgno = orgno;
	}
	public String getUniqueno() {
		return Uniqueno;
	}
	public void setUniqueno(String uniqueno) {
		Uniqueno = uniqueno;
	}
	public String getOwnername() {
		return Ownername;
	}
	public void setOwnername(String ownername) {
		Ownername = ownername;
	}
	public String getExecutegov() {
		return Executegov;
	}
	public void setExecutegov(String executegov) {
		Executegov = executegov;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getExecuteunite() {
		return Executeunite;
	}
	public void setExecuteunite(String executeunite) {
		Executeunite = executeunite;
	}
	public String getYiwu() {
		return Yiwu;
	}
	public void setYiwu(String yiwu) {
		Yiwu = yiwu;
	}
	public String getExecutestatus() {
		return Executestatus;
	}
	public void setExecutestatus(String executestatus) {
		Executestatus = executestatus;
	}
	public String getActionremark() {
		return Actionremark;
	}
	public void setActionremark(String actionremark) {
		Actionremark = actionremark;
	}
	public String getPublicdate() {
		return Publicdate;
	}
	public void setPublicdate(String publicdate) {
		Publicdate = publicdate;
	}
	public String getFollows() {
		return Follows;
	}
	public void setFollows(String follows) {
		Follows = follows;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getSexy() {
		return Sexy;
	}
	public void setSexy(String sexy) {
		Sexy = sexy;
	}
	public String getCreatedate() {
		return Createdate;
	}
	public void setCreatedate(String createdate) {
		Createdate = createdate;
	}
	public String getUpdatedate() {
		return Updatedate;
	}
	public void setUpdatedate(String updatedate) {
		Updatedate = updatedate;
	}
	public String getExecuteno() {
		return Executeno;
	}
	public void setExecuteno(String executeno) {
		Executeno = executeno;
	}
	public String getPerformedpart() {
		return Performedpart;
	}
	public void setPerformedpart(String performedpart) {
		Performedpart = performedpart;
	}
	public String getUnperformpart() {
		return Unperformpart;
	}
	public void setUnperformpart(String unperformpart) {
		Unperformpart = unperformpart;
	}
	public String getIsperson() {
		return Isperson;
	}
	public void setIsperson(String isperson) {
		Isperson = isperson;
	}

}
