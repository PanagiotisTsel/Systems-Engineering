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
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class NewTaskDialog extends JDialog {

	/**
	 * 
	 */
	//employee_id INTEGER NOT NULL,
	//employee_id2 Integer,
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField motor_id;
	public JTextField task_id;
	public JTextField task_name;
	public JTextField task_desc;
	public JComboBox tasktype;
	public JTextField expected_duration;
	public JTextField task_duration;
	public JComboBox task_priority;
	public JTextField assigned_tech;
	public JTextField assigned_tech2;
	public JTextField date_allocated;
	String[] priority = {"High", "Low"};
	public JTextField employee_id;
	public JTextField employee_id2;
	String[] type = {"Easy", "Medium", "Hard"};

	/**
	 * Create the dialog.
	 */
	public NewTaskDialog() {

		setModal(true);
		setBounds(100, 100, 1133, 795);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel lblmotorid = new JLabel("Motor ID");
			lblmotorid.setBounds(0, 0, 153, 123);
			contentPanel.add(lblmotorid);
			}
			{
			motor_id = new JTextField();
			motor_id.setEditable(false);
			motor_id.setColumns(10);
			motor_id.setBounds(163, 0, 153, 123);
			contentPanel.add(motor_id);
			}
		{
			JLabel lblNewLabel = new JLabel("Task ID");
			lblNewLabel.setBounds(326, 0, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			task_id = new JTextField();
			task_id.setBounds(489, 0, 153, 123);
			contentPanel.add(task_id);
			task_id.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("task Name");
			lblNewLabel_1.setBounds(652, 0, 153, 123);
			contentPanel.add(lblNewLabel_1);
		}
		{
			task_name = new JTextField();
			task_name.setBounds(820, 0, 153, 123);
			contentPanel.add(task_name);
			task_name.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Task Description");
			lblNewLabel.setBounds(0, 134, 158, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			task_desc = new JTextField();
			task_desc.setBounds(163, 134, 153, 123);
			contentPanel.add(task_desc);
			task_desc.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Task Type");
			lblNewLabel.setBounds(326, 134, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			tasktype = new JComboBox(type);
			tasktype.setBounds(489, 129, 153, 128);
			contentPanel.add(tasktype);
		}
		{
			JLabel lblNewLabel = new JLabel("Expected Duration");
			lblNewLabel.setBounds(652, 134, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			expected_duration = new JTextField();
			expected_duration.setBounds(820, 134, 153, 123);
			contentPanel.add(expected_duration);
			expected_duration.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("Task Duration");
			lblNewLabel.setBounds(0, 264, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			task_duration = new JTextField();
			task_duration.setBounds(163, 264, 153, 123);
			contentPanel.add(task_duration);
			task_duration.setColumns(10);
		}
		//This is a combobox
		{
			JLabel lblNewLabel = new JLabel("task priority");
			lblNewLabel.setBounds(321, 398, 158, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			task_priority = new JComboBox(priority);
			task_priority.setBounds(489, 395, 153, 128);
			contentPanel.add(task_priority);
		}
		
		{
			JLabel lblNewLabel = new JLabel("Assigned Tech");
			lblNewLabel.setBounds(326, 264, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			assigned_tech = new JTextField();
			assigned_tech.setBounds(489, 261, 153, 123);
			contentPanel.add(assigned_tech);
			assigned_tech.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("Assigned Tech 2");
			lblNewLabel.setBounds(672, 268, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			assigned_tech2 = new JTextField();
			assigned_tech2.setBounds(820, 268, 153, 123);
			contentPanel.add(assigned_tech2);
			assigned_tech2.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("Date Allocated");
			lblNewLabel.setBounds(0, 398, 153, 123);
			contentPanel.add(lblNewLabel);
		}
		{
			date_allocated = new JTextField();
			date_allocated.setBounds(163, 398, 153, 123);
			contentPanel.add(date_allocated);
			date_allocated.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(953, 389, 158, 128);
			contentPanel.add(label);
		}
		{
			JLabel lblEmployeeId = new JLabel("Employee ID");
			lblEmployeeId.setBounds(672, 402, 153, 123);
			contentPanel.add(lblEmployeeId);
		}
		{
			employee_id = new JTextField();
			employee_id.setColumns(10);
			employee_id.setBounds(820, 402, 153, 123);
			contentPanel.add(employee_id);
		}
		{
			JLabel lblEmployeeId_1 = new JLabel("Employee ID 2");
			lblEmployeeId_1.setBounds(0, 552, 153, 123);
			contentPanel.add(lblEmployeeId_1);
		}
		{
			employee_id2 = new JTextField();
			employee_id2.setColumns(10);
			employee_id2.setBounds(163, 552, 153, 123);
			contentPanel.add(employee_id2);
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
						task_id.setText("");
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
		txtpnNewMotorDetails.setText("New Task Details");
		panel.add(txtpnNewMotorDetails);
	}
}
