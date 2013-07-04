package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sg.edu.nus.iss.eleave.dao.LeaveApplicationDao;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class LeaveApplicationDAOImpl implements LeaveApplicationDao {
	
	public static final String LEAVE_APPLICATION_KIND = "LeaveApplication";

	@Override
	public LeaveApplication findLeaveApplication(String companyId,
			String leaveApplicationId) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplications()
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationsByCompany(
			String companyId) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationsByEmployee(
			Employee employee) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertLeaveApplication(LeaveApplication leaveApplication)
			throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLeaveApplication(LeaveApplication leaveApplication)
			throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLeaveApplication(LeaveApplication leaveApplication)
			throws DAOException {
		// TODO Auto-generated method stub

	}
	
	private Entity getLeaveApplication(String companyId,String leaveApplicationId){
		Key parent = KeyFactory.createKey(CompanyDAOImpl.COMPANY_KIND, leaveApplicationId);
		//TODO should we model it as a child of Employee, then in employee, just do listChild
		Key key = KeyFactory.createKey(parent, LEAVE_APPLICATION_KIND, leaveApplicationId);
		try {
			return Util.getDatastoreServiceInstance().get(key);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private LeaveApplication buildLeaveApplicationDTO(Entity entity){
		LeaveApplication p = new LeaveApplication();
		p.setApplicationId((String) entity.getProperty("leaveApplicationId"));
		p.setApplyDate((Date) entity.getProperty("applyDate"));
		//TODO, store employee key or Employee Object
//		p.setApplicant((Employee) entity.getProperty("applicant"));
		
		
	
		return p;
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationsByEmployee(
			Employee employee, int year) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
