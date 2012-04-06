package outlook.utility;

import com.lowagie.text.Paragraph;


import utility.RTFClass;
import utility.TaskBean;

public class CreateStartTemplate {

	public static String temp = new String();
	public RTFClass richText = new RTFClass();
	Paragraph para = new Paragraph();
	

	public CreateStartTemplate(TaskBean task){
		createTemplate(task);
	}
	public void createTemplate(TaskBean task) {

		// temp =
		para = richText.addToParagraph(
				"Hi Gohar / Truc," + System.getProperty("line.separator"), 0);

		para = richText.addToParagraph(" I’m starting the task [", 0);
		para = richText.addToParagraph(
				"" + task.getTaskType() + "]:" + task.getTaskName(),1);
		para = richText.addToParagraph( " that was created on ", 0);
		para = richText.addToParagraph(
				"<Launch_date>. " + System.getProperty("line.separator"), 1);
		para = richText.addToParagraph(" The delivery date is on ", 0);
		para = richText.addToParagraph(
				"<Delivery_date>." + System.getProperty("line.separator"), 1);

		para = richText.addToParagraph("This task is an integration on program ", 0);
		para = richText.addToParagraph(
				"<IDA A400M/IDA A350/ISA>."
						+ System.getProperty("line.separator"), 2);

		temp = " 1.	About the inputs"
				+ System.getProperty("line.separator")
				+

				" All inputs are correct               <yes / no>   <if no, write here what is not OK>"
				+ System.getProperty("line.separator")
				+ " I understand all I have to do    <yes / no>   <if no, write here what isn't clear>"
				+ System.getProperty("line.separator")
				+ " Some inputs are in French       <yes / no>   <if yes, write here which inputs>"
				+ System.getProperty("line.separator") +

				" 2.	About the task" + System.getProperty("line.separator") +

				" Application/Tool version used as reference: <application/tool version name>"
				+ System.getProperty("line.separator") +

				" OM: <OM_number>" + System.getProperty("line.separator")
				+ " Workload: <number of days affected to the task>"
				+ System.getProperty("line.separator")
				+ " Priority: <Task_priority>"
				+ System.getProperty("line.separator") +

				" For detailed steps on application to deliver, refer Process document."
				+ System.getProperty("line.separator") +

				" 3.	Verification at Offshore"
				+ System.getProperty("line.separator") +

				" Verifier : " + task.getVerifier()
				+ System.getProperty("line.separator") +

				"[Add Verifier in CC in all emails -- Remove this line]"
				+ System.getProperty("line.separator") +

				" The TLOF excel document is up-to-date <yes / no > "
				+ System.getProperty("line.separator") +

				"Best regards, ";
		para = richText.addToParagraph(temp, 2);
        richText.writeTheData(para);
		
	}

//	public static void main(String[] args) {
//		XMLReader xr = new Read4mXML();
//		CreateStartTemplate ct = new CreateStartTemplate();
//		ct.createTemplate(xr.getTask("TaskName"));
//		
//		System.out.println(temp);
//	}

}
