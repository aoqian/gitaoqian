package com.hoomsun.pdfcontract;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jt.classic.system.wordbook.WordBookUtil;


import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class FullNoticePDF {
	public static String createPDF(Map dataMap,Map list1,List<Map<String, Object>> list,HttpServletResponse response ){
		HttpServletRequest request = (HttpServletRequest) dataMap.get("request");
		// 输出文档路径及名称
		Date date=new Date();
		SimpleDateFormat format= new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time =format.format(date);
		String filePath = request.getSession().getServletContext().getRealPath("/pdfFile/")+list1.get("CONTRACTCODE")+"/";
		//第一步，创建一个矩形图形对象。
		Rectangle rectPageSize = new Rectangle(PageSize.A4);
		//第二步，创建document对象
		Document document = new Document(rectPageSize, -20, -20, 50, 50);
		//第三步，判断生成的文件是否存在，如果不存在则生成文件。
		PdfUtil.isExist(filePath);
	
		String fileName = filePath+list1.get("CONTRACTCODE")+"-"+time+"full_notice.pdf";
		//第四步，将Document实例和文件输出流用PdfWriter类绑定在一起，从而完成向Document写数据，即写入PDF文档
		try {
			FileOutputStream os = new FileOutputStream(fileName);
			PdfWriter.getInstance(document, os);
			//第五步，将创建的文档实例打开
			document.open();
			//填充内容
			generateFullNotice(document, request, dataMap,list1,list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
//		FileInputStream fs = null;
//		try {
//			fs = new FileInputStream(fileName);
//			try {
//				ExportUtil.download(response, fs, list1.get("LENDERNAME")+"满额通知单.pdf", null);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return fileName;
	}
	/**
	 * 填充内容
	 * @param document
	 * @param request
	 * @throws Exception 
	 */
	public static void generateFullNotice(Document document, HttpServletRequest request, Map dataMap,Map list1,List<Map<String, Object>> list) throws Exception{
		System.out.println("填充内容");
		List<Map<String, Object>> pdfMapList = ParsePdfXmlUtil.parseXmlFile(request.getSession().getServletContext().getRealPath("")+"/WEB-INF/debt/fullNotice.xml");
		Map<String, Image> mapI = getImage(request);
		if(pdfMapList != null && pdfMapList.size() > 0){
			for(int i=0; i<pdfMapList.size(); i++){
				Map tableMap = pdfMapList.get(i);
				String tableid = (String)tableMap.get("tableid");
				String type = (String) tableMap.get("type");
				if(tableid.length()==0){
					int columns = Integer.parseInt("".equals(((String) tableMap.get("columns")).trim())?"0":(String)tableMap.get("columns"));
					String percent = ((String)tableMap.get("percent"));
					List<Map<String, Object>> cellList = (List<Map<String, Object>>) tableMap.get("cellList");
					PdfPTable pdfTable = null;
					if(columns>0){
						pdfTable = new PdfPTable(columns);
					}else{
						if(percent != null && percent.length()>0){
							String[] widths = percent.split(",");
							float[] fWidth = new float[widths.length];
							for(int m=0;m<widths.length;m++){
								fWidth[m] = Float.valueOf(widths[m]);
							}
							pdfTable = new PdfPTable(fWidth);
						}
					}
					if(cellList != null && cellList.size() > 0){
						for(int j=0;j<cellList.size();j++){
							Map cellMap = cellList.get(j);
							PdfPCell pdfCell = new PdfPCell();
							int border = PdfUtil.stringChangeInt((String)cellMap.get("border"));
							if(border>=0){
								pdfCell.setBorder(border);
							}
							int colspan = PdfUtil.stringChangeInt((String) cellMap.get("colspan"));
							pdfCell.setColspan(colspan);
							int rowspan = PdfUtil.stringChangeInt((String) cellMap.get("rowspan"));
							pdfCell.setRowspan(rowspan);
							List<Map<String, Object>> parList = (List<Map<String, Object>>) cellMap.get("parList");
							if(parList != null && parList.size() > 0){
								for(int m=0; m<parList.size(); m++){
									Paragraph par = new Paragraph();
									Map parMap = parList.get(m);
									int alignment = PdfUtil.stringChangeInt((String) parMap.get("alignment"));
									par.setAlignment(alignment);
									
									List<Map<String, Object>> chunkList = (List<Map<String, Object>>) parMap.get("chunkList");
									if(chunkList != null && chunkList.size() > 0){
										for(int n=0;n<chunkList.size();n++){
											
											Chunk chunk = new Chunk();
											Map chunkMap = chunkList.get(n);
											String chunkid = (String) chunkMap.get("chunkid");
											String content = (String) chunkMap.get("content");
											int size = PdfUtil.stringChangeInt((String)chunkMap.get("size"));
											int style = PdfUtil.stringChangeInt((String) chunkMap.get("style"));
											if(chunkid != null && "newPage".equals(chunkid.trim())){
												document.newPage();
											}else{
												if(chunkid != null && chunkid.length()>0){
													chunk.append(fillFullNoticeContent(chunkMap, dataMap,list1));
												}else{
													chunk.append(content);
												}
											}
											Font font = PdfFontUtil.getFont(PdfFontUtil.getBaseFont_Instance(), size, style);
											chunk.setFont(font);
											par.add(chunk);
										}
									}
									pdfCell.addElement(par);
								}
							}
							pdfTable.addCell(pdfCell);
						}
					}
					if(type != null &&"form".equals(type.trim())){
						List<Map<String, Object>> listDebts = list;
						
						for(int n=0; n<listDebts.size(); n++){
							Map map = listDebts.get(n);
							addDebtList(map, pdfTable,n+1);
						}
						
					}
					document.add(pdfTable);
				}else{
					if(type != null &&"image".equals(type.trim())){
						Image image = mapI.get(tableid);
						document.add(image);
					}
				}
			}
			
		}
	}
	/**
	 * 填充满额通知单内容
	 * @param chunkMap
	 * @param chunk
	 */
	public static String fillFullNoticeContent(Map chunkMap, Map dataMap,Map list1){
		return getAgreementInfo(chunkMap, dataMap,list1);
	}
	
	/**
	 * 获得Image对象
	 * @param document
	 * @throws Exception
	 */
	public static Map<String, Image> getImage(HttpServletRequest request) throws Exception {
		Map<String, Image> mapG = new HashMap<String, Image>();
		Map<String, Map<String, Object>> mapImage = ParsePdfXmlUtil.parseXmlImage(request.getSession().getServletContext().getRealPath("")+"/WEB-INF/debt/fullNotice.xml");
		if(!mapImage.isEmpty()){
			for(Entry<String, Map<String, Object>> mapI : mapImage.entrySet()){
				Map map = mapI.getValue();
				String imagename = (String)map.get("imagename");
				float width = PdfUtil.stringChangeFloat(String.valueOf(map.get("width")));
				float height = PdfUtil.stringChangeFloat(String.valueOf(map.get("height")));
				float absoluteX = PdfUtil.stringChangeFloat(String.valueOf(map.get("absoluteX")));
				float absoluteY = PdfUtil.stringChangeFloat(String.valueOf(map.get("absoluteY")));
				
				Image image= Image.getInstance(request.getSession().getServletContext().getRealPath("")+"/WEB-INF/classes/resources/"+imagename);
				image.scaleAbsolute(Float.valueOf(width),Float.valueOf(height));
				image.setAbsolutePosition(Float.valueOf(absoluteX), image.getAbsoluteY()+20);
				image.setAlignment(Image.UNDERLYING);
				mapG.put((String)map.get("imageid"), image);
			}
		}
		return mapG;
	}
	/**
	 * 添加债权列表
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	private static void addDebtList(Map map, PdfPTable pdfTable,int n) throws DocumentException, IOException{
		PdfPCell pCell_num = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_num.addElement(PdfFormUtil.getParagraph_Center(map.get("groups").toString(), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_num);
		//用户名
		PdfPCell pCell_name = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_name.addElement(PdfFormUtil.getParagraph_Center(map.get("count").toString(), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_name);
		PdfPCell pCell_idnum = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_idnum.addElement(PdfFormUtil.getParagraph_Center(String.valueOf(map.get("CUSTIDENTIFY")), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_idnum);
		PdfPCell pCell_curprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
		Object ff =   map.get("c"); 
		BigDecimal bb = new BigDecimal(ff+""); 
		BigDecimal ff1 = bb.setScale(2, BigDecimal.ROUND_HALF_UP);
		pCell_curprice.addElement(PdfFormUtil.getParagraph_Center((ff1+""), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_curprice);
		PdfPCell pCell_equalprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
		Object f =  map.get("c");
		BigDecimal b = new BigDecimal(f+""); 
		BigDecimal f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP);
		pCell_equalprice.addElement(PdfFormUtil.getParagraph_Center((f1+""), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_equalprice);
		PdfPCell pCell_work = PdfFormUtil.getPdfPCell(-1, 1, 1);//工作情况
		pCell_work.addElement(PdfFormUtil.getParagraph_Center(String.valueOf(map.get("PROFESSIONSITUATION")), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_work);
		PdfPCell pCell_loanuse = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_loanuse.addElement(PdfFormUtil.getParagraph_Center(String.valueOf(map.get("LOANDESC")), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_loanuse);
		PdfPCell pCell_initpaydate = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_initpaydate.addElement(PdfFormUtil.getParagraph_Center(String.valueOf(map.get("SREPAYMENTDATE")), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_initpaydate);
		PdfPCell pCell_totalcount = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_totalcount.addElement(PdfFormUtil.getParagraph_Center(String.valueOf(map.get("TOTALCOUNT")), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_totalcount);
		PdfPCell pCell_residuecount = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_residuecount.addElement(PdfFormUtil.getParagraph_Center(String.valueOf(map.get("RESIDUECOUNT")), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_residuecount);
		PdfPCell pCell_rate = PdfFormUtil.getPdfPCell(-1, 1, 1);
		Object rate= map.get("YEARRATE");
		String ratea=rate+"";
		System.out.println("rate--------------"+rate);
		String newrate=ratea.substring(0, 5);
		System.out.println(newrate);
		
		pCell_rate.addElement(PdfFormUtil.getParagraph_Center(String.valueOf(newrate+"%"), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_rate);
	}
	/**
	 * 获得协议信息
	 * @param chunkMap
	 * @param dataMap
	 * @return
	 */
	public static String getAgreementInfo(Map chunkMap, Map dataMap,Map list1){
		String content = "";
		String chunkid = (String) chunkMap.get("chunkid");
		if(chunkid != null && "zip".equals(chunkid.trim())){//邮编
			content = (String) list1.get("POSTCODE");
		}else if(chunkid != null && "address".equals(chunkid.trim())){//邮寄地址
			String province = (String) list1.get("HOME_PROVINCE_NAME");
			String city = (String) list1.get("HOME_CITY_NAME");
			String area = (String) list1.get("HOME_AREA_NAME");
			String address = (String) list1.get("HOME_ADDRESS");
			content = province+city+area+address;
		}else if(chunkid != null && "lendcode".equals(chunkid.trim())){//出借编号
			content = (String) list1.get("APPLYCODE");
		}else if(chunkid != null && "custname".equals(chunkid.trim())){//出借人姓名
			content = (String) list1.get("LENDERNAME");
		}else if(chunkid != null && "lenddate".equals(chunkid.trim())){//出借日期
			content = ((String) list1.get("LENDDATE")).substring(0, 8);
		}else if(chunkid != null && "lendercode".equals(chunkid.trim())){//出借人编号
			content = (String) list1.get("LENDERCODE"); 
		}else if(chunkid != null && "deductdate".equals(chunkid.trim())){//划扣日期
			content = ((String) list1.get("DEDUCTDATE")).substring(0, 8); 
		}else if(chunkid != null && "lendamounts_d".equals(chunkid.trim())){//出借金额-大写
			content = NumberConvert.hangeToBig(DataTypeUtil.stringToDouble(String.valueOf(list1.get("LENDAMOUNTS"))));
		}else if(chunkid != null && "lendamounts".equals(chunkid.trim())){//出借金额小写
			content = String.valueOf(list1.get("LENDAMOUNTS"));
		}else if(chunkid != null && "nowdate".equals(chunkid.trim())){//现在时间
			content = ((String) list1.get("LENDDATE")).substring(0, 8);
		}else if(chunkid != null && "receivetype".equals(chunkid.trim())){//资金出借及回收方式
			content = (String) list1.get("MODENAME");
		}else if(chunkid != null && "nodedate".equals(chunkid.trim())){//赎回日期
			content = ((String) list1.get("NODEDATE")).substring(0, 8); 
		}else if(chunkid != null && "yqsy".equals(chunkid.trim())){//预期收益
			double lendamount = DataTypeUtil.stringToDouble(String.valueOf(list1.get("LENDAMOUNTS")));
			double moderate = DataTypeUtil.stringToDouble(String.valueOf(list1.get("MODERATE")));
			Date lenddate = DateUtil.convertToDate(String.valueOf(list1.get("LENDDATE")).substring(0, 8));
			Date nodedate = DateUtil.convertToDateTime1(String.valueOf(list1.get("NODEDATE")).substring(0, 8));
			int days = DateUtil.getDaySub(lenddate, nodedate);
			int yeardays = 360;
			double interest = ArithUtil.round(lendamount*(moderate/100/yeardays)*days, 2);
			content = String.valueOf(ArithUtil.round(interest + lendamount,2));
		}
		return content;
	}
	/**
	 * 债权列表合计
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public static void debtListTotal(double currpriceTotal, PdfPTable pdfTable) throws DocumentException, IOException{
		PdfPCell pCell_num = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_num.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_num);
		PdfPCell pCell_name = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_name.addElement(PdfFormUtil.getParagraph_Center("合计", PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_name);
		PdfPCell pCell_idnum = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_idnum.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_idnum);
		PdfPCell pCell_curprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_curprice.addElement(PdfFormUtil.getParagraph_Center(String.valueOf(ArithUtil.round(currpriceTotal, 2)), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_curprice);
		PdfPCell pCell_equalprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_equalprice.addElement(PdfFormUtil.getParagraph_Center(String.valueOf(ArithUtil.round(currpriceTotal, 2)), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_equalprice);
		
		PdfPCell pCell_work = PdfFormUtil.getPdfPCell(-1, 1, 1);//工作情况
		pCell_work.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_work);
		
		PdfPCell pCell_loanuse = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_loanuse.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_loanuse);
		PdfPCell pCell_initpaydate = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_initpaydate.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_initpaydate);
		PdfPCell pCell_totalcount = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_totalcount.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_totalcount);
		PdfPCell pCell_residuecount = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_residuecount.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_residuecount);
		PdfPCell pCell_rate = PdfFormUtil.getPdfPCell(-1, 1, 1);
		pCell_rate.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_rate);
	}
}
