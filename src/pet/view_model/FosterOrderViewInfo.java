package pet.view_model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("fosterOrderViewInfo")
public class FosterOrderViewInfo {
	private String userName;
	private String petName;
	private String petKind;
	private int weight;
	private double businessPrice;
	private boolean food;
	private double discount;
	private int orderId;
	private Date orderTime;
	
	public Date getOrderTime() {
		return orderTime;
	}
	
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetKind() {
		return petKind;
	}

	public void setPetKind(String petKind) {
		this.petKind = petKind;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(double businessPrice) {
		this.businessPrice = businessPrice;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public FosterOrderViewInfo(String userName, String petName, String petKind, int weight, double businessPrice,
			boolean food, double discount, int orderId, Date orderTime) {
		super();
		this.userName = userName;
		this.petName = petName;
		this.petKind = petKind;
		this.weight = weight;
		this.businessPrice = businessPrice;
		this.food = food;
		this.discount = discount;
		this.orderId = orderId;
		this.orderTime = orderTime;
	}

	public FosterOrderViewInfo() {
		super();
	}

}
