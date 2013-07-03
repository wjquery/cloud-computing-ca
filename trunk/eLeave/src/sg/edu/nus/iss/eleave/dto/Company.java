package sg.edu.nus.iss.eleave.dto;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Company {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String companyId;
	
	@Persistent
	private String name;
	
	@Persistent
	private String address;
	
	@Persistent
	private String countryCode;
	
	@Persistent
	private String contactNo;
	
	@Persistent
	private String subcriptionType;
	
	public Company(String companyId, String name, String address,
			String countryCode, String contactNo, String subcriptionType) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.address = address;
		this.countryCode = countryCode;
		this.contactNo = contactNo;
		this.subcriptionType = subcriptionType;
	}
	public Company() {
		super();
	}
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getSubcriptionType() {
		return subcriptionType;
	}
	public void setSubcriptionType(String subcriptionType) {
		this.subcriptionType = subcriptionType;
	}
	
}
