package com.swift.json;

public class OpenstackSwiftUserInfo {
	String tenant = "admin";
	String userNmae = "admin";
	String passWord = "qwer1234";
	String authUrl = "http://192.168.0.14:5000/v2.0/tokens";
	String container;
	
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public String getUserNmae() {
		return userNmae;
	}
	public void setUserNmae(String userNmae) {
		this.userNmae = userNmae;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAuthUrl() {
		return authUrl;
	}
	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
}
