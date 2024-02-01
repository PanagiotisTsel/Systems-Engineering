
public class userTableGUI{
	
	UsersSystemGUI theMainWindow;			// The GUI to communicate with user
	private VultureServiceSystemDatabase data;
	

	// This is just to run the program
	public static void main(String[] args) {
		userTableGUI mh = new userTableGUI();
		
	}
	public userTableGUI(){
		data = new VultureServiceSystemDatabase();
		theMainWindow = new UsersSystemGUI(this);
		theMainWindow.setVisible(true);
		theMainWindow.displayTableData(data.GetAllUsers());
	}

	void RemoveUser(String UsersName) {
		data.RemoveUser(UsersName);
		
		theMainWindow.displayTableData(data.GetAllUsers());
	}
	void EditUserInformation(String username, String hassed_password, int employee_id, int AdminSection ) {
		data.EditUserInformation(username, hassed_password,employee_id, AdminSection);
		
		
		theMainWindow.displayTableData(data.GetAllUsers());
	}
	
	void addUserName(String UsersName, String hassed_password,int employee_id, int AdminSection){
		UserInformation newUser = new UserInformation();
		newUser.setUserName(UsersName);
		newUser.setPassword(hassed_password);
		newUser.setEmployee_id(employee_id);
		newUser.setAdminSection(AdminSection);
		data.AddUser(newUser);
		
		// Tempted to convert to an Object[][] at this point.
		// But I'll let the GUI do it, since it will be replaced by
		// database ResultSet, anyway.
		theMainWindow.displayTableData(data.GetAllUsers());
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
	

