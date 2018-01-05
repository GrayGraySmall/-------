package pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.dao.PetInfoDao;
import pet.model.PetInfo;
import pet.view_model.PetViewInfo;

@Service
public class PetService {
	@Autowired
	private PetInfoDao petInfoDao = null;

	public final String SUCCESS = "RIGHT";
	public final String ERROR = "ERROR";

	/**
	 * 用户添加宠物
	 * 
	 * @param pet
	 * @return
	 */
	public String addPet(PetViewInfo pet) {
		try {
			petInfoDao.insertPet(pet);
		} catch (Exception e) {
			System.out.println(ERROR);
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 查询当前用户所拥有的宠物
	 * 
	 * @return
	 */
	public PetInfo[] qureyPet(String userTel) {
		return petInfoDao.selectPetByUserTel(userTel);
	}
}
