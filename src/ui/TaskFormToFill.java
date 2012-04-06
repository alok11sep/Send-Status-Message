package ui;

import intf.XMLReader;
import intf.XMLWriter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import utility.FormFillService;
import utility.Read4mXML;
import utility.TaskListClass;
import utility.Write2XML;

public class TaskFormToFill extends JDialog implements ActionListener,
		FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1797777143957462295L;

	private JTextField taskName = new JTextField("TaskName", 25),
			onshoreAdvisors = new JTextField("alok@a.com", 25),
			offshoreAdvisors = new JTextField("alok@a.com", 25),
			technicalReferent = new JTextField("alok@a.com", 25),
			verifier = new JTextField("alok@a.com", 25);

	private ArrayList<String> onshoreAdvisorsList = new ArrayList<String>(),
			offshoreAdvisorsList = new ArrayList<String>(),
			technicalReferentList = new ArrayList<String>(),
			verifierList = new ArrayList<String>();

	XMLWriter xWriter = new Write2XML();
	XMLReader xReader = new Read4mXML();

	// onshoreAdvisorsList = new
	// JTextField("Enter Valid Email Adresses seperated by ;", 25),
	// offshoreAdvisorsList = new
	// JTextField("Enter Valid Email Adresses seperated by ;", 25),
	// technicalReferent = new
	// JTextField("Enter Valid Email Adresses seperated by ;", 25),
	// verifier = new JTextField("Enter Valid Email Adresses seperated by ;",
	// 25);

	private ButtonGroup sizeGroup = new ButtonGroup();
	private FormFillService fService = new FormFillService();

	private JRadioButton isa = new JRadioButton(" ISA     "),
			ida = new JRadioButton(" IDA     ");

	private JButton createButton = new JButton("Create Task");

	public TaskFormToFill() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		addItem(panel1, new JLabel("Task Name:"), 0, 0, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Onshore Advisors:"), 0, 1, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Offshore Advisors:"), 0, 2, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Technical referent:"), 0, 3, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Verifier:"), 0, 4, 1, 1,
				GridBagConstraints.EAST);

		addItem(panel1, taskName, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(panel1, onshoreAdvisors, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(panel1, offshoreAdvisors, 1, 2, 1, 1, GridBagConstraints.WEST);
		addItem(panel1, technicalReferent, 1, 3, 1, 1, GridBagConstraints.WEST);
		addItem(panel1, verifier, 1, 4, 1, 1, GridBagConstraints.WEST);

		taskName.addFocusListener(this);
		onshoreAdvisors.addFocusListener(this);
		onshoreAdvisors.addFocusListener(this);
		offshoreAdvisors.addFocusListener(this);
		technicalReferent.addFocusListener(this);
		verifier.addFocusListener(this);

		Box typeBox = Box.createVerticalBox();
		sizeGroup.add(isa);
		sizeGroup.add(ida);
		typeBox.add(isa);
		typeBox.add(ida);
		typeBox.setBorder(BorderFactory.createTitledBorder("Task type:"));
		addItem(panel1, typeBox, 2, 1, 1, 2, GridBagConstraints.NORTH);
		isa.setSelected(true);

		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(createButton);
		buttonBox.add(Box.createHorizontalStrut(20));

		addItem(panel1, buttonBox, 2, 6, 1, 1, GridBagConstraints.NORTH);
		createButton.addActionListener(this);
		this.add(panel1);
		this.pack();
		this.setVisible(true);
	}

	public String getTaskType() {
		if (isa.isSelected())
			return "ISA";
		else
			return "IDA";
	}

	private void addItem(JPanel p, JComponent c, int x, int y, int width,
			int height, int align) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.weightx = 100.0;
		gc.weighty = 100.0;
		gc.insets = new Insets(10, 10, 10, 10);
		gc.anchor = align;
		gc.fill = GridBagConstraints.NONE;
		p.add(c, gc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(createButton)) {
			if (xReader.isTaskNameExist(taskName.getText())) {

				JOptionPane.showMessageDialog(null, taskName.getText()
						+ ": is Already exist.");
				taskName.setText("");
			}else if (taskName.getText().length() != 0) {
				
				setAllAddress();
				fService.createBean();
				saveData();
				this.setVisible(false);
				
			//	MainUI.getInstance().refresh();
			} else {
				JOptionPane
						.showMessageDialog(null, "Task Name Field is Empty.");

			}
		}

	}

	void saveData() {
		xWriter.writeTask(TaskListClass.getInstance());
	}

	@Override
	public void focusGained(FocusEvent e1) {

	}

	@Override
	public void focusLost(FocusEvent e1) {
		if (e1.getSource().equals(offshoreAdvisors)) {

			offshoreAdvisorsList = fService
					.getValidAddressList(offshoreAdvisors);

		} else if (e1.getSource().equals(technicalReferent)) {

			technicalReferentList = fService
					.getValidAddressList(technicalReferent);

		} else if (e1.getSource().equals(verifier)) {

			verifierList = fService.getValidAddressList(verifier);

		} else if (e1.getSource().equals(onshoreAdvisors)) {

			onshoreAdvisorsList = fService.getValidAddressList(onshoreAdvisors);

		} else if (e1.getSource().equals(taskName)) {

			if (xReader.isTaskNameExist(taskName.getText())) {

				JOptionPane.showMessageDialog(null, taskName.getText()
						+ ": is Already exist.");
				taskName.setText("");
			}

		}

	}

	private void setAllAddress() {

		offshoreAdvisorsList = fService.getValidAddressList(offshoreAdvisors);
		technicalReferentList = fService.getValidAddressList(technicalReferent);
		verifierList = fService.getValidAddressList(verifier);
		onshoreAdvisorsList = fService.getValidAddressList(onshoreAdvisors);

		fService.setTaskName(taskName);
		fService.setoffshoreAdvisorsList(convertListToString(offshoreAdvisorsList));
		fService.settechnicalReferent(convertListToString(technicalReferentList));
		fService.setVerifier(convertListToString(verifierList));
		fService.setOnshoreAdvisorsList(convertListToString(onshoreAdvisorsList));
		fService.setTaskType(getTaskType());

	}

	public String convertListToString(ArrayList<String> list) {
		String listString = "";
		for (String s : list) {
			listString += s + ";";
		}
		return listString;
	}
}
