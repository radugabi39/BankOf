package ro.fmi.bnk.service;

import java.util.List;

import ro.fmi.bnk.models.CountryCityMapping;
import ro.fmi.bnk.models.SendMailInputModel;

public interface UtilsService {

	public void sendEmail(SendMailInputModel inp, String userName);

	void sendEmailResetPass(String cnp);

	List<CountryCityMapping> getCountryCityMapping();

	List<String> getNomData(String className);
}
