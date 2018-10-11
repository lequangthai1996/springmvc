package com.example.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.domain.SaleTeam;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement( name = "DSalePerformanceRepsonse")
public class DSalePerformanceRepsonse {
	@JsonProperty("id")
	private String id;
	@JsonProperty("dsale_name")
	private String dsaleName;
	@JsonProperty("emp_code")
	private String empCode;
	@JsonProperty("team'")
	private SaleTeam team;
	@JsonProperty("applicatioin_form")
	private String applicationForm;
	@JsonProperty("total_app_approved")
	private String totalAppApproved;
	@JsonProperty("amount_disbursed")
	private String amountDisbursed;
	public DSalePerformanceRepsonse() {
		super();
	}
	public DSalePerformanceRepsonse(String id, String dsaleName, String empCode, SaleTeam team, String applicationForm,
			String totalAppApproved, String amountDisbursed) {
		super();
		this.id = id;
		this.dsaleName = dsaleName;
		this.empCode = empCode;
		this.team = team;
		this.applicationForm = applicationForm;
		this.totalAppApproved = totalAppApproved;
		this.amountDisbursed = amountDisbursed;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public SaleTeam getTeam() {
		return team;
	}
	public void setTeam(SaleTeam team) {
		this.team = team;
	}
	public String getApplicationForm() {
		return applicationForm;
	}
	public void setApplicationForm(String applicationForm) {
		this.applicationForm = applicationForm;
	}
	public String getTotalAppApproved() {
		return totalAppApproved;
	}
	public void setTotalAppApproved(String totalAppApproved) {
		this.totalAppApproved = totalAppApproved;
	}
	public String getAmountDisbursed() {
		return amountDisbursed;
	}
	public void setAmountDisbursed(String amountDisbursed) {
		this.amountDisbursed = amountDisbursed;
	}
	
}
