package ui;

import intf.PropertyFileIntf;
import intf.XMLReader;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utility.PropertyFileUtility;
import utility.Read4mXML;
import utility.RunVBScript;
import utility.TemplatePath;

public class MainUI extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3316321777392883509L;
	private JButton newTaskButton ;
    private JButton startTaskButton; 
    private JButton IssueTaskButton ;
    private JButton DeliveryTaskbutton ;
    private JButton AlertButton; 
    private JButton OverLoadTaskButton ;
    private JButton VerificationTaskbutton ;
    private JButton RefreshListButton ;
    private JMenuItem  configuration;
    private JMenu  config;
    private JMenuBar menuBar;
    
    private JPanel comboBoxPanel;
    private JPanel taskButtonPanel;
    private static MainUI instance = new MainUI();
    private XMLReader xReader= new Read4mXML();
    private PropertyFileIntf  intf= new PropertyFileUtility();
  //  private Object[] labels = xReader.getTasklist().toArray();
  //  private DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
    private JComboBox comboBox1 = new JComboBox();
    
 	private MainUI(){
		createUI();
		
	}
	public static MainUI getInstance(){
		return instance;
	}
	void createUI(){
		
		configuration = new JMenuItem("SetConfig");
		config = new JMenu("Configuration");
		menuBar = new JMenuBar();	
        comboBoxPanel = new JPanel();
        taskButtonPanel = new JPanel();
      
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new FlowLayout());
	    this.setResizable(false);
	    
	    
	    taskButtonPanel.setBorder(BorderFactory.createTitledBorder("Template Type :"));
	    comboBoxPanel.setLayout(new FlowLayout());
	    taskButtonPanel.setLayout(new FlowLayout());
	    
	    config.add(configuration);
	    menuBar.add(config);
	  	    	   	 
	    configuration.addActionListener(this);
	    comboBox1.setPreferredSize(new Dimension(300,25));
	    comboBox1.setEditable(true);

	    RefreshListButton= new JButton("Refresh List");
	     newTaskButton = new JButton("New");
	     startTaskButton = new JButton("Start");
	     IssueTaskButton = new JButton("Issue");
	     DeliveryTaskbutton = new JButton("Delivery");
	     AlertButton = new JButton("Alert");
	     OverLoadTaskButton = new JButton("Overload");
	     VerificationTaskbutton= new JButton("Verification");
	     
	     comboBoxPanel.add(newTaskButton);
	     comboBoxPanel.add(comboBox1);
	     comboBoxPanel.add(RefreshListButton);
	     
	     taskButtonPanel.add(startTaskButton);
	     taskButtonPanel.add(IssueTaskButton);
	     taskButtonPanel.add(OverLoadTaskButton);
	     taskButtonPanel.add(DeliveryTaskbutton);
	     taskButtonPanel.add(AlertButton);
	     taskButtonPanel.add(VerificationTaskbutton);
	    
	     this.setJMenuBar(menuBar);
	     this.add(comboBoxPanel);
	     this.add(taskButtonPanel);
	  
	     newTaskButton.addActionListener(this);
	    RefreshListButton.addActionListener(this);
	     startTaskButton.addActionListener(this);
	    IssueTaskButton.addActionListener(this);
	    OverLoadTaskButton.addActionListener(this);
	    DeliveryTaskbutton.addActionListener(this);
	    AlertButton.addActionListener(this);
	    VerificationTaskbutton.addActionListener(this);
	    
	    this.setSize(600,200);
	    this.setVisible(true);
	    setComboBox();
	    TemplatePath.setTemplatePath();
	  }
	public static void main(String[] args) {
		MainUI.getInstance().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(intf.isPropFileExist()){
		if(arg0.getSource().equals(newTaskButton)){
				new TaskFormToFill();
		
	    }else if(arg0.getSource().equals(startTaskButton)){
			//new CreateStartTemplate(xReader.getTask(comboBox1.getSelectedItem().toString()));
		    new RunVBScript(xReader.getTask(comboBox1.getSelectedItem().toString()),"startTask");
			
		}else if(arg0.getSource().equals(IssueTaskButton)){
			  new RunVBScript(xReader.getTask(comboBox1.getSelectedItem().toString()),"IssueTask");
			
		}else if(arg0.getSource().equals(OverLoadTaskButton)){
			  new RunVBScript(xReader.getTask(comboBox1.getSelectedItem().toString()),"OverLoadTask");
		
		}else if(arg0.getSource().equals(DeliveryTaskbutton)){
			  new RunVBScript(xReader.getTask(comboBox1.getSelectedItem().toString()),"DeliveryTask");
			
		}else if(arg0.getSource().equals(AlertButton)){
		  
			  new RunVBScript(xReader.getTask(comboBox1.getSelectedItem().toString()),"AlertTask");
		}else if(arg0.getSource().equals(VerificationTaskbutton)){
		  
			  new RunVBScript(xReader.getTask(comboBox1.getSelectedItem().toString()),"VerificationTask");
		}else if(arg0.getSource().equals(RefreshListButton)){
			 setComboBox();
			 
		}
		}else{
			JOptionPane.showMessageDialog(null, "Configuration File not exist");
		} if(arg0.getSource().equals(configuration)){
			new ConfigurationUI();
		}
	
	
		}
	void setComboBox(){
		comboBox1.removeAllItems();
		HashSet<String> list = new HashSet<String>(xReader.getTasklist());
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String taskName = (String) iterator.next();
			comboBox1.addItem(taskName);
			
		}
		setButtonsProperty();
	}
	
	void setButtonsProperty(){
		    
		    startTaskButton.setEnabled(comboBox1.getItemCount()>0);
		    IssueTaskButton.setEnabled(comboBox1.getItemCount()>0);
		    OverLoadTaskButton.setEnabled(comboBox1.getItemCount()>0);
		    DeliveryTaskbutton.setEnabled(comboBox1.getItemCount()>0);
		    AlertButton.setEnabled(comboBox1.getItemCount()>0);
		    VerificationTaskbutton.setEnabled(comboBox1.getItemCount()>0);
	}
			
	
}
