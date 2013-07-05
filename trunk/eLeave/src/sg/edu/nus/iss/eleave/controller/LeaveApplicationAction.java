package sg.edu.nus.iss.eleave.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.dto.LeaveType;
import sg.edu.nus.iss.eleave.service.EmployeeService;
import sg.edu.nus.iss.eleave.service.LeaveApplicationService;
import sg.edu.nus.iss.eleave.service.LeaveTypeService;
import sg.edu.nus.iss.eleave.service.impl.EmployeeServiceImpl;
import sg.edu.nus.iss.eleave.service.impl.LeaveApplicationServiceImpl;
import sg.edu.nus.iss.eleave.service.impl.LeaveTypeServiceImpl;
import sg.edu.nus.iss.eleave.util.DateUtil;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class LeaveApplicationAction extends ActionSupport {

	private static Logger log = Logger.getLogger(LeaveApplicationAction.class.getCanonicalName());
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private String companyId = (String) session.getAttribute("companyId");
	private String myId = (String) session.getAttribute("myId");
	
	public String insert() throws Exception {
		String supervisorId = employeeService.findEmployee(myId).getSupervisorId();
		
		LeaveApplication application = new LeaveApplication();
		application.setApplicantId(myId);
		application.setLeaveTypeId(leaveTypeId);
		application.setFromDate(DateUtil.parse(fromDate, "dd/MM/yyyy"));
		application.setToDate(DateUtil.parse(toDate, "dd/MM/yyyy"));
		application.setDays(days);
		application.setReason(reason);
		application.setProcessedById(supervisorId);
		log.log(Level.INFO, application.toString());
		leaveApplicationService.insertLeaveApplication(application);
		return SUCCESS;
	}
	
	public String approve() throws Exception {
		return SUCCESS;
	}
	
	public String reject() throws Exception {
		return SUCCESS;
	}
	
	public String update() throws Exception {
		LeaveApplication application = new LeaveApplication();
		application.setApplicantId(myId);
		application.setLeaveTypeId(leaveTypeId);
		application.setFromDate(DateUtil.parse(fromDate, "dd/MM/yyyy"));
		application.setToDate(DateUtil.parse(toDate, "dd/MM/yyyy"));
		application.setDays(days);
		application.setReason(reason);
		leaveApplicationService.upadateLeaveApplication(application);
		return SUCCESS;
	}
	
	public String findById() throws Exception {
		String searchId = request.getParameter("id");
		String type = request.getParameter("type");
		LeaveApplication application = leaveApplicationService.findLeaveApplicationById(searchId);
		session.setAttribute("appDetails", application);
		session.setAttribute("t", type);
		if (LeaveApplication.PENDING.equals(application.getStatus()))
			return SUCCESS;
		else
			return NONE;
	}
	
	public String findByEmployee() throws Exception {
		List<LeaveApplication> applications = leaveApplicationService.findAllLeaveApplicationsByEmployee(companyId, myId);
		List<LeaveType> types = new ArrayList<LeaveType>();
		for (LeaveApplication app : applications) {
			log.log(Level.INFO, "Leave Application retrieved, Id: " + app.getApplicationId());
			types.add(leaveTypeService.findLeaveTypeById(app.getLeaveTypeId()));
		}
		session.setAttribute("myApplications", applications);
		session.setAttribute("types", types);
		return SUCCESS;
	}
	
	public String findPendingBySupervisor() throws Exception {
		List<LeaveApplication> pending = leaveApplicationService.findPendingLeaveApplicationsBySupervisor(companyId, myId);
		session.setAttribute("pending", pending);
		return SUCCESS;
	}
	
	public String findHistoryBySupervisor() throws Exception {
		List<LeaveApplication> history = leaveApplicationService.findAllLeaveApplicationsBySupervisor(companyId, myId);
		session.setAttribute("history", history);
		return SUCCESS;
	}
	
	private LeaveApplicationService leaveApplicationService = new LeaveApplicationServiceImpl();
	private LeaveTypeService leaveTypeService = new LeaveTypeServiceImpl();
	private EmployeeService employeeService = new EmployeeServiceImpl();
	private String leaveTypeId;
	private String fromDate;
	private String toDate;
	private double days;
	private String reason;
	private String status;
	private String processComment;
	private String processById;
	private String applicantId;
	private String applyDate;
	private String modifyDate;
	private String processDate;
	
	public LeaveApplicationService getLeaveApplicationService() {
		return leaveApplicationService;
	}
	public void setLeaveApplicationService(
			LeaveApplicationService leaveApplicationService) {
		this.leaveApplicationService = leaveApplicationService;
	}
	public LeaveTypeService getLeaveTypeService() {
		return leaveTypeService;
	}
	public void setLeaveTypeService(LeaveTypeService leaveTypeService) {
		this.leaveTypeService = leaveTypeService;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public double getDays() {
		return days;
	}
	public void setDays(double days) {
		this.days = days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProcessComment() {
		return processComment;
	}
	public void setProcessComment(String processComment) {
		this.processComment = processComment;
	}
	public String getProcessById() {
		return processById;
	}
	public void setProcessById(String processById) {
		this.processById = processById;
	}
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	
}
