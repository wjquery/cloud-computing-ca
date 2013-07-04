package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.edu.nus.iss.eleave.dao.EmployeeDAO;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class.getCanonicalName());
	
	@Override
	public Employee findEmployeeById(String employeeId) {
		Entity entity = Util.findFirstMatch(Employee.KIND, "employeeId", employeeId);
		if (entity != null) {
			Employee employee = buildEmployeeDTO(entity);
			log.log(Level.INFO, "Employee found: " + employee.getName());
			return employee;
		}
		log.log(Level.INFO, "Employee not found for Id: " + employeeId);
		return null;
	}

	@Override
	public List<Employee> findAllEmployees() {
		Iterable<Entity> entities = Util.listEntities(Employee.KIND, null, null);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(buildEmployeeDTO(entity));
		}
		return employees;
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(String companyId) {
		Key ancestorKey = KeyFactory.createKey(Company.KIND, companyId); 
		Iterable<Entity> entities = Util.listChildren(Employee.KIND, ancestorKey);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(buildEmployeeDTO(entity));
		}
		return employees;
	}

	@Override
	public List<Employee> findAllEmployeesByCompany(String companyId, int offset, int fetchSize) {
		return findAllEmployeesByCompany(companyId).subList(offset, offset + fetchSize + 1);
	}

	@Override
	public List<Employee> findAllEmployeesByDeparment(String departmentId) {
		Iterable<Entity> entities = Util.listEntities(Employee.KIND, "departmentId", departmentId);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(buildEmployeeDTO(entity));
		}
		return employees;
	}

	@Override
	public List<Employee> findAllEmployeesByDeparment(String departmentId, int offset, int fetchSize) {
		return findAllEmployeesByDeparment(departmentId).subList(offset, offset + fetchSize + 1);
	}

	@Override
	public List<Employee> findAllEmployeesBySupervisor(String supervisorId) {
		Iterable<Entity> entities = Util.listEntities(Employee.KIND, "supervisorId", supervisorId);
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
			employees.add(this.buildEmployeeDTO(entity));
		}
		return employees;
	}
	
	@Override
	public List<Employee> findAllEmployeesBySupervisor(String supervisorId, int offset, int fetchSize) {
		return findAllEmployeesBySupervisor(supervisorId).subList(offset, offset + fetchSize + 1);
	}

	@Override
	public void insertEmployee(Employee employee) throws DAOException {
		Key companyKey = KeyFactory.createKey(Company.KIND, employee.getCompanyId());
		log.log(Level.INFO, "Adding employee for company: " + companyKey.getName());
		Entity e = new Entity(Employee.KIND, companyKey);
		e.setProperty("employeeId", employee.getEmployeeId());
		e.setProperty("companyId", employee.getCompanyId());
		
		e.setProperty("name", employee.getName());
		e.setProperty("designation", employee.getDesignation());
		e.setProperty("departmentId", employee.getDeparmentId());
		e.setProperty("supervisorId", employee.getSupervisorId());
		e.setProperty("joinDate", employee.getJoinDate());
		e.setProperty("resignDate", employee.getResignDate());
		e.setProperty("userrole", employee.getUserrole());
		e.setProperty("email", employee.getEmail());
		e.setProperty("password", employee.getPassword());
		e.setProperty("username", employee.getUsername());
		e.setProperty("isCurrent", employee.isCurrent());
		log.log(Level.INFO, "Employee: " + e.getKey().getName());
		Util.persistEntity(e);
	}

	@Override
	public void updateEmployee(Employee employee) throws DAOException {
		
		Entity e = Util.findFirstMatch(Employee.KIND, "employeeId", employee.getEmployeeId());
		
		e.setProperty("name", employee.getName());
		e.setProperty("designation", employee.getDesignation());
		e.setProperty("departmentId", employee.getDeparmentId());
		e.setProperty("supervisorId", employee.getSupervisorId());
		e.setProperty("joinDate", employee.getJoinDate());
		e.setProperty("resignDate", employee.getResignDate());
		e.setProperty("userrole", employee.getUserrole());
		e.setProperty("email", employee.getEmail());
		e.setProperty("password", employee.getPassword());
		e.setProperty("username", employee.getUsername());
		e.setProperty("isCurrent", employee.isCurrent());
		Util.persistEntity(e);
	}

	@Override
	public void deleteEmployee(Employee employee) throws DAOException {
		Entity entity = getEmployee(employee.getEmployeeId());
		if(entity != null) {
			Util.deleteEntity(entity.getKey());
		}
	}
	
	private Entity getEmployee(String employeeId){
		Key key = KeyFactory.createKey(Employee.KIND, employeeId);
		return Util.findEntity(key);
	}
	
	private Employee buildEmployeeDTO(Entity entity){
		Employee p = new Employee();
		p.setEmployeeId((String) entity.getProperty("employeeId"));
		p.setName((String) entity.getProperty("name"));
		p.setCompanyId((String) entity.getProperty("companyId"));
		p.setDeparmentId((String) entity.getProperty("departmentId"));
		p.setDesignation((String) entity.getProperty("designation"));
		p.setSupervisorId((String) entity.getProperty("supervisorId"));
		p.setJoinDate((Date) entity.getProperty("joinDate"));
		p.setResignDate((Date) entity.getProperty("joinDate"));
		p.setEmail((String) entity.getProperty("email"));
		p.setUserrole((String) entity.getProperty("userrole"));
		p.setUsername((String) entity.getProperty("username"));
		p.setPassword((String) entity.getProperty("password"));
		p.setCurrent((Boolean) entity.getProperty("isCurrent"));
		return p;
	}

}
