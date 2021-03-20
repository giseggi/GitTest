package com.gsg.app.entity;

public class FileDto {
	
	private int no;
	private String title;
	private String writter;
	private String filename;
	private long filesize;
	private String filepath;
	private String reg_date;
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
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return writter
	 */
	public String getWritter() {
		return writter;
	}
	/**
	 * @param writter セットする writter
	 */
	public void setWritter(String writter) {
		this.writter = writter;
	}
	/**
	 * @return filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename セットする filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return filesize
	 */
	public long getFilesize() {
		return filesize;
	}
	/**
	 * @param filesize セットする filesize
	 */
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	/**
	 * @return filepath
	 */
	public String getFilepath() {
		return filepath;
	}
	/**
	 * @param filepath セットする filepath
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
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
	
	@Override
	public String toString() {
		return "FileDto [no=" + no + ", title=" + title + ", writter=" + writter + ", filename=" + filename
				+ ", filesize=" + filesize + ", filepath=" + filepath + ", reg_date=" + reg_date + "]";
	}
	
	

}
