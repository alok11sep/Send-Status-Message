package utility;

import java.io.File;

import javax.swing.JOptionPane;

import intf.PropertyFileIntf;

public class RunVBScript {
	/**
	 * Start the batch file if any
	 * 
	 * @param name
	 */
    private FileUtility fUtility = new FileUtility("utility\\StartTest.vbs");
    private PropertyFileIntf propertyFileIntf = new PropertyFileUtility();
    
	final String templatePAth =propertyFileIntf.readProperty("tempLatePath")+"\\"; 
    //final String templatePAth ="templates_folder\\";
	
    final String fixedString = "Set Outlook = CreateObject(\"Outlook.Application\")"+ System.getProperty("line.separator")+
    "Set MAPI = Outlook.GetNameSpace(\"MAPI\")"+ System.getProperty("line.separator")+
    "Set NewMail = Outlook.CreateItemFromTemplate(MsgTemplate)"+ System.getProperty("line.separator")+
    "NewMail.Subject = SUBJ"+ System.getProperty("line.separator")+
    "NewMail.TO = TOlist"+ System.getProperty("line.separator")+
    "NewMail.CC = CC"+ System.getProperty("line.separator")+
    "NewMail.BCC = BCC"+ System.getProperty("line.separator")+
    "NewMail.display";


	
	public RunVBScript(TaskBean task, String Type) {
   
		if(getDataToWrite(task, Type).length()>0){
		createVB(getDataToWrite(task, Type));
		try {
			System.out.println("Running the vbs script");
			@SuppressWarnings("unused")
			Process p = Runtime.getRuntime().exec("wscript utility\\StartTest.vbs ");
			System.out.println("Finished running the batch script");

		} catch (Exception e) {
			System.out.println("Error Running script" + e);
			e.printStackTrace();
		}
		}else			
		JOptionPane.showMessageDialog(null, "Property Not set Correctly.");

	}
	
	public String getTemplateName(String templateType) {
        
		String tType = "";
		if (templateType.equals("startTask")&&isFileExsist(templatePAth+ propertyFileIntf.readProperty("pathForStartTemplate"))) {
	
				tType =propertyFileIntf.readProperty("pathForStartTemplate");
				
			
		} else if (templateType.equals("IssueTask")&&isFileExsist(templatePAth+ propertyFileIntf.readProperty("pathForIssueTemplate"))) {
			tType = propertyFileIntf.readProperty("pathForIssueTemplate");

		} else if (templateType.equals("OverLoadTask")&&isFileExsist(templatePAth+ propertyFileIntf.readProperty("pathForOverloadTemplate"))) {
			tType = propertyFileIntf.readProperty("pathForOverloadTemplate");

		} else if (templateType.equals("DeliveryTask")&&isFileExsist(templatePAth+ propertyFileIntf.readProperty("pathForDeliveryTemplate"))) {
			tType =propertyFileIntf.readProperty("pathForDeliveryTemplate");

		} else if (templateType.equals("AlertTask")&&isFileExsist(templatePAth+ propertyFileIntf.readProperty("pathForAlertTemplate"))) {
			tType =propertyFileIntf.readProperty("pathForAlertTemplate");

		} else if (templateType.equals("VerificationTask")&&isFileExsist(templatePAth+ propertyFileIntf.readProperty("pathForVerificationTemplate"))) {
			tType = propertyFileIntf.readProperty("pathForVerificationTemplate");
		}
		return tType;
	}

//	public static void main(String args[]) {
//		// RCP = "alok.maheshwary@capgemini.com"
//		// MSG = "Alok"
//		// SUBJ = "Message Subject"
//		// MsgTemplate =
//		// "D:\Alok\templates_benches\templates_benches\HTIS5-Benches-TEMPLATE-Task_Verification-TBV.oft"
//
//	}

	public String getDataToWrite(TaskBean task, String Type) {
		if(getTemplateName(Type).length()>0){
		String data = "TOlist = \"" + task.getOffshoreAdvisorsList()+ task.getOnshoreAdvisorsList() + "\""+ System.getProperty("line.separator")
				+ "CC = \"" + task.getVerifier()+ task.getTechnicalReferent()+ "\""+ System.getProperty("line.separator")
				+ "BCC = \"" + task.getOffshoreAdvisorsList()+ task.getOnshoreAdvisorsList() + "\""+ System.getProperty("line.separator")
				+ "SUBJ = \"" + "[" + task.getTaskType() + "]:"
				+ task.getTaskName() + "\""+ System.getProperty("line.separator") + "MsgTemplate=\"" + templatePAth
				+ getTemplateName(Type) + "\""+ System.getProperty("line.separator") + fixedString;
		
	return data;}
		else 
			
			return "";
		

	}
	public void createVB(String data){
		fUtility.setData(data);
	}
	 boolean isFileExsist(String path){
		 File f = new File(path);
		 if(f.exists()){
		return true;
		 }else
			 return false;
		
	}
	
}
