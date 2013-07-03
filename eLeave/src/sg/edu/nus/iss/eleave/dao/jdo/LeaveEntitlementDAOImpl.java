package sg.edu.nus.iss.eleave.dao.jdo;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sg.edu.nus.iss.eleave.dao.LeaveApplicationDao;
import sg.edu.nus.iss.eleave.dao.LeaveEntitlementDao;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.dto.LeaveEntitlement;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class LeaveEntitlementDAOImpl implements LeaveEntitlementDao {

	@Override
	public LeaveEntitlement findLeaveEntitlement(String companyId,
			String leaveEntitlementId) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	      return pm.getObjectById(LeaveEntitlement.class, leaveEntitlementId);
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public List<LeaveEntitlement> findAllLeaveEntitlementsByEmployee(
			Employee employee) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(LeaveEntitlement.class);
		q.setFilter("employee == employeeParam ");
		q.declareParameters("String applicantParam");
		
		try{
			//TODO not sure, to verify
			List<LeaveEntitlement> results = (List<LeaveEntitlement>) q.execute(employee.getEmployeeId());
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public void insertLeaveEntitlement(LeaveEntitlement leaveEntitlement)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(leaveEntitlement);
	    } finally {
	      pm.close();
	    }
		
	}

	@Override
	public void updateLeaveEntitlement(LeaveEntitlement leaveEntitlement)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(leaveEntitlement);
	    } finally {
	      pm.close();
	    }
		
	}

	@Override
	public void deleteLeaveEntitlement(LeaveEntitlement leaveEntitlement)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.deletePersistent(leaveEntitlement);
	    } finally {
	      pm.close();
	    }
		
	}

	@Override
	public List<LeaveEntitlement> findAllLeaveEntitlementsByEmployeeAndYear(
			Employee employee, int year) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(LeaveEntitlement.class);
		q.setFilter("employee == employeeParam && year == yearParam ");
		q.declareParameters("String applicantParam");
		q.declareParameters("int yearParam");
		try{
			//TODO not sure, to verify
			List<LeaveEntitlement> results = (List<LeaveEntitlement>) q.execute(employee.getEmployeeId(), year);
			return results;
		}finally{
			q.closeAll();
		}
	}

	

}
