package sg.edu.nus.iss.eleave.service.impl;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.edu.nus.iss.eleave.dao.ClaimDAO;
import sg.edu.nus.iss.eleave.dao.LeaveApplicationDao;
import sg.edu.nus.iss.eleave.dto.Claim;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.exception.DAOException;
import sg.edu.nus.iss.eleave.exception.ServiceException;
import sg.edu.nus.iss.eleave.service.ClaimService;

public class ClaimServiceImpl implements  ClaimService{
    	private static Logger log = Logger.getLogger(LeaveApplicationServiceImpl.class.getCanonicalName());
	private ClaimDAO claimnDAO;

	@Override
	public Claim findClaimApplication(String companyId,
			String claimApplicationId) throws ServiceException {
	    try{
		return claimnDAO.findClaim(companyId, claimApplicationId);
	    }catch (DAOException e) {
		log.log(Level.SEVERE, e.getMessage());
		throw new ServiceException();
	    }
	}

	@Override
	public List<Claim> findAllClaimApplicationByEmployee(String employeeId)
			throws ServiceException {
	    return null;
	}

	@Override
	public Claim findAllClaimApplicationByEmployee(String employeeId,
			int month) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertClaimApplication(Claim claim) throws ServiceException {
	    try{
		claimnDAO.insertClaim(claim);
	    }catch (DAOException e) {
		log.log(Level.SEVERE, e.getMessage());
		throw new ServiceException();
	    }
		
	}

	@Override
	public void upadateClaimApplication(Claim claim) throws ServiceException {
	    try{
 		claimnDAO.updateClaim(claim);
 	    }catch (DAOException e) {
 		log.log(Level.SEVERE, e.getMessage());
 		throw new ServiceException();
 	    }
	}

	@Override
	public void deleteClaimApplication(Claim claim) throws ServiceException {
	    try{
 		claimnDAO.deleteClaim(claim);
 	    }catch (DAOException e) {
 		log.log(Level.SEVERE, e.getMessage());
 		throw new ServiceException();
 	    }
	}

	@Override
	public List<Claim> findClaimByManager(String managerId)
		throws ServiceException {
	    try{
 		return claimnDAO.findClaimByManager(managerId);
 	    }catch (DAOException e) {
 		log.log(Level.SEVERE, e.getMessage());
 		throw new ServiceException();
 	    }
	}

	@Override
	public List<Claim> findClaimByManager(String managerId, int month)
		throws ServiceException {
	    try {
		return claimnDAO.findClaimByManager(managerId,month);
	    } catch (DAOException e) {
		log.log(Level.SEVERE, e.getMessage());
 		throw new ServiceException();
 	    }
	}
	
	@Override
	public void approveClaim(Claim claim) throws ServiceException {
	    try{
 		claimnDAO.updateClaim(claim);
 	    }catch (DAOException e) {
 		log.log(Level.SEVERE, e.getMessage());
 		throw new ServiceException();
 	    }
	}

	@Override
	public void rejectClaim(Claim claim) throws ServiceException {
	    claim.setStatus("R");
	    try{
 		claimnDAO.updateClaim(claim);
 	    }catch (DAOException e) {
 		log.log(Level.SEVERE, e.getMessage());
 		throw new ServiceException();
 	    }	
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
