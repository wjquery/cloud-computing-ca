package sg.edu.nus.iss.eleave.dao;

import sg.edu.nus.iss.eleave.exception.DAOException;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Claim;

public interface ClaimDAO {
	
	public Claim findClaim(String claimId) throws DAOException;
    public List<Claim> findAllClaims() throws DAOException;
    public List<Claim> findAllClaims(int offset) throws DAOException;
    public void insertClaim(Claim claim) throws DAOException;
    public void updateClaim(Claim claim) throws DAOException;
    public void deleteClaim(Claim claim) throws DAOException;
}
