package ro.fmi.bnk.dao.repo;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.enitites.Customer;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.PasswordModel;
import ro.fmi.bnk.models.UserModel;

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
	
	public User getUserByUsername(String userName) {
		Query q = em.createQuery("select u from User u where u.userName=:userName");
		q.setParameter("userName", userName);
		List<User> toReturn = q.getResultList();
		if (toReturn != null && toReturn.size() > 0) {
			return toReturn.get(0);
		}
		return null;
	}
	
	public UserModel getCurrentUserData(String userName) {

		Query q = em.createQuery("select new ro.fmi.bnk.models.UserModel(pers.firstName,pers.lastName,cust.phone,cust.address1,pers.CNP,us.email,ct.name,cnt.name) from Customer cust "
				+ " INNER JOIN cust.user us "
				+ " INNER JOIN cust.person pers "
				+ " INNER JOIN cust.city ct "
				+ " INNER JOIN ct.country cnt "
				+ " where us.userName=:userName");
		q.setParameter("userName", userName);
		List<UserModel> toReturn = q.getResultList();
		if (toReturn != null && toReturn.size() > 0) {
			return toReturn.get(0);
		}
		return null;
	}

	@Transactional
	public void saveUserData(UserModel inpModel,String userName) {
		User usr= getUserByUsername(userName);
		Customer cust =usr.getCustomers().iterator().next();
		cust.setAddress1(inpModel.getAddress());
		cust.setPhone(inpModel.getPhone());
		em.persist(cust);
		
	}
	
	@Transactional
	public String changePassword(PasswordModel inp,String userName) {
		User currentUser=checkUser(userName,inp.getOldPass());
		if(currentUser==null){
			return "Password is incorrect!"; 
		}
		currentUser.setPassword(inp.getNewPass());
		em.persist(currentUser);
		return "";
	}
}
