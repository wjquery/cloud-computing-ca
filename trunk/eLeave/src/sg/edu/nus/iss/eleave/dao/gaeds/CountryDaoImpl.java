package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sg.edu.nus.iss.eleave.dao.CountryDao;
import sg.edu.nus.iss.eleave.dto.Country;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class CountryDaoImpl implements CountryDao {
	
	public static final String COUNTRY_ENTITY = "Country";

	@Override
	public Country findCountry(String countryId) throws DAOException {
		Entity entity = this.getCountry(countryId);
		if(entity != null) {
			return this.buildCountryDTO(entity);
		}
		return null;
	}

	@Override
	public Country findCountryByISOCode(String isoCode) throws DAOException {
		Iterable<Entity> entities = Util.listEntities(COUNTRY_ENTITY, "countryCode", isoCode);
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity entity = it.next();
			return this.buildCountryDTO(entity);
		}
		return null;
	}

	@Override
	public List<Country> findAllCountries() throws DAOException {
		Iterable<Entity> entities = Util.listEntities(COUNTRY_ENTITY, null, null);
		List<Country> countries = new ArrayList<Country>();
		for(Entity entity : entities) {
			countries.add(this.buildCountryDTO(entity));
		}
		return countries;
	}

	@Override
	public List<Country> findAllCountries(int offset) throws DAOException {
		Iterable<Entity> entities = Util.listEntities(COUNTRY_ENTITY, null, null, offset);
		List<Country> countries = new ArrayList<Country>();
		for(Entity entity : entities) {
			countries.add(this.buildCountryDTO(entity));
		}
		return countries;
	}

	@Override
	public void insertCountry(Country country) throws DAOException {
		Entity p = new Entity(COUNTRY_ENTITY,country.getCountryId());
		p.setProperty("name",country.getCountryName());
		p.setProperty("countryCode",country.getCountryCode());
		Util.persistEntity(p);

	}

	@Override
	public void updateCountry(Country country) throws DAOException {
		Entity p = new Entity(COUNTRY_ENTITY,country.getCountryId());
		p.setProperty("name",country.getCountryName());
		p.setProperty("countryCode",country.getCountryCode());
		Util.persistEntity(p);
	}

	@Override
	public void deleteCountry(Country country) throws DAOException {
		Entity p = this.getCountry(country.getCountryId());
		if(p!=null) {
			Util.deleteEntity(p.getKey());
		}
	}
	
	private Entity getCountry(String countryId){
		Key key = KeyFactory.createKey(COUNTRY_ENTITY, countryId);
		try {
			return Util.getDatastoreServiceInstance().get(key);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Country buildCountryDTO(Entity entity){
		Country p = new Country();
		p.setCountryCode((String) entity.getProperty("countryCode"));
		p.setCountryId(entity.getKey().getName());
		p.setCountryName((String) entity.getProperty("countryName"));
		return p;
	}

}
