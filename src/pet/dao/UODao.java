package pet.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pet.model.POInfo;
import pet.model.UOInfo;

@Repository
public class UODao {
	private JdbcTemplate jdbcTemplate = null;

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 新增用户和订单关系表
	 * 
	 * @param poInfo
	 * @return
	 */
	public int insertUO(UOInfo uoInfo) {
		String sql = "insert into dbo.uo(userPhoneNumber, orderId) values(?,?)";
		int ret = jdbcTemplate.update(sql, new Object[] { uoInfo.getUserPhoneNumber(), uoInfo.getOrderId() });
		return ret;
	}

	/**
	 * 删除订单（触发器和存储过程）
	 * 
	 * @param orderId
	 * @return
	 */
	public int deleteUo(int orderId) {
		String sql = "delete from po where orderId =  ?";
		return jdbcTemplate.update(sql, new Object[] { orderId });
	}
}
