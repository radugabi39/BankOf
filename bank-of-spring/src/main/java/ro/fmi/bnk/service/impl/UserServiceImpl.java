package ro.fmi.bnk.service.impl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.UserDAO;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.PasswordModel;
import ro.fmi.bnk.models.UserModel;
import ro.fmi.bnk.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private MailSender mailSender;
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
		
	}
	@Override
	public User authentificateUser(String userName,String password) {
		return userDAO.checkUser(userName,password);
		
	}
	@Override
	public UserModel getCurrentUserData(String userName) {
		return userDAO.getCurrentUserData(userName);
	}
	@Override
	public void saveUserData(UserModel inpModel,String username) {
		userDAO.saveUserData(inpModel,username);
		
	}
	@Override
	public String changePassword(PasswordModel inpModel,String username) {
		return userDAO.changePassword(inpModel,username);
		
	}
	@Override
	public UserModel getUserDataByCNP(String cnp) {
		return userDAO.getUserDataByCNP(cnp);
	}
	@Override
	public void saveUserDataAdm(UserModel inpModel) {
		userDAO.saveUserDataAdm(inpModel);
		
	}
	
	@Override
	public Boolean checkIfUserIsEmployee(String userName) {
		return userDAO.checkIfUserIsEmployee(userName);
		
	}
}
