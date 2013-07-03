package sg.edu.nus.iss.eleave.dao.jdo;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class DepartmentDaoImplTest {
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());
	private CompanyDAOImpl companyDao;
	private DepartmentDAOImpl departmentDao;
	
	
	@Before
	public void setUp() {
		helper.setUp();
		//pm = PMF.get().getPersistenceManager();
		companyDao = new CompanyDAOImpl();
		departmentDao = new DepartmentDAOImpl();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}
	
	
	@Test
	public void test1()
	{
		Company company1 = new Company(
				"C000001", "Test Company 1", "Address 1",
				"SG", " ", "FREE"
				);
		Department department1 = new Department(
				"D000001", "Test Department 1",
				null,  company1
				);
		
		try {
			List<Department> departments = departmentDao.findAllDepartments();
			Assert.assertEquals(0, departments.size());
			companyDao.insertCompany(company1);
			departmentDao.insertDepartment(department1);
			//test whether cascade
			List<Company> companys = companyDao.findAllCompanies();
			System.out.println("companys.size() " + companys.size());
			departments = departmentDao.findAllDepartments();
			Assert.assertEquals(1, departments.size());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}