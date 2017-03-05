package ro.fmi.bnk.dao.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ro.fmi.bnk.enitites.User;

public class GenericDAO {

	@PersistenceContext
	protected EntityManager em;

	public <T> T getEntityByName(Class<T> className, String name) {

		Query q = em
				.createQuery("select gen from " + className.getName() + " gen where gen.name=:name");
		q.setParameter("name", name);
		T toReturn = (T) q.getSingleResult();
		return toReturn;

	}

	public <T> T persist(final T t) {
		this.em.persist(t);
		return t;
	}

	public <T> T merge(final T t) {
		return this.em.merge(t);
	}
}
