package sg.edu.nus.iss.eleave.dto;

import java.util.Date;

public class ClaimItem {
	String claimId;
	Date otDate;
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
