package com.hoomsun.Controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hoomsun.Service.Connect;
import com.hoomsun.Service.EnterprisebusinessdataService;
import com.hoomsun.entity.Enterprisebusinessdata;

import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/home")
public class homepage {
	@Autowired
	private Connect con;
	
	@Autowired
	private EnterprisebusinessdataService ids;
	
	@RequestMapping("/select")
	public String select(HttpServletRequest request) throws IOException{
	String url="http://i.yjapi.com/ECISimple/Search?";	

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("key","aa88905eb8474f32ac52dadb2e7383e8");
	//keyword=小米科技有限责任公司
	map.put("keyword", "小米科技有限责任公司");
	//返回结果集
	
	
	//返回结果集
	Map<String, Object> ma=con.res(map,url);
	Set<Entry<String, Object>> entrySet=ma.entrySet();
	for (Entry<String, Object> entry : entrySet) {  
		//System.out.println(entry.getKey()+":"+entry.getValue()); 
		if(entry.getKey().equals("Result")){
			List<Map<String, Object>> ss=(List<Map<String, Object>>) entry.getValue();
			
			for(Map<String, Object> map1:ss){
				//System.out.println(map1.toString());
				
				Enterprisebusinessdata gs=new Enterprisebusinessdata();
				gs.setName((String)map1.get("Name"));
				gs.setNo((String)map1.get("No"));
				gs.setStatus((String)map1.get("Status"));
				gs.setStartDate((String)map1.get("StartDate"));
				gs.setOperName((String)map1.get("OperName"));
				gs.setKeyNo((String)map1.get("KeyNo"));
				ids.in_gs(gs);
				
			}
	
		
		}

	}
	
		return "home1";
	}
	
	@RequestMapping("/a2")
	public String select2(){
		System.out.println("drfee");
		return "a2";
	}
	
	
	
	
	

}
