package tests;

import src.Appointment;
import src.AppointmentService;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import org.junit.jupiter.api.Test;


public class AppointmentServiceTest {
	// Defining variables for the tests
	final Date appointmentDate = new Date();
	final String description = "The Description Of The Task";
	final String testingValue = "testingValue";
	final Date testingDate = new Date();
	
	@Test
	void testTaskService() {
		AppointmentService as = new AppointmentService();
		assert(as != null);
	}
	// Test case for adding an appointment
	@Test
	void testAddAppointment() {
		AppointmentService as = new AppointmentService();
		String UUID = as.addInformation(appointmentDate, description);
		assert(UUID != null);
			
		Appointment appointment = as.get(UUID);
		assert(appointment != null);
		// Checks that the values of the variables are equal
		assertEquals(appointmentDate, appointment.getAppointmentDate());
		assertEquals(description, appointment.getDescription());
	}
		
	// Test case for removing an appointment
	@Test
	void testRemoveAppointment() {
		AppointmentService as = new AppointmentService();
		String UUID = as.addInformation(appointmentDate, description);
		assert(UUID != null);
				
		Appointment appointment = as.get(UUID);
		assert(appointment != null);
				
		as.remove(UUID);
		assert(as.get(UUID) == null);
	}
		
	// Test case for updating a specific field
	@Test
	void testAppointmentUpdate() {
		AppointmentService as = new AppointmentService();
		String UUID = as.addInformation(appointmentDate, description);
		assert(UUID != null);
				
		Appointment appointment = as.get(UUID);
		assert(appointment != null);
				
		as.updatableField(UUID, "appointmentDate", testingDate, testingValue);
		assertEquals(testingDate, appointment.getAppointmentDate());
		as.updatableField(UUID, "description", testingDate, testingValue);
		assertEquals(testingValue, appointment.getDescription());
	}
}
