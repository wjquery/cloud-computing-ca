package sg.edu.nus.iss.eleave.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import sg.edu.nus.iss.eleave.service.EmployeeService;
import sg.edu.nus.iss.eleave.service.impl.EmployeeServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class AccountAction extends ActionSupport {

	private String companyId;
	private String username;
	private String password;
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String login() throws Exception {
		if (employeeService.validateUser(companyId, username, password)) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("companyId", companyId);
			session.setAttribute("employeeName", "Jon Doe");
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String logout() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return SUCCESS;
	}
	
}
