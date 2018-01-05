package pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.dao.WorkerDao;
import pet.model.WorkerInfo;
import pet.view_model.WorkerViewInfo;

@Service
public class WorkerService {
	public final String SECCESS = "COREECT";
	public final String ERRPR = "ERROR";
	
	@Autowired
	public WorkerDao workerDao = null;
	
	/**
	 * 添加工作人员
	 * @param workerInfo
	 * @return
	 */
	public String insertWorker(WorkerInfo workerInfo){
		 if (workerDao.insertWorker(workerInfo) == 0) {
			return ERRPR;
		}else {
			return SECCESS;
		}
	}
	
	/**
	 * 查询所有工作人员
	 * @return
	 */
	public WorkerViewInfo[] queryViewInfos(){
		return workerDao.queryAllWorker();
	}
}
