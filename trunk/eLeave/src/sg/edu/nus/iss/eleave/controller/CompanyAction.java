package sg.edu.nus.iss.eleave.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.service.CompanyService;
import sg.edu.nus.iss.eleave.service.EmployeeService;
import sg.edu.nus.iss.eleave.service.impl.CompanyServiceImpl;
import sg.edu.nus.iss.eleave.service.impl.EmployeeServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class CompanyAction extends ActionSupport {

	private String companyName;
	private String companyCode;
	public String subscriptionType;
	private String username;
	private String password;
	private String repassword;
	private CompanyService companyService = new CompanyServiceImpl();
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
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
	
	public String insert() throws Exception {
		Company company = new Company();
		company.setName(companyName);
		company.setCompanyId(companyCode);
		company.setSubcriptionType(subscriptionType);
		
		Employee employee = new Employee();
		employee.setCompanyId(companyCode);
		employee.setUserrole(Employee.ADMIN);
		employee.setUsername(username);
		employee.setPassword(password);
		
		if (companyService.insertCompany(company)) {
			if (employeeService.insertEmployee(employee)) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("companyId", companyCode);
				session.setAttribute("myName", username);
				return SUCCESS;
			}
		}
		return INPUT;
	}
}
