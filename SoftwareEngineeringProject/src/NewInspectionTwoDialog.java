import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;

public class NewInspectionTwoDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField InspectionID;
	public JTextField motor_id;
	public JTextField technician;
	public JComboBox final_approval;


	/**
	 * Create the dialog.
	 */
	public NewInspectionTwoDialog() {

		setModal(true);
		setBounds(100, 100, 1133, 666);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Inspection ID");
			lblNewLabel.setBounds(5, 0, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			InspectionID = new JTextField();
			InspectionID.setBounds(163, 0, 153, 123);
			contentPanel.add(InspectionID);
			InspectionID.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Motor ID");
			lblNewLabel_1.setBounds(326, 0, 153, 123);
			contentPanel.add(lblNewLabel_1);
		}
		{
			motor_id = new JTextField();
			motor_id.setEditable(false);
			motor_id.setBounds(489, 0, 153, 123);
			contentPanel.add(motor_id);
			motor_id.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Technician");
			lblNewLabel.setBounds(652, 0, 158, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			technician = new JTextField();
			technician.setBounds(820, 0, 153, 123);
			contentPanel.add(technician);
			technician.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Final Approval");
			lblNewLabel.setBounds(15, 134, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		
		String[] approval = {"Approved","Not Approved"};
		final_approval = new JComboBox(approval);
		final_approval.setBounds(163, 144, 153, 123);
		contentPanel.add(final_approval);
		

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
						motor_id.setText("");
						 setModal(false);
				         dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JTextPane txtpnNewMotorDetails = new JTextPane();
		txtpnNewMotorDetails.setEditable(false);
		txtpnNewMotorDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnNewMotorDetails.setText("New Inspection Two Details");
		panel.add(txtpnNewMotorDetails);
	}
}