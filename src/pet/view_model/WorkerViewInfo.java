package pet.view_model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("workerViewInfo")
public class WorkerViewInfo {
	private String workerName;// 员工姓名
	private String kindName;// 员工类别号（外码）
	private Date workerBirthday;// 员工生日
	private String workerTel;// 员工电话
	private String workerIntro;// 员工简介

	public WorkerViewInfo(String workerName, String kindName, Date workerBirthday, String workerTel,
			String workerIntro) {
		super();
		this.workerName = workerName;
		this.kindName = kindName;
		this.workerBirthday = workerBirthday;
		this.workerTel = workerTel;
		this.workerIntro = workerIntro;
	}

	public WorkerViewInfo() {
		super();
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public Date getWorkerBirthday() {
		return workerBirthday;
	}

	public void setWorkerBirthday(Date workerBirthday) {
		this.workerBirthday = workerBirthday;
	}

	public String getWorkerTel() {
		return workerTel;
	}

	public void setWorkerTel(String workerTel) {
		this.workerTel = workerTel;
	}

	public String getWorkerIntro() {
		return workerIntro;
	}

	public void setWorkerIntro(String workerIntro) {
		this.workerIntro = workerIntro;
	}

}
