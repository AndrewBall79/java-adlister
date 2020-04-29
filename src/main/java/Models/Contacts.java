package Models;//INTERFACE FOR OUR CONTACT BEAN

import java.util.List;

public interface Contacts {
    // List all the contacts (List<Models.Contact>)
    List<Contact> getContacts();

    // method for saving contact
    long saveContact(Contact contact);

    // method for deleting contact
    void deleteContactById(long id);

    // method for getting contact by id
    Contact getContactById(long id);

}
