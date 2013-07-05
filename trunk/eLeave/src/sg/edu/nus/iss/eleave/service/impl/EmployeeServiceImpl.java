package sg.edu.nus.iss.eleave.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.edu.nus.iss.eleave.dao.EmployeeDAO;
import sg.edu.nus.iss.eleave.dao.gaeds.EmployeeDAOImpl;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;
import sg.edu.nus.iss.eleave.exception.ServiceException;
import sg.edu.nus.iss.eleave.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class.getCanonicalName());
	
	private EmployeeDAO employeeDao = new EmployeeDAOImpl();

	@Override
	public boolean validateUser(String companyId, String username, String password)
	{
		// TODO
		return true;
	}
	
	@Override
	public Employee findEmployee(String employeeId) throws ServiceException {
		return employeeDao.findEmployeeById(employeeId);
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(String companyId) throws ServiceException {
		List<Employee> all = employeeDao.findAllEmployeesByCompany(companyId);
		List<Employee> filtered = new ArrayList<Employee>();
		for (Employee e : all) {
			if (e.getUserrole() != null && !e.getUserrole().equals(Employee.ADMIN))
				filtered.add(e);
		}
		return filtered;
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(String companyId, int offset, int fetchSize) {
		return employeeDao.findAllEmployeesByCompany(companyId, offset, fetchSize);
	}

	@Override
	public boolean insertEmployee(Employee employee) throws ServiceException {
		// TODO: when inserting new employee, LeaveEntitlement(default) of the employee will be inserted at the same time
		boolean isSuccessful = true;
		try {
			employeeDao.insertEmployee(employee);
		} catch (DAOException e) {
			isSuccessful = false;
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
		return isSuccessful;
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
	public List<Employee> findAllEmployeesByDepartment(String departmentId) throws ServiceException {
		try {
			return employeeDao.findAllEmployeesByDeparment(departmentId);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
	}

	@Override
	public List<Employee> findAllEmployeesByDepartment(String departmentId, int offset, int fetchSize) throws ServiceException {
		return employeeDao.findAllEmployeesByDeparment(departmentId, offset, fetchSize);
	}
	
	@Override
	public List<Employee> findAllEmployeesBySupervisor(String supervisorId) {
		return employeeDao.findAllEmployeesBySupervisor(supervisorId);
	}

	@Override
	public List<Employee> findAllEmployeesBySupervisor(String supervisorId, int offset, int fetchSize) throws ServiceException {
		return employeeDao.findAllEmployeesBySupervisor(supervisorId, offset, fetchSize);
	}
	
	public EmployeeDAO getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

}
