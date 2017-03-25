package ro.fmi.bnk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.AccountDAO;
import ro.fmi.bnk.dao.repo.UserDAO;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.AccountModel;
import ro.fmi.bnk.models.AccountSaveModel;
import ro.fmi.bnk.models.InOutComeModel;
import ro.fmi.bnk.service.AccountService;
import ro.fmi.bnk.service.UserService;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public List<AccountModel> getAccounts(String userName) {
		return accountDAO.getAccounts(userName);

	}
	
	@Override
	public List<AccountModel> getAccountByNo(String accNo) {
		return accountDAO.getAccountByNo(accNo);

	}
	
	@Override
	public List<String> getActiveAccounts(String userName) {
		return accountDAO.getActiveAccounts(userName);

	}
	
	@Override
	public InOutComeModel getInOutcomeFromLastMonths(int months,String accNo) {
		return accountDAO.getInOutcomeFromLastMonths(months,accNo);

	}
	
	@Override
	public List<String> getAccountsNo(String userName) {
		return accountDAO.getAccountsNo(userName);

	}

	@Override
	public void saveAccount(AccountSaveModel inpModel) {
		accountDAO.saveAccount(inpModel);
		
	}
}
