package pet.view_model;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 宠物寄养提交的资料
 * @author zephyr
 *
 */
public class FosterViewInfo {
	private int petId;
	private String petName;
	private String userTel;
	private Date orderTime;
	private String orderSupp;//补充
	private boolean food;

	public FosterViewInfo(int petId, String petName, String userTel, Date orderTime, String orderSupp, boolean food) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.userTel = userTel;
		this.orderTime = orderTime;
		this.orderSupp = orderSupp;
		this.food = food;
	}

	public FosterViewInfo() {
		super();
	}

	public int getPetId() {
		return petId;
	}

	public boolean isFood() {
		return food;
	}
	
	public void setFood(boolean food) {
		this.food = food;
	}
	
	
	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderSupp() {
		return orderSupp;
	}

	public void setOrderSupp(String orderSupp) {
		this.orderSupp = orderSupp;
	}

}
