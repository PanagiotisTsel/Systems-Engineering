

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class ChangePassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 JTextField PasswordField;
	 JLabel lblEnterNewPassword;
	 JTextField userNameField;
	 JTextField userField;

    public DBConnection database;
 public VultureServiceSystemDatabase data;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 600, 300);
		setResizable(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		  contentPane.setLayout(null);
		
		  PasswordField = new JTextField();
	      PasswordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	      PasswordField.setBounds(250, 50, 250, 70);
	      contentPane.add(PasswordField);
	      PasswordField.setColumns(10);
	      
	      userNameField = new JTextField();
	      userNameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	      userNameField.setBounds(250, 50, 250, 70);
	      contentPane.add(userNameField);
	      userNameField.setColumns(10);

	    
	      JButton btnEnter = new JButton("Enter");
	      btnEnter.setVerticalAlignment(SwingConstants.BOTTOM);
	      btnEnter.addActionListener(new ActionListener() {
	     
	     
	      public void actionPerformed(ActionEvent e) {
	    	
	    	  String hassed_password = PasswordField.getText();
	    	  String username = null;
try {
	database = new DBConnection();
	database.Connect("C:\\Users\\Dimitriana\\Desktop\\Software Engineering Practice\\Assignment\\SoftwareEngineering\\SoftwareEngineeringProject\\groupdatabasetask.db");
	String userName = userNameField.getText();
    String password = PasswordField.getText();
	String sql = "UPDATE useraccount SET hassed_password = '"+hassed_password+"' WHERE username = '"+username+"';";
	ResultSet rs = database.RunSQLQuery(sql);
	if(rs.next()) {
		dispose();
        System.out.println("constructor");
System.out.println("Success");

	}else {
	Component JFrame = null;
	JOptionPane.showMessageDialog(JFrame, "Invalid Username or Password");
	System.out.println("unsuccessful");
	}
	} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	}	
	});
	
	
	
	
	
	/*System.out.println("updated password: " + hassed_password );
	    		 
  Connection con = (Connection) DriverManager.getConnection("groupdatabasetask.db");
  PreparedStatement st = (PreparedStatement) con.prepareStatement("UPDATE useraccount SET hassed_password = '"+hassed_password+"' WHERE username = '"+username+"';");
         
       
                  st.setString(1, hassed_password);
                  st.setString(2, hassed_password);
                  st.executeUpdate();
                  JOptionPane.showMessageDialog(btnEnter, "Password has been successfully changed");
	    	  }
	    		  
	    	  catch (SQLException sqlException) {
                  sqlException.printStackTrace();
	      }
	    	 }
	    	 }); */

	        btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnEnter.setBackground(Color.PINK);
	        btnEnter.setBounds(80, 150, 200, 40);
	        contentPane.add(btnEnter);

	        lblEnterNewPassword = new JLabel("Enter New Password :");
	        lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblEnterNewPassword.setBounds(10, 50, 223, 67);
	        contentPane.add(lblEnterNewPassword);
	}
	
}