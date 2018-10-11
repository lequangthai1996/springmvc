package com.example.dto;

import com.example.model.Team;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {

	@JsonProperty(value = "person_id")
	private String id;
	@JsonProperty(value = "person_name")
	private String name;
	@JsonProperty(value = "address_city")
	private String city;
	@JsonProperty(value = "team")
	private Team team;
	public UserResponse() {
		super();
	}
	public UserResponse(String id, String name, String city, Team team) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.team = team;
	}
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
