package sg.edu.nus.iss.eleave.dto;

public class Department {

	private String departmentId;
	private String name;
	private Employee departmentHead;
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
