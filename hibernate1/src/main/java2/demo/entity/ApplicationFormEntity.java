package demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "APPLICATION_FORM")
public class ApplicationFormEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "APP_FORM_STATUS")
	private String appFormStatus;
	@Column(name = "APPLICATION_CODE")
	private String applicationCode;
	
	public ApplicationFormEntity(Long id, String appFormStatus, String applicationCode) {
		super();
		this.id = id;
		this.appFormStatus = appFormStatus;
		this.applicationCode = applicationCode;
	}
	public ApplicationFormEntity() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAppFormStatus() {
		return appFormStatus;
	}
	public void setAppFormStatus(String appFormStatus) {
		this.appFormStatus = appFormStatus;
	}
	public String getApplicationCode() {
		return applicationCode;
	}
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}
}
