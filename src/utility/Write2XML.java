package utility;

import intf.XMLReader;
import intf.XMLWriter;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Write2XML implements XMLWriter{
	
	XMLReader xReader = new Read4mXML();
//	private static Write2XML xmlWriter = new Write2XML();
//	public static Write2XML getInstance(){
//		return xmlWriter;
//		
//	}

	@Override
	public void writeTask(TaskListClass taskClass) {
			
	  try {
	 
			File file = new File("utility\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(TaskListClass.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 		// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 TaskListClass tc = xReader.getAllTask();
			 tc.getBeanList().addAll(taskClass.getBeanList());
			//xReader.getAllTask();
    		jaxbMarshaller.marshal(tc, file);
		//	jaxbMarshaller.marshal(task, System.out);
		 
		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
		
	}

	@Override
	public void setTemplatepath(String path) {

		
		  try {
			  TaskListClass taskClass;
				File file = new File("utility\\file.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(TaskListClass.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 		// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
				taskClass = xReader.getAllTask();
				taskClass.setTemplatesPath(path);
				//xReader.getAllTask();
	    		jaxbMarshaller.marshal(taskClass, file);
			//	jaxbMarshaller.marshal(task, System.out);
			 
			      } catch (JAXBException e) {
				e.printStackTrace();
			      }
			
		
		
	}
	
	

	

}


 
