package com.hoomsun.Controller.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoomsun.Service.FirstService;
import com.hoomsun.Service.creditImpl.BreakonespromiseServiceImpl;
import com.hoomsun.entity.First;
import com.hoomsun.entity.Record;
import com.hoomsun.entity.User;
import com.hoomsun.entity.analysis_of_home_ownership;
import com.hoomsun.entity.associated_information;
import com.hoomsun.entity.check_item_details;
import com.hoomsun.entity.court_information_field_table;
import com.hoomsun.entity.frequency_details;
import com.hoomsun.entity.overdue_details;
import com.hoomsun.entity.plat;
import com.hoomsun.entity.risk_check_item_list;
import com.hoomsun.util.ConnectUtil;

@Controller
@RequestMapping("first")
public class FirstController {

	@Autowired
	private FirstService ffss;
	@Autowired
	private BreakonespromiseServiceImpl impl;
	
	// 中级查询
		@RequestMapping("moreSearch")
		public String moreSearch(HttpServletRequest request) {
			String name = request.getParameter("name");
			String iden = request.getParameter("iden");
			String phonenum = request.getParameter("phonenum");
			User user = (User) request.getSession().getAttribute("user");

			Record record = new Record();
			record.setKeyword(name);
			record.setType(user.getUsertype());
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(format.format(date));
			record.setTime(format.format(date));
			record.setRank("1");
			record.setPort("0");
			record.setUserid(user.getId());
			record.setNum(iden);

			// 保存记录/如果存在则更新否则保存
			Record record2 = impl.se_CountRecord(record);
			if (record2 == null) {
				impl.insertRecord(record);
			} else {
				record.setId(record2.getId());
				impl.updateDate_Record(record);
			}
			
			First first = new First();
			first.setName(name);
			first.setId_number(iden);
			first.setPhone_number(phonenum);
			middleSearch(first);

			return "ok";
		}
 
		
	public void middleSearch(First first){
		Map<String, Object> map1 = new LinkedHashMap<String, Object>();
		
		map1.put("keyword",first.getName());
		map1.put("code", first.getId_number());
		map1.put("phone", first.getPhone_number());

		
		String result = ConnectUtil.main2(map1);
		System.out.println("result:" + result);

		// 保存
		First first2 = ffss.se_fi(first);
		// 如果存在则删除否则保存数据
		if (first2 == null) {
			getListMap3(result, first);
		} else {

			ffss.de_fi(first2);// 删除fist
			analysis_of_home_ownership analysis_of_home_ownership = new analysis_of_home_ownership();
			analysis_of_home_ownership.setF_address_detect_id(first2.getId());
			ffss.de_address(analysis_of_home_ownership);// 删除analysis_of_home_ownership
			risk_check_item_list risk_check_item_list = new risk_check_item_list();
			risk_check_item_list.setF_risk_items_id(first2.getId());
			List<risk_check_item_list> risk_check_item_lists = ffss
					.se_risk(risk_check_item_list);
			ffss.de_risk(risk_check_item_list);// 删除risk_check_item_list
			if (risk_check_item_lists != null) {
				for (risk_check_item_list risk_check_item_list2 : risk_check_item_lists) {
					check_item_details check_item_details = new check_item_details();
					check_item_details.setRisk_item_id(risk_check_item_list2
							.getId());
					List<check_item_details> check_item_details2 = ffss
							.se_ch(check_item_details);
					ffss.de_ch(check_item_details);// 删除check_item_details

					if (check_item_details2 != null) {
						for (check_item_details check_item_details3 : check_item_details2) {
							overdue_details overdue_details = new overdue_details();
							overdue_details
									.setCheck_item_id(check_item_details3
											.getId());
							ffss.de_overdue(overdue_details);// 删除overdue_details
							plat plat = new plat();
							plat.setCheck_item_id(check_item_details3.getId());
							ffss.de_plat(plat);// 删除plat
							court_information_field_table court_information_field_table = new court_information_field_table();
							court_information_field_table
									.setCheck_item_id(check_item_details3
											.getId());
							ffss.de_court(court_information_field_table);// 删除court_information_field_table

							frequency_details frequency_details = new frequency_details();
							frequency_details
									.setCheck_item_id(check_item_details3
											.getId());
							List<frequency_details> frequency_details2 = ffss
									.se_fre(frequency_details);
							ffss.de_fre(frequency_details);// 删除frequency_details
							if (frequency_details2 != null) {
								for (frequency_details frequency_details3 : frequency_details2) {
									associated_information associated_information = new associated_information();
									associated_information
											.setFrequency_details_id(frequency_details3
													.getId());
									ffss.de_ass(associated_information);// 删除associated_information
								}
							}

						}
					}
				}
			}

			// 保存
			getListMap3(result, first);

		}
		
	}


