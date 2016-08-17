package com.hoomsun.Controller.Login;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoomsun.util.ConnectUtil;
import com.hoomsun.util.JSONUtil;

/**
 * @author aoqian
 * 
 * @time 2016-7-6 下午4:40:17
 */

@Controller
@RequestMapping(value = "login")
public class LoginController {

	/*
	 * @Autowired private JSONUtil jsonUtil;
	 */
	private static final String key = "05ae3812e75044c492382bae2b61f2e9";
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "index")
	public String userLogin() {
		System.out.println("0");
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("ECISimple", "ECISimple");
		map.put("Search", "Search");
		map.put("key", key);
		map.put("keyword", "小米科技有限责任公司");
		String result = ConnectUtil.main(map);
//		 String result =
//		 "{\"Status\": \"200\",\"Message\": \"查询成功\",\"Result\": [{\"KeyNo\": \"5795c8cec1f47d9409f617759cd67758\",\"Name\": \"小米科技有限责任公司\",\"OperName\": \"雷军\",\"StartDate\": \"2012-02-16T00:00:00\",\"Status\": \"存续\", \"No\": \"420111000222960\"}]}";
//		 String result =
//		 "{\"Status\":\"200\",\"Message\":\"查询成功\",\"Result\":{\"TermStart\":\"2010-03-03T00:00:00+08:00\",\"TeamEnd\":\"2030-03-02T00:00:00+08:00\",\"CheckDate\":\"2016-04-20T00:00:00+08:00\",\"Partners\":[{\"StockName\":\"刘德\",\"StockType\":\"自然人股东\",\"StockPercent\":null,\"IdentifyType\":\"\",\"IdentifyNo\":\"\",\"ShouldCapi\":null,\"ShoudDate\":null,\"InvestType\":null,\"InvestName\":null,\"RealCapi\":null,\"CapiDate\":null,\"Address\":null}],\"Employees\":[{\"Name\":\"黎万强\",\"Job\":\"监事\",\"CerNo\":\"\",\"ScertName\":\"\"}],\"Branches\":[],\"ChangeRecords\":[{\"ProjectName\":\"注册资本\",\"BeforeContent\":\"5000万元\",\"AfterContent\":\"185000万元\",\"ChangeDate\":\"2016-03-24T00:00:00+08:00\"}],\"ContactInfo\":{\"WebSite\":[{\"Name\":\"小米科技\",\"Url\":\"www.xiaomi.com\"}],\"PhoneNumber\":\"60606666-1000\",\"Email\":\"chenchongwei@xiaomi.com\"},\"KeyNo\":\"9cce0780ab7644008b73bc2120479d31\",\"Name\":\"小米科技有限责任公司\",\"No\":\"110108012660422\",\"BelongOrg\":\"海淀分局\",\"OperName\":\"雷军\",\"StartDate\":\"2010-03-03T00:00:00+08:00\",\"EndDate\":null,\"Status\":\"在营（开业）企业\",\"Province\":\"BJ\",\"UpdatedDate\":\"2016-04-23T14:07:16.578+08:00\",\"CreditCode\":\"91110108551385082Q\",\"RegistCapi\":\"185000万元\",\"EconKind\":\"有限责任公司(自然人投资或控股)\",\"Address\":\"北京市海淀区清河中街68号华润五彩城购物中心二期13层\",\"Scope\":\"手机技术开发；手机生产、手机服务。（限海淀区永捷北路2号二层经营）；技术开发；货物进出口、技术进出口、代理进出口；销售通讯设备；维修仪器仪表；维修办公设备；承办展览展示活动；会议服务；筹备、策划、组织大型庆典。（企业依法自主选择经营项目，开展经营活动；依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\"}}";
		Map<String, Object> maps = JSONUtil.getListMap("Result", result);
		System.out.println(maps.get("Result9_Name"));
		int size = Integer.parseInt(maps.get("size").toString());
		if (size != 0 || size != 1) {
			System.out.println("返回的数据列表为---" + size);
			for (int i = 0; i < size; i++) {
				System.out.println(maps.get("Result" + i + "_Name"));
			}

		}
				
		return "login/login";
	}

	@RequestMapping(value = "querybox")
	public String queryBox() {
		return "querybox";
	}

	public static void main(String[] args) {
		String result = "{\"Status\": \"200\",\"Message\": \"查询成功\",\"Result\": [{\"KeyNo\": \"5795c8cec1f47d9409f617759cd67758\",\"Name\": \"小米科技有限责任公司\",\"OperName\": \"雷军\",\"StartDate\": \"2012-02-16T00:00:00\",\"Status\": \"存续\", \"No\": \"420111000222960\"}]}";
		String string = "{\"Status\":\"200\",\"Message\":\"查询成功\",\"Result\": {\"TermStart\":\"1996-03-20T00:00:00+08:00\",\"TeamEnd\":null,\"CheckDate\":\"1996-03-20T00:00:00+08:00\",\"Partners\": [  {  \"StockName\":\"华裕电器集团有限公司\",  \"StockType\":\"企业法人\",  \"StockPercent\":null,  \"IdentifyType\":\"企业法人营业执照(公司)\",  \"IdentifyNo\":\"3302822001404\",  \"ShouldCapi\":\"3496.500000 万元\",  \"ShoudDate\":\"\",  \"InvestType\":\"货币\",  \"InvestName\":\"货币\",  \"RealCapi\":\"3496.500000 万元\",  \"CapiDate\":\"2010年1月18日\",  \"Address\":null }],\"Employees\": [   {  \"Name\":\"徐志绒\",  \"Job\":\"监事\",  \"CerNo\":null,  \"ScertName\":null }],\"Branches\": [],\"ChangeRecords\": [  {  \"ProjectName\":\"经营期限(营业期限)变\",  \"BeforeContent\":\"1996-03-20~2016-03-19\",  \"AfterContent\":\"1996-03-20~\",  \"ChangeDate\":\"2015-11-12T00:00:00+08:00\" }],\"ContactInfo\": { \"WebSite\": [  {   \"Name\":\"上海红心器具有限公司\",   \"Url\":\"www.hongxin-sh.com\"  } ], \"PhoneNumber\":\"021-50281434\", \"Email\":\"553928043@qq.com\"},\"KeyNo\":\"6adf59b5d81d4d9ce6166651bb5d197e\",\"Name\":\"上海红心器具有限公司\",\"No\":\"310115000325650\",\"BelongOrg\":\"自贸试验区分局\",\"OperName\":\"徐万群\",\"StartDate\":\"1996-03-20T00:00:00+08:00\",\"EndDate\":null,\"Status\":\"存续（在营、开业、在册）\",\"Province\":\"SH\",\"UpdatedDate\":\"2016-03-18T00:00:00.011+08:00\",\"CreditCode\":\"913100006306127141\",\"RegistCapi\":\"4200万人民币\",\"EconKind\":\"有限责任公司\",\"Address\":\"中国（上海）自由贸易试验区杨高中路2108号\",\"Scope\":\"电熨斗、电饭锅、工业熨烫设备、家用小电器产品的制造加工，橡塑制品、五金交电、仪器仪表、电工器材、机电设备、建筑装潢材料、汽车配件的销售，燃气器具产品的开发制造和销售及售后服务，冰箱、洗衣机的开发、组装、销售及售后服务，从事货物及技术的进出口业务。\r\n【依法须经批准的项目，经相关部门批准后方可开展经营活动】\"}}";

		System.out.println(result);
		System.out.println(string);
	}

	@Test
	public void test() {
		// JSONUtil jsonUtil = new JSONUtil();
		String result = "{\"Status\": \"200\",\"Message\": \"查询成功\",\"Result\": [{\"KeyNo\": \"5795c8cec1f47d9409f617759cd67758\",\"Name\": \"小米科技有限责任公司\",\"OperName\": \"雷军\",\"StartDate\": \"2012-02-16T00:00:00\",\"Status\": \"存续\", \"No\": \"420111000222960\"}]}";
		// String result =
		// "{\"Status\":\"200\",\"Message\":\"查询成功\",\"Result\":{\"TermStart\":\"2010-03-03T00:00:00+08:00\",\"TeamEnd\":\"2030-03-02T00:00:00+08:00\",\"CheckDate\":\"2016-04-20T00:00:00+08:00\",\"Partners\":[{\"StockName\":\"刘德\",\"StockType\":\"自然人股东\",\"StockPercent\":null,\"IdentifyType\":\"\",\"IdentifyNo\":\"\",\"ShouldCapi\":null,\"ShoudDate\":null,\"InvestType\":null,\"InvestName\":null,\"RealCapi\":null,\"CapiDate\":null,\"Address\":null}],\"Employees\":[{\"Name\":\"黎万强\",\"Job\":\"监事\",\"CerNo\":\"\",\"ScertName\":\"\"}],\"Branches\":[],\"ChangeRecords\":[{\"ProjectName\":\"注册资本\",\"BeforeContent\":\"5000万元\",\"AfterContent\":\"185000万元\",\"ChangeDate\":\"2016-03-24T00:00:00+08:00\"}],\"ContactInfo\":{\"WebSite\":[{\"Name\":\"小米科技\",\"Url\":\"www.xiaomi.com\"}],\"PhoneNumber\":\"60606666-1000\",\"Email\":\"chenchongwei@xiaomi.com\"},\"KeyNo\":\"9cce0780ab7644008b73bc2120479d31\",\"Name\":\"小米科技有限责任公司\",\"No\":\"110108012660422\",\"BelongOrg\":\"海淀分局\",\"OperName\":\"雷军\",\"StartDate\":\"2010-03-03T00:00:00+08:00\",\"EndDate\":null,\"Status\":\"在营（开业）企业\",\"Province\":\"BJ\",\"UpdatedDate\":\"2016-04-23T14:07:16.578+08:00\",\"CreditCode\":\"91110108551385082Q\",\"RegistCapi\":\"185000万元\",\"EconKind\":\"有限责任公司(自然人投资或控股)\",\"Address\":\"北京市海淀区清河中街68号华润五彩城购物中心二期13层\",\"Scope\":\"手机技术开发；手机生产、手机服务。（限海淀区永捷北路2号二层经营）；技术开发；货物进出口、技术进出口、代理进出口；销售通讯设备；维修仪器仪表；维修办公设备；承办展览展示活动；会议服务；筹备、策划、组织大型庆典。（企业依法自主选择经营项目，开展经营活动；依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\"}}";
		Map<String, Object> list = JSONUtil.getListMap("Result", result);
		System.out.println(list.get("Result_No"));

	}
}
