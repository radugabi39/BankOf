package ro.fmi.bnk.dao.repo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.enitites.Account;
import ro.fmi.bnk.enitites.Scheduler;
import ro.fmi.bnk.models.SchedulerModel;
import ro.fmi.bnk.models.TransactionTableModel;

@Repository("transactionDAO")
public class TransactionDAO extends GenericDAO {

	public List<TransactionTableModel> getTransactionsByAccNo(String accNo) {
		Query q = em.createQuery(
				"select new ro.fmi.bnk.models.TransactionTableModel(fa.accountNo,da.accountNo,tr.creationDate,tr.description,ts.name,tt.name,tr.amount) from Transaction tr"
						+ " INNER JOIN tr.account fa" + " INNER JOIN tr.destinationAccount da"
						+ " INNER JOIN tr.transactionStatus ts" + " INNER JOIN tr.transactionType tt"
						+ " where da.accountNo=:accNo or fa.accountNo=:accNo");
		q.setParameter("accNo", accNo);
		List<TransactionTableModel> toReturn = q.getResultList();
		return toReturn;
	}

	public List<TransactionTableModel> getAdminTransactionsByAccNo(String accNo) {
		Query q = em.createQuery(
				"select new ro.fmi.bnk.models.TransactionTableModel(fa.accountNo,da.accountNo,tr.creationDate,tr.description,ts.name,tt.name,tr.amount,tr.id) from Transaction tr"
						+ " INNER JOIN tr.account fa" + " INNER JOIN tr.destinationAccount da"
						+ " INNER JOIN tr.transactionStatus ts" + " INNER JOIN tr.transactionType tt"
						+ " where da.accountNo=:accNo or fa.accountNo=:accNo");
		q.setParameter("accNo", accNo);
		List<TransactionTableModel> toReturn = q.getResultList();
		return toReturn;
	}

	public List<SchedulerModel> getSchedulers(String userName) {
		Query q = em.createQuery(
				"select new ro.fmi.bnk.models.SchedulerModel(sc.id,da.accountNo,fa.accountNo,sc.nextPayment,sc.active,sc.amount) from Scheduler sc"
						+ " INNER JOIN sc.fromAccount fa" + " INNER JOIN sc.toAccount da"
						+ " INNER JOIN sc.customer cust" + " INNER JOIN cust.user us"

						+ " where us.userName=:userName ");
		q.setParameter("userName", userName);
		List<SchedulerModel> toReturn = q.getResultList();
		return toReturn;
	}

	public List<Scheduler> getAllSchedulers() {
		Query q = em.createQuery("select sc from Scheduler sc"

				+ " where sc.active=true");

		List<Scheduler> toReturn = q.getResultList();
		return toReturn;
	}

	@Transactional
	public Boolean inactiveSchedule(Long id) {
		Scheduler toModify = em.find(Scheduler.class, id);
		toModify.setActive(false);
		em.persist(toModify);
		return true;
	}

}
