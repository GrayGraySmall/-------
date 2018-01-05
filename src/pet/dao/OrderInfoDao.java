package pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import pet.model.OrderInfo;
import pet.utils.DateUtils;
import pet.utils.JsonUtils;
import pet.view_model.OrderNoClean;
import pet.view_model.OrderViewInfo;

@Repository
public class OrderInfoDao {
	private JdbcTemplate jdbcTemplate = null;

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 用户提交订单、插入订单,并返回自增主键
	 * 
	 * @param order
	 * @return
	 */
	public int insertOrder(OrderInfo order) {
		String sql = "insert into dbo.Orders(businessId, orderTime, orderSupp, clean) values(?, ?, ?, ?)";
		/*
		 * Map<String, Object> parmMap = new HashMap<String, Object>();
		 * parmMap.put("businessId", order.getBusinessId());
		 * parmMap.put("orderTime", order.getOrderTime());
		 * parmMap.put("orderSupp", order.getOrderSupplement());
		 * parmMap.put("clean", order.isClean()); KeyHolder keyHolder = new
		 * GeneratedKeyHolder(); SqlParameterSource source = new
		 * MapSqlParameterSource(parmMap); int rc = jdbcTemplate.update(sql,
		 * source ,keyHolder); System.out.println(rc); if(rc > 0) return rc;
		 * else { return 0; }
		 */
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				PreparedStatement ps = arg0.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setObject(1, order.getBusinessId());
				ps.setObject(2, order.getOrderTime());
				ps.setObject(3, order.getOrderSupplement());
				ps.setObject(4, order.isClean());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	/**
	 * 根据电话号码查询
	 * 
	 * @param userTel
	 * @return
	 */
	public OrderViewInfo[] queryViewInfos(String userTel, int clean) {
		String sql = "";
		if (clean == 1) {
			sql = "select * from OrderQueryView where clean = 1";
		}
		if (!(userTel == null || userTel.equals(""))) {
			sql = sql + " and userPhoneNumber = " + userTel;
		}
		List<OrderViewInfo> orders = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OrderViewInfo.class));
		System.out.println(JsonUtils.objectToJson(orders));
		return orders.toArray(new OrderViewInfo[0]);
	}

	/**
	 * 处理为结帐订单
	 * 
	 * @param userTel
	 * @return
	 */
	public OrderNoClean[] queryCleans(String userTel) {
		String sql = "select userPhoneNumber, userName, petName, petKind, orderTime, "
				+ "orderSupp, businessPrice, clean, orderId, businessId, petSex, businessSup "
				+ "from OrderQueryView where clean = 0";
		if (!(userTel == null || userTel.equals(""))) {
			sql = sql + " and userPhoneNumber = " + userTel;
		}
		List<OrderNoClean> orders = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OrderNoClean.class));
		System.out.println(JsonUtils.objectToJson(orders));
		return orders.toArray(new OrderNoClean[0]);
	}

	/**
	 * 结算订单()
	 * 
	 * @param orderId
	 * @param cost
	 * @return
	 */
	public int cleanOrder(int orderId, double cost) {
		String sql = "update dbo.Orders set cleanTime = (Select GetDate()), cost = ?, clean = 1  where orderId = ?";
		// String date = DateUtils.dateToStr(new Date(), "YYYY-MMMM-DDDD");
		System.out.println(cost);
		int ret = jdbcTemplate.update(sql, new Object[] { cost, orderId });
		System.out.println(ret);
		return ret;
	}
}
