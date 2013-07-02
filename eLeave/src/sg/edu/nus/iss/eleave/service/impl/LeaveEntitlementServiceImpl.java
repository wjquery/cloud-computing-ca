package sg.edu.nus.iss.eleave.service.impl;

import java.util.List;
import java.util.logging.Level;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveEntitlement;
import sg.edu.nus.iss.eleave.dto.LeaveType;
import sg.edu.nus.iss.eleave.exception.ServiceException;
import sg.edu.nus.iss.eleave.exception.DAOException;
import sg.edu.nus.iss.eleave.service.LeaveEntitlementService;
import sg.edu.nus.iss.eleave.dao.LeaveEntitlementDao;

public class LeaveEntitlementServiceImpl implements LeaveEntitlementService {
	
	private LeaveEntitlementDao leaveEntitlementDao;

	@Override
	public List<LeaveEntitlement> findLeaveEntitlementsByEmp(Employee emp) throws ServiceException {		
		try {
				return leaveEntitlementDao.findAllLeaveEntitlementsByEmployee(emp);
		} catch (DAOException e) {
				throw new ServiceException();
		}
	}

	@Override
	public List<LeaveEntitlement> findLeaveEntitlementsByEmpAndYear(Employee emp, int year) throws ServiceException {
		try {
			return leaveEntitlementDao.findAllLeaveEntitlementsByEmployeeAndYear(emp, year);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<LeaveEntitlement> findLeaveEntitlementsByLeaveType(LeaveType leaveType) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveEntitlement> findLeaveEntitlementsByLeaveTypeAndYear(LeaveType leaveType, int year) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertLeaveEntitlement(LeaveEntitlement entitlement) throws ServiceException {
		try {
			leaveEntitlementDao.insertLeaveEntitlement(entitlement);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void insertListOfLeaveEntitlements(List<LeaveEntitlement> list) throws ServiceException {
		try {
			for (LeaveEntitlement entitlement:list){
				leaveEntitlementDao.insertLeaveEntitlement(entitlement);
			}
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void updateLeaveEntitlement(LeaveEntitlement entitlement) throws ServiceException {
		try {
			leaveEntitlementDao.updateLeaveEntitlement(entitlement);
		} catch (DAOException e) {
			throw new ServiceException();
		}		
	}

	@Override
	public void deleteLeaveEntitlement(LeaveEntitlement entitlement) throws ServiceException {
		try {
			leaveEntitlementDao.deleteLeaveEntitlement(entitlement);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

}
