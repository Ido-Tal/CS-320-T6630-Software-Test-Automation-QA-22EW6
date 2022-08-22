package src;

import java.util.Map;
import java.util.HashMap;

public class ContactService {
private Map<String, Contact> contacts;
	
	// Add contact with unique ID
	private void addContact(Contact contact) {
		contacts.put(contact.getID(), contact);
	}
	
	public Contact get(String UUID) {
		return contacts.get(UUID);
	}
	
	// Remove contact with unique ID
	public void remove(String UUID) {
		contacts.remove(UUID);
	}
	
	public ContactService() {
		contacts = new HashMap<String, Contact>();
	}
	
	// Add contact information
	public String addInformation(String firstName, String lastName, String phoneNumber, String address) {
		Contact toAdd = new Contact(firstName, lastName, phoneNumber, address);
		this.addContact(toAdd);
		return toAdd.getID();
	}
	
	// Update specific information in contact
	public void updatableField(String UUID, String fields, String value) {
		Contact contact = contacts.get(UUID);
		
		// Use if switch to select which field to update
		switch(fields.toLowerCase()) {
		// Update first name
		case "firstname":
		case "first name":
			contact.setFirstName(value);
			break;
		// Update last name
		case "lastname":
		case "last name":
			contact.setLastName(value);
			break;
		// Update phone number
		case "phonenumber":
		case "phone number":
			contact.setPhoneNumber(value);
			break;
		// Update address
		case "address":
			contact.setAddress(value);
			break;
		default:
			break;
		}
	}
}