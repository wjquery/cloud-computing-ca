package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface LeaveApplicationDao {
	
	public LeaveApplication findLeaveApplicationById(String leaveApplicationId);
    public List<LeaveApplication> findAllLeaveApplications();
    
    public List<LeaveApplication> findAllLeaveApplicationsByCompany(String companyId);
    public List<LeaveApplication> findAllLeaveApplicationsBySupervisor(String companyId, String supervisorId);
    public List<LeaveApplication> findAllLeaveApplicationsByEmployee(String companyId, String employeeId);
    
    public void insertLeaveApplication(LeaveApplication leaveApplication) throws DAOException;
    public void updateLeaveApplication(LeaveApplication leaveApplication) throws DAOException;
    public void deleteLeaveApplication(LeaveApplication leaveApplication) throws DAOException;
}
