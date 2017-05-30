package ro.fmi.bnk.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ro.fmi.bnk.models.CountryCityMapping;
import ro.fmi.bnk.models.SendMailInputModel;
import ro.fmi.bnk.models.TransactionTableModel;

public interface UtilsService {

	public void sendEmail(SendMailInputModel inp, String userName);

	void sendEmailResetPass(String cnp);

	List<CountryCityMapping> getCountryCityMapping();

	List<String> getNomData(String className);

	String getProfileImage(String userName);



	String savePictureToDisk(MultipartFile file, String userName);
///, ParsePropertyException, InvalidFormatException,
	InputStream getExcell(String records) throws Exception;
}
