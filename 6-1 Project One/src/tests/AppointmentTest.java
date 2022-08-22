package tests;

import src.Appointment;
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest {
	// Test case for string values
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
	@Test
	void testTaskStringTwice() {
		final Date appointmentDate = new Date();
		final String description = "The Description Of The Task";
		Appointment appointment = new Appointment(appointmentDate,description);
				
		// Checks that the values of the variables are equal
		assert(appointment.getID() != null);
		assertEquals(appointmentDate, appointment.getAppointmentDate());
		assertEquals(description, appointment.getDescription());
	}
		
	// Test for getting ID
	@Test
	void testGettingID() {
		Appointment appointment = new Appointment();
		assert(appointment.getID() != null);
		assert(appointment.getID().length() <= 10);
	}
		
	// Test for getting appointment date
	@Test
	void testGettingAppointmentDate() {
		final String description = "The Description Of The Task";
		final ZoneId defaultZoneId = ZoneId.systemDefault();
		final LocalDate today = LocalDate.now();
		final LocalDate yesterday = today.minusDays(1);
		final Date yesterdayAppointmentDate = Date.from(yesterday.atStartOfDay(defaultZoneId).toInstant());
		//final Date currentDate = null;
				
		// Create new appointment with appointment date missing
		Appointment appointment = new Appointment(null,description);
		assert(appointment.getAppointmentDate() != null);
		assert(appointment.getDescription().length() <= 50);
				
		// Create new appointment with appointment date before today
		appointment = new Appointment(yesterdayAppointmentDate,description);
		assert(appointment.getAppointmentDate() != null);
		assert(appointment.getDescription().length() <= 50);
	}
		
	// Test for getting description
	@Test
	void testGettingDescription() {
		final Date appointmentDate = new Date();
		final ZoneId defaultZoneId = ZoneId.systemDefault();
		final LocalDate today = LocalDate.now();
		final LocalDate yesterday = today.minusDays(1);
		final Date yesterdayAppointmentDate = Date.from(yesterday.atStartOfDay(defaultZoneId).toInstant());
					
		// Create new task with description missing
		Appointment appointment = new Appointment(appointmentDate,null);
		assert(appointment.getAppointmentDate().after(yesterdayAppointmentDate));
		assert(appointment.getDescription() != null);
					
		// Create new contact with description exceeding 50 characters
		appointment = new Appointment(appointmentDate,"This Is Longer than 50 characters For This Test!!!!!!!!");
		assert (appointment.getAppointmentDate().after(yesterdayAppointmentDate));
		assert(appointment.getDescription().length() <= 50);
	}
}
