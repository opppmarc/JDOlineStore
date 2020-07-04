package com.aaa.vo;
//实体类
public class User {
	private Integer uid;
	private String username;
	private String pwd;
	private String question;
	private String answer;
	private String role;
	public User() {
	}
	
	public User(Integer uid, String username, String pwd, String question,
			String answer, String role) {
		super();
		this.uid = uid;
		this.username = username;
		this.pwd = pwd;
		this.question = question;
		this.answer = answer;
		this.role = role;
	}


	public User(String username, String pwd, String question, String answer,
			String role) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.question = question;
		this.answer = answer;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
