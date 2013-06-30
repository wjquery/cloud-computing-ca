package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface EmployeeDAO {
	public Employee findEmployee(String employeeId) throws DAOException;
    public List<Employee> findAllEmployees() throws DAOException;
    public List<Employee> findAllEmployees(int offset) throws DAOException;
    public void insertEmployee(Employee employee) throws DAOException;
    public void updateEmployee(Employee employee) throws DAOException;
    public void deleteEmployee(Employee employee) throws DAOException;
}
