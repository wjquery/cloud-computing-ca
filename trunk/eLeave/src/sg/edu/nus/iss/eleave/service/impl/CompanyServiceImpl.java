package sg.edu.nus.iss.eleave.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.edu.nus.iss.eleave.dao.CompanyDAO;
import sg.edu.nus.iss.eleave.dao.gaeds.CompanyDAOImpl;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.exception.DAOException;
import sg.edu.nus.iss.eleave.exception.ServiceException;
import sg.edu.nus.iss.eleave.service.CompanyService;
import sg.edu.nus.iss.eleave.service.EmployeeService;

public class CompanyServiceImpl implements CompanyService {

	private static Logger log = Logger.getLogger(CompanyService.class.getCanonicalName());
	
	private CompanyDAO companyDAO = new CompanyDAOImpl();
	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}
	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	@Override
	public List<Company> findAllCompanies() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findCompany(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertCompany(Company company) throws ServiceException {
		try {
			companyDAO.insertCompany(company);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
		return true;
	}

}
