package com.bridgelabz.addressBookProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Welcome message
		System.out.println("Welcome to Address Book Program");

		Scanner sc = new Scanner(System.in);
		Map<String, AddressBook> dictionary = new HashMap<String, AddressBook>();

		int option = 1;
		while (option > 0 && option < 5) {
			System.out.println(
					"Enter your option\n1. View all  AddressBooks\n2. Add  New AddressBook\n3. Edit AddressBook\n4. Delete AddressBook\n5. Exit");
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

}