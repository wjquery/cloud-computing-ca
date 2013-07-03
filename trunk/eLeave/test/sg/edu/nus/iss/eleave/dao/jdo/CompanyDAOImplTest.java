package sg.edu.nus.iss.eleave.dao.jdo;

import java.util.List;

import javax.jdo.PersistenceManager;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.exception.DAOException;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class CompanyDAOImplTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());
	private CompanyDAOImpl companyDao;
	//private PersistenceManager pm;

	@Before
	public void setUp() {
		helper.setUp();
		//pm = PMF.get().getPersistenceManager();
		companyDao = new CompanyDAOImpl();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void insertCompany() {
		Company company1 = new Company(
				"C000001", "Test Company 1", "Address 1",
				"SG", " ", "FREE"
				);
		try {
			List<Company> companys = companyDao.findAllCompanies();
			Assert.assertEquals(0, companys.size());
			companyDao.insertCompany(company1);
			companys = companyDao.findAllCompanies();
			System.out.println(companys.size());
			Assert.assertEquals(1, companys.size());
			Company find = companyDao.findCompany("C000001");
			System.out.println(find.getAddress());
			Assert.assertNotNull(find);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
