package ro.fmi.bnk.rest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.models.TaskModel;
import ro.fmi.bnk.rest.utils.GenericListResponse;
import ro.fmi.bnk.rest.utils.GenericResponse;
import ro.fmi.bnk.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskRest {
	@Autowired
	private TaskService taskBean;

	@RequestMapping(value = "/getPendingTasks", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<TaskModel> getPendingTasks() {
		GenericListResponse<TaskModel> toReturn = new GenericListResponse<TaskModel>();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			toReturn.setData(taskBean.getPendingTasks(userName));
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	@RequestMapping(value = "/claimTask", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public GenericResponse<Boolean> claimTask(@RequestBody Long taskID) {
		GenericResponse<Boolean> toReturn = new GenericResponse<Boolean>();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		try {
		taskBean.claimTask(taskID,userName);
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	@RequestMapping(value = "/approveTask", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public GenericResponse<String> approveTask(@RequestBody Long taskID) {
		GenericResponse<String> toReturn = new GenericResponse<String>();

		try {
			toReturn.setData(taskBean.approveTask(taskID)); 
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
	
	@RequestMapping(value = "/rejectTask", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public GenericResponse<String> rejectTask(@RequestBody Long taskID) {
		GenericResponse<String> toReturn = new GenericResponse<String>();

		try {
			toReturn.setData(taskBean.rejectTask(taskID)); 
			toReturn.setStatus("OK");
		} catch (Exception e) {
			toReturn.setStatus("Exception Occured");
			toReturn.setMessage(e.getMessage());
		}
		return toReturn;
	}
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
