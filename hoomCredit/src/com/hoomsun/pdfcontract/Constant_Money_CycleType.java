package com.hoomsun.pdfcontract;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Constant_Money_CycleType {
	private static Map<String, String> moneyCycleTypes = null;
	
	public static int MONEY_CYCLE_ALL_GROUP = 1;
	public static int MONEY_CYCLE_INTEREST_GROUP = 2;
	public static int MONEY_CYCLE_NONE_GROUP = 3;

	public static Map<String, String> loadBillReceiveType(){
		if (moneyCycleTypes == null){
			moneyCycleTypes = new HashMap<String, String>();
			InputStream is = Constant_Debt_Assign.class.getClassLoader().getResourceAsStream("/resources/Money_CycleType.properties");
			Properties dbProps = new Properties();
			try{
				dbProps.load(is);
				
				moneyCycleTypes.put(dbProps.getProperty("money_cycle_all_group"), dbProps.getProperty("money_cycle_all_desc"));
				moneyCycleTypes.put(dbProps.getProperty("money_cycle_interest_group"), dbProps.getProperty("money_cycle_interest_desc"));
				moneyCycleTypes.put(dbProps.getProperty("money_cycle_none_group"), dbProps.getProperty("money_cycle_none_desc"));
				
			}catch(Exception ex){
				System.err.println("不能读取属性文件. ");
				ex.printStackTrace();
			}
		}
		
		return moneyCycleTypes;
	}
	
	static  {
		InputStream is = Constant_Debt_Assign.class.getResourceAsStream("/resources/Money_CycleType.properties");
		Properties dbProps = new Properties();
		try{
			dbProps.load(is);
			MONEY_CYCLE_ALL_GROUP = Integer.parseInt(dbProps.getProperty("money_cycle_all_group"));
			MONEY_CYCLE_INTEREST_GROUP = Integer.parseInt(dbProps.getProperty("money_cycle_interest_group"));
			MONEY_CYCLE_NONE_GROUP = Integer.parseInt(dbProps.getProperty("money_cycle_none_group"));
		}catch(Exception ex){
			System.err.println("不能读取属性文件. ");
			ex.printStackTrace();
		}
	}
}