	@RequestMapping("middleshow")
	public String middleshow(HttpServletRequest request,
			HttpServletResponse response) {
	
		String num = request.getParameter("num");
		// 本地查询
		First f1 = ffss.sel_first(num);
		if (f1 != null) {
			List<analysis_of_home_ownership> an = ffss.sel_address(f1.getId());
			System.out.println("size:" + an.size());
			analysis_of_home_ownership an1 = an.get(0);
			List<risk_check_item_list> re = ffss.sel_risk(f1.getId());
			List<Map<String, Object>> li = ffss.sel_risk_count(f1.getId());
			List<check_item_details> chs = new ArrayList<check_item_details>();
			List<plat> plss = new ArrayList<plat>();
			for (risk_check_item_list rr : re) {
				check_item_details ch = ffss.sel_ch(rr.getId());
				if (ch != null) {
					chs.add(ch);

					List<plat> pls = ffss.sel_pl(ch.getId());

					if (pls.size() != 0) {
						for (plat p : pls) {
							if (p != null) {
								plss.add(p);
							}
						}
					}

				}

			}
			// frequency
			List<frequency_details> frss = new ArrayList<frequency_details>();
			// court
			List<court_information_field_table> courtss = new ArrayList<court_information_field_table>();
			for (check_item_details c1 : chs) {
				System.out.println("c1_id:" + c1.getId());
				// 频度规则详情
				List<frequency_details> frs = ffss.sel_fre(c1.getId());
				if (frs != null) {
					frss.addAll(frs);
				}
				// 失信人与被执行人
				List<court_information_field_table> courts = ffss.courts(c1
						.getId());
				if (courts != null) {
					courtss.addAll(courts);
				}

			}
			// associate
			List<associated_information> ass = new ArrayList<associated_information>();
			for (frequency_details fre1 : frss) {
				List<associated_information> as = ffss.sel_ass(fre1.getId());
				if (as != null) {
					ass.addAll(as);
				}
			}
			System.out.println("court:" + courtss.size());
			request.setAttribute("total", re.size());
			request.setAttribute("first", f1);
			request.setAttribute("adds", an1);
			request.setAttribute("counts", li);
			request.setAttribute("chs", chs);
			request.setAttribute("risks", re);
			request.setAttribute("plss", plss);
			request.setAttribute("frss", frss);
			request.setAttribute("ass", ass);
			request.setAttribute("courtss", courtss);
			request.setAttribute("num", num);
		}

		return "middle";
	}
	
	
	

	@RequestMapping("test")
	public String test() {
		List<frequency_details> frs = ffss.sel_fre("103");
		for (frequency_details f : frs) {
			System.out.println(f.getDetail());
		}
		return "home1";
	}

