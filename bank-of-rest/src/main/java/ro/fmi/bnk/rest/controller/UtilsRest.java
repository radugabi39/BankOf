package ro.fmi.bnk.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.models.SendMailInputModel;
import ro.fmi.bnk.rest.utils.GenericResponse;
import ro.fmi.bnk.service.UtilsService;

@RestController
@RequestMapping("/utils")
public class UtilsRest {
	
	@Autowired
	private UtilsService utilsBean;

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public GenericResponse<Boolean> sendEmail(@RequestBody SendMailInputModel inpModel) {
		GenericResponse<Boolean> toReturn = new GenericResponse<Boolean>();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		try{
			utilsBean.sendEmail(inpModel,userName);
		}catch(Exception e){
			toReturn.setData(false);
			return toReturn;
		}
		
		toReturn.setData(true);
		return toReturn;
		
	}
}
