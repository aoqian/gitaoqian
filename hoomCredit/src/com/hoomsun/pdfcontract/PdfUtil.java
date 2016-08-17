package com.hoomsun.pdfcontract;

import java.io.File;

public class PdfUtil {
	 /**
	  * 判断文件是否存在，如果不存在则创建文件
	  * @param path 文件夹路径
	  */
	public static void isExist(String path) {
		File file = new File(path);
		//判断文件夹是否存在,如果不存在则创建文件夹
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	/**
	 * 空值或空串转换为整数值
	 * @param content
	 * @return
	 */
	public static int stringChangeInt(String content){
		if(content==null || "".equals(content.trim())){
			return 0;
		}else{
			return Integer.parseInt(content);
		}
	}
	/**
	 * 空值或空串转换为浮点型数值
	 * @param content
	 * @return
	 */
	public static float stringChangeFloat(String content){
		if(content==null || "".equals(content.trim())){
			return 0;
		}else{
			return Float.parseFloat(content);
		}
	}
	/**
	 * 空值或空串转换为浮点型数值
	 * @param content
	 * @return
	 */
	public static String changeToString(Object content){
		if(content==null){
			return "";
		}else{
			return String.valueOf(content);
		}
	}
	
}
