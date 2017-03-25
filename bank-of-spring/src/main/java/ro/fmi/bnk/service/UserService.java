package ro.fmi.bnk.service;

import java.util.List;
import java.util.Optional;

import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.PasswordModel;
import ro.fmi.bnk.models.UserModel;

public interface UserService {
	
	public List<User> getAllUsers();

	User authentificateUser(String userName, String password);
	
	UserModel getCurrentUserData(String userName);

	void saveUserData(UserModel inpModel, String username);

	String changePassword(PasswordModel inpModel, String username);
} 
