package com.hoomsun.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class ConnectUtil {

	public static final String GET_URL = "http://i.yjapi.com";

	public static final String POST_URL = "http://localhost:9045/test";
	
	public static final String  geturl="http://192.168.1.35:8080/hoomsun.credit/views";
	
	public static final String  posturl="http://192.168.1.35:8080/hoomsun.credit/views/creditConnect/tongdun";
	
	
	public static String readContentFromGet2(Map<String, Object> ma)
			throws IOException {
		
		String getURL = geturl;
		Set<String> keys = ma.keySet();
	    int i = 0;
		for (String key : keys) {
			if (i == 0 || i == 1) {
				getURL += "/" + ma.get(key);
				System.out.println(ma.get(key));
			} else if (i == 2) {
				
				getURL+= "?"+key+"="+URLEncoder.encode((String) ma.get(key), "utf-8");
				
			} else {
				
				getURL+= "&"+key+"="+URLEncoder.encode((String) ma.get(key), "utf-8");
			}
			i++;
		}
		// getURL = getURL.substring(0, getURL.length() - 1);
		System.out.println(getURL);

		URL getUrl = new URL(getURL);
		HttpURLConnection connection = (HttpURLConnection) getUrl
				.openConnection();
		connection.connect();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "UTF-8"));
		System.out.println("=============================");
		System.out.println("Contents of get request");
		System.out.println("=============================");
		String lines;
		String s = null;
		//Map<String, Object> productMap = new HashMap<String, Object>();
		// 转成map
		while ((lines = reader.readLine()) != null) {
			System.out.println(lines);
			s = lines;

		}

		reader.close();


		// 断开连接
		
		System.out.println("=============================");
		System.out.println("Contents of get request ends");
		System.out.println("=============================");
		return s;
	}
	
	
	

	public static String readContentFromGet(Map<String, Object> ma)
			throws IOException {
		// 拼凑get请求的URL字串，使用URLEncoder.encode对特殊和不可见字符进行编码
		String getURL = GET_URL;
		// 遍历出所有参数
		Set<String> keys = ma.keySet();
	

		int i = 0;
		for (String key : keys) {
			if (i == 0 || i == 1) {
				getURL += "/" + ma.get(key);
				System.out.println(ma.get(key));
			} else if (i == 2) {
				
				getURL+= "?"+key+"="+URLEncoder.encode((String) ma.get(key), "utf-8");
				
			} else {
				
				getURL+= "&"+key+"="+URLEncoder.encode((String) ma.get(key), "utf-8");
			}
			i++;
		}
		// getURL = getURL.substring(0, getURL.length() - 1);
		System.out.println(getURL);
		// 拼凑get请求的URL字串，使用URLEncoder.encode对特殊和不可见字符进行编码
		/*
		 * String getURL = GET_URL + "?key=" + URLEncoder.encode
		 * 
		 * ("05ae3812e75044c492382bae2b61f2e9", "utf-8") + "&keyword=" +
		 * URLEncoder.encode("小米科技有限责任公司", "utf-8") + "&dtype=json";
		 */
		URL getUrl = new URL(getURL);
		// 根据拼凑的URL，打开连接，URL.openConnection函数会根据URL的类型，
		// 返回不同的URLConnection子类的对象，这里URL是一个http，因此实际返回的是HttpURLConnection

		HttpURLConnection connection = (HttpURLConnection) getUrl
				.openConnection();
		// 进行连接，但是实际上get request要在下一句的connection.getInputStream()函数中才会真正发到
		// 服务器
		connection.connect();
		// 取得输入流，并使用Reader读取
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(connection.getInputStream()));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "UTF-8"));
		System.out.println("=============================");
		System.out.println("Contents of get request");
		System.out.println("=============================");
		String lines;
		String s = null;
		//Map<String, Object> productMap = new HashMap<String, Object>();
		// 转成map
		while ((lines = reader.readLine()) != null) {
			System.out.println(lines);
			s = lines;

		}

		reader.close();
		// Map<String, Object> map = parseJSON2Map(s);

		// System.out.println("json装map---" + map.get("Result"));
		// productMap = (Map<String, Object>) map.get("Result");

		// 断开连接
		// System.out.println("json装map---" + productMap.get("OperName"));
		System.out.println("=============================");
		System.out.println("Contents of get request ends");
		System.out.println("=============================");
		return s;
	}

	/**
	 * json转Map
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

	public static String readContentFromPost(Map<String, Object> ma) throws IOException {
		// Post请求的url，与get不同的是不需要带参数
		URL postUrl = new URL(posturl);
		// 打开连接
		HttpURLConnection connection = (HttpURLConnection) postUrl
				.openConnection();
		// Output to the connection. Default is
		// false, set to true because post
		// method must write something to the
		// connection
		// 设置是否向connection输出，因为这个是post请求，参数要放在
		// http正文内，因此需要设为true
		connection.setDoOutput(true);
		// Read from the connection. Default is true.
		connection.setDoInput(true);
		// Set the post method. Default is GET
		connection.setRequestMethod("POST");
		// Post cannot use caches
		// Post 请求不能使用缓存
		connection.setUseCaches(false);
		// This method takes effects to
		// every instances of this class.
		// URLConnection.setFollowRedirects是static函数，作用于所有的URLConnection对象。
		// connection.setFollowRedirects(true);

		// This methods only
		// takes effacts to this
		// instance.
		// URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
		connection.setInstanceFollowRedirects(true);
		// Set the content type to urlencoded,
		// because we will write
		// some URL-encoded content to the
		// connection. Settings above must be set before connect!
		// 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
		// 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
		// 进行编码
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
		// 要注意的是connection.getOutputStream会隐含的进行connect。
		connection.connect();
		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());
		
		// The URL-encoded contend
		// 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
		 
		Set<String> keys = ma.keySet();
		

		String cc="";
		for (String key : keys) {
			cc+=ma.get(key).toString()+",";
				
			
		}
		
		
		String content = "keyword=" + URLEncoder.encode( cc, "utf-8");
		//content = "userName=" + ;
		// DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
		out.writeBytes(content);

		out.flush();
		out.close(); // flush and close
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(),"UTF-8"));
		String line;
		System.out.println("=============================");
		System.out.println("Contents of post request");
		System.out.println("=============================");
		String s = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			s=line;
		}
		System.out.println("=============================");
		System.out.println("Contents of post request ends");
		System.out.println("=============================");
		reader.close();
		connection.disconnect();
		
		return s;
	}

	/** */
	/**
	 * @param args
	 */
	public static String main(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String s = "";
		try {
			s = readContentFromGet(map);

			/* readContentFromPost(); */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	
	public static String main2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String s = "";
		try {
			s = readContentFromPost(map);

			/* readContentFromPost(); */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
