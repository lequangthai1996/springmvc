package com.exampl.bean;

import javax.annotation.PostConstruct;


public class Class {
	private String id;
	private String name;
	public Class(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Class() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("new Class("+ this.getId() + "," + this.getName() + ")" + "-" + System.identityHashCode(this));
	}
	
}
