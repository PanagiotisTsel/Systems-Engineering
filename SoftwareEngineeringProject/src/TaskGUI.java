import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TaskGUI extends JFrame {
	

	TaskList taskHandler;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable taskTable;
	VultureServiceSystemDatabase data;


	/**
	 * Create the frame.
	 */
	//employee_id INTEGER NOT NULL,
	//employee_id2 Integer,
	public TaskGUI(TaskList taskList) {
		data = new VultureServiceSystemDatabase();
		taskHandler = taskList;
		setBackground(Color.GRAY);
		addComponentListener(new ComponentAdapter() {
			@Override
			
			public void componentResized(ComponentEvent e) {
			
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setBounds(100, 100, 1806, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel Button_Panel = new JPanel();
		contentPane.add(Button_Panel, BorderLayout.SOUTH);
		
		
		
		JButton btnDeltask = new JButton("Delete Task");
		btnDeltask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
int rowToDelete = taskTable.getSelectedRow();
				
				if(taskTable.getSelectedRow() != -1) {
					String nameToDelete = (String) taskTable.getValueAt(rowToDelete, 0).toString();
					taskHandler.deleteTask(nameToDelete);
		               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
		            }else {
						JOptionPane.showMessageDialog(null, "Select a motor!");
					}	
			}		
		});
	
		Button_Panel.add(btnDeltask);

		
		JButton btnEditTask = new JButton("Edit Task");
		btnEditTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = taskTable.getSelectedRow();
				System.out.println("TEST if the edit gets a click = " + i);
				
				if(i >= 0) {
					EditTaskDialog dialog = new EditTaskDialog();
					dialog.motor_id.setText((String)taskTable.getValueAt(i, 0).toString());
					dialog.setVisible(true);
					
					String task_namem = "";
					int task_id  = 0;
					String task_priority  = "";
					String expected_duration = "";
					String assigned_tech = "";
					String assigned_tech2 = "";
					String task_desc = "";
					String textFieldSuspended = "";
					String task_type = "";
					String TaskDuration = "";
					String date_allocated = "";
					
					try {
						task_namem = (dialog.task_namem.getText().trim());
				
					}catch (NumberFormatException ex) {
						task_namem = "";
					
					}
					try {
						task_id = Integer.parseInt(dialog.task_id.getText().trim());
					
					} catch (NumberFormatException ex) {
						task_id = 0;
				
					}
					try {
						task_type = (dialog.task_type.getText().trim());
					
					} catch (NumberFormatException ex) {
						task_type = "";
				
					}
					try {
						task_priority = (dialog.task_priority.getText().trim());
					
					} catch (NumberFormatException ex) {
						task_priority ="";
				
					}
					try {
						expected_duration = (dialog.expected_duration.getText().trim());
				
					}catch (NumberFormatException ex) {
						expected_duration = "";
			
					}
					
					try {
						assigned_tech = (String) (dialog.assigned_tech.getSelectedItem());
						
					} catch (NumberFormatException ex) {
						assigned_tech ="";
			
					}
			
					try {
						assigned_tech2 = (String) (dialog.assigned_tech2.getSelectedItem());
			
					} catch (NumberFormatException ex) {
						assigned_tech2 ="";
				
					}
		
					try {
						task_desc = (dialog.task_desc.getText().trim());
		
					} catch (NumberFormatException ex) {
						task_desc ="";
					}
					try {
						textFieldSuspended = (dialog.textFieldSuspended.getText().trim());
			
					} catch (NumberFormatException ex) {
						textFieldSuspended ="";
				
					}
					try {
						TaskDuration = (dialog.TaskDuration.getText().trim());
			
					} catch (NumberFormatException ex) {
						TaskDuration ="";
				
					}
					try {
						date_allocated = (dialog.date_allocated.getText().trim());
			
					} catch (NumberFormatException ex) {
						date_allocated ="";
				
					}
					
					taskHandler.EditTask((int) taskTable.getValueAt(i, 0), task_id, task_desc, task_type,
							expected_duration, task_type, expected_duration, TaskDuration, task_priority);	

				}else {
					JOptionPane.showMessageDialog(null, "Select a motor!");
				}
			
				
				}
		});
		
		
		Button_Panel.add(btnEditTask);
		
		JButton btnPersonalTaskList = new JButton("Personal Task List");
		btnPersonalTaskList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*PersonalTaskListDialog theMainWindow;            
                VultureServiceSystemDatabase data;
               // PersonalTaskListDialog pers = new PersonalTaskListDialog ();

                data = new VultureServiceSystemDatabase();
                theMainWindow = new PersonalTaskListDialog (pers );
                theMainWindow.setVisible(true);
                System.out.println("constructor");
                System.out.println(data.GetAllTasks().size());
                theMainWindow.displayTableData(data.GetAllTasks());*/
			}
		});
		Button_Panel.add(btnPersonalTaskList);
		
		JButton btnInspectionOne = new JButton("Motor");
		Button_Panel.add(btnInspectionOne);
		btnInspectionOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				MotorGUI theMainWindow;			
				VultureServiceSystemDatabase data;
				MotorList motorHandler = new MotorList();
				
				data = new VultureServiceSystemDatabase();
				theMainWindow = new MotorGUI(motorHandler);
				theMainWindow.setVisible(true);
				System.out.println("constructor");
				System.out.println(data.GetAllMotors().size());
				theMainWindow.displayTableData(data.GetAllMotors());
			
			}});
		
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		taskTable = new JTable();
		taskTable.setForeground(Color.GRAY);
		taskTable.setBackground(Color.PINK);
		taskTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Motor ID","Task ID", "Task Name", "Task Description", "Task Type", "Expected Duration", "Task Duration", "Task Priority", "Assigned Technician", "Date Allocated", "Assigned Technician 2","Employee ID","Employee ID 2"
			}
		));
		scrollPane.setViewportView(taskTable);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Vulture System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBackground(new Color(255, 175, 175));
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("Task Detils");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
	}


	public static void AddRowToJTable(Object[] dataRow) {
		
		DefaultTableModel model = (DefaultTableModel) taskTable.getModel();
		model.addRow(dataRow);
		
		
	}

	public void displayTableData(ArrayList <Task> tableData) {
		DefaultTableModel tableModel = (DefaultTableModel) taskTable.getModel();
		tableModel.setRowCount(0);
		System.out.println(tableData.size());
		
		for(Task s: tableData) {
			tableModel.addRow(new Object[] {s.getmotor_id(), s.gettask_id(), s.gettask_namem(), s.gettask_desc(), s.gettask_type(), s.getexpected_duration(), s.gettask_duration(), s.gettask_priority(), s.getassigned_tech(), s.getassigned_tech2(), s.getdate_allocated(), s.getemployee_id(), s.getemployee_id2()});
		}
		}

	}