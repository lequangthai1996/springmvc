package com.example.domain;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "SaleTeam")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleTeam {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	public SaleTeam() {
		super();
	}
	public SaleTeam(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
