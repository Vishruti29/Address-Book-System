package com.AddressBook;
import java.util.*;
import java.util.stream.Collectors;

class AddressBook {
    public List<Contact> people;

    public AddressBook() {
        this.people = new ArrayList<Contact>();
    }
    public void addContact(Contact contact) {
        this.people.add(contact);
    }
    public List<Contact> getContact() {
        return people;
    }

}
public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addContact(new Contact("Vishruti","Patil","D207","Indore","MP","452016","000","abc"));
        addressBook.addContact(new Contact("A","B","C","D","E","F","G","H"));
        addressBook.addContact(new Contact("Q","W","E","R","T","Y","U","I"));

        List<Contact> sortedPeople = addressBook.getContact().stream().sorted(Comparator.comparing(Contact::getFirstName)).collect(Collectors.toList());
        System.out.println("Sorted Address Book by Name:");
        sortedPeople.forEach(System.out::println);
    }
}
    class Contact {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String phoneNumber;
        private String email;
        public Contact(String firstName, String lastName, String address, String city, String state, String zip,
                       String phoneNumber, String email)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
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
        public String getZip() {
            return zip;
        }
        public void setZip(String zip) {
            this.zip = zip;
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
                    ", zip=" + zip +
                    ", phone=" + phoneNumber + ", email='" + email + '\'' +
                    '}';
        }
    }