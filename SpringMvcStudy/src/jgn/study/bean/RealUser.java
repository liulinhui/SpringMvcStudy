package jgn.study.bean;

import java.io.Serializable;

public class RealUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private String user_name;//用户名
	private String user_code;//资金账号
	private String user_password;//用户密码
	private String user_asset;


	public String getUser_asset() {
		return user_asset;
	}

	public void setUser_asset(String user_asset) {
		this.user_asset = user_asset;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	
}
