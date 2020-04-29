package Models;

import java.util.ArrayList;
import java.util.List;

public class ContactsListDao implements Contacts {

    // we need a list variable to hold all the contacts
    private List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> getContacts(){
        return  contacts;
    }

    // method for saving contact
    @Override
    public long saveContact(Contact contact){
        // it we're setting up a contact that hasn't been assigned an ID
        if(contact.getId() == 0){
            // if we are setting up the very first contact, we want to add 1, so that our SQL table doesn't start with a primary number
            contact.setId(contacts.size() + 1);
            contacts.add(contact);
        }else {
            //we aleady have the correct ID coming from the MySQL table
            //so just set that contact in the ArrayList (contacts) with the ID that was passed in
            contacts.set((int) (contact.getId() - 1), contact);
        }
        // return the ID of the newly saved contact
        return contact.getId();
    }

    // method for deleting contact
    @Override
    public void deleteContactById(long id){
        //do a .remove on the passed ID to remove that contact
        contacts.remove((int) id - 1);
    }

    // method for getting contact by id
    @Override
    public Contact getContactById(long id){
        return contacts.get((int) id - 1);
    }

    // let's test out our DAO
    public static void main(String[] args){
        Contacts contactDao = new ContactsListDao();

        System.out.println( "\n === Testing getContacts()");
        List<Contact> allContacts = contactDao.getContacts();

        for(Contact contact : allContacts){
            System.out.println(contact.getFirstName());
        }
    }
}
