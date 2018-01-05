package pet.model;

import org.springframework.stereotype.Component;

/**
 * 业务信息，总类，寄养、美容、医疗等等业务继承它
 * 
 * @author zephyr
 */
@Component("businessInfo")
public class BusinessInfo {
	private int BusinessId; // 业务Id
	private String businessSup; // 业务补充
	private double businessPrice;// 业务单价
	private int petId; //与其发生业务关系的宠物的id
	
	public void setPetId(int petId) {
		this.petId = petId;
	}
	
	public int getPetId() {
		return petId;
	}

	public int getBusinessId() {
		return BusinessId;
	}

	public void setBusinessId(int businessId) {
		BusinessId = businessId;
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

	public BusinessInfo(int businessId, String businessSup, double businessPrice, int petId) {
		super();
		BusinessId = businessId;
		this.businessSup = businessSup;
		this.businessPrice = businessPrice;
		this.petId = petId;
	}

	public BusinessInfo() {
		super();
	}

}
