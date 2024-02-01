import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;


public class FirstWindow extends JFrame 
{
	
	
	
	
	public static void main(String[] args) {
		FirstWindow mh = new FirstWindow();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Object ArrayList = null;
	VultureServiceSystemDatabase data = new VultureServiceSystemDatabase();
	private JPanel MainContentPane;
	private JLayeredPane MainPanel;
	private JPanel LoginPanel;
	private JPanel MotorListPanel;
	private JPanel TaskListPanel;
	private JPanel InspectionOnePanel;
	private JPanel InspectionTwoPanel;
	private JPanel ManageUsersPanel;
	private MotorList handler;
	private static JTable motorTable;

	/** Launch the application.*/
	
	

	/**    Create the frame.  */

	//-----------------------------------------------------------------------------------------------
	//The Constructor: 
	public FirstWindow() 
	{
		//Calling the functions:
		initComponents();
		//createEvents();
		
		
	}

	//-----------------------------------------------------------------------------------------------
	//Contains the code for creating and initialising components: 
	private void initComponents() 
	{
		setTitle("Vulture Service System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 608);
		
		//-----------------------------MENU BAR------------------------------------------------------
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//-------------------------------------------------------------------------------------------
		//File menu
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Logout");
		mnFile.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Exit");
		mnFile.add(mntmNewMenuItem_6);
		
		//-------------------------------------------------------------------------------------------
		//Edit Menu
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Undo");
		mnEdit.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Redo");
		mnEdit.add(mntmNewMenuItem_1);
		
		//-------------------------------------------------------------------------------------------
		//About Menu
		JMenu mnNewMenu = new JMenu("About");
		menuBar.add(mnNewMenu);
		
		//--------------------MAIN CONTENT PANE-----------------------------------------------------
		MainContentPane = new JPanel();
		MainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainContentPane);
		MainContentPane.setLayout(null);
		
		//--------------------NAVIGATION PANEL--------------------------------------------------
		//Creating Navigation Panel: 
		JPanel NavPanel = new JPanel();
		NavPanel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		NavPanel.setBounds(865, 11, 129, 439);
		MainContentPane.add(NavPanel);
		
		//-----------------------BUTTONS-------------------------------------------------------
		//Navigation Buttons:
		
		//Login
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScreen(LoginPanel);
			}
		});
		NavPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		NavPanel.add(btnLogin);
		
		//Motor List
		JButton btnMotorList = new JButton("Motor List");
		btnMotorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScreen(MotorListPanel);
			}
		});
		NavPanel.add(btnMotorList);
		
		//Task List
		JButton btnTaskList = new JButton("Task List");
		btnTaskList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScreen(TaskListPanel);
			}
		});
		NavPanel.add(btnTaskList);
		
		//Inspection One
		JButton btnInspectionOne = new JButton("InspectionOne");
		btnInspectionOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScreen(InspectionOnePanel);
			}
		});
		NavPanel.add(btnInspectionOne);
		
		//Inspection Two
		JButton btnInspectionTwo = new JButton("Inspection Two");
		btnInspectionTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScreen(InspectionTwoPanel);
			}
		});
		NavPanel.add(btnInspectionTwo);
		
		//Manage Users
		JButton btnManageUsers = new JButton("Manage Users");
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScreen(ManageUsersPanel);
			}
			
		});
		NavPanel.add(btnManageUsers);
		
		//Extra Button (Add as needed)
		JButton btnNewButton_6 = new JButton("New button");
		NavPanel.add(btnNewButton_6);
		
		
		//------------------------LAYERED PANE---------------------------------------------------------------
		//Creating the Layered Pane: 
		
		MainPanel = new JLayeredPane();
		MainPanel.setBounds(10, 11, 843, 428);
		MainContentPane.add(MainPanel);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//PANEL 1: LOGIN -> LOGIN BUTTON
		
		LoginPanel = new JPanel();
		LoginPanel.setBackground(SystemColor.menu);
		LoginPanel.setBounds(0, 0, 853, 439);
		MainPanel.add(LoginPanel);
	    LoginPanel.setLayout(null);
        
	    //-------------------------------------------------------------------------------------------
	    //LoginPanel Content:
	    
        //LoginPanel is used instead of container, everything login related should be added to this panel.
	    
        //Container container = getContentPane();
	    
	    //LABELS:
	    //Title
	    JLabel lblLoginTitle = new JLabel("Login");
        lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblLoginTitle.setBounds(150, 31, 148, 67);
        LoginPanel.add(lblLoginTitle);
        
        //Instructions:
	    JLabel lblInstructionLogin = new JLabel("Enter Username and Password");
        lblInstructionLogin.setBounds(43, 111, 170, 14);
        LoginPanel.add(lblInstructionLogin);
        
        //Username:
	    JLabel userLabel = new JLabel("USERNAME");
        userLabel.setBounds(43, 152, 57, 14);
        LoginPanel.add(userLabel);
        JTextField userNameField = new JTextField();
        userNameField.setBounds(121, 149, 223, 20);
        LoginPanel.add(userNameField);
        
        //Password:
        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(43, 189, 59, 14);
        LoginPanel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(121, 186, 223, 20);
        LoginPanel.add(passwordField);
        
        //CHECKBOX
        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(150, 219, 103, 23);
        LoginPanel.add(showPassword);
        
        //BUTTONS
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(113, 260, 65, 23);
        LoginPanel.add(loginButton);
        
        JButton resetButton = new JButton("RESET");
        resetButton.setBounds(229, 260, 65, 23);
        LoginPanel.add(resetButton);
          
        
	 /*
	  *This is inside a function already called initComponents used to initialise and add components
	  *PLEASE DON'T CREATE FUNCTIONS INSIDE FUNCTIONS!!
	    public void addComponentsToContainer() {
	        
	    }
	    
	  *ActionListeners could be under buttons or in the createEvents() function 
	  */
        /*
        @Override
    	public void displayTableData(ArrayList <Motor> tableData) {
    		DefaultTableModel tableModel = (DefaultTableModel) motorTable.getModel();
    		tableModel.setRowCount(0);
    		System.out.println(tableData.size());
    		
    		for(Motor s: tableData) {
    			tableModel.addRow(new Object[] {s.getMotorid(), s.getmotor_name(), s.getMotorManid(), s.getMotomanName(), s.getDateOfArrival(), s.getreported_problems(), s.getcustomer_id(), s.getestimated_cost(), s.gettotal_ExpectedDuration(), s.getmotor_status(), s.getmotorDelayCount(), s.getdate_OfCompletition()});
    		}
    		}

    		public static void AddRowToJTable(Object[] dataRow) {
    			
    			DefaultTableModel model = (DefaultTableModel) motorTable.getModel();
    			model.addRow(dataRow);
    			
    			
    		}
    		
    		*/
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
		//PANEL 2: MOTOR LIST -> MOTOR LIST BUTTON
		MotorListPanel = new JPanel();
		MotorListPanel.setBackground(SystemColor.menu);
		MotorListPanel.setBounds(0, 0, 853, 439);
		MainPanel.add(MotorListPanel);
		
		
