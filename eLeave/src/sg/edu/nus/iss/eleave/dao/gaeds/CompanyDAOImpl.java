package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sg.edu.nus.iss.eleave.dao.CompanyDAO;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class CompanyDAOImpl implements CompanyDAO {
	public static final String COMPANY_ENTITY = "Company";

	@Override
	public Company findCompany(String companyId) throws DAOException {
		Entity entity = this.getCompany(companyId);
		if (entity!=null){
			return this.buildCompanyDTO(entity);
		} else {
			return null;
		}
	}

	@Override
	public List<Company> findAllCompanies() throws DAOException {
		Iterable<Entity> entities = Util.listEntities(COMPANY_ENTITY, null, null);
		List<Company> l = new ArrayList<Company>();
		for (Entity item : entities){
			l.add(buildCompanyDTO(item));
		}
		return l;
		
	}

	@Override
	public List<Company> findAllCompanies(int offset) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCompany(Company company) throws DAOException {
		Entity p = new Entity(COMPANY_ENTITY,company.getCompanyId());
		p.setProperty("name",company.getName());
		p.setProperty("address",company.getAddress());
		p.setProperty("contactNo",company.getContactNo());
		p.setProperty("country",company.getCountryCode());
		Util.persistEntity(p);
		
	}

	@Override
	public void updateCompany(Company company) throws DAOException {
		Entity p = new Entity(COMPANY_ENTITY,company.getCompanyId());
		p.setProperty("name",company.getName());
		p.setProperty("address",company.getAddress());
		p.setProperty("contactNo",company.getContactNo());
		p.setProperty("country",company.getCountryCode());
		Util.persistEntity(p);
		
	}

	@Override
	public void deleteCompany(Company company) throws DAOException {
		Entity p = getCompany(company.getCompanyId());
		
		if (p!=null){
			Util.deleteEntity(p.getKey());
		}
		
	}
	
	private Entity getCompany(String companyId){
		Key key = KeyFactory.createKey(COMPANY_ENTITY, companyId);
		try {
			return Util.getDatastoreServiceInstance().get(key);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Company buildCompanyDTO(Entity entity){
		Company p = new Company();
		
		return p;
	}

}
