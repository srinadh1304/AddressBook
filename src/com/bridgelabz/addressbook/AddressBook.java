package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBook {
	private ArrayList<ContactDetails> addressBook = new ArrayList<ContactDetails>();
	public void addPerson() {
		Scanner sc = new Scanner(System.in);
		ContactDetails person1 = new ContactDetails();
		System.out.println("-------Enter the Contact Details--------");
		System.out.print("Enter First Name: ");
		sc.next();
		person1.setFirstName(sc.nextLine());
		System.out.print("Enter Second Name: ");
		sc.next();
		person1.setLastName(sc.nextLine());
		System.out.print("Enter Address: ");
		sc.next();
		person1.setAddress(sc.nextLine());
		System.out.print("Enter City: ");
		person1.setCity(sc.next());
		System.out.print("Enter State: ");
		sc.next();
		person1.setState(sc.nextLine());
		System.out.print("Enter Pin code: ");
		person1.setPinCode(sc.nextInt());
		System.out.print("Enter Phone nmber: ");
		person1.setPhoneNumber(sc.next());
		System.out.print("Enter email: ");
		person1.setEmail(sc.next());
		sc.close();
		addressBook.add(person1);

	}


}
