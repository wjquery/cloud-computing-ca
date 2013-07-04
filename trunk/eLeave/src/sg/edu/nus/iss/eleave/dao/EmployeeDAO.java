package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface EmployeeDAO {
	
	public Employee findEmployeeById(String employeeId);
	
    public List<Employee> findAllEmployees();
    public List<Employee> findAllEmployeesByCompany(String companyId);
    public List<Employee> findAllEmployeesByCompany(String companyId, int offset, int fetchSize);
    
    public List<Employee> findAllEmployeesByDeparment(String departmentId) throws DAOException;
    public List<Employee> findAllEmployeesByDeparment(String departmentId, int offset, int fetchSize);
    
    public List<Employee> findAllEmployeesBySupervisor(String supervisorId);
    public List<Employee> findAllEmployeesBySupervisor(String supervisorId, int offset, int fetchSize);
    
    public void insertEmployee(Employee employee) throws DAOException;
    public void updateEmployee(Employee employee) throws DAOException;
    public void deleteEmployee(Employee employee) throws DAOException;
}
