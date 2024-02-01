import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class InspectionOneGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	InspectionOneList InspectionOneHandler;
	static JTable InspectionOneTable;
	VultureServiceSystemDatabase VultureServiceSystemGUI=new VultureServiceSystemDatabase();

	/**
	 * Create the frame.
	 */
	
	public InspectionOneGUI(InspectionOneList Handler) {
		InspectionOneHandler = Handler;
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

		JButton btnDeleteInspectionOne = new JButton("Delete Inspection One");
		btnDeleteInspectionOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				int rowToDelete = InspectionOneTable.getSelectedRow();
				
				if(InspectionOneTable.getSelectedRow() != -1) {
					String nameToDelete = (String) InspectionOneTable.getValueAt(rowToDelete, 0).toString();
					InspectionOneHandler.deleteInspectionOne(nameToDelete);
		               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
		            }	
			}		
		});
		
		JButton btnEditinspOne = new JButton("Edit Inspection One");
		btnEditinspOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i = InspectionOneTable.getSelectedRow();
				InspectionOne temp= new InspectionOne();

				if(i>=0) {
					
					NewInspectionAOneDialog dialog = new NewInspectionAOneDialog();
					dialog.motor_id.setText((String)InspectionOneTable.getValueAt(i, 1).toString());
					dialog.setVisible(true);

					int motor_id = 0; 
					String technician = "";
					String tech_comments  = "";
					String initial_approval  = "";
				

					
					try {
						motor_id = Integer.parseInt(dialog.motor_id.getText().trim());
				
					}catch (NumberFormatException ex) {
						motor_id = 0;
					
					}
					try {
						technician = (dialog.technician.getText().trim());
					
					} catch (NumberFormatException ex) {
						technician ="";
				
					}
					try {
						tech_comments = (dialog.tech_comments.getText().trim());
					
					} catch (NumberFormatException ex) {
						tech_comments ="";
				
					}
					try {
						initial_approval = (String) dialog.initial_approval.getSelectedItem();
				
					}catch (NumberFormatException ex) {
						initial_approval = "";
			
					}
					InspectionOneHandler.updateInspectionOne((int) InspectionOneTable.getValueAt(i, 0), motor_id, technician, tech_comments, initial_approval);	

				}else {
					JOptionPane.showMessageDialog(null, "Select a motor!");
				}
					
			}
		});
		Button_Panel.add(btnEditinspOne);
		
		Button_Panel.add(btnDeleteInspectionOne);

		JButton btnMotor = new JButton("Motor");
		Button_Panel.add(btnMotor);
		btnMotor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				MotorGUI theMainWindow;			
				VultureServiceSystemDatabase data;
				MotorList MotorList = new MotorList();

				data = new VultureServiceSystemDatabase();
				theMainWindow = new MotorGUI(MotorList);
				theMainWindow.setVisible(true);
				System.out.println("constructor");
				System.out.println(data.GetAllMotors().size());
				theMainWindow.displayTableData(data.GetAllMotors());
			
			}});
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
	
	
		InspectionOneTable = new JTable();
		InspectionOneTable.setForeground(Color.GRAY);
		InspectionOneTable.setBackground(Color.PINK);
		InspectionOneTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"InspectionID", "motor_id", "technician", "tech_comments", "initial_approval"
			}
		));
		
		
		scrollPane.setViewportView(InspectionOneTable);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.NORTH);
	
	
		JLabel lblNewLabel_1 = new JLabel("Vulture System ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBackground(new Color(255, 175, 175));
		
		
		panel.add(lblNewLabel_1);JLabel lblNewLabel_11 = new JLabel("Vulture System ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_11.setBackground(new Color(255, 175, 175));
		panel.add(lblNewLabel_11);
	
	
		JLabel lblNewLabel = new JLabel("Inspection One");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);

	}
	
	public static void AddRowToJTable(Object[] dataRow) {
	
		DefaultTableModel model = (DefaultTableModel) InspectionOneTable.getModel();
		model.addRow(dataRow);
		
	}
	InspectionOneGUI theMainWindow;			
	private VultureServiceSystemDatabase data;
	
		public void displayTableData(ArrayList<InspectionOne> tableData) {

			DefaultTableModel tableModel = (DefaultTableModel) InspectionOneTable.getModel();
			tableModel.setRowCount(0);
			System.out.println(tableData.size());
	
	
	
			for(InspectionOne s: tableData) {
				tableModel.addRow(new Object[] {s.getinspectionOne_id(), s.getmotor_id(), s.gettechnician(), s.gettech_comments(), s.getinitial_approval()});
			} 
		
		}
		
}