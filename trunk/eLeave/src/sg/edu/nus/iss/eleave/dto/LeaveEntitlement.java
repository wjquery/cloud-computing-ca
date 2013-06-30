package sg.edu.nus.iss.eleave.dto;

public class LeaveEntitlement {
	
	private Employee employee;
	private int year;
	private LeaveType leaveType;
	private double entitlement;
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
