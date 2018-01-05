package pet.view_model;

import java.sql.Date;

public class OrderViewInfo {
	private int orderId;
	private String userPhoneNumber;
	private String userName;
	private String petName;
	private String petSex;
	private String petKind;
	private Date orderTime;
	private String orderSupp;
	private String businessSup;
	private double businessPrice;
	private int businessId;
	private Date cleanTime;
	private double cost;

	public String getPetSex() {
		return petSex;
	}

	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}

	public OrderViewInfo(int orderId, String userPhoneNumber, String userName, String petName, String petSex,
			String petKind, Date orderTime, String orderSupp, String businessSup, double businessPrice, int businessId,
			Date cleanTime, double cost) {
		super();
		this.orderId = orderId;
		this.userPhoneNumber = userPhoneNumber;
		this.userName = userName;
		this.petName = petName;
		this.petSex = petSex;
		this.petKind = petKind;
		this.orderTime = orderTime;
		this.orderSupp = orderSupp;
		this.businessSup = businessSup;
		this.businessPrice = businessPrice;
		this.businessId = businessId;
		this.cleanTime = cleanTime;
		this.cost = cost;
	}

	public Date getCleanTime() {
		return cleanTime;
	}

	public void setCleanTime(Date cleanTime) {
		this.cleanTime = cleanTime;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public OrderViewInfo() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
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

	public String getBusinessSup() {
		return businessSup;
	}

	public void setBusinessSup(String businessSup) {
		this.businessSup = businessSup;
	}

	public double getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(double businessPrice) {
		this.businessPrice = businessPrice;
	}
}
