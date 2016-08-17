package com.hoomsun.entity;

import java.io.Serializable;

/**
 * @author aoqian
 * 
 * @time 2016-8-8 下午1:38:53
 */
public class Hotheadlines implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id; // 主键
	private String headline; // 标题
	private String content; // 内容

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}

	/**
	 * @param headline
	 *            the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 *
	 */

	/**
	 * @param id
	 * @param headline
	 * @param content
	 */
	public Hotheadlines(String id, String headline, String content) {
		super();
		this.id = id;
		this.headline = headline;
		this.content = content;
	}

	public Hotheadlines() {
		super();
		// TODO Auto-generated constructor stub
	}

}
