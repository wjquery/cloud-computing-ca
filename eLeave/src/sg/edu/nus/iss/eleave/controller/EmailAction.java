package sg.edu.nus.iss.eleave.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import sg.edu.nus.iss.eleave.dto.Employee;
import sg.edu.nus.iss.eleave.dto.LeaveApplication;
import sg.edu.nus.iss.eleave.service.EmailService;
import sg.edu.nus.iss.eleave.service.LeaveApplicationService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class EmailAction extends ActionSupport implements ServletRequestAware  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//TODO figure out the email address used by GAE
	private static final String fromAddress = "noapply@gmail.com";
	private EmailService emailService;
	private LeaveApplicationService leaveApplicationService;
	private HttpServletRequest request;
	@Override
	public String execute() throws Exception {
//		//READ the task from EmailTaskQueue, then calling email Service to send out email
//		String companyId = request.getParameter("companyId");
//		String leaveApplicationId = request.getParameter("leaveApplicationId");
//		String type = request.getParameter("notificationType");
//		//find the LeaveAppliation
//		LeaveApplication leaveApplication = leaveApplicationService.findLeaveApplication(companyId, leaveApplicationId);
//		if(leaveApplication != null){
//			Employee applicant = leaveApplication.getApplicant();
//			String subject = leaveApplicationService.formEmailSubjectToApplicant(leaveApplication, type);
//			String content = leaveApplicationService.formEmailContentToApplicant(leaveApplication, type);
//			emailService.sendEmail(fromAddress, applicant.getEmail(), subject, content);
//			
//			//send to supervisor
//			subject = leaveApplicationService.formEmailSubjectToApprover(leaveApplication, type);
//			content = leaveApplicationService.formEmailContentToApprover(leaveApplication, type);
//			List<String> emails = new ArrayList<String>();
//			for(Employee manager: applicant.getSupervisors()){
//				emails.add(manager.getEmail());
//			}
//			emailService.sendEmail(fromAddress, emails, subject, content);
//		}
		
		return Action.SUCCESS;
		
	}
	


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	
	
	

}
