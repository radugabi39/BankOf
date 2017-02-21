package ro.fmi.bnk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.TransactionDAO;
import ro.fmi.bnk.models.TransactionTableModel;
import ro.fmi.bnk.service.TransactionService;
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionDAO transactionDAO;
	
	@Override
	public List<TransactionTableModel> getTransactionsByAccNo(String accNo){
		return	transactionDAO.getTransactionsByAccNo(accNo);
	}
}
