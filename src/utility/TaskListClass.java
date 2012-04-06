package utility;

import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TaskListClass {
	
	private static TaskListClass list = new TaskListClass();
	ArrayList<Integer>  a = new ArrayList<Integer>();
	
	public static TaskListClass getInstance(){
		return  list;
	}

	 HashSet<TaskBean> tasks = new HashSet<TaskBean>();
	 String templatesPath = new String();

	public String getTemplatesPath() {

		return templatesPath;
	}
	@XmlElement
	public void setTemplatesPath(String templatesPath) {
		this.templatesPath = templatesPath;
	}
	public  HashSet<TaskBean> getBeanList() {
		return tasks;
	}
	@XmlElement
	public  void setBeanList(HashSet<TaskBean> beanL) {
		tasks = beanL;
	}
	
	
}
