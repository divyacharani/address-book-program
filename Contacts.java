package com.bridgelabz.addressBookProgram;

import java.util.ArrayList;

public class Contacts {

	private ArrayList<AddressBook> contactList = new ArrayList<AddressBook>();
	
	//Setters and Getters
	public ArrayList<AddressBook> getContactList() {
		return contactList;
	}

	public void setContactList(ArrayList<AddressBook> contactList) {
		this.contactList = contactList;
	}

	//Method to add a contact
	public void addContact(AddressBook obj) {
		contactList.add(obj);
		System.out.println("Contact Added Successfully");
	}
}
