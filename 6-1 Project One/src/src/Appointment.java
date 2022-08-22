package src;

import java.util.UUID;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Appointment {
	// Initialize variables
	static private List<String> IDs = new ArrayList<String>();
	private String ID = null;
	private Date appointmentDate;
	private String description;
			
	public Appointment() {
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
			
	public Appointment(Date appointmentDate, String description) {
		this();	
		// Call set functions for taskName and description
		setAppointmentDate(appointmentDate);
		setDescription(description);
	}
		
	// Getter for ID
	public String getID() {
		return ID;
	}
		
	// Getter and Setter for appointmentDate
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	Date checkDate = new Date();
	// Checks if the appointment date has value a assigned to it and if the date is not before today
	public void setAppointmentDate(Date appointmentDate) {
		// Variables to check for current date to compare to appointment date
		final ZoneId defaultZoneId = ZoneId.systemDefault();
		final LocalDate today = LocalDate.now();
		final LocalDate yesterday = today.minusDays(1);
		final Date yesterdayAppointmentDate = Date.from(yesterday.atStartOfDay(defaultZoneId).toInstant());
		
		if(appointmentDate == null || appointmentDate.before(yesterdayAppointmentDate)) 
			this.appointmentDate = new Date();
		else
			this.appointmentDate = appointmentDate;
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
