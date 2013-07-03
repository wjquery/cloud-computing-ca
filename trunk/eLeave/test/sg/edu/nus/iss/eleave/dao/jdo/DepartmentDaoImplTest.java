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
		
	
		
		try {
			List<Department> departments = departmentDao.findAllDepartments();
			Assert.assertEquals(0, departments.size());
			Company company1 = new Company(
					"C000001", "Test Company 1", "Address 1",
					"SG", " ", "FREE"
					);
			//After testing, it won't cascade saving,so have to store company first
			companyDao.insertCompany(company1);
			
			Department department1 = new Department(
					"D000001", "Test Department 1",
					null,  company1
					);
			departmentDao.insertDepartment(department1);
			//company1.getDepartments().add(department1);
			companyDao.updateCompany(company1);
			//test whether cascade
			List<Company> companys = companyDao.findAllCompanies();
			System.out.println("companys.size() " + companys.size());
			departments = departmentDao.findAllDepartments();
			for(Department dep : departments){
				System.out.println(dep.getEncodedKey());
			}
			System.out.println("departments.size() :" + departments.size());
			
			Assert.assertEquals(1, departments.size());
			//test find department
			Department department = departmentDao.findDepartment("", "D000001");
			Assert.assertNotNull(department);
			System.out.println(department.getDepartmentId());
			System.out.println(department.getCompany());
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
