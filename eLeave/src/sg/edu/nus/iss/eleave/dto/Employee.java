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
	private String companyId;
	@Persistent
	private String deparmentId;
	@Persistent
	private String designation;
	@Persistent
	private String supervisorId;
	@Persistent
	private Date joinDate;
	@Persistent
	private Date resignDate;
	@Persistent
	private String email;
	@Persistent
	private String userrole;
	@Persistent
	private String username;
	@Persistent
	private String password;
	@Persistent
	private boolean isCurrent;
	
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
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getDeparmentId() {
		return deparmentId;
	}
	public void setDeparmentId(String deparmentId) {
		this.deparmentId = deparmentId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
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
	public boolean isCurrent() {
		return isCurrent;
	}
	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	
	public Employee(String employeeId, String name, String companyId,
			String deparmentId, String designation, String supervisorId,
			Date joinDate, Date resignDate, String email, String userrole,
			String username, String password, boolean isCurrent) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.companyId = companyId;
		this.deparmentId = deparmentId;
		this.designation = designation;
		this.supervisorId = supervisorId;
		this.joinDate = joinDate;
		this.resignDate = resignDate;
		this.email = email;
		this.userrole = userrole;
		this.username = username;
		this.password = password;
		this.isCurrent = isCurrent;
	}
	public Employee() {
		super();
	}
}
