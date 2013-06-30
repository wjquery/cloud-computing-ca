package sg.edu.nus.iss.eleave.dto;

import java.util.Date;
import java.util.List;

public class Employee {

	private String employeeId;
	private String name;
	private Department deparment;
	private List<Employee> supervisors;
	private Date joinDate;
	private Date resignDate;
	private String Designation;
	private String email;
	private String username;
	private String password;
	private boolean isActive;
	private List<LeaveApplication> leave;
	
}
