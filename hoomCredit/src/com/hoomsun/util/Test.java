package com.hoomsun.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author aoqian
 * 
 * @time 2016-7-15 上午10:47:59
 */
public class Test {

	Object object = new Object();

	//
	// public static void main(String[] args) {
	// // List<HashMap<String, String>> list = new ArrayList<HashMap<String,
	// String>>();
	// //
	// // HashMap hashMap = new HashMap<String, String>();
	// // hashMap.put("test", "test1");
	// // HashMap hashMap2 = new HashMap<String, String>();
	// // hashMap2.put("test", "test2");
	// // list.add(hashMap);
	// // list.add(hashMap2);
	// // Object object = list;
	// //
	// // if (object instanceof java.util.List) {
	// // System.out.println("Object 是一个list集合");
	// // }
	// int size = 3;
	// if (size != 0 && size != 1) {
	// System.out.println("f");
	//
	// }
	// }

	public static void main(String[] args) {
		System.out.println("生成的10为随机数为：" + getCharAndNumr(10));
	}

	public static String getCharAndNumr(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
}
