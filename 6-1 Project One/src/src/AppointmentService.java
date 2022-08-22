package src;

import java.util.Map;
import java.util.Date;
import java.util.HashMap;

public class AppointmentService {
private Map<String, Appointment> appointments = new HashMap<String, Appointment>();
	
	// Add task with unique ID
	private void addAppointment(Appointment appointment) {
		appointments.put(appointment.getID(), appointment);
	}
		
	public Appointment get(String UUID) {
		return appointments.get(UUID);
	}
		
	// Remove task with unique ID
	public void remove(String UUID) {
		appointments.remove(UUID);
	}
		
	public AppointmentService() {
		appointments = new HashMap<String, Appointment>();
	}
	
	// Add Appointment information
	public String addInformation(Date appointmentDate, String description) {
		Appointment toAdd = new Appointment(appointmentDate, description);
		this.addAppointment(toAdd);
		return toAdd.getID();
	}
	
	// Update specific information in task
	public void updatableField(String UUID, String fields, Date appointDate, String value) {
		Appointment appointment = appointments.get(UUID);
			
		// Use if switch to select which field to update
		switch(fields.toLowerCase()) {
		// Update task name
		case "appointmentdate":
		case "appointment date":
			appointment.setAppointmentDate(appointDate);
			break;
		// Update description
		case "description":
			appointment.setDescription(value);
			break;
		default:
			break;
		}
	}
}