/*
		MotorGUIandSQL theMainWindow;			
		VultureServiceSystemDatabase data;
		
		data = new VultureServiceSystemDatabase();
		theMainWindow = new MotorGUIandSQL(MotorListPanel);
		theMainWindow.setVisible(true);
		System.out.println("constructor");
		System.out.println(data.GetAllMotors().size());
		theMainWindow.displayTableData(data.GetAllMotors());
		
		*/
		
		}
	
		
		
		/*
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		TaskListPanel = new JPanel();
		TaskListPanel.setBounds(0, 0, 420, 435);
		MainPanel.add(TaskListPanel);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		InspectionOnePanel = new JPanel();
		InspectionOnePanel.setBackground(Color.YELLOW);
		InspectionOnePanel.setBounds(0, 0, 420, 435);
		MainPanel.add(InspectionOnePanel);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		InspectionTwoPanel = new JPanel();
		InspectionTwoPanel.setBounds(0, 0, 420, 435);
		MainPanel.add(InspectionTwoPanel);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		ManageUsersPanel = new JPanel();
		ManageUsersPanel.setBounds(0, 0, 420, 435);
		MainPanel.add(ManageUsersPanel);
		
		
		
	}
	
	
	//--------------------------------ACTION LISTENERS---------------------------------------------------------------
	//Contains the code for creating Events: (Action listeners will be copied here. 
	private void createEvents() 
	{
		// TODO Auto-generated method stub
		
	}
	*/
	//------------------------------------SWITCH SCREEN FUNCTION------------------------------------------------------------
	//Method for switching panels in the layered Pane:
	
	public void switchScreen(JPanel p) {
		MainPanel.removeAll();
		MainPanel.add(p);
		MainPanel.repaint();
		MainPanel.revalidate();
		
	}
}
