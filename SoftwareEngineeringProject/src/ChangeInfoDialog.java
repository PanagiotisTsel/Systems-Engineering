import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangeInfoDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField usernameField;
	public JLabel existingNameLabel;
	public JTextField passwordField;
	public JLabel passwordLabel;
	public JTextField employeetextField;
	public JTextField AdminTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChangeInfoDialog dialog = new ChangeInfoDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangeInfoDialog() {
		setModal(true);
		setBounds(100, 100, 608, 268);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel LabelUsername = new JLabel("Enter the new username: ");
			LabelUsername.setBounds(43, 13, 125, 14);
			contentPanel.add(LabelUsername);
		}
		{
			existingNameLabel = new JLabel("User's name should be here");
			existingNameLabel.setBounds(173, 13, 132, 14);
			contentPanel.add(existingNameLabel);
		}
		{
			usernameField = new JTextField();
			usernameField.setBounds(310, 10, 86, 20);
			contentPanel.add(usernameField);
			usernameField.setColumns(10);
		}
		
		JLabel labelEnterPassword = new JLabel("Enter the password:");
		labelEnterPassword.setBounds(43, 38, 125, 14);
		contentPanel.add(labelEnterPassword);
		
		JLabel existingpasswordLabel = new JLabel("Password should be here");
		existingpasswordLabel.setBounds(173, 38, 132, 14);
		contentPanel.add(existingpasswordLabel);
		
		passwordField = new JTextField();
		passwordField.setBounds(310, 35, 86, 20);
		contentPanel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel Labelemployee = new JLabel("Employee ID");
		Labelemployee.setBounds(43, 63, 125, 14);
		contentPanel.add(Labelemployee);
		
		JLabel ExistingEmployeeIDLabel = new JLabel("Employee ID should be here");
		ExistingEmployeeIDLabel.setEnabled(false);
		ExistingEmployeeIDLabel.setBounds(169, 63, 151, 14);
		contentPanel.add(ExistingEmployeeIDLabel);
		
		employeetextField = new JTextField();
		employeetextField.setEditable(false);
		employeetextField.setBounds(310, 60, 86, 20);
		contentPanel.add(employeetextField);
		employeetextField.setColumns(10);
		
		JLabel LabelAdmin = new JLabel("Administrator");
		LabelAdmin.setBounds(43, 90, 95, 14);
		contentPanel.add(LabelAdmin);
		
		JLabel existingAdmin = new JLabel("Admin should be here");
		existingAdmin.setEnabled(false);
		existingAdmin.setBounds(173, 88, 132, 14);
		contentPanel.add(existingAdmin);
		
		AdminTextField = new JTextField();
		AdminTextField.setEditable(false);
		AdminTextField.setBounds(310, 88, 86, 20);
		contentPanel.add(AdminTextField);
		AdminTextField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 setModal(false);
				         dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						 setModal(false);
				         dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
