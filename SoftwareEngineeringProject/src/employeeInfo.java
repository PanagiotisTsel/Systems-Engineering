

public class employeeInfo implements Comparable<employeeInfo> {
	private int employee_id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String employeeRole; 
	
	//constructor
	
	public employeeInfo() {
		employee_id = 0;
		firstName = "Not set";
		lastName="Not set";
		dateOfBirth = "Not set";
		employeeRole = "Not set";
	}
	//getters
	public int getemployee_id() {
		return employee_id;
	}

	public String getfirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	public String getlastName() {
		return lastName;
	}

	public String getdateOfBirth() {
		return dateOfBirth;
	}
    public String getemployeeRole() {
    	return employeeRole;
    }
	//setters
	public void setfirstName(String firstName) {
		firstName = this.firstName;
	}
	
	public void setlastName(String newlastName) {
		lastName = newlastName;
	}
	public void setemployee_id(int newemployee_id) {
		employee_id = newemployee_id;
	}
	public void setdateOfBirth(String newdateOfBirth) {
		dateOfBirth = newdateOfBirth;
	}
	public void setemployeeRole(String newemployeeRole) {
		employeeRole = newemployeeRole;
	}
	


	@Override
	public int compareTo(employeeInfo o) {
		// TODO Auto-generated method stub
		return 0;
	}



}
