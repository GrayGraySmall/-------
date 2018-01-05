package pet.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 订单详情 对应dbo.Order
 * 
 * @author zephyr
 *
 */
@Component("orderInfo")
public class OrderInfo {
	private String userPhoneNumber; // 用户电话号码（用户表主键）
	private int BusinessId; // 业务id
	private Date OrderTime; // 订单生成时间
	private String OrderSupplement; // 订单提交补充（说明）
	private Date returnTime; // 订单结帐时间
	private double cost; // 总花费
	private boolean clean;// 是否已结算

	public boolean isClean() {
		return clean;
	}

	public void setClean(boolean clean) {
		this.clean = clean;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public int getBusinessId() {
		return BusinessId;
	}

	public void setBusinessId(int businessId) {
		BusinessId = businessId;
	}

	public Date getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(Date orderTime) {
		OrderTime = orderTime;
	}

	public String getOrderSupplement() {
		return OrderSupplement;
	}

	public void setOrderSupplement(String orderSupplement) {
		OrderSupplement = orderSupplement;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public OrderInfo(String userPhoneNumber, int businessId, Date orderTime, String orderSupplement, Date returnTime,
			double cost, boolean clean) {
		super();
		this.userPhoneNumber = userPhoneNumber;
		BusinessId = businessId;
		OrderTime = orderTime;
		OrderSupplement = orderSupplement;
		this.returnTime = returnTime;
		this.cost = cost;
		this.clean = clean;
	}

	public OrderInfo(int businessId, Date orderTime, String orderSupplement, boolean clean) {
		super();
		BusinessId = businessId;
		OrderTime = orderTime;
		OrderSupplement = orderSupplement;
		this.clean = clean;
	}

	public OrderInfo() {
		super();
	}

}
