package sg.edu.nus.iss.eleave.service;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveType;
import sg.edu.nus.iss.eleave.dto.LeaveEntitlement;
import sg.edu.nus.iss.eleave.exception.ServiceException;

public interface LeaveEntitlementService {
	
	public List<LeaveEntitlement> findLeaveEntitlementsByEmp (Employee emp) throws ServiceException;
	public List<LeaveEntitlement> findLeaveEntitlementsByEmpAndYear (Employee emp, int year) throws ServiceException;
	public List<LeaveEntitlement> findLeaveEntitlementsByLeaveType (LeaveType leaveType) throws ServiceException;
	public List<LeaveEntitlement> findLeaveEntitlementsByLeaveTypeAndYear (LeaveType leaveType, int year) throws ServiceException;
	
	public void insertLeaveEntitlement (LeaveEntitlement entitlement) throws ServiceException;
	public void insertListOfLeaveEntitlements (List<LeaveEntitlement> list) throws ServiceException;
	public void updateLeaveEntitlement (LeaveEntitlement entitlement) throws ServiceException;
	public void deleteLeaveEntitlement (LeaveEntitlement entitlement) throws ServiceException;
	
}
