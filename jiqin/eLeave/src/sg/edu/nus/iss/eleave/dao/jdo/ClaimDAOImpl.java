package sg.edu.nus.iss.eleave.dao.jdo;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sg.edu.nus.iss.eleave.dao.ClaimDAO;
import sg.edu.nus.iss.eleave.dto.Claim;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class ClaimDAOImpl implements ClaimDAO {
	
	

	@Override
	public Claim findClaim(String CompanyId, String claimId)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	      return pm.getObjectById(Claim.class, claimId);
	    } finally {
	      pm.close();
	    }
	    
	}

	@Override
	public List<Claim> findAllClaimsByCompany(String companyId)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		//TODO verify filter by ID or object
		//Company company = pm.getObjectById(Company.class, companyId);
		Query q = pm.newQuery(Claim.class);
		q.setFilter("company == companyIdParam");
		q.declareParameters("String companyIdParam");
		try{
			List<Claim> results = (List<Claim>) q.execute(companyId);
			return results;
		}finally{
			q.closeAll();
		}
		
	}

	@Override
	public List<Claim> findAllClaims(String companyId, int offset)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		//TODO verify filter by ID or object
		//Company company = pm.getObjectById(Company.class, companyId);
		Query q = pm.newQuery(Claim.class);
		q.setFilter("company == companyIdParam");
		q.declareParameters("String companyIdParam");
		q.setRange(offset, offset + ConfigSetting.LIST_PER_PAGE);
		try{
			List<Claim> results = (List<Claim>) q.execute(companyId);
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public void insertClaim(Claim claim) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(claim);
	    } finally {
	      pm.close();
	    }

	}

	@Override
	public void updateClaim(Claim claim) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	    	//TODO will JDO make sure the key did not change??
	       pm.makePersistent(claim);
	    } finally {
	      pm.close();
	    }

	}

	@Override
	public void deleteClaim(Claim claim) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	    	 pm.deletePersistent(claim);
	    } finally {
	      pm.close();
	    }

	}

}
