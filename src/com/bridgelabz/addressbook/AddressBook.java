package com.bridgelabz.addressbook;
import java.util.Scanner;
public class AddressBook {
	private ContactDetails[] addressBook = new ContactDetails[20];
	private int numOfContacts = 0;

	public void addPerson() {
		System.out.println("Enter Person details:");

		Scanner sc = new Scanner(System.in);
		ContactDetails person1 = new ContactDetails();

		System.out.print("Enter First Name:");
		person1.setFirstName(sc.next());
		System.out.print("Enter Second Name: ");
		person1.setLastName(sc.next());
		System.out.print("Enter Address: ");
		person1.setAddress(sc.next());
		System.out.print("Enter City: ");
		person1.setCity(sc.next());
		System.out.print("Enter State: ");
		person1.setState(sc.next());
		System.out.print("Enter Pin code: ");
		person1.setPinCode(sc.nextInt());
		System.out.print("Enter Phone nmber: ");
		person1.setPhoneNumber(sc.next());
		System.out.print("Enter Email: ");
		person1.setEmail(sc.next());

		addressBook[numOfContacts] = person1;
		numOfContacts++;

	}

	public void editPerson(String phoneNumber) {
		ContactDetails person = null ;
		int i = 0;
		if(addressBook.length!=0) {
			while(addressBook[i]!= null) {
				if(addressBook[i].getPhoneNumber().equals(phoneNumber)) {
					person = addressBook[i];
					break;
				}
				i++;
			}
			if(person == null) {
				System.out.println("name not found!");
				return;
			}

			System.out.println("Changing details, Enter new details  of "+addressBook[i].getFirstName());
			addressBook[i] = addContactDetails();
		}
		else
		{
			System.out.println("First add some contacts to Edit");
		}
	}

	public void display() {
		Scanner sc = new Scanner(System.in);
		ContactDetails person = null; 
		if(addressBook.length!=0) {
			System.out.println("Persons present in the address book:");
			for(int i=0; addressBook[i] != null;i++) {
				System.out.print(addressBook[i].getFirstName()+"  ");
			}
			System.out.println();
			System.out.println("Enter name to see details");
			String name = sc.next();

			for(int i = 0;addressBook[i]!= null;i++) {
				if(addressBook[i].getFirstName().equals(name)) {
					person = addressBook[i];
					break;
				}
			}
			if(person == null) {
				System.out.println("Name not found!");
				return;
			}

			displayContactDetails(person);
		}
		else
		{
			System.out.println("First add some contacts to Delete");


		}
	}

	public void deleteContact(String phoneNumber) {
		int i=0;
		if(addressBook.length!=0) {
			for(i=0;addressBook[i]!=null;i++) {
				if(addressBook[i].getPhoneNumber().equals(phoneNumber)) {
					break;
				}
			}
			if(i==numOfContacts) {
				System.out.println("Name not found");
				return;
			}
			while(addressBook[i+1]!= null) {
				addressBook[i] = addressBook[i+1];
				i++;
			}
			addressBook[i] = null;
			System.out.println("Deleted details of : "+ phoneNumber);
		}
		else
		{
			System.out.println("First add some contacts to Delete");
		}
	}




	private static ContactDetails addContactDetails() {
		Scanner sc = new Scanner(System.in);
		ContactDetails person1 = new ContactDetails();

		System.out.println("Enter firstName:");
		person1.setFirstName(sc.next());
		System.out.println("Enter SecondName:");
		person1.setLastName(sc.next());
		System.out.println("Enter Address:");
		person1.setAddress(sc.next());
		System.out.println("Enter City:");
		person1.setCity(sc.next());
		System.out.println("Enter State:");
		person1.setState(sc.next());
		System.out.println("Enter Pin code:");
		person1.setPinCode(sc.nextInt());
		System.out.println("Enter Phone nmber:");
		person1.setPhoneNumber(sc.next());
		System.out.println("Enter email:");
		person1.setEmail(sc.next());
		return person1;
	}

	private static void displayContactDetails(ContactDetails person) {
		System.out.println("------Contact Details-------");
		System.out.println("First Name : "+person.getFirstName());
		System.out.println("Second Name : "+ person.getLastName());
		System.out.println("Address : "+ person.getAddress());
		System.out.println("City : "+person.getCity());
		System.out.println("State : "+person.getState());
		System.out.println("Pin code : "+person.getPinCode());
		System.out.println("Phone nmber : "+person.getPhoneNumber() );
		System.out.println("Email : "+person.getEmail());
	}
}
