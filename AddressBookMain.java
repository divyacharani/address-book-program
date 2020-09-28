package com.bridgelabz.addressBookProgram;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Welcome message
		System.out.println("Welcome to Address Book Program");

		Contacts person = new Contacts();
		int option= 1;
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);
		
		
		while(option>0 && option<4) {
			System.out.println("Enter your option\n1. Add Contact\n2. Edit Contact\n3. Delete Contact\n4. Exit");
			option = sc.nextInt();
			//To add a contact
			if(option==1) {
				System.out.println("Enter the details to add contact");
				System.out.println("Enter First Name");
				sc.nextLine();
				String firstName = sc.nextLine();
				System.out.println("Enter Last Name");
				String lastName = sc.nextLine();
				System.out.println("Enter Address");
				String  address= sc.nextLine();
				System.out.println("Enter City");
				String city = sc.nextLine();
				System.out.println("Enter State");
				String  state= sc.nextLine();
				System.out.println("Enter Zip");
				int  zip= sc.nextInt();
				System.out.println("Enter Phone Number");
				long phoneNumber = sc.nextLong();
				System.out.println("Enter email");
				sc.nextLine();
				String email = sc.nextLine();
				AddressBook obj = new AddressBook(firstName, lastName, address, city, state, zip, phoneNumber, email);
				person.addContact(obj);
			}
			//To edit a contact
			else if(option==2) {
				System.out.println("Enter the details to edit contact");
				System.out.println("Enter First Name");
				sc.nextLine();
				String firstName = sc.nextLine();
				System.out.println("Enter Last Name");
				String lastName = sc.nextLine();
				System.out.println("Enter Address");
				String  address= sc.nextLine();
				System.out.println("Enter City");
				String city = sc.nextLine();
				System.out.println("Enter State");
				String  state= sc.nextLine();
				System.out.println("Enter Zip");
				int  zip= sc.nextInt();
				System.out.println("Enter Phone Number");
				long phoneNumber = sc.nextLong();
				System.out.println("Enter email");
				sc.nextLine();
				String email = sc.nextLine();
				person.editContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
			}
			//To delete a contact
			else if(option==3) {
				System.out.println("Enter the details to delete contact");
				System.out.println("Enter First Name");
				sc.nextLine();
				String firstName = sc.nextLine();
				System.out.println("Enter Last Name");
				String lastName = sc.nextLine();
				person.deleteContact(firstName, lastName);
			}
		}
		sc.close();

	}

}
