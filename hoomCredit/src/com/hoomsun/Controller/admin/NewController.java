package com.hoomsun.Controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoomsun.Service.Connect;

import com.hoomsun.Service.UserService;
import com.hoomsun.Service.cominformationverifyService;

import com.hoomsun.Service.nationbreakspromiseService;
import com.hoomsun.Service.creditImpl.BreakonespromiseServiceImpl;
import com.hoomsun.Service.creditImpl.EnterprisebusinessdataImpl;
import com.hoomsun.Service.creditImpl.SmsauLoginServiceImpl;


import com.hoomsun.entity.Enterprisebusinessdata;
import com.hoomsun.entity.Record;
import com.hoomsun.entity.User;
import com.hoomsun.entity.breakonespromise;
import com.hoomsun.entity.cominformationverify;
import com.hoomsun.entity.nationbreakspromise;
import com.hoomsun.util.ConnectUtil;
import com.hoomsun.util.JSONUtil;

@Controller
@RequestMapping(value = "New")
public class NewController {

	@Autowired
	private BreakonespromiseServiceImpl impl;
	
	@Autowired
	private Connect con;
	
	@Autowired
	private EnterprisebusinessdataImpl impl_enterprise;
	@Autowired
	private UserService userService;
	@Autowired
	private SmsauLoginServiceImpl loginServiceImpl;
	@Autowired
	private cominformationverifyService civService;
	@Autowired
	private nationbreakspromiseService naService;

	private static final String key = "4735f1946b8448c383d82849a1f950fa";// 接口ApiKey编号唯一

	private String name = "张三";

