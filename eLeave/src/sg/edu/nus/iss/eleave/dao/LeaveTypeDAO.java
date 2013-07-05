package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.LeaveType;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface LeaveTypeDAO {
	public LeaveType findLeaveTypeById(String leaveTypeId);
	
    public List<LeaveType> findAllLeaveTypesByCompany(String companyId);
    public List<LeaveType> findAllLeaveTypesByCompany(String companyId, int offset, int fetchSize);

    public void insertLeaveType(LeaveType leaveType) throws DAOException;
    public void updateLeaveType(LeaveType leaveType) throws DAOException;
    public void deleteLeaveType(LeaveType leaveType) throws DAOException;
}
