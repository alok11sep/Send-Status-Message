package utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import intf.XMLReader;

public class Read4mXML implements XMLReader{
	

	public Read4mXML(){
		
	}
	TaskListClass customer = new TaskListClass();
	ArrayList<String> tasks = new ArrayList<String>();

	@Override
	public ArrayList<String> getTasklist() {
		HashSet<TaskBean> customers = getAllTask().getBeanList();
		for (Iterator<TaskBean> iterator = customers.iterator(); iterator.hasNext();) {
			TaskBean taskBean = iterator.next();
			tasks.add(taskBean.getTaskName());
		}
		return tasks;
		
	}

	@Override
	public TaskListClass getAllTask() {
		 try {
				File file = new File("utility\\file.xml");
				if(file.exists()){
					try {
						file.createNewFile();
						} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				JAXBContext jaxbContext = JAXBContext.newInstance(TaskListClass.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				customer = (TaskListClass) jaxbUnmarshaller.unmarshal(file);
				//System.out.println(customer);
		 
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }
		 
        return customer;
		
	}

	@Override
	public TaskBean getTask(String name) {
		TaskBean taskBean = null;
		HashSet<TaskBean> customers = getAllTask().getBeanList();
		for (Iterator<TaskBean> iterator = customers.iterator(); iterator.hasNext();) {
			TaskBean bean = iterator.next();
			if(bean.getTaskName().equals(name)){
				taskBean = bean;
			}
			
		}
		return taskBean;
		
	}

	@Override
	public boolean isTaskNameExist(String name) {
		boolean exists = false;
	
		HashSet<TaskBean> customers = getAllTask().getBeanList();
		for (Iterator<TaskBean> iterator = customers.iterator(); iterator.hasNext();) {
			TaskBean bean = iterator.next();
			if(bean.getTaskName().equals(name)){
				exists =  true;
			}
			
		}
		return exists;
	}

	@Override
	public String getTemplatePath() {
		if(getAllTask().getTemplatesPath().length()>0)
		return customer.getTemplatesPath();
		else 
			return "pathNotSet";
	}

}