	/**
	 * 失信人和被执行人信息查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "SearchCourt")
	public String searchinformation(HttpServletRequest request) {
		List<breakonespromise> list1 = SearchCourt(name, 1);
		// Education(name,"450481199209160078");
		// driving(name,"450481199209160078");

		request.setAttribute("personList", list1);
		return "e_register";
	}

	// 进入首页页面
	@RequestMapping("first")
	public String firstPage(HttpServletRequest request) {
		Map<String, String> map11 = new HashMap<String, String>();
		map11.put("from", "hotheadlines");
		List<Map<String, Object>> list = impl.SelAlls(map11);
		if (list != null && list.size() > 7) {
			list = list.subList(0, 7);
		}

		request.setAttribute("list", list);
		return "home1";
	}

	// 进入登录页面
	@RequestMapping("login")
	public String EnterPage() {

		return "enter";
	}

	// 进入个人注册页面
	@RequestMapping("register")
	public String regi() {

		return "p_register";
	}

	// 进入企业注册页面
	@RequestMapping("registers")
	public String regis() {

		return "e_register";
	}

	// 个人初级查询
	@RequestMapping("primary")
	public String first(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("word");
		request.setAttribute("keyword", keyword);
		List<breakonespromise> list1 = SearchCourt(keyword, 1);

		Map<String, String> map11 = new HashMap<String, String>();
		map11.put("from", "breakonespromise");
		map11.put("Column1", "Name");
		map11.put("Column2", keyword);
		int totalPage = impl.SelCount(map11);

		if (totalPage % 5 == 0) {

			totalPage = totalPage / 5;
		} else {
			totalPage = (totalPage / 5) + 1;
			System.out.println(totalPage + "------总共有多少页------");
		}
		request.setAttribute("totalPage", totalPage);

		request.setAttribute("personList", list1);
		request.getSession().setAttribute("keyword", keyword);

		return "search";
	}

	// 企业初级查询
	@RequestMapping("primarys")
	public String firsts(HttpServletRequest request,
			HttpServletResponse response) {
		String keyword = request.getParameter("word");
		request.setAttribute("keyword", keyword);
		if (keyword != null && keyword != "") {
			List<Enterprisebusinessdata> list1 = SearchWide(keyword, 1);

			int totalPage = list1.size();

			if (totalPage % 5 == 0) {

				totalPage = totalPage / 5;
			} else {
				totalPage = (totalPage / 5) + 1;
				System.out.println(totalPage + "------总共有多少页------");
			}
			request.setAttribute("totalPage", totalPage);

			request.setAttribute("companyList", list1);
		}

		request.getSession().setAttribute("keyword", keyword);
		return "e_search";
	}

	// 中级查询
	@RequestMapping("intermediate")
	public String second() {

		return "home2";
	}

	// 高级查询
	@RequestMapping("senior")
	public String third() {

		return "home2";
	}

	
	// 关于我们
	@RequestMapping("our")
	public String aboutour(HttpServletRequest request) {
		Map<String, String> map11 = new HashMap<String, String>();
		map11.put("from", "hotheadlines");
		List<Map<String, Object>> list = impl.SelAlls(map11);

		request.setAttribute("list", list);
		// ----分页
		int as = list.size();
		int totalpage = 1;
		int am = as % 8;
		if (am == 0) {
			totalpage = as / 8;
		} else {
			totalpage = as / 8 + 1;
		}

		request.setAttribute("totalpage", totalpage);

		return "aboutOur";
	}

	// 新闻信息详情页面
	@RequestMapping("hot_detail")
	public String news(HttpServletRequest request) {
		String id = request.getParameter("id");
		String headline = null;
		String content = null;
		String related_company = null;
		String time = null;
		if (id != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("from", "hotheadlines");
			map.put("Column1", "id");
			map.put("Column2", id);
			List<Map<String, Object>> list = impl.SelAll(map);

			for (Map<String, Object> maps : list) {
				headline = maps.get("headline").toString();
				content = maps.get("content").toString();
				related_company = maps.get("related_company").toString();
				time = maps.get("time").toString();
			}
			request.setAttribute("headline", headline);
			request.setAttribute("content", content);
			request.setAttribute("related_company", related_company);
			request.setAttribute("time", time);

		}
		return "hot";
	}

	// 此电话号码是否已被注册
	@RequestMapping("tel")
	@ResponseBody
	public int register_tel(HttpServletRequest request) {

		String tel = request.getParameter("telphone");
		List<User> list = userService.isexist_tel(tel);
		int a1 = list.size();
		return a1;

	}

	// 个人注册
	@RequestMapping("register_p")
	public String register_personal(HttpServletRequest request) {
		String username = request.getParameter("name");
		String telphone = request.getParameter("telphone");
		String code = request.getParameter("code");
		User user = new User();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(date));
		user.setRegisterDate(format.format(date));
		user.setCode(code);
		user.setName(username);
		user.setTelphone(telphone);
		user.setUsertype("1");
		userService.in_user(user);
		System.out.println("______" + username + "________" + telphone
				+ "_________" + code);
		return "redirect:enter.do?telphone=" + telphone + "&code=" + code;
	}

	// 企业注册
	@RequestMapping("register_e")
	public String register_company(HttpServletRequest request) {
		String conname = request.getParameter("name");
		String telphone = request.getParameter("telphone");
		String code = request.getParameter("code");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(date));
		User user = new User(conname, telphone, code, "0", format.format(date));
		loginServiceImpl.in_user(user);
		System.out.println("______" + conname + "________" + telphone
				+ "_________" + code);
		return "redirect:enter.do?telphone=" + telphone + "&code=" + code;
	}

	// cominformationverify//name,"user":user,"license":license,"imgper":imgper,"imgcom":imgcom
	// 企业实名认证
	@RequestMapping("civ")
	@ResponseBody
	public String companyinformationverify(HttpServletRequest request) {
		System.out.println("--------企业实名认证");
		String com_name = request.getParameter("name");
		String user = request.getParameter("user");
		String com_num = request.getParameter("license");
		String imgper = request.getParameter("imgper");
		String imgcom = request.getParameter("imgcom");
		cominformationverify civ = new cominformationverify();
		civ.setImgcompany(imgcom);
		civ.setImgperson(imgper);
		civ.setNamecompany(com_name);
		civ.setNameperson(user);
		civ.setNum(com_num);
		civ.setUserid("2");
		civService.in_civ(civ);
		return "0";
	}

	// 个人登录
	@RequestMapping("enter")
	public String enter(HttpServletRequest request) {

		String telphone = request.getParameter("telphone");
		String code = request.getParameter("code");
		// ----存入session

		System.out.println("________" + telphone + "_________" + code);
		User user = new User();
		user.setCode(code);
		user.setTelphone(telphone);
		User u1 = userService.isexist(user);
		if (u1 != null) {
			System.out.println("-------------" + u1.getId());
			request.setAttribute("u1", u1);

			String type = u1.getUsertype();
			// 将该用户set到session
			request.getSession().setAttribute("user", u1);
			User user2 = (User) request.getSession().getAttribute("user");
			System.out.println(user2.getName());

			if (type.equals("0")) {
				return "company";
			} else {
				// 查询查看记录
				User user1 = (User) request.getSession().getAttribute("user");
				List<Record> records = impl.selectRecord(user1.getId());
				request.setAttribute("records", records);

				// 分页
				Map<String, String> map11 = new HashMap<String, String>();
				map11.put("from", "record");
				map11.put("Column1", "userid");
				map11.put("Column2", user1.getId());
				int totalPage = impl.SelCountWhere(user1.getId());

				if (totalPage % 8 == 0) {

					totalPage = totalPage / 8;
				} else {
					totalPage = (totalPage / 8) + 1;
					System.out.println(totalPage + "------总共有多少页------");
				}
				request.setAttribute("totalPage", totalPage);
				return "individual";
			}

		} else {
			System.out.println("-------------" + 222);
			return "enter";
		}

	}

	/**
	 * 查询记录
	 * 
	 * @return
	 */
	@RequestMapping("queryLog")
	public String queryLog(HttpServletRequest request) {

		// 查询查看记录
		User user1 = (User) request.getSession().getAttribute("user");
		if (user1 != null) {
			List<Record> records = impl.selectRecord(user1.getId());
			request.setAttribute("records", records);

			// 分页
			Map<String, String> map11 = new HashMap<String, String>();
			map11.put("from", "record");
			map11.put("Column1", "userid");
			map11.put("Column2", user1.getId());
			int totalPage = impl.SelCountWhere(user1.getId());

			if (totalPage % 8 == 0) {

				totalPage = totalPage / 8;
			} else {
				totalPage = (totalPage / 8) + 1;
				System.out.println(totalPage + "------总共有多少页------");
			}
			request.setAttribute("totalPage", totalPage);
			return "individual";
		} else {
			return "enter";
		}

	}

