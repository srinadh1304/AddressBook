package com.bridgelabz.addressbook;
import java.util.ArrayList;
public class AddressBook {
private ArrayList<ContactDetails> addressBook = new ArrayList<ContactDetails>();
	
	public void addPerson() {
		
		ContactDetails person1 = new ContactDetails();
		person1.setFirstName("Srinadh");
		person1.setLastName("Tadiparthi");
		person1.setAddress("Andhra Pradesh");
		person1.setCity("Tenali");
		person1.setState("Andhra Pradesh");
		person1.setPinCode(522201);
		person1.setPhoneNumber("9290090032");
		person1.setEmail("srinadh1304@gmail.com");
		addressBook.add(person1);
		
	}
}
