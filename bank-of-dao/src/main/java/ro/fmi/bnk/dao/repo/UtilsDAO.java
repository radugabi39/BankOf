package ro.fmi.bnk.dao.repo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.models.CountryCityMapping;
import ro.fmi.bnk.models.UserModel;

@Repository("utilsDAO")
public class UtilsDAO  extends GenericDAO{
	
	
	public List<CountryCityMapping> getCountryCityMapping() {
		Query q = em.createQuery("select new ro.fmi.bnk.models.CountryCityMapping(cnt.name,city.name) from City city "
				+ " INNER JOIN city.country cnt "
				+ " where city.active=true");
		List<CountryCityMapping> toReturn = q.getResultList();
		return toReturn;
	}
	
	public List<String> getNomData(String className) {
		Query q = em.createQuery("select gen.name from "+ className+" gen "
				+ " where gen.active=true");
		List<String> toReturn = q.getResultList();
		return toReturn;
	}
}