	// 进入个人中心
	@RequestMapping("personal")
	public String p_center(HttpServletRequest request) {

		User user1 = (User) request.getSession().getAttribute("user");
		if (user1 != null) {
			List<Record> records = impl.selectRecord(user1.getId());
			request.setAttribute("records", records);
			request.setAttribute("u1", user1);

			// 分页
			Map<String, String> map11 = new HashMap<String, String>();
			map11.put("from", "record");
			map11.put("Column1", "userid");
			map11.put("Column2", user1.getId());
			int totalPage = impl.SelCountWhere(user1.getId());

			if (totalPage % 8 == 0) {

				totalPage = totalPage / 8;
			} else {
				totalPage = (totalPage / 8) + 1;
				System.out.println(totalPage + "------总共有多少页------");
			}
			request.setAttribute("totalPage", totalPage);
			return "individual";
		} else {
			return "enter";
		}
	}

	// 关键字更多
	@RequestMapping("more")
	public String more(HttpServletRequest request) {

		User user1 = (User) request.getSession().getAttribute("user");
		if (user1 != null) {
			Record record = new Record();
			record.setUserid(user1.getId());
			record.setKeyword(request.getParameter("keyword"));
			List<Record> records = impl.selectRecorMore(record);
			request.setAttribute("records", records);
			request.setAttribute("u1", user1);

			// 分页
			Map<String, String> map11 = new HashMap<String, String>();
			map11.put("from", "record");
			map11.put("Column1", "userid");
			map11.put("Column2", user1.getId());
			int totalPage = impl.SelCountMore(record);

			if (totalPage % 8 == 0) {

				totalPage = totalPage / 8;
			} else {
				totalPage = (totalPage / 8) + 1;
				System.out.println(totalPage + "------总共有多少页------");
			}
			request.setAttribute("totalPage", totalPage);
			return "more";
		} else {
			return "enter";
		}
	}

