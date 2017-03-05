package ro.fmi.bnk.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.AccountDAO;
import ro.fmi.bnk.dao.repo.TransactionDAO;
import ro.fmi.bnk.enitites.Account;
import ro.fmi.bnk.enitites.Transaction;
import ro.fmi.bnk.enitites.TransactionStatus;
import ro.fmi.bnk.enitites.TransactionType;
import ro.fmi.bnk.models.TransactionTableModel;
import ro.fmi.bnk.models.TransferInputModel;
import ro.fmi.bnk.service.TransactionService;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public List<TransactionTableModel> getTransactionsByAccNo(String accNo) {
		return transactionDAO.getTransactionsByAccNo(accNo);
	}

	@Override
	@Transactional 
	public String tryTransaction(TransferInputModel inpModel) {
		try {
			Account myAcc = accountDAO.getAccountENTByNo(inpModel.getFromAccount()).get(0);
			if (myAcc.getBalance().compareTo(inpModel.getAmount()) == -1) {
				return "No funds";
			}

			Account destAcc = accountDAO.getAccountENTByNo(inpModel.getDestAccount()).get(0);
			if (!destAcc.getAccountStatus().getName().equals("OPEN")) {
				return "Destination account is not active";
			}
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
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
