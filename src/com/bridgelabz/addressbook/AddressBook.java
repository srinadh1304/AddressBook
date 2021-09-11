package com.bridgelabz.addressbook;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
	HashMap<String,ContactDetails> addressBook;
	private int numOfContacts = 0;
	Scanner sc = new Scanner(System.in);
	String name;
	AddressBook(String name){
		this.addressBook=new HashMap<>();
		this.name=name;
	}
	public void addPerson() {
		System.out.println("Enter Person details:");


		ContactDetails person1 = new ContactDetails();

		System.out.print("Enter First Name:");
		String firstName=sc.next();
		person1.setFirstName(firstName);
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
		if(search(firstName)==false)
			addressBook.put(firstName,person1);
		else
			System.out.println("Contact with same name already exists");
		numOfContacts++;

	}
	public boolean search(String name) {
		if(addressBook.get(name)!=null)
			return true;
		else
			return false;
	}

	public void editPerson() {
		System.out.println("Edit contact:");
		System.out.println("Select Option:\n1.First Name\n2.Last Name\n3.City\n4.State\n5.Phone\n6.Email");
		int choice=sc.nextInt();
		System.out.println("Enter First name of contact to be edited");
		String nameToBeEdited=sc.next();
		ContactDetails contactToBeEdited=addressBook.get(nameToBeEdited);
		if(contactToBeEdited!=null) {
			switch(choice) {
			case 1: System.out.println("Enter new First Name");
			String newFName=sc.next();
			contactToBeEdited.setFirstName(newFName);
			addressBook.remove(nameToBeEdited);
			addressBook.put(newFName, contactToBeEdited);
			break;
			case 2: System.out.println("Enter new Last Name");
			String newLName=sc.next();
			contactToBeEdited.setLastName(newLName);
			addressBook.replace(nameToBeEdited, contactToBeEdited);
			break;
			case 3: System.out.println("Enter new City");
			String newCity=sc.next();
			contactToBeEdited.setCity(newCity);
			addressBook.replace(nameToBeEdited, contactToBeEdited);
			break;
			case 4: System.out.println("Enter new State");
			String newState=sc.next();
			contactToBeEdited.setState(newState);
			addressBook.replace(nameToBeEdited, contactToBeEdited);
			break;
			case 5: System.out.println("Enter new Phone Number");
			String newPNumber=sc.next();
			contactToBeEdited.setPhoneNumber(newPNumber);
			addressBook.replace(nameToBeEdited, contactToBeEdited);
			break;
			case 6: System.out.println("Enter new Email");
			String newEmail=sc.next();
			contactToBeEdited.setEmail(newEmail);
			addressBook.replace(nameToBeEdited, contactToBeEdited);
			break;
			}
			System.out.println("Contact edited");
		}else
		{
			System.out.println("Contact not found");
		}
	}

	public void display() {
		Scanner sc = new Scanner(System.in);
		ContactDetails person = null; 
		if(addressBook.size()!=0) {
			System.out.println("Enter name to see details");
			String name = sc.next();
			for(int i = 0;i<addressBook.size();i++) {
				if(addressBook.get(name) != null) {
					person = addressBook.get(name);
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

	public void deleteContact() {
		System.out.println("Enter first name of contact to be deleted");
		String nameToBeDeleted=sc.next();
		addressBook.remove(nameToBeDeleted);
		System.out.println("Contact deleted");
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
