package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sg.edu.nus.iss.eleave.dao.LeaveApplicationDao;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class LeaveApplicationDAOImpl implements LeaveApplicationDao {
	
	private static Logger log = Logger.getLogger(LeaveApplicationDAOImpl.class.getCanonicalName());
	
	@Override
	public void insertLeaveApplication(LeaveApplication leaveApplication)
			throws DAOException {
		Entity employee = Util.findFirstMatch(Employee.KIND, "employeeId", leaveApplication.getApplicantId());
		Key employeeKey = employee.getKey();
		log.log(Level.INFO, "Adding leave application for employee: " + employeeKey.getName());
		Entity e = new Entity(LeaveApplication.KIND, employeeKey);
		
		e.setProperty("applicationId", UUID.randomUUID());
		e.setProperty("applicantId", leaveApplication.getApplicantId());
		e.setProperty("fromDate", leaveApplication.getFromDate());
		e.setProperty("toDate", leaveApplication.getToDate());
		e.setProperty("applyDate", leaveApplication.getApplyDate());
		e.setProperty("modifyDate", leaveApplication.getModifyDate());
		e.setProperty("processDate", leaveApplication.getProcessDate());
		e.setProperty("processComment", leaveApplication.getProcessComment());
		e.setProperty("processedById", leaveApplication.getProcessedById());
		e.setProperty("days", leaveApplication.getDays());
		e.setProperty("reason", leaveApplication.getReason());
		e.setProperty("status", leaveApplication.getStatus());
		
		log.log(Level.INFO, "Leave Application: " + e.getKey().getName());
		Util.persistEntity(e);

	}

	@Override
	public void updateLeaveApplication(LeaveApplication leaveApplication)
			throws DAOException {
		Entity e = Util.findFirstMatch(LeaveApplication.KIND, "applicationId", leaveApplication.getApplicationId());
		e.setProperty("fromDate", leaveApplication.getFromDate());
		e.setProperty("toDate", leaveApplication.getToDate());
		e.setProperty("applyDate", leaveApplication.getApplyDate());
		e.setProperty("modifyDate", leaveApplication.getModifyDate());
		e.setProperty("processDate", leaveApplication.getProcessDate());
		e.setProperty("processComment", leaveApplication.getProcessComment());
		e.setProperty("processedById", leaveApplication.getProcessedById());
		e.setProperty("days", leaveApplication.getDays());
		e.setProperty("reason", leaveApplication.getReason());
		e.setProperty("status", leaveApplication.getStatus());
		Util.persistEntity(e);
	}

	@Override
	public void deleteLeaveApplication(LeaveApplication leaveApplication)
			throws DAOException {
		Entity e = Util.findFirstMatch(LeaveApplication.KIND, "applicationId", leaveApplication.getApplicationId());
		if (e != null) {
			Util.deleteEntity(e.getKey());
		}
	}
	
	@Override
	public LeaveApplication findLeaveApplicationById(String leaveApplicationId) {
		Entity e = Util.findFirstMatch(LeaveApplication.KIND, "applicationId", leaveApplicationId);
		if (e != null) {
			return buildLeaveApplicationDTO(e);
		}
		return null;
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplications() {
		Iterable<Entity> entities = Util.listEntities(LeaveApplication.KIND, null, null);
		List<LeaveApplication> applications = new ArrayList<LeaveApplication>();
		for(Entity entity : entities) {
			applications.add(buildLeaveApplicationDTO(entity));
		}
		return applications;
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationsByCompany(String companyId) {
		Key ancestorKey = KeyFactory.createKey(Company.KIND, companyId); 
		Iterable<Entity> entities = Util.listChildren(LeaveApplication.KIND, ancestorKey);
		List<LeaveApplication> applications = new ArrayList<LeaveApplication>();
		for (Entity entity : entities) {
			applications.add(buildLeaveApplicationDTO(entity));
		}
		return applications;
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationsBySupervisor(String companyId, String supervisorId) {
		Key ancestorKey = KeyFactory.createKey(Company.KIND, companyId); 
		Iterable<Entity> entities = Util.listChildren(LeaveApplication.KIND, ancestorKey);
		List<LeaveApplication> applications = new ArrayList<LeaveApplication>();
		for (Entity entity : entities) {
			String sId = (String) entity.getProperty("supervisorId");
			if (supervisorId.equals(sId)) {
				applications.add(buildLeaveApplicationDTO(entity));
			}
		}
		return applications;
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationsByEmployee(String companyId, String employeeId) {
		Key ancestorKey = KeyFactory.createKey(Company.KIND, companyId); 
		Iterable<Entity> entities = Util.listChildren(Employee.KIND, ancestorKey);
		List<LeaveApplication> applications = new ArrayList<LeaveApplication>();
		for (Entity entity : entities) {
			String eId = (String) entity.getProperty("employeeId");
			if (employeeId.equals(eId)) {
				Iterable<Entity> list = Util.listChildren(LeaveApplication.KIND, entity.getKey());
				for (Entity e : list) {
					applications.add(buildLeaveApplicationDTO(e));
				}
			}
		}
		return applications;
	}

//	private Entity getLeaveApplication(String leaveApplicationId){
//		Key key = KeyFactory.createKey(LeaveApplication.KIND, leaveApplicationId);
//		return Util.findEntity(key);
//	}
	
	private LeaveApplication buildLeaveApplicationDTO(Entity entity){
		LeaveApplication l = new LeaveApplication();
		l.setApplicationId((String) entity.getProperty("leaveApplicationId"));
		l.setApplicantId((String)entity.getProperty("applicantId"));
		l.setDays((Double)entity.getProperty("days"));
		l.setFromDate((Date)entity.getProperty("fromDate"));
		l.setToDate((Date)entity.getProperty("toDate"));
		l.setLeaveTypeId((String)entity.getProperty("leaveTypeId"));
		l.setModifyDate((Date)entity.getProperty("modifyDate"));
		l.setProcessDate((Date)entity.getProperty("processDate"));
		l.setProcessComment((String)entity.getProperty("processComment"));
		l.setProcessedById((String)entity.getProperty("processedById"));
		l.setReason((String)entity.getProperty("reason"));
		l.setStatus((String)entity.getProperty("status"));
		l.setApplyDate((Date) entity.getProperty("applyDate"));
		return l;
	}

}
