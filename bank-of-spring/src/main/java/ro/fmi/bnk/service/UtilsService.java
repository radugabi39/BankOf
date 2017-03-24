package ro.fmi.bnk.service;

import ro.fmi.bnk.models.SendMailInputModel;

public interface UtilsService {

	public void sendEmail(SendMailInputModel inp, String userName);
}
