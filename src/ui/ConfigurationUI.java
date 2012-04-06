package ui;

import intf.PropertyFileIntf;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utility.PropertyFileUtility;

public class ConfigurationUI extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1797777143957462295L;
	private PropertyFileIntf pf = new PropertyFileUtility();
	private JButton createButton = new JButton("Create Task");

	private JTextField tempLatePath, pathForStartTemplate,
			pathForIssueTemplate, pathForDeliveryTemplate,
			pathForOverloadTemplate, pathForVerificationTemplate,
			pathForAlertTemplate;

	private JButton setPathFolderTemplate = new JButton("Path");
	private JButton setPathForStartTemplate = new JButton("Choose File");
	private JButton setPathForIssueTemplate = new JButton("Choose File");
	private JButton setPathForDeliveryTemplate = new JButton("Choose File");
	private JButton setPathForAlertTemplate = new JButton("Choose File");
	private JButton setPathForOverloadTemplate = new JButton("Choose File");
	private JButton setPathForVerificationTemplate = new JButton("Choose File");
	private JButton save = new JButton("Save");

	// onshoreAdvisorsList = new
	// JTextField("Enter Valid Email Adresses seperated by ;", 25),
	// offshoreAdvisorsList = new
	// JTextField("Enter Valid Email Adresses seperated by ;", 25),
	// technicalReferent = new
	// JTextField("Enter Valid Email Adresses seperated by ;", 25),
	// verifier = new JTextField("Enter Valid Email Adresses seperated by ;",
	// 25);

	public ConfigurationUI() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setValues();
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		addItem(panel1, new JLabel("tempLatePath"), 0, 0, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("pathForStartTemplate"), 0, 1, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("pathForIssueTemplate"), 0, 2, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("pathForDeliveryTemplate"), 0, 3, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("pathForOverloadTemplate"), 0, 4, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("pathForVerificationTemplate"), 0, 5, 1, 1,
				GridBagConstraints.EAST);
		addItem(panel1, new JLabel("pathForAlertTemplate"), 0, 6, 1, 1,
				GridBagConstraints.EAST);

		addItem(panel1, tempLatePath, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(panel1, pathForStartTemplate, 1, 1, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, pathForIssueTemplate, 1, 2, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, pathForDeliveryTemplate, 1, 3, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, pathForOverloadTemplate, 1, 4, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, pathForVerificationTemplate, 1, 5, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, pathForAlertTemplate, 1, 6, 1, 1,
				GridBagConstraints.WEST);

		tempLatePath.setEditable(false);
		pathForStartTemplate.setEditable(false);
		pathForIssueTemplate.setEditable(false);
		pathForDeliveryTemplate.setEditable(false);
		pathForOverloadTemplate.setEditable(false);
		pathForVerificationTemplate.setEditable(false);
		pathForAlertTemplate.setEditable(false);

		addItem(panel1, setPathFolderTemplate, 2, 0, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, setPathForStartTemplate, 2, 1, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, setPathForIssueTemplate, 2, 2, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, setPathForDeliveryTemplate, 2, 3, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, setPathForOverloadTemplate, 2, 4, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, setPathForVerificationTemplate, 2, 5, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, setPathForAlertTemplate, 2, 6, 1, 1,
				GridBagConstraints.WEST);
		addItem(panel1, save, 2, 7, 1, 1, GridBagConstraints.WEST);

		setPathFolderTemplate.addActionListener(this);
		setPathForStartTemplate.addActionListener(this);
		setPathForIssueTemplate.addActionListener(this);
		setPathForDeliveryTemplate.addActionListener(this);
		setPathForOverloadTemplate.addActionListener(this);
		setPathForVerificationTemplate.addActionListener(this);
		setPathForAlertTemplate.addActionListener(this);
		save.addActionListener(this);

		createButton.addActionListener(this);
		this.add(panel1);
		this.pack();
		this.setVisible(true);
		//setValues();
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
	public void actionPerformed(ActionEvent e1) {
		if (e1.getSource().equals(setPathFolderTemplate)) {

			tempLatePath.setText(chooseFold());

		} else if (e1.getSource().equals(setPathForStartTemplate)) {

			pathForStartTemplate.setText(chooseFile("Start Template"));

		} else if (e1.getSource().equals(setPathForIssueTemplate)) {

			pathForIssueTemplate.setText(chooseFile("Issue Template"));

		} else if (e1.getSource().equals(setPathForDeliveryTemplate)) {

			pathForDeliveryTemplate.setText(chooseFile("Delivery Template"));

		} else if (e1.getSource().equals(setPathForAlertTemplate)) {

			pathForAlertTemplate.setText(chooseFile("Alert Template"));

		} else if (e1.getSource().equals(setPathForOverloadTemplate)) {

			pathForOverloadTemplate.setText(chooseFile("Overload Template"));

		} else if (e1.getSource().equals(setPathForVerificationTemplate)) {

			pathForVerificationTemplate.setText(chooseFile("Verification template"));

		} else if (e1.getSource().equals(save)) {

			setPropertFile();
			this.setVisible(false);

		}

	}

	private String chooseFile(String varName) {

		JFileChooser chooser = new JFileChooser(tempLatePath.getText());
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileFilter() {

			@Override
			public String getDescription() {
				return "Template";
			}

			@Override
			public boolean accept(File file) {
				if (file.getName().endsWith(".oft")) {
					return true;
				} else
					return false;
			}

		};

		chooser.setFileFilter(filter);
		chooser.showDialog(null, "Set "+varName);
		String path = "";

		path = chooser.getSelectedFile().getAbsolutePath();
		if (!path.isEmpty())
			return chooser.getSelectedFile().getName();
		else
			return "";
	}

	private String chooseFold() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		chooser.showDialog(null, "SetPath");
		String path = "";

		path = chooser.getSelectedFile().getAbsolutePath();
		if (!path.isEmpty())
			return chooser.getSelectedFile().getAbsolutePath();
		else
			return "";
	}

	private void setPropertFile() {

		pf.writeProperty("tempLatePath", tempLatePath.getText());
		pf.writeProperty("pathForStartTemplate", pathForStartTemplate.getText());
		pf.writeProperty("pathForIssueTemplate", pathForIssueTemplate.getText());
		pf.writeProperty("pathForDeliveryTemplate",
				pathForDeliveryTemplate.getText());
		pf.writeProperty("pathForAlertTemplate", pathForAlertTemplate.getText());
		pf.writeProperty("pathForOverloadTemplate",
				pathForOverloadTemplate.getText());
		pf.writeProperty("pathForVerificationTemplate",
				pathForVerificationTemplate.getText());

	}

	void setValues() {
		if (pf.isPropFileExist()) {
			tempLatePath = new JTextField(pf.readProperty("tempLatePath"), 25);
			pathForStartTemplate = new JTextField(
					pf.readProperty("pathForStartTemplate"), 25);
			pathForIssueTemplate = new JTextField(
					pf.readProperty("pathForIssueTemplate"), 25);
			pathForDeliveryTemplate = new JTextField(
					pf.readProperty("pathForDeliveryTemplate"), 25);
			pathForOverloadTemplate = new JTextField(
					pf.readProperty("pathForOverloadTemplate"), 25);
			pathForVerificationTemplate = new JTextField(
					pf.readProperty("pathForVerificationTemplate"), 25);
			pathForAlertTemplate = new JTextField(
					pf.readProperty("pathForAlertTemplate"), 25);
		} else {
			tempLatePath = new JTextField("", 25);
			pathForStartTemplate = new JTextField("", 25);
			pathForIssueTemplate = new JTextField("", 25);
			pathForDeliveryTemplate = new JTextField("", 25);
			pathForOverloadTemplate = new JTextField("", 25);
			pathForVerificationTemplate = new JTextField("", 25);
			pathForAlertTemplate = new JTextField("", 25);
		}
	}
}
