package com.example.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DSalePerformanceRequest {
	@JsonProperty("from_date")
	private String fromDate;
	@JsonProperty("to_date")
	private String toDate;
	@JsonProperty("ids")
	private List<String> ids;
	@JsonProperty("dsale_name")
	private String dsaleName;
	@JsonProperty("emp_code")
	private String empCode;
	@JsonProperty("team_name")
	private String teamName;
	public DSalePerformanceRequest() {
		super();
	}
	public DSalePerformanceRequest(String fromDate, String toDate, List<String> ids, String dsaleName, String empCode,
			String teamName) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.ids = ids;
		this.dsaleName = dsaleName;
		this.empCode = empCode;
		this.teamName = teamName;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public List<String> getIds() {
		return ids;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	public String getDsaleName() {
		return dsaleName;
	}
	public void setDsaleName(String dsaleName) {
		this.dsaleName = dsaleName;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Query: "  + "fromDate: " +fromDate + ", toDate: "+ toDate + ", ids: "+ ids + ", dsale_name: "+ dsaleName +
				", emp_code: "+ empCode + ", team_name: "+ teamName;
	}
	
}
