package ro.fmi.bnk.models;

public class SendMailInputModel {

	private String body;
	private String subject;
	public SendMailInputModel() {
		super();
		}
	public SendMailInputModel(String body, String subject) {
		super();
		this.body = body;
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
