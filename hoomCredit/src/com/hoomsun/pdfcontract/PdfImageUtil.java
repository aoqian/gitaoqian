package com.hoomsun.pdfcontract;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

public class PdfImageUtil {
	/**
	 * 获得图片的实例
	 * @param filePath
	 * @return
	 * @throws BadElementException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Image getImage_Instance(String filePath) throws BadElementException, MalformedURLException, IOException{
		return Image.getInstance(filePath);
	}
	/**
	 * 获得水印图片（文字下方）
	 * @param filePath
	 * @param absoluteX -- 绝对宽度
	 * @param absoluteY -- 绝对高度
	 * @return
	 * @throws BadElementException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Image getImageUnderLying(String filePath, int absoluteX, int absoluteY) throws BadElementException, MalformedURLException, IOException{
		Image image = getImage_Instance(filePath);
		image.setAlignment(Image.UNDERLYING);
//		image.scaleAbsolute(newWidth, newHeight);
		image.setAbsolutePosition(absoluteX, absoluteY);
		return image;
	}
}
