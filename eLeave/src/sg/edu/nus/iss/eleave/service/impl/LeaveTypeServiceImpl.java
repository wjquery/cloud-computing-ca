package sg.edu.nus.iss.eleave.service.impl;

import java.util.List;

import sg.edu.nus.iss.eleave.dao.LeaveTypeDAO;
import sg.edu.nus.iss.eleave.dao.gaeds.LeaveTypeDAOImpl;
import sg.edu.nus.iss.eleave.dto.LeaveType;
import sg.edu.nus.iss.eleave.exception.DAOException;
import sg.edu.nus.iss.eleave.exception.ServiceException;
import sg.edu.nus.iss.eleave.service.LeaveTypeService;

public class LeaveTypeServiceImpl implements LeaveTypeService {

	private LeaveTypeDAO leaveTypeDAO = new LeaveTypeDAOImpl();
	public LeaveTypeDAO getLeaveTypeDAO() {
		return leaveTypeDAO;
	}
	public void setLeaveTypeDAO(LeaveTypeDAO leaveTypeDAO) {
		this.leaveTypeDAO = leaveTypeDAO;
	}

	@Override
	public LeaveType findLeaveTypeById(String leaveTypeId) {
		return leaveTypeDAO.findLeaveTypeById(leaveTypeId);
	}

	@Override
	public List<LeaveType> findAllLeaveTypesByCompany(String companyId) {
		return leaveTypeDAO.findAllLeaveTypesByCompany(companyId);
	}

	@Override
	public List<LeaveType> findAllLeaveTypesByCompany(String companyId,
			int offset, int fetchSize) {
		return leaveTypeDAO.findAllLeaveTypesByCompany(companyId, offset, fetchSize);
	}

	@Override
	public void insertLeaveType(LeaveType leaveType) throws ServiceException {
		try {
			leaveTypeDAO.insertLeaveType(leaveType);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void updateLeaveType(LeaveType leaveType) throws ServiceException {
		try {
			leaveTypeDAO.updateLeaveType(leaveType);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void deleteLeaveType(LeaveType leaveType) throws ServiceException {
		try {
			leaveTypeDAO.deleteLeaveType(leaveType);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

}
