package mvc.model;

import java.util.Date;

public class Project {
	private int serialNo;
	private String projectName;
	private String projectContent;
	private Date startDate;
	private Date endDate;
	private String processStatus;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int serialNo, String projectName, String projectContent, Date startDate, Date endDate,
			String processStatus) {
		super();
		this.serialNo = serialNo;
		this.projectName = projectName;
		this.projectContent = projectContent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.processStatus = processStatus;
	}





	public int getSerialNo() {
		return serialNo;
	}



	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getProjectContent() {
		return projectContent;
	}



	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public String getProcessStatus() {
		return processStatus;
	}



	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	@Override
	public String toString() {
		return "Project [serialNo=" + serialNo + ", projectName=" + projectName + ", projectContent=" + projectContent
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", processStatus=" + processStatus + "]";
	}

	
	
}
