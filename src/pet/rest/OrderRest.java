package pet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pet.service.FosterService;
import pet.service.OrderService;
import pet.utils.JsonUtils;
import pet.view_model.FosterOrderViewInfo;
import pet.view_model.FosterViewInfo;
import pet.view_model.OrderNoClean;
import pet.view_model.OrderViewInfo;
import pet.view_model.TreatOrderViewInfo;
import pet.view_model.TreatViewInfo;

@Controller
public class OrderRest {
	@Autowired
	private OrderService order;
	@Autowired
	private FosterService foster;

	/**
	 * 宠物寄养
	 * 
	 * @param fosteViewInfo
	 * @return
	 */
	@RequestMapping(value = { "petFoster" }, method = RequestMethod.POST)
	public String foster(@RequestBody FosterViewInfo fosteViewInfo) {
		System.out.println(JsonUtils.objectToJson(fosteViewInfo));
		return order.addFosterOrder(fosteViewInfo);
	}

	/**
	 * 宠物寄养
	 * 
	 * @param fosteViewInfo
	 * @return
	 */
	@RequestMapping(value = { "petFoster/{orderId}" }, method = RequestMethod.GET)
	public @ResponseBody FosterOrderViewInfo fosterOrder(@PathVariable("orderId") int orderId) {
		System.out.println(orderId);
		return foster.queryFosterOrder(orderId);
	}

	/**
	 * 宠物医疗
	 * 
	 * @param treatViewInfo
	 * @return 是否添加订单成功
	 */
	@RequestMapping(value = { "petTreat" }, method = RequestMethod.POST)
	public @ResponseBody String treat(@RequestBody TreatViewInfo treatViewInfo) {
		System.out.println(JsonUtils.objectToJson(treatViewInfo));
		return order.addTreatOrder(treatViewInfo);
	}
	
	/**
	 * 处理所有为处理的订单
	 * 
	 * @return
	 */
	@RequestMapping(value = { "orderList" }, method = RequestMethod.GET)
	public @ResponseBody OrderNoClean[] queryNoClenOrder() {
		System.out.println("test");
		return order.queryCleans(null);
	}

	/**
	 * 处理所有为处理的订单(按电话号码查询)
	 * 
	 * @return
	 */
	@RequestMapping(value = { "orderList/{userTel}" }, method = RequestMethod.GET)
	public @ResponseBody OrderNoClean[] queryNoClenOrder(@PathVariable("userTel") String userTel) {
		System.out.println("test");
		return order.queryCleans(userTel);
	}

	/**
	 * 订单结算
	 * 
	 * @param orderId
	 * @param cost
	 * @return
	 */
	@RequestMapping(value = { "petFoster/{orderId}/{cost}" }, method = RequestMethod.GET)
	public @ResponseBody int cleanFosterOrder(@PathVariable("orderId") int orderId, @PathVariable double cost) {
		System.out.println(orderId);
		return order.cleanFosterOrder(cost, orderId);
	}

	/**
	 * 订单结算
	 * 
	 * @param orderId
	 * @param cost
	 * @return
	 */
	@RequestMapping(value = { "petTreat/{orderId}" }, method = RequestMethod.GET)
	public @ResponseBody TreatOrderViewInfo cleanFosterOrder(@PathVariable("orderId") int orderId) {
		System.out.println(orderId);
		return order.queryTreatOrders(orderId);
	}

	/**
	 * 根据电话号码请求用户已消费订单
	 * @param userTel
	 * @return
	 */
	@RequestMapping(value = {"petOrder/{userTel}"},method = RequestMethod.GET)
	public @ResponseBody OrderViewInfo[] queryPetOrder(@PathVariable("userTel") String userTel) {
		return order.queryOrders(userTel, 1);
	}
	
	/**
	 * 删除用户订单
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = {"deleteOrder/{orderId}"}, method = RequestMethod.GET)
	public @ResponseBody int deleteOrder(@PathVariable("orderId") int orderId) {
		return order.deleteUo(orderId);
	}
}
