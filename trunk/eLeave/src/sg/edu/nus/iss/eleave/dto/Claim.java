package sg.edu.nus.iss.eleave.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Claim {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String claimId;
	
	@Persistent
	private Company company;
	
	@Persistent
	private Employee employee;
	//private LeaveType leave;
	//private Date OTDate;
	@Persistent
	private int month;//yymm
	//private double OTHours;
	@Persistent
	private double totalOTHours;
	@Persistent
	private String status;//D=draft;S=Submited;A=Approved
	@Persistent
	private Date applyDate;
	@Persistent
	private Date processDate;
	@Persistent
	private String processComment;
	@Persistent
	private List<ClaimItem> claimItems=new ArrayList<ClaimItem>();
	
	
	
	public String getClaimId() {
		return claimId;
	}
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public double getTotalOTHours() {
		return totalOTHours;
	}
	public void setTotalOTHours(double totalOTHours) {
		this.totalOTHours = totalOTHours;
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
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public String getProcessComment() {
		return processComment;
	}
	public void setProcessComment(String processComment) {
		this.processComment = processComment;
	}
	public List<ClaimItem> getClaimItems() {
		return claimItems;
	}
	public void setClaimItems(List<ClaimItem> claimItems) {
		this.claimItems = claimItems;
	}	
	public void addClaimItem(ClaimItem claimItem)
	{
	    claimItems.add(claimItem);
	}
}
