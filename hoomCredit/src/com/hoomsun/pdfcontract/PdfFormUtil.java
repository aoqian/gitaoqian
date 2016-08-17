package com.hoomsun.pdfcontract;

import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PdfFormUtil {
	/**
	 * 获得Pdf表格
	 * @param widths
	 * @param contentList
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public static PdfPTable getPdfPTable(float[] widths, List<List<String>> contentList) throws DocumentException, IOException{
		PdfPTable pdfPTable = new PdfPTable(widths);
		if(contentList != null && contentList.size() > 0){
			for(int i=0; i<contentList.size() ;i++){
				List<String> listLine = contentList.get(i);
				for(int j=0; j<listLine.size() ;j++){
					PdfPCell pCell = getPdfPCell(1, 1, 1);
					pCell.addElement(getParagraph_Center(listLine.get(j), PdfFontUtil.getFont_Instance_Text()));
					pdfPTable.addCell(pCell);
				}
			} 
		}
		return pdfPTable;
	}
	/**
	 * 获得单元格样式
	 * @param border 样式
	 * @param colspan 几个单元格合并
	 * @return
	 */
	public static PdfPCell getPdfPCell(int border, int colspan, int rowspan){
		PdfPCell pCell = new PdfPCell();
		if(border >= 0){
			pCell.setBorder(border);
		}
		pCell.setColspan(colspan);
		pCell.setRowspan(rowspan);
		return pCell;
	}
	/**
	 * 段落向左对齐（默认向左对齐）
	 * @param content
	 * @param font
	 * @return
	 */
	public static Paragraph getParagraph_Left(String content, Font font){
		return new Paragraph(content, font);
	}
	/**
	 * 段落中间对齐
	 * @param content
	 * @param font
	 * @return
	 */
	public static Paragraph getParagraph_Center(String content, Font font){
		Paragraph par = new Paragraph(content, font);
		par.setAlignment(CommonParameters.par_center);
		return par;
	}
	/**
	 * 段落向右对齐
	 * @param content
	 * @param font
	 * @return
	 */
	public static Paragraph getParagraph_Right(String content, Font font){
		Paragraph par = new Paragraph(content, font);
		par.setAlignment(CommonParameters.par_right);
		return par;
	}
	/**
	 * PDF块
	 * @return
	 */
	public static Chunk getChunk(String content, Font font){
		return new Chunk(content, font);
	}
}
