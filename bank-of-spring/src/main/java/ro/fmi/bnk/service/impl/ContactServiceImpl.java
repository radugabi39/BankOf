package ro.fmi.bnk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.ContactDAO;
import ro.fmi.bnk.models.BranchLocationModel;
import ro.fmi.bnk.service.ContactService;


	@Service("contactService")
	public class ContactServiceImpl implements ContactService {

		@Autowired
		private ContactDAO contactDAO;
		@Override
		public List<BranchLocationModel> getBranchLocation() {
			return contactDAO.getBranchLocation();
		}
}
