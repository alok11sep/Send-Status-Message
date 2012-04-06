package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

/**
 * 
 * @author Alok Maheshwary
 * to set the status in file.
 *
 */
 public class FileUtility {
	 FileInputStream iStraem ;
	 FileOutputStream oStraem ;
  	 DataInputStream in; 
 	 DataOutputStream out; 
	String path = "";
	 File file;
	
	public FileUtility(String path){
		this.path =path;
		 file = new File(path);
		 if(!file.exists())
		 {
			 try {
				file.createNewFile();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		 }

	}
	public StringBuffer getData(){
		 StringBuffer sb = null;
			File f = new File(path);
		    try {
		     iStraem = new FileInputStream(f);
			 in = new DataInputStream(iStraem);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  sb = new StringBuffer();
				  String strLine;
				  //Read File Line By Line
				  while ((strLine = br.readLine()) != null)   {
				  // Print the content on the console
				  sb.append("\n"+strLine);
				  }

				  //Close the input stream
				  in.close();
			

			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 return sb;
	}
	public void setData(String value){
	
		    try {
		        	Writer output = null;
		    	  String text = value;
		    //	  file = new File(path);
		    	  output = new BufferedWriter(new FileWriter(file));
		    	  output.write(text);
		          output.close();
	
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	}
	public void setData(String[] value){
	    try {
        	Writer output = null;
        	  output = new BufferedWriter(new FileWriter(file));
        	for (int i = 0; i < value.length; i++) {
        		  String text = value[i];
        	 	  output.write(text);
			}
          output.close();
		} catch (FileNotFoundException e) {
	
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

}
	
}
