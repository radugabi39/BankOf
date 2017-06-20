package ro.fmi.bnk.service.impl;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Schedule;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.AccountDAO;
import ro.fmi.bnk.dao.repo.TransactionDAO;
import ro.fmi.bnk.enitites.Account;
import ro.fmi.bnk.enitites.Scheduler;
import ro.fmi.bnk.enitites.Task;
import ro.fmi.bnk.enitites.TaskStatus;
import ro.fmi.bnk.enitites.TaskType;
import ro.fmi.bnk.enitites.Transaction;
import ro.fmi.bnk.enitites.TransactionStatus;
import ro.fmi.bnk.enitites.TransactionType;
import ro.fmi.bnk.models.AccountSaveModel;
import ro.fmi.bnk.models.SchedulerModel;
import ro.fmi.bnk.models.TaskStatusEnum;
import ro.fmi.bnk.models.TaskTypeEnum;
import ro.fmi.bnk.models.TransactionTableModel;
import ro.fmi.bnk.models.TransferInputModel;
import ro.fmi.bnk.service.TransactionService;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	final String vodaNo = "10000001";
	final String rdsNo = "10000002";
	final String enelNo = "10000003";
	@Autowired
	private TransactionDAO transactionDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public List<TransactionTableModel> getTransactionsByAccNo(String accNo) {
		return transactionDAO.getTransactionsByAccNo(accNo);
	}

	@Override
	public List<TransactionTableModel> getAdminTransactionsByAccNo(String accNo) {
		return transactionDAO.getAdminTransactionsByAccNo(accNo);
	}

	@Override
	@Transactional
	public String reverseTransaction(TransactionTableModel inpModel) {
		try {
			Account myAcc = accountDAO.getAccountENTByNo(inpModel.getToAccount());
			if (myAcc.getBalance() != null && myAcc.getBalance().compareTo(inpModel.getAmount()) == -1) {
				return "No funds";
			}

			Account destAcc = accountDAO.getAccountENTByNo(inpModel.getFromAccount());
			if (!destAcc.getAccountStatus().getName().equals("OPEN")) {
				return "Destination account is not active";
			}
			myAcc.setBalance(myAcc.getBalance().subtract(inpModel.getAmount()));
			destAcc.setBalance(destAcc.getBalance().add(inpModel.getAmount()));
			Transaction newTrans = new Transaction();
			newTrans.setAccount(myAcc);
			newTrans.setDescription("Reversed transaction");
			newTrans.setDestinationAccount(destAcc);
			newTrans.setAmount(inpModel.getAmount());
			newTrans.setTransactionType(transactionDAO.getEntityByName(TransactionType.class, "TRANSACTION"));
			newTrans.setTransactionStatus(transactionDAO.getEntityByName(TransactionStatus.class, "SUCCESS"));
			newTrans.setCreationDate(new Date());
			transactionDAO.persist(destAcc);
			transactionDAO.persist(myAcc);
			transactionDAO.persist(newTrans);
			return "OK";

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	@Transactional
	public String tryTransaction(TransferInputModel inpModel) {
		try {
			Account myAcc = accountDAO.getAccountENTByNo(inpModel.getFromAccount());

			String accNoF = "";
			if (myAcc.getBalance() != null && myAcc.getBalance().compareTo(inpModel.getAmount()) == -1) {
				return "No funds";
			}
			if (inpModel.getProvider() != null && !inpModel.getProvider().equals("")) {
				if (inpModel.getProvider().equals("voda")) {
					accNoF = vodaNo;
				} else if (inpModel.getProvider().equals("rds")) {
					accNoF = rdsNo;
				} else if (inpModel.getProvider().equals("enel")) {
					accNoF = enelNo;
				}
			} else {
				accNoF = inpModel.getDestAccount();
			}
			Account destAcc = accountDAO.getAccountENTByNo(accNoF);
			if (destAcc.getCurrency() == null || myAcc.getCurrency() == null
					|| !destAcc.getCurrency().getName().equals(myAcc.getCurrency().getName())) {
				return "Not the same currency";
			}
			if (inpModel.getDateToPay() != null && !inpModel.getDateToPay().equals("")) {
				Scheduler newSc = new Scheduler();
				newSc.setActive(true);
				newSc.setAmount(inpModel.getAmount());
				newSc.setFromAccount(myAcc);
				newSc.setToAccount(destAcc);
				Calendar cal = Calendar.getInstance();
				cal.setTime(inpModel.getDateToPay());
				Date now = new Date();

				if (now.getDate()>inpModel.getDateToPay().getDate()) {
					cal.add(Calendar.MONTH, 1);
				}

				newSc.setNextPayment(
						new Date().before(inpModel.getDateToPay()) ? inpModel.getDateToPay() : cal.getTime());
				newSc.setCustomer(myAcc.getCustomer());
				transactionDAO.persist(newSc);
				return "OK";
			} else {

				if (!destAcc.getAccountStatus().getName().equals("OPEN")) {
					return "Destination account is not active";
				}

				if (myAcc.getLimitAmount().compareTo(inpModel.getAmount()) == -1) {
					String xmlString = "";

					try {
						JAXBContext context = JAXBContext.newInstance(TransferInputModel.class);

						Marshaller m = context.createMarshaller();

						m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

						StringWriter sw = new StringWriter();
						m.marshal(inpModel, sw);
						xmlString = sw.toString();
						Task newT = new Task();
						TaskStatus ts = transactionDAO.getEntityByName(TaskStatus.class,
								TaskStatusEnum.PENDING.toString());
						TaskType tt = transactionDAO.getEntityByName(TaskType.class,
								TaskTypeEnum.TRANSFER_HIGH_AMOUNT.toString());
						newT.setActive(true);
						newT.setDescription("High amount transfer");
						newT.setTaskStatus(ts);
						newT.setTaskType(tt);
						newT.setTransactionModifications(xmlString);
						transactionDAO.persist(newT);
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "transaction need to be approved";
				} else {
					myAcc.setBalance(myAcc.getBalance().subtract(inpModel.getAmount()));
					destAcc.setBalance(destAcc.getBalance().add(inpModel.getAmount()));
					Transaction newTrans = new Transaction();
					newTrans.setAccount(myAcc);
					newTrans.setDescription(inpModel.getTransDescription());
					newTrans.setDestinationAccount(destAcc);
					newTrans.setAmount(inpModel.getAmount());
					newTrans.setTransactionType(transactionDAO.getEntityByName(TransactionType.class, "TRANSACTION"));
					newTrans.setTransactionStatus(transactionDAO.getEntityByName(TransactionStatus.class, "SUCCESS"));
					newTrans.setCreationDate(new Date());
					transactionDAO.persist(destAcc);
					transactionDAO.persist(myAcc);
					transactionDAO.persist(newTrans);
					return "OK";
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<SchedulerModel> getSchedulers(String userName) {
		return transactionDAO.getSchedulers(userName);
	}

	@Override
	public Boolean inactiveSchedule(Long id) {
		return transactionDAO.inactiveSchedule(id);
	}

	@Override
	@Scheduled(fixedDelay = 5000)
	@Transactional
	public void checkShcedulerTask() {
		List<Scheduler> asd = transactionDAO.getAllSchedulers();
		Date now = new Date();
		for (Scheduler obj : asd) {
			if (now.after(obj.getNextPayment())) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(obj.getNextPayment());
				cal.add(Calendar.MONTH, 1);
				obj.setNextPayment(cal.getTime());
				Transaction newTrans = new Transaction();
				Account myAcc = obj.getFromAccount();
				Account destAcc = obj.getToAccount();
				myAcc.setBalance(myAcc.getBalance().subtract(obj.getAmount()));
				destAcc.setBalance(destAcc.getBalance().add(obj.getAmount()));
				newTrans.setAccount(myAcc);
				newTrans.setDescription("provider paymnent");
				newTrans.setDestinationAccount(destAcc);
				newTrans.setAmount(obj.getAmount());
				newTrans.setTransactionType(transactionDAO.getEntityByName(TransactionType.class, "TRANSACTION"));
				newTrans.setTransactionStatus(transactionDAO.getEntityByName(TransactionStatus.class, "SUCCESS"));
				newTrans.setCreationDate(new Date());
				transactionDAO.persist(destAcc);
				transactionDAO.persist(myAcc);
				transactionDAO.persist(newTrans);
				transactionDAO.persist(obj);
			}
		}

	}
}
