package ro.fmi.bnk.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.models.BranchLocationModel;
import ro.fmi.bnk.rest.utils.GenericListResponse;
import ro.fmi.bnk.service.ContactService;
import ro.fmi.bnk.service.TaskService;

@RestController
@RequestMapping("/contact")
public class ContactRest {
	@Autowired
	private ContactService contactBean;

	@RequestMapping(value = "/getBranchesLocation", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<BranchLocationModel> getPendingTasks() {
		GenericListResponse<BranchLocationModel> toReturn = new GenericListResponse<BranchLocationModel>();

		try {
			toReturn.setData(contactBean.getBranchLocation());
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
}