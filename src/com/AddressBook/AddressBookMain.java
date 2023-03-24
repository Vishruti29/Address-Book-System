package com.AddressBook;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("\nAddress Book Options:");
            System.out.println("1. Add a new contact");
            System.out.println("2. List all contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Quit the program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();

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

                    Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
                    addressBook.addContact(newContact);
                    System.out.println("\nContact added successfully!");
                    break;
                case 2:
                    ArrayList<Contact> contacts = addressBook.getContacts();
                    if (contacts.size() == 0) {
                        System.out.println("\nNo contacts found!");
                    } else {
                        System.out.println("\nAll Contacts:");
                        for (Contact c : contacts) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter first name of the contact to edit: ");
                    firstName = scanner.nextLine();

                    System.out.print("Enter last name of the contact to edit: ");
                    lastName = scanner.nextLine();

                    Contact contactToEdit = addressBook.findContact(firstName, lastName);
                    if (contactToEdit != null) {
                        System.out.println("\nContact Details:");
                        System.out.println(contactToEdit);
                        System.out.println("\nEnter new contact details:");

                        System.out.print("Enter new address: ");
                        address = scanner.nextLine();

                        System.out.print("Enter new city: ");
                        city = scanner.nextLine();

                        System.out.print("Enter new state: ");
                        state = scanner.nextLine();

                        System.out.print("Enter new zip code: ");
                        zip = scanner.nextLine();

                        System.out.print("Enter new phone number: ");
                        phone = scanner.nextLine();

                        System.out.print("Enter new email address: ");
                        email = scanner.nextLine();

                        addressBook.editContact(contactToEdit, address, city, state, zip, phone, email);
                        System.out.println("\nContact updated successfully!");
                    } else {
                        System.out.println("\nContact not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter first name of the contact to delete: ");
                    firstName = scanner.nextLine();

                    System.out.print("Enter last name of the contact to delete: ");
                    lastName = scanner.nextLine();

                    if (addressBook.deleteContact(firstName, lastName)) {
                        System.out.println("\nContact deleted successfully!");
                    } else {
                        System.out.println("\nContact not found!");
                    }
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("\nInvalid choice! Please enter a valid choice.");
            }
        }
        scanner.close();
    }
}

class AddressBook {
    private ArrayList<Contact> contacts;
    public AddressBook() {
        this.contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public Contact findContact(String firstName, String lastName) {
        for (Contact c : this.contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)) {
                return c;
            }
        }
        return null;
    }

    public void editContact(Contact contact, String address, String city, String state, String zip, String phone, String email) {
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZip(zip);
        contact.setPhone(phone);
        contact.setEmail(email);
    }

    public boolean deleteContact(String firstName, String lastName) {
        Contact contactToDelete = findContact(firstName, lastName);
        if (contactToDelete != null) {
            this.contacts.remove(contactToDelete);
            return true;
        }
        return false;
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
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName + ", Address: " + this.address + ", City: " + this.city + ", State: " + this.state + ", Zip Code: " + this.zip + ", Phone Number: " + this.phone + ", Email Address: " + this.email;
    }
}
