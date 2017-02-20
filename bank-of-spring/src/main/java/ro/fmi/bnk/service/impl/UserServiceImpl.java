package ro.fmi.bnk.service.impl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.UserDAO;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
		
	}
	@Override
	public User authentificateUser(String userName,String password) {
		return userDAO.checkUser(userName,password);
		
	}

}
