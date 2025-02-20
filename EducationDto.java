package com.dto;

public class EducationDto {
	private String title;
	private String subtitle;
	private String year;
	private String description;
	public EducationDto(String title, String subtitle, String year, String description) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.year = year;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
