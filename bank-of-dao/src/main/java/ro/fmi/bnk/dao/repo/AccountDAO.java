package ro.fmi.bnk.dao.repo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.models.AccountModel;
import ro.fmi.bnk.models.InOutComeModel;

@Repository("accountDao")
public class AccountDAO extends GenericDAO {

	
	public List<AccountModel> getAccounts(String userName) {
		Query q = em.createQuery("select new ro.fmi.bnk.models.AccountModel(acc.accountNo,cur.name,acc.balance,accType.name,acc.overDraft,accStat.name) from Account acc "
				+ " INNER JOIN acc.currency cur"
				+ " INNER JOIN acc.customer cust"
				+ " INNER JOIN cust.user u"
				+ " INNER JOIN acc.accountType accType"
				+ " INNER JOIN acc.accountStatus accStat"
				+ " where u.userName=:userName");
		q.setParameter("userName", userName);
		List<AccountModel> toReturn = q.getResultList();
		return toReturn;		
	}
	
	public List<AccountModel> getAccountByNo(String accNo) {
		Query q = em.createQuery("select new ro.fmi.bnk.models.AccountModel(acc.accountNo,cur.name,acc.balance,accType.name,acc.overDraft,accStat.name) from Account acc "
				+ " INNER JOIN acc.currency cur"
				+ " INNER JOIN acc.accountType accType"
				+ " INNER JOIN acc.accountStatus accStat"
				+ " where acc.accountNo=:accNo");
		q.setParameter("accNo", accNo);
		List<AccountModel> toReturn = q.getResultList();
		return toReturn;
		
	}
	
	public InOutComeModel getInOutcomeFromLastMonths(int months,String accNo) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -months);
		Query q = em.createQuery("select sum(tr.amount) from Transaction tr "
				+ " INNER JOIN tr.destinationAccount acc"
				+ " where acc.accountNo=:accNo and tr.creationDate>:date");
		q.setParameter("accNo", accNo);
		q.setParameter("date", cal.getTime());
		List<BigDecimal> income = q.getResultList();
		
		
		 q = em.createQuery("select sum(tr.amount) from Transaction tr "
				+ " INNER JOIN tr.account acc"
				+ " where acc.accountNo=:accNo and tr.creationDate>:date");
		q.setParameter("accNo", accNo);
		q.setParameter("date", cal.getTime());
		List<BigDecimal> outcome = q.getResultList();
		
		
		return new InOutComeModel(income.get(0),outcome.get(0));
		
	}
	
	public List<String> getAccountsNo(String userName) {
		Query q = em.createQuery("select acc.accountNo from Account acc "
				+ " INNER JOIN acc.customer cust"
				+ " INNER JOIN cust.user u"
				+ " where u.userName=:userName");
		q.setParameter("userName", userName);
		List<String> toReturn = q.getResultList();
		return toReturn;		
	}
	
}