package ro.fmi.bnk.rest.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.PasswordModel;
import ro.fmi.bnk.models.UserModel;
import ro.fmi.bnk.rest.utils.GenericResponse;
import ro.fmi.bnk.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRest {
	
	@Autowired
	private UserService userBean; 

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {
		return  userBean.getAllUsers();
	}
	
	@RequestMapping(value = "/getCurrentUserData", method = RequestMethod.GET)
	@ResponseBody
	public GenericResponse<UserModel> getCurrentUserData() {
		GenericResponse<UserModel> toReturn = new GenericResponse<UserModel>();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			toReturn.setData(userBean.getCurrentUserData(userName));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	@RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse<Boolean> saveUserData(@RequestBody UserModel inpModel) {
		GenericResponse<Boolean> toReturn = new GenericResponse<Boolean>();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			userBean.saveUserData(inpModel,userName);
//			toReturn.setData(userBean.getCurrentUserData(userName));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse<String> changePassword(@RequestBody PasswordModel inpModel) {
		GenericResponse<String> toReturn = new GenericResponse<String>();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			
			toReturn.setData(userBean.changePassword(inpModel,userName));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
}