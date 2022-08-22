package src;

import java.util.Map;
import java.util.HashMap;

public class TaskService {
	private Map<String, Task> tasks;
	
	// Add task with unique ID
	private void addTask(Task task) {
		tasks.put(task.getID(), task);
	}
		
	public Task get(String UUID) {
		return tasks.get(UUID);
	}
		
	// Remove task with unique ID
	public void remove(String UUID) {
		tasks.remove(UUID);
	}
		
	public TaskService() {
		tasks = new HashMap<String, Task>();
	}
	
	// Add task information
	public String addInformation(String taskName, String description) {
		Task toAdd = new Task(taskName, description);
		this.addTask(toAdd);
		return toAdd.getID();
	}
	
	// Update specific information in task
	public void updatableField(String UUID, String fields, String value) {
		Task task = tasks.get(UUID);
			
		// Use if switch to select which field to update
		switch(fields.toLowerCase()) {
		// Update task name
		case "taskname":
		case "task name":
			task.setTaskName(value);
			break;
		// Update description
		case "description":
			task.setDescription(value);
			break;
		default:
			break;
		}
	}
}
