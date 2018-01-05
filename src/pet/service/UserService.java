package pet.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.dao.UserInfoDao;
import pet.model.UserInfo;
import pet.utils.DateUtils;
import pet.utils.MD5Utils;
import pet.view_model.RegisterInfo;

@Service
public class UserService {
	public static int LOGIN_STATE = 1;
	public final String SECCESS = "COREECT";
	public final String ERRPR = "ERROR";
	@Autowired
	private UserInfoDao userdao = null;

	/**
	 * 检查登录是否成功
	 * 
	 * @param userPhoneNumber
	 *            登录账号
	 * @param password
	 *            登录密码
	 * @return 匹配状态
	 */
	public String checkLongin(String userPhoneNumber, String password) {
		String queryPW = userdao.selectPassW(userPhoneNumber);
		if(queryPW == null || queryPW.equals("")){
			return ERRPR;
		}
		queryPW = queryPW.replace(" ", ""); // 去除多余的空格
		if (MD5Utils.md5(password).equals(queryPW)) {
			return SECCESS;
		} else {
			return ERRPR;
		}
	}

	/**
	 * 注册&&检查注册是否合法
	 * 
	 * @param registerInfo
	 * @return
	 */
	public String checkRegister(RegisterInfo registerInfo) {
		boolean fT = userdao.selectIn(registerInfo.getTel());
		System.out.println(fT);
		if (fT) {
			return ERRPR;
		} else {
			String date = DateUtils.dateToStr(new Date(), "YYYY-MMMM-DDDD");
			UserInfo userInfo = new UserInfo(registerInfo.getTel(), 1, registerInfo.getUserName(),
					registerInfo.getUserSex(), "null",
					new java.sql.Date(DateUtils.strToDate(date, "YYYY-MMMM-DDDD").getTime()),
					MD5Utils.md5(registerInfo.getPassword()));
			int ret = userdao.insert(userInfo);
			return ret == 1 ? SECCESS : ERRPR;
		}
	}

	/**
	 * 更具电话号码查询用户信息
	 * 
	 * @param userTel
	 * @return
	 */
	public UserInfo queryUser(String userTel) {
		return userdao.queryUser(userTel);
	}

	/**
	 * 检查管理员用户登录是否成功
	 * 
	 * @param userTel
	 * @param password
	 * @return
	 */
	public boolean checkManager(String userTel, String password) {
		UserInfo user = userdao.queryUser(userTel);
		if (user == null || user.getKindId() != 6) {
			System.out.println("?????????");
			return false;
		}
		if ((checkLongin(userTel, password)).equals(ERRPR)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 根据用户名字和请求页来请求用户（分页）
	 * @param userName
	 * @param pageIndex
	 * @return
	 */
	public UserInfo[] queryUsers(String userName, int pageIndex){
		return userdao.findByIndex(pageIndex-1, userName);
	}
	
	/**
	 * 计算一共有多少行数据（分页用）
	 * @param userName，请求的用户名
	 * @return
	 */
	public int contRow(String userName){
		return userdao.countRow(userName);
	}
	
	/**
	 * 修改用户密码
	 * @param password
	 * @param usertel
	 * @return
	 */
	public int updatePassword(String password, String usertel){
		return userdao.updatePassword(usertel, password);
	}
}
