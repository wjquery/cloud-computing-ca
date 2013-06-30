package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.LeaveEntitlement;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface LeaveEntitlementDao {
	public LeaveEntitlement findLeaveEntitlement(String leaveEntitlementId) throws DAOException;
	
    public List<LeaveEntitlement> findAllLeaveEntitlements(String employeeId) throws DAOException;
    
    public void insertLeaveEntitlement(LeaveEntitlement leaveEntitlement) throws DAOException;
    public void updateLeaveEntitlement(LeaveEntitlement leaveEntitlement) throws DAOException;
    public void deleteLeaveEntitlement(LeaveEntitlement leaveEntitlement) throws DAOException;
}
