public class InspectionOne implements Comparable<InspectionOne> {
	
	private int inspectionOne_id;
	private int motor_id;
	private String technician;
	private String tech_comments;
	private String initial_approval;

	
	public InspectionOne(){
		inspectionOne_id = 0;
		motor_id = 0;
		technician = "Not Set";
		tech_comments = "Not set";
		initial_approval = "Not set";	
	}
	
	public void setinspectionOne_id(int inspectionOneid) {
		inspectionOne_id = inspectionOneid;
	}
	
	public int getinspectionOne_id() {
		return inspectionOne_id;
	}
	
	public void setmotor_id(int motorid) {
		motor_id = motorid;
	}
	
	public int getmotor_id() {
		return motor_id;
	}
	
	public void settechnician(String Technician) {
		technician = Technician;
	}
	
	public String gettechnician() {
		return technician;
	}
	
	public void settech_comments(String techcomments) {
		tech_comments = techcomments;
	}
	
	public String gettech_comments() {
		return tech_comments;
	}
	
	public void setinitial_approval(String initialapproval) {
		initial_approval = initialapproval;
	}
	
	public String getinitial_approval() {
		return initial_approval;
	}
	
	
	
	@Override
	public int compareTo(InspectionOne o) {
		return o.inspectionOne_id-this.inspectionOne_id;
	}

	public static boolean next() {
		// TODO Auto-generated method stub
		return false;
	}


	
}