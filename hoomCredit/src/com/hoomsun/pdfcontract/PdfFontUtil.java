package com.hoomsun.pdfcontract;

import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

public class PdfFontUtil {
	/**
	 * 字体基本格式  实例
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static BaseFont getBaseFont_Instance() throws DocumentException, IOException{
		return BaseFont.createFont("resources/SIMFANG.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
	}
	/**
	 * 无参数字体格式
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static BaseFont getBaseFont() throws DocumentException, IOException{
		return BaseFont.createFont();
	}
	/**
	 * 可设置字体基本格式
	 * @param name
	 * @param encoding
	 * @param embedded
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static BaseFont getBaseFont(String name, String encoding, boolean embedded) throws DocumentException, IOException{
		return BaseFont.createFont(name, encoding, embedded);
	}
	/**
	 * 无参数字体
	 * @return
	 */
	public static Font getFont(){
		return new Font();
	}
	/**
	 * 字体样式设置
	 * @param baseFont
	 * @param size
	 * @param style
	 * @return
	 */
	public static Font getFont(BaseFont baseFont, int size, int style){
		return new Font(baseFont, size, style);
	}
	/**
	 * 获得标题样式（加粗）
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Font getFont_Instance_Title() throws DocumentException, IOException{
		return new Font(getBaseFont_Instance(), 18, Font.BOLD);
	}
	/**
	 * 获得样例正文样式
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Font getFont_Instance_Text() throws DocumentException, IOException{
		return new Font(getBaseFont_Instance(), 8, Font.NORMAL);
	}
	/**
	 * 获得同正文样式相同且有下划线的样式
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Font getFont_Instance_UnderLine() throws DocumentException, IOException{
		return new Font(getBaseFont_Instance(), 8, Font.UNDEFINED);
	} 
	/**
	 * 获得小标题，字体大小大于正文2个大小
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Font getFont_Instance_Title1() throws DocumentException, IOException{
		return new Font(getBaseFont_Instance(), 10, Font.BOLD);
	}
	/**
	 * 获得小标题，字体大小大于正文4个大小
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Font getFont_Instance_Title2() throws DocumentException, IOException{
		return new Font(getBaseFont_Instance(), 12, Font.BOLD);
	}
	/**
	 * 获得小标题，字体大小大于正文6个大小
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Font getFont_Instance_Title3() throws DocumentException, IOException{
		return new Font(getBaseFont_Instance(), 14, Font.BOLD);
	}
	/**
	 * 获得小标题，字体大小大于正文8个大小
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Font getFont_Instance_Title4() throws DocumentException, IOException{
		return new Font(getBaseFont_Instance(), 16, Font.BOLD);
	}
	
}
