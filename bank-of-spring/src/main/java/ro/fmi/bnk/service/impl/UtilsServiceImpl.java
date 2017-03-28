package ro.fmi.bnk.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.UserDAO;
import ro.fmi.bnk.dao.repo.UtilsDAO;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.CountryCityMapping;
import ro.fmi.bnk.models.SendMailInputModel;
import ro.fmi.bnk.service.UtilsService;

@Service("utilsService")
public class UtilsServiceImpl implements UtilsService{
	@Autowired
	private MailSender mailSender;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UtilsDAO utilsDAO;
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
	@Override
	public void sendEmailResetPass(String cnp) {
		String generatedPass=UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
	
		SimpleMailMessage message = new SimpleMailMessage();
		String email=userDAO.changePasswordAndReturnEmailToSend(cnp, generatedPass);
		message.setFrom("bankoflic@gmail.com");
		message.setTo(email);
		message.setSubject("Reset password");
		message.setText("Generated password: "+ generatedPass);
		mailSender.send(message);
	}
	
	@Override
	public List<CountryCityMapping> getCountryCityMapping() {
		return utilsDAO.getCountryCityMapping();
	}
	
	
	@Override
	public List<String> getNomData(String className) {
		return utilsDAO.getNomData(className);
	}
}
