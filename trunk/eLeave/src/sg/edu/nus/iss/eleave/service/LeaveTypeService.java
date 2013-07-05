package sg.edu.nus.iss.eleave.service;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.LeaveType;
import sg.edu.nus.iss.eleave.exception.ServiceException;

public interface LeaveTypeService {
	public LeaveType findLeaveTypeById(String leaveTypeId);
	
    public List<LeaveType> findAllLeaveTypesByCompany(String companyId);
    public List<LeaveType> findAllLeaveTypesByCompany(String companyId, int offset, int fetchSize);

    public void insertLeaveType(LeaveType leaveType) throws ServiceException;
    public void updateLeaveType(LeaveType leaveType) throws ServiceException;
    public void deleteLeaveType(LeaveType leaveType) throws ServiceException;
}
