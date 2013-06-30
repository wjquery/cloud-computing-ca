package sg.edu.nus.iss.eleave.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import sg.edu.nus.iss.eleave.exception.ServiceException;
import sg.edu.nus.iss.eleave.service.EmailService;

public class EmailServiceImpl implements EmailService {
	private static Logger log = Logger.getLogger(EmailServiceImpl.class.getCanonicalName());
	
	@Override
	public void sendEmail(String fromAddress, List<String> toAddresses,
			String subject, String content) throws ServiceException{
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		try {
		  Message msg = new MimeMessage(session);
		  msg.setFrom(new InternetAddress(fromAddress));
		  List<Address> toAddrs = new ArrayList<Address>();
		  for(String toAddress: toAddresses){
			  InternetAddress toAddr = new InternetAddress(toAddress);
			  toAddrs.add(toAddr);
		  }
		  Address[] to = toAddrs.toArray(new Address[toAddrs.size()]);
		  msg.addRecipients(Message.RecipientType.TO, to);
		  msg.setSubject(subject);
		  msg.setText(content);
		  Transport.send(msg, to);
		} catch (AddressException addressException) {
		  log.log(Level.SEVERE, "Address Exception , mail could not be sent", addressException);
		  throw new ServiceException();
		} catch (MessagingException messageException) {
		  log.log(Level.SEVERE, "Messaging Exception , mail could not be sent", messageException);
		  throw new ServiceException();
		}

	}

	@Override
	public void sendEmail(String fromAddress, String toAddress, String subject,
			String content)  throws ServiceException{
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		try {
		  Message msg = new MimeMessage(session);
		  msg.setFrom(new InternetAddress(fromAddress));
		  
		InternetAddress to = new InternetAddress(toAddress);
			  
		  
		  
		  msg.addRecipient(Message.RecipientType.TO, to);
		  msg.setSubject(subject);
		  msg.setText(content);
		  Transport.send(msg, new InternetAddress[]{to});
		} catch (AddressException addressException) {
		  log.log(Level.SEVERE, "Address Exception , mail could not be sent", addressException);
		  throw new ServiceException();
		} catch (MessagingException messageException) {
		  log.log(Level.SEVERE, "Messaging Exception , mail could not be sent", messageException);
		  throw new ServiceException();
		}
		
	}

}
