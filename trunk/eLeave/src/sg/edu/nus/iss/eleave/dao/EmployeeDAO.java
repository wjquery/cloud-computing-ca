package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface EmployeeDAO {
	
	public Employee findEmployee(String companyId, String employeeId) throws DAOException;
	
	
    public List<Employee> findAllEmployees() throws DAOException;
    
    public List<Employee> findAllEmployeesByCompany(Company company) throws DAOException;
    public List<Employee> findAllEmployeesByCompany(Company company, int offset) throws DAOException;
    
    public List<Employee> findAllEmployeesByDeparment(Department department) throws DAOException;
    public List<Employee> findAllEmployeesByDeparment(Department department, int offset) throws DAOException;
    
    public List<Employee> findAllEmployeeBySupervisor(Employee supervisor) throws DAOException;
    
    
    public void insertEmployee(Employee employee) throws DAOException;
    public void updateEmployee(Employee employee) throws DAOException;
    public void deleteEmployee(Employee employee) throws DAOException;
}
