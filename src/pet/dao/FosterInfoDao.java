package pet.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pet.model.FosterInfo;
import pet.model.PetInfo;
import pet.view_model.FosterOrderViewInfo;

@Repository
public class FosterInfoDao {
	private JdbcTemplate jdbcTemplate = null;

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 通过用户提交的宠物选择布偶能够类型的寄养服务
	 * 
	 * @param pet
	 * @param food
	 * @return
	 */
	public int selectBussiness(PetInfo pet, boolean food) {
		String sql = "select businessId from dbo.Foster where weight = ?  AND food = ? ";
		int bussId = jdbcTemplate.queryForObject(sql,
				new Object[] {pet.getPetWeight(), food ? 1 : 0 }, Integer.class);
		return bussId;
	}

	/**
	 * 查询用户所寄养的订单
	 * 
	 * @param orderId
	 * @return
	 */
	public FosterOrderViewInfo fosterOrderInfo(int orderId) {
		String sql = "select * from dbo.foster_order_view where orderId = ?";
		List<FosterOrderViewInfo> fosters = jdbcTemplate.query(sql, new Object[] { orderId },
				BeanPropertyRowMapper.newInstance(FosterOrderViewInfo.class));
		if (fosters != null) {
			return fosters.get(0);
		} else {
			return null;
		}
	}
}
