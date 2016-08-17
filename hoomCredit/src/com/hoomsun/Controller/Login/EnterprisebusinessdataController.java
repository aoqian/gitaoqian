package com.hoomsun.Controller.Login;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoomsun.Service.creditImpl.EnterprisebusinessdataImpl;
import com.hoomsun.entity.Enterprisebusinessdata;
import com.hoomsun.util.ConnectUtil;
import com.hoomsun.util.JSONUtil;

/**
 * 
 * 企业工商数据查询
 * 
 * @author aoqian
 * 
 * @time 2016-7-12 下午6:49:11
 */

@Controller
@RequestMapping(value = "ECI")
public class EnterprisebusinessdataController {

	private static final String key = "aa88905eb8474f32ac52dadb2e7383e8";// 接口ApiKey编号唯一

	@Autowired
	private EnterprisebusinessdataImpl impl;

	/**
	 * 获取城市列表缩写
	 * 
	 * @return
	 */
	@RequestMapping(value = "Provinces")
	public String Provinces() {

		Map<String, String> map = new HashMap<String, String>();
		map.put("from", "enterprisebusinessdata");
		map.put("Column1", "Status");
		map.put("Column2", "在营（开业）企业");
		// int count = impl.SelCount(map);
		int count = 0;
		System.out.println(count);
		// 如果本地数据库无该数据矫勇第三方接口并将返回数据保存至数据库
		if (count == 0) {
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("ECI", "ECI");
			map1.put("Provinces", "Provinces");
			map1.put("key", key);
			String result = ConnectUtil.main(map1);
			Map<String, Object> maps = JSONUtil.getListMap("Result", result);
			System.out.println("结果："+maps);
			// 如果第三方接口返回的数据不为空 ，则取出数据set至实体类并保存到数据库
			if (maps != null) {
				Enterprisebusinessdata enterprisebusinessdata = new Enterprisebusinessdata();
				int size = Integer.parseInt(maps.get("size").toString());
				if (size != 0 || size != 1) {
					System.out.println("返回的数据列表为---" + size);
					for (int i = 0; i < size; i++) {
						System.out.println("Result" + i + "_ID---"
								+ maps.get("Result" + i + "_ID"));
						System.out.println("Result" + i + "_ProvinceName---"
								+ maps.get("Result" + i + "_ProvinceName"));
						enterprisebusinessdata.setID(maps.get(
								"Result" + i + "_ID").toString());
						enterprisebusinessdata.setCode(maps.get(
								"Result" + i + "_Code").toString());
						enterprisebusinessdata.setProvinceName(maps.get(
								"Result" + i + "_ProvinceName").toString());
						enterprisebusinessdata.setPinYin(maps.get(
								"Result" + i + "_PinYin").toString());
						enterprisebusinessdata.setMinSearchLen(maps.get(
								"Result" + i + "_MinSearchLen").toString());
						enterprisebusinessdata.setStatus(maps.get(
								"Result" + i + "_Status").toString());
						enterprisebusinessdata.setRegionId(maps.get(
								"Result" + i + "_RegionId").toString());
						impl.insertEnterprisebusinessdata(enterprisebusinessdata);
					}

				}

			}
		}
		return "ok";
	}

	/**
	 * 企业关键字模糊查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "Search")
	public String Search() {

		Map<String, String> map = new HashMap<String, String>();
		map.put("from", "enterprisebusinessdata");
		map.put("Column1", "Status");
		map.put("Column2", "在营（开业）企业");
		// int count = impl.SelCount(map);
		int count = 0;
		System.out.println(count);
		// 如果本地数据库无该数据矫勇第三方接口并将返回数据保存至数据库
		if (count == 0) {
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("ECI", "ECI");
			map1.put("Search", "Search");
			map1.put("key", key);
			map1.put("keyword", "小米科技有限责任公司");
			map1.put("province", "BJ");

			String result = ConnectUtil.main(map1);
			Map<String, Object> maps = JSONUtil.getListMap("Result", result);
			// 如果第三方接口返回的数据不为空 ，则取出数据set至实体类并保存到数据库
			if (maps != null) {
				Enterprisebusinessdata enterprisebusinessdata = new Enterprisebusinessdata();
				int size = Integer.parseInt(maps.get("size").toString());
				if (size != 0 || size != 1) {
					System.out.println("返回的数据列表为---" + size);
					for (int i = 0; i < size; i++) {
						System.out.println("Result" + i + "_KeyNo---"
								+ maps.get("Result" + i + "_KeyNo"));
						System.out.println("Result" + i + "_Name---"
								+ maps.get("Result" + i + "_Name"));
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
						impl.insertEnterprisebusinessdata(enterprisebusinessdata);
					}

				}

			}
		}
		return "ok";

	}

	/**
	 * 企业关键字多维度查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "SearchWide")
	public String SearchWide() {

		Map<String, String> map = new HashMap<String, String>();
		map.put("from", "enterprisebusinessdata");
		map.put("Column1", "Status");
		map.put("Column2", "在营（开业）企业");
		// int count = impl.SelCount(map);
		int count = 0;
		System.out.println(count);
		// 如果本地数据库无该数据矫勇第三方接口并将返回数据保存至数据库
		if (count == 0) {
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("ECI", "ECI");
			map1.put("SearchWide", "SearchWide");
			map1.put("key", key);
			map1.put("keyWord", "雷军");
			map1.put("type", "opername");
			
			String result = ConnectUtil.main(map1);
			Map<String, Object> maps = JSONUtil.getListMap("Result", result);
			// 如果第三方接口返回的数据不为空 ，则取出数据set至实体类并保存到数据库
			if (maps != null) {
				Enterprisebusinessdata enterprisebusinessdata = new Enterprisebusinessdata();
				int size = Integer.parseInt(maps.get("size").toString());
				if (size != 0 || size != 1) {
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
						impl.insertEnterprisebusinessdata(enterprisebusinessdata);
					}

				}

			}
		}
		return "ok";
	}

}
