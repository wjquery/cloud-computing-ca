package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sg.edu.nus.iss.eleave.dao.EmployeeDAO;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	public static final String EMPLOYEE_KIND = "Employee";

	@Override
	public Employee findEmployee(String companyId, String employeeId)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployees() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(Company company)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(Company company, int offset)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployeesByDeparment(Department department)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployeesByDeparment(Department department,
			int offset) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployeeBySupervisor(Employee supervisor)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertEmployee(Employee employee) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(Employee employee) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(Employee employee) throws DAOException {
		// TODO Auto-generated method stub

	}
	
	private Entity getEmployee(String companyId,String employeeId){
		Key parent = KeyFactory.createKey(CompanyDAOImpl.COMPANY_ENTITY, companyId);
		Key key = KeyFactory.createKey(parent, EMPLOYEE_KIND, employeeId);
		try {
			return Util.getDatastoreServiceInstance().get(key);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private Employee buildEmployeeDTO(Entity entity){
		Employee p = new Employee();
		p.setActive((Boolean) entity.getProperty("isActive"));
		p.setDeparment((Department) entity.getProperty("department"));
		p.setDesignation((String) entity.getProperty("designation"));
		p.setEmail((String) entity.getProperty("email"));
		p.setEmployeeId((String) entity.getKey().getName());
		p.setName((String) entity.getProperty("name"));
		//TODO refine
		p.setPassword((String) entity.getProperty("password"));
		p.setSupervisors((List<Employee>) entity.getProperty("supervisors"));
		p.setUsername((String) entity.getProperty("username"));
		
		
		return p;
	}

}
