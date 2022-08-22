package tests;

import src.Task;
import src.TaskService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TaskServiceTest {
	// Defining variables for the tests
	final String taskName = "Name Of The Task";
	final String description = "The Description Of The Task";
	final String testingValue = "testingValue";
	
	@Test
	void testTaskService() {
		TaskService cs = new TaskService();
		assert(cs != null);
	}
	// Test case for adding a task
	@Test
	void testAddTask() {
		TaskService cs = new TaskService();
		String UUID = cs.addInformation(taskName, description);
		assert(UUID != null);
		
		Task task = cs.get(UUID);
		assert(task != null);
		// Checks that the values of the variables are equal
		assertEquals(taskName, task.getTaskName());
		assertEquals(description, task.getDescription());
	}
	
	// Test case for removing a task
	@Test
	void testRemoveTask() {
		TaskService cs = new TaskService();
		String UUID = cs.addInformation(taskName, description);
		assert(UUID != null);
			
		Task task = cs.get(UUID);
		assert(task != null);
			
		cs.remove(UUID);
		assert(cs.get(UUID) == null);
	}
	
	// Test case for updating a specific field
	@Test
	void testTaskUpdate() {
		TaskService cs = new TaskService();
		String UUID = cs.addInformation(taskName, description);
		assert(UUID != null);
			
		Task task = cs.get(UUID);
		assert(task != null);
			
		cs.updatableField(UUID, "taskName", testingValue);
		assertEquals(testingValue, task.getTaskName());
		cs.updatableField(UUID, "description", testingValue);
		assertEquals(testingValue, task.getDescription());
	}
}
