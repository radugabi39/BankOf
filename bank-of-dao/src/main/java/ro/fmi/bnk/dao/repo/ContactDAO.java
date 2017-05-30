package ro.fmi.bnk.dao.repo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.models.BranchLocationModel;
import ro.fmi.bnk.models.CardsModel;

	@Repository("contactDAO")
	public class ContactDAO extends GenericDAO{
		public List<BranchLocationModel> getBranchLocation() {

			Query q = em.createQuery("select new ro.fmi.bnk.models.BranchLocationModel(b.name,b.longitude,b.latitude) from ro.fmi.bnk.enitites.Branch b"
					+ " where b.active=1");
		
			List<BranchLocationModel> toReturn = q.getResultList();
			return toReturn;
		}
}
