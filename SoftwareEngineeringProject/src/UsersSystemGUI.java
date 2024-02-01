import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class UsersSystemGUI extends JFrame{

	userTableGUI theMarksHandler;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable userTable;

	/**
	 * Create the frame.
	 */
	
	LoginFrame x;
	public UsersSystemGUI(userTableGUI marksHandler) {
		x = new LoginFrame();
		theMarksHandler = marksHandler;
		
		setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 80, 734, 551);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change password");
		mnNewMenu.add(mntmChangePassword);
		mntmChangePassword.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ChangePassword jframe = new ChangePassword();
          	jframe.setVisible(true);
			}
		});
	
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		
		JButton btnNewUser = new JButton("Add User");
		if(x.a==0) {
			btnNewUser.setVisible(false);
		}else {
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
                // Show the dialog
                NewUserDialog dialog = new NewUserDialog();
                dialog.setVisible(true);
                // Get the user id from the dialog
                String newusername = (String) ((dialog.nameField.getText().trim()));
                
                if(newusername != ""){
                    String hassed_password = "";
                    int employee_id = 0;
                    int AdminSection  = 0;
                    
                    
                    try {
                    hassed_password = (dialog.passwordField.getText().trim());
                    } catch (NumberFormatException ex) {
                        hassed_password ="";
                    }
                    try {
                        employee_id = Integer.parseInt(dialog.employeeField.getText().trim());

                    }catch (NumberFormatException ex) {
                        employee_id = 0;
                    }
                    try {
                    	AdminSection = Integer.parseInt((String) dialog.adminSection.getSelectedItem());
                        

                    }catch (NumberFormatException ex) {
                        AdminSection = 0;
                    }
                    theMarksHandler.addUserName(newusername,hassed_password, employee_id, AdminSection);    
                }
            }
        });
		bottomPanel.add(btnNewUser);
		}
	
		JButton MotorsButton = new JButton("Motors");
		MotorsButton.addActionListener(new ActionListener() {
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
		}
	});
		bottomPanel.add(MotorsButton);
		
		JButton btnEditUserInformation = new JButton("Edit user information");
		btnEditUserInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = userTable.getSelectedRow();
				
				 UserInformation ui = new UserInformation();
	
				int i = userTable.getSelectedRow();
	

				if(i>=0) {
					ChangeInfoDialog dialog = new ChangeInfoDialog();
					dialog.usernameField.setText((String)userTable.getValueAt(i, 1).toString());
					dialog.setVisible(true);

					String username = ""; 
					String password = "";
					int Employee_id = 0;
					int AdminSection = 0 ;
									
					try {
						username = dialog.usernameField.getText().trim();
				
					}catch (NumberFormatException ex) {
						username = "";
					
					}
					try {
						password = (dialog.passwordField.getText().trim());
					
					} catch (NumberFormatException ex) {
						password ="";
				
					}
					try {
						Employee_id = Integer.parseInt(dialog.employeetextField.getText().trim());
					
					} catch (NumberFormatException ex) {
						Employee_id = 0;
				
					}
					try {
						AdminSection = Integer.parseInt(dialog.AdminTextField.getText().trim());
					
					} catch (NumberFormatException ex) {
						AdminSection =0;
				
					}
					theMarksHandler.EditUserInformation(username, password,(int)userTable.getValueAt(i,2),(int)userTable.getValueAt(i, 3));	
				}
			}
		});
		bottomPanel.add(btnEditUserInformation);
		if(x.a==0) {
			btnNewUser.setVisible(false);
		}else {
		JButton  btnRemoveUser = new JButton(" Remove user");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Find the student in the selected row.
				int rowToDelete = userTable.getSelectedRow();
				
				// If row is selected, delete it
				if(rowToDelete>=0) {
					String nameToDelete = (String) userTable.getValueAt(rowToDelete, 0);
					theMarksHandler.RemoveUser(nameToDelete);
				}
				JOptionPane.showMessageDialog(null, "User Deleted");
			}

		});
		bottomPanel.add(btnRemoveUser);
		}
		
		JButton btnLogout = new JButton("Logout");
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame theMainWindow;            
		        VultureServiceSystemDatabase data;
		        LoginFrame LoginFrame = new LoginFrame();

		        data = new VultureServiceSystemDatabase();
		        theMainWindow = new LoginFrame();
		        theMainWindow.setVisible(true);
				LoginFrame jframe = new LoginFrame();
	          	jframe.setVisible(true);
				}
			});

		bottomPanel.add(btnLogout);
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel topLabel = new JLabel("User Information");
		topLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		topPanel.add(topLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		userTable = new JTable();
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User name", "Password","Employee ID", "Administrator"
			}
		));
		userTable.getColumnModel().getColumn(0).setPreferredWidth(250);
		scrollPane.setViewportView(userTable);
	}
	
	void displayTableData(ArrayList<UserInformation> tableData){
		
		// Empty the existing data
		DefaultTableModel tableModel = (DefaultTableModel) userTable.getModel();
		tableModel.setRowCount(0);
		
		// Some safety code missing here
		for(UserInformation s: tableData) {
			tableModel.addRow(new Object[] {s.getusername(), s.getPassword(),s.getEmployee_id(),s.getAdminSection()});
		}
	}
}