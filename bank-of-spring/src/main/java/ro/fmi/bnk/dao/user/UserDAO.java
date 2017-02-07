package ro.fmi.bnk.dao.user;

import java.util.List;

import javax.persistence.Query;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.enitites.User;

public class UserDAO extends GenericDAO{
	
		public List<User> getAllUsers(){
			Query q= em.createQuery("select u from User u");
			List<User> toReturn=q.getResultList();
			return toReturn;
		}
}
