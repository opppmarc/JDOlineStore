package com.aaa.vo;

public class Category {
	private Integer cid;
	private Integer parent_id;
	private String name;
	public Category() {
	}
	
	public Category(Integer cid, Integer parent_id, String name) {
		super();
		this.cid = cid;
		this.parent_id = parent_id;
		this.name = name;
	}

	public Category(Integer parent_id, String name) {
		super();
		this.parent_id = parent_id;
		this.name = name;
	}

	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
