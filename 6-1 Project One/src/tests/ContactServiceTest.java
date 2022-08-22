package tests;

import src.Contact;
import src.ContactService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	@Test
	void testContactService() {
		ContactService cs = new ContactService();
		assert(cs != null);
	}
	// Test case for adding a contact
	@Test
	void testAddContact() {
		final String firstName = "Adam";
		final String lastName = "Smith";
		final String phoneNumber = "0123456789";
		final String address = "1 Adam Street, Boston MA";
		
		ContactService cs = new ContactService();
		String UUID = cs.addInformation(firstName, lastName, phoneNumber, address);
		assert(UUID != null);
		
		Contact contact = cs.get(UUID);
		assert(contact != null);
		// Checks that the values of the variables are equal
		assertEquals(firstName, contact.getFirstName());
		assertEquals(lastName, contact.getLastName());
		assertEquals(phoneNumber, contact.getPhoneNumber());
		assertEquals(address, contact.getAddress());
	}
	// Test case for removing a contact
	@Test
	void testRemoveContact() {
		final String firstName = "Adam";
		final String lastName = "Smith";
		final String phoneNumber = "0123456789";
		final String address = "1 Adam Street, Boston MA";
		
		ContactService cs = new ContactService();
		String UUID = cs.addInformation(firstName, lastName, phoneNumber, address);
		assert(UUID != null);
		
		Contact contact = cs.get(UUID);
		assert(contact != null);
		
		cs.remove(UUID);
		assert(cs.get(UUID) == null);
	}
	// Test case for updating a specific field
	@Test
	void testContactUpdate() {
		final String firstName = "Adam";
		final String lastName = "Smith";
		final String phoneNumber = "0123456789";
		final String address = "1 Adam Street, Boston MA";
		final String testValue = "testValue";
		
		ContactService cs = new ContactService();
		String UUID = cs.addInformation(firstName, lastName, phoneNumber, address);
		assert(UUID != null);
		
		Contact contact = cs.get(UUID);
		assert(contact != null);
		
		cs.updatableField(UUID, "firstName", testValue);
		assertEquals(testValue, contact.getFirstName());
		cs.updatableField(UUID, "lastName", testValue);
		assertEquals(testValue, contact.getLastName());
		cs.updatableField(UUID, "phoneNumber", testValue);
		assertEquals(testValue, contact.getLastName());
		cs.updatableField(UUID, "address", testValue);
		assertEquals(testValue, contact.getAddress());
	}
}
