/*  Main Class  */

//  import Scanner utility
import java.util.Scanner;

public class Main {

    //  Create scanner and phone objects
    private static Scanner scanner = new Scanner(System.in);
    private static Phone phone = new Phone("(000) 123-4567");

    public static void main(String[] args) {

        //  Initial behavior of application
        boolean quit = false;
        startPhone();
        printActions();

        //  Maintain behavior of phone
        while (!quit) {
            System.out.println("Enter an option (6 to show all options):");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("\nShutting down");
                    quit = true;
                    break;
                case 1:
                    phone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }

    //  Method to add a new contact
    private static void addNewContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter a phone number");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if (phone.addNewContact(newContact)) {
            System.out.println("Contact added: " + name + ", " + phoneNumber);
        } else {
            System.out.println("Cannot add contact, " + name + " already exists.");
        }
    }

    //  Method to update an existing contact
    private static void updateContact() {
        System.out.println("Enter an existing contact to update: ");
        String name = scanner.nextLine();
        Contact existingContact = phone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.print("Enter an updated name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter an updated phone number: ");
        String newNumber = scanner.nextLine();
        Contact updatedContact = Contact.createContact(newName, newNumber);
        if (phone.updateContact(existingContact, updatedContact)) {
            System.out.println("Successfully updated contact information.");
        } else {
            System.out.println("Error updating contact information.");
        }
    }

    //  Method to remove an existing contact
    private static void removeContact() {
        System.out.println("Enter an existing contact to delete: ");
        String name = scanner.nextLine();
        Contact existingContact = phone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        if (phone.removeContact(existingContact)) {
            System.out.println("Successfully deleted contact.");
        } else {
            System.out.println("Error deleting contact.");
        }
    }

    //  Method to query contact
    private static void queryContact() {
        System.out.println("Enter an existing contact to search: ");
        String name = scanner.nextLine();
        Contact existingContact = phone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContact.getName() +
            ", Phone Number: " + existingContact.getPhoneNumber());
    }

    //  Method to start phone application
    private static void startPhone() {
        System.out.println("Starting phone, please wait...");
    }

    //  Method to print options for phone
    private static void printActions() {
        System.out.println("\n Press number for action:\n" +
            "0 - Exit phone\n" +
            "1 - Print contacts\n" +
            "2 - Add a new contact\n" +
            "3 - Update an existing contact\n" +
            "4 - Remove an existing contact\n" +
            "5 - Query to see if a contact exists\n" +
            "6 - Print a list of actions");
        System.out.println("Choose an option: ");
    }
}



/*  Contacts Class  */

public class Contact {

    //  Fields for Contact class
    private String name;
    private String phoneNumber;

    //  Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //  Getters
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //  Return a static Contact record (factory method)
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}



/*  Phone Class  */

//  Import ArrayList utility
import java.util.ArrayList;

public class Phone {

    //  Fields for Phone Class
    private String myNumber;
    private ArrayList<Contact> myContacts;

    //  Constructor
    public Phone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    //  Method to add a new contact
    public boolean addNewContact(Contact contact) {
        if(findContact(contact.getName()) >=0) {
            System.out.println("This contact already exists.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    //  Method to update existing contact
    public boolean updateContact(Contact originalContact, Contact updatedContact) {
        int contactPosition = findContact(originalContact);
        if (contactPosition < 0) {
            System.out.println("This contact does not exist.");
            return false;
        }
        this.myContacts.set(contactPosition, updatedContact);
        System.out.println(originalContact.getName() + " was updated to " + updatedContact.getName());
        return true;
    }

    //  Method to remove a contact
    public boolean removeContact(Contact contact) {
        int contactPosition = findContact(contact);
        if (contactPosition < 0) {
            System.out.println("This contact does not exist.");
            return false;
        }
        this.myContacts.remove(contactPosition);
        System.out.println(contact.getName() + " was deleted.");
        return true;
    }

    //  Find contact by index (Overloaded method)
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    //  Find contact by name (Overloaded method)
    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    //  Method to return data of contact as string (Overloaded method)
    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    //  Method to return contact (Overloaded method)
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    //  Method to print a list of all contacts
    public void printContacts() {
        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                this.myContacts.get(i).getName() + ", " +
                this.myContacts.get(i).getPhoneNumber());
        }
    }
}