	// 个人查询记录，每条记录详情
	@RequestMapping("record")
	public String remeberRecord(HttpServletRequest request) {
		String port = request.getParameter("port");
		String num = request.getParameter("num");
		Map<String, String> map11 = new HashMap<String, String>();
		if (port.equals("0")) {
			map11.put("from", "breakonespromise");
			map11.put("Column1", "a1");
			map11.put("Column2", num);
			List<Map<String, Object>> list = impl.SelAll(map11);
			System.out.println("记录：" + list.size());
			request.setAttribute("list", list);
		}

		return "p_re_detail";
	}

	// 失信人和详细信息
	@RequestMapping("personDetail")
	public String perdetail(HttpServletRequest request) {

		String a1 = request.getParameter("a1");
		breakonespromise br = impl.sel_a1(a1);

		request.setAttribute("br", br);
		String keyword = (String) request.getSession().getAttribute("keyword");
		System.out.println("关键字：" + keyword);
		// -----查询记录
		User user = (User) request.getSession().getAttribute("user");
		// 如果list1不为null保存查询记录
		if (user != null) {
			Record record = new Record();
			record.setKeyword(keyword);
			record.setType(user.getUsertype());
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(format.format(date));
			record.setTime(format.format(date));
			record.setRank("0");
			record.setPort("0");
			record.setUserid(user.getId());
			record.setNum(a1);

			// 保存记录/如果存在则更新否则保存
			Record record2 = impl.se_CountRecord(record);
			if (record2 == null) {
				impl.insertRecord(record);
			} else {
				record.setId(record2.getId());
				impl.updateDate_Record(record);
			}

		}

		return "p_detail";
	}

	// 失信人和被执行人信息查询
	int par = 0;

