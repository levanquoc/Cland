package edu.vinaenter.model;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String subject;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Contact(int id, String name,String email, String subject, String content) {
		super();
		this.id = id;
		this.name = name;
		this.email=email;
		this.subject = subject;
		this.content = content;
		
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
