package src;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Task {
	
	// Initialize variables
	static private List<String> IDs = new ArrayList<String>();
	private String ID = null;
	private String taskName;
	private String description;
		
	public Task() {
		// Check if ID has been set
		if(ID != null)
			return;
			
		// Generate a unique identifier
		UUID id = UUID.randomUUID();
		// Find a unique ID with a limit of 10 characters
		while(IDs.contains(id.toString().substring(0, 10)))
			id = UUID.randomUUID();
			
		ID = id.toString().substring(0, 10);
	}
		
	public Task(String taskName, String description) {
		this();	
		// Call set functions for taskName and description
		setTaskName(taskName);
		setDescription(description);
	}
	
	// Getter for ID
	public String getID() {
		return ID;
	}
	
	// Getter and Setter for taskName
	public String getTaskName() {
		return taskName;
	}
	// Checks if task name has value a assigned to it and if that value is within the limit
	public void setTaskName(String taskName) {
		if(taskName == null)
			taskName = "";
		// Task name cannot exceed 20 characters
		if(taskName.length() > 20)
			this.taskName = taskName.substring(0,20);
		else
			this.taskName = taskName;
	}
	
	// Getter and Setter for description
	public String getDescription() {
		return description;
	}
	// Checks if description has value a assigned to it and if that value is within the limit
	public void setDescription(String description) {
		if(description == null)
			description = "";
		// Description cannot exceed 50 characters
		if(description.length() > 50)
			this.description = description.substring(0,50);
		else
			this.description = description;
	}
}
