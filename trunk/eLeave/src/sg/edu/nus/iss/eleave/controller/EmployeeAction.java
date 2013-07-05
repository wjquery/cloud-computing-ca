package sg.edu.nus.iss.eleave.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.service.EmployeeService;
import sg.edu.nus.iss.eleave.service.impl.EmployeeServiceImpl;
import sg.edu.nus.iss.eleave.util.DateUtil;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	
	private static Logger log = Logger.getLogger(EmployeeAction.class.getCanonicalName());
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private String companyId = (String) session.getAttribute("companyId");
	
	public String insert() throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setName(name);
		employee.setCompanyId(companyId);
		employee.setDesignation(designation);
		employee.setJoinDate(DateUtil.parse(joinDate, "dd/MM/yyyy"));
		employee.setDepartmentId(department);
		employee.setSupervisorId(supervisor);
		employee.setEmail(email);
		employee.setUserrole(userrole);
		employee.setUsername(username);
		employee.setPassword(password);
		
		employeeService.insertEmployee(employee);
		return SUCCESS;
	}
	
	public String findAll() throws Exception {
		List<Employee> employees = employeeService.findAllEmployeesByCompany(companyId);
		session.setAttribute("employees", employees);
		return SUCCESS;
	}
	
	public String findById() throws Exception {
		Employee employee = employeeService.findEmployee(employeeId);
		session.setAttribute("emp", employee);//TODO
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setName(name);
		employee.setCompanyId(companyId);
		employee.setDesignation(designation);
		employee.setJoinDate(DateUtil.parse(joinDate, "dd/MM/yyyy"));
		employee.setDepartmentId(department);
		employee.setSupervisorId(supervisor);
		employee.setEmail(email);
		employee.setUserrole(userrole);
		employee.setUsername(username);
		employee.setPassword(password);
		employeeService.updateEmployee(employee);
		return SUCCESS;
	}
	
	private EmployeeService employeeService = new EmployeeServiceImpl();
	private String employeeId;
	private String name;
	private String designation;
	private String joinDate;
	private String department;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
