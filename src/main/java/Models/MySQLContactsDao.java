package Models;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLContactsDao implements Contacts{
    private Connection conn;

    public MySQLContactsDao() throws SQLException {
        //instantiate a config object
        Config config = new Config();

        //set up our database driver, and make a connection
        DriverManager.registerDriver(new Driver());

        // get connection object
        Connection conn = DriverManager.getConnection(
                config.getUrl(),
                config.getUserName(),
                config.getPasssword()
        );


    }

    @Override
    public List<Contact> getContacts() {
        List<Contact> output = new ArrayList<>();

        // Query the SQL Db table for all contacts
        String query = "SELECT * FROM contacts";

        // Take into account th SQL Exception that needs to be handled
        try {
            // Create a statement object
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Iterate through our result set and add each contact to our 'Contact' Bean
            while(rs.next()){
                output.add(
                        new Contact(
                                rs.getLong("id"), // id
                                rs.getString("first_name"),// first name
                                rs.getString("last_name"),// last name
                                rs.getString("phone_number")//phone number
                        )
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return output; //returns lte List<Contact> of all the contacts we imported from MySQL DB
    }

    @Override
    public long saveContact(Contact contact) {
        // a Contact object sent in with first/last/phone,
        // we need to insert that info into a new row in the database, then return
// INSERT INTO contacts (first_name, last_name, phone_number) VALUES ('casey', 'friday', '9877654321'

        // This is the ID we return after inserting the user into the DB table
        long newlyCreatedUserId = 0;

        String addContactQuery = String.format("INSERT INTO contacts (first_name, last_name, phone_number) VALUES ('%s', '%s', '%s')",
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhoneNumber(),
                contact.getId()
        );
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(addContactQuery, Statement.RETURN_GENERATED_KEYS);
            long insertedRowId = 0;
            ResultSet ks = stmt.getGeneratedKeys();
            if(ks.next()){
                ks.getLong(1);// this will save the MySql row ID to a variable
            }
            if(insertedRowId != 0 ){
                contact.setId(insertedRowId);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        //return the newly inserted user's id
        return newlyCreatedUserId;

    }

    @Override
    public void deleteContactById(long id) {
        // 'id' passed in is the id of the row we want to delete from our DB table

        // SQL equiv for deleting row by tid: DELETE FROM contacts WHERE id = sentInId
        String query = String.format("DELETE FROM contacts WHERE id = %d", id);

        try {
            // Create a statement object
            Statement stmt = conn.createStatement();
            boolean success = stmt.execute(query);
            if(success){
                System.out.println("Contact has been deleted.");
            } else{
                System.out.println("Contact was not deleted - check for syntax errors");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Contact getContactById(long id) {

        Contact returnContact = new Contact();
        String query = String.format("SELECT * FROM contacts WHERE id = %d", id);

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()){// this means there is a match
                returnContact.setId(id);
                returnContact.setFirstName(rs.getString("first_name"));
                returnContact.setLastName(rs.getString("last_name"));
                returnContact.setPhoneNumber(rs.getString("phone_number"));

            }else{// there was no match for the id that was sent in
                System.out.println("Supplied user id found no contact matches.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    return returnContact;
    }



}
