package sg.edu.nus.iss.eleave.dao;

import sg.edu.nus.iss.eleave.exception.DAOException;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Claim;

public interface ClaimDAO {
	
	public Claim findClaim(String CompanyId, String claimId) throws DAOException;
    public List<Claim> findAllClaimsByCompany(String companyId) throws DAOException;
    public List<Claim> findAllClaims(String companyId, int offset) throws DAOException;
    public void insertClaim(Claim claim) throws DAOException;
    public void updateClaim(Claim claim) throws DAOException;
    public void deleteClaim(Claim claim) throws DAOException;
}
