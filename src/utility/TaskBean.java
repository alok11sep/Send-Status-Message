package utility;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class TaskBean {
	

	private String taskName;

	private String taskType;

	private String onshoreAdvisorsList;

	private String offshoreAdvisorsList;

	private String technicalReferent;

	private String verifier;
	

	public String getTaskName() {
		return taskName;
	}

  public TaskBean(){
	  
  }
	public TaskBean(String taskName, String taskType,
			String onshoreAdvisorsList,
			String offshoreAdvisorsList,
			String technicalReferent, String verifier) {
	super();
	this.taskName = taskName;
	this.taskType = taskType;

	this.onshoreAdvisorsList = onshoreAdvisorsList;
	this.offshoreAdvisorsList = offshoreAdvisorsList;
	this.technicalReferent = technicalReferent;
	this.verifier = verifier;
}

	@XmlAttribute
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public String getTaskType() {
		return taskType;
	}


	@XmlAttribute
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getOnshoreAdvisorsList() {
		return onshoreAdvisorsList;
	}


	@XmlElement
	public void setOnshoreAdvisorsList(String onshoreAdvisorsList) {
		this.onshoreAdvisorsList = onshoreAdvisorsList;
	}


	public String getOffshoreAdvisorsList() {
		return offshoreAdvisorsList;
	}

	@XmlElement
	public void setOffshoreAdvisorsList(String offshoreAdvisorsList) {

		this.offshoreAdvisorsList = offshoreAdvisorsList;
	
	}

	public String getTechnicalReferent() {
		return technicalReferent;
	}

	@XmlElement
	public void setTechnicalReferent(String technicalReferent) {
		this.technicalReferent = technicalReferent;
	}

	public String getVerifier() {
		return verifier;
	}

	@XmlElement
	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

}
