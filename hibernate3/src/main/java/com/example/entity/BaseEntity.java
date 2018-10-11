package com.example.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

	/**
	 * 
	 */
	@JsonIgnore
	protected static final long serialVersionUID = 1L;
	@Column(name = "CREATED_BY")
	protected Long createdBy;
	@Column(name = "CREATED_DATE")
	protected Date createdDated;
	@Column(name = "IS_DELETED")
	protected Boolean isDeleted;
	public BaseEntity() {
		super();
	}
	public BaseEntity(Long createdBy, Date createdDated, Boolean isDeleted) {
		super();
		this.createdBy = createdBy;
		this.createdDated = createdDated;
		this.isDeleted = isDeleted;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDated() {
		return createdDated;
	}
	public void setCreatedDated(Date createdDated) {
		this.createdDated = createdDated;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   @PrePersist
   protected void onCreate() {
     createdDated = new Date();
     this.isDeleted = false;
   }

   @PreUpdate
   protected void onUpdate() {
	   createdDated = new Date();
   }

}
