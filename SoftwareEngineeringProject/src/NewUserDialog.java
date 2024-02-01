import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class NewUserDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField nameField;
	public JTextField passwordField;
	private final JLabel lblemployeeID = new JLabel("Employee ID");
	public JTextField employeeField;
	String [] admin = {"0","1"};
	public JComboBox adminSection;

	/**
	 * Create the dialog.
	 */
	public NewUserDialog() {
		setModal(true);
		setBounds(100, 100, 565, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewuser = new JLabel("Add new user");
			lblNewuser.setBounds(5, 6, 269, 82);
			lblNewuser.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPanel.add(lblNewuser);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBounds(274, 6, 269, 41);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblusernameLabel = new JLabel("User Name");
			lblusernameLabel.setBounds(5, 129, 269, 41);
			contentPanel.add(lblusernameLabel);
		}
		{
			nameField = new JTextField();
			nameField.setBounds(274, 129, 269, 41);
			contentPanel.add(nameField);
			nameField.setColumns(10);
		}
		{
			JLabel lblPasswordLabel = new JLabel("Password");
			lblPasswordLabel.setBounds(5, 170, 269, 82);
			contentPanel.add(lblPasswordLabel);
		}
		{
			passwordField = new JTextField();
			passwordField.setBounds(274, 170, 269, 82);
			contentPanel.add(passwordField);
			passwordField.setColumns(10);
		}
		
		{
			lblemployeeID.setBounds(5, 252, 269, 82);
			contentPanel.add(lblemployeeID);
		
			employeeField = new JTextField();
			employeeField.setBounds(274, 252, 269, 82);
			employeeField.setText("0");
			contentPanel.add(employeeField);
			employeeField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Administrator section");
			lblNewLabel.setBounds(10, 72, 264, 41);
			contentPanel.add(lblNewLabel);
		}
		
		adminSection= new JComboBox(admin);
		adminSection.setEditable(false);
		adminSection.setBounds(274, 81, 269, 22);
		contentPanel.add(adminSection);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 setModal(false);
				         dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nameField.setText("");
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
