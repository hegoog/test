package com.myweb.domain;


import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberVO {
	private static Logger log = LoggerFactory.getLogger(MemberVO.class);
	private String email;
	private String pwd;
	private String nickname;
	private Date regd8;
	
	
	public MemberVO() 	{}

	
	
	public MemberVO(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	public MemberVO(String email, String pwd, String nickname) {
		this(email,pwd);
		this.nickname = nickname;
	}



	public static Logger getLog() {
		return log;
	}



	public static void setLog(Logger log) {
		MemberVO.log = log;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public Date getRegd8() {
		return regd8;
	}



	public void setRegd8(Date regd8) {
		this.regd8 = regd8;
	}



	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", pwd=" + pwd + ", nickname=" + nickname + ", regd8=" + regd8 + "]";
	}
	
	
	
}
