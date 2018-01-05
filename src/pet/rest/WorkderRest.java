package pet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pet.model.WorkerInfo;
import pet.service.WorkerService;
import pet.view_model.WorkerViewInfo;

@Controller
public class WorkderRest {
	@Autowired
	public WorkerService workerService = null;

	/**
	 * 工作人员用户
	 * 
	 * @param workerInfo
	 * @return
	 */
	@RequestMapping(value = { "worker" }, method = RequestMethod.POST)
	public @ResponseBody String insertWorker(@RequestBody WorkerInfo workerInfo) {
		return workerService.insertWorker(workerInfo);
	}

	/**
	 * 请求工作人员
	 * @return
	 */
	@RequestMapping(value = { "worker" }, method = RequestMethod.GET)
	public @ResponseBody WorkerViewInfo[] queryWorkerInfo() {
		System.out.println("test");
		return workerService.queryViewInfos();
	}
}
