package pet.model;

import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * 宠物和订单关系表
 * 
 * @author zephyr
 *
 */
@Component("pOInfo")
public class POInfo {
	private int petId;
	private int orderId;

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public POInfo(int petId, int orderId) {
		super();
		this.petId = petId;
		this.orderId = orderId;
	}

	public POInfo() {
		super();
	}
}
