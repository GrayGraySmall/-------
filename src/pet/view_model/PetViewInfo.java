package pet.view_model;

import java.sql.Date;
/**
 * 添加宠物的适合，添加的视图
 * @author zephyr
 *
 */
public class PetViewInfo {
	private String userPhoneNumber;// 宠物主人电话号码
	private String petSex;// 宠物性别
	private String petName;// 宠物名字
	private Date petBirthday;// 宠物生日
	private String petKind;// 宠物类别
	private int petWeight; // 宠物体重

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getPetSex() {
		return petSex;
	}

	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Date getPetBirthday() {
		return petBirthday;
	}

	public void setPetBirthday(Date petBirthday) {
		this.petBirthday = petBirthday;
	}

	public String getPetKind() {
		return petKind;
	}

	public void setPetKind(String petKind) {
		this.petKind = petKind;
	}

	public int getPetWeight() {
		return petWeight;
	}

	public void setPetWeight(int petWeight) {
		this.petWeight = petWeight;
	}

	public PetViewInfo(String userPhoneNumber, String petSex, String petName, Date petBirthday, String petKind,
			int petWeight) {
		super();
		this.userPhoneNumber = userPhoneNumber;
		this.petSex = petSex;
		this.petName = petName;
		this.petBirthday = petBirthday;
		this.petKind = petKind;
		this.petWeight = petWeight;
	}

	public PetViewInfo() {
		super();
	}

}
