package com.Modle;

public class projectFile {
	private int id;
	private String fileName;
	private String dateTime;
	public projectFile(int id, String fileName, String dateTime) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.dateTime = dateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	

}
