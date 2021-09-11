package com.bridgelabz.addressbook;
import java.util.Scanner;
public class AddressBookMain {
	private static AddressBook[] addressBooks = new AddressBook[10];
	private static String[] addressBookName = new String[10];
	private static int  numOfBooks =0;

	private static void addressMenu(AddressBook addressBook) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean exit = true;
		while(exit) {
			System.out.println("Select option \n1: Add Contact.  \n2: Edit Existing Contact.  \n3:Display contacts \n4:Delete contact. \n5:Switch Address Book");
			option  = sc.nextInt();
			switch(option) {
			case 1 :
				addressBook.addPerson();
				break;
			case 2 :
				addressBook.editPerson();
				break;
			case 3:
				addressBook.display();
				break;
			case 4:
				addressBook.deleteContact();
				break;
			default:
				exit = false;

			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		System.out.println("****** Welcome to address book program ! ******");
		Scanner sc = new Scanner(System.in);

		AddressBook currentBook;
		boolean exit1 = true;
		while(exit1) {
			System.out.println("Select option 1:Add address Book 2:open Address Book 3:Exit");
			switch(sc.nextInt()) {
			case 1: 
				System.out.println("Enter the address book name");
				String name = sc.next();
				currentBook  = new AddressBook(name);
				addressBooks[numOfBooks] = currentBook;
				addressBookName[numOfBooks] = name;
				numOfBooks++;
				break;
			case 2:
				System.out.println("The Address books available :");
				for(int i=0;i<numOfBooks;i++) {
					System.out.println(addressBookName[i]);
				}
				System.out.println("Enter the name");
				String book = sc.next();
				int i =0;
				for(i=0;i<numOfBooks;i++) {
					if(addressBookName[i].equals(book)) break;
				}
				if(i == numOfBooks) {
					System.out.println("Name Not Found");
					break;
				}
				currentBook = addressBooks[i];
				addressMenu(currentBook);
				break;
			default:
				exit1 = false;

			}
		}



		sc.close();

	}
}