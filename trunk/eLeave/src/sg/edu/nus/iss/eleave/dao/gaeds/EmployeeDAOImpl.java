package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sg.edu.nus.iss.eleave.dao.EmployeeDAO;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.DAOException;



public class EmployeeDAOImpl implements EmployeeDAO {
	
	public static final String EMPLOYEE_KIND = "Employee";

	@Override
	public Employee findEmployee(String companyId, String employeeId)
			throws DAOException {
		Entity entity = this.getEmployee(companyId, employeeId);
		if(entity != null) {
			return this.buildEmployeeDTO(entity);
		}
		return null;
	}

	@Override
	public List<Employee> findAllEmployees() throws DAOException {
		Iterable<Entity> entities = Util.listEntities(EMPLOYEE_KIND, null, null);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(this.buildEmployeeDTO(entity));
		}
		return employees;
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(Company company)
			throws DAOException {
		Iterable<Entity> entities = Util.listEntities(EMPLOYEE_KIND, "company", company);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(this.buildEmployeeDTO(entity));
		}
		return employees;
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(Company company, int offset)
			throws DAOException {
		Iterable<Entity> entities = Util.listEntities(EMPLOYEE_KIND, "company", company, offset);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(this.buildEmployeeDTO(entity));
		}
		return employees;
	}

	@Override
	public List<Employee> findAllEmployeesByDeparment(Department department)
			throws DAOException {
		Iterable<Entity> entities = Util.listEntities(EMPLOYEE_KIND, "department", department);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(this.buildEmployeeDTO(entity));
		}
		return employees;
	}

	@Override
	public List<Employee> findAllEmployeesByDeparment(Department department,
			int offset) throws DAOException {
		Iterable<Entity> entities = Util.listEntities(EMPLOYEE_KIND, "department", department, offset);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(this.buildEmployeeDTO(entity));
		}
		return employees;
	}

	@Override
	public List<Employee> findAllEmployeeBySupervisor(Employee supervisor)
			throws DAOException {
		Iterable<Entity> entities = Util.listEntities(EMPLOYEE_KIND, "supervisors", supervisor);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(this.buildEmployeeDTO(entity));
		}
		return employees;
	}

	@Override
	public void insertEmployee(Employee employee) throws DAOException {
		Key parent = KeyFactory.createKey(CompanyDAOImpl.COMPANY_KIND, employee.getCompany().getCompanyId());
		Entity p = new Entity(EMPLOYEE_KIND,employee.getEmployeeId(), parent);
		if(employee.getDeparment()!=null){
			//p.setProperty("department", employee.getDeparment());
			Key department = new KeyFactory.Builder(CompanyDAOImpl.COMPANY_KIND, employee.getCompany().getCompanyId())
					.addChild(DepartmentDAOImpl.DEPARTMENT_KIND, employee.getDeparment().getDepartmentId())
					.getKey();
			p.setProperty("department", department);
		}
		
		//p.setProperty("company", employee.getCompany());
		p.setProperty("company", parent);
		p.setProperty("designation", employee.getDesignation());
		p.setProperty("email", employee.getEmail());
		p.setProperty("employeeId", employee.getEmployeeId());
		p.setProperty("joinDate", employee.getJoinDate());
		p.setProperty("name", employee.getName());
		p.setProperty("password", employee.getPassword());
		p.setProperty("username", employee.getUsername());
		p.setProperty("userrole", employee.getUserrole());
		Util.persistEntity(p);

	}

	@Override
	public void updateEmployee(Employee employee) throws DAOException {
		Key parent = KeyFactory.createKey(CompanyDAOImpl.COMPANY_KIND, employee.getCompany().getCompanyId());
		Entity p = new Entity(EMPLOYEE_KIND,employee.getEmployeeId(), parent);
		if(employee.getDeparment()!=null){
			//p.setProperty("department", employee.getDeparment());
			Key department = new KeyFactory.Builder(CompanyDAOImpl.COMPANY_KIND, employee.getCompany().getCompanyId())
					.addChild(DepartmentDAOImpl.DEPARTMENT_KIND, employee.getDeparment().getDepartmentId())
					.getKey();
			p.setProperty("department", department);
		}
		//p.setProperty("company", employee.getCompany());
		p.setProperty("designation", employee.getDesignation());
		p.setProperty("email", employee.getEmail());
		p.setProperty("employeeId", employee.getEmployeeId());
		p.setProperty("joinDate", employee.getJoinDate());
		p.setProperty("name", employee.getName());
		p.setProperty("password", employee.getPassword());
		p.setProperty("username", employee.getUsername());
		p.setProperty("userrole", employee.getUserrole());
		Util.persistEntity(p);

	}

	@Override
	public void deleteEmployee(Employee employee) throws DAOException {
		Entity entity = this.getEmployee(employee.getCompany().getCompanyId(), employee.getEmployeeId());
		if(entity != null) {
			Util.deleteEntity(entity.getKey());
		}

	}
	
	@Override
	public boolean addSupervisor(Employee employee, Employee supervisor)
			throws DAOException {
		Entity entity = this.getEmployee(employee.getCompany().getCompanyId(), employee.getEmployeeId());
		if(entity != null) {
			List<Key> supervisors = (List<Key>) entity.getProperty("supervisors");
			Key sKey = new KeyFactory.Builder(CompanyDAOImpl.COMPANY_KIND, supervisor.getCompany().getCompanyId())
				.addChild(EMPLOYEE_KIND, supervisor.getEmployeeId()).getKey();
			supervisors.add(sKey);
			entity.setProperty("supervisors", supervisors);
			Util.persistEntity(entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeSupervisor(Employee employee, Employee supervisor)
			throws DAOException {
		Entity entity = this.getEmployee(employee.getCompany().getCompanyId(), employee.getEmployeeId());
		if(entity != null) {
			List<Key> supervisors = (List<Key>) entity.getProperty("supervisors");
			Key sKey = new KeyFactory.Builder(CompanyDAOImpl.COMPANY_KIND, supervisor.getCompany().getCompanyId())
				.addChild(EMPLOYEE_KIND, supervisor.getEmployeeId()).getKey();
			supervisors.remove(sKey);
			entity.setProperty("supervisors", supervisors);
			Util.persistEntity(entity);
			return true;
		}
		return false;
	}

	private Entity getEmployee(String companyId,String employeeId){
		Key parent = KeyFactory.createKey(CompanyDAOImpl.COMPANY_KIND, companyId);
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
		p.setCurrent((Boolean) entity.getProperty("isActive"));
		p.setDeparment((Department) entity.getProperty("department"));
		p.setDesignation((String) entity.getProperty("designation"));
		p.setEmail((String) entity.getProperty("email"));
		p.setEmployeeId((String) entity.getKey().getName());
		p.setName((String) entity.getProperty("name"));
		//TODO refine
		p.setPassword((String) entity.getProperty("password"));
		//TODO, should we retrieve the real Object or just pass key?
		//p.setSupervisors((List<Employee>) entity.getProperty("supervisors"));
		p.setUsername((String) entity.getProperty("username"));
		p.setUserrole((String) entity.getProperty("userrole"));
		
		return p;
	}

}
