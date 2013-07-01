package sg.edu.nus.iss.eleave.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Method;

import sg.edu.nus.iss.eleave.dao.LeaveApplicationDao;
import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.DAOException;
import sg.edu.nus.iss.eleave.exception.ServiceException;
import sg.edu.nus.iss.eleave.service.LeaveApplicationService;

public class LeaveApplicationServiceImpl implements LeaveApplicationService {
	
	private static Logger log = Logger.getLogger(LeaveApplicationServiceImpl.class.getCanonicalName());
	
	
	private LeaveApplicationDao leaveApplicationDao;

	@Override
	public LeaveApplication findLeaveApplication(String companyId, String leaveApplicationId)  throws ServiceException {
		try{
			return leaveApplicationDao.findLeaveApplication(companyId, leaveApplicationId);
		}catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
	}

	@Override
	public void insertLeaveApplication(
			LeaveApplication leaveApplication)  throws ServiceException {
		 try {
			leaveApplicationDao.insertLeaveApplication(leaveApplication);
			addEmailTask(leaveApplication,"new");
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
		 
	}

	@Override
	public String formEmailSubjectToApplicant(LeaveApplication leaveApplication, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formEmailContentToApplicant(LeaveApplication leaveApplication, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formEmailSubjectToApprover(LeaveApplication leaveApplication, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formEmailContentToApprover(LeaveApplication leaveApplication, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upadateLeaveApplication(LeaveApplication leaveApplication)  throws ServiceException {
		try {
			leaveApplicationDao.updateLeaveApplication(leaveApplication);
			addEmailTask(leaveApplication,"update");
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
		
	}

	@Override
	public void deleteLeaveApplication(LeaveApplication leaveApplication)  throws ServiceException {
		try {
			leaveApplicationDao.deleteLeaveApplication(leaveApplication);
			addEmailTask(leaveApplication,"delete");
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
		
		 
	}

	@Override
	public List<LeaveApplication> findAllLeaveApplicationByEmployee(Employee employee) throws ServiceException {
		try {
			return leaveApplicationDao.findAllLeaveApplicationsByEmployee(employee);
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
	}
	
	private void addEmailTask(LeaveApplication leaveApplication, String type) {

		 Queue queue = QueueFactory.getQueue("EmailQueue");
		 TaskOptions taskOptions = TaskOptions.Builder.withUrl("/email")
				 				  .param("companyId", leaveApplication.getCompany().getCompanyId())
		                          .param("leaveApplicationId", leaveApplication.getApplicationId())
		                          .param("notificationType", type)
		                          .method(Method.POST);
		 queue.add(taskOptions);
	}

	@Override
	public void approveApplication(LeaveApplication leaveApplication)  throws ServiceException {
		//TODO refine
		try {
			leaveApplicationDao.updateLeaveApplication(leaveApplication);
			addEmailTask(leaveApplication, "approve");
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
		
	}

	@Override
	public void rejectApplication(LeaveApplication leaveApplication)  throws ServiceException{
		//TODO refine
		try {
			leaveApplicationDao.updateLeaveApplication(leaveApplication);
			addEmailTask(leaveApplication,"reject");
		} catch (DAOException e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new ServiceException();
		}
		
		
	}

	
}
