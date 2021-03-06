package ro.fmi.bnk.service;

import java.util.List;

import ro.fmi.bnk.models.SchedulerModel;
import ro.fmi.bnk.models.TransactionTableModel;
import ro.fmi.bnk.models.TransferInputModel;

public interface TransactionService {

	List<TransactionTableModel> getTransactionsByAccNo(String accNo);
	String tryTransaction(TransferInputModel inpModel) throws Exception;
	List<TransactionTableModel> getAdminTransactionsByAccNo(String accNo);

	String reverseTransaction(TransactionTableModel inp);
	List<SchedulerModel> getSchedulers(String userName);
	Boolean inactiveSchedule(Long id);

	void checkShcedulerTask();
}
