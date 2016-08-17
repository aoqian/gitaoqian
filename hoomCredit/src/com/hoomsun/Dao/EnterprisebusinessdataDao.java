package com.hoomsun.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;


import com.hoomsun.entity.Enterprisebusinessdata;

import com.hoomsun.util.MyBatisDao;

@MyBatisDao
public interface EnterprisebusinessdataDao {

	public void in_gs(Enterprisebusinessdata gs);
	
	public List<Enterprisebusinessdata>  sel_keyword(String key);

	@Insert("INSERT INTO enterprisebusinessdata (hc_id, ID, Code, ProvinceName, PinYin, MinSearchLen, Status, RegionId, KeyNo, Name, No, OperName, StartDate, BelongOrg, EndDate, Province, UpdateDate, ShortStatus, CreditCode, RegistCapi, EconKind, Address, Scope, TermStart, TeamEnd, CheckDate, StockName, StockType, StockPercent, IdentifyType, IdentifyNo, ShouldCapi, ShoudDate, InvestType, InvestName, RealCapi, CapiDate, Job, CerNo, ScertName, RegNo, ProjectName, BeforeContent, AfterContent, ChangeDate, PhoneNumber, Email, WebSiteName, WebSiteUrl, personnelName, Result, Dimension) VALUES (#{hc_id}, #{ID}, #{Code}, #{ProvinceName}, #{PinYin}, #{MinSearchLen}, #{Status}, #{RegionId}, #{KeyNo}, #{Name}, #{No}, #{OperName}, #{StartDate}, #{BelongOrg}, #{EndDate}, #{Province}, #{UpdateDate}, #{ShortStatus}, #{CreditCode}, #{RegistCapi}, #{EconKind}, #{Address}, #{Scope}, #{TermStart}, #{TeamEnd}, #{CheckDate}, #{StockName}, #{StockType}, #{StockPercent}, #{IdentifyType}, #{IdentifyNo}, #{ShouldCapi}, #{ShoudDate}, #{InvestType}, #{InvestName}, #{RealCapi}, #{CapiDate}, #{Job}, #{CerNo}, #{ScertName}, #{RegNo}, #{ProjectName}, #{BeforeContent}, #{AfterContent}, #{ChangeDate}, #{PhoneNumber}, #{Email}, #{WebSiteName}, #{WebSiteUrl}, #{personnelName}, #{Result}, #{Dimension})")
	void insertEnterprisebusinessdata(Enterprisebusinessdata enterprisebusinessdata);
}
