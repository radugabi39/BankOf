package ro.fmi.bnk.service;

import java.util.List;

import ro.fmi.bnk.models.TransactionTableModel;
import ro.fmi.bnk.models.TransferInputModel;

public interface TransactionService {

	List<TransactionTableModel> getTransactionsByAccNo(String accNo);
	String tryTransaction(TransferInputModel inpModel);
	List<TransactionTableModel> getAdminTransactionsByAccNo(String accNo);

	String reverseTransaction(TransactionTableModel inp);
}
