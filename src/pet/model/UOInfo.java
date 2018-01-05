package pet.model;

import org.springframework.stereotype.Component;

/**
 * 用户和订单关系表
 * 
 * @author zephyr
 *
 */
@Component("uOInfo")
public class UOInfo {
	private String userPhoneNumber;
	private int orderId;

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public UOInfo(String userPhoneNumber, int orderId) {
		super();
		this.userPhoneNumber = userPhoneNumber;
		this.orderId = orderId;
	}

	public UOInfo() {
		super();
	}

}
