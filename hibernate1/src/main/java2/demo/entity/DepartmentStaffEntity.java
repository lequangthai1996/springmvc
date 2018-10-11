package demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DEPARTMENT_STAFF")
public class DepartmentStaffEntity extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID")  
    private Long id;

    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "STAFF_ID")
    private Long staffId;

    @Column(name = "RESPONSIBLE_TYPE")
    private String responsibleType;

    @Column(name = "JOINED_DATE")
    private Date joinedDate;

	public DepartmentStaffEntity() {
		super();
	}

	public DepartmentStaffEntity(Long id, Long departmentId, Long staffId, String responsibleType, Date joinedDate) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.staffId = staffId;
		this.responsibleType = responsibleType;
		this.joinedDate = joinedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getResponsibleType() {
		return responsibleType;
	}

	public void setResponsibleType(String responsibleType) {
		this.responsibleType = responsibleType;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
    
}
