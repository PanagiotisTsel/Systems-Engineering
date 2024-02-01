import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditTaskDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField task_namem;
	public JTextField task_id;
	public JTextField task_type;
	public JTextField task_priority;
	public JTextField expected_duration;
	public JComboBox assigned_tech;
	public JComboBox assigned_tech2;
	public JTextField task_desc;
	public JTextField textFieldSuspended;
	public JTextField TaskDuration;
	public JTextField motor_id;
	public JTextField date_allocated;
	

	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			EditTaskDialog dialog = new EditTaskDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public EditTaskDialog() {
		
		setBounds(100, 100, 722, 496);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Task ID");
			lblNewLabel_1.setBounds(10, 82, 215, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			task_id = new JTextField();
			task_id.setBounds(426, 79, 233, 20);
			contentPanel.add(task_id);
			task_id.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Task Name: ");
			lblNewLabel.setBounds(8, 113, 358, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			task_namem = new JTextField();
			task_namem.setBounds(426, 110, 233, 20);
			contentPanel.add(task_namem);
			task_namem.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Task Description: ");
			lblNewLabel_2.setBounds(8, 138, 90, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Task Type:");
			lblNewLabel_3.setBounds(8, 176, 55, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			task_type = new JTextField();
			task_type.setBounds(426, 173, 233, 20);
			contentPanel.add(task_type);
			task_type.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Expected Duration: ");
			lblNewLabel_4.setBounds(10, 258, 99, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			task_priority = new JTextField();
			task_priority.setBounds(426, 204, 233, 20);
			contentPanel.add(task_priority);
			task_priority.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Task Priority:");
			lblNewLabel_5.setBounds(8, 207, 65, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			expected_duration = new JTextField();
			expected_duration.setBounds(426, 255, 233, 20);
			contentPanel.add(expected_duration);
			expected_duration.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Assign a Technician: ");
			lblNewLabel_6.setBounds(8, 315, 105, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JComboBox assigned_tech = new JComboBox();
			assigned_tech.setBounds(426, 307, 233, 22);
			contentPanel.add(assigned_tech);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Assign Second Technician: ");
			lblNewLabel_7.setBounds(10, 369, 135, 14);
			contentPanel.add(lblNewLabel_7);
		}
		{
			assigned_tech2 = new JComboBox();
			assigned_tech2.setBounds(426, 365, 233, 22);
			contentPanel.add(assigned_tech2);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(16, 11, 682, 39);
			contentPanel.add(panel);
			
			JLabel lblNewLabel_8 = new JLabel("Edit Task");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
			panel.add(lblNewLabel_8);
		}
		
		task_desc = new JTextField();
		task_desc.setBounds(426, 141, 233, 20);
		contentPanel.add(task_desc);
		task_desc.setColumns(10);
		
		JCheckBox chcsuspend = new JCheckBox("Suspend Mission");
		chcsuspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if(chcsuspend.isSelected()) {
				textFieldSuspended.setText("Task is suspended.");
			}else {
				textFieldSuspended.setText("Task is not suspended.");

			}
			}
		});
		chcsuspend.setBounds(8, 336, 108, 23);
		contentPanel.add(chcsuspend);
		
		textFieldSuspended = new JTextField();
		textFieldSuspended.setEditable(false);
		textFieldSuspended.setBounds(425, 337, 233, 20);
		contentPanel.add(textFieldSuspended);
		textFieldSuspended.setColumns(10);
		
		JLabel lblTaskDuration = new JLabel("Task Duration");
		lblTaskDuration.setBounds(10, 233, 105, 14);
		contentPanel.add(lblTaskDuration);
		
		TaskDuration = new JTextField();
		TaskDuration.setColumns(10);
		TaskDuration.setBounds(426, 230, 233, 20);
		contentPanel.add(TaskDuration);
		{
			JLabel lblMotorID = new JLabel("Motor ID");
			lblMotorID.setBounds(10, 61, 215, 14);
			contentPanel.add(lblMotorID);
		}
		{
			motor_id = new JTextField();
			motor_id.setEditable(false);
			motor_id.setColumns(10);
			motor_id.setBounds(426, 61, 233, 20);
			contentPanel.add(motor_id);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Date Allocated:");
			lblNewLabel_4.setBounds(10, 290, 99, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			date_allocated = new JTextField();
			date_allocated.setColumns(10);
			date_allocated.setBounds(426, 286, 233, 20);
			contentPanel.add(date_allocated);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
