package com.bridgelabz.addressBookProgram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
	public static String path = "C:\\Users\\DELL\\eclipse-workspace\\AddressBookProgram\\src\\com\\bridgelabz\\addressBookProgram\\contacts-file.txt";

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
		if (contactObject == null) {
			contactList.add(obj);
			writeData(obj);
		} else
			return false;
		return true;
	}

	// To write data to file
	public void writeData(Contact obj) {
		StringBuffer contactBuffer = new StringBuffer();
		String contactDataString = obj.toString().concat("\n");
		contactBuffer.append(contactDataString);
		try {
			Files.write(Paths.get(path), contactBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// To read data from file
	public Contact readData() {
		Contact obj = new Contact();
		try {
			Files.lines(Paths.get(path)).map(line -> line.trim()).forEach(line -> {
				String data = line.toString();
				String[] dataArray = data.split(", ");
				int index = 0;
				while (index < dataArray.length) {
					String firstName= dataArray[index].replace("firstName=", "");
					index++;
					String lastName = dataArray[index].replace("lastName=", "");
					index++;
					String address = dataArray[index].replace("address=", "");
					index++;
					String city = dataArray[index].replace("city=", "");
					index++;
					String state = dataArray[index].replace("state=", "");
					index++;
					int zip = Integer.parseInt(dataArray[index].replace("zip=", ""));
					index++;
					long phoneNumber = Long.parseLong(dataArray[index].replace("phoneNumber=", ""));
					index++;
					String email = dataArray[index].replace("email=", "");
					obj.setFirstName(firstName);
					obj.setLastName(lastName);
					obj.setAddress(address);
					obj.setCity(city);
					obj.setState(state);
					obj.setZip(zip);
					obj.setPhoneNumber(phoneNumber);
					obj.setEmail(email);
					System.out.println(obj);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
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

	// Method to view contacts in sorted order by name
	public List<Contact> sortByName() {
		List<Contact> sortedList = contactList.stream().sorted(
				(c1, c2) -> (c1.getFirstName() + c1.getLastName()).compareTo(c2.getFirstName() + c2.getLastName()))
				.collect(Collectors.toList());
		return sortedList;
	}

	// Method to view contacts in sorted order by city
	public List<Contact> sortByCity() {
		List<Contact> sortedList = contactList.stream().sorted((c1, c2) -> (c1.getCity()).compareTo(c2.getCity()))
				.collect(Collectors.toList());
		return sortedList;
	}

	// Method to view contacts in sorted order by zip code
	public List<Contact> sortByZip() {
		List<Contact> sortedList = contactList.stream().sorted((c1, c2) -> c1.getZip() - c2.getZip())
				.collect(Collectors.toList());
		return sortedList;
	}

	// Method to view contacts in sorted order by state
	public List<Contact> sortByState() {
		List<Contact> sortedList = contactList.stream().sorted((c1, c2) -> (c1.getState()).compareTo(c2.getState()))
				.collect(Collectors.toList());
		return sortedList;
	}

}