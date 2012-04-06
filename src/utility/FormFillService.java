package utility;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormFillService {


	private  String taskName,taskType;
	
   
	private String onshoreAdvisorsList,offshoreAdvisorsList,technicalReferent,verifier;
	
	public static boolean isValidEmailAddress(String emailAdd) {
		if((!emailAdd.contains("@"))||!emailAdd.endsWith(".com")){
			return false;
		}
		return true;
	}

	public static boolean isFormProperlyFilled() {
		if(true){
			
		}
		return false;
	}

	public  void addBeanToList(String taskName, String taskType,
			String onshoreAdvisorsList,
			String offshoreAdvisorsList,
			String technicalReferent, String verifier) {
		{
		   TaskListClass.getInstance().getBeanList().add(new TaskBean(taskName, taskType, onshoreAdvisorsList,
				offshoreAdvisorsList, technicalReferent, verifier));
		}
		   
	}

	public  void saveDataToFile() {

	}
	public  void setOnshoreAdvisorsList(String validEmailAddList){
		onshoreAdvisorsList = validEmailAddList;
		
	}
	public  void setoffshoreAdvisorsList(String validEmailAddList){
		offshoreAdvisorsList = validEmailAddList;
		
	}
	public  void settechnicalReferent(String validEmailAddList){
		technicalReferent = validEmailAddList;
		
	
		
	}
	public  void setVerifier(String validEmailAddList){
		verifier = validEmailAddList;
		
	
		
	}
	public  void createBean(){
		addBeanToList(taskName, taskType, onshoreAdvisorsList, offshoreAdvisorsList, technicalReferent, verifier);
	}

	public static ArrayList<TaskBean> getDataFromFile() {
		ArrayList<TaskBean> list = null;
		return list;

	}
	public  void setTaskName(JTextField taskN) {
		taskName = taskN.getText();
	}

	public  void setTaskType(String taskT) {
		taskType = taskT;
	}
	
	public static void printList(){
		
	}
	public ArrayList<String> getValidAddressList(JTextField data){
		ArrayList<String> validEmailAddList = new ArrayList<String>();
		String []temp = data.getText().split(";");
		for (int i = 0; i < temp.length; i++) {
			if(isValidEmailAddress(temp[i])){
				validEmailAddList.add(temp[i]);
			}
			else{
				JOptionPane.showMessageDialog(null, temp[i]+ ": Wrong email adress");
			}
		}
		return validEmailAddList;
	}
}
