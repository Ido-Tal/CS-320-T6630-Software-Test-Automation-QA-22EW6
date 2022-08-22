package tests;

import src.Contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
	// Test case for string values
	@Test
	void testContactStringStringStringString() {
		final String firstName = "Adam";
		final String lastName = "Smith";
		final String phoneNumber = "0123456789";
		final String address = "1 Adam Street, Boston MA";
		Contact contact = new Contact(firstName,lastName,phoneNumber, address);
		
		// Checks that the values of the variables are equal
		assert(contact.getID() != null);
		assertEquals(firstName, contact.getFirstName());
		assertEquals(lastName, contact.getLastName());
		assertEquals(phoneNumber, contact.getPhoneNumber());
		assertEquals(address, contact.getAddress());
	}
	// Test for getting ID
	@Test
	void testGettingID() {
		Contact contact = new Contact();
		assert(contact.getID() != null);
		assert(contact.getID().length() <= 10);
	}
	// Test for getting first name
	@Test
	void testGettingFirstName() {
		final String lastName = "Smith";
		final String phoneNumber = "0123456789";
		final String address = "1 Adam Street, Boston MA";
		
		// Create new contact with first name missing
		Contact contact = new Contact(null,lastName,phoneNumber, address);
		assert(contact.getFirstName() != null);
		assert(contact.getFirstName().length() <= 10);
		
		// Create new contact with first name exceeding 10 characters
		contact = new Contact("Longer than 10 characters",lastName,phoneNumber, address);
		assert(contact.getFirstName() != null);
		assert(contact.getFirstName().length() <= 10);
	}
	// Test for getting last name
	@Test
	void testGettingLastName() {
		final String firstName = "Adam";
		final String phoneNumber = "0123456789";
		final String address = "1 Adam Street, Boston MA";
		
		// Create new contact with last name missing
		Contact contact = new Contact(firstName, null, phoneNumber, address);
		assert(contact.getLastName() != null);
		assert(contact.getLastName().length() <= 10);
		
		// Create new contact with last name exceeding 10 characters
		contact = new Contact(firstName, "Longer than 10 characters", phoneNumber, address);
		assert(contact.getLastName() != null);
		assert(contact.getLastName().length() <= 10);
	}
	// Test for getting phone number
	@Test
	void testGettingPhoneNumber() {
		final String firstName = "Adam";
		final String lastName = "Smith";
		final String address = "1 Adam Street, Boston MA";
		
		// Create new contact with phone number missing
		Contact contact = new Contact(firstName,lastName, null, address);
		assert(contact.getPhoneNumber() != null);
		assert(contact.getPhoneNumber().length() == 10);
		
		// Create new contact with phone number with than 10 digits
		contact = new Contact(firstName, lastName, "Longer than 10 characters", address);
		assert(contact.getPhoneNumber() != null);
		assert(contact.getPhoneNumber().length() == 10);
	}
	// Test for getting address
	@Test
	void testGettingAddress() {
		final String firstName = "Adam";
		final String lastName = "Smith";
		final String phoneNumber = "0123456789";
		
		// Create new contact with address missing
		Contact contact = new Contact(firstName,lastName, phoneNumber, null);
		assert(contact.getAddress() != null);
		assert(contact.getAddress().length() <= 30);
		
		// Create new contact with address longer than 30 characters
		contact = new Contact(firstName,lastName, phoneNumber, "This is longer than 30 characters");
		assert(contact.getAddress() != null);
		assert(contact.getAddress().length() <= 30);
	}
}