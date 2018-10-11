package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Staff {
    private String id;
    private String code;
    private String username;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("mid_name")
    private String midName;
    private String email;
    private String phone;
    @JsonProperty("location_id")
    private String locationId;
    @JsonProperty("identity_no")
    private String identityNo;
    @JsonProperty("identity_issue_date")
    private String identityIssueDate;
    @JsonProperty("identity_issue_place")
    private String identityIssuePlace;
    private String status;
    @JsonProperty("team")
    private Department team;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("case_assign_today")
    private String caseAssignToday;
    @JsonProperty("total_pending")
    private String totalPending;
    @JsonIgnore
    private boolean isAdmin;
	public Staff() {
		super();
	}
	public Staff(String id, String code, String username, String firstName, String lastName, String midName,
			String email, String phone, String locationId, String identityNo, String identityIssueDate,
			String identityIssuePlace, String status, Department team, String fullName, String caseAssignToday,
			String totalPending, boolean isAdmin) {
		super();
		this.id = id;
		this.code = code;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
		this.email = email;
		this.phone = phone;
		this.locationId = locationId;
		this.identityNo = identityNo;
		this.identityIssueDate = identityIssueDate;
		this.identityIssuePlace = identityIssuePlace;
		this.status = status;
		this.team = team;
		this.fullName = fullName;
		this.caseAssignToday = caseAssignToday;
		this.totalPending = totalPending;
		this.isAdmin = isAdmin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMidName() {
		return midName;
	}
	public void setMidName(String midName) {
		this.midName = midName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public String getIdentityIssueDate() {
		return identityIssueDate;
	}
	public void setIdentityIssueDate(String identityIssueDate) {
		this.identityIssueDate = identityIssueDate;
	}
	public String getIdentityIssuePlace() {
		return identityIssuePlace;
	}
	public void setIdentityIssuePlace(String identityIssuePlace) {
		this.identityIssuePlace = identityIssuePlace;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Department getTeam() {
		return team;
	}
	public void setTeam(Department team) {
		this.team = team;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCaseAssignToday() {
		return caseAssignToday;
	}
	public void setCaseAssignToday(String caseAssignToday) {
		this.caseAssignToday = caseAssignToday;
	}
	public String getTotalPending() {
		return totalPending;
	}
	public void setTotalPending(String totalPending) {
		this.totalPending = totalPending;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
    
}
