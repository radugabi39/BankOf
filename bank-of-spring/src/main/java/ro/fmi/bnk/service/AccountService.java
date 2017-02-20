package ro.fmi.bnk.service;

import java.util.List;

import ro.fmi.bnk.models.AccountModel;
import ro.fmi.bnk.models.InOutComeModel;

public interface AccountService {
	
	public List<AccountModel> getAccounts(String userName);

	List<AccountModel> getAccountByNo(String accNo);

	InOutComeModel getInOutcomeFromLastMonths(int months, String accNo);

}
