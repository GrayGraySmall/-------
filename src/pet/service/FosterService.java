package pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.dao.FosterInfoDao;
import pet.view_model.FosterOrderViewInfo;
import pet.view_model.FosterViewInfo;

@Service
public class FosterService {
	@Autowired
	private FosterInfoDao fosterInfoDao;
	
	public FosterOrderViewInfo queryFosterOrder(int orderId){
		return fosterInfoDao.fosterOrderInfo(orderId);
	}
}
