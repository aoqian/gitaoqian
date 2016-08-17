package com.hoomsun.pdfcontract;

public class DataTypeUtil {
	public static String nullToString(Object obj){
		return obj==null?"":String.valueOf(obj);
	}
	public static int stringToInt(String str){
		return Integer.parseInt("".equals(str.trim())?"0":str);
	}
	public static double stringToDouble(String str){
		return Double.parseDouble((str == null || "".equals(str.trim()))?"0":str);
	}
}
