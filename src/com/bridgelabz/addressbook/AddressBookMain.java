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
			System.out.println("Select option 1:Add address Book 2:open Address Book 3:search by city or state 4:exit");
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
			case 3:
				System.out.println("Select 1:search by city 2: search by state");
				int option = sc.nextInt();
				if(option == 1) {
					System.out.println("enter city");
					String city = sc.next();
					System.out.println("enter firstName");
					String firstName  = sc.next();
					AddressBookMain.searchByCity(city,firstName);
				}
				else {
					System.out.println("enter state");
					String state = sc.next();
					System.out.println("enter firstName");
					String firstName  = sc.next();
					AddressBookMain.searchByState(state,firstName);
				}
				break;
			default:
				exit1 = false;

			}
		}



		sc.close();

	}
	private static void searchByState(String state, String firstName) {
		for(int i=0;addressBooks[i]!=null;i++) {
			addressBooks[i].searchByState(state,firstName);
		}
	}
	private static void searchByCity(String city, String firstName) {
		for(int i=0;addressBooks[i]!=null;i++) {
			addressBooks[i].searchByCity(city,firstName);
		}
		
	}
}