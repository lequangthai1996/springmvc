package com.example.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "ResponseData")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object data;
	@JsonProperty("total_rows")
	private Object totalRows;
	private Object error;
	private String message;
	private Boolean otp = false;
	private String pager;
	@JsonProperty("pager_info")
	private String pageInfo;
	@JsonProperty("return_value")
	private Integer returnValue;
	private Boolean success = true;
	private String url;
	private String username;
	public ResponseData() {
		super();
	}
	public ResponseData(Object data, Object totalRows, Object error, String message, Boolean otp, String pager,
			String pageInfo, Integer returnValue, Boolean success, String url, String username) {
		super();
		this.data = data;
		this.totalRows = totalRows;
		this.error = error;
		this.message = message;
		this.otp = otp;
		this.pager = pager;
		this.pageInfo = pageInfo;
		this.returnValue = returnValue;
		this.success = success;
		this.url = url;
		this.username = username;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Object totalRows) {
		this.totalRows = totalRows;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getOtp() {
		return otp;
	}
	public void setOtp(Boolean otp) {
		this.otp = otp;
	}
	public String getPager() {
		return pager;
	}
	public void setPager(String pager) {
		this.pager = pager;
	}
	public String getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}
	public Integer getReturnValue() {
		return returnValue;
	}
	public void setReturnValue(Integer returnValue) {
		this.returnValue = returnValue;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
