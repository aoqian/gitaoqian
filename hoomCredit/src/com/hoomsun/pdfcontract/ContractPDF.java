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

import com.hoomsun.entity.First;
import com.hoomsun.entity.analysis_of_home_ownership;
import com.hoomsun.entity.associated_information;
import com.hoomsun.entity.check_item_details;
import com.hoomsun.entity.court_information_field_table;
import com.hoomsun.entity.frequency_details;
import com.hoomsun.entity.plat;
import com.hoomsun.entity.risk_check_item_list;
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

public class ContractPDF {
	public static String createPDF(Map dataMap,Map list1,HttpServletResponse response ){
		HttpServletRequest request = (HttpServletRequest) dataMap.get("request");
		// 输出文档路径及名称
		Date date=new Date();
		SimpleDateFormat format= new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time =format.format(date);
		String filePath = request.getSession().getServletContext().getRealPath("/pdfFile/")+list1.get("${Username}")+"/";
		//第一步，创建一个矩形图形对象。
		Rectangle rectPageSize = new Rectangle(PageSize.A4);
		//第二步，创建document对象
		Document document = new Document(rectPageSize, -20, -20, 50, 50);
		//第三步，判断生成的文件是否存在，如果不存在则生成文件。
		PdfUtil.isExist(filePath);
	
		String fileName = filePath+list1.get("${Username}")+"-"+time+"contract.pdf";
		//第四步，将Document实例和文件输出流用PdfWriter类绑定在一起，从而完成向Document写数据，即写入PDF文档
		try {
			FileOutputStream os = new FileOutputStream(fileName);
			PdfWriter.getInstance(document, os);
			//第五步，将创建的文档实例打开
			document.open();
			//填充内容
			generateFullNotice(document, request, dataMap,list1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();

		return fileName;
	}
	/**
	 * 填充内容
	 * @param document
	 * @param request
	 * @throws Exception 
	 */
	public static void generateFullNotice(Document document, HttpServletRequest request, Map dataMap,Map list1) throws Exception{
		System.out.println("填充内容");
		List<Map<String, Object>> pdfMapList = ParsePdfXmlUtil.parseXmlFile(request.getSession().getServletContext().getRealPath("")+"/WEB-INF/debt/contract.xml");
		Map<String, Image> mapI = getImage(request);
		if(pdfMapList != null && pdfMapList.size() > 0){
			for(int i=0; i<pdfMapList.size(); i++){
				Map tableMap = pdfMapList.get(i);
				String tableid = (String)tableMap.get("tableid");
				System.out.println(tableid+"==tableid==");
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
	 * 获得协议信息
	 * @param chunkMap
	 * @param dataMap
	 * @return
	 */
	public static String getAgreementInfo(Map chunkMap, Map dataMap,Map list1){
		String content = "";
		String chunkid = (String) chunkMap.get("chunkid");
		if(chunkid != null && "lendcode".equals(chunkid.trim())){//进件编号
			content = (String) list1.get("${pactcode}");
		}else if(chunkid != null && "lendcode".equals(chunkid.trim())){//出借编号
			content = (String) list1.get("APPLYCODE");
		}else if(chunkid != null && "custname".equals(chunkid.trim())){//出借人姓名
			content = (String) list1.get("${Username}");
		}else if(chunkid != null && "modename".equals(chunkid.trim())){//产品类型
			content = (String) list1.get("${modename}");
		}else if(chunkid != null && "type".equals(chunkid.trim())){//证件类型
			content = (String) list1.get("${type}"); 
		}else if(chunkid != null && "number".equals(chunkid.trim())){//证件号
			content = (String) list1.get("${number}"); 
		}else if(chunkid != null && "daxie".equals(chunkid.trim())){//大写
			content = (String) list1.get("${daxie}"); 
		}else if(chunkid != null && "account".equals(chunkid.trim())){//银行名
			String account= String.valueOf(list1.get("${bankname}"));
			String branch= String.valueOf(list1.get("${branch}"));
			if(list1.get("${branch}")==null){
				branch="";
			}
			String zhihang= String.valueOf(list1.get("${zhihang}"));
			if(list1.get("${zhihang}")==null){
				zhihang="";
			}
			content=account+branch+zhihang;
		}else if(chunkid != null && "Username".equals(chunkid.trim())){//账户
			content = (String) list1.get("${account}");
		}else if(chunkid != null && "time".equals(chunkid.trim())){//年月日
			String y=(String) list1.get("${YY}");
			String m=(String) list1.get("${MM}");
			String d=(String) list1.get("${DD}");
			content=y+"年"+m+"月"+d+"日";
		}else if(chunkid != null && "nodedate".equals(chunkid.trim())){//赎回日期
			content = ((String) list1.get("NODEDATE")).substring(0, 8); 
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
	/**
	 * 获得Image对象
	 * @param document
	 * @throws Exception
	 */
	public static Map<String, Image> getImage(HttpServletRequest request) throws Exception {
		Map<String, Image> mapG = new HashMap<String, Image>();
		Map<String, Map<String, Object>> mapImage = ParsePdfXmlUtil.parseXmlImage(request.getSession().getServletContext().getRealPath("")+"/WEB-INF/classes/resources/fullNotice.xml");
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
	public static String createPDF(Map dataMap, HttpServletResponse response,
			int size, First f1, analysis_of_home_ownership an1,
			List<Map<String, Object>> li, List<check_item_details> chs,
			List<risk_check_item_list> re, List<plat> plss,
			List<frequency_details> frss, List<associated_information> ass,
			List<court_information_field_table> courtss) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}

