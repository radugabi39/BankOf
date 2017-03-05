package ro.fmi.bnk.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.models.AccountModel;
import ro.fmi.bnk.models.InOutComeModel;
import ro.fmi.bnk.rest.utils.GenericListResponse;
import ro.fmi.bnk.rest.utils.GenericResponse;
import ro.fmi.bnk.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountRest {
	@Autowired
	private AccountService accountBean;

	@RequestMapping(value = "/getAccounts", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<AccountModel> getAccounts() {
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		GenericListResponse<AccountModel> toReturn = new GenericListResponse<AccountModel>();
		try {
			toReturn.setData(accountBean.getAccounts(userName));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	
	@RequestMapping(value = "/getAccountByNo/{accNo}", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<AccountModel> getAccountByNo(@PathVariable String accNo) {
		GenericListResponse<AccountModel> toReturn = new GenericListResponse<AccountModel>();
		try {
			toReturn.setData(accountBean.getAccountByNo(accNo));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}

	
	@RequestMapping(value = "/getActiveAccounts", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<String> getActiveAccounts() {
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		GenericListResponse<String> toReturn = new GenericListResponse<String>();
		try {
			toReturn.setData(accountBean.getActiveAccounts(userName));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	
	@RequestMapping(value = "/getInOutcomeFromLastMonths/{accNo}/{months}", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericResponse<InOutComeModel> getInOutcomeFromLastMonths(@PathVariable String accNo,@PathVariable int months) {
		GenericResponse<InOutComeModel> toReturn = new GenericResponse<InOutComeModel>();
		try {
			toReturn.setData(accountBean.getInOutcomeFromLastMonths(months, accNo));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	
	@RequestMapping(value = "/getAccountsNo", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<String> getAccountsNo() {
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		GenericListResponse<String> toReturn = new GenericListResponse<String>();
		try {
			toReturn.setData(accountBean.getAccountsNo(userName));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
}
