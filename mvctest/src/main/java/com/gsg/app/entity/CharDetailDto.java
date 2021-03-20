package com.gsg.app.entity;

public class CharDetailDto {

	private int no;
	private String c_id;
	private int gold;
	private int hunting_count;
	private String reg_date;
	private String mod_date;
	private int views;
	
	
	/**
	 * @return no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no セットする no
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return c_id
	 */
	public String getC_id() {
		return c_id;
	}
	/**
	 * @param c_id セットする c_id
	 */
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	/**
	 * @return gold
	 */
	public int getGold() {
		return gold;
	}
	/**
	 * @param gold セットする gold
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}
	/**
	 * @return hunting_count
	 */
	public int getHunting_count() {
		return hunting_count;
	}
	/**
	 * @param hunting_count セットする hunting_count
	 */
	public void setHunting_count(int hunting_count) {
		this.hunting_count = hunting_count;
	}
	/**
	 * @return reg_date
	 */
	public String getReg_date() {
		return reg_date;
	}
	/**
	 * @param reg_date セットする reg_date
	 */
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	/**
	 * @return mod_date
	 */
	public String getMod_date() {
		return mod_date;
	}
	/**
	 * @param mod_date セットする mod_date
	 */
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
	/**
	 * @return views
	 */
	public int getViews() {
		return views;
	}
	/**
	 * @param views セットする views
	 */
	public void setViews(int views) {
		this.views = views;
	}
	
	@Override
	public String toString() {
		return "CharDetailDto [no=" + no + ", c_id=" + c_id + ", gold=" + gold + ", hunting_count=" + hunting_count
				+ ", reg_date=" + reg_date + ", mod_date=" + mod_date + ", views=" + views + "]";
	}
	
	
	
	
}
