package pet.view_model;

import java.sql.Date;

/**
 * 宠物医疗订单
 * 
 * @author zephyr
 *
 */
public class TreatOrderViewInfo {
	private String userName;
	private String petName;
	private String petKind;
	private String treatKind;
	private double businessPrice;
	private int orderId;
	private Date orderTime;
	private double discount;
	
	public TreatOrderViewInfo(String userName, String petName, String petKind, String treatKind, double businessPrice,
			int orderId, Date orderTime, double discount) {
		super();
		this.userName = userName;
		this.petName = petName;
		this.petKind = petKind;
		this.treatKind = treatKind;
		this.businessPrice = businessPrice;
		this.orderId = orderId;
		this.orderTime = orderTime;
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
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

	public String getTreatKind() {
		return treatKind;
	}

	public void setTreatKind(String treatKind) {
		this.treatKind = treatKind;
	}

	public double getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(double businessPrice) {
		this.businessPrice = businessPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public TreatOrderViewInfo() {
		super();
	}
}
