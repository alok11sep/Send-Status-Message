package utility;

import intf.XMLReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TemplatePath extends JFrame{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Write2XML xWriter= new Write2XML();
	  private static String templatePath = new String();
	  private static XMLReader xReader= new Read4mXML();

	public static void setTemplatePath() {
		if(xReader.getTemplatePath().equals("pathNotSet")){
			try{
			templatePath = chooseDir();
			}catch(NullPointerException e){
				JOptionPane.showMessageDialog(null, "You have to give Template path");
				templatePath = chooseDir();
			}
			if(templatePath.length()>0){
			xWriter.setTemplatepath(templatePath);
			}
			
		}
	}
	
	private static String chooseDir() throws NullPointerException{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//		javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileFilter() {
//
//			@Override
//			public String getDescription() {
//				return "Template";
//			}
//
//			@Override
//			public boolean accept(File file) {
//			
//				return false;
//			}
//
//		};
//
//		chooser.setFileFilter(filter);
		chooser.showDialog(null, "SetPath");
		String path = "";
		
		path = chooser.getSelectedFile().getAbsolutePath();
		if(!path.isEmpty())
			return chooser.getSelectedFile().getAbsolutePath();
		else
		return "";
	}

}
