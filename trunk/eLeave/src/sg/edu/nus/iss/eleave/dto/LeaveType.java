package sg.edu.nus.iss.eleave.dto;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class LeaveType {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String leaveTypeId;
	@Persistent
	private String name;
	@Persistent
	private double defaultEntitlement;
	@Persistent
	private String companyId;
	
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
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public LeaveType(String leaveTypeId, String name,
			double defaultEntitlement, String companyId) {
		super();
		this.leaveTypeId = leaveTypeId;
		this.name = name;
		this.defaultEntitlement = defaultEntitlement;
		this.companyId = companyId;
	}
	public LeaveType() {
		super();
	}
	
}
