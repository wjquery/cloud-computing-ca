package sg.edu.nus.iss.eleave.service;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.ServiceException;

public interface LeaveApplicationService {
	
	public LeaveApplication findLeaveApplication(String companyId, String leaveApplicationId) throws ServiceException;
	public List<LeaveApplication> findAllLeaveApplicationByEmployee(Employee employee) throws ServiceException;
	public List<LeaveApplication> findAllLeaveApplicationByEmployee(Employee employee, int year) throws ServiceException;
	
	public void insertLeaveApplication(LeaveApplication leaveApplication) throws ServiceException;
	public void upadateLeaveApplication(LeaveApplication leaveApplication) throws ServiceException;
	public void deleteLeaveApplication(LeaveApplication leaveApplication) throws ServiceException;
	
	
	
	public void approveApplication(LeaveApplication leaveApplication) throws ServiceException;
	public void rejectApplication(LeaveApplication leaveApplication) throws ServiceException;
	
	//Email Related
	public String formEmailSubjectToApplicant(LeaveApplication leaveApplication, String type);
	public String formEmailContentToApplicant(LeaveApplication leaveApplication, String type);
	public String formEmailSubjectToApprover(LeaveApplication leaveApplication, String type);
	public String formEmailContentToApprover(LeaveApplication leaveApplication, String type);
	
	
}
