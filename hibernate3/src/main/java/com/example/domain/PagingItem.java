package com.example.domain;

public class PagingItem {
	private String directionSort = "ASC";
	private int numberOfPage = 0;
	private String orderBy = "id";
    private Long ourRowsNumber = 0L;
	private int pageIndex = 0;
	private int pageSize = 1;
	public PagingItem() {
		super();
	}
	public PagingItem(Long ourRowsNumber, int pageIndex, int pageSize) {
		super();
		this.ourRowsNumber = ourRowsNumber;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	public String getDirectionSort() {
		return directionSort;
	}
	public void setDirectionSort(String directionSort) {
		this.directionSort = directionSort;
	}
	public int getNumberOfPage() {
		return numberOfPage;
	}
	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Long getOurRowsNumber() {
		return ourRowsNumber;
	}
	public void setOurRowsNumber(Long ourRowsNumber) {
		this.ourRowsNumber = ourRowsNumber;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PagingItem: "+ "directionSort: "+ directionSort + ", pageSize: "+ pageSize + 
				", pageIndex: " + pageIndex + ", numberOfPage: "+ numberOfPage + 
				", orderBy: " + orderBy + ", outRowsNumber: "+ ourRowsNumber;
		
	}
}
