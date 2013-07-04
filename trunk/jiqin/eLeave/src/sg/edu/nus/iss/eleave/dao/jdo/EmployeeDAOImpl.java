package sg.edu.nus.iss.eleave.dao.jdo;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sg.edu.nus.iss.eleave.dao.EmployeeDAO;
import sg.edu.nus.iss.eleave.dto.Claim;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee findEmployee(String companyId, String employeeId)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	      return pm.getObjectById(Employee.class, employeeId);
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public List<Employee> findAllEmployees() throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Employee.class);
		
		try{
			List<Employee> results = (List<Employee>) q.execute();
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(Company company)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Employee.class);
		q.setFilter("company == companyParam");
		q.declareParameters("String companyParam");
		try{
			List<Employee> results = (List<Employee>) q.execute(company.getCompanyId());
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(Company company, int offset)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Employee.class);
		q.setFilter("company == companyParam");
		q.declareParameters("String companyParam");
		q.setRange(offset, offset + ConfigSetting.LIST_PER_PAGE);
		try{
			List<Employee> results = (List<Employee>) q.execute(company.getCompanyId());
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<Employee> findAllEmployeesByDeparment(Department department)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Employee.class);
		q.setFilter("department == departmentParam");
		q.declareParameters("String departmentParam");
		try{
			List<Employee> results = (List<Employee>) q.execute(department.getDepartmentId());
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<Employee> findAllEmployeesByDeparment(Department department,
			int offset) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Employee.class);
		q.setFilter("department == departmentParam");
		q.declareParameters("String departmentParam");
		q.setRange(offset, offset + ConfigSetting.LIST_PER_PAGE);
		try{
			List<Employee> results = (List<Employee>) q.execute(department.getDepartmentId());
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<Employee> findAllEmployeeBySupervisor(Employee supervisor)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Employee.class);
		q.setFilter("supervisors == supervisorParam");
		q.declareParameters("String supervisorParam");
		try{
			List<Employee> results = (List<Employee>) q.execute(supervisor.getEmployeeId());
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public boolean addSupervisor(Employee employee, Employee supervisor)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	    	employee.getSupervisors().add(supervisor);
	       pm.makePersistent(employee);
	       return true;
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public boolean removeSupervisor(Employee employee, Employee supervisor)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	    	employee.getSupervisors().remove(supervisor);
	       pm.makePersistent(employee);
	       return true;
	    } finally {
	      pm.close();
	    }
	    
	}

	@Override
	public void insertEmployee(Employee employee) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(employee);
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public void updateEmployee(Employee employee) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(employee);
	    } finally {
	      pm.close();
	    }

	}

	@Override
	public void deleteEmployee(Employee employee) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.deletePersistent(employee);
	    } finally {
	      pm.close();
	    }

	}

}
