package com.hoomsun.pdfcontract;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class ParsePdfXmlUtil {
	public static List<Map<String, Object>> parseXmlFile(String xmlPath){
		List<Map<String, Object>> tableList = new ArrayList<Map<String, Object>>();
		//创建SAXReader对象，SAXReader就是一个管道，用一个流的方式，解析XML文件
		SAXReader saxReader = new SAXReader();
		try {
			//获得xml文档对象
			Document document = saxReader.read(new File(xmlPath));
			//获得根节点
			Element rootElt = document.getRootElement();
			//获得根节点下的table节点
			Iterator<Element> eltTables = rootElt.elementIterator("pdftable");
			getElementTable(eltTables, tableList);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return tableList;
	} 
	/**
	 * 获得表格信息
	 * @param eltTables
	 * @param tableList
	 */
	public static void getElementTable(Iterator<Element> eltTables, List<Map<String, Object>> tableList){
		while(eltTables.hasNext()){
			Map<String, Object> tableMap = new HashMap<String, Object>();
			Element eltTable = eltTables.next();
			//获取pdftable下tableid的值
			tableMap.put("tableid", eltTable.elementTextTrim("tableid"));
			//获取pdftable下的type值
			tableMap.put("type", eltTable.elementTextTrim("type"));
			//获取pdftable下的columns值
			String columns = eltTable.elementTextTrim("columns");
			//获取pdftable下的percent值
			String percent = eltTable.elementTextTrim("percent");
			if(!tableMap.containsKey(percent)){
				tableMap.put("columns", columns);
			}
			if(!tableMap.containsKey(columns)){
				tableMap.put("percent", percent);
			}
			Iterator<Element> cells = eltTable.elementIterator("pdfcell");
			List<Map<String, Object>> cellList = new ArrayList<Map<String, Object>>();
			getElementCell(cells, cellList);
			tableMap.put("cellList", cellList);
			tableList.add(tableMap);
		}
	}
	/**
	 * 获得单元格信息
	 * @param cells
	 * @param eltCells
	 */
	public static void getElementCell(Iterator<Element> cells, List<Map<String, Object>> cellList){
		while(cells.hasNext()){
			Map<String, Object> cellMap = new HashMap<String, Object>();
			Element cell = cells.next();
			cellMap.put("border", cell.elementTextTrim("border"));
			cellMap.put("colspan", cell.elementTextTrim("colspan"));
			cellMap.put("rowspan", cell.elementTextTrim("rowspan"));
			List<Map<String, Object>> parList = new ArrayList<Map<String, Object>>();
			Iterator<Element> pars = cell.elementIterator("paragraph");
			getElementParagraph(pars, parList);
			cellMap.put("parList", parList);
			cellList.add(cellMap);
		}
	}
	/**
	 * 获得段落信息
	 * @param eltPars
	 * @param parList
	 */
	public static void getElementParagraph(Iterator<Element> pars, List<Map<String, Object>> parList){
		while(pars.hasNext()){
			Map<String, Object> parMap = new HashMap<String, Object>();
			Element par = pars.next();
			parMap.put("alignment", par.elementTextTrim("alignment"));
			List<Map<String, String>> chunkList = new ArrayList<Map<String, String>>();
			Iterator<Element> chunks = par.elementIterator("chunk");
			getElementChunk(chunks, chunkList);
			parMap.put("chunkList", chunkList);
			parList.add(parMap);
		}
	}
	/**获取块的信息
	 * 
	 * @param chunks
	 * @param chunkList
	 */
	public static void getElementChunk(Iterator<Element> chunks, List<Map<String, String>> chunkList){
		while(chunks.hasNext()){
			Map<String, String> mapChunk = new HashMap<String, String>();
			Element chunk = chunks.next();
			mapChunk.put("chunkid", chunk.elementTextTrim("chunkid"));
			mapChunk.put("content", chunk.elementTextTrim("content"));
			mapChunk.put("size", chunk.elementTextTrim("size"));
			mapChunk.put("style", chunk.elementTextTrim("style"));
			chunkList.add(mapChunk);
		}
	}
	
	/**
	 * 解析图片参数信息
	 * @param xmlPath
	 * @return
	 */
	public static Map<String, Map<String, Object>> parseXmlImage(String xmlPath){
		Map<String, Map<String, Object>> imagesMap= new HashMap<String, Map<String, Object>>();
		//创建SAXReader对象，SAXReader就是一个管道，用一个流的方式，解析XML文件
		SAXReader saxReader = new SAXReader();
		try {
			//获得xml文档对象
			Document document = saxReader.read(new File(xmlPath));
			//获得根节点
			Element rootElt = document.getRootElement();
			//获得根节点下的table节点
			Iterator<Element> eltImages = rootElt.elementIterator("image");
			getElementImages(eltImages, imagesMap);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return imagesMap;
	} 
	/**
	 * 获得图片的信息
	 * @param eltImages
	 * @param imageList
	 */
	public static void getElementImages(Iterator<Element> eltImages, Map<String, Map<String, Object>> imagesMap){
		while(eltImages.hasNext()){
			Map<String, Object> mapImage = new HashMap<String, Object>();
			Element image = eltImages.next();
			mapImage.put("imageid", image.elementTextTrim("imageid"));
			mapImage.put("imagename", image.elementTextTrim("imagename"));
			mapImage.put("width", PdfUtil.stringChangeFloat(image.elementTextTrim("width")));
			mapImage.put("height", PdfUtil.stringChangeFloat(image.elementTextTrim("height")));
			mapImage.put("style", image.elementTextTrim("style"));
			mapImage.put("absoluteX", PdfUtil.stringChangeFloat(image.elementText("absoluteX")));
			mapImage.put("absoluteY", PdfUtil.stringChangeFloat(image.elementText("absoluteY")));
			mapImage.put("isY", image.elementText("isY"));
			imagesMap.put(image.elementTextTrim("imageid"), mapImage);
		}
	}
}
