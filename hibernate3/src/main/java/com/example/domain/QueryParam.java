package com.example.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryParam<T> {
	@JsonProperty("Query")
	@NotNull(message = "Query is null")
	@Valid
	private T query;
	@JsonProperty("PagingItem")
	@NotNull(message = "Paging item is null")
	@Valid
	private PagingItem pagingItem;
	public QueryParam() {
		super();
	}
	public QueryParam(@NotNull @Valid T query, @NotNull @Valid PagingItem pagingItem) {
		super();
		this.query = query;
		this.pagingItem = pagingItem;
	}
	public T getQuery() {
		return query;
	}
	public void setQuery(T query) {
		this.query = query;
	}
	public PagingItem getPagingItem() {
		return pagingItem;
	}
	public void setPagingItem(PagingItem pagingItem) {
		this.pagingItem = pagingItem;
	}
	
}
