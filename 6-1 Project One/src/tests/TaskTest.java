package tests;

import src.Task;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {
	// Test case for string values
	@Test
	void testTaskStringTwice() {
		final String taskName = "Name Of The Task";
		final String description = "The Description Of The Task";
		Task task = new Task(taskName,description);
			
		// Checks that the values of the variables are equal
		assert(task.getID() != null);
		assertEquals(taskName, task.getTaskName());
		assertEquals(description, task.getDescription());
	}
	
	// Test for getting ID
	@Test
	void testGettingID() {
		Task task = new Task();
		assert(task.getID() != null);
		assert(task.getID().length() <= 10);
	}
	
	// Test for getting task name
	@Test
	void testGettingTaskName() {
		final String description = "The Description Of The Task";
			
		// Create new task with task name missing
		Task task = new Task(null,description);
		assert(task.getTaskName() != null);
		assert(task.getDescription().length() <= 50);
			
		// Create new contact with task name exceeding 20 characters
		task = new Task("Longer than 20 characters For This Test",description);
		assert(task.getTaskName() != null);
		assert(task.getDescription().length() <= 50);
	}
	
	// Test for getting description
	@Test
	void testGettingDescription() {
		final String taskName = "Name Of The Task";
				
		// Create new task with description missing
		Task task = new Task(taskName,null);
		assert(task.getTaskName().length() <= 20);
		assert(task.getDescription() != null);
				
		// Create new contact with description exceeding 50 characters
		task = new Task(taskName,"This Is Longer than 50 characters For This Test!!!!!!!!");
		assert(task.getTaskName().length() <= 20);
		assert(task.getDescription() != null);
	}
}
