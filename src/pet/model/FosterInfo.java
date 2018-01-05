package pet.model;

import java.sql.Date;
import org.springframework.stereotype.Component;

/**
 * 这是宠物寄养表，宠物寄养信息，继承自BusinessInfo 对应数据库中 dbo.Foste
 * 
 * @author zephyr
 */
@Component("fosterInfo")
public class FosterInfo extends BusinessInfo {
	private boolean food; // 是否自带食物
	private int weight; // 宠物体重

	public FosterInfo(int businessId, String businessSup, double businessPrice, int petId, boolean food, int weight) {
		super(businessId, businessSup, businessPrice, petId);
		this.food = food;
		this.weight = weight;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public FosterInfo() {
		super();
	}
}
