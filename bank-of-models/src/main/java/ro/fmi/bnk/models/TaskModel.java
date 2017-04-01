package ro.fmi.bnk.models;

import java.util.Date;


public class TaskModel {
	private Long id;
	private String description;
	private Date creationDate;
	private String taskStatus;
	private String taskType;

	public TaskModel() {
		super();
	}

	public TaskModel(Long id, String description, Date creationDate, String taskStatus, String taskType) {
		super();
		this.id = id;
		this.description = description;
		this.creationDate = creationDate;
		this.taskStatus = taskStatus;
		this.taskType = taskType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

}
