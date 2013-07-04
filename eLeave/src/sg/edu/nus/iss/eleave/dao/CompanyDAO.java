package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface CompanyDAO {
	public Company findCompanyById(String companyId);
	public List<Company> findCompaniesByName(String name);
    public List<Company> findAllCompanies();
    public List<Company> findAllCompanies(int offset, int fetchSize);
    public void insertCompany(Company company) throws DAOException;
    public void updateCompany(Company company) throws DAOException;
    public void deleteCompany(Company company) throws DAOException;
}