	public List<breakonespromise> SearchCourt(String username, int pageIndex) {
		breakonespromise br = new breakonespromise();
		br.setName(username);
		List<breakonespromise> list = impl.sel_br(br);

		int count = list.size();
		System.out.println("总条数：" + count + ":" + username);
		// 如果本地数据库无该数据矫勇第三方接口并将返回数据保存至数据库

		try {

			if (count == 0) {
				Map<String, Object> map1 = new LinkedHashMap<String, Object>();
				map1.put("Court", "Court");
				map1.put("SearchCourt", "SearchCourt");
				map1.put("key", key);
				// 公司KeyNo
				map1.put("searchKey", username);
				map1.put("pageIndex", String.valueOf(pageIndex));
				String result = ConnectUtil.main(map1);
				Map<String, Object> maps = JSONUtil.selectMap("Result", result);
				// 如果第三方接口返回的数据不为空 ，则取出数据set至实体类并保存到数据库
				if (maps != null) {
					Map<String, String> map11 = new HashMap<String, String>();
					map11.put("from", "breakonespromise");
					map11.put("Column1", "Id");

					int size = Integer.parseInt(maps.get("size").toString());
					System.out.println("size---" + size + size);
					if (size != 0) {
						System.out.println("返回的数据列表为---" + size);
						for (int i = 0; i < size; i++) {
							System.out.println("Items" + i + "_Id_a---"
									+ maps.get("Items" + i + "_Id_a"));
							System.out.println("Items" + i + "_Id_b---"
									+ maps.get("Items" + i + "_Id_b"));
							if (maps.get("Items" + i + "_Id_a") != null) {
								breakonespromise breakonespromise = new breakonespromise();
								breakonespromise.setId(maps.get(
										"Items" + i + "_Id_a").toString());
								breakonespromise
										.setSourceid(maps.get(
												"Items" + i + "_Sourceid_a")
												.toString());
								breakonespromise
										.setUniqueno(maps.get(
												"Items" + i + "_Uniqueno_a")
												.toString());
								breakonespromise.setName(maps.get(
										"Items" + i + "_Name_a").toString());
								breakonespromise
										.setLiandate(maps.get(
												"Items" + i + "_Liandate_a")
												.toString());
								breakonespromise.setAnno(maps.get(
										"Items" + i + "_Anno_a").toString());
								breakonespromise.setOrgno(maps.get(
										"Items" + i + "_Orgno_a").toString());
								breakonespromise.setOwnername(maps.get(
										"Items" + i + "_Ownername_a")
										.toString());
								breakonespromise.setExecutegov(maps.get(
										"Items" + i + "_Executegov_a")
										.toString());
								breakonespromise
										.setProvince(maps.get(
												"Items" + i + "_Province_a")
												.toString());
								breakonespromise.setExecuteunite(maps.get(
										"Items" + i + "_Executeunite_a")
										.toString());
								breakonespromise.setYiwu(maps.get(
										"Items" + i + "_Yiwu_a").toString());
								breakonespromise.setExecutestatus(maps.get(
										"Items" + i + "_Executestatus_a")
										.toString());
								breakonespromise.setActionremark(maps.get(
										"Items" + i + "_Actionremark_a")
										.toString());
								breakonespromise.setPublicdate(maps.get(
										"Items" + i + "_Publicdate_a")
										.toString());
								breakonespromise.setFollows(maps.get(
										"Items" + i + "_Follows_a").toString());
								breakonespromise.setAge(maps.get(
										"Items" + i + "_Age_a").toString());
								breakonespromise.setSexy(maps.get(
										"Items" + i + "_Sexy_a").toString());
								breakonespromise.setCreatedate(maps.get(
										"Items" + i + "_Createdate_a")
										.toString());
								breakonespromise.setUpdatedate(maps.get(
										"Items" + i + "_Updatedate_a")
										.toString());
								breakonespromise.setExecuteno(maps.get(
										"Items" + i + "_Executeno_a")
										.toString());
								breakonespromise.setPerformedpart(maps.get(
										"Items" + i + "_Performedpart_a")
										.toString());
								breakonespromise.setUnperformpart(maps.get(
										"Items" + i + "_Unperformpart_a")
										.toString());
								breakonespromise
										.setIsperson(maps.get(
												"Items" + i + "_Isperson_a")
												.toString());
								breakonespromise.setCate("失信人");

								// 已Id为标识，如果本地数据库存在该条数据则不保存，反之
								String Id = maps.get("Items" + i + "_Id_a")
										.toString();
								map11.put("Column2", Id);
								int count1 = impl.SelCount(map11);
								if (count1 == 0) {
									impl.insertBreakonespromise(breakonespromise);

								} else {
									impl.updateBreakonespromisess(breakonespromise);
								}

							}

							// 已Id为标识，如果本地数据库存在该条数据则不保存，反之
							if (maps.get("Items" + i + "_Id_b") != null) {
								breakonespromise breakonespromise = new breakonespromise();
								breakonespromise.setId(maps.get(
										"Items" + i + "_Id_b").toString());
								breakonespromise
										.setSourceid(maps.get(
												"Items" + i + "_Sourceid_b")
												.toString());
								breakonespromise.setName(maps.get(
										"Items" + i + "_Name_b").toString());
								breakonespromise
										.setLiandate(maps.get(
												"Items" + i + "_Liandate_b")
												.toString());
								breakonespromise.setAnno(maps.get(
										"Items" + i + "_Anno_b").toString());
								breakonespromise.setFollows(maps.get(
										"Items" + i + "_Follows_b").toString());
								breakonespromise.setExecutegov(maps.get(
										"Items" + i + "_ExecuteGov_b")
										.toString());
								breakonespromise.setBiaodi(maps.get(
										"Items" + i + "_Biaodi_b").toString());
								breakonespromise.setStatus(maps.get(
										"Items" + i + "_Status_b").toString());
								breakonespromise.setOrgno(maps.get(
										"Items" + i + "_PartyCardNum_b")
										.toString());
								breakonespromise.setCreatedate(maps.get(
										"Items" + i + "_Createdate_b")
										.toString());
								breakonespromise.setUpdatedate(maps.get(
										"Items" + i + "_Updatedate_b")
										.toString());
								breakonespromise.setCate("被执行人");

								String Id1 = maps.get("Items" + i + "_Id_b")
										.toString();
								map11.put("Column2", Id1);
								int count11 = impl.SelCount(map11);
								if (count11 == 0) {

									impl.insertBreakonespromise(breakonespromise);
								} else {
									impl.updateBreakonespromisess(breakonespromise);
								}

							}

						}

						if (size == 10) {
							pageIndex++;
							SearchCourt(username, pageIndex);
						}
					}

				}
				par = 1;
			}

			list = impl.sel_br(br);

		} catch (Exception e) {
			// TODO: handle exception
			list = null;
		}

		return list;

	}





