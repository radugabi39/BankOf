package ro.fmi.bnk.rest.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRest {
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	@ResponseBody
	public String getAllUsers() {
		String result = "Helloto dineshonjava.com!!!";
		return result;
	}
}