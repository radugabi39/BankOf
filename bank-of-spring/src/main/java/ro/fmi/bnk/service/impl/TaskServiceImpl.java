package ro.fmi.bnk.service.impl;

import java.io.StringReader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.AccountDAO;
import ro.fmi.bnk.dao.repo.TaskDAO;
import ro.fmi.bnk.dao.repo.UserDAO;
import ro.fmi.bnk.enitites.Account;
import ro.fmi.bnk.enitites.Person;
import ro.fmi.bnk.enitites.Scheduler;
import ro.fmi.bnk.enitites.Task;
import ro.fmi.bnk.enitites.TaskStatus;
import ro.fmi.bnk.enitites.Transaction;
import ro.fmi.bnk.enitites.TransactionStatus;
import ro.fmi.bnk.enitites.TransactionType;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.AccountSaveModel;
import ro.fmi.bnk.models.TaskModel;
import ro.fmi.bnk.models.TaskStatusEnum;
import ro.fmi.bnk.models.TaskTypeEnum;
import ro.fmi.bnk.models.TransferInputModel;
import ro.fmi.bnk.service.TaskService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDAO taskDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AccountDAO accountDAO;

	@Override
	public List<TaskModel> getPendingTasks(String userName) {
		return taskDAO.getPendingTasks(userName);
	}

	@Override
	public void claimTask(Long taskId, String userName) {
		User usr = userDAO.getUserByUsername(userName);
		taskDAO.claimTask(taskId, usr);
	}
	@Override
	@Transactional
	public String rejectTask(Long taskId) {
		Task t = taskDAO.getByID(taskId);
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(TransferInputModel.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
			StringReader reader = new StringReader(t.getTransactionModifications());
			TransferInputModel obj = (TransferInputModel) unmarshaller.unmarshal(reader);
			Account myAcc = accountDAO.getAccountENTByNo(obj.getFromAccount());
			Account destAcc = accountDAO.getAccountENTByNo(obj.getDestAccount());
			t.setTaskStatus(taskDAO.getEntityByName(TaskStatus.class, TaskStatusEnum.REJECTED.toString()));
			Transaction newTrans = new Transaction();
			newTrans.setAccount(myAcc);
			newTrans.setDescription(obj.getTransDescription());
			newTrans.setDestinationAccount(destAcc);
			newTrans.setAmount(obj.getAmount());
			newTrans.setTransactionType(taskDAO.getEntityByName(TransactionType.class, "TRANSACTION"));
			newTrans.setTransactionStatus(taskDAO.getEntityByName(TransactionStatus.class, "REJECTED"));
			newTrans.setCreationDate(new Date());
			taskDAO.persist(newTrans);
			taskDAO.persist(t);
			return "OK";
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	@Transactional
	public String approveTask(Long taskId) {
		Task t = taskDAO.getByID(taskId);
		String taskType = t.getTaskType().getName();
		if (taskType.equals(TaskTypeEnum.LIMIT_ACCOUNT.toString())) {
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(AccountSaveModel.class);

				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

				StringReader reader = new StringReader(t.getTransactionModifications());
				AccountSaveModel obj = (AccountSaveModel) unmarshaller.unmarshal(reader);
				Account acc = accountDAO.getAccountENTByNo(obj.getAccNo());
				acc.setLimitAmount(obj.getLimit());
				taskDAO.persist(acc);
				t.setTaskStatus(taskDAO.getEntityByName(TaskStatus.class, TaskStatusEnum.COMPLETED.toString()));
				taskDAO.persist(t);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (taskType.equals(TaskTypeEnum.TRANSFER_HIGH_AMOUNT.toString())) {
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(TransferInputModel.class);

				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

				StringReader reader = new StringReader(t.getTransactionModifications());
				TransferInputModel obj = (TransferInputModel) unmarshaller.unmarshal(reader);
				Account myAcc = accountDAO.getAccountENTByNo(obj.getFromAccount());
				Account destAcc = accountDAO.getAccountENTByNo(obj.getDestAccount());
				if (myAcc.getBalance() != null && myAcc.getBalance().compareTo(obj.getAmount()) == -1) {
					return "No funds";
				}

				if (!destAcc.getAccountStatus().getName().equals("OPEN")) {
					return "Destination account is not active";
				}
				Transaction newTrans = new Transaction();
				newTrans.setAccount(myAcc);
				newTrans.setDescription(obj.getTransDescription());
				newTrans.setDestinationAccount(destAcc);
				newTrans.setAmount(obj.getAmount());
				newTrans.setTransactionType(taskDAO.getEntityByName(TransactionType.class, "TRANSACTION"));
				newTrans.setTransactionStatus(taskDAO.getEntityByName(TransactionStatus.class, "SUCCESS"));
				newTrans.setCreationDate(new Date());
				myAcc.setBalance(myAcc.getBalance().subtract(obj.getAmount()));
				destAcc.setBalance(destAcc.getBalance().add(obj.getAmount()));
				taskDAO.persist(destAcc);
				taskDAO.persist(myAcc);
				taskDAO.persist(newTrans);
				t.setTaskStatus(taskDAO.getEntityByName(TaskStatus.class, TaskStatusEnum.COMPLETED.toString()));
				taskDAO.persist(t);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "OK";

	}

}
