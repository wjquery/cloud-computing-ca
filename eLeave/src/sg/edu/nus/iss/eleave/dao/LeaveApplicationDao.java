package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface LeaveApplicationDao {
	
	public LeaveApplication findLeaveApplication(String leaveApplicationId) throws DAOException;
    public List<LeaveApplication> findAllLeaveApplications() throws DAOException;
    
    public List<LeaveApplication> findAllLeaveApplications(String applicantId) throws DAOException;
    
    public void insertLeaveApplication(LeaveApplication leaveApplication) throws DAOException;
    public void updateLeaveApplication(LeaveApplication leaveApplication) throws DAOException;
    public void deleteLeaveApplication(LeaveApplication leaveApplication) throws DAOException;
    
	
}
