package sg.edu.nus.iss.eleave.controller;

import org.springframework.stereotype.Controller;

import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.service.LeaveApplicationService;
import sg.edu.nus.iss.eleave.service.impl.LeaveApplicationServiceImpl;
import sg.edu.nus.iss.eleave.util.DateUtil;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class LeaveApplicationAction extends ActionSupport {

	public String insert() throws Exception {
		LeaveApplication application = new LeaveApplication();
		application.setApplicantId(applicantId);
		application.setFromDate(DateUtil.parse(fromDate, "dd/MM/yyyy"));
		application.setToDate(DateUtil.parse(toDate, "dd/MM/yyyy"));
		application.setDays(days);
		application.setReason(reason);
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
		return SUCCESS;
	}
	
	public String findById() throws Exception {
		return SUCCESS;
	}
	
	public String findByEmployee() {
		return SUCCESS;
	}
	
	public String findPendingBySupervisor() {
		return SUCCESS;
	}
	
	public String findHistoryBySupervisor() {
		return SUCCESS;
	}
	
	private LeaveApplicationService leaveApplicationService = new LeaveApplicationServiceImpl();
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
