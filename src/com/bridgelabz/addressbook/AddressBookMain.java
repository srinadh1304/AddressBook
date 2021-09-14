package com.bridgelabz.addressbook;
import java.util.*;

public class AddressBookMain {
	
	public static AddressBookList addressBookList = new AddressBookList();
	public static void main(String[] args) {
		System.out.println("************Welcome to Address Book Program*********");
		AddressBookMain addressBookMain = new AddressBookMain();
		Scanner scannerObject = new Scanner(System.in);
		boolean exit1 = true;
		while(exit1) {
			System.out.println("Select option 1:Add address Book 2:open Address Book 3:Search in AddressBooks  4.Number of contact persons  5:Exit");
			switch(scannerObject.nextInt()) {
			case 1: 
				System.out.println("Enter the address book name");
				String name = scannerObject.next();
				AddressBook addressBook = new AddressBook();
				addressBookList.add(name, addressBook);
				break;
			case 2:
				System.out.println("Enter the name of Address Book");
				String book = scannerObject.next();
				if(addressBookList.get(book)==null)
					System.out.println("Address Book does not exist");
				else {
					AddressBook bookName = addressBookList.get(book);
					addressBookList.addressMenu(bookName);
				}
				break;
			case 3:
				System.out.println("Options: 1.search by city 2:search by state");
				int choice=scannerObject.nextInt();
				if(choice==1) {
					System.out.println("Enter city name");
					addressBookList.searchAcrossByCity(scannerObject.next());
				}
				else if(choice==2) {
					System.out.println("Enter state name");
					addressBookList.searchAcrossByState(scannerObject.next());
				}
				else
					System.out.println("Invalid choice");
				break;
			case 4:
				System.out.println("Options: 1:Count by city 2.Count by state");
				int option = scannerObject.nextInt();
				if(option==1)
					addressBookList.countByCity();
				else if(option==2)
					addressBookList.countByState();
				else
					System.out.println("Invalid choice");
				break;
			default:
				exit1 = false;

			}
	}

	}
}