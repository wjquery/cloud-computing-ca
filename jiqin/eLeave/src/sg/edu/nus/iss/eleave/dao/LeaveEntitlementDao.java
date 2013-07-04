package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveEntitlement;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface LeaveEntitlementDao {
	public LeaveEntitlement findLeaveEntitlement(String companyId, String leaveEntitlementId) throws DAOException;
    public List<LeaveEntitlement> findAllLeaveEntitlementsByEmployee(Employee employee) throws DAOException;
    public void insertLeaveEntitlement(LeaveEntitlement leaveEntitlement) throws DAOException;
    public void updateLeaveEntitlement(LeaveEntitlement leaveEntitlement) throws DAOException;
    public void deleteLeaveEntitlement(LeaveEntitlement leaveEntitlement) throws DAOException;
	public List<LeaveEntitlement> findAllLeaveEntitlementsByEmployeeAndYear(Employee employee, int year) throws DAOException;
}
