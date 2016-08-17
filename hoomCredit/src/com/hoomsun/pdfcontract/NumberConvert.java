package com.hoomsun.pdfcontract;

import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;



/**
 * 将10亿以内的阿拉伯数字转成汉字大写形式
 * 
 * @author liushengzhun
 * 
 */
public class NumberConvert {
	// 整数部分
	private String integerPart;
	// 小数部分
	private String floatPart;

	// 将数字转化为汉字的数组,因为各个实例都要使用所以设为静态
	private static final char[] cnNumbers = { '零', '壹', '贰', '叁', '肆', '伍',
			'陆', '柒', '捌', '玖' };

	// 供分级转化的数组,因为各个实例都要使用所以设为静态
	private static final char[] series = { '元', '拾', '百', '仟', '万', '拾', '百',
			'仟', '亿' };

	/**
	 * 构造函数,通过它将阿拉伯数字形式的字符串传入
	 * 
	 * @param original
	 */
	public NumberConvert(String original) {
		// 成员变量初始化
		integerPart = "";
		floatPart = "";

		if (original.contains(".")) {
			// 如果包含小数点
			int dotIndex = original.indexOf(".");
			integerPart = original.substring(0, dotIndex);
			floatPart = original.substring(dotIndex + 1);
		} else {
			// 不包含小数点
			integerPart = original;
		}
	}

	/**
	 * 取得大写形式的字符串
	 * 
	 * @return
	 */
	public String getCnString() {
		// 因为是累加所以用StringBuffer
		StringBuffer sb = new StringBuffer();

		// 整数部分处理
		for (int i = 0; i < integerPart.length(); i++) {
			int number = getNumber(integerPart.charAt(i));

			sb.append(cnNumbers[number]);
			sb.append(series[integerPart.length() - 1 - i]);
		}

		// 小数部分处理
		if (floatPart.length() > 0) {
			sb.append("点");
			for (int i = 0; i < floatPart.length(); i++) {
				int number = getNumber(floatPart.charAt(i));

				sb.append(cnNumbers[number]);
			}
		}

		// 返回拼接好的字符串
		return sb.toString();
	}

	/**
	 * 将字符形式的数字转化为整形数字 因为所有实例都要用到所以用静态修饰
	 * 
	 * @param c
	 * @return
	 */
	private static int getNumber(char c) {
		String str = String.valueOf(c);
		return Integer.parseInt(str);
	}

	/**
	 * 金额转大写
	 * 
	 * @param value
	 * @return
	 */
	public static String hangeToBig(Double o) {
		String s = new DecimalFormat("#.00").format(o);
		s = s.replaceAll("\\.", "");
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
		String unit = "仟佰拾兆仟佰拾亿仟佰拾万仟佰拾元角分";
		int l = unit.length();
		StringBuffer sb = new StringBuffer(unit);
		for (int i = s.length() - 1; i >= 0; i--)
			sb = sb.insert(l - s.length() + i, digit[(s.charAt(i) - 0x30)]);
		s = sb.substring(l - s.length(), l + s.length());
		s = s.replaceAll("零[拾佰仟]", "零").replaceAll("零{2,}", "零")
				.replaceAll("零([兆万元])", "$1").replaceAll("零[角分]", "");
		if (s.endsWith("角"))
			s += "零分";
		if (!s.contains("角") && !s.contains("分") && s.contains("元"))
			s += "整";
		if (s.contains("分") && !s.contains("整") && !s.contains("角"))
			s = s.replace("元", "元零");
		
		if(StringUtils.isEmpty(s))
			s="零";
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(new
		// NumberConvert("123456789.12345").getCnString());
		// System.out.println(new NumberConvert("123456789").getCnString());
		// System.out.println(new NumberConvert(".123456789").getCnString());
		// System.out.println(new NumberConvert("0.1234").getCnString());
		// System.out.println(new NumberConvert("1").getCnString());
		// System.out.println(new NumberConvert("12").getCnString());
		// System.out.println(new NumberConvert("123").getCnString());
		// System.out.println(new NumberConvert("1234").getCnString());
		// System.out.println(new NumberConvert("12345").getCnString());
		// System.out.println(new NumberConvert("123456").getCnString());
		// System.out.println(new NumberConvert("1234567").getCnString());
		// System.out.println(new NumberConvert("12345678").getCnString());
		// System.out.println(new NumberConvert("123456789").getCnString());
		System.out.println(hangeToBig(201001.10));
	}
}