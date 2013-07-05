package sg.edu.nus.iss.eleave.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sg.edu.nus.iss.eleave.dto.LeaveType;
import sg.edu.nus.iss.eleave.service.LeaveTypeService;
import sg.edu.nus.iss.eleave.service.impl.LeaveTypeServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class LeaveTypeAction extends ActionSupport {
	private static Logger log = Logger.getLogger(LeaveTypeAction.class.getCanonicalName());
	
	public String insert() throws Exception {
		LeaveType leaveType = new LeaveType();
		leaveType.setCompanyId("NTU");//TODO
		leaveType.setLeaveTypeId(leaveTypeId);
		leaveType.setName(leaveTypeName);
		leaveType.setDefaultEntitlement(defaultEntitlement);
		leaveTypeService.insertLeaveType(leaveType);
		return SUCCESS;
	}
	
	public String findAll() throws Exception {
		List<LeaveType> list = leaveTypeService.findAllLeaveTypesByCompany("NTU");//TODO
		log.log(Level.INFO, "@@@@@@@@@@@@" + list.size());
		session.setAttribute("leaveTypes", list); // TODO: save attr in request scope instead
		return SUCCESS;
	}
	
	public String findById() throws Exception {
		LeaveType leaveType = leaveTypeService.findLeaveTypeById(leaveTypeId);
		session.setAttribute("leaveType", leaveType);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		LeaveType leaveType = new LeaveType();
		leaveType.setCompanyId("NTU");//TODO
		leaveType.setLeaveTypeId(leaveTypeId);
		leaveType.setName(leaveTypeName);
		leaveType.setDefaultEntitlement(defaultEntitlement);
		leaveTypeService.updateLeaveType(leaveType);
		return SUCCESS;
	}
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	
	private LeaveTypeService leaveTypeService = new LeaveTypeServiceImpl();
	private String leaveTypeId;
	private String leaveTypeName;
	private String companyId = (String) session.getAttribute("companyId");
	private double defaultEntitlement;
	
	public LeaveTypeService getLeaveTypeService() {
		return leaveTypeService;
	}
	public void setLeaveTypeService(LeaveTypeService leaveTypeService) {
		this.leaveTypeService = leaveTypeService;
	}
	public String getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public String getLeaveTypeName() {
		return leaveTypeName;
	}
	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public double getDefaultEntitlement() {
		return defaultEntitlement;
	}
	public void setDefaultEntitlement(double defaultEntitlement) {
		this.defaultEntitlement = defaultEntitlement;
	}
	
}
