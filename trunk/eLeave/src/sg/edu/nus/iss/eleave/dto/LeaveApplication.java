package sg.edu.nus.iss.eleave.dto;

import java.util.Date;

public class LeaveApplication {

	private String applicationId;
	private LeaveType type;
	private Date fromDate;
	private Date toDate;
	private double days;
	private String reason;
	private String contactDetail;
	private String status;
	private Date applyDate;
	private Date modifyDate;
	private Date processDate;
	private Employee approvedBy;
	private String processComment;
	
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public LeaveType getType() {
		return type;
	}
	public void setType(LeaveType type) {
		this.type = type;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
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
	public String getContactDetail() {
		return contactDetail;
	}
	public void setContactDetail(String contactDetail) {
		this.contactDetail = contactDetail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public Employee getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(Employee approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getProcessComment() {
		return processComment;
	}
	public void setProcessComment(String processComment) {
		this.processComment = processComment;
	}
	
	public LeaveApplication() {
		super();
	}
	public LeaveApplication(String applicationId, LeaveType type,
			Date fromDate, Date toDate, double days, String reason,
			String contactDetail, String status, Date applyDate,
			Date modifyDate, Date processDate, Employee approvedBy,
			String processComment) {
		super();
		this.applicationId = applicationId;
		this.type = type;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.days = days;
		this.reason = reason;
		this.contactDetail = contactDetail;
		this.status = status;
		this.applyDate = applyDate;
		this.modifyDate = modifyDate;
		this.processDate = processDate;
		this.approvedBy = approvedBy;
		this.processComment = processComment;
	}
	
}
