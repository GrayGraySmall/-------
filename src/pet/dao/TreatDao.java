package pet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pet.view_model.TreatOrderViewInfo;

@Repository
public class TreatDao {
	@Autowired
	private JdbcTemplate template = null;

	public JdbcTemplate getTemplate() {
		return template;
	}

	/**
	 * 选择合适的宠物医疗类型
	 * 
	 * @param treatKind
	 * @return
	 */
	public int selectTreat(String treatKind) {
		String sql = "select businessId from dbo.Treat where treatKind = ?";
		int ret = template.queryForObject(sql, new Object[] { treatKind }, Integer.class);
		return ret;
	}

	/**
	 * 按订单号查询宠物医疗订单
	 * @param orderId
	 * @return
	 */
	public TreatOrderViewInfo queryTreatOrder(int orderId) {
		String sql = "select * from dbo.treat_order_view where orderId = ?";
		List<TreatOrderViewInfo> treatOrderViewInfos = template.query(sql, new Object[] { orderId },
				BeanPropertyRowMapper.newInstance(TreatOrderViewInfo.class));
		if (treatOrderViewInfos != null) {
			return treatOrderViewInfos.get(0);
		}
		return null;
	}
}
