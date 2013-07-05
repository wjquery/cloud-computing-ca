package sg.edu.nus.iss.eleave.dto;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class LeaveApplication implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String PENDING = "pending";
	public static final String APPROVED = "approved";
	public static final String REJECTED = "rejected";
	public static final String CANCELLED = "cancelled";
	public static final String EXPIRED = "expired";
	public static final String MODIFIED = "modified";
	public static final String KIND = "LeaveApplication";
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String applicationId;
	@Persistent
	private String leaveTypeId; // foreign key to LeaveType
	@Persistent
	private Date fromDate;
	@Persistent
	private Date toDate;
	@Persistent
	private double days;
	@Persistent
	private String reason;
	@Persistent
	private String status;
	@Persistent
	private Date applyDate;
	@Persistent
	private Date modifyDate;
	@Persistent
	private Date processDate;
	@Persistent
	private String applicantId; // many-to-one relationship with employee
	@Persistent
	private String processedById; // foreign key to employee
	@Persistent
	private String processComment;
	
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
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
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getProcessedById() {
		return processedById;
	}
	public void setProcessedById(String processedById) {
		this.processedById = processedById;
	}
	public String getProcessComment() {
		return processComment;
	}
	public void setProcessComment(String processComment) {
		this.processComment = processComment;
	}
	
	public LeaveApplication(String applicationId, String leaveTypeId,
			Date fromDate, Date toDate, double days, String reason,
			String status, Date applyDate, Date modifyDate, Date processDate,
			String applicantId, String processedById, String processComment) {
		super();
		this.applicationId = applicationId;
		this.leaveTypeId = leaveTypeId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.days = days;
		this.reason = reason;
		this.status = status;
		this.applyDate = applyDate;
		this.modifyDate = modifyDate;
		this.processDate = processDate;
		this.applicantId = applicantId;
		this.processedById = processedById;
		this.processComment = processComment;
	}
	public LeaveApplication() {
		super();
	}
	
	@Override
	public String toString() {
		return "LeaveApplication [applicationId=" + applicationId
				+ ", leaveTypeId=" + leaveTypeId + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", days=" + days + ", reason="
				+ reason + ", status=" + status + ", applyDate=" + applyDate
				+ ", modifyDate=" + modifyDate + ", processDate=" + processDate
				+ ", applicantId=" + applicantId + ", processedById="
				+ processedById + ", processComment=" + processComment + "]";
	}
	
}
