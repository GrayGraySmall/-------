package pet.rest;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pet.model.UserInfo;
import pet.service.UserService;
import pet.utils.JsonUtils;
import pet.view_model.LoginInfo;
import pet.view_model.RegisterInfo;

@Controller
public class UserInfoRest {
	@Autowired
	private UserService userService = null;

	/**
	 * 用户登录检测
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "userLogin" }, method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody LoginInfo login) {
		System.out.println(JsonUtils.objectToJson(login));
		return userService.checkLongin(login.getTel(), login.getPassword());
	}

	/**
	 * 负责管理员登录
	 * 
	 * @param login
	 * @return
	 */
	@RequestMapping(value = { "manaLogin" }, method = RequestMethod.POST)
	public @ResponseBody String managerLogin(@RequestBody LoginInfo login) {
		System.out.println(login.getTel());
		if (userService.checkManager(login.getTel(), login.getPassword())) {
			return userService.SECCESS;
		}
		return userService.ERRPR;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = { "userLogin/{userTel}" }, method = RequestMethod.GET)
	public @ResponseBody UserInfo getUser(@PathVariable("userTel") String userTel) {
		System.out.println(userTel);
		return userService.queryUser(userTel);
	}

	/**
	 * 用户注册检测
	 * 
	 * @param registerInfo
	 * @return
	 */
	@RequestMapping(value = { "userRegister" }, method = RequestMethod.POST)
	public @ResponseBody String register(@RequestBody RegisterInfo registerInfo) {
		String teString = userService.checkRegister(registerInfo);
		System.out.println(teString);
		return teString;
	}

	/**
	 * 根据页号、用户名查询
	 * 
	 * @param userName
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value = { "userList/{pageIndex}/{userName}" }, method = RequestMethod.GET)
	public @ResponseBody UserInfo[] queryUsers(@PathVariable("userName") String userName,
			@PathVariable("pageIndex") int pageIndex) {
		System.out.println(pageIndex);
		return userService.queryUsers(userName, pageIndex);
	}

	/**
	 * 更具页号查询
	 * 
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value = { "userList/{pageIndex}" }, method = RequestMethod.GET)
	public @ResponseBody UserInfo[] queryUsers(@PathVariable("pageIndex") int pageIndex) {
		System.out.println(pageIndex);
		return userService.queryUsers(null, pageIndex);
	}

	/**
	 * 计算该用户名下有多少页
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = { "calculatePage/{userName}" }, method = RequestMethod.GET)
	public @ResponseBody int queryPage(@PathVariable("userName") String userName) {
		System.out.println(userName);
		return userService.contRow(userName);
	}

	/**
	 * 计算一共有多少页
	 * 
	 * @return
	 */
	@RequestMapping(value = { "calculatePage" }, method = RequestMethod.GET)
	public @ResponseBody int queryPage() {
		System.out.println("test");
		return userService.contRow(null);
	}

	/**
	 * 修改用户的密码
	 * @param userTel
	 * @param password
	 * @return
	 */
	@RequestMapping(value = { "updatePassword/{userPhoneNumber}/{password}" }, method = RequestMethod.GET)
	public @ResponseBody int updatePassword(@PathVariable("userPhoneNumber") String userTel,
			@PathVariable("password") String password) {
		System.out.println(userTel+password);
		int ret =  userService.updatePassword(password, userTel);
		System.out.println(ret);
		return ret;
	}
}