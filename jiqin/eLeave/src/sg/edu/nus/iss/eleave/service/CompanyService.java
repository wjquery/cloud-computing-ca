package sg.edu.nus.iss.eleave.service;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.exception.ServiceException;

public interface CompanyService {
	public List<Company> findAllCompanies() throws ServiceException;
	public Company findCompany(String companyId) throws ServiceException;
	public boolean insertCompany(Company company) throws ServiceException;
}
