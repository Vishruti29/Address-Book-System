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

    public List<Contact> search(String city, String state) {
        return people.stream().filter(person -> person.getCity().equals(city) && person.getState().equals(state)).collect(Collectors.toList());
    }

    public Map<String, Long> countByCity() {
        return people.stream().collect(Collectors.groupingBy(Contact::getCity, Collectors.counting()));
    }

    public Map<String, Long> countByState() {
        return people.stream().collect(Collectors.groupingBy(Contact::getState, Collectors.counting()));
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

        // count by city
        Map<String, Long> countByCity = addressBooks.stream()
                .flatMap(addressBook -> addressBook.countByCity().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingLong(Map.Entry::getValue)));

        System.out.println("Count by City:");
        countByCity.forEach((city, count) -> System.out.println(city + ": " + count));

        // count by state
        Map<String, Long> countByState = addressBooks.stream()
                .flatMap(addressBook -> addressBook.countByState().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingLong(Map.Entry::getValue)));

        System.out.println("Count by State:");
        countByState.forEach((state, count) -> System.out.println(state + ": " + count));
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