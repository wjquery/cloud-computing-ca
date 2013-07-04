package sg.edu.nus.iss.eleave.dto;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Employee {
	
	public static final String ADMIN = "admin";
	public static final String SUPERVISOR = "supervisor";
	public static final String STAFF = "staff";
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String employeeId;
	
	@Persistent
	private String name;
	
	@Persistent
	private Department deparment;
	
	@Persistent
	private List<Employee> supervisors;
	
	@Persistent
	private Date joinDate;
	
	@Persistent
	private Date resignDate;
	
	@Persistent
	private String Designation;
	
	@Persistent
	private String email;
	
	@Persistent
	private String username;
	
	@Persistent
	private String password;
	
	@Persistent
	private String userrole;
	
	@Persistent
	private boolean isCurrent;
	
	@Persistent
	private List<LeaveApplication> leave;
	private Company company;
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDeparment() {
		return deparment;
	}
	public void setDeparment(Department deparment) {
		this.deparment = deparment;
	}
	public List<Employee> getSupervisors() {
		return supervisors;
	}
	public void setSupervisors(List<Employee> supervisors) {
		this.supervisors = supervisors;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getResignDate() {
		return resignDate;
	}
	public void setResignDate(Date resignDate) {
		this.resignDate = resignDate;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public boolean isCurrent() {
		return isCurrent;
	}
	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	public List<LeaveApplication> getLeave() {
		return leave;
	}
	public void setLeave(List<LeaveApplication> leave) {
		this.leave = leave;
	}
	
	
	
}
