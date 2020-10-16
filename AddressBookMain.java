package com.bridgelabz.addressBookProgram;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Welcome message
		System.out.println("Welcome to Address Book Program");

		Scanner sc = new Scanner(System.in);
		Dictionary object = new Dictionary();

		int option = 1;
		while (option > 0 && option < 7) {
			System.out.println(
					"Enter your option\n1. View all  AddressBooks\n2. Add  New AddressBook\n3. Edit AddressBook\n4. Delete AddressBook\n5. Search persons by City\n6. Search persons by State\n7. Exit");
			option = sc.nextInt();
			switch (option) {
			case 1:
				object.viewallBooks();// To view all Address Books
				break;
			case 2:
				object.addBook(); // To Add Address Book
				break;
			case 3:
				object.editBook(); // To Edit Address Book
				break;
			case 4:
				object.deleteBook(); // To Delete Address Book
				break;
			case 5:
				object.searchByCity(); // To Search persons by City
				break;
			case 6:
				object.searchByState(); // To Search persons by State
				break;
			case 7:
				System.out.println("You have quit the program!!");
				break;
			default:
				System.out.println("Invalid Entry!!");
			}
		}
	}
}