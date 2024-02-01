public class InspectionTwo implements Comparable<InspectionTwo> {
	
	private int inspectionTwo_id ;
	private int motor_id;
	private String technician;
	private String final_approval ;

	
	public InspectionTwo(){
		inspectionTwo_id  = 0;
		motor_id = 0;
		technician = "Not Set";
		final_approval  = "Not set";
	
	}
	//tesr
	public void setinspectionTwo_id (int inspectionTwoid ) {
		inspectionTwo_id  = inspectionTwoid ;
	}
	
	public int getinspectionTwo_id () {
		return inspectionTwo_id ;
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
	
	public void setfinal_approval (String finalapproval ) {
		final_approval  = finalapproval ;
	}
	
	public String getfinal_approval () {
		return final_approval ;
	}
	

	
	
	@Override
	public int compareTo(InspectionTwo o) {
		return o.inspectionTwo_id-this.inspectionTwo_id;
	}

	public static boolean next() {
		// TODO Auto-generated method stub
		return false;
	}


	
}