import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
public class InspectionTwoList{
	
	InspectionTwoGUI two;			
	 VultureServiceSystemDatabase data;
	
	public static void main(String[] args) {
		InspectionTwoList mh = new InspectionTwoList();
	}


	public InspectionTwoList(){
		data = new VultureServiceSystemDatabase();
		two = new InspectionTwoGUI(this);
		System.out.println("constructor");
		System.out.println(data.GetAllInspectionTwo().size());
		two.displayTableData(data.GetAllInspectionTwo());
	}
	

	void deleteInspectionTwo(String InspectionTwoID) {
		data.DeleteInspectionTwobyId(InspectionTwoID);
		
		two.displayTableData(data.GetAllInspectionTwo());
	}
	
	public void updateInspectionTwo(int newInspectionTwoID, int motor_id, String technician, String final_approval) {

		data.updateInspectionTwo( newInspectionTwoID,  motor_id,  technician,  final_approval);

		two.displayTableData(data.GetAllInspectionTwo());
	}

	public void AddInspectionTwo(int newInspectionTwoID, int motor_id, String technician, String final_approval) {		
		InspectionTwo newInspectionTwo = new InspectionTwo();
		newInspectionTwo.setinspectionTwo_id(newInspectionTwoID);
		newInspectionTwo.setmotor_id(motor_id);
		newInspectionTwo.settechnician(technician);
		newInspectionTwo.setfinal_approval(final_approval);	
		data.AddInspectionTwo(newInspectionTwo);
		

		two.displayTableData(data.GetAllInspectionTwo());
	}
	}

