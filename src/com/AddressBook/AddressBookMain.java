package com.AddressBook;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {
            System.out.println("Select an option:");
            System.out.println("1. Add new contact");
            System.out.println("2. List all contacts");
            System.out.println("3. Edit contact");
            System.out.println("4. Delete contact");
            System.out.println("0. Quit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter address:");
                    String address = scanner.nextLine();
                    System.out.println("Enter city:");
                    String city = scanner.nextLine();
                    System.out.println("Enter state:");
                    String state = scanner.nextLine();
                    System.out.println("Enter ZIP code:");
                    String zip = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phone = scanner.nextLine();
                    System.out.println("Enter email address:");
                    String email = scanner.nextLine();

                    Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
                    addressBook.addContact(newContact);
                    System.out.println("New contact added.");
                    break;

                case 2:
                    ArrayList<Contact> contacts = addressBook.getContacts();
                    if (contacts.size() > 0) {
                        System.out.println("List of all contacts:");
                        for (Contact c : contacts) {
                            System.out.println(c.toString());
                        }
                    } else {
                        System.out.println("No contacts found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter first name of the contact to edit:");
                    String editFirstName = scanner.nextLine();
                    System.out.println("Enter last name of the contact to edit:");
                    String editLastName = scanner.nextLine();

                    Contact contactToEdit = addressBook.findContact(editFirstName, editLastName);
                    if (contactToEdit != null) {
                        System.out.println("Enter new address:");
                        String newAddress = scanner.nextLine();
                        System.out.println("Enter new city:");
                        String newCity = scanner.nextLine();
                        System.out.println("Enter new state:");
                        String newState = scanner.nextLine();
                        System.out.println("Enter new ZIP code:");
                        String newZip = scanner.nextLine();
                        System.out.println("Enter new phone number:");
                        String newPhone = scanner.nextLine();
                        System.out.println("Enter new email address:");
                        String newEmail = scanner.nextLine();

                        addressBook.editContact(contactToEdit, newAddress, newCity, newState, newZip, newPhone, newEmail);
                        System.out.println("Contact edited.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter first name of the contact to delete:");
                    String deleteFirstName = scanner.nextLine();
                    System.out.println("Enter last name of the contact to delete:");
                    String deleteLastName = scanner.nextLine();

                    boolean deleted = addressBook.deleteContact(deleteFirstName, deleteLastName);
                    if (deleted) {
                        System.out.println("Contact deleted.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 0:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
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
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
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
        } else {
            return false;
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
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String toString() {
        return this.firstName + " " + this.lastName + "\n" +
                this.address + "\n" +
                this.city + ", " + this.state + " " + this.zip + "\n" +
                "Phone: " + this.phone + "\n" +
                "Email: " + this.email;
    }
}
