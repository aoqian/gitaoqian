package com.hoomsun.pdfcontract;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JudgmentDate {
	public static String judgment(String date){
		String Time=date.substring(0, 6);
		System.out.println(Time+"==Time==");
		Date lenddate = DateUtil.convertToDates(String.valueOf(date).substring(0, 6));
		
		Calendar c = Calendar.getInstance();
		c.setTime(lenddate);
		 c.add(Calendar.MONTH, 1);
		String time=date.substring(6, 8);
		System.out.println(time+"===time===");
		int day=Integer.parseInt(time);
		String str;
		if(day<15){
		Date nextTime=	c.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");  
		 str=sdf.format(nextTime); 
		str=str+"15";
		System.out.println(str+"==15===");
		}else{
			Date nextTime=	c.getTime();
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");  
			 str=sdf.format(nextTime);
			int yer= Integer.parseInt(str.substring(0, 4)) ;
			int a= yer%4;
			System.out.println(a+"a====");
			if(a==0){
				String month= str.substring(4, 6) ;
				if(month=="02"){
					str=str+"29";
					System.out.println(str+"==29==");
				}else{
					str=str+"30";	
					System.out.println(str+"===30===");
				}
			}else{
				String month= str.substring(4, 6) ;
				if(month=="02"){
					str=str+"28";
					System.out.println(str+"==28==");
				}else{
					str=str+"30";	
					System.out.println(str+"===30===");
				}
			}
			
		}
		
		return str;
		
	}
	public static String judgmentChoice(String lend,String today){
		String lenddate= judgment(lend);
		int lendtime=Integer.parseInt(lenddate);
		System.out.println(lendtime+"===lendtime====");
		int totime=Integer.parseInt(today);
		if(lendtime>totime){
			return "0";
		}else{
			return "1";
		}
	}
}
