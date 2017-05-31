package ro.fmi.bnk.service;

import java.util.List;

import ro.fmi.bnk.models.TaskModel;

public interface TaskService {


	void claimTask(Long taskId,String userName);

	List<TaskModel> getPendingTasks(String userName);

	String approveTask(Long taskId);

	String rejectTask(Long taskId);

}
