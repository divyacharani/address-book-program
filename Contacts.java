package com.bridgelabz.addressBookProgram;

import java.util.*;

public class Contacts {

	private Map<String,AddressBook> nameToContact = new HashMap<String,AddressBook>();
	
	//Setters and Getters
	public Map<String, AddressBook> getNameToContact() {
		return nameToContact;
	}

	public void setNameToContact(Map<String, AddressBook> nameToContact) {
		this.nameToContact = nameToContact;
	}
	
	//Method to add a contact
	public int addContact(String firstName, String lastName, AddressBook obj) {
		nameToContact.put(firstName+" "+lastName,obj);
		return 1;
	}
	
	//Method to edit a contact
	public int editContact(String firstName, String lastName, String address, String city, String state, int zip,
			long phoneNumber, String email) {
		for(String name : nameToContact.keySet()){
			if(name.equals(firstName+" "+lastName)) {
				nameToContact.get(name).setFirstName(firstName);
				nameToContact.get(name).setLastName(lastName);
				nameToContact.get(name).setAddress(address);
				nameToContact.get(name).setCity(city);
				nameToContact.get(name).setState(state);
				nameToContact.get(name).setZip(zip);
				nameToContact.get(name).setPhoneNumber(phoneNumber);
				nameToContact.get(name).setEmail(email);
				return 1;	
			}
		}
		return -1;
	}
	
	//Method to delete a contact
	public int deleteContact(String firstName, String lastName) {
		for(String name : nameToContact.keySet()) {
			if(name.equals(firstName+" "+lastName)) {
				nameToContact.remove(firstName+" "+lastName);
				return 1;
			}
		}
		return -1;
	}
		
}