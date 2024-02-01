import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class PersonalTaskListDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable PersonalListTable;
	VultureServiceSystemDatabase data;
	public JTextField task_namem;
	public JTextField task_id;
	public JTextField task_type;
	public JTextField task_priority;
	public JTextField expected_duration;
	public JComboBox assigned_tech;
	public JComboBox assigned_tech2;
	public JTextField task_desc;
	

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		try {
			//PersonalTaskListDialog dialog = new PersonalTaskListDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public PersonalTaskListDialog(PersonalTaskListDialog listhandler) {
		data = new VultureServiceSystemDatabase();
		
		setBounds(100, 100, 711, 508);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 677, 355);
		contentPanel.add(scrollPane);
		
		PersonalListTable = new JTable();
		PersonalListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Task Name ", "Task Description", "Priority", "Date Allocated"
			}
			
			
		));
		PersonalListTable.getColumnModel().getColumn(0).setPreferredWidth(158);
		PersonalListTable.getColumnModel().getColumn(1).setPreferredWidth(246);
		PersonalListTable.getColumnModel().getColumn(2).setPreferredWidth(81);
		PersonalListTable.getColumnModel().getColumn(3).setPreferredWidth(164);
		
		scrollPane.setViewportView(PersonalListTable);
		
		
		
		JLabel lblNewLabel = new JLabel("Personal Task List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 677, 54);
		contentPanel.add(lblNewLabel);
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
	
	public static void AddRowToJTable(Object[] dataRow) {
		
		DefaultTableModel model = (DefaultTableModel) PersonalListTable.getModel();
		model.addRow(dataRow);
	}
	
	public void displayTableData(ArrayList <Task> tableData) {
		DefaultTableModel tableModel = (DefaultTableModel) PersonalListTable.getModel();
		tableModel.setRowCount(0);
		System.out.println(tableData.size());
		
		for(Task s: tableData) {
			tableModel.addRow(new Object[] {s.gettask_namem(), s.gettask_desc(), s.gettask_priority(), s.getdate_allocated()});
		}
		}
}
