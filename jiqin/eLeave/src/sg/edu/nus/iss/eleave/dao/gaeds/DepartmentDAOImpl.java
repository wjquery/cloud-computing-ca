package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sg.edu.nus.iss.eleave.dao.DepartmentDao;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class DepartmentDAOImpl implements DepartmentDao {
	public static final String DEPARTMENT_KIND = "Department";
	
	@Override
	public Department findDepartment(String companyId, String departmentId)
			throws DAOException {
		Entity entity = this.getDepartment(companyId, departmentId);
		if(entity != null) {
			return this.buildDepartmentDTO(entity);
		}
		return null;
	}

	@Override
	public List<Department> findAllDepartments() throws DAOException {
		Iterable<Entity> entities = Util.listEntities(DEPARTMENT_KIND, null, null);
		List<Department> departments = new ArrayList<Department>();
		for(Entity entity: entities) {
			departments.add(this.buildDepartmentDTO(entity));
		}
		return departments;
	}

	@Override
	public List<Department> findAllDepartmentsByCompany(Company company)
			throws DAOException {
		Iterable<Entity> entities = Util.listEntities(DEPARTMENT_KIND, "company", company);
		List<Department> departments = new ArrayList<Department>();
		for(Entity entity: entities) {
			departments.add(this.buildDepartmentDTO(entity));
		}
		return departments;
	}

	@Override
	public void insertDepartment(Department department) throws DAOException {
		Key parent = KeyFactory.createKey(CompanyDAOImpl.COMPANY_KIND, department.getCompany().getCompanyId());
		Entity p = new Entity(DEPARTMENT_KIND,department.getDepartmentId(), parent);
		p.setProperty("name", department.getName());
		p.setProperty("company",department.getCompany());
		p.setProperty("departmentHead", department.getDepartmentHead());
		Util.persistEntity(p);

	}

	@Override
	public void updateDepartment(Department department) throws DAOException {
		Key parent = KeyFactory.createKey(CompanyDAOImpl.COMPANY_KIND, department.getCompany().getCompanyId());
		Entity p = new Entity(DEPARTMENT_KIND,department.getDepartmentId(), parent);
		p.setProperty("name", department.getName());
		p.setProperty("company",department.getCompany());
		p.setProperty("departmentHead", department.getDepartmentHead());
		Util.persistEntity(p);


	}

	@Override
	public void deleteDepartment(Department department) throws DAOException {
		Entity entity = this.getDepartment(department.getCompany().getCompanyId(), department.getDepartmentId());
		if(entity != null) {
			Util.deleteEntity(entity.getKey());
		}

	}
	
	private Entity getDepartment(String companyId,String departmentId){
		Key parent = KeyFactory.createKey(CompanyDAOImpl.COMPANY_KIND, companyId);
		Key key = KeyFactory.createKey(parent, DEPARTMENT_KIND, departmentId);
		try {
			return Util.getDatastoreServiceInstance().get(key);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Department buildDepartmentDTO(Entity entity){
		Department p = new Department();
		p.setCompany((Company) entity.getProperty("company"));
		p.setDepartmentHead((Employee) entity.getProperty("departmentHead"));
		p.setDepartmentId(entity.getKey().getName());
		p.setName((String) entity.getProperty("name"));
		
		return p;
	}

}
