package sg.edu.nus.iss.eleave.dao.jdo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sg.edu.nus.iss.eleave.dao.LeaveApplicationDao;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class LeaveApplicationDAOImpl implements LeaveApplicationDao {

	@Override
	public LeaveApplication findLeaveApplication(String companyId,
			String leaveApplicationId) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	      return pm.getObjectById(LeaveApplication.class, leaveApplicationId);
	    } finally {
	      pm.close();
	    }
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplications()
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(LeaveApplication.class);
		
		try{
			List<LeaveApplication> results = (List<LeaveApplication>) q.execute();
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationsByCompany(
			String companyId) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(LeaveApplication.class);
		q.setFilter("company == companyParam");
		q.declareParameters("String companyParam");
		try{
			List<LeaveApplication> results = (List<LeaveApplication>) q.execute(companyId);
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationsByEmployee(
			Employee employee) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(LeaveApplication.class);
		q.setFilter("applicant == applicantParam");
		q.declareParameters("String applicantParam");
		try{
			List<LeaveApplication> results = (List<LeaveApplication>) q.execute(employee.getEmployeeId());
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationsByEmployee(
			Employee employee, int year) throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(LeaveApplication.class);
		q.setFilter("applicant == applicantParam && applyDate >= startDateParam && applyDate < endDateParam ");
		q.declareParameters("String applicantParam");
		q.declareParameters("Date startDateParam");
		q.declareParameters("Date endDateParam");
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		Date startDate = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		Date endDate = cal.getTime();
		try{
			//TODO check ??
			List<LeaveApplication> results = (List<LeaveApplication>) q.execute(employee.getEmployeeId(), startDate, endDate);
			return results;
		}finally{
			q.closeAll();
		}
	}

	@Override
	public void insertLeaveApplication(LeaveApplication leaveApplication)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(leaveApplication);
	    } finally {
	      pm.close();
	    }
		
	}

	@Override
	public void updateLeaveApplication(LeaveApplication leaveApplication)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.makePersistent(leaveApplication);
	    } finally {
	      pm.close();
	    }
		
	}

	@Override
	public void deleteLeaveApplication(LeaveApplication leaveApplication)
			throws DAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	       pm.deletePersistent(leaveApplication);
	    } finally {
	      pm.close();
	    }
	}

}
