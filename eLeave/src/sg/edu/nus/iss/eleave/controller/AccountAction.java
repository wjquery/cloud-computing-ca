package sg.edu.nus.iss.eleave.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import sg.edu.nus.iss.eleave.service.EmployeeService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class AccountAction extends ActionSupport {

	private String username;
	private String password;
	private EmployeeService employeeService;
	
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
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String login() throws Exception {
		if ("user".equals(username) && "password".equals(password))
			return SUCCESS;
		else
			return INPUT;
	}
	
	public String logout() throws Exception {
		return SUCCESS;
	}
	
}
