public class Motor implements Comparable<Motor> {
	
	private int motor_id;
	private String motor_name;
	private int MotorMan_id;
	private String MotorMan_Name;
	private String dateOfArrival;
	private String reported_problems;
	private int customer_id;
	private int estimated_cost;
	private String total_ExpectedDuration;
	private String motor_status;
	private int motor_DelayCount;
	private String date_OfCompletition;
	
	public Motor(){
		motor_id = 0;
		motor_name = "Not set";
		MotorMan_id = 0;
		MotorMan_Name = "Not set";
		dateOfArrival = "Not set";
		reported_problems = "Not set";
		customer_id = 0;
		estimated_cost = 0;
		total_ExpectedDuration = "Not set";
		motor_status = "Not set";
		motor_DelayCount = 0;
		date_OfCompletition = "Not set";
		
	}
	
	public void setMotorid(int motorid) {
		motor_id = motorid;
	}
	
	public int getMotorid() {
		return motor_id;
	}
	
	
	public void setMotorManid(int motormanid) {
		MotorMan_id = motormanid;
	}
	
	public int getMotorManid() {
		return MotorMan_id;
	}
	
	public void setmotor_name(String motorname) {
		motor_name = motorname;
	}
	
	public String getmotor_name() {
		return motor_name;
	}
	
	public void setMotomanName(String motorManname) {
		MotorMan_Name = motorManname;
	}
	
	public String getMotomanName() {
		return MotorMan_Name;
	}
	
	public void setDateOfArrival(String DateofArrival) {
		dateOfArrival = DateofArrival;
	}
	
	public String getDateOfArrival() {
		return dateOfArrival;
	}
	
	public void setreported_problems(String reportedproblems) {
		reported_problems = reportedproblems;
	}
	
	public String getreported_problems() {
		return reported_problems;
	}
	
	public void setcustomer_id(int customerid) {
		customer_id = customerid;
	}
	
	public int getcustomer_id() {
		return customer_id;
	}
	
	public void setestimated_cost(int estimatedcost) {
		estimated_cost = estimatedcost;
	}
	
	public int getestimated_cost() {
		return estimated_cost;
	}

	public void settotal_ExpectedDuration(String totalExpectedDuration) {
		total_ExpectedDuration = totalExpectedDuration;
	}
	
	public String gettotal_ExpectedDuration() {
		return total_ExpectedDuration;
	}
	
	public void setmotor_status(String motorstatus) {
		motor_status = motorstatus;
	}
	
	public String getmotor_status() {
		return motor_status;
	}
	
	public void setmotorDelayCount(int motorDelaycount) {
		motor_DelayCount = motorDelaycount;
	}
	
	public int getmotorDelayCount() {
		return motor_DelayCount;
	}
	
	public void setdate_OfCompletition(String dateOfCompletition) {
		date_OfCompletition = dateOfCompletition;
	}
	
	public String getdate_OfCompletition() {
		return date_OfCompletition;
	}
	@Override
	public int compareTo(Motor o) {
		return o.motor_id-this.motor_id;
	}
	public static boolean next() {
		// TODO Auto-generated method stub
		return false;
	}	
}