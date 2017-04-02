package ro.fmi.bnk.rest.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.models.CountryCityMapping;
import ro.fmi.bnk.models.SendMailInputModel;
import ro.fmi.bnk.models.TransactionTableModel;
import ro.fmi.bnk.rest.utils.GenericListResponse;
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
	@RequestMapping(value = "/getCountryCityMapping", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<CountryCityMapping> getCountryCityMapping() {
		GenericListResponse<CountryCityMapping> toReturn = new GenericListResponse<CountryCityMapping>();
		toReturn.setData(utilsBean.getCountryCityMapping());

		return toReturn;
		
	}
	@RequestMapping(value = "/getNomData/{entityName}", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<String> getNomData(@PathVariable String entityName) {
		GenericListResponse<String> toReturn = new GenericListResponse<String>();
		toReturn.setData(utilsBean.getNomData(entityName));

		return toReturn;
		
	}
	@RequestMapping(value = "/downloadExcell/{accNo}", method = RequestMethod.GET)
	@ResponseBody
	public void getFile(
			@PathVariable String accNo,
	    HttpServletResponse response) {
	    try {
	      // get your file as InputStream
	      InputStream is = utilsBean.getExcell(accNo);
	      // copy it to response's OutputStream
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	      response.flushBuffer();
	    } catch (Exception ex) {
//	      log.info("Error writing file to output stream. Filename was '{}'", fileName, ex);
	      throw new RuntimeException("IOError writing file to output stream");
	    }

	}

}
