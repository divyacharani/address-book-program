package com.bridgelabz.addressBookProgram;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Welcome message
		System.out.println("Welcome to Address Book Program");

		Scanner sc = new Scanner(System.in);
		Map<String, AddressBook> dictionary = new HashMap<String, AddressBook>();

		int option = 1;
		while (option > 0 && option < 7) {
			System.out.println(
					"Enter your option\n1. View all  AddressBooks\n2. Add  New AddressBook\n3. Edit AddressBook\n4. Delete AddressBook\n5. Search persons by City\n6. Search persons by State\n7. Exit");
			option = sc.nextInt();
			switch (option) {
			// To view all Address Books
			case 1:
				for (String str : dictionary.keySet()) {
					System.out.println(str);
				}
				break;
			// To Add Address Book
			case 2:
				System.out.println("Enter the name of AddressBook you want to add");
				sc.nextLine();
				String addName = sc.nextLine();
				AddressBook obj = new AddressBook();
				dictionary.put(addName, obj);
				System.out.println("Address Book Added Successfully");
				break;
			// To Edit Address Book
			case 3:
				System.out.println("Enter the name of the Address Book you want to edit");
				sc.nextLine();
				String editName = sc.nextLine();
				AddressBookOperations(dictionary.get(editName), sc);
				break;
			// To Delete Address Book
			case 4:
				System.out.println("Enter the name of the Address Book you want to delete");
				sc.nextLine();
				String deleteName = sc.nextLine();
				dictionary.remove(deleteName);
				break;
			// To Search persons by City
			case 5:
				System.out.println("Enter name of the city to search");
				sc.nextLine();
				String cityName = sc.nextLine();
				List<Contact> personsListByCity = searchByCity(dictionary, cityName);
				personsListByCity.forEach(contact -> System.out.println(contact));
				break;
				// To Search persons by State
			case 6:
				System.out.println("Enter name of the state to search");
				sc.nextLine();
				String stateName = sc.nextLine();
				List<Contact> personsListByState = searchByState(dictionary, stateName);
				personsListByState.forEach(contact -> System.out.println(contact));
				break;
			case 7:
				break;
			default:
				System.out.println("Invalid Entry!!");
			}
		}
	}

	// Method to do operations on Address Book
	private static void AddressBookOperations(AddressBook addressBookObj, Scanner sc) {

		int option = 1;
		while (option > 0 && option < 5) {
			System.out.println(
					"Enter your option\n1. View all Contacts\n2. Add Contact\n3. Edit Contact\n4. Delete Contact\n5. Exit");
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
				sc.nextLine();
				String firstName = sc.nextLine();
				System.out.println("Enter Last Name");
				String lastName = sc.nextLine();
				if (addressBookObj.deleteContact(firstName + " " + lastName))
					System.out.println("Contact Deleted Successfully");
				else
					System.out.println("There is no contact with entered name");
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid Entry!!");

			}
		}
	}

	// Method to get contact
	private static Contact getContact(Scanner sc) {

		System.out.println("Enter First Name");
		sc.nextLine();
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name");
		String lastName = sc.nextLine();
		System.out.println("Enter Address");
		String address = sc.nextLine();
		System.out.println("Enter City");
		String city = sc.nextLine();
		System.out.println("Enter State");
		String state = sc.nextLine();
		System.out.println("Enter Zip");
		int zip = sc.nextInt();
		System.out.println("Enter Phone Number");
		long phoneNumber = sc.nextLong();
		System.out.println("Enter email");
		sc.nextLine();
		String email = sc.nextLine();
		return (new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
	}

	// Method to search persons across multiple address books in a state
	private static List<Contact> searchByState(Map<String, AddressBook> dictionary, String state) {
		List<Contact> personsList = new ArrayList<Contact>();
		for (AddressBook addressbookObj : dictionary.values()) {
			personsList.addAll(addressbookObj.getContactList().stream()
					.filter(contact -> contact.getState().equals(state)).collect(Collectors.toList()));
		}
		return personsList;

	}

	// Method to search persons across multiple address books in a city
	private static List<Contact> searchByCity(Map<String, AddressBook> dictionary, String cityName) {
		List<Contact> personsList = new ArrayList<Contact>();
		for (AddressBook addressbookObj : dictionary.values()) {
			personsList.addAll(addressbookObj.getContactList().stream()
					.filter(contact -> contact.getState().equals(cityName)).collect(Collectors.toList()));
		}
		return personsList;

	}
}