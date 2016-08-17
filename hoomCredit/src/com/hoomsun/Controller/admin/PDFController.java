package com.hoomsun.Controller.admin;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoomsun.Service.FirstService;
import com.hoomsun.entity.First;
import com.hoomsun.entity.User;
import com.hoomsun.entity.analysis_of_home_ownership;
import com.hoomsun.entity.associated_information;
import com.hoomsun.entity.check_item_details;
import com.hoomsun.entity.court_information_field_table;
import com.hoomsun.entity.frequency_details;
import com.hoomsun.entity.plat;
import com.hoomsun.entity.risk_check_item_list;
import com.hoomsun.pdfcontract.ContractPDF;
import com.hoomsun.pdfcontract.LendReportPDF;
import com.hoomsun.pdfcontract.ParsePdfXmlUtil;
import com.hoomsun.pdfcontract.PdfFontUtil;
import com.hoomsun.pdfcontract.PdfFormUtil;
import com.hoomsun.pdfcontract.PdfUtil;
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

import org.apache.commons.collections.map.HashedMap;
@Controller
@RequestMapping("pdf")
public class PDFController {
	
	@Autowired
	private FirstService ffss;
	
	@RequestMapping("middle")
	public void middleshow(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("pdf-----------------");
	
		String num = request.getParameter("num");
		
		// 本地查询
		First f1 = ffss.sel_first(num);
		if (f1 != null) {
			List<analysis_of_home_ownership> an = ffss.sel_address(f1.getId());
			System.out.println("size:" + an.size());
			analysis_of_home_ownership an1 = an.get(0);
			List<risk_check_item_list> re = ffss.sel_risk(f1.getId());
			List<Map<String, Object>> li = ffss.sel_risk_count(f1.getId());
			List<check_item_details> chs = new ArrayList<check_item_details>();
			List<plat> plss = new ArrayList<plat>();
			for (risk_check_item_list rr : re) {
				check_item_details ch = ffss.sel_ch(rr.getId());
				if (ch != null) {
					chs.add(ch);

					List<plat> pls = ffss.sel_pl(ch.getId());

					if (pls.size() != 0) {
						for (plat p : pls) {
							if (p != null) {
								plss.add(p);
							}
						}
					}

				}

			}
			// frequency
			List<frequency_details> frss = new ArrayList<frequency_details>();
			// court
			List<court_information_field_table> courtss = new ArrayList<court_information_field_table>();
			for (check_item_details c1 : chs) {
				
				// 频度规则详情
				List<frequency_details> frs = ffss.sel_fre(c1.getId());
				if (frs != null) {
					frss.addAll(frs);
				}
				// 失信人与被执行人
				List<court_information_field_table> courts = ffss.courts(c1
						.getId());
				if (courts != null) {
					courtss.addAll(courts);
				}

			}
			// associate
			List<associated_information> ass = new ArrayList<associated_information>();
			for (frequency_details fre1 : frss) {
				List<associated_information> as = ffss.sel_ass(fre1.getId());
				if (as != null) {
					ass.addAll(as);
				}
			}
			Map list1=new HashMap();
		//	User user1 = (User) request.getSession().getAttribute("user");
		//	String username=user1.getName();
			User user1=new User();
			user1.setName("jiafei");
			user1.setCode("123456");
			user1.setId("3");
		    list1.put("user", user1);
			
		    Map dataMap=new HashedMap();
			dataMap.put("request", request);
			Map map=new HashMap();
			
			map.put("total", re.size());
			map.put("first", f1);
			map.put("adds", an1);
			map.put("counts", li);
			map.put("chs", chs);
			map.put("risks", re);
			map.put("plss", plss);
			map.put("frss", frss);
			map.put("ass", ass);
			map.put("courtss", courtss);
			
			String fileName= createPDF(dataMap,response,list1,map,li);
			
			response.reset();
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/pdf");
			File file = new File(fileName);
			System.out.println(file + "................file");
			DataOutputStream temps = null;
			DataInputStream in = null;
			if (file.exists()) {
				try {
				temps = new DataOutputStream(response.getOutputStream());
				in = new DataInputStream(new FileInputStream(fileName));
				byte[] b = new byte[2048];
				while ((in.read(b)) != -1) {
				temps.write(b);
				temps.flush();
				}
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
	
		}
			
		}
	
		

		
		System.out.println("pdf-----------------2");

}
	

	public  String createPDF(Map dataMap, HttpServletResponse response,
			Map<String,String> list1,Map map,List<Map<String, Object>> li){
		System.out.println("进入方法：createPDF");
		HttpServletRequest request = (HttpServletRequest) dataMap.get("request");
		Date date=new Date();
		SimpleDateFormat format= new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time =format.format(date);
		// 输出文档路径及名称
		String filePath = request.getSession().getServletContext().getRealPath("/pdfFile/")+list1.get("CONTRACTCODE")+"/";
		//第一步，创建一个矩形图形对象。
		Rectangle rectPageSize = new Rectangle(PageSize.A4);
		//第二步，创建document对象
		Document document = new Document(rectPageSize, -20, -20, 50, 50);
		//第三步，判断生成的文件是否存在，如果不存在则生成文件。
		PdfUtil.isExist(filePath);
		
		String fileName = filePath+list1.get("CONTRACTCODE")+"-"+time+"report_lendfunds.pdf";
		//第四步，将Document实例和文件输出流用PdfWriter类绑定在一起，从而完成向Document写数据，即写入PDF文档
		try {
			FileOutputStream os = new FileOutputStream(fileName);
			PdfWriter.getInstance(document, os);
			//第五步，将创建的文档实例打开
			document.open();
			//填充内容
			generateLendReport(document, request, dataMap,list1,map,li);
		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
		return fileName;
		
		
	}
	
	public  void generateLendReport(Document document, HttpServletRequest request, Map dataMap,Map list1,
			Map map,List<Map<String, Object>> li) throws Exception{
		System.out.println("进入方法：generateLendReport");
		List<Map<String, Object>> pdfMapList = ParsePdfXmlUtil.parseXmlFile(request.getSession().getServletContext().getRealPath("")+"/WEB-INF/resource/lendReport.xml");
		Map<String, Image> mapI = getImage(request,map);
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
					int ta=0;
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
											String content1="";
											int size = PdfUtil.stringChangeInt((String)chunkMap.get("size"));
											int style = PdfUtil.stringChangeInt((String) chunkMap.get("style"));
											if(chunkid != null && chunkid.length()>0){
												content1=fillLendReportContent(chunkMap, dataMap,list1,map);
												chunk.append(content1);
											}else{
												chunk.append(content);
											}
											
											if("dishonestpeoplename".equals(chunkid.trim()) && content1.equals("")){
												ta=9;
											}else if("execution_status".equals(chunkid.trim()) && content1.equals("")){
												ta=9;
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
						
						BigDecimal cmoney=new BigDecimal("0");
					
					   for(int n=0;n<li.size();n++){
						   Map ma=li.get(n);
						   System.out.println("groups:"+ma.get("groups"));
						   addDebtList(ma, pdfTable,n+1,map);
					   }
						
						
					}
					
					if(ta!=9){
						
						document.add(pdfTable);
					}
					
				}else{
					if(type != null &&"image".equals(type.trim())){
						Image image = mapI.get(tableid);
						document.add(image);
					}
				}
			}
		}
	}
	
	
	private  void addDebtList(Map map, PdfPTable pdfTable,int n,Map mas) throws DocumentException, IOException{
		
		String groups=map.get("groups").toString();
		List<risk_check_item_list> rrs=new ArrayList<risk_check_item_list>();
		List<risk_check_item_list> re =(List<risk_check_item_list>)mas.get("risks");
		List<check_item_details> ccs = new ArrayList<check_item_details>();
		List<plat> pps = new ArrayList<plat>();
		List<frequency_details> ffs = new ArrayList<frequency_details>();
		List<associated_information> aas = new ArrayList<associated_information>();
		
		//risk
		if(re!=null){
			for(risk_check_item_list r:re){
				String gr=r.getGroups();
				if(gr.equals(groups)){
					rrs.add(r);
					//check
					System.out.println("rid:"+r.getId());
				
				if( ffss.sel_ch(r.getId())!=null){
					check_item_details ch=ffss.sel_ch(r.getId());
					   ccs.add(ch);
					   //plat
					   List<plat> pls = ffss.sel_pl(ch.getId());
					   pps.addAll(pls);
					   //frequency
					   List<frequency_details> frs = ffss.sel_fre(ch.getId());
						ffs.addAll(frs);
						for(frequency_details fi:frs){
							List<associated_information> as = ffss.sel_ass(fi.getId());
							aas.addAll(as);
						}
				}
				
					
				}
			}
		}
	
		
		int size2=rrs.size();
		int size4=pps.size()+ffs.size()+aas.size();
		int size=1;
		if(size4<size2){
		    if(size2>size){
		    	size=size2;
		    }
		}else{
			size=size4;
		}
		System.out.println("size:"+size);
		System.out.println("size2:"+size2);
		System.out.println("size4:"+size4);
		//1
		PdfPCell pCell_num = PdfFormUtil.getPdfPCell(-1, 1, size);
		pCell_num.addElement(PdfFormUtil.getParagraph_Center(map.get("groups").toString(), PdfFontUtil.getFont_Instance_Text()));
		pdfTable.addCell(pCell_num);
		//2
		if(rrs!=null){
			  for(risk_check_item_list r:rrs){
				  int si=1;
				    check_item_details ch = ffss.sel_ch(r.getId());
				    if(ch!=null){
				    	List<plat> pls = ffss.sel_pl(ch.getId());
						List<frequency_details> frs = ffss.sel_fre(ch.getId());
						List<associated_information> aas2 = new ArrayList<associated_information>();
						for(frequency_details fi:frs){
							
							List<associated_information> as = ffss.sel_ass(fi.getId());
							aas2.addAll(as);
						} 
						 si=pls.size()+frs.size()+aas2.size();
							int xi=1;
							if(si>xi){
								xi=si;
							}
							PdfPCell pCell_name = PdfFormUtil.getPdfPCell(-1, 1, xi);
						    pCell_name.addElement(PdfFormUtil.getParagraph_Center(r.getItem_name(), PdfFontUtil.getFont_Instance_Text()));
							pdfTable.addCell(pCell_name);
							//3
							PdfPCell pCell_idnum = PdfFormUtil.getPdfPCell(-1, 1, xi);
							pCell_idnum.addElement(PdfFormUtil.getParagraph_Center(r.getRisk_level(), PdfFontUtil.getFont_Instance_Text()));
							pdfTable.addCell(pCell_idnum);
						
						 if(ch.getFrequency_detail_list()==null && ch.getPlatform_count()==null){
							//4
							 if(ch.getFraud_type()==null){
								 PdfPCell pCell_curprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
									pCell_curprice.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
									pdfTable.addCell(pCell_curprice);
							 }else{
								 PdfPCell pCell_curprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
									pCell_curprice.addElement(PdfFormUtil.getParagraph_Center(ch.getFraud_type(), PdfFontUtil.getFont_Instance_Text()));
									pdfTable.addCell(pCell_curprice);
							 }
								
						 }
							
						
							if(pls!=null){
								for(plat pi:pls){
									//4
									PdfPCell pCell_curprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
									pCell_curprice.addElement(PdfFormUtil.getParagraph_Center(pi.getPlat_type(), PdfFontUtil.getFont_Instance_Text()));
									pdfTable.addCell(pCell_curprice);
								}
							}
							
							if(frs!=null){
								for(frequency_details fi1:frs){
									PdfPCell pCell_curprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
									pCell_curprice.addElement(PdfFormUtil.getParagraph_Center(fi1.getDetail(), PdfFontUtil.getFont_Instance_Text()));
									pdfTable.addCell(pCell_curprice);
									List<associated_information> as1 = ffss.sel_ass(fi1.getId());
									for(associated_information ai:as1){
										//4
									    pCell_curprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
										pCell_curprice.addElement(PdfFormUtil.getParagraph_Center(ai.getData(), PdfFontUtil.getFont_Instance_Text()));
										pdfTable.addCell(pCell_curprice);
										
									}
								}
							}
				    }else{
				    	PdfPCell pCell_name = PdfFormUtil.getPdfPCell(-1, 1, 1);
					    pCell_name.addElement(PdfFormUtil.getParagraph_Center(r.getItem_name(), PdfFontUtil.getFont_Instance_Text()));
						pdfTable.addCell(pCell_name);
						//3
						PdfPCell pCell_idnum = PdfFormUtil.getPdfPCell(-1, 1, 1);
						pCell_idnum.addElement(PdfFormUtil.getParagraph_Center(r.getRisk_level(), PdfFontUtil.getFont_Instance_Text()));
						pdfTable.addCell(pCell_idnum);
						//4
						PdfPCell pCell_curprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
							pCell_curprice.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
							pdfTable.addCell(pCell_curprice);
						
				    	
				    }
				
					
				

				
					
					
				  
			  }
			
		}
		if(size2==0){
			PdfPCell pCell_name = PdfFormUtil.getPdfPCell(-1, 1, 1);
		    pCell_name.addElement(PdfFormUtil.getParagraph_Center("正常", PdfFontUtil.getFont_Instance_Text()));
			pdfTable.addCell(pCell_name);
			//3
			PdfPCell pCell_idnum = PdfFormUtil.getPdfPCell(-1, 1, 1);
			pCell_idnum.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
			pdfTable.addCell(pCell_idnum);
			
			//4
			PdfPCell  pCell_curprice = PdfFormUtil.getPdfPCell(-1, 1, 1);
			pCell_curprice.addElement(PdfFormUtil.getParagraph_Center("", PdfFontUtil.getFont_Instance_Text()));
			pdfTable.addCell(pCell_curprice);
			
			
		}

			
			
}
	
	/**
	 * 填充PDF内容
	 * @param chunkMap
	 * @param dataMap
	 * @return
	 */
	public static String fillLendReportContent(Map chunkMap, Map dataMap,Map list1,Map map){
		String content = "";
		String chunkid = (String) chunkMap.get("chunkid");
		User user1= ((User) list1.get("user"));
		int total=(Integer) map.get("total");
		First f1=(First)map.get("first");
		analysis_of_home_ownership an1 =(analysis_of_home_ownership)map.get("adds");
		List<Map<String, Object>> li=(List<Map<String, Object>>)map.get("counts");
		List<risk_check_item_list> re =(List<risk_check_item_list>)map.get("risks");
		List<check_item_details> chs =(List<check_item_details>)map.get("chs");
		List<plat> plss = (List<plat>)map.get("plss");
		List<frequency_details> frss = (List<frequency_details>)map.get("frss");
		List<associated_information> ass=(List<associated_information>)map.get("ass");
		List<court_information_field_table> courtss =(List<court_information_field_table>)map.get("courtss");	
		if(chunkid != null && "custname".equals(chunkid.trim())){
			content = user1.getName();//用户姓名
		}else if(chunkid != null && "report_id".equals(chunkid.trim())){
		    content=f1.getReport_id();//报告编号
		}else if(chunkid != null && "report_time".equals(chunkid.trim())){
			content = f1.getReport_time();//报告时间

		}else if(chunkid != null && "final_score".equals(chunkid.trim())){
			content = f1.getFinal_score();
		}else if(chunkid != null && "total".equals(chunkid.trim())){
		
			content=String.valueOf(total);
			
		}else if(chunkid != null && "assess".equals(chunkid.trim())){
			int sore=Integer.parseInt(f1.getFinal_score());
		    if(sore<70){
		    	content="申请用户未检出高危风险，建议通过";
			 }else if(sore>69 && sore<90){
				 content="申请用户存在较大风险，建议进行人工审核";
			 }else if(sore>89){
				 content="申请用户检测出高危风险，建议拒绝";
			 }
		}else if(chunkid != null && "name".equals(chunkid.trim())){
			content = f1.getName();
		}else if(chunkid != null && "iden".equals(chunkid.trim())){
			content=f1.getId_number();
		}else if(chunkid != null && "tel".equals(chunkid.trim())){
			content = f1.getPhone_number();
		}else if(chunkid != null && "id_card_address".equals(chunkid.trim()) && an1.getId_card_address()!=null){
			content="身份证所属地地址:"+an1.getId_card_address();
		}else if(chunkid != null && "mobile_address".equals(chunkid.trim())  && an1.getMobile_address()!=null){
			content="手机所属地地址:"+an1.getMobile_address();
		}else if(chunkid != null && "true_ip_address".equals(chunkid.trim()) && an1.getTrue_ip_address()!=null){
			content="ip所属地地址:"+an1.getTrue_ip_address();
		}else if(chunkid != null && "wifi_address".equals(chunkid.trim()) && an1.getWifi_address()!=null){
			content="wifi所属地地址:"+an1.getWifi_address();
		}else if(chunkid != null && "cell_address".equals(chunkid.trim()) && an1.getCell_address()!=null){
			content="基站所属地地址:"+an1.getCell_address();
		}
		
		if(courtss !=null && courtss.size() > 0) {
			for(court_information_field_table court:courtss){
				String type=court.getFraud_type();
				if(type.equals("法院失信")){
					if(chunkid != null && "dishonestpeoplename".equals(chunkid.trim())){
						content=court.getName();
					}else if(chunkid != null && "sex".equals(chunkid.trim())){
						content=court.getGender();
					}else if(chunkid != null && "courtofexecution".equals(chunkid.trim())){
						content=court.getCourt_name();
					}else if(chunkid != null && "province".equals(chunkid.trim())){
						content=court.getProvince();
					}else if(chunkid != null && "Basedotimplementationotsymbol".equals(chunkid.trim())){
						content=court.getExecution_base();
					}else if(chunkid != null && "filingtime".equals(chunkid.trim())){
						content=court.getFiling_time();
					}else if(chunkid != null && "caseNo".equals(chunkid.trim())){
						content=court.getCase_number();
					}else if(chunkid != null && "makeexecutivebasis".equals(chunkid.trim())){
						content=court.getExecution_department();
					}else if(chunkid != null && "obligationtmeld".equals(chunkid.trim())){
						content=court.getDuty();
					}else if(chunkid != null && "performancenotpbe".equals(chunkid.trim())){
						content=court.getSituation();
					}else if(chunkid != null && "dbotscotiotsc".equals(chunkid.trim())){
						content=court.getDiscredit_detail();
					}else if(chunkid != null && "age".equals(chunkid.trim())){
						content=court.getAge();
					} 
					
					
				}else if(type.equals("法院执行")){
					
					if(chunkid != null && "executedpersonname".equals(chunkid.trim())){
						content=court.getName();
					}else if(chunkid != null && "court_name".equals(chunkid.trim())){
						content=court.getCourt_name();
					}else if(chunkid != null && "filingtime".equals(chunkid.trim())){
						content=court.getFiling_time();
					}else if(chunkid != null && "ecaseNo".equals(chunkid.trim())){
						content=court.getCase_number();
					}else if(chunkid != null && "execution_number".equals(chunkid.trim())){
						content=court.getExecution_number();
					}else if(chunkid != null && "execution_status".equals(chunkid.trim())){
						content=court.getExecution_status();
					}
					
				}
			}
			
		
		}
		return content;
	}
	
	/**
	 * 获得Image对象
	 * @param document
	 * @throws Exception
	 */
	public  Map<String, Image> getImage(HttpServletRequest request,Map ma) throws Exception {
		Map<String, Image> mapG = new HashMap<String, Image>();
		Map<String, Map<String, Object>> mapImage = ParsePdfXmlUtil.parseXmlImage(request.getSession().getServletContext().getRealPath("")+"/WEB-INF/resource/lendReport.xml");
		if(!mapImage.isEmpty()){
			for(Entry<String, Map<String, Object>> mapI : mapImage.entrySet()){
				Map map = mapI.getValue();
				String imagename = (String)map.get("imagename");
				System.out.println("img:"+imagename);
				First f1=(First)ma.get("first");
				int sore=Integer.parseInt(f1.getFinal_score());
				    if(sore<10){
				    	imagename="4.png";
					 }else if(sore>9 && sore<70){
						 imagename="1.png";
					 }else if(sore>69 && sore<90){
						 imagename="2.png";
					 }else if(sore>89){
						 imagename="3.png";
					 }
				float width = PdfUtil.stringChangeFloat(String.valueOf(map.get("width")));
				float height = PdfUtil.stringChangeFloat(String.valueOf(map.get("height")));
				float absoluteX = PdfUtil.stringChangeFloat(String.valueOf(map.get("absoluteX")));
				float absoluteY = PdfUtil.stringChangeFloat(String.valueOf(map.get("absoluteY")));
				
				Image image= Image.getInstance(request.getSession().getServletContext().getRealPath("")+"/WEB-INF/resource/"+imagename);
				image.scaleAbsolute(Float.valueOf(width),Float.valueOf(height));
				image.setAbsolutePosition(Float.valueOf(absoluteX), Float.valueOf(absoluteY));
				image.setAlignment(Image.UNDERLYING);
				mapG.put((String)map.get("imageid"), image);
			}
		}
		return mapG;
	}
	
}
