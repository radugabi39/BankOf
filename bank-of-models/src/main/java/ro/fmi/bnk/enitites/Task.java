package ro.fmi.bnk.enitites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {

	private Long id;
	private String name;
	private String description;
	private Date creationDate;
	private Date modificationDate;
	private TaskStatus taskStatus;
	private TaskType taskType;
	private String transactionModifications;
	private Boolean active;
	private User claimedByUser;
	public Task() {
		super();}
	public Task(Long id, String name, String description, Date creationDate, Date modificationDate,
			TaskStatus taskStatus, TaskType taskType, String transactionModifications, Boolean active,User claimedByUser) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.taskStatus = taskStatus;
		this.taskType = taskType;
		this.transactionModifications = transactionModifications;
		this.active = active;
		this.setClaimedByUser(claimedByUser);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CREATIONDATE")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "MODIFICATIONDATE")
	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASKSTATUS_ID")
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASKTYPE_ID")
	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	@Column(name = "TRANSACTIONMODIFICATIONS")
	public String getTransactionModifications() {
		return transactionModifications;
	}

	public void setTransactionModifications(String transactionModifications) {
		this.transactionModifications = transactionModifications;
	}

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLAIMEDBYUSER_ID")
	public User getClaimedByUser() {
		return claimedByUser;
	}
	public void setClaimedByUser(User claimedByUser) {
		this.claimedByUser = claimedByUser;
	}
	

}
