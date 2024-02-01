import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class InspectionTwoGUI extends JFrame {

	private JPanel contentPane;
	static JTable InspectionTwoTable;
	InspectionTwoList InspectionTwoHandler;
	

	/**
	 * Create the frame.
	 */
	public InspectionTwoGUI(InspectionTwoList Handler) {
		InspectionTwoHandler = Handler;
		setBackground(Color.GRAY);
		addComponentListener(new ComponentAdapter() {
			@Override
			
			public void componentResized(ComponentEvent e) {
			
			}
		});
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH); 
	setBounds(100, 100, 1044, 547);
	setVisible(false);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	JPanel Button_Panel = new JPanel();
	contentPane.add(Button_Panel, BorderLayout.SOUTH);
	
	
	JButton btnDeleteInspectionTwo = new JButton("Delete Inspection Two");
	btnDeleteInspectionTwo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			
			int rowToDelete = InspectionTwoTable.getSelectedRow();
			
			if(InspectionTwoTable.getSelectedRow() != -1) {
				String nameToDelete = (String) InspectionTwoTable.getValueAt(rowToDelete, 0).toString();
				InspectionTwoHandler.deleteInspectionTwo(nameToDelete);
	               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
	            }	
		}		
	});
	
	JButton btnEditDetails = new JButton("Edit Inspection Two");
	btnEditDetails.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

			int i = InspectionTwoTable.getSelectedRow();
			InspectionTwo temp= new InspectionTwo();

			if(i>=0) {
				NewInspectionTwoDialog dialog = new NewInspectionTwoDialog();
				dialog.motor_id.setText((String)InspectionTwoTable.getValueAt(i, 1).toString());
				dialog.setVisible(true);

				int motor_id = 0; 
				String technician = "";
				String final_approval = "";
			

				
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
					final_approval = (String) dialog.final_approval.getSelectedItem();
			
				}catch (NumberFormatException ex) {
					final_approval = "";
		
				}
				InspectionTwoHandler.updateInspectionTwo((int) InspectionTwoTable.getValueAt(i, 0), motor_id, technician, final_approval);	

			}

			
		}
	});
	Button_Panel.add(btnEditDetails);
	Button_Panel.add(btnDeleteInspectionTwo);

	JButton btnMotor = new JButton("Motor");
	btnMotor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			MotorGUI theMainWindow;			
			VultureServiceSystemDatabase data;
			MotorList MotorList=new MotorList();

			
			data = new VultureServiceSystemDatabase();
			theMainWindow = new MotorGUI(MotorList);
			theMainWindow.setVisible(true);
			System.out.println("constructor");
			System.out.println(data.GetAllMotors().size());
			theMainWindow.displayTableData(data.GetAllMotors());
		
		}});
	
	Button_Panel.add(btnMotor);

	
	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane, BorderLayout.CENTER);


	InspectionTwoTable = new JTable();
	InspectionTwoTable.setForeground(Color.GRAY);
	InspectionTwoTable.setBackground(Color.PINK);
	InspectionTwoTable.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"Inspection Two ID", "motor ID", "Technician", "Final Approval"
		}
	));
	
	
	scrollPane.setViewportView(InspectionTwoTable);

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


	JLabel lblNewLabel = new JLabel("Inspection Two");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
	panel.add(lblNewLabel);
	

}

public static void AddRowToJTable(Object[] dataRow) {

	DefaultTableModel model = (DefaultTableModel) InspectionTwoTable.getModel();
	model.addRow(dataRow);
	
}
InspectionTwoGUI theMainWindow;			
VultureServiceSystemDatabase data;

	public void displayTableData(ArrayList <InspectionTwo> tableData) {

		DefaultTableModel tableModel = (DefaultTableModel) InspectionTwoTable.getModel();
		tableModel.setRowCount(0);
		System.out.println(tableData.size());



		for(InspectionTwo s: tableData) {
			tableModel.addRow(new Object[] {s.getinspectionTwo_id(), s.getmotor_id(), s.gettechnician(), s.getfinal_approval()});
		} 
	
	}
	
}
