package edu.vinaenter.model;

import java.sql.Timestamp;

public class News {
	private int lid;
	private String lname;
	private String description;
	private String detail;
	private Timestamp date_create;
	private Category category;
	private String picture;
	private int area;
	private String address;
	private int count_views;

	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCount_views() {
		return count_views;
	}
	public void setCount_views(int count_views) {
		this.count_views = count_views;
	}
	public News(int lid, String lname, String description, String detail, Timestamp date_create, Category category,
		String picture, int area, String address, int count_views) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.description = description;
		this.detail = detail;
		this.date_create = date_create;
		this.category = category;
		this.picture=picture;
		this.area = area;
		this.address = address;
		this.count_views = count_views;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
	}
	
	

