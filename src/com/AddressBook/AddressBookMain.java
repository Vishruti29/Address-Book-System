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

    public List<Contact> searchByCity(String city) {
        return people.stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList());
    }

    public List<Contact> searchByState(String state) {
        return people.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList());
    }
}
public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook1 = new AddressBook();
        addressBook1.addContact(new Contact("Vishruti","Patil","D207","Indore","MP","452016","000","abc"));
        addressBook1.addContact(new Contact("A","B","C","D","E","F","G","H"));
        addressBook1.addContact(new Contact("Q","W","E","R","T","Y","U","I"));

        AddressBook addressBook2 = new AddressBook();
        addressBook2.addContact(new Contact("Ashu","Chouhan","123","XYZ","UP","1324","12345","fm"));
        addressBook2.addContact(new Contact("a","b","c","d","e","f","g","h"));
        addressBook2.addContact(new Contact("q","w","e","r","t","y","u","i"));

        List<AddressBook> addressBooks = Arrays.asList(addressBook1, addressBook2);

        // Create dictionaries of people by city and state
        Map<String, List<Contact>> peopleByCity = new HashMap<>();
        Map<String, List<Contact>> peopleByState = new HashMap<>();
        for (AddressBook addressBook : addressBooks) {
            for (Contact contact : addressBook.people) {
                String city = contact.getCity();
                String state = contact.getState();

                if (!peopleByCity.containsKey(city)) {
                    peopleByCity.put(city, new ArrayList<>());
                }
                peopleByCity.get(city).add(contact);

                if (!peopleByState.containsKey(state)) {
                    peopleByState.put(state, new ArrayList<>());
                }
                peopleByState.get(state).add(contact);
            }
        }

        String city = "Indore";
        String state = "UP";

        System.out.println("People in " + city + ":");
        List<Contact> peopleInCity = peopleByCity.get(city);
        if (peopleInCity != null) {
            peopleInCity.forEach(System.out::println);
        } else {
            System.out.println("No results found.");
        }

        System.out.println("People in " + state + ":");
        List<Contact> peopleInState = peopleByState.get(state);
        if (peopleInState != null) {
            peopleInState.forEach(System.out::println);
        } else {
            System.out.println("No results found.");
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