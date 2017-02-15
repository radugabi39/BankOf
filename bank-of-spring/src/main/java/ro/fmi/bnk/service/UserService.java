package ro.fmi.bnk.service;

import java.util.List;
import java.util.Optional;

import ro.fmi.bnk.enitites.User;

public interface UserService {
	
	public List<User> getAllUsers();

	User authentificateUser(String userName, String password);
}
