package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface CompanyDAO {
	
	public Company findCompany(String companyId) throws DAOException;
    public List<Company> findAllCompanies() throws DAOException;
    public List<Company> findAllCompanies(int offset) throws DAOException;
    public void insertCompany(Company company) throws DAOException;
    public void updateCompany(Company company) throws DAOException;
    public void deleteCompany(Company company) throws DAOException;
}
