package pet.test;

import java.sql.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonObject;

import pet.dao.PetInfoDao;
import pet.dao.UserInfoDao;
import pet.model.PetInfo;
import pet.model.UserInfo;
import pet.utils.DateUtils;
import pet.utils.JsonUtils;
import pet.utils.MD5Utils;
import pet.utils.SpringUtils;

public class Test {
	
	public static void main(String[] args) {
		UserInfo userInfo = new UserInfo("110", 2, "杨辉", "男", "123",
				new java.sql.Date(DateUtils.strToDate("1970-1-1", "yyyy-MM-dd").getTime()), MD5Utils.md5("BRGWQJC"));
		BeanFactory factory = SpringUtils.getBeanFactory();
		UserInfoDao dao = factory.getBean(UserInfoDao.class);
		
		PetInfo pet = new PetInfo(1, "15161166601", "男", "小赵",
				new java.sql.Date(DateUtils.strToDate("2016-10-23", "yyyy-MM-dd").getTime()), "波斯猫", 5);
		dao.insert(userInfo);
	}
}
