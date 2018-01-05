package pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.dao.FosterInfoDao;
import pet.dao.OrderInfoDao;
import pet.dao.PODao;
import pet.dao.PetInfoDao;
import pet.dao.TreatDao;
import pet.dao.UODao;
import pet.model.OrderInfo;
import pet.model.POInfo;
import pet.model.PetInfo;
import pet.model.UOInfo;
import pet.view_model.FosterViewInfo;
import pet.view_model.OrderNoClean;
import pet.view_model.OrderViewInfo;
import pet.view_model.TreatOrderViewInfo;
import pet.view_model.TreatViewInfo;

@Service
public class OrderService {
	@Autowired
	private FosterInfoDao fosterInfoDao = null;
	@Autowired
	private PetInfoDao petInfoDao = null;
	@Autowired
	private OrderInfoDao orderInfoDao = null;
	@Autowired
	private PODao poDao = null;
	@Autowired
	private UODao uoDao = null;
	@Autowired
	private TreatDao treatDao = null;
	public final String SECCESS = "RIGHT";
	public final String ERROR = "FALSE";

	/**
	 * 添加寄养订单
	 * 
	 * @param fosterViewInfo
	 * @return
	 */
	public String addFosterOrder(FosterViewInfo fosterViewInfo) {
		PetInfo pet = petInfoDao.selectById(fosterViewInfo.getPetId());// 查询宠物信息
		if (pet == null) {
			return ERROR;
		}
		int bussinessId = fosterInfoDao.selectBussiness(pet, fosterViewInfo.isFood());// 查询用户适合的业务编号
		OrderInfo order = new OrderInfo(bussinessId, fosterViewInfo.getOrderTime(), fosterViewInfo.getOrderSupp(),
				false);// 订单对象实例化
		return addPUO(fosterViewInfo.getPetId(), fosterViewInfo.getUserTel(), order);
	}

	/**
	 * 添加医疗订单
	 * @param treatViewInfo
	 * @return
	 */
	public String addTreatOrder(TreatViewInfo treatViewInfo) {
		int bussinessId = treatDao.selectTreat(treatViewInfo.getTreatKind());
		OrderInfo orderInfo = new OrderInfo(bussinessId, treatViewInfo.getOrderTime(), treatViewInfo.getOrderSupp(),
				false);//订单对象 实例化
		return addPUO(treatViewInfo.getPetId(), treatViewInfo.getUserTel(), orderInfo);
	}

	/**
	 * 添加用户订单，Po，uo
	 * 
	 * @param petId
	 * @param userTel
	 * @param order
	 * @return
	 */
	public String addPUO(int petId, String userTel, OrderInfo order) {
		
		try {
			int index = orderInfoDao.insertOrder(order);
			System.out.println(index);
			poDao.insertPO(new POInfo(petId, index));
			uoDao.insertUO(new UOInfo(userTel, index));
		} catch (Exception e) {
			System.out.println("出错了！！！");
			return ERROR;
		}
		return SECCESS;
	}
	
	/**
	 * 查询未处理订单
	 * @param userTel
	 * @return
	 */
	public OrderViewInfo[] queryOrders(String userTel, int clean){
		return orderInfoDao.queryViewInfos(userTel, clean);
	}
	
	/**
	 * 结算订单
	 * @param cost
	 * @param orderId
	 * @return
	 */
	public int cleanFosterOrder(double cost, int orderId){
		return orderInfoDao.cleanOrder(orderId, cost);
	}
	
	/**
	 * 宠物医疗查询
	 * @param orderId
	 * @return
	 */
	public TreatOrderViewInfo queryTreatOrders(int orderId){
		return treatDao.queryTreatOrder(orderId);
	}
	
	/**
	 * 删除订单
	 * @param orderId
	 * @return
	 */
	public int deleteUo(int orderId){
		return uoDao.deleteUo(orderId);
	}
	
	public OrderNoClean[] queryCleans(String userTel){
		return orderInfoDao.queryCleans(userTel);
	}
}
