package intf;

import utility.TaskListClass;

public interface XMLWriter {

	void writeTask(TaskListClass taskClass);
	void setTemplatepath(String path);
}
