package com.bridgelabz.addressBookProgram;

import java.util.*;

public class AddressBook {

	private Map<String, Contact> nameToContact = new HashMap<String, Contact>();

	// Setters and Getters
	public Map<String, Contact> getNameToContact() {
		return nameToContact;
	}

	public void setNameToContact(Map<String, Contact> nameToContact) {
		this.nameToContact = nameToContact;
	}

	// Method to add a contact
	public void addContact(Contact obj) {
		nameToContact.put(obj.getFirstName() + " " + obj.getLastName(), obj);
	}

	// Method to edit a contact
	public void editContact(Contact obj) {
		nameToContact.replace(obj.getFirstName() + " " + obj.getLastName(), obj);
	}

	// Method to delete a contact
	public void deleteContact(String firstName, String lastName) {
		nameToContact.remove(firstName + " " + lastName);
	}
	
	//Method to view all contacts
	public List<Contact> viewContacts() {
		List<Contact> contactList = new ArrayList<Contact>();
		for (String str : nameToContact.keySet()) {
			contactList.add(nameToContact.get(str));
		}
		return contactList;

	}

}