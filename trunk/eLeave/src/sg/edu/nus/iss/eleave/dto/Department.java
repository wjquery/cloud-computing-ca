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
	private Employee departmentHead;
	
	@Persistent
	private Company company;
	
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
	public Employee getDepartmentHead() {
		return departmentHead;
	}
	public void setDepartmentHead(Employee departmentHead) {
		this.departmentHead = departmentHead;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Department() {
		super();
	}
	public Department(String departmentId, String name,
			Employee departmentHead, Company company) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.departmentHead = departmentHead;
		this.company = company;
	}
	
}
