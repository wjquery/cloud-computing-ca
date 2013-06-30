package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Country;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface CountryDao {
	
	public Country findCountry(String countryId) throws DAOException;
	public Country findCountryByISOCode(String isoCode) throws DAOException;
    public List<Country> findAllCountries() throws DAOException;
    public List<Country> findAllCountries(int offset) throws DAOException;
    public void insertCountry(Country country) throws DAOException;
    public void updateCountry(Country country) throws DAOException;
    public void deleteCountry(Country country) throws DAOException;
}
