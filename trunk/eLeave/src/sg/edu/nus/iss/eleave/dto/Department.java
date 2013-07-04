package sg.edu.nus.iss.eleave.dto;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Department {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String departmentId;
	@Persistent
	private String name;
	@Persistent
	private String departmentHeadId; // foreign key to employee
	@Persistent
	private String companyId; // many-to-one relationship with company
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentHeadId() {
		return departmentHeadId;
	}
	public void setDepartmentHead(String departmentHeadId) {
		this.departmentHeadId = departmentHeadId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public Department(String departmentId, String name, String departmentHeadId,
			String companyId) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.departmentHeadId = departmentHeadId;
		this.companyId = companyId;
	}
	public Department() {
		super();
	}
}
