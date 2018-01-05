package pet.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pet.model.UserInfo;
import pet.model.WorkerInfo;
import pet.utils.JsonUtils;
import pet.view_model.WorkerViewInfo;

@Repository
public class WorkerDao {
	private JdbcTemplate jdbcTemplate = null;

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 新增工作人员
	 * 
	 * @param workerInfo
	 * @return
	 */
	public int insertWorker(WorkerInfo workerInfo) {
		String sql = "insert into dbo.Worker(workerName, workKindId, workerBirthday, workerTel, workerIntro) "
				+ "values(?, ?, ?, ?, ?)";
		int ret = 0;
		try {
			ret = jdbcTemplate.update(sql, new Object[] { workerInfo.getWorkerName(), workerInfo.getWorkKindId(),
					workerInfo.getWorkerBirthday(), workerInfo.getWorkerTel(), workerInfo.getWorkerIntro() });
		} catch (Exception e) {
			System.out.println("出错了");
			return 0;
		}
		return ret;
	}

	public WorkerViewInfo[] queryAllWorker() {
		String sql = "select workerName, kindName, workerBirthday, workerTel, workerIntro "
				+ "from Worker, dbo.WorkKind" + " where  Worker.workKindId = WorkKind.workKindId";
		List<WorkerViewInfo> workerViewInfos = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(WorkerViewInfo.class));
		System.out.println(JsonUtils.objectToJson(workerViewInfos));
		return workerViewInfos.toArray(new WorkerViewInfo[0]);
	}
}
