package ro.fmi.bnk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.UserDAO;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.SendMailInputModel;
import ro.fmi.bnk.service.UtilsService;

@Service("utilsService")
public class UtilsServiceImpl implements UtilsService{
	@Autowired
	private MailSender mailSender;
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void sendEmail(SendMailInputModel inp, String userName) {
		
		User currentUser=userDAO.getUserByUsername(userName);
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("bankoflic@gmail.com");
		message.setTo(currentUser.getEmail());
		message.setSubject(inp.getSubject());
		message.setText(inp.getBody());
		mailSender.send(message);
	}

}
