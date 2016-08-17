package com.hoomsun.entity;

import java.io.Serializable;

/**
 * 
 * 企业工商数据查询
 * 
 * @author aoqian
 * 
 * @time 2016-7-8 上午10:00:14
 */
public class Enterprisebusinessdata implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hc_id; // 主键
	private String ID; // 系统内部ID
	private String Code; // 城市代码
	private String ProvinceName; // 城市名称
	private String PinYin; // 城市名称拼音
	private String MinSearchLen; // 最少搜索关键字长度
	private String Status; // 登记状态
	private String RegionId; // 地区ID
	private String KeyNo; // 公司内部关联主键
	private String Name; // 公司名称
	private String No; // 注册号或统一社会信用代码，默认统一社会信用代码
	private String Dimension;// 匹配出的搜索维度

	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return Dimension;
	}

	/**
	 * @param dimension
	 *            the dimension to set
	 */
	public void setDimension(String dimension) {
		Dimension = dimension;
	}

	private String OperName; // 法定代表人
	private String StartDate; // 成立日期
	private String BelongOrg; // 登记机关
	private String EndDate; // 注销/吊销日期
	private String Province; // 所在省份缩写
	private String UpdateDate; // 更新日期
	private String ShortStatus; // 状态简写
	private String CreditCode; // 统一社会信用代码
	private String RegistCapi; // 注册资本
	private String EconKind; // 类型
	private String Address; // 住所
	private String Scope; // 经营范围
	private String TermStart; // 营业期限自
	private String TeamEnd; // 营业期限至
	private String CheckDate; // 核准日期
	private String StockName; // 股东/发起人
	private String StockType; // 股东/发起人类型
	private String StockPercent; // 股份占比，保留字段
	private String IdentifyType; // 证照/证件类型
	private String IdentifyNo; // 证照/证件号码
	private String ShouldCapi; // 认缴出资额
	private String ShoudDate; // 认缴出资日期
	private String InvestType; // 认缴出资方式
	private String InvestName; // 实缴出资方式
	private String RealCapi; // 实缴出资额
	private String CapiDate; // 实缴出资日期
	private String Job; // 职位
	private String CerNo; // 证件号
	private String ScertName; // 证件名称
	private String RegNo; // 公司注册号码
	private String ProjectName; // 变更事项
	private String BeforeContent; // 变更前内容
	private String AfterContent; // 变更后内容
	private String ChangeDate; // 变更日期
	private String PhoneNumber; // 联系电话
	private String Email; // 联系邮箱
	private String WebSiteName; // 公司名
	private String WebSiteUrl; // 公司网站
	private String personnelName; // 主要人员姓名
	private String Result; // 省份代码

	/**
	 * @return the hc_id
	 */
	public String getHc_id() {
		return hc_id;
	}

	/**
	 * @param hc_id
	 *            the hc_id to set
	 */
	public void setHc_id(String hc_id) {
		this.hc_id = hc_id;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return Code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		Code = code;
	}

	/**
	 * @return the provinceName
	 */
	public String getProvinceName() {
		return ProvinceName;
	}

	/**
	 * @param provinceName
	 *            the provinceName to set
	 */
	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
	}

	/**
	 * @return the pinYin
	 */
	public String getPinYin() {
		return PinYin;
	}

	/**
	 * @param pinYin
	 *            the pinYin to set
	 */
	public void setPinYin(String pinYin) {
		PinYin = pinYin;
	}

	/**
	 * @return the minSearchLen
	 */
	public String getMinSearchLen() {
		return MinSearchLen;
	}

	/**
	 * @param minSearchLen
	 *            the minSearchLen to set
	 */
	public void setMinSearchLen(String minSearchLen) {
		MinSearchLen = minSearchLen;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return RegionId;
	}

	/**
	 * @param regionId
	 *            the regionId to set
	 */
	public void setRegionId(String regionId) {
		RegionId = regionId;
	}

	/**
	 * @return the keyNo
	 */
	public String getKeyNo() {
		return KeyNo;
	}

	/**
	 * @param keyNo
	 *            the keyNo to set
	 */
	public void setKeyNo(String keyNo) {
		KeyNo = keyNo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the no
	 */
	public String getNo() {
		return No;
	}

	/**
	 * @param no
	 *            the no to set
	 */
	public void setNo(String no) {
		No = no;
	}

	/**
	 * @return the operName
	 */
	public String getOperName() {
		return OperName;
	}

	/**
	 * @param operName
	 *            the operName to set
	 */
	public void setOperName(String operName) {
		OperName = operName;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return StartDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	/**
	 * @return the belongOrg
	 */
	public String getBelongOrg() {
		return BelongOrg;
	}

	/**
	 * @param belongOrg
	 *            the belongOrg to set
	 */
	public void setBelongOrg(String belongOrg) {
		BelongOrg = belongOrg;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return EndDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return Province;
	}

	/**
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		Province = province;
	}

	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return UpdateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}

	/**
	 * @return the shortStatus
	 */
	public String getShortStatus() {
		return ShortStatus;
	}

	/**
	 * @param shortStatus
	 *            the shortStatus to set
	 */
	public void setShortStatus(String shortStatus) {
		ShortStatus = shortStatus;
	}

	/**
	 * @return the creditCode
	 */
	public String getCreditCode() {
		return CreditCode;
	}

	/**
	 * @param creditCode
	 *            the creditCode to set
	 */
	public void setCreditCode(String creditCode) {
		CreditCode = creditCode;
	}

	/**
	 * @return the registCapi
	 */
	public String getRegistCapi() {
		return RegistCapi;
	}

	/**
	 * @param registCapi
	 *            the registCapi to set
	 */
	public void setRegistCapi(String registCapi) {
		RegistCapi = registCapi;
	}

	/**
	 * @return the econKind
	 */
	public String getEconKind() {
		return EconKind;
	}

	/**
	 * @param econKind
	 *            the econKind to set
	 */
	public void setEconKind(String econKind) {
		EconKind = econKind;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return Scope;
	}

	/**
	 * @param scope
	 *            the scope to set
	 */
	public void setScope(String scope) {
		Scope = scope;
	}

	/**
	 * @return the termStart
	 */
	public String getTermStart() {
		return TermStart;
	}

	/**
	 * @param termStart
	 *            the termStart to set
	 */
	public void setTermStart(String termStart) {
		TermStart = termStart;
	}

	/**
	 * @return the teamEnd
	 */
	public String getTeamEnd() {
		return TeamEnd;
	}

	/**
	 * @param teamEnd
	 *            the teamEnd to set
	 */
	public void setTeamEnd(String teamEnd) {
		TeamEnd = teamEnd;
	}

	/**
	 * @return the checkDate
	 */
	public String getCheckDate() {
		return CheckDate;
	}

	/**
	 * @param checkDate
	 *            the checkDate to set
	 */
	public void setCheckDate(String checkDate) {
		CheckDate = checkDate;
	}

	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return StockName;
	}

	/**
	 * @param stockName
	 *            the stockName to set
	 */
	public void setStockName(String stockName) {
		StockName = stockName;
	}

	/**
	 * @return the stockType
	 */
	public String getStockType() {
		return StockType;
	}

	/**
	 * @param stockType
	 *            the stockType to set
	 */
	public void setStockType(String stockType) {
		StockType = stockType;
	}

	/**
	 * @return the stockPercent
	 */
	public String getStockPercent() {
		return StockPercent;
	}

	/**
	 * @param stockPercent
	 *            the stockPercent to set
	 */
	public void setStockPercent(String stockPercent) {
		StockPercent = stockPercent;
	}

	/**
	 * @return the identifyType
	 */
	public String getIdentifyType() {
		return IdentifyType;
	}

	/**
	 * @param identifyType
	 *            the identifyType to set
	 */
	public void setIdentifyType(String identifyType) {
		IdentifyType = identifyType;
	}

	/**
	 * @return the identifyNo
	 */
	public String getIdentifyNo() {
		return IdentifyNo;
	}

	/**
	 * @param identifyNo
	 *            the identifyNo to set
	 */
	public void setIdentifyNo(String identifyNo) {
		IdentifyNo = identifyNo;
	}

	/**
	 * @return the shouldCapi
	 */
	public String getShouldCapi() {
		return ShouldCapi;
	}

	/**
	 * @param shouldCapi
	 *            the shouldCapi to set
	 */
	public void setShouldCapi(String shouldCapi) {
		ShouldCapi = shouldCapi;
	}

	/**
	 * @return the shoudDate
	 */
	public String getShoudDate() {
		return ShoudDate;
	}

	/**
	 * @param shoudDate
	 *            the shoudDate to set
	 */
	public void setShoudDate(String shoudDate) {
		ShoudDate = shoudDate;
	}

	/**
	 * @return the investType
	 */
	public String getInvestType() {
		return InvestType;
	}

	/**
	 * @param investType
	 *            the investType to set
	 */
	public void setInvestType(String investType) {
		InvestType = investType;
	}

	/**
	 * @return the investName
	 */
	public String getInvestName() {
		return InvestName;
	}

	/**
	 * @param investName
	 *            the investName to set
	 */
	public void setInvestName(String investName) {
		InvestName = investName;
	}

	/**
	 * @return the realCapi
	 */
	public String getRealCapi() {
		return RealCapi;
	}

	/**
	 * @param realCapi
	 *            the realCapi to set
	 */
	public void setRealCapi(String realCapi) {
		RealCapi = realCapi;
	}

	/**
	 * @return the capiDate
	 */
	public String getCapiDate() {
		return CapiDate;
	}

	/**
	 * @param capiDate
	 *            the capiDate to set
	 */
	public void setCapiDate(String capiDate) {
		CapiDate = capiDate;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return Job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		Job = job;
	}

	/**
	 * @return the cerNo
	 */
	public String getCerNo() {
		return CerNo;
	}

	/**
	 * @param cerNo
	 *            the cerNo to set
	 */
	public void setCerNo(String cerNo) {
		CerNo = cerNo;
	}

	/**
	 * @return the scertName
	 */
	public String getScertName() {
		return ScertName;
	}

	/**
	 * @param scertName
	 *            the scertName to set
	 */
	public void setScertName(String scertName) {
		ScertName = scertName;
	}

	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return RegNo;
	}

	/**
	 * @param regNo
	 *            the regNo to set
	 */
	public void setRegNo(String regNo) {
		RegNo = regNo;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return ProjectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	/**
	 * @return the beforeContent
	 */
	public String getBeforeContent() {
		return BeforeContent;
	}

	/**
	 * @param beforeContent
	 *            the beforeContent to set
	 */
	public void setBeforeContent(String beforeContent) {
		BeforeContent = beforeContent;
	}

	/**
	 * @return the afterContent
	 */
	public String getAfterContent() {
		return AfterContent;
	}

	/**
	 * @param afterContent
	 *            the afterContent to set
	 */
	public void setAfterContent(String afterContent) {
		AfterContent = afterContent;
	}

	/**
	 * @return the changeDate
	 */
	public String getChangeDate() {
		return ChangeDate;
	}

	/**
	 * @param changeDate
	 *            the changeDate to set
	 */
	public void setChangeDate(String changeDate) {
		ChangeDate = changeDate;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return PhoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the webSiteName
	 */
	public String getWebSiteName() {
		return WebSiteName;
	}

	/**
	 * @param webSiteName
	 *            the webSiteName to set
	 */
	public void setWebSiteName(String webSiteName) {
		WebSiteName = webSiteName;
	}

	/**
	 * @return the webSiteUrl
	 */
	public String getWebSiteUrl() {
		return WebSiteUrl;
	}

	/**
	 * @param webSiteUrl
	 *            the webSiteUrl to set
	 */
	public void setWebSiteUrl(String webSiteUrl) {
		WebSiteUrl = webSiteUrl;
	}

	/**
	 * @return the personnelName
	 */
	public String getPersonnelName() {
		return personnelName;
	}

	/**
	 * @param personnelName
	 *            the personnelName to set
	 */
	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return Result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		Result = result;
	}

	/**
	 * @param hc_id
	 * @param iD
	 * @param code
	 * @param provinceName
	 * @param pinYin
	 * @param minSearchLen
	 * @param status
	 * @param regionId
	 * @param keyNo
	 * @param name
	 * @param no
	 * @param dimension
	 * @param operName
	 * @param startDate
	 * @param belongOrg
	 * @param endDate
	 * @param province
	 * @param updateDate
	 * @param shortStatus
	 * @param creditCode
	 * @param registCapi
	 * @param econKind
	 * @param address
	 * @param scope
	 * @param termStart
	 * @param teamEnd
	 * @param checkDate
	 * @param stockName
	 * @param stockType
	 * @param stockPercent
	 * @param identifyType
	 * @param identifyNo
	 * @param shouldCapi
	 * @param shoudDate
	 * @param investType
	 * @param investName
	 * @param realCapi
	 * @param capiDate
	 * @param job
	 * @param cerNo
	 * @param scertName
	 * @param regNo
	 * @param projectName
	 * @param beforeContent
	 * @param afterContent
	 * @param changeDate
	 * @param phoneNumber
	 * @param email
	 * @param webSiteName
	 * @param webSiteUrl
	 * @param personnelName
	 * @param result
	 */
	public Enterprisebusinessdata(String hc_id, String iD, String code,
			String provinceName, String pinYin, String minSearchLen,
			String status, String regionId, String keyNo, String name,
			String no, String dimension, String operName, String startDate,
			String belongOrg, String endDate, String province,
			String updateDate, String shortStatus, String creditCode,
			String registCapi, String econKind, String address, String scope,
			String termStart, String teamEnd, String checkDate,
			String stockName, String stockType, String stockPercent,
			String identifyType, String identifyNo, String shouldCapi,
			String shoudDate, String investType, String investName,
			String realCapi, String capiDate, String job, String cerNo,
			String scertName, String regNo, String projectName,
			String beforeContent, String afterContent, String changeDate,
			String phoneNumber, String email, String webSiteName,
			String webSiteUrl, String personnelName, String result) {
		super();
		this.hc_id = hc_id;
		ID = iD;
		Code = code;
		ProvinceName = provinceName;
		PinYin = pinYin;
		MinSearchLen = minSearchLen;
		Status = status;
		RegionId = regionId;
		KeyNo = keyNo;
		Name = name;
		No = no;
		Dimension = dimension;
		OperName = operName;
		StartDate = startDate;
		BelongOrg = belongOrg;
		EndDate = endDate;
		Province = province;
		UpdateDate = updateDate;
		ShortStatus = shortStatus;
		CreditCode = creditCode;
		RegistCapi = registCapi;
		EconKind = econKind;
		Address = address;
		Scope = scope;
		TermStart = termStart;
		TeamEnd = teamEnd;
		CheckDate = checkDate;
		StockName = stockName;
		StockType = stockType;
		StockPercent = stockPercent;
		IdentifyType = identifyType;
		IdentifyNo = identifyNo;
		ShouldCapi = shouldCapi;
		ShoudDate = shoudDate;
		InvestType = investType;
		InvestName = investName;
		RealCapi = realCapi;
		CapiDate = capiDate;
		Job = job;
		CerNo = cerNo;
		ScertName = scertName;
		RegNo = regNo;
		ProjectName = projectName;
		BeforeContent = beforeContent;
		AfterContent = afterContent;
		ChangeDate = changeDate;
		PhoneNumber = phoneNumber;
		Email = email;
		WebSiteName = webSiteName;
		WebSiteUrl = webSiteUrl;
		this.personnelName = personnelName;
		Result = result;
	}

	/**
	 *
	 */
	public Enterprisebusinessdata() {
		super();
		// TODO Auto-generated constructor stub
	}

}
