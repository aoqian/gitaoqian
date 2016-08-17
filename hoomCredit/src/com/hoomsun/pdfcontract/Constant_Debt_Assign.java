package com.hoomsun.pdfcontract;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Constant_Debt_Assign {
	private static Map<String, String> debtAssignTypes = null;
	
	public static int DEBT_ASSIGN_INIT_GROUP = 1;      //初始债权包
	public static String DEBT_ASSIGN_INIT_DESC = "";
	public static int DEBT_ASSIGN_CAPITAL_GROUP = 2;   //月还本金包
	public static String DEBT_ASSIGN_CAPITAL_DESC = "";
	public static int DEBT_ASSIGN_INTEREST_GROUP = 3;  //月还利息包
	public static String DEBT_ASSIGN_INTEREST_DESC = "";
	
	public static Map<String, String> loadBillReceiveType(){
		if (debtAssignTypes == null){
			debtAssignTypes = new HashMap<String, String>();
			InputStream is = Constant_Debt_Assign.class.getClassLoader().getResourceAsStream("./resources/Debt_Assign.properties");
			Properties dbProps = new Properties();
			try{
				dbProps.load(is);
				
				debtAssignTypes.put(dbProps.getProperty("debt_assign_init_group"), dbProps.getProperty("debt_assign_init_desc"));
				debtAssignTypes.put(dbProps.getProperty("debt_assign_capital_group"), dbProps.getProperty("debt_assign_capital_desc"));
				debtAssignTypes.put(dbProps.getProperty("debt_assign_interest_group"), dbProps.getProperty("debt_assign_interest_desc"));
			
			}catch(Exception ex){
				System.err.println("不能读取属性文件. ");
				ex.printStackTrace();
			}
		}
		
		return debtAssignTypes;
	}
	
	static  {
		InputStream is = Constant_Debt_Assign.class.getClassLoader().getResourceAsStream("./resources/Debt_Assign.properties");
		Properties dbProps = new Properties();
		try{
			dbProps.load(is);
			DEBT_ASSIGN_INIT_GROUP = Integer.parseInt(dbProps.getProperty("debt_assign_init_group"));
			DEBT_ASSIGN_CAPITAL_GROUP = Integer.parseInt(dbProps.getProperty("debt_assign_capital_group"));
			DEBT_ASSIGN_INTEREST_GROUP = Integer.parseInt(dbProps.getProperty("debt_assign_interest_group"));
			
			DEBT_ASSIGN_INIT_DESC = dbProps.getProperty("debt_assign_init_desc");
			DEBT_ASSIGN_CAPITAL_DESC = dbProps.getProperty("debt_assign_capital_desc");
			DEBT_ASSIGN_INTEREST_DESC = dbProps.getProperty("debt_assign_interest_desc");
		}catch(Exception ex){
			System.err.println("不能读取属性文件. ");
			ex.printStackTrace();
		}
	}
}
