package ro.fmi.bnk.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.models.TransactionTableModel;
import ro.fmi.bnk.models.TransferInputModel;
import ro.fmi.bnk.rest.utils.GenericListResponse;
import ro.fmi.bnk.rest.utils.GenericResponse;
import ro.fmi.bnk.service.TransactionService;


@RestController
@RequestMapping("/transaction")
public class TransactionRest {

	@Autowired
	private TransactionService transactionBean;

	@RequestMapping(value = "/getTransactionsByAccNo/{accNo}", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<TransactionTableModel> getTransactionsByAccNo(@PathVariable String accNo) {
		GenericListResponse<TransactionTableModel> toReturn = new GenericListResponse<TransactionTableModel>();
		try {
			toReturn.setData(transactionBean.getTransactionsByAccNo(accNo));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	
	@RequestMapping(value = "/tryTransfer", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public GenericResponse<String> tryTransfer(@RequestBody TransferInputModel inpModel) {
		GenericResponse<String> toReturn = new GenericResponse<String>();
		try {
			toReturn.setData(transactionBean.tryTransaction(inpModel));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
}
