package com.bridgelabz.addressBookProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dictionary {
	private Map<String, AddressBook> dictionary = new HashMap<String, AddressBook>();
	Scanner sc = new Scanner(System.in);

	// To view all Address Books
	public void viewallBooks() {

		for (String str : dictionary.keySet()) {
			System.out.println(str);
		}
	}
	
	// To Add Address Book
	public void addBook() {
		System.out.println("Enter the name of AddressBook you want to add");
		String addName = sc.next();
		AddressBook obj = new AddressBook();
		dictionary.put(addName, obj);
		System.out.println("Address Book Added Successfully");
	}

	// To Edit Address Book
	public void editBook() {
		System.out.println("Enter the name of the Address Book you want to edit");
		String editName = sc.next();
		AddressBookOperations(dictionary.get(editName), sc);
	}

	// To Delete Address Book
	public void deleteBook() {
		System.out.println("Enter the name of the Address Book you want to delete");
		String deleteName = sc.next();
		dictionary.remove(deleteName);
	}

	// To Search persons by City
	public void searchByCity() {
		System.out.println("Enter name of the city to search");
		String cityName = sc.next();
		List<Contact> personsList = search(cityName);
		long countByCity = personsList.stream().count();
		if (countByCity != 0) {
			System.out.println("Number of persons in the city " + cityName + " : " + countByCity);
			personsList.forEach(contact -> System.out.println(contact));
		} else
			System.out.println("There are no contacts with city name " + cityName);
	}

	// To Search persons by State
	public void searchByState() {
		System.out.println("Enter name of the state to search");
		String stateName = sc.next();
		List<Contact> personsList = search(stateName);
		long countByState = personsList.stream().count();
		if (countByState != 0) {
			System.out.println("Number of persons in the state " + stateName + " are " + countByState);
			personsList.forEach(contact -> System.out.println(contact));
		} else
			System.out.println("There are no contacts with state name " + stateName);
	}

	public List<Contact> search(String name) {
		List<Contact> personsList = new ArrayList<Contact>();
		for (AddressBook addressbookObj : dictionary.values()) {
			personsList.addAll(addressbookObj.getContactList().stream()
					.filter(contact -> contact.getCity().equalsIgnoreCase(name)).collect(Collectors.toList()));
		}
		return personsList;
	}

	// Method to do operations on Address Book
	private static void AddressBookOperations(AddressBook addressBookObj, Scanner sc) {

		int option = 1;
		while (option > 0 && option < 6) {
			System.out.println(
					"Enter your option\n1. View all Contacts\n2. Add Contact\n3. Edit Contact\n4. Delete Contact\n5. Sort Contacts\n6. Back");
			option = sc.nextInt();
			switch (option) {
			// To view all Contacts
			case 1:
				List<Contact> contactList = new ArrayList<Contact>();
				contactList = addressBookObj.viewContacts();
				for (Contact contact : contactList) {
					System.out.println(contact);
				}
				break;
			// To add a contact
			case 2:
				System.out.println("Enter the details to add contact");
				if (addressBookObj.addContact(getContact(sc)))
					System.out.println("Contact Added Successfully");
				else
					System.out.println("Name already exists!!");
				break;
			// To edit a contact
			case 3:
				System.out.println("Enter the details to edit contact");
				if (addressBookObj.editContact(getContact(sc)))
					System.out.println("Contact updated Successfully");
				else
					System.out.println("There is no contact with entered name");
				break;
			// To delete a contact
			case 4:
				System.out.println("Enter the details to delete contact");
				System.out.println("Enter First Name");
				String firstName = sc.next();
				System.out.println("Enter Last Name");
				String lastName = sc.next();
				if (addressBookObj.deleteContact(firstName + " " + lastName))
					System.out.println("Contact Deleted Successfully");
				else
					System.out.println("There is no contact with entered name");
				break;
			case 5:
				System.out.println(
						"Enter your option\n1. Sort by Name\n2. Sort by zip\n3. Sort by city\n4. Sort by state");
				int choice = sc.nextInt();
				List<Contact> sortedList = new ArrayList<Contact>();
				if (choice == 1)
					sortedList = addressBookObj.sortByName();
				else if (choice == 2)
					sortedList = addressBookObj.sortByZip();
				else if (choice == 3)
					sortedList = addressBookObj.sortByCity();
				else if (choice == 4)
					sortedList = addressBookObj.sortByState();
				sortedList.forEach(contact -> System.out.println(contact));
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid Entry!!");

			}
		}
	}

	// Method to get contact
	private static Contact getContact(Scanner sc) {

		System.out.println("Enter First Name");
		String firstName = sc.next();
		System.out.println("Enter Last Name");
		String lastName = sc.next();
		System.out.println("Enter Address");
		String address = sc.next();
		System.out.println("Enter City");
		String city = sc.next();
		System.out.println("Enter State");
		String state = sc.next();
		System.out.println("Enter Zip");
		int zip = sc.nextInt();
		System.out.println("Enter Phone Number");
		long phoneNumber = sc.nextLong();
		System.out.println("Enter email");
		String email = sc.next();
		return (new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
	}
}
