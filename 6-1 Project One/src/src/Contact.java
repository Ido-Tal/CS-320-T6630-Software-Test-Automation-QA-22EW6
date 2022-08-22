package src;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Contact {
	// Initialize variables
	static private List<String> IDs = new ArrayList<String>();
	private String ID = null;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact() {
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
	public Contact(String firstName, String lastName, String phoneNumber, String address) {
		this();	
		// Call set functions for ID, firstName, lastName, phoneNumber, and address
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
	}
	
	// Getter for ID
	public String getID() {
		return ID;
	}
	
	// Getter and Setter for first name
	public String getFirstName() {
		return firstName;
	}
	// Checks if first name has value a assigned to it and if that value is within the limit
	public void setFirstName(String firstName) {
		if(firstName == null)
			firstName = "";
		// First name cannot exceed 10 characters
		if(firstName.length() > 10)
			this.firstName = firstName.substring(0,10);
		else
			this.firstName = firstName;
	}
	
	// Getter and Setter for last name
	public String getLastName() {
		return lastName;
	}
	// Checks if last name has value a assigned to it and if that value is within the limit
	public void setLastName(String lastName) {
		if(lastName == null)
			lastName = "";
		// Last name cannot exceed 10 characters
		if(lastName.length() > 10)
			this.lastName = lastName.substring(0, 10);
		else
			this.lastName = lastName;
	}
	
	// Getter and Setter for Phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}
	// Phone number cannot be null and it cannot exceed 10 digits
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.length() != 10)
			phoneNumber = "9999999999";
		this.phoneNumber = phoneNumber;
	}
	
	// Getter and Setter for address
	public String getAddress() {
		return address;
	}
	// Checks that address has value a assigned to it and if that value is within the limit
	public void setAddress(String address) {
		if(address == null)
			address = "";
		// Address cannot exceed 30 characters
		if(address.length() > 30)
			this.address = address.substring(0,30);
		else
			this.address = address;
	}
}