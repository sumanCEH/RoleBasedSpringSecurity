package com.springsecurity.jwthelper.model;

public class JwtRequest {

	private String usersEmail;
	private String password;

	public JwtRequest(String usersEmail, String password) {
		super();
		this.usersEmail = usersEmail;
		this.password = password;
	}

	public String getusersEmail() {
		return usersEmail;
	}

	public void setusersEmail(String email) {
		this.usersEmail = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtRequest [usersEmail=" + usersEmail + ", password=" + password + "]";
	}
}
