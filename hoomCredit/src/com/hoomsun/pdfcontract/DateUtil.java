package com.hoomsun.pdfcontract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static Date getCurrentDate(){
		return new Date();
	}
	
	public static String getDateByFormat(Date date, String format){
		SimpleDateFormat dateFormat = null;
		if ("".equals(format) || format == null){
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else{
			dateFormat = new SimpleDateFormat(format);
		}
		
		if(date == null){
			return dateFormat.format(getCurrentDate());
		}else{
			return dateFormat.format(date);
		}
	}
	
	public static final int getYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	public static final int getMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		return cal.get(Calendar.MONTH)+1;
	}
	
	public static final int getDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public static final int getHour(Date date){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	public static final int getMinute(Date date){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}
	
	public static final int getSecond(Date date){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		return cal.get(Calendar.SECOND);
	}
	
	public static final Date setYear(Date date, int year){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.YEAR, year);

		return cal.getTime();
	}
	
	public static final Date setMonth(Date date, int month){
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		cal.set(Calendar.MONTH, month-1);

		cal.get(Calendar.MILLISECOND); 
		cal.set(Calendar.MILLISECOND,0);
		
		return cal.getTime();
	}
	
	public static final Date setDay(Date date, int day){
		Calendar cal = Calendar.getInstance();
		
		cal.setLenient(true);
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, day);

		return cal.getTime();
	}
	
	public static final Date setHour(Date date, int hour){
		Calendar cal = Calendar.getInstance();
		
		cal.setLenient(true);
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hour);

		return cal.getTime();
	}
	
	public static final Date setMinute(Date date, int minute){
		Calendar cal = Calendar.getInstance();
		
		cal.setLenient(true);
		cal.setTime(date);
		cal.set(Calendar.MINUTE, minute);

		return cal.getTime();
	}
	
	public static final Date setSecond(Date date, int second){
		Calendar cal = Calendar.getInstance();
		
		cal.setLenient(true);
		cal.setTime(date);
		cal.set(Calendar.SECOND, second);

		return cal.getTime();
	}
	
	public static long getMillis_day(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}
	
	public static final int getDays(Date date){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static final Date addYear(Date date, int year){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, year);
		
		return cal.getTime();
	}
	public static final Date addMonth(Date date, int month){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		
		return cal.getTime();
	}
	public static final Date addDay(Date date, int day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		
		return cal.getTime();
	}
	
	public static final int getDaySub(Date sdate, Date edate){
		int iResult = 0;
		
		if(edate.after(sdate)){
			iResult = (int) ((getMillis_day(edate) - getMillis_day(sdate)) / (24 * 3600 * 1000));
		}else{
			iResult = (int) ((getMillis_day(sdate) - getMillis_day(edate)) / (24 * 3600 * 1000));
		}
		return iResult;
	}
	
	public static final int getMonthSub(Date sdate, Date edate){
		int iResult = 0;
		
		if (edate.after(sdate)){
			iResult = DateUtil.getMonth(edate)+(DateUtil.getYear(edate)-DateUtil.getYear(sdate))*12-DateUtil.getMonth(sdate);
		}else{
			iResult = DateUtil.getMonth(sdate)+(DateUtil.getYear(sdate)-DateUtil.getYear(edate))*12-DateUtil.getMonth(edate);
		}
		return iResult;
	}
	
	public static Date convertToDateTime(String date) {
		if (date == null || date.equals("")) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date dResult = null;
		try{
			dResult = sdf.parse(date);
		}catch(ParseException ex){
			ex.printStackTrace();
		}
		return dResult;
	}
	
	public static Date convertToDateTime1(String date){
		if (date == null || date.equals("")) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		Date dResult = null;
		try{
			dResult = sdf.parse(date);
		}catch(ParseException ex){
			ex.printStackTrace();
		}
		return dResult;
	}
	
	public static Date convertToDate(String date){
		if (date == null || date.equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date dResult = null;
		try{
			dResult = sdf.parse(date);
		}catch(ParseException ex){
			ex.printStackTrace();
		}
		return dResult;
	}
	public static Date convertToDates(String date){
		if (date == null || date.equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Date dResult = null;
		System.out.println(date+"----date");
		try{
			dResult = sdf.parse(date);
		}catch(ParseException ex){
			ex.printStackTrace();
		}
		return dResult;
	}
	
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertToDate1(String date){
		if (date == null || date.equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date dResult = null;
		try{
			dResult = sdf.parse(date);
		}catch(ParseException ex){
			ex.printStackTrace();
		}
		return dResult;
	}
	/**
	 * 判断是否闰年
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year){
		return (year%4==0&&year%100!=0)||year%400==0;
	}
	/**
	 * 得到两位月
	 * @param month
	 * @return
	 */
	public static String getMonth(int month){
		if(month<10){
			return "0"+month;
		}else {
			return String.valueOf(month);
		}
	}
	/**
	 * 得到两位日
	 * @param day
	 * @return
	 */
	public static String getDay(int day){
		if(day<10){
			return "0"+day;
		}else{
			return String.valueOf(day);
		}
	}
	/**
	 * 获得首个账期日
	 * @param lenddate
	 * @param billdate
	 * @return
	 */
	public static Date getFirstAccountDate(Date lenddate, int billdate){
		int year = getYear(lenddate);
		int month = getMonth(lenddate);
		int day = getDay(lenddate);
		if(day>30){
			if(month ==12){
				year = year+1;
				month = 1;
			}else{
				month = month+1;				
			}
		}else if(15<day && day<=30){
			if(billdate <= day){
				if(month==12){
					month = 1;
					year = year+1;
				}else{
					month = month+1;
				}
			}
		}
		if(isLeapYear(year)){
			if(month == 2){
				if(billdate>29){
					billdate = 29;
				}
			}
		}else{
			if(month == 2){
				if(billdate>28){
					billdate = 28;
				}
			}
		}
		String fdate = year+"-"+getMonth(month)+"-"+getDay(billdate);
		return convertToDate(fdate);
	}
	/**
	 * 获得账期日
	 * @param fAccountDate
	 * @param count
	 * @return
	 */
	public static Date getAccountDate(Date fAccountDate, int count){
		int year = getYear(fAccountDate);
		int month = getMonth(fAccountDate);
		int day = getDay(fAccountDate);
		int addyear = Math.round((float)((month+count-1)/12-0.5));
		month = (month+count-1)%12;
		year = year+addyear;
		if(isLeapYear(year)){
			if(month == 2){
				if(day>15){
					day = 29;
				}
			}
		}else{
			if(month == 2){
				if(day>15){
					day = 28;
				}
			}
		}
		String accountDate = year+"-"+getMonth(month)+"-"+getDay(day);
		return convertToDate(accountDate);
	}
}
