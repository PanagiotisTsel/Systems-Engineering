import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
public class InspectionOneList{
	
	InspectionOneGUI one;			
	 VultureServiceSystemDatabase data;
	
	public static void main(String[] args) {
		InspectionOneList mh = new InspectionOneList();
	}


	public InspectionOneList(){
		data = new VultureServiceSystemDatabase();
		one = new InspectionOneGUI(this);
		System.out.println("constructor");
		System.out.println(data.GetAllInspectionOne().size());
		one.displayTableData(data.GetAllInspectionOne());
	}
	

	void deleteInspectionOne(String InspectionOneID) {
		data.DeleteInspectionOnebyId(InspectionOneID);
		
		one.displayTableData(data.GetAllInspectionOne());
	}
	
	public void updateInspectionOne(int inspectionOne_id , int motor_id, String technician, String tech_comments, String innitial_approval ) {

		data.updateInspectionOne( inspectionOne_id,  motor_id,  technician,  tech_comments, innitial_approval );

		one.displayTableData(data.GetAllInspectionOne());
	}

	public void AddInspectionOne(int newInspectionOneID, int motor_id, String technician, String tech_comments,String initial_approval) {		
		InspectionOne newInspectionOne = new InspectionOne();
		newInspectionOne.setinspectionOne_id(newInspectionOneID);
		newInspectionOne.setmotor_id(motor_id);
		newInspectionOne.settechnician(technician);
		newInspectionOne.settech_comments(tech_comments);
		newInspectionOne.setinitial_approval(initial_approval);	
		data.AddInspectionOne(newInspectionOne);
		

		one.displayTableData(data.GetAllInspectionOne());
	}
	}

