package ro.fmi.bnk.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ro.fmi.bnk.dao.repo.TransactionDAO;
//import net.sf.jxls.transformer.XLSTransformer;
import ro.fmi.bnk.dao.repo.UserDAO;
import ro.fmi.bnk.dao.repo.UtilsDAO;
import ro.fmi.bnk.enitites.Person;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.CountryCityMapping;
import ro.fmi.bnk.models.SendMailInputModel;
import ro.fmi.bnk.models.TransactionTableModel;
import ro.fmi.bnk.models.UserModel;
import ro.fmi.bnk.service.UtilsService;

@Service("utilsService")
public class UtilsServiceImpl implements UtilsService {
	@Autowired
	private MailSender mailSender;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UtilsDAO utilsDAO;
	@Autowired
	private TransactionDAO transDAO;

	@Override
	public void sendEmail(SendMailInputModel inp, String userName) {

		UserModel currentUser = userDAO.getCurrentUserData(userName);
		SimpleMailMessage message = new SimpleMailMessage();
		StringBuilder msgFooter=new StringBuilder("\n");
		message.setFrom("bankoflic@gmail.com");
		message.setTo("bankoflic@gmail.com");
		message.setSubject(inp.getSubject());
		msgFooter.append("Sender: "+currentUser.getFirstName()+" "+currentUser.getLastName()+"\n");
		msgFooter.append("Email: "+currentUser.getEmail()+"\n");
		msgFooter.append("Number: "+currentUser.getPhone()+"\n");
		message.setText(msgFooter.toString()+inp.getBody());
		mailSender.send(message);
	}

	@Override
	public void sendEmailResetPass(String cnp) {
		String generatedPass = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);

		SimpleMailMessage message = new SimpleMailMessage();
		String email = userDAO.changePasswordAndReturnEmailToSend(cnp, generatedPass);
		message.setFrom("bankoflic@gmail.com");
		message.setTo(email);
		message.setSubject("Reset password");
		message.setText("Generated password: " + generatedPass);
		mailSender.send(message);
	}

	@Override
	public List<CountryCityMapping> getCountryCityMapping() {
		return utilsDAO.getCountryCityMapping();
	}

	@Override
	public List<String> getNomData(String className) {
		return utilsDAO.getNomData(className);
	}

	@Override
	public String getProfileImage(String userName) {
		return userDAO.getProfileImage(userName);
	}

	@Override
	@Transactional
	public String savePictureToDisk(MultipartFile file, String userName) {
		Person pers = userDAO.getPersonByUserName(userName);
		String fileName = pers.getCNP() + "_" + new Timestamp(System.currentTimeMillis()).getTime() + "."
				+ file.getOriginalFilename().split("\\.")[1];
		pers.setImageURL(fileName);
		userDAO.persist(pers);

		try {
			file.transferTo(new File(System.getProperty("jboss.home.dir") + "\\images\\" + fileName));
			return fileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// ParsePropertyException, InvalidFormatException,
	@Override
	public InputStream getExcell(String accNo) throws Exception {
		Map beans = new HashMap();
		List<TransactionTableModel> records = transDAO.getTransactionsByAccNo(accNo);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Transactions");

		int rowNum = 0;
		System.out.println("Creating excel");
		Row row = sheet.createRow(rowNum++);
		int colNum = 0;
		row.createCell(colNum++).setCellValue("From Account");
		row.createCell(colNum++).setCellValue("To Account");
		row.createCell(colNum++).setCellValue("Date");
		row.createCell(colNum++).setCellValue("Description");
		row.createCell(colNum++).setCellValue("Transaction Status");
		row.createCell(colNum++).setCellValue("Transaction Type");
		row.createCell(colNum++).setCellValue("Amount");
		for (TransactionTableModel datatype : records) {
			row = sheet.createRow(rowNum++);
			colNum = 0;
			row.createCell(colNum++).setCellValue(datatype.getFromAccount());
			row.createCell(colNum++).setCellValue(datatype.getToAccount());
			row.createCell(colNum++).setCellValue(datatype.getDate());
			row.createCell(colNum++).setCellValue(datatype.getDescription());
			row.createCell(colNum++).setCellValue(datatype.getTransactionStatus());
			row.createCell(colNum++).setCellValue(datatype.getTransactionType());
			row.createCell(colNum++)
					.setCellValue(datatype.getAmount() != null ? datatype.getAmount().doubleValue() : null);

		}

		try {
			;
			FileOutputStream outputStream = new FileOutputStream(
					new File(System.getProperty("jboss.home.dir") + "\\excell\\resultTransactionTable.xlsx"));
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new BufferedInputStream(new FileInputStream(
				new File(System.getProperty("jboss.home.dir") + "\\excell\\resultTransactionTable.xlsx")));

	}
}
