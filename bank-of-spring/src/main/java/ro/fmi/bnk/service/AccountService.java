package ro.fmi.bnk.service;

import java.util.List;

import ro.fmi.bnk.models.AccountModel;
import ro.fmi.bnk.models.AccountSaveModel;
import ro.fmi.bnk.models.InOutComeModel;

public interface AccountService {
	
	List<AccountModel> getAccounts(String userName);

	List<AccountModel> getAccountByNo(String accNo);

	InOutComeModel getInOutcomeFromLastMonths(int months, String accNo);

	List<String> getAccountsNo(String userName);
	
	List<String> getActiveAccounts(String userName);
	
	void saveAccount(AccountSaveModel inpModel);
}
