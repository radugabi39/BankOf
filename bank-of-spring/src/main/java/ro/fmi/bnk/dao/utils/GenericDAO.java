package ro.fmi.bnk.dao.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class GenericDAO {
	
	@PersistenceContext(unitName = "bankofPU", type = PersistenceContextType.TRANSACTION)
	protected EntityManager em;
}
