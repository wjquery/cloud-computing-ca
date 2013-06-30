package sg.edu.nus.iss.eleave.dto;

public class LeaveType {

	private String leaveTypeId;
	private String name;
	private double defaultEntitlement;
	
	public String getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDefaultEntitlement() {
		return defaultEntitlement;
	}
	public void setDefaultEntitlement(double defaultEntitlement) {
		this.defaultEntitlement = defaultEntitlement;
	}
	
	public LeaveType() {
		super();
	}
	public LeaveType(String leaveTypeId, String name, double defaultEntitlement) {
		super();
		this.leaveTypeId = leaveTypeId;
		this.name = name;
		this.defaultEntitlement = defaultEntitlement;
	}
	
}
