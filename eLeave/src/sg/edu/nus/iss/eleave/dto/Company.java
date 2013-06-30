package sg.edu.nus.iss.eleave.dto;

public class Company {

	private String companyId;
	private String name;
	private String address;
	private String countryCode;
	private String contactNo;
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
