package sg.edu.nus.iss.eleave.service;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Claim;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.ServiceException;

public interface ClaimService {
	public Claim findClaimApplication(String companyId, String claimApplicationId) throws ServiceException;
	public List<Claim> findAllClaimApplicationByEmployee(Employee employee) throws ServiceException;
	public List<Claim> findAllClaimApplicationByEmployee(Employee employee, int month) throws ServiceException;
	
	public void insertClaimApplication(Claim claim) throws ServiceException;
	public void upadateClaimApplication(Claim claim) throws ServiceException;
	public void deleteClaimApplication(Claim claim) throws ServiceException;
	
	
	
	public void approveClaim(Claim claim) throws ServiceException;
	public void rejectClaim(Claim claim) throws ServiceException;
	
	//Email Related
	public String formEmailSubjectToApplicant(Claim claim, String type);
	public String formEmailContentToApplicant(Claim claim, String type);
	public String formEmailSubjectToApprover(Claim claim, String type);
	public String formEmailContentToApprover(Claim claim, String type);
}
