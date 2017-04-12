package ro.fmi.bnk.rest.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.PasswordModel;
import ro.fmi.bnk.models.UserModel;
import ro.fmi.bnk.rest.utils.GenericResponse;
import ro.fmi.bnk.service.UserService;
import ro.fmi.bnk.service.UtilsService;

@RestController
@RequestMapping("/user")
public class UserRest {
	
	@Autowired
	private UserService userBean; 
	@Autowired
	private UtilsService utilsService; 

	
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
	
	@RequestMapping(value = "/getUserDataByCNP/{cnp}", method = RequestMethod.GET)
	@ResponseBody
	public GenericResponse<UserModel> getUserDataByCNP(@PathVariable String cnp) {
		GenericResponse<UserModel> toReturn = new GenericResponse<UserModel>();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			toReturn.setData(userBean.getUserDataByCNP(cnp));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	
	@RequestMapping(value = "/saveUserDataAdm", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse<Boolean> saveUserDataAdm(@RequestBody UserModel inpModel) {
		GenericResponse<Boolean> toReturn = new GenericResponse<Boolean>();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			userBean.saveUserDataAdm(inpModel);
//			toReturn.setData(userBean.getCurrentUserData(userName));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	
	@RequestMapping(value = "/resetPassword/{cnp}", method = RequestMethod.GET)
	@ResponseBody
	public GenericResponse<UserModel> resetPassword(@PathVariable String cnp) {
		GenericResponse<UserModel> toReturn = new GenericResponse<UserModel>();
		
		try {
			utilsService.sendEmailResetPass(cnp);
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	
	@RequestMapping(value = "/getProfileImage", method = RequestMethod.GET)
	@ResponseBody
	public GenericResponse<String> getProfileImage() {
		GenericResponse<String> toReturn = new GenericResponse<String>();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			toReturn.setData(utilsService.getProfileImage(userName));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	@RequestMapping(value = "/getUserName", method = RequestMethod.GET)
	@ResponseBody
	public GenericResponse<String> getUserName() {
		GenericResponse<String> toReturn = new GenericResponse<String>();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			toReturn.setData(userName);
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	 @RequestMapping(value = "/uploadProfileImage", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public GenericResponse<String> uploadProfileImage(HttpServletRequest request, HttpServletResponse response) throws IOException
	    {
			GenericResponse<String> toReturn = new GenericResponse<String>();
			String userName= SecurityContextHolder.getContext().getAuthentication().getName();
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			//		     HttpServletRequest originalRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//		     MultipartHttpServletRequest multiPartRequest = new DefaultMultipartHttpServletRequest(originalRequest);
		       Iterator<String> iterator = multipartRequest.getFileNames();
		     
		     MultipartFile file = multipartRequest.getFile(iterator.next());
		     utilsService.savePictureToDisk(file, userName);
			try {
				
			} catch (Exception e) {
				toReturn.setStatus("Exception Occured");
				toReturn.setMessage(e.getMessage());
			}
			return toReturn;

	    }
	 @RequestMapping(value = "/checkIfUserIsEmployee/{userName}", method = RequestMethod.GET)
		@ResponseBody
		public GenericResponse<Boolean> checkIfUserIsEmployee(@PathVariable String userName) {
			GenericResponse<Boolean> toReturn = new GenericResponse<Boolean>();
//			String userName= SecurityContextHolder.getContext().getAuthentication().getName();
			try {
				toReturn.setData(userBean.checkIfUserIsEmployee(userName));
				toReturn.setStatus("OK");
			} catch (Exception e) {
				toReturn.setStatus("Exception Occured");
				toReturn.setMessage(e.getMessage());
			}
			return toReturn;
		}
}