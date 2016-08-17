package com.hoomsun.entity;

/**
 * 
 * 个人及企业查询记录
 * 
 * @author aoqian
 * 
 * @time 2016-7-27 上午10:58:50
 */
public class Record {

	private String id;
	private String keyword;
	private String type;
	private String time;
	private String rank;
	private String port;// 对应哪一张表
	private String userid;
	private String num;// 对应那张表中的具体哪一条的编号
	private String other;// 其他列

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

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
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword
	 *            the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the other
	 */
	public String getOther() {
		return other;
	}

	/**
	 * @param other
	 *            the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * @param id
	 * @param keyword
	 * @param type
	 * @param time
	 * @param rank
	 * @param port
	 * @param userid
	 * @param num
	 * @param other
	 */
	public Record(String id, String keyword, String type, String time,
			String rank, String port, String userid, String num, String other) {
		super();
		this.id = id;
		this.keyword = keyword;
		this.type = type;
		this.time = time;
		this.rank = rank;
		this.port = port;
		this.userid = userid;
		this.num = num;
		this.other = other;
	}

	/**
	 *
	 */
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

}
