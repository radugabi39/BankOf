package ro.fmi.bnk.models;

public class PasswordModel {

	private String newPass;
	private String oldPass;
	
	public PasswordModel(String newPass, String oldPass) {
		super();
		this.newPass = newPass;
		this.oldPass = oldPass;
	}
	public PasswordModel() {
		super();
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	
}
