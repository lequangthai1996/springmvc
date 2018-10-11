package com.example.domain;

import java.util.List;

public class ResultSearch<T> {
	private List<T> data;
	private Long totalRows;
	public ResultSearch() {
		super();
	}
	public ResultSearch(List<T> data, Long totalRows) {
		super();
		this.data = data;
		this.totalRows = totalRows;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}
	
}
