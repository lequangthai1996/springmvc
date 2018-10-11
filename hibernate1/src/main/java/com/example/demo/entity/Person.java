package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "person")
public class Person implements Serializable{
	/**
	 * 
	 */
	@JsonIgnore
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private String age;
	private String department_id;
	public Person() {
		super();
	}
	public Person(String id, String name, String age, String department_id) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.department_id = department_id;
	}
	
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
