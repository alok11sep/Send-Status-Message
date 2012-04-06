package intf;

public interface PropertyFileIntf {

	public String readProperty(String propName);
	public void writeProperty(String propName, String value);
	public boolean isPropFileExist();
}