	public void getListMap3(String jsonString, First first) {

		// 遍历Result下的一级参数

		JSONObject jsonObject2 = JSONObject.fromObject(jsonString);
		// fist.class
		First fi = new First();
		System.out.println("----------****************1-------------");
		if (jsonObject2.get("report_id") != null) {
			fi.setReport_id(jsonObject2.get("report_id").toString());
		}
		if (jsonObject2.get("final_score") != null) {
			fi.setFinal_score(jsonObject2.get("final_score").toString());
		}
		if (jsonObject2.get("final_decision") != null) {
			fi.setFinal_decision(jsonObject2.get("final_decision").toString());
		}
		if (jsonObject2.get("report_time") != null) {
			fi.setReport_time(jsonObject2.get("report_time").toString());
		}
		if (jsonObject2.get("final_score") != null) {
			fi.setSuccess(jsonObject2.get("success").toString());
		}
		if (jsonObject2.get("apply_time") != null) {
			fi.setApply_time(jsonObject2.get("apply_time").toString());
		}
		if (jsonObject2.get("reason_code") != null) {
			fi.setReason_code(jsonObject2.get("reason_code").toString());
		}
		if (jsonObject2.get("reason_desc") != null) {
			fi.setReason_desc(jsonObject2.get("reason_desc").toString());
		}

		fi.setName(first.getName());
		fi.setId_number(first.getId_number());
		fi.setPhone_number(first.getPhone_number());

		ffss.in_fi(fi);
		String idf = fi.getId();
		System.out.println("----------------id:" + idf);
		Iterator<String> iterator = jsonObject2.keys();

		while (iterator.hasNext()) {

			String json_key = iterator.next();
			Object json_value = jsonObject2.get(json_key);
			if (json_key.equals("address_detect")) {
				System.out.println("-------------------归属地解析-----------------");
				// f3(json_value.toString());
				JSONObject jsonObject3 = JSONObject.fromObject(json_value
						.toString());

				analysis_of_home_ownership ad = new analysis_of_home_ownership();
				if (jsonObject3.get("id_card_address") != null) {
					ad.setId_card_address(jsonObject3.get("id_card_address")
							.toString());
				}
				if (jsonObject3.get("mobile_address") != null) {
					ad.setMobile_address(jsonObject3.get("mobile_address")
							.toString());
				}
				if (jsonObject3.get("true_ip_address") != null) {
					ad.setTrue_ip_address(jsonObject3.get("true_ip_address")
							.toString());
				}
				if (jsonObject3.get("wifi_address") != null) {
					ad.setWifi_address(jsonObject3.get("wifi_address")
							.toString());
				}
				if (jsonObject3.get("cell_address") != null) {
					ad.setCell_address(jsonObject3.get("cell_address")
							.toString());
				}
				ad.setF_address_detect_id(idf);
				ffss.in_address(ad);

			} else if (json_key.equals("risk_items")) {
				System.out.println("------------------扫描出来的风险项-------------");

				JSONArray jsonArray = JSONArray.fromObject(json_value
						.toString());
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject jsonObject4 = jsonArray.getJSONObject(i);
					risk_check_item_list ri = new risk_check_item_list();
					if (jsonObject4.get("item_id") != null) {
						ri.setItem_id(jsonObject4.get("item_id").toString());
					}
					if (jsonObject4.get("item_name") != null) {
						ri.setItem_name(jsonObject4.get("item_name").toString());
					}
					if (jsonObject4.get("risk_level") != null) {
						String level=jsonObject4.get("risk_level").toString();
						String le="高";
						if(level.equals("low")){
							 le="低";
						}else if(level.equals("medium")){
							 le="中";
						}
						ri.setRisk_level(le);
					}
					if (jsonObject4.get("group") != null) {
						ri.setGroups(jsonObject4.get("group").toString());
					}

					ri.setF_risk_items_id(idf);
					ffss.in_risk(ri);
					String idr = ri.getId();
					System.out.println("------idr:" + idr);

					if (jsonObject4.get("item_detail") != null) {
						System.out.println("item_detail_:"
								+ jsonObject4.get("item_detail").toString());
						JSONObject jsonObject5 = JSONObject
								.fromObject(jsonObject4.get("item_detail")
										.toString());
						check_item_details ch = new check_item_details();
						if (jsonObject5.get("discredit_times") != null) {
							ch.setDiscredit_times(jsonObject5.get(
									"discredit_times").toString());
						}
						if (jsonObject5.get("platform_count") != null) {
							ch.setPlatform_count(jsonObject5.get(
									"platform_count").toString());
						}
						if (jsonObject5.get("fraud_type") != null) {
							ch.setFraud_type(jsonObject5.get("fraud_type")
									.toString());
						}
						if (jsonObject5.get("frequency_detail_list") != null) {
							ch.setFrequency_detail_list("have");
						}

						ch.setRisk_item_id(idr);
						ffss.in_ch(ch);
						String idc = ch.getId();
						System.out.println("------idc:" + idc);
						if (jsonObject5.get("platform_detail") != null) {
							plat pl = new plat();
							String kk = jsonObject5.get("platform_detail")
									.toString();
							String gg = kk.substring(1, kk.length() - 1);
							String nn[] = gg.split(",");
							for (int s = 0; s < nn.length; s++) {
								String aa = nn[s];
								String bb = aa.substring(1, aa.length() - 1);
								pl.setPlat_type(bb);
								pl.setCheck_item_id(idc);
								ffss.in_plat(pl);

							}
						}
						if (jsonObject5.get("overdue_details") != null) {
							JSONObject jsonObject6 = JSONObject
									.fromObject(jsonObject5.get(
											"overdue_details").toString());
							overdue_details du = new overdue_details();
							if (jsonObject6.get("overdue_amount") != null) {
								du.setOverdue_amount(jsonObject6.get(
										"overdue_amount").toString());
							}
							if (jsonObject6.get("overdue_count") != null) {
								du.setOverdue_count(jsonObject6.get(
										"overdue_count").toString());
							}
							if (jsonObject6.get("overdue_day") != null) {
								du.setOverdue_day(jsonObject6
										.get("overdue_day").toString());
							}
							du.setCheck_item_id(idc);
							ffss.in_overdue(du);

						}

						if (jsonObject5.get("high_risk_areas") != null) {

						}
						if (jsonObject5.get("hit_list_datas") != null) {

						}
						if (jsonObject5.get("court_details") != null) {
							String court = jsonObject5.get("court_details")
									.toString();
							String aa = court.substring(0, 1);
							if (aa.equals("[")) {
								JSONArray jArray8 = JSONArray.fromObject(court);
								for (int m = 0; m < jArray8.size(); m++) {
									JSONObject jsonObject8 = jArray8
											.getJSONObject(m);
									a8(jsonObject8, idc);

								}

							} else {
								JSONObject jsonObject8 = JSONObject
										.fromObject(court);
								a8(jsonObject8, idc);

							}

						}
						if (jsonObject5.get("frequency_detail_list") != null) {
							String frequency = jsonObject5.get(
									"frequency_detail_list").toString();
							String aa = frequency.substring(0, 1);
							if (aa.equals("[")) {
								JSONArray jArray9 = JSONArray
										.fromObject(frequency);
								for (int m = 0; m < jArray9.size(); m++) {
									JSONObject jsonObject9 = jArray9
											.getJSONObject(m);
									a9(jsonObject9, idc);

								}

							} else {
								JSONObject jsonObject9 = JSONObject
										.fromObject(frequency);
								a9(jsonObject9, idc);
							}

						}

					}

				}

			}

		}

	}

	// obj---6
	// obj---7

	// obj----8
	public void a8(JSONObject jsonObject8, String idc) {
		court_information_field_table co = new court_information_field_table();
		if (jsonObject8.get("fraud_type") != null) {
			co.setFraud_type(jsonObject8.get("fraud_type").toString());
		}
		if (jsonObject8.get("name") != null) {
			co.setName(jsonObject8.get("name").toString());
		}
		if (jsonObject8.get("age") != null) {
			co.setAge(jsonObject8.get("age").toString());
		}
		if (jsonObject8.get("gender") != null) {
			co.setGender(jsonObject8.get("gender").toString());
		}
		if (jsonObject8.get("province") != null) {
			co.setProvince(jsonObject8.get("province").toString());
		}
		if (jsonObject8.get("filing_time") != null) {
			co.setFiling_time(jsonObject8.get("filing_time").toString());
		}
		if (jsonObject8.get("court_name") != null) {
			co.setCourt_name(jsonObject8.get("court_name").toString());
		}
		if (jsonObject8.get("execution_department") != null) {
			co.setExecution_department(jsonObject8.get("execution_department")
					.toString());
		}
		if (jsonObject8.get("duty") != null) {
			co.setDuty(jsonObject8.get("duty").toString());
		}
		if (jsonObject8.get("situation") != null) {
			co.setSituation(jsonObject8.get("situation").toString());
		}
		if (jsonObject8.get("discredit_detail") != null) {
			co.setDiscredit_detail(jsonObject8.get("discredit_detail")
					.toString());
		}
		if (jsonObject8.get("execution_base") != null) {
			co.setExecution_base(jsonObject8.get("execution_base").toString());
		}
		if (jsonObject8.get("case_number") != null) {
			co.setCase_number(jsonObject8.get("case_number").toString());
		}
		if (jsonObject8.get("execution_number") != null) {
			co.setExecution_number(jsonObject8.get("execution_number")
					.toString());
		}
		if (jsonObject8.get("execution_status") != null) {
			co.setExecution_status(jsonObject8.get("execution_status")
					.toString());
		}
		co.setCheck_item_id(idc);
		ffss.in_court(co);

	}

	// obj----9
	public void a9(JSONObject jsonObject9, String idc) {
		frequency_details fr = new frequency_details();
		if (jsonObject9.get("detail") != null) {
			fr.setDetail(jsonObject9.get("detail").toString());
		}

		fr.setCheck_item_id(idc);
		ffss.in_fre(fr);
		String idfre = fr.getId();
		if (jsonObject9.get("data") != null) {
			associated_information ass = new associated_information();
			String kk = jsonObject9.get("data").toString();
			String gg = kk.substring(1, kk.length() - 1);
			String nn[] = gg.split(",");
			for (int i = 0; i < nn.length; i++) {
				String aa = nn[i];
				String bb = aa.substring(1, aa.length() - 1);
				ass.setData(bb);
				ass.setFrequency_details_id(idfre);
				ffss.in_ass(ass);

			}
		}
	}

	// 方法1
	public static void f3(String s) {
		JSONObject jsonObject3 = JSONObject.fromObject(s);
		Iterator<String> iterator3 = jsonObject3.keys();
		while (iterator3.hasNext()) {
			String k3 = iterator3.next();
			String v3 = jsonObject3.getString(k3);
			if (k3.equals("platform_detail")) {
				System.out.println("-----------借贷详情-----------");
				v3 = v3.substring(1, v3.length() - 1);
				String[] arr = v3.split(",");
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}

			} else if (k3.equals("frequency_detail_list")) {
				System.out.println("----------频度详情---------");
				JSONArray jsonArray = JSONArray.fromObject(v3);
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject jsonObject4 = jsonArray.getJSONObject(i);

					Iterator<String> iterator4 = jsonObject4.keys();
					while (iterator4.hasNext()) {
						String k4 = iterator4.next();
						Object v4 = jsonObject4.get(k4);
						if (k4.equals("data")) {
							System.out
									.println("----------频度规则列表详情------------");
							String v5 = v4.toString();
							v5 = v5.substring(1, v5.length() - 1);
							String[] arr2 = v5.split(",");
							for (int j = 0; i < arr2.length; j++) {
								System.out.println(arr2[j]);
							}

						} else {
							System.out.println(k4 + ":" + v4);
						}

					}

				}

			} else {
				System.out.println(k3 + ":" + v3);
			}

		}

	}

	// 方法2
	public static void f4(String s) {

	}
	// 方法3

}
