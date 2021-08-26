package com.bridgelabz.addressbook;
import java.util.Scanner;
public class AddressBookMain {
	public static void main(String args[]) {


		System.out.println("*********** Welcome to address book program  *************");
		Scanner sc = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		int choice = 0;
		boolean exit = true;
		while(exit) {
			System.out.println("Select option \n1: Add Contact  \n2: Edit existing Contact.  \n3: Display \n4. Delete Contact \n5: Exit");
			choice  = sc.nextInt();
			switch(choice) {
			case 1 :
				addressBook.addPerson();
				break;
			case 2 :
				System.out.println("Enter the Contact Name to Edit Details");
				addressBook.editPerson(sc.next());
				break;
			case 3:
				addressBook.display();
				break;
			case 4:
				System.out.println("Enter name");
				addressBook.deleteContact(sc.next());
				break;
			default:
				exit = false;

			}
			System.out.println();
		}
		sc.close();
	}
}