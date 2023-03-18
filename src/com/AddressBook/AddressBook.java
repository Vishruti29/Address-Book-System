package com.AddressBook;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        // create scanner for console input
        Scanner scanner = new Scanner(System.in);

        // loop to add contacts
        while (true) {
            System.out.print("Enter first name (or 'quit' to exit): ");
            String firstName = scanner.nextLine();
            if (firstName.equals("quit")) {
                break;
            }

            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            System.out.print("Enter city: ");
            String city = scanner.nextLine();

            System.out.print("Enter state: ");
            String state = scanner.nextLine();

            System.out.print("Enter zip code: ");
            String zip = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter email address: ");
            String email = scanner.nextLine();

            // create new contact and add to address book
            Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
            addressBook.addContact(contact);

            System.out.println("Contact added:\n" + contact);
        }

        // display all contacts in address book
        List<Contact> contacts = addressBook.getContacts();
        System.out.println("All contacts in address book:");
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
