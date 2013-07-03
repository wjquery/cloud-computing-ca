package sg.edu.nus.iss.eleave.dto;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ClaimItem {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	String claimId;
	
	@Persistent
	Date otDate;
	
	@Persistent
	Double otHour;
	
	public String getClaimId() {
		return claimId;
	}
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}
	public Date getOtDate() {
		return otDate;
	}
	public void setOtDate(Date otDate) {
		this.otDate = otDate;
	}
	public Double getOtHour() {
		return otHour;
	}
	public void setOtHour(Double otHour) {
		this.otHour = otHour;
	}
}
