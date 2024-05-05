package models;

import java.sql.Date;

public class AboutUsModel {
	private String sender_name;
	private String sender_email;
	private String subject;
	private String message;
	private Date timestamp;
	public AboutUsModel(String sender_name, String sender_email, String subject, String message, Date timestamp) {
		super();
		this.sender_name = sender_name;
		this.sender_email = sender_email;
		this.subject = subject;
		this.message = message;
		this.timestamp = timestamp;
	}
	
	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getSender_email() {
		return sender_email;
	}

	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	//yo chai insert garda use garney ho
	public AboutUsModel(String sender_name, String sender_email, String subject, String message) {
		super();
		this.sender_name = sender_name;
		this.sender_email = sender_email;
		this.subject = subject;
		this.message = message;
	}
	
	

}
