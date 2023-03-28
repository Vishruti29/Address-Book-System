package com.AddressBook;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
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
        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBooks = new HashMap<>();
        Set<String> addressBookNames = new HashSet<>(); // New HashSet to store names of existing address books.
        while (true) {
            System.out.println("Welcome to the Address Book System!");
            System.out.println("What would you like to do?");
            System.out.println("1. Create a new Address Book");
            System.out.println("2. Add a Contact to an Address Book");
            System.out.println("3. View Contacts in an Address Book");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter the name of the new Address Book:");
                String name = scanner.next();
                // Check if the name already exists in the HashSet.
                if (addressBookNames.contains(name)) {
                    System.out.println("Address Book with name '" + name + "' already exists. Please enter a different name.");
                } else {
                    AddressBook addressBook = new AddressBook();
                    addressBooks.put(name, addressBook);
                    addressBookNames.add(name); // Add the new name to the HashSet.
                    System.out.println("Address Book '" + name + "' created.");
                }
            } else if (choice == 2) {
                System.out.println("Enter the name of the Address Book to add a Contact to:");
                String name = scanner.next();
                AddressBook addressBook = addressBooks.get(name);
                if (addressBook == null) {
                    System.out.println("No Address Book with name '" + name + "' found.");
                } else {
                    System.out.println("Enter the details of the new Contact:");
                    System.out.println("First Name:");
                    String firstName = scanner.next();
                    System.out.println("Last Name:");
                    String lastName = scanner.next();
                    System.out.println("Address:");
                    String address = scanner.next();
                    System.out.println("City:");
                    String city = scanner.next();
                    System.out.println("State:");
                    String state = scanner.next();
                    System.out.println("Zip Code:");
                    String zip = scanner.next();
                    System.out.println("Phone Number:");
                    String phone = scanner.next();
                    System.out.println("Email:");
                    String email = scanner.next();
                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
                    addressBook.addContact(contact);
                    System.out.println("Contact added to Address Book '" + name + "'.");
                }
            } else if (choice == 3) {
                System.out.println("Enter the name of the Address Book to view Contacts in:");
                String name = scanner.next();
                AddressBook addressBook = addressBooks.get(name);
                if (addressBook == null) {
                    System.out.println("No Address Book with name '" + name + "' found.");
                } else {
                    List<Contact> contacts = addressBook.getContacts();
                    if (contacts.isEmpty()) {
                        System.out.println("No Contacts found in Address Book '" + name + "'.");
                    } else {
                        System.out.println("Contacts in Address Book '" + name + "':");
                        for (Contact contact : contacts) {
                            System.out.println(contact);
                        }
                    }
                }
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }
    static class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    public Contact(String firstName, String lastName, String address, String city, String state, String zipCode,
                   String phoneNumber, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
}
