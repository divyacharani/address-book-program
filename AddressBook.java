package com.bridgelabz.addressBookProgram;

import java.util.*;

public class AddressBook {

	private List<Contact> contactList = new ArrayList<Contact>();
	
	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	// Method to add a contact
	public boolean addContact(Contact obj) {
		Contact contactObject = contactList.stream().filter(contact -> obj.equals(contact)).findAny().orElse(null);
		if (contactObject == null)
			contactList.add(obj);
		else
			return false;
		return true;
	}

	// Method to edit a contact
	public boolean editContact(Contact obj) {
		Contact contactObject = contactList.stream().filter(contact -> obj.equals(contact)).findAny().orElse(null);
		if (contactObject == null)
			return false;
		else
			contactList.set(contactList.indexOf(contactObject), obj);
		return true;

	}

	// Method to delete a contact
	public boolean deleteContact(String name) {
		Contact contactObject = contactList.stream()
				.filter(contact -> name.equals(contact.getFirstName() + " " + contact.getLastName())).findAny()
				.orElse(null);
		if (contactObject == null)
			return false;
		else
			contactList.remove(contactObject);
		return true;
	}

	// Method to view all contacts
	public List<Contact> viewContacts() {
		return contactList;

	}

}