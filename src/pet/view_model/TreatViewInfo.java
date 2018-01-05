package pet.view_model;

import java.sql.Date;

/**
 * 和宠物医疗相对应的表单
 * @author zephyr
 *
 */
public class TreatViewInfo {
	private int petId;
	private String petName;
	private String userTel;
	private Date orderTime;
	private String orderSupp;// 补充
	private String treatKind;// 医疗种类

	public int getPetId() {
		return petId;
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

	public String getTreatKind() {
		return treatKind;
	}

	public void setTreatKind(String treatKind) {
		this.treatKind = treatKind;
	}

	public TreatViewInfo(int petId, String petName, String userTel, Date orderTime, String orderSupp,
			String treatKind) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.userTel = userTel;
		this.orderTime = orderTime;
		this.orderSupp = orderSupp;
		this.treatKind = treatKind;
	}

	public TreatViewInfo() {
		super();
	}

}
