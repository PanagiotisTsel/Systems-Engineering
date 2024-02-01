public class UserInformation implements Comparable<UserInformation> {
	public String Password;
	public String username;
	public int Employee_id;
	public int AdminSection;
	
	public UserInformation(){
		username = "Not set";
		Password = "Not set" ;
		Employee_id = 0;
		AdminSection = 0 ;
	}
	
	public void setUserName(String userName) {
		username = userName;
	}
	
	public void setPassword(String newpassword) {
		Password = newpassword;
	}
	public void setEmployee_id(int newemployee_id) {
		Employee_id = newemployee_id;
	}
	public void setAdminSection(int newAdminSection) {
		AdminSection = newAdminSection;
	}
	//getters
	public String getPassword() {
		return Password;
	}

	public String getusername() {
		return username;
	}
	public int getEmployee_id() {
		return Employee_id;
	}
	public int getAdminSection() {
		return AdminSection;
	}

	@Override
	public int compareTo(UserInformation o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
