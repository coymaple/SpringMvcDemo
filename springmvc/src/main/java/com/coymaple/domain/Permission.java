package com.coymaple.domain;

public class Permission {
	private int id;
	private String url;
	private String name;
	private int parentId;
	private String remark;
	
	public Permission() {}
	public Permission(int id, String url, String name, int parentId, String remark) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.parentId = parentId;
		this.remark = remark;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
