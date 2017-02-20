package ro.fmi.bnk.rest.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.enitites.User;
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
}