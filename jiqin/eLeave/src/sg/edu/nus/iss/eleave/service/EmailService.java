package sg.edu.nus.iss.eleave.service;

import java.util.List;
import sg.edu.nus.iss.eleave.exception.ServiceException;


public interface EmailService {
	public void sendEmail(String fromAddress, List<String> toAddresses, String subject, String content) throws ServiceException;
	public void sendEmail(String fromAddress, String toAddress, String subject, String content) throws ServiceException;
}
