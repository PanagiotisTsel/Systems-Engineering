public class Task implements Comparable<Task> {
	
	public int motor_id;
	public int task_id;
	public String task_namem;
	public String task_desc;
	public String task_type;
	public String expected_duration;
	public String task_duration ;
	public int task_priority ;
	public String assigned_tech ;
	public String assigned_tech2 ;
	public String date_allocated ;
	public int employee_id ;
	public int employee_id2 ;

	//employee_id INTEGER NOT NULL,
	//employee_id2 Integer,
	public Task(){
		motor_id = 0;
		task_id = 0;
		task_namem = "Not set";
		task_desc = "Not set";
		task_type = "Not set";
		expected_duration = "Not set";
		task_duration  = "Not set";
		task_priority  = 0;
		assigned_tech  = "Not set";
		assigned_tech2  = "Not set";
		date_allocated  = "Not set";
		employee_id = 0;
		employee_id2 = 0;
	}
	public void setmotor_id(int motorid) {
		motor_id = motorid;
	}
	
	public int getmotor_id() {
		return motor_id;
	}
	public void settask_id(int taskid) {
		task_id = taskid;
	}
	
	public int gettask_id() {
		return task_id;
	}
	
	
	public void settask_namem(String tasknamem) {
		task_namem = tasknamem;
	}
	
	public String gettask_namem() {
		return task_namem;
	}
	
	public void settask_desc(String taskdesc) {
		task_desc = taskdesc;
	}
	
	public String gettask_desc() {
		return task_desc;
	}
	
	public void settask_type(String tasktype) {
		task_type = tasktype;
	}
	
	public String gettask_type() {
		return task_type;
	}
	
	public void setexpected_duration(String expectedduration) {
		expected_duration = expectedduration;
	}
	
	public String getexpected_duration() {
		return expected_duration;
	}
	
	public void settask_duration (String taskduration ) {
		task_duration  = taskduration ;
	}
	
	public String gettask_duration () {
		return task_duration ;
	}
	
	public void settask_priority (int taskpriority ) {
		task_priority  = taskpriority ;
	}
	
	public int gettask_priority () {
		return task_priority ;
	}
	
	public void setassigned_tech (String assignedtech ) {
		assigned_tech  = assignedtech ;
	}
	
	public String getassigned_tech () {
		return assigned_tech ;
	}

	public void setassigned_tech2 (String assignedtech2 ) {
		assigned_tech2  = assignedtech2 ;
	}
	
	public String getassigned_tech2 () {
		return assigned_tech2 ;
	}
	
	public void setdate_allocated (String dateallocated ) {
		date_allocated  = dateallocated ;
	}
	
	public String getdate_allocated () {
		return date_allocated ;
	}
	public void setemployee_id (int employeeid ) {
		employee_id  = employeeid ;
	}
	
	public int getemployee_id () {
		return employee_id ;
	}
	public void setemployee_id2 (int employeeid2 ) {
		employee_id2  = employeeid2 ;
	}
	
	public int getemployee_id2 () {
		return employee_id2 ;
	}
	
	
	
	public static boolean next() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(Task o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}