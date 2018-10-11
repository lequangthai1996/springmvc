package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department {
    private String id;

    private String name;

    @JsonProperty("contact_id")
    private String contactId;

    @JsonProperty("parent_id")
    private String parentId;

    private String code;

    private String description;

    private String type;

	private String phone;

    private String tax;

    private String email;

    private String status;
    
    public Department() {
		super();
	}

	public Department(String id, String name, String contactId, String parentId, String code, String description,
			String type, String phone, String tax, String email, String status) {
		super();
		this.id = id;
		this.name = name;
		this.contactId = contactId;
		this.parentId = parentId;
		this.code = code;
		this.description = description;
		this.type = type;
		this.phone = phone;
		this.tax = tax;
		this.email = email;
		this.status = status;
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

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
