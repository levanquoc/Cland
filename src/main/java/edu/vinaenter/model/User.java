package edu.vinaenter.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {
	private int id;
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String fullname;
	@NotEmpty
	private String password;
	@NotNull
	private Roles roles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	public User(int id, String username, String fullname, String password, Roles roles) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.roles = roles;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	}
	


