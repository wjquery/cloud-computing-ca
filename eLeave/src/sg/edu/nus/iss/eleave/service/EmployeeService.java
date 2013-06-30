package sg.edu.nus.iss.eleave.service;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.ServiceException;

public interface EmployeeService {
	public Employee findEmployee(String employeeId) throws ServiceException;
    public List<Employee> findAllEmployees() throws ServiceException;
    public List<Employee> findAllEmployees(int offset) throws ServiceException;
    public void insertEmployee(Employee employee) throws ServiceException;
    public void updateEmployee(Employee employee) throws ServiceException;
    public void deleteEmployee(Employee employee) throws ServiceException;
}
