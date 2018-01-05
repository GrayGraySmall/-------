package pet.view_model;

import org.springframework.stereotype.Component;

/**
 * 用户登录上传的参数
 * 
 * @author zephyr
 *
 */
public class RegisterInfo {
	private String tel;
	private String userName;
	private String userSex;
	private String password;

	public RegisterInfo(String tel, String userName, String userSex, String password) {
		super();
		this.tel = tel;
		this.userName = userName;
		this.userSex = userSex;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public RegisterInfo() {
		super();
	}

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

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
}
