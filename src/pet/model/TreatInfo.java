package pet.model;

import org.springframework.stereotype.Component;

/**
 * 宠物医疗类，继承自BusinessInfo dbo.Treat
 * 
 * @author zephyr
 *
 */
@Component("treatInfo")
public class TreatInfo extends BusinessInfo {
	private String treatKind; // 宠物医疗种类

	public String getTreatKind() {
		return treatKind;
	}

	public void setTreatKind(String treatKind) {
		this.treatKind = treatKind;
	}

	public TreatInfo() {
		super();
	}

	public TreatInfo(int businessId, String businessSup, double businessPrice, int petId, String treatKind) {
		super(businessId, businessSup, businessPrice, petId);
		this.treatKind = treatKind;
	}

}
