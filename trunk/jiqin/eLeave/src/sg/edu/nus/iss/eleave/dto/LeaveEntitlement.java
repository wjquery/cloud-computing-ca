package sg.edu.nus.iss.eleave.dto;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class LeaveEntitlement {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String leaveEntitlementId;
	
	@Persistent
	private Employee employee;
	
	@Persistent
	private int year;
	
	@Persistent
	private LeaveType leaveType;
	
	@Persistent
	private double entitlement;
	
	@Persistent
	private double balance;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public double getEntitlement() {
		return entitlement;
	}
	public void setEntitlement(double entitlement) {
		this.entitlement = entitlement;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public LeaveEntitlement(Employee employee, int year, LeaveType leaveType,
			double entitlement, double balance) {
		super();
		this.employee = employee;
		this.year = year;
		this.leaveType = leaveType;
		this.entitlement = entitlement;
		this.balance = balance;
	}
	public LeaveEntitlement() {
		super();
	}
	
}
