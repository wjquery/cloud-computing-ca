package sg.edu.nus.iss.eleave.dto;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class LeaveEntitlement {
	
	public static final String KIND = "LeaveEntitlement";
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String leaveEntitlementId;
	@Persistent
	private String employeeId; // one-to-one relationship with employee
	@Persistent
	private int year;
	@Persistent
	private String leaveTypeId; // foreign key to LeaveType
	@Persistent
	private double entitled;
	@Persistent
	private double balance;
	
	public String getLeaveEntitlementId() {
		return leaveEntitlementId;
	}
	public void setLeaveEntitlementId(String leaveEntitlementId) {
		this.leaveEntitlementId = leaveEntitlementId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public double getEntitled() {
		return entitled;
	}
	public void setEntitled(double entitled) {
		this.entitled = entitled;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LeaveEntitlement(String leaveEntitlementId, String employeeId,
			int year, String leaveTypeId, double entitled, double balance) {
		super();
		this.leaveEntitlementId = leaveEntitlementId;
		this.employeeId = employeeId;
		this.year = year;
		this.leaveTypeId = leaveTypeId;
		this.entitled = entitled;
		this.balance = balance;
	}
	public LeaveEntitlement() {
		super();
	}
	
}
