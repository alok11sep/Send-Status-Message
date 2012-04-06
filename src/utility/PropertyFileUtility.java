package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import intf.PropertyFileIntf;

public class PropertyFileUtility implements PropertyFileIntf {

	private Properties properties = new Properties();

	@Override
	public String readProperty(String propName) {
		String value = "";
		try {
			properties
					.load(new FileInputStream("utility//tempProp.properties"));
			value = properties.getProperty(propName);

		} catch (IOException e) {
		}
		return value;

	}

	@Override
	public void writeProperty(String propName, String value) {
		// Write properties file.
		try {
			properties.setProperty(propName, value);
			properties.store(new FileOutputStream(
					"utility//tempProp.properties"), null);
		} catch (IOException e) {
		}

	}

	@Override
	public boolean isPropFileExist() {
		if (new File("utility//tempProp.properties").exists())
			return true;
		else
		{
			
			return false;
	}
		}

	// public static void main(String[] args) {
	// PropertyFileIntf pf = new PropertyFileUtility();
	// pf.writeProperty("name", "alok");
	// pf.writeProperty("clos", "alok");
	// pf.writeProperty("casc", "alok");
	// pf.writeProperty("acc", "alok");
	// System.out.println(pf.readProperty("name"));
	// }

}
