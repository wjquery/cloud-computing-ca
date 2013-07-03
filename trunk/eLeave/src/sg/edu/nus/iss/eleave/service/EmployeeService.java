package sg.edu.nus.iss.eleave.service;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.ServiceException;

public interface EmployeeService {
	public boolean validateUser(String companyId, String username, String password);
	public Employee findEmployee(String companyId, String employeeId) throws ServiceException;
    public List<Employee> findAllEmployeesByCompany(Company company) throws ServiceException;
    public List<Employee> findAllEmployeesByCompany(Company company,int offset) throws ServiceException;
    
    public List<Employee> findAllEmployeesByDepartment(Department department) throws ServiceException;
    public List<Employee> findAllEmployeesByDepartment(Department department, int offset) throws ServiceException;
    
    public List<Employee> findAllEmployeesBySupervisor(Employee supervisor) throws ServiceException;
    public boolean insertEmployee(Employee employee) throws ServiceException;
    public void updateEmployee(Employee employee) throws ServiceException;
    public void deleteEmployee(Employee employee) throws ServiceException;
}
