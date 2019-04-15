package com.ycsf.persys.modalur.sys.entity;

public class MailInfo {
	private String from;
	private String to;
	private String subject;
	private String message;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
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
	@Override
	public String toString() {
		return "MailInfo [from=" + from + ", to=" + to + ", subject=" + subject + ", message=" + message + "]";
	}
	
	
}
