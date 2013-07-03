package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface LeaveApplicationDao {
	
	public LeaveApplication findLeaveApplication(String companyId, String leaveApplicationId) throws DAOException;
    public List<LeaveApplication> findAllLeaveApplications() throws DAOException;
    
    public List<LeaveApplication> findAllLeaveApplicationsByCompany(String companyId) throws DAOException;
    public List<LeaveApplication> findAllLeaveApplicationsByEmployee(Employee employee) throws DAOException;
    public List<LeaveApplication> findAllLeaveApplicationsByEmployee(Employee employee, int year) throws DAOException;
    
    public void insertLeaveApplication(LeaveApplication leaveApplication) throws DAOException;
    public void updateLeaveApplication(LeaveApplication leaveApplication) throws DAOException;
    public void deleteLeaveApplication(LeaveApplication leaveApplication) throws DAOException;
}
