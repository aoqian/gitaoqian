package com.hoomsun.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.annotations.Until;
import com.hoomsun.entity.First;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author aoqian
 * 
 * @time 2016-7-8 下午2:30:11
 */

public class JSONUtil {
	/**
	 * 
	 * @param result
	 *            JSON字符串
	 * @param name
	 *            JSON数组名称
	 * @param fields
	 *            JSON字符串所包含的字段
	 * @return 返回List<Map<String,Object>>类型的列表，Map<String,Object>对应于 "id":"1"的结构
	 */
	// public static Person getPerson(String key, String jsonString) {
	// Person person = new Person();
	// try {
	// JSONObject jsonObject = new JSONObject(jsonString);
	// JSONObject personObject = jsonObject.getJSONObject("person");
	// person.setId(personObject.getInt("id"));
	// person.setName(personObject.getString("name"));
	// person.setAddress(personObject.getString("address"));
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return person;
	// }

	// public static List<Person> getPersons(String key, String jsonString) {
	// List<Person> list = new ArrayList<Person>();
	// try {
	// JSONObject jsonObject = new JSONObject(jsonString);
	// // 返回json数组
	// JSONArray jsonArray = jsonObject.getJSONArray(key);
	// for (int i = 0; i < jsonArray.length(); i++) {
	// JSONObject jsonObject2 = jsonArray.getJSONObject(i);
	// Person person = new Person();
	// person.setId(jsonObject2.getInt("id"));
	// person.setName(jsonObject2.getString("name"));
	// person.setAddress(jsonObject2.getString("address"));
	// list.add(person);
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return list;
	// }

	// public static List<String> getList(String key, String jsonString) {
	// List<String> list = new ArrayList<String>();
	// try {
	// JSONObject jsonObject = new JSONObject(jsonString);
	// JSONArray jsonArray = jsonObject.getJSONArray(key);
	// for (int i = 0; i < jsonArray.length(); i++) {
	// String msg = jsonArray.getString(i);
	// list.add(msg);
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return list;
	// }

