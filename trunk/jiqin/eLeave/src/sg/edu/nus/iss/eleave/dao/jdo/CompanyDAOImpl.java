package sg.edu.nus.iss.eleave.dao.jdo;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sg.edu.nus.iss.eleave.dao.CompanyDAO;
import sg.edu.nus.iss.eleave.dto.Claim;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class CompanyDAOImpl implements CompanyDAO {

	@Override
	public Company findCompany(String companyId) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	      return pm.getObjectById(Company.class, companyId);
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public List<Company> findAllCompanies() throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Company.class);
	
		try{
			List<Company> results = (List<Company>) q.execute();
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<Company> findAllCompanies(int offset) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Claim.class);
		q.setRange(offset, offset + ConfigSetting.LIST_PER_PAGE);
		try{
			List<Company> results = (List<Company>) q.execute();
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public void insertCompany(Company company) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(company);
	    } finally {
	      pm.close();
	    }

	}

	@Override
	public void updateCompany(Company company) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(company);
	    } finally {
	      pm.close();
	    }

	}

	@Override
	public void deleteCompany(Company company) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.deletePersistent(company);
	    } finally {
	      pm.close();
	    }

	}

}
