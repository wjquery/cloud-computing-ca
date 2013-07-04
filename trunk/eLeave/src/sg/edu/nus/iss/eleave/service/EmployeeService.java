package sg.edu.nus.iss.eleave.service;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.ServiceException;

public interface EmployeeService {
	public boolean validateUser(String companyId, String username, String password);
	public Employee findEmployee(String employeeId) throws ServiceException;
    public List<Employee> findAllEmployeesByCompany(String companyId) throws ServiceException;
    public List<Employee> findAllEmployeesByCompany(String companyId,int offset, int fetchSize) throws ServiceException;
    
    public List<Employee> findAllEmployeesByDepartment(String departmentId) throws ServiceException;
    public List<Employee> findAllEmployeesByDepartment(String departmentId, int offset, int fetchSize) throws ServiceException;
    
    public List<Employee> findAllEmployeesBySupervisor(String supervisorId) throws ServiceException;
    public List<Employee> findAllEmployeesBySupervisor(String supervisorId, int offset, int fetchSize) throws ServiceException;
    
    public boolean insertEmployee(Employee employee) throws ServiceException;
    public void updateEmployee(Employee employee) throws ServiceException;
    public void deleteEmployee(Employee employee) throws ServiceException;
}