	public static Map<String, Object> getListMap(String key, String jsonString) {

		Map<String, Object> list = new HashMap<String, Object>();
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		try {
			String result = jsonObject.getString(key);
			String sub = result.substring(0, 1);
			System.out.println("-----sub:"+sub);
			System.out.println("------------");
			if (!sub.equals("") && sub.equals("[")) {
				
				
					 JSONArray jsonArray = jsonObject.getJSONArray(key);
						for (int i = 0; i < jsonArray.size(); i++) {
							JSONObject jsonObject2 = jsonArray.getJSONObject(i);
							Map<String, Object> map = new HashMap<String, Object>();
							Iterator<String> iterator = jsonObject2.keys();
							while (iterator.hasNext()) {
								String json_key = iterator.next();
								System.out.println(json_key);
								Object json_value = jsonObject2.get(json_key);
								if (json_value == null) {
									json_value = "";
								}
								map.put(key + i + "_" + json_key, json_value);
							}
							map.put("size", jsonArray.size());
							list.putAll(map);
						}
				
				
			} else if (!sub.equals("") && sub.equals("{")) {

				// 遍历Result下的一级参数
				Map<String, Object> map = new HashMap<String, Object>();
				JSONObject jsonObject2 = jsonObject.getJSONObject(key);
				Iterator<String> iterator = jsonObject2.keys();
				while (iterator.hasNext()) {
					String json_key = iterator.next();
					Object json_value = jsonObject2.get(json_key);
					if (json_value == null) {
						json_value = "";
					}
					map.put(key + "0" + "_" + json_key, json_value);
					}
				map.put("size", 1);
				list.putAll(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
	
	public static Map<String, Object> getListMap2(String jsonString) {

		Map<String, Object> list = new HashMap<String, Object>();
		
		try {
			
		

				// 遍历Result下的一级参数
				Map<String, Object> map = new HashMap<String, Object>();
				JSONObject jsonObject2 = JSONObject.fromObject(jsonString);
				Iterator<String> iterator = jsonObject2.keys();
				while (iterator.hasNext()) {
					String json_key = iterator.next();
					Object json_value = jsonObject2.get(json_key);
					if (json_value == null) {
						json_value = "";
					}
					map.put("_"+json_key, json_value);
					}
				map.put("size", 1);
				list.putAll(map);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
	
	//----------------------------------
	
	
	
	
	//方法1
	public static void f3(String s){
		JSONObject jsonObject3 = JSONObject.fromObject(s);
		Iterator<String> iterator3 = jsonObject3.keys();
		while(iterator3.hasNext()){
			String k3=iterator3.next();
			String v3=jsonObject3.getString(k3);
			if(k3.equals("platform_detail")){
				System.out.println("-----------借贷详情-----------");
				    v3=v3.substring(1, v3.length()-1);
				    String[] arr = v3.split(",");
				    for(int i=0;i<arr.length;i++){
				    	System.out.println(arr[i]);
				    }
				
			}else if(k3.equals("frequency_detail_list")){
				System.out.println("----------频度详情---------");
				JSONArray jsonArray = JSONArray.fromObject(v3);
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject jsonObject4 = jsonArray.getJSONObject(i);
					
					Iterator<String> iterator4 = jsonObject4.keys();
					while (iterator4.hasNext()) {
						String k4 = iterator4.next();
						Object v4 = jsonObject4.get(k4);
					        if(k4.equals("data")){
					        	System.out.println("----------频度规则列表详情------------");
					        	String v5=v4.toString();
					        	v5=v5.substring(1, v5.length()-1);
					        	 String[] arr2 = v5.split(",");
								    for(int j=0;i<arr2.length;j++){
								    	System.out.println(arr2[j]);
								    }
					        	
					        	
					        }else{
					        	System.out.println(k4+":"+v4);
					        	}
							
						
						
						
					}
					
					
				}
				
				
			}
			else{
				System.out.println(k3+":"+v3);
				}
			
			
			
		}
		
		
	}
	//方法2
	public static void f4(String s){
		
	}
	//方法3
	

	static int size = 0;
	static String s = "a";

	public static Map<String, Object> getListSearchCourtMap(String key,
			String jsonString) {

		Map<String, Object> list = new HashMap<String, Object>();
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		try {
			String result = jsonObject.getString(key);
			System.out.println("result---" + result);
			String sub = result.substring(0, 1);
			if (!sub.equals("") && sub.equals("[")) {
				JSONArray jsonArray = jsonObject.getJSONArray(key);
				
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject jsonObject2 = jsonArray.getJSONObject(i);
					Map<String, Object> map = new HashMap<String, Object>();
					Iterator<String> iterator = jsonObject2.keys();
					while (iterator.hasNext()) {
						String json_key = iterator.next();
						System.out.println(json_key);
						Object json_value = jsonObject2.get(json_key);
						if (json_value == null) {
							json_value = "";
						}
						map.put(key + i + "_" + json_key + "_" + s, json_value);
					}

					list.putAll(map);
				}

				if (size == 0) {
					size = jsonArray.size();
					// list.put("size", jsonArray.size());
					s = "b";
					System.out.println("a_size:"+size);
					list.put("size", size);
				} else {
			
					int s2=jsonArray.size();
				
					if(s2>size){
						size=s2;
					}
				 System.out.println("ab_size:"+size);
				
					list.put("size", size);

				}

			} else if (!sub.equals("") && sub.equals("{")) {

				// 遍历Result下的一级参数
				Map<String, Object> map = new HashMap<String, Object>();
				JSONObject jsonObject2 = jsonObject.getJSONObject(key);
				Iterator<String> iterator = jsonObject2.keys();
				while (iterator.hasNext()) {
					String json_key = iterator.next();
					Object json_value = jsonObject2.get(json_key);

					String result1 = jsonObject2.getString(json_key);

					System.out.println(json_key);
					System.out.println(json_value);
					String sub1 = result1.substring(0, 1);
					if (!sub1.equals("") && sub1.equals("[")) {
						JSONArray jsonArray = jsonObject2
								.getJSONArray(json_key);
						for (int i = 0; i < jsonArray.size(); i++) {
							JSONObject jsonObject21 = jsonArray
									.getJSONObject(i);
							Iterator<String> iterator1 = jsonObject21.keys();
							while (iterator1.hasNext()) {
								String json_key1 = iterator1.next();
								System.out.println(json_key1);
								Object json_value1 = jsonObject21
										.get(json_key1);
								System.out.println(json_value1);
								if (json_value1 == null) {
									json_value1 = "";
								}
								map.put(json_key + "_" + json_key1, json_value1);
							}

						}
						list.putAll(map);
					} else if (!sub1.equals("") && sub1.equals("{")) {
						JSONObject jsonObject3 = jsonObject2
								.getJSONObject(json_key);
						Iterator<String> iterator2 = jsonObject3.keys();
						while (iterator2.hasNext()) {
							String json_key1 = iterator2.next();
							Object json_value1 = jsonObject3.get(json_key1);
							String result11 = jsonObject3.getString(json_key1);
							String sub11 = result11.substring(0, 1);
							if (!sub11.equals("") && sub11.equals("[")) {
								Map<String, Object> map2 = getListSearchCourtMap(
										json_key1, result1);
								list.putAll(map2);
							} else {
								map.put(json_key + "_" + json_key1, json_value1);
								list.putAll(map);
							}

							System.out.println(json_key1 + "\t" + json_value1);
						}

					} else {
						map.put(json_key, json_value);
						list.putAll(map);
					}

				}
				Map<String, Object> list2 = getListSearchCourtMap("Partners",
						result);
				list.putAll(list2);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public static Map<String, Object> selectMap(String key, String jsonString) {
		Map<String, Object> map = getListSearchCourtMap(key, jsonString);
		size = 0;
		s = "a";
		return map;
	}

	public static void main(String[] args) {
		String result = "{\"Status\": \"200\",\"Message\": \"查询成功\",\"Result\": [{\"KeyNo\": \"5795c8cec1f47d9409f617759cd67758\",\"Name\": \"小米科技有限责任公司\",\"OperName\": \"雷军\",\"StartDate\": \"2012-02-16T00:00:00\",\"Status\": \"存续\", \"No\": \"420111000222960\"}]}";
		// String result =
		// "{\"Status\":\"200\",\"Message\":\"查询成功\",\"Result\":{\"TermStart\":\"2010-03-03T00:00:00+08:00\",\"TeamEnd\":\"2030-03-02T00:00:00+08:00\",\"CheckDate\":\"2016-04-20T00:00:00+08:00\",\"Partners\":[{\"StockName\":\"刘德\",\"StockType\":\"自然人股东\",\"StockPercent\":null,\"IdentifyType\":\"\",\"IdentifyNo\":\"\",\"ShouldCapi\":null,\"ShoudDate\":null,\"InvestType\":null,\"InvestName\":null,\"RealCapi\":null,\"CapiDate\":null,\"Address\":null}],\"Employees\":[{\"Name\":\"黎万强\",\"Job\":\"监事\",\"CerNo\":\"\",\"ScertName\":\"\"}],\"Branches\":[],\"ChangeRecords\":[{\"ProjectName\":\"注册资本\",\"BeforeContent\":\"5000万元\",\"AfterContent\":\"185000万元\",\"ChangeDate\":\"2016-03-24T00:00:00+08:00\"}],\"ContactInfo\":{\"WebSite\":[{\"Name\":\"小米科技\",\"Url\":\"www.xiaomi.com\"}],\"PhoneNumber\":\"60606666-1000\",\"Email\":\"chenchongwei@xiaomi.com\"},\"KeyNo\":\"9cce0780ab7644008b73bc2120479d31\",\"Name\":\"小米科技有限责任公司\",\"No\":\"110108012660422\",\"BelongOrg\":\"海淀分局\",\"OperName\":\"雷军\",\"StartDate\":\"2010-03-03T00:00:00+08:00\",\"EndDate\":null,\"Status\":\"在营（开业）企业\",\"Province\":\"BJ\",\"UpdatedDate\":\"2016-04-23T14:07:16.578+08:00\",\"CreditCode\":\"91110108551385082Q\",\"RegistCapi\":\"185000万元\",\"EconKind\":\"有限责任公司(自然人投资或控股)\",\"Address\":\"北京市海淀区清河中街68号华润五彩城购物中心二期13层\",\"Scope\":\"手机技术开发；手机生产、手机服务。（限海淀区永捷北路2号二层经营）；技术开发；货物进出口、技术进出口、代理进出口；销售通讯设备；维修仪器仪表；维修办公设备；承办展览展示活动；会议服务；筹备、策划、组织大型庆典。（企业依法自主选择经营项目，开展经营活动；依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\"}}";
		System.out.println(result);
		// Map<String, Object> list = getListMap("Result", result);
		// for (Map map : list) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		boolean b = map.containsKey("a");
		boolean b1 = map.containsKey("b");
		System.out.println(b);
		System.out.println(b1);

		// System.out.println(list.get("Result_No"));
		// System.out.println(list.get("Scope"));
		// }
	}
}
