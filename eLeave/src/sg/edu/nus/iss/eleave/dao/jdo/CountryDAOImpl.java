package sg.edu.nus.iss.eleave.dao.jdo;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sg.edu.nus.iss.eleave.dao.CountryDao;
import sg.edu.nus.iss.eleave.dto.Claim;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Country;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class CountryDAOImpl implements CountryDao {

	@Override
	public Country findCountry(String countryId) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	      return pm.getObjectById(Country.class, countryId);
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public Country findCountryByISOCode(String isoCode) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Claim.class);
		q.setFilter("countryCode == countryCodeParam");
		q.declareParameters("String countryCodeParam");
		try{
			List<Country> results = (List<Country>) q.execute(isoCode);
			if( results.isEmpty() ){
				return null;
			}else{
				return results.get(0);
			}
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<Country> findAllCountries() throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Claim.class);
		
		try{
			List<Country> results = (List<Country>) q.execute();
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<Country> findAllCountries(int offset) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Claim.class);
		q.setRange(offset, offset + ConfigSetting.LIST_PER_PAGE);
		try{
			List<Country> results = (List<Country>) q.execute();
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public void insertCountry(Country country) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(country);
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public void updateCountry(Country country) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(country);
	    } finally {
	      pm.close();
	    }


	}

	@Override
	public void deleteCountry(Country country) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.deletePersistent(country);
	    } finally {
	      pm.close();
	    }

	}

}
