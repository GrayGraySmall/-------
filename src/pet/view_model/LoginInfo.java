package pet.view_model;

import org.springframework.stereotype.Component;

public class LoginInfo {
	private String tel;
	private String password;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginInfo(String tel, String password) {
		super();
		this.tel = tel;
		this.password = password;
	}

	public LoginInfo() {
		super();
	}

}
