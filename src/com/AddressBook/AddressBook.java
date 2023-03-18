package com.AddressBook;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        // create new contacts
        Contact contact1 = new Contact("Vish", "Chaudhari", "140", "jalgaon", "MH", "12345", "91-12345678", "vish.ch@gmail.com");
        Contact contact2 = new Contact("Gaurav", "Patil", "207", "Indore", "MP", "12345", "91-87654321", "gaurav.patil@gmail.com");

        // add contacts to address book
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);

        // display contacts
        List<Contact> contacts = addressBook.getContacts();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return firstName + " " + lastName + "\n" + address + "\n" + city + ", " + state + " " + zip + "\n" + phone + "\n" + email + "\n";
    }
}
