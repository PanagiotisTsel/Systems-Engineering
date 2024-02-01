import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.*;
import java.security.*;
 
public class LoginFrame extends JFrame implements ActionListener {
 
    /**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");

    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    private JTextField newpasswordField;
    private JTextField username;
    public DBConnection database;
    public VultureServiceSystemDatabase data;
    public int a = 0;
    LoginFrame() {
    	
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        userLabel.setBounds(178, 138, 100, 30);
        passwordLabel.setBounds(178, 205, 100, 30);
        userNameField.setBounds(300, 138, 150, 30);
        passwordField.setBounds(300, 205, 150, 30);
        showPassword.setBounds(266, 263, 150, 30);
        loginButton.setBounds(162, 300, 100, 30);
        resetButton.setBounds(371, 300, 100, 30);
    }
 
    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userNameField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        
    }
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    
    }
    //JButton loginButton = new JButton("LOGIN");
    public void actionPerformed(ActionEvent e) {
    	loginButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    				database = new DBConnection();
    				database.Connect("Task06.db");
    				String userName = userNameField.getText();
    		        String password = passwordField.getText();
    		       
    				String sql = "SELECT * from useraccount where username='"+userName+"' and hassed_password='"+password+"'";
    			    
					ResultSet rs = database.RunSQLQuery(sql);
					ResultSet rs2 = database.RunSQLQuery(sql);
					if(rs2.next()) {
						 a = rs2.getInt("AdminSection");
						System.out.println(a + "Admin section");
					}else {
						System.out.println("Not getting admin");
						
					}
					if(rs.next()) {
						rs.close();
						rs2.close();
						dispose();
						MotorGUI theMainWindow;			
						VultureServiceSystemDatabase data;
						MotorList MotorList = new MotorList();

						data = new VultureServiceSystemDatabase();
						theMainWindow = new MotorGUI(MotorList);
						theMainWindow.setVisible(true);
						System.out.println("constructor");
						System.out.println(data.GetAllMotors().size());
						theMainWindow.displayTableData(data.GetAllMotors());
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
    	

        // LOGIN button
       /* if (e.getSource() == loginButton) {
            String userName;
            //String password = "123456";
           // System.out.println("MD5:" + encryption.MD5(password));
           
            if (userName.equals("admin") ) { 
            	
                JOptionPane.showMessageDialog(this, "Login Successful");
                dispose();
                userTableGUI jframe = new userTableGUI();
            	jframe.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            	
            }*/
        // RESET button
        if (e.getSource() == resetButton) {
        	userNameField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
      }
    
    
    public static void main(String[] a) {
   
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(350, 80, 734, 551);
        frame.setResizable(false);
    }
        		}
        
