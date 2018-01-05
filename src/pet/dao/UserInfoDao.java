package pet.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pet.model.UserInfo;
import pet.utils.JsonUtils;
import pet.utils.MD5Utils;

/**
 * 负责User的增删改查
 * 
 * @author zephyr
 *
 */
@Repository
public class UserInfoDao {
	private JdbcTemplate jdbcTemplate = null;

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 增加用户（用户注册时候用）
	 * 
	 * @param user
	 * @return
	 */
	public int insert(UserInfo user) {
		System.out.println(user.getUserSex());
		String sql = "insert into Users(userPhoneNumber, kindId, userName, userSex, userIcon, regerstTime, password) values(?, ?, ?, ?, ?, ?, ?)";
		int ret = jdbcTemplate.update(sql, user.getUserPhoneNumber(), user.getKindId(), user.getUserName(),
				user.getUserSex(), user.getUserIcon(), user.getRegerstTime(), user.getPassword());
		return ret;
	}

	/**
	 * 根据电话号码查询用户密码
	 * 
	 * @param userPhoneNumber
	 * @return
	 */
	public String selectPassW(String userPhoneNumber) {
		String sql = "select password from dbo.Users where userPhoneNumber = ?";
		String passw = "-1";
		try {
			passw = jdbcTemplate.queryForObject(sql, new Object[] { userPhoneNumber }, String.class);
		} catch (Exception e) {
			return "-1";
		}
		return passw;
	}

	/**
	 * 查询用户是否已注册
	 * 
	 * @param tel
	 *            电话号码
	 * @return 已经注册ture，没有注册 false
	 */
	public boolean selectIn(String tel) {
		String sql = "select count(*) from dbo.Users where userPhoneNumber = ?";
		Integer number = jdbcTemplate.queryForObject(sql, new Object[] { tel }, Integer.class);
		return number != 0 ? true : false;
	}

	/**
	 * 更具电话号码查询用户信息
	 * 
	 * @param userTel
	 * @return
	 */
	public UserInfo queryUser(String userTel) {
		String sql = "select * from Users where userPhoneNumber = ?";
		List<UserInfo> users = jdbcTemplate.query(sql, new Object[] { userTel },
				BeanPropertyRowMapper.newInstance(UserInfo.class));
		if (users == null || users.size() == 0) {
			return null;
		}
		System.out.println(JsonUtils.objectToJson(users.get(0)));
		return users.get(0);
	}
	
	/**
	 * 返回第index页的数据
	 * 
	 * @param index
	 *            页号
	 * @return 图书数组
	 */
	public UserInfo[] findByIndex(int index, String userName) {
		System.out.println(index);
		String sql = "select top " + 10 + " * from dbo.Users where ";
		if (userName == null || userName.equals("") == true)
			sql = sql + " userPhoneNumber not in ";
		else
			sql = sql + " userName like '%" + userName + "%' and userPhoneNumber not in ";
		String subSql = " (select top " + index * 10 + " userPhoneNumber from Users ";
		if (userName == null || userName.equals("") == true)
			subSql = subSql + " order by regerstTime) ";
		else
			subSql = subSql + " where userName like '%" + userName + "%' order by regerstTime) ";
		sql = sql + subSql + " order by regerstTime";
		List<UserInfo> objs = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserInfo.class));
		System.out.println(JsonUtils.objectToJson(objs));
		return objs.toArray(new UserInfo[0]);
	}
	
	/**
	 * 计算一共有多少行数据
	 * 
	 * @return
	 */
	public int countRow(String userName) {
		String sql = "select count(*) as countRows from dbo.Users ";
		if (!(userName == null || userName.equals("") == true))
			sql = sql + " where userName like '%" + userName + "%'";
		Integer x = jdbcTemplate.queryForObject(sql, Integer.class);
		return x;
	}

	public int updatePassword(String userTel, String password){
		String sql = "update Users set password = ? where userPhoneNumber = ?";
		int ret = jdbcTemplate.update(sql, new Object[]{MD5Utils.md5(password), userTel});
		return ret;
	}
}
