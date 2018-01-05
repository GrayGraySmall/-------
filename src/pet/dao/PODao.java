package pet.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pet.model.POInfo;

@Repository
public class PODao {
	private JdbcTemplate jdbcTemplate = null;

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 增加订单和宠物的关系表
	 * @param poInfo
	 * @return
	 */
	public int insertPO(POInfo poInfo) {
		String sql = "insert into dbo.po(petId, orderId) values(?,?)";
		int ret = jdbcTemplate.update(sql, new Object[] { poInfo.getPetId(), poInfo.getOrderId() });
		return ret;
	}
}
