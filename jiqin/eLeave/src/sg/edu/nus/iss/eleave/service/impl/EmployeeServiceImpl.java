package sg.edu.nus.iss.eleave.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.edu.nus.iss.eleave.dao.EmployeeDAO;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;
import sg.edu.nus.iss.eleave.exception.ServiceException;
import sg.edu.nus.iss.eleave.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static Logger log = Logger.getLogger(EmployeeService.class.getCanonicalName());
	
	private EmployeeDAO employeeDao;

	@Override
	public boolean validateUser(String companyId, String username, String password)
	{
		// TODO
		return true;
	}
	
	@Override
	public Employee findEmployee(String companyId, String employeeId) throws ServiceException {
		
		try {
			return employeeDao.findEmployee(companyId, employeeId);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(Company company) throws ServiceException {
		
		try {
			return employeeDao.findAllEmployeesByCompany(company);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(Company company, int offset) throws ServiceException {
		try {
			return employeeDao.findAllEmployeesByCompany(company, offset);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
	}

	@Override
	public boolean insertEmployee(Employee employee) throws ServiceException {
		try {
			employeeDao.insertEmployee(employee);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
		return true;
	}

	@Override
	public void updateEmployee(Employee employee) throws ServiceException {
		try {
			employeeDao.updateEmployee(employee);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}

	}

	@Override
	public void deleteEmployee(Employee employee) throws ServiceException {
		try {
			employeeDao.deleteEmployee(employee);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}

	}
	
	

	@Override
	public List<Employee> findAllEmployeesByDepartment(Department department)
			throws ServiceException {
		try {
			return employeeDao.findAllEmployeesByDeparment(department);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
	}

	@Override
	public List<Employee> findAllEmployeesByDepartment(Department department,
			int offset) throws ServiceException {
		try {
			return employeeDao.findAllEmployeesByDeparment(department, offset);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
	}
	
	

	@Override
	public List<Employee> findAllEmployeesBySupervisor(Employee supervisor)
			throws ServiceException {
		try {
			return employeeDao.findAllEmployeeBySupervisor(supervisor);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
	}

	public EmployeeDAO getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDAO employeeDao) throws ServiceException{
		this.employeeDao = employeeDao;
	}

}
