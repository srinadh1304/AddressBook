package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBook {
	private ArrayList<ContactDetails> addressBook = new ArrayList<ContactDetails>();

	public void addPerson() {
		System.out.println("Enter Person details:");
		addressBook.add(addContact());
	}
	public static ContactDetails addContact() {
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
		return person1;
	}

	public void editPerson(String name) {
		ContactDetails person = null ;
		int i = 0;
		if(addressBook.size()!=0) {
			while(i < addressBook.size()) {
				if(addressBook.get(i).getFirstName().equals(name)) {
					person = addressBook.get(i);
					break;
				}
				i++;
			}
			if(person == null) {
				System.out.println("Name not found!");
				return;
			}

			System.out.println("Changing details, Enter new details  of "+name);
			addressBook.set(i,addContact());
			System.out.println("Modified Details Successfully.");
		}
		else
		{
			System.out.println("First add some contacts to Edit");
		}
	}

	public void display() {
		Scanner sc = new Scanner(System.in);
		ContactDetails person = null; 
		if(addressBook.size()!=0) {
			System.out.println("---------Persons present in the address book------");
			for(int i=0; i<addressBook.size();i++) {
				System.out.print(addressBook.get(i).getFirstName()+"  ");
			}
			System.out.println();
			System.out.println("Enter name to see details");
			String name = sc.next();

			for(int i = 0;i < addressBook.size();i++) {
				if(addressBook.get(i).getFirstName().equals(name)) {
					person = addressBook.get(i);
					break;
				}
			}
			if(person == null) {
				System.out.println("name not found!");
				return;
			}

			displayContactDetails(person);
		}
		else
		{
			System.out.println("Add contacts to display");
		}


	}



	public static void displayContactDetails(ContactDetails person) {
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
	public void deleteContact(String name) {
		if(addressBook.size()!=0) {
			for(int i=0;i<addressBook.size();i++) {
				if(addressBook.get(i).getFirstName().equals(name)) {
					addressBook.remove(i);
					System.out.println("Deleted details of : "+name+" successfully!");
					return;
				}
			}
			System.out.println("Name not found");
		}
		else
		{
			System.out.println("Add contacts to delete");
		}
	}
}