	/**
	 * 企业关键字多维度查询
	 * 
	 * @return
	 */
	int is = 0;

	public List<Enterprisebusinessdata> SearchWide(String keyword, int pageIndex) {

		// String keyword="雷军";

		List<Enterprisebusinessdata> list = impl_enterprise
				.sel_keyword(keyword);

		int count = list.size();
		// int count = 0;
		System.out.println(count + "------------------企业");
		// 如果本地数据库无该数据矫勇第三方接口并将返回数据保存至数据库
		if (is == 0) {
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("ECI", "ECI");
			map1.put("SearchWide", "SearchWide");
			map1.put("key", key);
			map1.put("keyWord", keyword);
			map1.put("type", "opername");
			map1.put("pageIndex", String.valueOf(pageIndex));
			String result = ConnectUtil.main(map1);

			Map<String, Object> maps = JSONUtil.getListMap("Result", result);

			System.out.println("maps:" + maps);
			// 如果第三方接口返回的数据不为空 ，则取出数据set至实体类并保存到数据库
			if (maps != null) {
				Enterprisebusinessdata enterprisebusinessdata = new Enterprisebusinessdata();
				int size = Integer.parseInt(maps.get("size").toString());
				if (size != 0) {
					Map<String, String> map11 = new HashMap<String, String>();
					map11.put("from", "enterprisebusinessdata");
					map11.put("Column1", "KeyNo");
					System.out.println("返回的数据列表为---" + size);
					for (int i = 0; i < size; i++) {
						System.out.println("Result" + i + "_KeyNo---"
								+ maps.get("Result" + i + "_KeyNo"));
						System.out.println("Result" + i + "_Name---"
								+ maps.get("Result" + i + "_Name"));

						enterprisebusinessdata.setDimension(maps.get(
								"Result" + i + "_Dimension").toString());
						enterprisebusinessdata.setKeyNo(maps.get(
								"Result" + i + "_KeyNo").toString());
						enterprisebusinessdata.setName(maps.get(
								"Result" + i + "_Name").toString());
						enterprisebusinessdata.setOperName(maps.get(
								"Result" + i + "_OperName").toString());
						enterprisebusinessdata.setStartDate(maps.get(
								"Result" + i + "_StartDate").toString());
						enterprisebusinessdata.setStatus(maps.get(
								"Result" + i + "_Status").toString());
						enterprisebusinessdata.setNo(maps.get(
								"Result" + i + "_No").toString());

						map11.put("Column2", maps.get("Result" + i + "_KeyNo")
								.toString());
						int count1 = impl.SelCount(map11);
						if (count1 == 0) {
							impl_enterprise
									.insertEnterprisebusinessdata(enterprisebusinessdata);

						}

					}

					if (size == 10) {
						pageIndex++;
						SearchWide(keyword, pageIndex);
					}

				}

			}
			is = 1;
		}

		List<Enterprisebusinessdata> list1 = impl_enterprise
				.sel_keyword(keyword);
		return list1;
	}

	@RequestMapping("exitUser")
	public String exitUser(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		Map<String, String> map11 = new HashMap<String, String>();
		map11.put("from", "hotheadlines");
		List<Map<String, Object>> list = impl.SelAlls(map11);
		if (list != null && list.size() > 7) {
			list = list.subList(0, 7);
		}

		request.setAttribute("list", list);
		return "home1";
	}

}
