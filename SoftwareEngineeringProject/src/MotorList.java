import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
public class MotorList{
	
	MotorGUI theMainWindow;	
	VultureServiceSystemDatabase data;
	public static void main(String[] args) {
		MotorList mh = new MotorList();

	}

	public MotorList(){
		data = new VultureServiceSystemDatabase();
		theMainWindow = new MotorGUI(this);
		theMainWindow.setVisible(true);
		System.out.println("constructor");
		System.out.println(data.GetAllMotors().size());
		theMainWindow.displayTableData(data.GetAllMotors());
	
	}

	void deleteMotor(String motorId) {
		data.DeleteMotorByMotorId(motorId);
		
		theMainWindow.displayTableData(data.GetAllMotors());
	}
	
	public void updateMotor (int motor_id, String motor_name, int motorMan_id, String MotorMan_Name, String DateOfArrival, 
			String reported_problems, int customer_id, int estimated_cost, String total_ExpectedDuration, String motor_status, 
			int motor_DelayCount, String date_OfCompletition){

		data.updateMotor( motor_id,  motor_name,  motorMan_id,  MotorMan_Name,
				DateOfArrival,  reported_problems,  customer_id,  estimated_cost,
				 total_ExpectedDuration,  motor_status,  motor_DelayCount,  date_OfCompletition);

		theMainWindow.displayTableData(data.GetAllMotors());
	}


	void addMotor(int motor_id, String motor_name, int motorMan_id, String MotorMan_Name, String DateOfArrival, String reported_problems, int customer_id, int estimated_cost, String total_ExpectedDuration, String motor_status, int motor_DelayCount, String date_OfCompletition) {
		Motor newMotor = new Motor();
		newMotor.setMotorid(motor_id);		
		newMotor.setmotor_name(motor_name);
		newMotor.setMotorManid(motorMan_id);
		newMotor.setMotomanName(MotorMan_Name);
		newMotor.setDateOfArrival(DateOfArrival);
		newMotor.setreported_problems(reported_problems);
		newMotor.setcustomer_id(customer_id);
		newMotor.setestimated_cost(estimated_cost);
		newMotor.settotal_ExpectedDuration(total_ExpectedDuration);
		newMotor.setmotor_status(motor_status);
		newMotor.setmotorDelayCount(motor_DelayCount);
		newMotor.setdate_OfCompletition(date_OfCompletition);	
		data.AddMotor(newMotor);

		
		theMainWindow.displayTableData(data.GetAllMotors());
	}	
}

