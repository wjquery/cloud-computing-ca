package sg.edu.nus.iss.eleave.service.impl;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Claim;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.ServiceException;
import sg.edu.nus.iss.eleave.service.ClaimService;

public class ClaimServiceImpl implements  ClaimService{

	@Override
	public Claim findClaimApplication(String companyId,
			String claimApplicationId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claim> findAllClaimApplicationByEmployee(Employee employee)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claim> findAllClaimApplicationByEmployee(Employee employee,
			int year) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertClaimApplication(Claim claim) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upadateClaimApplication(Claim claim) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClaimApplication(Claim claim) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveClaim(Claim claim) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectClaim(Claim claim) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String formEmailSubjectToApplicant(Claim claim, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formEmailContentToApplicant(Claim claim, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formEmailSubjectToApprover(Claim claim, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formEmailContentToApprover(Claim claim, String type) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
