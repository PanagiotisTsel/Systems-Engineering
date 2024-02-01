//Panagiotis Tsellos w20024460 2nd Year Student

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class VultureServiceSystemDatabase {
	private DBConnection database;
	VultureServiceSystemDatabase data;

	public static void main(String[] args) {
		VultureServiceSystemDatabase vssd = new VultureServiceSystemDatabase();
		Motor mo = new Motor();
		mo.setMotorid(50);

		mo.setMotorManid(1);
		mo.setmotor_name("bmw");
		mo.setMotomanName("bmw");
		mo.setDateOfArrival("05-04-2022");
		mo.setreported_problems("ignition");
		mo.setcustomer_id(1);;
		mo.setestimated_cost(300);
		mo.settotal_ExpectedDuration("25 days");
		mo.setmotor_status("ACTIVE");
		mo.setmotorDelayCount(0);
		mo.setdate_OfCompletition("23-05-2022");
		vssd.AddMotor(mo);
		ArrayList <Motor> al = vssd.GetAllMotors();
		System.out.println("testing list of motors");

		for (int i=0; i<al.size(); i++) {
			System.out.println(al.get(i).getMotorid());
		}
		
	}
	
	public VultureServiceSystemDatabase(){
		database = new DBConnection();

		database.Connect("Task06.db");	}

	
	
//-------------------------------MOTOR Functions------------------------------------------------
//Add Motor
	public void AddMotor(Motor sm) {
		String sqlString = new String("INSERT INTO motor VALUES('");
		sqlString = sqlString+   Integer.toString(sm.getMotorid())+"','";
		sqlString = sqlString + sm.getmotor_name()+"', '";
		sqlString = sqlString+   Integer.toString(sm.getMotorManid())+"','";
		sqlString = sqlString + sm.getMotomanName()+"', '";
		sqlString = sqlString + sm.getDateOfArrival()+"', '";
		sqlString = sqlString + sm.getreported_problems()+"', '";
		sqlString = sqlString+   Integer.toString(sm.getcustomer_id())+"','";
		sqlString = sqlString+   Integer.toString(sm.getestimated_cost())+"','";
		sqlString = sqlString + sm.gettotal_ExpectedDuration()+"', '";
		sqlString = sqlString + sm.getmotor_status()+"', '";
		sqlString = sqlString+   Integer.toString(sm.getmotorDelayCount())+"','";
		sqlString = sqlString + sm.getdate_OfCompletition()+"'";		
		sqlString = sqlString+  ");";

		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
//Delete Motor using motor ID	
	public void DeleteMotorByMotorId(String motorid) {		
		String sqlString = new String("DELETE FROM motor WHERE motor_id = '"+motorid+"';");
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}

//Motor Arraylist
	public ArrayList<Motor> GetAllMotors(){
		
		//String sqlString = new String("SELECT motor_id,motor_name,MotorMan_id,MotorMan_Name,DateOfArrival,reported_problems,customer_id,estimated_cost,total_ExpectedDuration,motor_status,motor_DelayCount,date_OfCompletion FROM motor;");
		String sqlString = new String("SELECT * FROM motor");
		ResultSet MotorList = database.RunSQLQuery(sqlString);
		ArrayList<Motor> answer = new ArrayList<Motor>();

		
		try {
			while(MotorList.next()) {
				Motor newMotor = new Motor();
				newMotor.setMotorid(MotorList.getInt(1));
				newMotor.setmotor_name(MotorList.getString(2));
				newMotor.setMotorManid(MotorList.getInt(3));
				newMotor.setMotomanName(MotorList.getString(4));
				newMotor.setDateOfArrival(MotorList.getString(5));
				newMotor.setreported_problems(MotorList.getString(6));
				newMotor.setcustomer_id(MotorList.getInt(7));
				newMotor.setestimated_cost(MotorList.getInt(8));
				newMotor.settotal_ExpectedDuration(MotorList.getString(9));
				newMotor.setmotor_status(MotorList.getString(10));
				newMotor.setmotorDelayCount(MotorList.getInt(11));
				newMotor.setdate_OfCompletition(MotorList.getString(12));				
			
				System.out.println(newMotor.getMotorid());
				
				answer.add(newMotor);
			}
		} catch (SQLException e) {
			System.out.println("Failed to process query in GetAllMotors()");
			System.out.println("SQL attempted: "+sqlString);	
			System.out.println("Error: "+e.getErrorCode());
			System.out.println("Message: "+e.getMessage());			
			e.printStackTrace();
		}
		return answer;
	}

	public void updateMotor(int motor_id, String motor_name, int motorMan_id, String motorMan_name,
			String dateOfArrival, String reported_problems, int customer_id, int estimated_cost,
			String total_ExpectedDuration, String motor_status, int motor_DelayCount, String date_OfCompletion) {
		// TODO Auto-generated method stub
		//String sqlString = new String("UPDATE motor SET newMotorId="+ newMotorId + "motor_DelayCount="+ motor_DelayCount +" WHERE newMotorId='"+newMotorId+"';");
		String sqlString = new String("UPDATE motor SET motor_name = '"+motor_name+"', motorMan_id = '"+motorMan_id+"', motorMan_name = '"+motorMan_name+"', dateOfArrival = '"+dateOfArrival+"', "
				+ "reported_problems = '"+reported_problems+"', customer_id = '"+customer_id+"', estimated_cost = '"+estimated_cost+"', total_ExpectedDuration = '"+total_ExpectedDuration+"', motor_status = '"+motor_status+"', "
						+ "motor_DelayCount = '"+motor_DelayCount+"', date_OfCompletion = '"+date_OfCompletion+"' WHERE motor_id='"+motor_id+"';");
		
		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	

//------------------------------------------TASK Functions----------------------------------------
	
	public void AddTask(Task sm) {
		String sqlString = new String("INSERT INTO task VALUES('");
		
		sqlString = sqlString+  Integer.toString(sm.getmotor_id())+"','";
		sqlString = sqlString+  Integer.toString(sm.gettask_id())+"','";
		sqlString = sqlString + sm.gettask_namem()+"', '";
		sqlString = sqlString+  sm.gettask_desc()+"','";
		sqlString = sqlString + sm.gettask_type()+"', '";
		sqlString = sqlString + sm.getexpected_duration()+"', '";
		sqlString = sqlString + sm.gettask_duration()+"', '";
		sqlString = sqlString+   Integer.toString(sm.gettask_priority())+"','";
		sqlString = sqlString + sm.getassigned_tech()+"', '";
		sqlString = sqlString + sm.getdate_allocated()+"', '";	
		sqlString = sqlString + sm.getassigned_tech2()+"', '";
		sqlString = sqlString + sm.getemployee_id()+"', '";
		sqlString = sqlString + sm.getemployee_id2()+"'";		
		sqlString = sqlString+  ");";

		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	
	public void DeleteTaskByTaskID(String taskId) {		
		String sqlString = ("DELETE FROM task WHERE task_id = '"+taskId+"';");
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}

	
	public ArrayList <Task> GetAllTasks(){
		
		String sqlString = new String("SELECT * FROM task");
		ResultSet TakList = database.RunSQLQuery(sqlString);
		ArrayList<Task> answer = new ArrayList<Task>();

		try {
			while(TakList.next()) {
				Task newTask = new Task();
				newTask.setmotor_id(TakList.getInt(1));
				newTask.settask_id(TakList.getInt(2));
				newTask.settask_namem(TakList.getString(3));
				newTask.settask_desc(TakList.getString(4));
				newTask.settask_type(TakList.getString(5));
				newTask.setexpected_duration(TakList.getString(6));
				newTask.settask_duration(TakList.getString(7));
				newTask.settask_priority(TakList.getInt(8));
				newTask.setassigned_tech(TakList.getString(9));
				newTask.setassigned_tech2(TakList.getString(10));
				newTask.setdate_allocated(TakList.getString(11));
				newTask.setemployee_id(TakList.getInt(12));
				newTask.setemployee_id2(TakList.getInt(13));
			
			
				System.out.println(newTask.gettask_id());
				
				answer.add(newTask);
			}
		} catch (SQLException e) {
			System.out.println("Failed to process query in GetAllTasks()");
			System.out.println("SQL attempted: "+sqlString);	
			System.out.println("Error: "+e.getErrorCode());
			System.out.println("Message: "+e.getMessage());			
			e.printStackTrace();
		}
		return answer;
	}
	
	//Update or Edit task: 
	
	public void updateTask(int motor_id, int task_id, String task_namem, String task_desc, String task_type,
			String expected_duration, String task_duration, String task_priority, String assigned_tech,
			String assigned_tech2) 
	{String sqlString = new String("UPDATE task SET task_namem = '"+task_namem+"', task_desc = '"+task_desc+"', task_type = '"+task_type+"', expected_duration = '"+expected_duration+"', "
			+ "task_duration = '"+task_duration+"', task_priority = '"+task_priority+"', assigned_tech = '"+assigned_tech+"', assigned_tech2 = '"+assigned_tech2+"' WHERE task_id='"+task_id+"';");
		
		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}


//--------------------------InspectionOne Functions--------------------------------------------- 
		
		//Add Details for inspection one
			public void AddInspectionOne(InspectionOne sm) {
				String sqlString = new String("INSERT INTO InspectionOne VALUES('");
				sqlString = sqlString+   Integer.toString(sm.getinspectionOne_id())+"','";
				sqlString = sqlString+   Integer.toString(sm.getmotor_id())+"','";
				sqlString = sqlString + sm.gettechnician()+"', '";
				sqlString = sqlString + sm.gettech_comments()+"', '";
				sqlString = sqlString + sm.getinitial_approval()+"'";
				sqlString = sqlString+  ");";

				boolean success = database.RunSQL(sqlString);
				if(!success) {
					System.out.println("Failed to run query: "+sqlString);
				}
			}
			
		//Get All Inspection One sets
		public ArrayList<InspectionOne> GetAllInspectionOne(){
		
		String sqlString = new String("SELECT * FROM InspectionOne");
		ResultSet InspectionOneList = database.RunSQLQuery(sqlString);
		ArrayList<InspectionOne> answer = new ArrayList<InspectionOne>();

		
		try {
			while(InspectionOneList.next()) {
				InspectionOne newInspectionOne = new InspectionOne();
				newInspectionOne.setinspectionOne_id(InspectionOneList.getInt(1));
				newInspectionOne.setmotor_id(InspectionOneList.getInt(2));
				newInspectionOne.settechnician(InspectionOneList.getString(3));
				newInspectionOne.settech_comments(InspectionOneList.getString(4));
				newInspectionOne.setinitial_approval(InspectionOneList.getString(5));
				
				System.out.println(newInspectionOne.getinspectionOne_id());
				
				answer.add(newInspectionOne);
			}
		} catch (SQLException e) {
			System.out.println("Failed to process query in GetAllStudents()");
			System.out.println("SQL attempted: "+sqlString);	
			System.out.println("Error: "+e.getErrorCode());
			System.out.println("Message: "+e.getMessage());			
			e.printStackTrace();
		}
		return answer;
	}
		
	//Deleting Inspection from the InspectionOne table:
	public void DeleteInspectionOnebyId(String InspectionOneID) {		
		String sqlString = new String("DELETE FROM InspectionOne WHERE inspectionOne_id = '"+InspectionOneID+"';");
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	

	public void updateInspectionOne(int inspectionOne_id, int motor_id, String technician, String tech_comments,
			String innitial_approval) {
		String sqlString = new String("UPDATE InspectionOne SET inspectionOne_id  = '"+inspectionOne_id+"', motor_id = '"+motor_id+"', technician = '"+technician+"', tech_comments = '"+tech_comments+"', initial_approval  = '"+innitial_approval+"' WHERE inspectionOne_id ='"+inspectionOne_id+"';");
		boolean success = database.RunSQL(sqlString);
if(!success) {
	System.out.println("Failed to run query: "+sqlString);
}
	}
	
//_____________________________________________________________________________________________
//InspectionTwo table Functions: 
//InspectionTwo class Arraylist:
//Adding an Inspection to the InspectionTwo table: 
//Deleting Inspection from the InspectionTwo table:

//-----------------------------InspectionTwo Functions--------------------------------------------


	//Adding an Inspection to the InspectionTwo table: 
	public void AddInspectionTwo (InspectionTwo sm) {
		String sqlString = new String("INSERT INTO InspectionTwo VALUES('");
		sqlString = sqlString+   Integer.toString(sm.getinspectionTwo_id())+"','";
		sqlString = sqlString+   Integer.toString(sm.getmotor_id())+"','";
		sqlString = sqlString + sm.gettechnician()+"', '";
		sqlString = sqlString + sm.getfinal_approval()+"'";
		sqlString = sqlString+  ");";

		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	//Get All Insepction Two sets
public ArrayList<InspectionTwo> GetAllInspectionTwo(){
		
		String sqlString = new String("SELECT * FROM InspectionTwo");
		ResultSet InspectionTwoList = database.RunSQLQuery(sqlString);
		ArrayList<InspectionTwo> answer = new ArrayList<InspectionTwo>();

		
		try {
			while(InspectionTwoList.next()) {
				InspectionTwo newInspectionTwo = new InspectionTwo();
				newInspectionTwo.setinspectionTwo_id(InspectionTwoList.getInt(1));
				newInspectionTwo.setmotor_id(InspectionTwoList.getInt(2));
				newInspectionTwo.settechnician(InspectionTwoList.getString(3));
				newInspectionTwo.setfinal_approval(InspectionTwoList.getString(4));
				
				System.out.println(newInspectionTwo.getinspectionTwo_id());
				
				answer.add(newInspectionTwo);
			}
		} catch (SQLException e) {
			System.out.println("Failed to process query in GetAllStudents()");
			System.out.println("SQL attempted: "+sqlString);	
			System.out.println("Error: "+e.getErrorCode());
			System.out.println("Message: "+e.getMessage());			
			e.printStackTrace();
		}
		return answer;
	}

//Deleting Inspection from the InspectionTwo table:
public void DeleteInspectionTwobyId(String InspectionTwoID) {		
	String sqlString = new String("DELETE FROM InspectionTwo WHERE inspectionTwo_id = '"+InspectionTwoID+"';");
	boolean success = database.RunSQL(sqlString);
	if(!success) {
		System.out.println("Failed to run query: "+sqlString);
	}
}

public void updateInspectionTwo(int newInspectionTwoID, int motor_id, String technician, String final_approval) {
	// TODO Auto-generated method stub
	String sqlString = new String("UPDATE InspectionTwo SET inspectionTwo_id = '"+newInspectionTwoID+"', motor_id = '"+motor_id+"', technician = '"+technician+"', final_approval = '"+final_approval+"' WHERE inspectionTwo_id='"+newInspectionTwoID+"';");
			boolean success = database.RunSQL(sqlString);
	if(!success) {
		System.out.println("Failed to run query: "+sqlString);
	}
}


//----------------------------------USERACCOUNT FUNCTIONS----------------------------------------------

//useraccount class Arraylist: 
public void AddUser(UserInformation sm) {
	String sqlString = new String("INSERT INTO useraccount VALUES('");
	sqlString = sqlString + sm.getusername()+"', '";
	sqlString = sqlString+ Integer.toString(sm.getEmployee_id())+"', '";
	sqlString = sqlString+ Integer.toString(sm.getAdminSection())+"','";
	sqlString = sqlString+   sm.getPassword()+"'";
	sqlString = sqlString+  ");" ;
	
boolean success = database.RunSQL(sqlString);
	
	if(!success) {
		System.out.println("Failed to run query: "+sqlString);
	}
}


public void RemoveUser(String username) {
	// Should probably add a message if the student does not exist.
	
	String sqlString = new String("DELETE FROM useraccount WHERE username = '"+username+"';");
	boolean success = database.RunSQL(sqlString);
	if(!success) {
		System.out.println("Failed to run query: "+sqlString);
	}
}

/**
 * @param adminSection 

*/


 public void ChangePassword(String username, String password) {
 String sqlString = new String("UPDATE useraccount SET hassed_password = '"+password+"' WHERE username = '"+username+"';");
				boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
		  System.out.println("updated password: " + password );
 }

public ArrayList<UserInformation> GetAllUsers(){
	
	String sqlString = new String("SELECT * FROM useraccount;");
	ResultSet userList = database.RunSQLQuery(sqlString);
	ArrayList<UserInformation> answer = new ArrayList<UserInformation>();
	
	try {
		while(userList.next()) {
			UserInformation newUser = new UserInformation();
			newUser.setUserName(userList.getString(1));
			newUser.setPassword(userList.getString(2));	
			newUser.setEmployee_id(userList.getInt(3));
			newUser.setAdminSection(userList.getInt(4));
			System.out.println(newUser.getEmployee_id());
			
			answer.add(newUser);
		}
		
	} catch (SQLException e) {
		System.out.println("Failed to process query in useraccount()");
		System.out.println("SQL attempted: "+sqlString);	
		System.out.println("Error: "+e.getErrorCode());
		System.out.println("Message: "+e.getMessage());			
		e.printStackTrace();
	}
	return answer;
}

public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}

//-----------------------------EmployeeInfo---------------------------------------------------------------------------

		// Get all Employees
	public ArrayList<employeeInfo> GetAllEmployees(){
		
		String sqlString = new String("SELECT employee_id, first_name, last_name, dateOfBirth,employee_role  FROM employee;");
		ResultSet employeeList = database.RunSQLQuery(sqlString);
		ArrayList<employeeInfo> answer = new ArrayList<employeeInfo>();
		
		try {
			while(employeeList.next()) {
				employeeInfo newEmployee = new employeeInfo();
				newEmployee.setfirstName(employeeList.getString(1));
				newEmployee.setemployee_id(employeeList.getInt(2));	
				newEmployee.setlastName(employeeList.getString(2));
				newEmployee.setdateOfBirth(employeeList.getString(3));
				newEmployee.setemployeeRole(employeeList.getString(4));
				answer.add(newEmployee);
			}
		} catch (SQLException e) {
			System.out.println("Failed to process query in employee()");
			System.out.println("SQL attempted: "+sqlString);	
			System.out.println("Error: "+e.getErrorCode());
			System.out.println("Message: "+e.getMessage());			
			e.printStackTrace();
		}
		return answer;
	}
	
	
//Adding an employee to the employee table: 
	public void AddEmployee(employeeInfo sm) {
		String sqlString = new String("INSERT INTO employee VALUES('");
		sqlString = sqlString + sm.getfirstName()+"', ";
		sqlString = sqlString + sm.getlastName()+"', ";
		sqlString = sqlString+ sm.getemployee_id()+"', ";
		sqlString = sqlString+ sm.getemployeeRole()+";',";
		sqlString = sqlString+ sm.getdateOfBirth()+";',";
		sqlString = sqlString+   Integer.toString(sm.getemployee_id());
		sqlString = sqlString+  ");" ;
	    
		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
//Deleting an employee from the employee table:
	public void RemoveEmployee(String firstName) {
		// Should probably add a message if the employee does not exist.
		
		String sqlString = new String("DELETE FROM employee WHERE first_name = '"+firstName+"';");
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
//Edits a employeeInfo from the employee table (update) ** not working
	public void EditEmployeeInformation(String firstName, int employee_id) {
		// Should probably add a message if the employee does not exist
		String sqlString = new String("UPDATE employee SET employee_id="+ employee_id +" WHERE first_name='"+firstName+"';");

		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}

	}

	public void EditUserInformation(String username, String hassed_password, int employee_id, int adminSection) {
		String sqlString = new String("UPDATE useraccount SET username='"+username+"' ,"
				+ " hassed_password = '"+hassed_password+"'WHERE employee_id ='"+employee_id+"';");

		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
		
	}

	
}

	

	

