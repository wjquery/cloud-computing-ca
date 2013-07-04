package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sg.edu.nus.iss.eleave.dao.CompanyDAO;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class CompanyDAOImpl implements CompanyDAO {

	@Override
	public Company findCompanyById(String companyId) {
		Entity entity = getCompany(companyId);
		if (entity != null) {
			return buildCompanyDTO(entity);
		} else {
			return null;
		}
	}

	@Override
	public List<Company> findCompaniesByName(String name) {
		Iterable<Entity> entities = Util.listEntities(Company.KIND, "name", name);
		List<Company> l = new ArrayList<Company>();
		for (Entity item : entities) {
			l.add(buildCompanyDTO(item));
		}
		return l;
	}

	@Override
	public List<Company> findAllCompanies() {
		Iterable<Entity> entities = Util.listEntities(Company.KIND, null, null);
		List<Company> l = new ArrayList<Company>();
		for (Entity item : entities) {
			l.add(buildCompanyDTO(item));
		}
		return l;
	}

	@Override
	public List<Company> findAllCompanies(int offset, int fetchSize) {
		return findAllCompanies().subList(offset, offset + fetchSize + 1);
	}

	@Override
	public void insertCompany(Company company) throws DAOException {
		Entity p = new Entity(Company.KIND, company.getCompanyId());
		p.setProperty("companyId", company.getCompanyId());
		p.setProperty("name", company.getName());
		p.setProperty("address", company.getAddress());
		p.setProperty("contactNo", company.getContactNo());
		p.setProperty("subscriptionType", company.getSubcriptionType());
		Util.persistEntity(p);
	}

	@Override
	public void updateCompany(Company company) throws DAOException {
		Entity p = getCompany(company.getCompanyId());
		p.setProperty("name", company.getName());
		p.setProperty("address", company.getAddress());
		p.setProperty("contactNo", company.getContactNo());
		p.setProperty("subscriptionType", company.getSubcriptionType());
		Util.persistEntity(p);
	}

	@Override
	public void deleteCompany(Company company) throws DAOException {
		Entity p = getCompany(company.getCompanyId());
		if (p != null) {
			Util.deleteEntity(p.getKey());
		}
	}

	private Entity getCompany(String companyId) {
		Key key = KeyFactory.createKey(Company.KIND, companyId);
		return Util.findEntity(key);
	}

	private Company buildCompanyDTO(Entity entity) {
		Company p = new Company();
		p.setCompanyId((String) entity.getProperty("companyId"));
		p.setCompanyId((String) entity.getProperty("name"));
		p.setAddress((String) entity.getProperty("address"));
		p.setContactNo((String) entity.getProperty("contactNo"));
		p.setSubcriptionType((String) entity.getProperty("subscriptionType"));
		return p;
	}

}
