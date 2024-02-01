import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;

public class NewMotorDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField motor_id;
	public JTextField motor_name;
	public JTextField motorMan_id;
	public JTextField motorMan_name;
	public JTextField dateOfArrival;
	public JTextField reported_problems;
	public JTextField customer_id;
	public JTextField estimated_cost;
	public JTextField total_ExpectedDuration;
	public JComboBox motor_status;
	public JTextField motor_DelayCount;
	public JTextField date_OfCompletion;


	String[] status = {"Active", "Not Active"};


	/**
	 * Create the dialog.
	 */
	public NewMotorDialog() {

		setModal(true);
		setBounds(100, 100, 1133, 666);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBounds(0, 0, 153, 123);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel = new JLabel("motor_id");
			lblNewLabel.setBounds(5, 0, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			motor_id = new JTextField();
			motor_id.setBounds(163, 0, 153, 123);
			contentPanel.add(motor_id);
			motor_id.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("motor_name");
			lblNewLabel_1.setBounds(326, 0, 153, 123);
			contentPanel.add(lblNewLabel_1);
		}
		{
			motor_name = new JTextField();
			motor_name.setBounds(489, 0, 153, 123);
			contentPanel.add(motor_name);
			motor_name.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("motorMan_id");
			lblNewLabel.setBounds(652, 0, 158, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			motorMan_id = new JTextField();
			motorMan_id.setBounds(820, 0, 153, 123);
			contentPanel.add(motorMan_id);
			motorMan_id.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("motorMan_name");
			lblNewLabel.setBounds(0, 134, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			motorMan_name = new JTextField();
			motorMan_name.setBounds(163, 133, 153, 123);
			contentPanel.add(motorMan_name);
			motorMan_name.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("dateOfArrival");
			lblNewLabel.setBounds(321, 139, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			dateOfArrival = new JTextField();
			dateOfArrival.setBounds(489, 134, 153, 123);
			contentPanel.add(dateOfArrival);
			dateOfArrival.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("reported_problems");
			lblNewLabel.setBounds(662, 134, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			reported_problems = new JTextField();
			reported_problems.setBounds(820, 134, 153, 123);
			contentPanel.add(reported_problems);
			reported_problems.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("customer_id");
			lblNewLabel.setBounds(5, 261, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			customer_id = new JTextField();
			customer_id.setBounds(163, 261, 153, 123);
			contentPanel.add(customer_id);
			customer_id.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("estimated_cost");
			lblNewLabel.setBounds(321, 261, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			estimated_cost = new JTextField();
			estimated_cost.setBounds(489, 261, 153, 123);
			contentPanel.add(estimated_cost);
			estimated_cost.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("total_ExpectedDuration");
			lblNewLabel.setBounds(672, 261, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			total_ExpectedDuration = new JTextField();
			total_ExpectedDuration.setBounds(820, 261, 153, 123);
			contentPanel.add(total_ExpectedDuration);
			total_ExpectedDuration.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("motor_status");
			lblNewLabel.setBounds(0, 398, 158, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			motor_status = new JComboBox(status);
			motor_status.setBounds(163, 395, 153, 128);
			contentPanel.add(motor_status);
		}
		
		
		{
			JLabel lblNewLabel = new JLabel("motor_DelayCount");
			lblNewLabel.setBounds(321, 389, 153, 128);
			contentPanel.add(lblNewLabel);
		}
		{
			motor_DelayCount = new JTextField();
			motor_DelayCount.setBounds(489, 389, 153, 128);
			contentPanel.add(motor_DelayCount);
			motor_DelayCount.setColumns(10);
		}
		
		
		{
			JLabel lblNewLabel = new JLabel("date_OfCompletion ");
			lblNewLabel.setBounds(682, 395, 153, 128);
			contentPanel.add(lblNewLabel);
		}
		{
			date_OfCompletion = new JTextField();
			date_OfCompletion.setBounds(820, 395, 153, 128);
			contentPanel.add(date_OfCompletion);
			date_OfCompletion.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(795, 389, 153, 128);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(953, 389, 158, 128);
			contentPanel.add(label);
		}
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
		txtpnNewMotorDetails.setText("New Motor Details");
		panel.add(txtpnNewMotorDetails);
	}
}
