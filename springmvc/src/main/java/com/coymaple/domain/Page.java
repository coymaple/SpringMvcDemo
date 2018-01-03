package com.coymaple.domain;

import java.util.List;

import com.coymaple.Contants;

public class Page<T> {
	
	//当前页
	private int currentPage;
	//每页的行数
	private int rowNumber = Contants.ROW_NUMBER;
	//总行数
	private int totalRows;
	//总页数
	private int totalPage;
	
	private List<T> pageList;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage,int rowNumber) {
		int result = totalPage % rowNumber;
		if(result == 0) {
			this.totalPage = totalPage/rowNumber;
		}else {
			this.totalPage = totalPage/rowNumber + 1;
		}
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
	
	
}
