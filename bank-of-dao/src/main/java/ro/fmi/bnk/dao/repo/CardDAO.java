package ro.fmi.bnk.dao.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.models.CardsModel;
import ro.fmi.bnk.models.TransactionTableModel;

@Repository("cardDao")
public class CardDAO extends GenericDAO{
	public List<CardsModel> getCards(String userName) {

		Query q = em.createQuery("select new ro.fmi.bnk.models.CardsModel(CONCAT(pers.firstName,' ',pers.lastName),c.expiryDate,acc.accountNo,c.cardNumber,c.cvc,cstatus.name,ctype.name) from ro.fmi.bnk.enitites.Card c"
				+ " INNER JOIN c.holderName cust"
				+ " INNER JOIN cust.person pers"
				+ " INNER JOIN cust.user user"
				+ " INNER JOIN c.account acc"
				+ " INNER JOIN c.cardStatus cstatus"
				+ " INNER JOIN c.cardType ctype"
				+ " where user.userName=:userName");
		q.setParameter("userName", userName);
		List<CardsModel> toReturn = q.getResultList();
		return toReturn;
	}
}
