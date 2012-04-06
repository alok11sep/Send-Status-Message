package intf;

import java.util.ArrayList;

import utility.TaskBean;
import utility.TaskListClass;

public interface XMLReader {

	public ArrayList<String> getTasklist();
	public TaskListClass getAllTask();
	public TaskBean getTask(String name);
	public String getTemplatePath();
	public boolean isTaskNameExist(String name);
	
}
