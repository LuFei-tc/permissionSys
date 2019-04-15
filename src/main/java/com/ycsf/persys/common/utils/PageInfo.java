package com.ycsf.persys.common.utils;

public class PageInfo {
	private int currentPage;
	private int size;
	private int totalPage;
	private int totalResult;
	private int start;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
		this.start = (this.currentPage - 1)*this.size;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
		this.totalPage = this.totalResult % this.size == 0?this.totalResult/this.size:this.totalResult/this.size + 1; 
	}
	
	
}
