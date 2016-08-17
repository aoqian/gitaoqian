package com.hoomsun.Controller.Login;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoomsun.Service.creditImpl.BreakonespromiseServiceImpl;

import com.hoomsun.entity.breakonespromise;
import com.hoomsun.util.ConnectUtil;
import com.hoomsun.util.JSONUtil;

/**
 * 
 * 失信被执行人查询
 * 
 * 
 * @author aoqian
 * 
 * @time 2016-7-13 上午9:56:37
 */
@Controller
@RequestMapping(value = "Court")
public class BreakonespromiseController {

	private static final String key = "7cb5bfdca57f4f268fde5d311b181ba2";// 接口ApiKey编号唯一

	@Autowired
	private BreakonespromiseServiceImpl impl;



	/**
	 * 失信人信息查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "SearchShiXin")
	public String SearchShiXin() {
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
			map1.put("Court", "Court");
			map1.put("SearchShiXin", "SearchShiXin");
			map1.put("key", key);
			// 公司KeyNo
			map1.put("searchKey", "张三");
			String result = ConnectUtil.main(map1);
			Map<String, Object> maps = JSONUtil.getListMap("Result", result);
			// 如果第三方接口返回的数据不为空 ，则取出数据set至实体类并保存到数据库
		   System.out.println("maps:"+maps);
			if (!maps.equals("{}")) {
				Map<String, String> map11 = new HashMap<String, String>();
				map11.put("from", "breakonespromise");
				map11.put("Column1", "Id");
				breakonespromise breakonespromise = new breakonespromise();
				int size = Integer.parseInt(maps.get("size").toString());
				if (size != 0 || size != 1) {
					System.out.println("返回的数据列表为---" + size);
					for (int i = 0; i < size; i++) {

						System.out.println("Result" + i + "_Id---"
								+ maps.get("Result" + i + "_Id"));
						System.out.println("Result" + i + "_ExecuteGov---"
								+ maps.get("Result" + i + "_ExecuteGov"));
						breakonespromise.setId(maps.get("Result" + i + "_Id")
								.toString());
						breakonespromise.setSourceid(maps.get(
								"Result" + i + "_Sourceid").toString());
						breakonespromise.setUniqueno(maps.get(
								"Result" + i + "_Uniqueno").toString());
						breakonespromise.setName(maps.get(
								"Result" + i + "_Name").toString());
						breakonespromise.setLiandate(maps.get(
								"Result" + i + "_Liandate").toString());
						breakonespromise.setAnno(maps.get(
								"Result" + i + "_Anno").toString());
						breakonespromise.setOrgno(maps.get(
								"Result" + i + "_Orgno").toString());
						breakonespromise.setOwnername(maps.get(
								"Result" + i + "_Ownername").toString());
						breakonespromise.setExecutegov(maps.get(
								"Result" + i + "_Executegov").toString());
						breakonespromise.setProvince(maps.get(
								"Result" + i + "_Province").toString());
						breakonespromise.setExecuteunite(maps.get(
								"Result" + i + "_Executeunite").toString());
						breakonespromise.setYiwu(maps.get(
								"Result" + i + "_Yiwu").toString());
						breakonespromise.setExecutestatus(maps.get(
								"Result" + i + "_Executestatus").toString());
						breakonespromise.setActionremark(maps.get(
								"Result" + i + "_Actionremark").toString());
						breakonespromise.setPublicdate(maps.get(
								"Result" + i + "_Publicdate").toString());
						breakonespromise.setFollows(maps.get(
								"Result" + i + "_Follows").toString());
						breakonespromise.setAge(maps.get("Result" + i + "_Age")
								.toString());
						breakonespromise.setSexy(maps.get(
								"Result" + i + "_Sexy").toString());
						breakonespromise.setCreatedate(maps.get(
								"Result" + i + "_Createdate").toString());
						breakonespromise.setUpdatedate(maps.get(
								"Result" + i + "_Updatedate").toString());
						breakonespromise.setExecuteno(maps.get(
								"Result" + i + "_Executeno").toString());
						breakonespromise.setPerformedpart(maps.get(
								"Result" + i + "_Performedpart").toString());
						breakonespromise.setUnperformpart(maps.get(
								"Result" + i + "_Unperformpart").toString());
						breakonespromise.setIsperson(maps.get(
								"Result" + i + "_Isperson").toString());

						String Id = maps.get("Result" + i + "_Id").toString();
						map11.put("Column2", Id);
						int count1 = impl.SelCount(map11);
						if (count1 == 0) {
							impl.insertBreakonespromise(breakonespromise);
						} else {
							impl.updateBreakonespromises(breakonespromise);
						}
					}
				}

			}

		}
		return "ok";
	}

	/**
	 * 失信人和被执行人信息查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "SearchCourt")
	public String SearchCourt() {
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
			map1.put("Court", "Court");
			map1.put("SearchCourt", "SearchCourt");
			map1.put("key", key);
			// 公司KeyNo
			map1.put("searchKey", "张三");
			String result = ConnectUtil.main(map1);
			Map<String, Object> maps = JSONUtil.selectMap("Result", result);
			// 如果第三方接口返回的数据不为空 ，则取出数据set至实体类并保存到数据库
			if (maps != null) {
				Map<String, String> map11 = new HashMap<String, String>();
				map11.put("from", "breakonespromise");
				map11.put("Column1", "Id");
				breakonespromise breakonespromise = new breakonespromise();
				int size = Integer.parseInt(maps.get("size").toString()) / 2;
				System.out.println("size---" + size + size);
				if (size != 0 || size != 1) {
					System.out.println("返回的数据列表为---" + size);
					for (int i = 0; i < size; i++) {
						System.out.println("Items" + i + "_Id_a---"+ maps.get("Items" + i + "_Id_a"));
						System.out.println("Items" + i + "_Id_b---"+ maps.get("Items" + i + "_Id_b"));
                       if(maps.get("Items" + i + "_Id_a")!=null){
                    	   breakonespromise.setId(maps.get("Items" + i + "_Id_a")
   								.toString());
   						breakonespromise.setSourceid(maps.get(
   								"Items" + i + "_Sourceid_a").toString());
   						breakonespromise.setUniqueno(maps.get(
   								"Items" + i + "_Uniqueno_a").toString());
   						breakonespromise.setName(maps.get(
   								"Items" + i + "_Name_a").toString());
   						breakonespromise.setLiandate(maps.get(
   								"Items" + i + "_Liandate_a").toString());
   						breakonespromise.setAnno(maps.get(
   								"Items" + i + "_Anno_a").toString());
   						breakonespromise.setOrgno(maps.get(
   								"Items" + i + "_Orgno_a").toString());
   						breakonespromise.setOwnername(maps.get(
   								"Items" + i + "_Ownername_a").toString());
   						breakonespromise.setExecutegov(maps.get(
   								"Items" + i + "_Executegov_a").toString());
   						breakonespromise.setProvince(maps.get(
   								"Items" + i + "_Province_a").toString());
   						breakonespromise.setExecuteunite(maps.get(
   								"Items" + i + "_Executeunite_a").toString());
   						breakonespromise.setYiwu(maps.get(
   								"Items" + i + "_Yiwu_a").toString());
   						breakonespromise.setExecutestatus(maps.get(
   								"Items" + i + "_Executestatus_a").toString());
   						breakonespromise.setActionremark(maps.get(
   								"Items" + i + "_Actionremark_a").toString());
   						breakonespromise.setPublicdate(maps.get(
   								"Items" + i + "_Publicdate_a").toString());
   						breakonespromise.setFollows(maps.get(
   								"Items" + i + "_Follows_a").toString());
   						breakonespromise.setAge(maps
   								.get("Items" + i + "_Age_a").toString());
   						breakonespromise.setSexy(maps.get(
   								"Items" + i + "_Sexy_a").toString());
   						breakonespromise.setCreatedate(maps.get(
   								"Items" + i + "_Createdate_a").toString());
   						breakonespromise.setUpdatedate(maps.get(
   								"Items" + i + "_Updatedate_a").toString());
   						breakonespromise.setExecuteno(maps.get(
   								"Items" + i + "_Executeno_a").toString());
   						breakonespromise.setPerformedpart(maps.get(
   								"Items" + i + "_Performedpart_a").toString());
   						breakonespromise.setUnperformpart(maps.get(
   								"Items" + i + "_Unperformpart_a").toString());
   						breakonespromise.setIsperson(maps.get(
   								"Items" + i + "_Isperson_a").toString());

   						// 已Id为标识，如果本地数据库存在该条数据则不保存，反之
   						String Id = maps.get("Items" + i + "_Id_a").toString();
   						map11.put("Column2", Id);
   						int count1 = impl.SelCount(map11);
   						if (count1 == 0) {
   							impl.insertBreakonespromise(breakonespromise);

   						} else {
   							impl.updateBreakonespromisess(breakonespromise);
   						}
                    	   
                       }
						

						// 已Id为标识，如果本地数据库存在该条数据则不保存，反之
                        if(maps.get("Items" + i + "_Id_b")!=null){
                        	breakonespromise.setId(maps.get("Items" + i + "_Id_b")
    								.toString());
    						breakonespromise.setSourceid(maps.get(
    								"Items" + i + "_Sourceid_b").toString());
    						breakonespromise.setName(maps.get(
    								"Items" + i + "_Name_b").toString());
    						breakonespromise.setLiandate(maps.get(
    								"Items" + i + "_Liandate_b").toString());
    						breakonespromise.setAnno(maps.get(
    								"Items" + i + "_Anno_b").toString());
    						breakonespromise.setFollows(maps.get(
    								"Items" + i + "_Follows_b").toString());
    						breakonespromise.setExecutegov(maps.get(
    								"Items" + i + "_ExecuteGov_b").toString());
    						breakonespromise.setBiaodi(maps.get(
    								"Items" + i + "_Biaodi_b").toString());
    						breakonespromise.setStatus(maps.get(
    								"Items" + i + "_Status_b").toString());
    						breakonespromise.setOrgno(maps.get(
    								"Items" + i + "_PartyCardNum_b").toString());
    						breakonespromise.setCreatedate(maps.get(
    								"Items" + i + "_Createdate_b").toString());
    						breakonespromise.setUpdatedate(maps.get(
    								"Items" + i + "_Updatedate_b").toString());

    						String Id1 = maps.get("Items" + i + "_Id_b").toString();
    						map11.put("Column2", Id1);
    						int count11 = impl.SelCount(map11);
    						if (count11 == 0) {

    							impl.insertBreakonespromise(breakonespromise);
    						} else {
    							impl.updateBreakonespromisess(breakonespromise);
    						}
                        	
                        }
						
					}

				}

			}
		}
		return "ok";
	}

}
