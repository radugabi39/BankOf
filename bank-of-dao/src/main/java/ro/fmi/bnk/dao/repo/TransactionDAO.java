package ro.fmi.bnk.dao.repo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.models.TransactionTableModel;

@Repository("transactionDAO")
public class TransactionDAO extends GenericDAO {

	public List<TransactionTableModel> getTransactionsByAccNo(String accNo) {
		Query q = em.createQuery("select new ro.fmi.bnk.models.TransactionTableModel(fa.accountNo,da.accountNo,tr.creationDate,tr.description,ts.name,tt.name,tr.amount) from Transaction tr"
				+ " INNER JOIN tr.account fa"
				+ " INNER JOIN tr.destinationAccount da"
				+ " INNER JOIN tr.transactionStatus ts"
				+ " INNER JOIN tr.transactionType tt"
				+ " where da.accountNo=:accNo or fa.accountNo=:accNo");
		q.setParameter("accNo", accNo);
		List<TransactionTableModel> toReturn = q.getResultList();
		return toReturn;
	}
	

}
