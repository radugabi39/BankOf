package ro.fmi.bnk.rest.userAuthentification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.service.UserService;

@RestController
@RequestMapping("/userAuthentification")
public class LoginRest {
	
	@Autowired
	private UserService userBean; 


}