package ro.fmi.bnk.service;

import java.util.List;

import ro.fmi.bnk.models.TransactionTableModel;

public interface TransactionService {

	List<TransactionTableModel> getTransactionsByAccNo(String accNo);

}
