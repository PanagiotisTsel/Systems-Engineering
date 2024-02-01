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
public class MotorGUI extends JFrame {
	

	MotorList motorHandler;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable motorTable;
	VultureServiceSystemDatabase data;
	

LoginFrame x;
	/**
	 * Create the frame.
	 */
	
	public MotorGUI(MotorList handler) {
		data = new VultureServiceSystemDatabase();
		x = new LoginFrame();
		motorHandler = handler;
		setBackground(Color.GRAY);
		addComponentListener(new ComponentAdapter() {
			@Override
			
			public void componentResized(ComponentEvent e) {
			
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setBounds(100, 100, 1806, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel Button_Panel = new JPanel();
		contentPane.add(Button_Panel, BorderLayout.SOUTH);

		JButton btnRecordDetils = new JButton("Record Details");
		btnRecordDetils.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Show the dialog
				NewMotorDialog dialog = new NewMotorDialog();
				dialog.setVisible(true);

				
				// Get the motor id from the dialog
				int newMotorId = Integer.parseInt((dialog.motor_id.getText().trim()));
				
				// If the motor id smaller than zero, then Cancel was probably pressed
				if(newMotorId >= 0){
					String motor_name = "";
					int motorMan_id = 0;
					String motorMan_name = "";
					String dateOfArrival = "";
					String reported_problems = "";
					int customer_id = 0;
					int estimated_cost = 0;
					String total_ExpectedDuration = "";
					String motor_status = "";
					int motor_DelayCount = 0;
					String date_OfCompletion= "";
					
					try {
						motor_name = (dialog.motor_name.getText().trim());
					} catch (NumberFormatException ex) {
						motor_name ="";
					}
					try {
						motorMan_id = Integer.parseInt(dialog.motorMan_id.getText().trim());

					}catch (NumberFormatException ex) {
						motorMan_id = 0;
					}
					try {
						motorMan_name = (dialog.motorMan_name.getText().trim());

					}catch (NumberFormatException ex) {
						motorMan_name = "";
					}
					try {
						dateOfArrival = (dialog.dateOfArrival.getText().trim());

					}catch (NumberFormatException ex) {
						dateOfArrival = "";
					}
					try {
						reported_problems = (dialog.reported_problems.getText().trim());

					}catch (NumberFormatException ex) {
						reported_problems = "";
					}
					try {
						customer_id = Integer.parseInt(dialog.customer_id.getText().trim());

					}catch (NumberFormatException ex) {
						customer_id = 0;
					}
					try {
						estimated_cost = Integer.parseInt(dialog.estimated_cost.getText().trim());

					}catch (NumberFormatException ex) {
						estimated_cost = 0;
					}
					try {
						total_ExpectedDuration = (dialog.total_ExpectedDuration.getText().trim());

					}catch (NumberFormatException ex) {
						total_ExpectedDuration = "";
					}
					try {
						motor_status = (String) dialog.motor_status.getSelectedItem();
					}catch (NumberFormatException ex) {
						motor_status = "";
					}
					try {
						motor_DelayCount = Integer.parseInt(dialog.motor_DelayCount.getText().trim());
					}catch (NumberFormatException ex) {
						motor_DelayCount = 0;
					}
					try {
						date_OfCompletion = (dialog.date_OfCompletion.getText().trim());

					}catch (NumberFormatException ex) {
						date_OfCompletion= "";
					}
					
					motorHandler.addMotor(newMotorId, motor_name, motorMan_id, motorMan_name, dateOfArrival, reported_problems, customer_id, estimated_cost, total_ExpectedDuration, motor_status, motor_DelayCount, date_OfCompletion);	
				}
	
			}
		});
		
		JPanel panel_1 = new JPanel();
		Button_Panel.add(panel_1);
		
		
		

		JButton btnToRefresh = new JButton("Refresh");
		btnToRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This opens a new GUI as a refresh to get the info when you record detail. It gets the info but you have to reopen the GUI

			
				MotorGUI theMainWindow;			
				VultureServiceSystemDatabase data;
				MotorList MotorList = new MotorList();

				data = new VultureServiceSystemDatabase();
				theMainWindow = new MotorGUI(MotorList);
				theMainWindow.setVisible(true);
				System.out.println("constructor");
				System.out.println(data.GetAllMotors().size());
				theMainWindow.displayTableData(data.GetAllMotors());
				JOptionPane.showMessageDialog(null, "Page Refreshed!");

              

             
				  repaint();
				  System.out.println("Gets inside the func.");
			}

		});
		panel_1.add(btnToRefresh);
		
		Button_Panel.add(btnRecordDetils);
		;
		
		if(x.a==0) {
			
		}
		JButton btnDelMot = new JButton("Delete Record");
		btnDelMot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				int rowToDelete = motorTable.getSelectedRow();
				
				if(motorTable.getSelectedRow() != -1) {
					String nameToDelete = (String) motorTable.getValueAt(rowToDelete, 0).toString();
					motorHandler.deleteMotor(nameToDelete);
		               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
		            }	else {
						JOptionPane.showMessageDialog(null, "Select a motor!");
					}
			}		
		});
	
		Button_Panel.add(btnDelMot);

		
		JButton btnEditDetails = new JButton("Edit Details");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				int i = motorTable.getSelectedRow();
				
				if(i>=0) {
					NewMotorDialog dialog = new NewMotorDialog();
					dialog.motor_id.setText((String) motorTable.getValueAt(i, 0).toString());
					dialog.setVisible(true);
			
					String motor_name = "";
					int motorMan_id = -1;
					String motorMan_name = "";
					String dateOfArrival = "";
					String reported_problems = "";
					int customer_id = -1;
					int estimated_cost = -1;
					String total_ExpectedDuration = "";
					String motor_status = "";
					int motor_DelayCount = -1;
					String date_OfCompletion= "";
					
					try {
						motor_name = (dialog.motor_name.getText().trim());
					
					} catch (NumberFormatException ex) {
						motor_name ="";
				
					}
					try {
						motorMan_id = Integer.parseInt(dialog.motorMan_id.getText().trim());
				
					}catch (NumberFormatException ex) {
						motorMan_id = 0;
					
					}
					try {
						motorMan_name = (dialog.motorMan_name.getText().trim());
				
					}catch (NumberFormatException ex) {
						motorMan_name = "";
			
					}
					try {
						dateOfArrival = (dialog.dateOfArrival.getText().trim());
				
					}catch (NumberFormatException ex) {
						dateOfArrival = "";
					
					}
					try {
						reported_problems = (dialog.reported_problems.getText().trim());
				
					}catch (NumberFormatException ex) {
						reported_problems = "";
					
					}
					try {
						customer_id = Integer.parseInt(dialog.customer_id.getText().trim());
					
					}catch (NumberFormatException ex) {
						customer_id = 0;
					
					}
					try {
						estimated_cost = Integer.parseInt(dialog.estimated_cost.getText().trim());
					
					}catch (NumberFormatException ex) {
						estimated_cost = 0;
		
					}
					try {
						total_ExpectedDuration = (dialog.total_ExpectedDuration.getText().trim());
		
					}catch (NumberFormatException ex) {
						total_ExpectedDuration = "";

					}
					try {
						motor_status = (String) dialog.motor_status.getSelectedItem();
						
					}catch (NumberFormatException ex) {
						motor_status = "";
						
					}
					try {
						motor_DelayCount = Integer.parseInt(dialog.motor_DelayCount.getText().trim());
						
					}catch (NumberFormatException ex) {
						motor_DelayCount = 0;
						
					}
					try {
						date_OfCompletion = (dialog.date_OfCompletion.getText().trim());
						
					}catch (NumberFormatException ex) {
						date_OfCompletion= "";
					
					}
				
					motorHandler.updateMotor((int) motorTable.getValueAt(i, 0), motor_name, motorMan_id, motorMan_name, dateOfArrival, reported_problems, customer_id, estimated_cost, total_ExpectedDuration, motor_status, motor_DelayCount, date_OfCompletion);	

					
				}else {
					JOptionPane.showMessageDialog(null, "Select a motor!");
				}
			
			}
		});
		
		
		
		Button_Panel.add(btnEditDetails);
		
		JButton btnInspectionOne = new JButton("Inspection One");
		Button_Panel.add(btnInspectionOne);
		btnInspectionOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				InspectionOneGUI theMainWindow;			
				InspectionOneList InspectionOneHandler = new InspectionOneList();
				VultureServiceSystemDatabase data;
				
				data = new VultureServiceSystemDatabase();
				theMainWindow = new InspectionOneGUI(InspectionOneHandler);
				theMainWindow.setVisible(true);
				System.out.println("constructor");
				System.out.println(data.GetAllInspectionOne().size());
				theMainWindow.displayTableData(data.GetAllInspectionOne());

			}});
		
		
		
		//This is to add inspection details for a spesific motor.
		JButton btnAddInspection = new JButton("Add Inspection One");
		btnAddInspection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowToEdit = motorTable.getSelectedRow();
				Motor temp= new Motor();
				if(motorTable.getSelectedRow() != -1) {
					String nameToEdit = (String) motorTable.getValueAt(rowToEdit, 0).toString();
					// Show the dialog
					NewInspectionAOneDialog dialog = new NewInspectionAOneDialog();
			
					ArrayList <Motor> find = new ArrayList<Motor>(data.GetAllMotors());
					temp=find.get(rowToEdit);
					
					// Get the motor id from the dialog
					int newInspectionOneID =0;
					
					// If the motor id smaller than zero, then Cancel was probably pressed
					if(rowToEdit >= 0){
						
						int motor_id = 0;
						String technician = "";
						String tech_comments = "";
						String initial_approval = "";
						dialog.motor_id.setText(Integer.toString(temp.getMotorid()));
						dialog.setVisible(true);
						try {
							motor_id = Integer.parseInt(dialog.motor_id.getText().trim());

						}catch (NumberFormatException ex) {
							motor_id = 0;
						}
						try {
							technician = (dialog.technician.getText().trim());
						}catch (NumberFormatException ex) {
							technician = "";
						}
						try {
							tech_comments = (dialog.tech_comments.getText().trim());

						}catch (NumberFormatException ex) {
							tech_comments = "";
						}
						try {
							initial_approval = (String) (dialog.initial_approval.getSelectedItem());

						}catch (NumberFormatException ex) {
							initial_approval = "";
						}
						if(motor_id!=0)
							newInspectionOneID=Integer.parseInt((dialog.inspectionOne_id.getText().trim()));
						InspectionOneList InspectionOneHandler = new InspectionOneList();	
						
						//This is to test that it gets the values.
						System.out.println(newInspectionOneID + motor_id + technician + tech_comments + initial_approval);	

						InspectionOneHandler.AddInspectionOne(newInspectionOneID, motor_id, technician, tech_comments, initial_approval);	
					}
					
					
					JOptionPane.showMessageDialog(null, "Inspection One details for motor with Inspection ID:" + newInspectionOneID);
		            }	
				else{
					JOptionPane.showMessageDialog(null, "You have to select a motor");
				}
			
			}
		});
		Button_Panel.add(btnAddInspection);
		
		JButton btnInspectionTwo = new JButton("Inspection Two");
		Button_Panel.add(btnInspectionTwo);
		btnInspectionTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InspectionTwoGUI theMainWindow;			
				InspectionTwoList InspectionTwoHandler = new InspectionTwoList();
				VultureServiceSystemDatabase data;
				
				data = new VultureServiceSystemDatabase();
				theMainWindow = new InspectionTwoGUI(InspectionTwoHandler);
				theMainWindow.setVisible(true);
				System.out.println("constructor");
				System.out.println(data.GetAllInspectionTwo().size());
				theMainWindow.displayTableData(data.GetAllInspectionTwo());

			}});

		
		
		JButton btnAddInspeTwo = new JButton("Add Inspection Two");
		btnAddInspeTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int rowToEdit = motorTable.getSelectedRow();
				Motor temp= new Motor();
				
				if(motorTable.getSelectedRow() != -1) {
					String nameToEdit = (String) motorTable.getValueAt(rowToEdit, 0).toString();
					// Show the dialog
					NewInspectionTwoDialog dialog = new NewInspectionTwoDialog();
			
					ArrayList <Motor> find = new ArrayList<Motor>(data.GetAllMotors());
					temp=find.get(rowToEdit);
					
					// Get the motor id from the dialog
					int newInspectionTwoID =0;
					
					// If the motor id smaller than zero, then Cancel was probably pressed
					if(rowToEdit >= 0){
						
						int motor_id = 0;
						String technician = "";
						String final_approval = "";
						dialog.motor_id.setText(Integer.toString(temp.getMotorid()));
						dialog.setVisible(true);
						try {
							motor_id = Integer.parseInt(dialog.motor_id.getText().trim());

						}catch (NumberFormatException ex) {
							motor_id = 0;
						}
						try {
							technician = (dialog.technician.getText().trim());
						}catch (NumberFormatException ex) {
							technician = "";
						}
						try {
							final_approval = (String) (dialog.final_approval.getSelectedItem());

						}catch (NumberFormatException ex) {
							final_approval = "";
						}
						if(motor_id!=0)
							newInspectionTwoID=Integer.parseInt((dialog.InspectionID.getText().trim()));
						
						InspectionTwoList InspectionTwoHandler = new InspectionTwoList();				

						InspectionTwoHandler.AddInspectionTwo(newInspectionTwoID, motor_id, technician, final_approval);	
					}
		
					
					JOptionPane.showMessageDialog(null, "Inspection Two details for motor with Inspection ID:" + newInspectionTwoID);
		            }else {
						JOptionPane.showMessageDialog(null, "Select a motor!");
					}	
				

			}});
		Button_Panel.add(btnAddInspeTwo);
		
		
		
		
		JButton btnTasks = new JButton("Tasks");
		btnTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						TaskGUI theMainWindow;			
						TaskList TaskHandler = new TaskList();
						VultureServiceSystemDatabase data;
						
						data = new VultureServiceSystemDatabase();
						theMainWindow = new TaskGUI(TaskHandler);
						System.out.println("constructor");
						System.out.println(data.GetAllInspectionOne().size());
						theMainWindow.displayTableData(data.GetAllTasks());
			}});
		
		Button_Panel.add(btnTasks);
		
		
		
		
		
		
		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowToEdit = motorTable.getSelectedRow();
				
				Motor temp= new Motor();
				
				if(motorTable.getSelectedRow() != -1) {
					String nameToEdit = (String) motorTable.getValueAt(rowToEdit, 0).toString();
					// Show the dialog
					NewTaskDialog dialog = new NewTaskDialog();
			
					ArrayList <Motor> find = new ArrayList<Motor>(data.GetAllMotors());
					temp=find.get(rowToEdit);
					
					// Get the motor id from the dialog
					int newTaskID =0;
					
					// If the motor id smaller than zero, then Cancel was probably pressed
					if(rowToEdit >= 0){
						
						int motor_id = 0;
						String task_id = "";
						String task_name = "";
						String task_desc = "";
						String task_type = "";
						String expected_duration = "";
						String task_duration = "";
						int task_priority = 0;
						String assigned_tech = "";
						String assigned_tech2 = "";
						String date_allocated = "";	
						int employee_id = 0;
						int employee_id2 = 0;
						
						
						dialog.motor_id.setText(Integer.toString(temp.getMotorid()));
						dialog.setVisible(true);
						try {
							motor_id = Integer.parseInt(dialog.motor_id.getText().trim());

						}catch (NumberFormatException ex) {
							motor_id = 0;
						}
						try {
							task_id = (dialog.task_id.getText().trim());
						}catch (NumberFormatException ex) {
							task_id = "";
						}
						try {
							task_name = (dialog.task_name.getText().trim());

						}catch (NumberFormatException ex) {
							task_name = "";
						}
						try {
							task_desc = (dialog.task_desc.getText().trim());
						}catch (NumberFormatException ex) {
							task_desc = "";
						}
						try {
							task_type = (String) (dialog.tasktype.getSelectedItem());
						}catch (NumberFormatException ex) {
							task_type = "";
						}
						try {
							expected_duration = (dialog.expected_duration.getText().trim());
						}catch (NumberFormatException ex) {
							expected_duration = "";
						}
						try {
							task_duration = (dialog.task_duration.getText().trim());
						}catch (NumberFormatException ex) {
							task_duration = "";
						}
						try {
							task_priority = Integer.parseInt((String) dialog.task_priority.getSelectedItem());

						}catch (NumberFormatException ex) {
							task_priority = 0;
						}	
						try {
							assigned_tech = (dialog.assigned_tech.getText().trim());
						}catch (NumberFormatException ex) {
							assigned_tech = "";
						}

						try {
							assigned_tech2 = (dialog.assigned_tech2.getText().trim());
						}catch (NumberFormatException ex) {
							assigned_tech2 = "";
						}
						try {
							date_allocated = (dialog.date_allocated.getText().trim());
						}catch (NumberFormatException ex) {
							date_allocated = "";
						}
						try {
							employee_id = Integer.parseInt(dialog.employee_id.getText().trim());

						}catch (NumberFormatException ex) {
							employee_id = 0;
						}
						try {
							employee_id2 = Integer.parseInt(dialog.employee_id2.getText().trim());

						}catch (NumberFormatException ex) {
							employee_id2 = 0;
						}
						
						if(motor_id!=0)
							newTaskID=Integer.parseInt((dialog.task_id.getText().trim()));
						
						TaskList taskHandler = new TaskList();				

						taskHandler.addTask(newTaskID, motor_id, task_name, task_desc, task_type, expected_duration, task_duration, task_priority, assigned_tech, assigned_tech2, date_allocated, employee_id, employee_id2);	
					}
		
					
					JOptionPane.showMessageDialog(null, "Task details for motor with Task ID:" + newTaskID);
		            }else {
		            	JOptionPane.showMessageDialog(null, "You need to select a motor");
		            }

			}});
		
		Button_Panel.add(btnAddTask);
		
		JButton btnUser = new JButton("User Information");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsersSystemGUI theMainWindow;			
				userTableGUI theMarksHandler = new userTableGUI();
				VultureServiceSystemDatabase data;
				
				data = new VultureServiceSystemDatabase();
				theMainWindow = new UsersSystemGUI(theMarksHandler);
				System.out.println("constructor");
				System.out.println(data.GetAllInspectionOne().size());
				theMainWindow.displayTableData(data.GetAllUsers());
				
				
			}
		});
		Button_Panel.add(btnUser);
	
				
				
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		motorTable = new JTable();
		motorTable.setForeground(Color.GRAY);
		motorTable.setBackground(Color.PINK);
		motorTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"motor_id", "motor_name", "motorMan_id", "motorMan_name", "dateOfArrival", "reported_problems", "Customer_id", "estimate_cost", "total_ExpectedDuration", "motor_status", "motor_DelayCount", "date_OfCompletition"
			}
		));
		scrollPane.setViewportView(motorTable);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Vulture System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBackground(new Color(255, 175, 175));
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("Motor Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
	}


	public static void AddRowToJTable(Object[] dataRow) {
		
		DefaultTableModel model = (DefaultTableModel) motorTable.getModel();
		model.addRow(dataRow);
		
		
	}

	public void displayTableData(ArrayList <Motor> tableData) {
		DefaultTableModel tableModel = (DefaultTableModel) motorTable.getModel();
		tableModel.setRowCount(0);
		System.out.println(tableData.size());
		
		for(Motor s: tableData) {
			tableModel.addRow(new Object[] {s.getMotorid(), s.getmotor_name(), s.getMotorManid(), s.getMotomanName(), s.getDateOfArrival(), s.getreported_problems(), s.getcustomer_id(), s.getestimated_cost(), s.gettotal_ExpectedDuration(), s.getmotor_status(), s.getmotorDelayCount(), s.getdate_OfCompletition()});
		}
		}


	}