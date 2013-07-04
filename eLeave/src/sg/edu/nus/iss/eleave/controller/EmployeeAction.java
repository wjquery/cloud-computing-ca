package sg.edu.nus.iss.eleave.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.service.EmployeeService;
import sg.edu.nus.iss.eleave.service.impl.EmployeeServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	
	public String insert() throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setName(name);
		employee.setDesignation(designation);
		employee.setJoinDate(null);
		employee.setEmail(email);
		employee.setUserrole(userrole);
		employee.setUsername(username);
		employee.setPassword(password);
		Company company = new Company();
		company.setCompanyId("nus");
		company.setName("nus");
		
		employeeService.insertEmployee(employee);
		return SUCCESS;
	}
	
	public String findAll() throws Exception {
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		Company company = null;
//		List<Employee> employees = employeeService.findAllEmployeesByCompany(company);
//		session.setAttribute("employees", employees);
		return SUCCESS;
	}
	
	private EmployeeService employeeService = new EmployeeServiceImpl();
	private String employeeId;
	private String name;
	private String designation;
	private String joinDate;
	private String supervisor;
	private String email;
	private String userrole;
	private String username;
	private String password;
	private String repassword;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
}