package pet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pet.model.PetInfo;
import pet.service.PetService;
import pet.utils.JsonUtils;
import pet.view_model.PetViewInfo;

@Controller
public class PetRest {
	
	@Autowired
	private PetService service = null;
	
	/**
	 * 添加宠物rest
	 * @param pet
	 * @return
	 */
	@RequestMapping(value={"petAdd"}, method = RequestMethod.POST)
	public @ResponseBody String addPet(@RequestBody PetViewInfo pet){
		System.out.println(JsonUtils.objectToJson(pet));
		return service.addPet(pet);
	}
	
	/**
	 *查询当前用户拥有的宠物
	 * @param userTel
	 * @return
	 */
	@RequestMapping(value={"petAdd/{userTel}"}, method = RequestMethod.GET)
	public @ResponseBody PetInfo[] petRequest(@PathVariable("userTel")String userTel){
		System.out.println("test");
		return service.qureyPet(userTel);
	}
}
