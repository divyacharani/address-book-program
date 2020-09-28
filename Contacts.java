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
	
	//Method to edit a contact
	public void editContact(String firstName, String lastName, String address, String city, String state, int zip,
			long phoneNumber, String email) {
		for(AddressBook obj : contactList) {
		if(obj.getFirstName().equals(firstName) && obj.getLastName().equals(lastName)) {
			obj.setFirstName(firstName);
			obj.setLastName(lastName);
			obj.setAddress(address);
			obj.setCity(city);
			obj.setState(state);
			obj.setZip(zip);
			obj.setPhoneNumber(phoneNumber);
			obj.setEmail(email);
			System.out.println("Contact Updated Successfully");
			break;	
		}
		else
			System.out.println("There is no contact with name "+firstName+" "+lastName);
		}
	}
}
