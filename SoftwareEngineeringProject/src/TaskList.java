import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
public class TaskList{
	
	TaskGUI theMainWindow;	
	VultureServiceSystemDatabase data;
	public static void main(String[] args) {
		TaskList mh = new TaskList();

	}

	public TaskList(){
		data = new VultureServiceSystemDatabase();
		theMainWindow = new TaskGUI(this);
		theMainWindow.setVisible(true);
		System.out.println("constructor");
		System.out.println(data.GetAllMotors().size());
		theMainWindow.displayTableData(data.GetAllTasks());
	
	}

	void deleteTask(String nameToDelete) {
		data.DeleteTaskByTaskID(nameToDelete);
		
		theMainWindow.displayTableData(data.GetAllTasks());
	}

	
	//employee_id INTEGER NOT NULL,
	//employee_id2 Integer,

	void addTask(int motor_id, int task_id, String task_namem, String task_desc, String task_type, String expected_duration, String task_duration, int task_priority, String assigned_tech, String assigned_tech2, String date_allocated, int employee_id, int employee_id2) {
		Task newTask = new Task();
		newTask.setmotor_id(motor_id);
		newTask.settask_id(task_id);		
		newTask.settask_namem(task_namem);
		newTask.settask_desc(task_desc);
		newTask.settask_type(task_type);
		newTask.setexpected_duration(expected_duration);
		newTask.settask_duration(task_duration);
		newTask.settask_priority(task_priority);
		newTask.setassigned_tech(assigned_tech);
		newTask.setassigned_tech2(assigned_tech2);
		newTask.setdate_allocated(date_allocated);
		newTask.setemployee_id(employee_id);
		newTask.setemployee_id2(employee_id2);

		data.AddTask(newTask);
		

		theMainWindow.displayTableData(data.GetAllTasks());
	}

	//This is the update task 
	public void EditTask(int motor_id, int task_id, String task_namem, String task_desc, String task_type, String expected_duration,
			String task_priority, String assigned_tech, String assigned_tech2) {
		data.updateTask(motor_id, task_id, task_namem, task_desc, task_type, expected_duration, expected_duration, task_priority, assigned_tech, assigned_tech2);
		
		theMainWindow.displayTableData(data.GetAllTasks());
	}	
}

