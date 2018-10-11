package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "address")
public class Address implements Serializable{
	/**
	 * 
	 */
	@JsonIgnore
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String city;
	@Column(name = "person_id")
	private String person_id;
	public Address() {
		super();
	}
	public Address(String id, String city, String person_id) {
		super();
		this.id = id;
		this.city = city;
		this.person_id = person_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	
}
