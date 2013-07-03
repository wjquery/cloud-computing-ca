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
	
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	public String insert() throws Exception {
		
		return SUCCESS;
	}
	
	public String findAll() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Company company = (Company) session.getAttribute("company");
		List<Employee> employees = employeeService.findAllEmployeesByCompany(company);
		session.setAttribute("employees", employees);
		return SUCCESS;
	}
}
