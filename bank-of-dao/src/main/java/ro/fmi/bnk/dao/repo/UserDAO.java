package ro.fmi.bnk.dao.repo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.enitites.User;

@Repository("userDao")
public class UserDAO extends GenericDAO {

	public List<User> getAllUsers() {
		Query q = em.createQuery("select u from User u");
		List<User> toReturn = q.getResultList();
		return toReturn;
	}

	public User checkUser(String userName, String password) {
		Query q = em.createQuery("select u from User u where u.userName=:userName and u.password=:password");
		q.setParameter("userName", userName);
		q.setParameter("password", password);
		List<User> toReturn = q.getResultList();
		if (toReturn != null && toReturn.size() > 0) {
			return toReturn.get(0);
		}
		return null;
	}
}
