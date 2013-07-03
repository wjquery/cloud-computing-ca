package sg.edu.nus.iss.eleave.dao.jdo;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sg.edu.nus.iss.eleave.dao.DepartmentDao;
import sg.edu.nus.iss.eleave.dto.Claim;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class DepartmentDAOImpl implements DepartmentDao {

	@Override
	public Department findDepartment(String companyId, String departmentId)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	      return pm.getObjectById(Department.class, departmentId);
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public List<Department> findAllDepartments() throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Department.class);
		
		try{
			List<Department> results = (List<Department>) q.execute();
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<Department> findAllDepartmentsByCompany(Company company)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		//TODO verify filter by ID or object
		//Company company = pm.getObjectById(Company.class, companyId);
		Query q = pm.newQuery(Department.class);
		q.setFilter("company == companyIdParam");
		q.declareParameters("String companyIdParam");
		try{
			List<Department> results = (List<Department>) q.execute(company.getCompanyId());
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public void insertDepartment(Department department) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(department);
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public void updateDepartment(Department department) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(department);
	    } finally {
	      pm.close();
	    }


	}

	@Override
	public void deleteDepartment(Department department) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.deletePersistent(department);
	    } finally {
	      pm.close();
	    }

	}

}
