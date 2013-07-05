package sg.edu.nus.iss.eleave.service;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.ServiceException;

public interface LeaveApplicationService {
	
	public LeaveApplication findLeaveApplicationById(String leaveApplicationId);
	public List<LeaveApplication> findAllLeaveApplicationsByCompany(String companyId);
    public List<LeaveApplication> findAllLeaveApplicationsBySupervisor(String companyId, String supervisorId);
    public List<LeaveApplication> findPendingLeaveApplicationsBySupervisor(String companyId, String supervisorId);
    public List<LeaveApplication> findLeaveApplicationsHistoryBySupervisor(String companyId, String supervisorId);
    public List<LeaveApplication> findAllLeaveApplicationsByEmployee(String companyId, String employeeId);
	
	public void insertLeaveApplication(LeaveApplication leaveApplication) throws ServiceException;
	public void upadateLeaveApplication(LeaveApplication leaveApplication) throws ServiceException;
	public void deleteLeaveApplication(LeaveApplication leaveApplication) throws ServiceException;
	public void cancelLeaveApplication(LeaveApplication leaveApplication)  throws ServiceException;
	
	public void approveApplication(String applicationId);
	public void rejectApplication(String applicationId);
	
	//Email Related
	public String formEmailSubjectToApplicant(LeaveApplication leaveApplication, String type);
	public String formEmailContentToApplicant(LeaveApplication leaveApplication, String type);
	public String formEmailSubjectToApprover(LeaveApplication leaveApplication, String type);
	public String formEmailContentToApprover(LeaveApplication leaveApplication, String type);
	
	
}
