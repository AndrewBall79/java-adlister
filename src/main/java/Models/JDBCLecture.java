package Models;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class JDBCLecture {

    public static void main(String[] args) throws SQLException{

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

        // ***********create a statement object*************
        Statement stmt = conn.createStatement();


        // ***********execute some sort of query*************
        // create a query string to get everything in the contacts table
        String contactsQuery = "SELECT * FROM contacts";

        ResultSet rs = stmt.executeQuery(contactsQuery);

        // display what's actually in the ResultSet

        while(rs.next()){
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("phone_number"));

        }


        //If we want to add a row to our database, we'll;
            // 1 Create a contact object (bean)
            // 2 Use out DAO to add out new contact using the saveContact() method, and get the resulting ID
            // 3 Create an SQL query to insert that contact object into out database, as a new row, using the ID we previously retrieved
            // 4 To add to our DAO - instantiate ContactsListDap, and use the saveContact() method



        // this will allow us to use the methods defined in out DAO
        Contacts clDao = DaoFactory.getContactsDao(); // this data-access-object allows us to interact with all the contacts


        // Instantiate a new Contact Object
        Contact casey = new Contact(
                "Alby",
                "Querqy",
                "212346897667"
        );


        long newContactId = clDao.saveContact(casey); // id (for use in DB) on new contact
        Contact newlyCreatedContact = clDao.getContactById(newContactId);

        // INSERT INTO contacts (first_name, last_name, phone_number) VALUES ('casey', 'friday', '9877654321'

        String addContactQuery = String.format("INSERT INTO contacts (first_name, last_name, phone_number) VALUES ('%s', '%s', '%s')",
                newlyCreatedContact.getFirstName(),
                newlyCreatedContact.getLastName(),
                newlyCreatedContact.getPhoneNumber(),
                newlyCreatedContact.getId()
        );


        System.out.println("This is the string we'll be sending to MySQL\n" + addContactQuery);
        // now let's actually execute this SQL query to add the new contact to our database
        int numRows = stmt.executeUpdate(addContactQuery, Statement.RETURN_GENERATED_KEYS);


        //If we add Statement.REturn, we can work with the actual MySQL DB table rows ID's, and reassign those ID's to our Contact objects here in our Java Code

        long insertedRowId = 0;
        ResultSet ks = stmt.getGeneratedKeys();
        if(ks.next()){
            insertedRowId = ks.getLong(1);// this will save the MySQL row ID to a variable
            System.out.println("The ID of the newly inserted row is: " + ks.getLong(1));
        }
        System.out.println("Before doing the MySQL is check, " + newlyCreatedContact.getFirstName() + "'s id was: " + newlyCreatedContact.getId());
        System.out.println("Number of rows affected: " + numRows);

//check to see if the id was returned, or if insetredRowId is still at its defualt of '0'
        if (insertedRowId != 0 ){
            newlyCreatedContact.setId(insertedRowId);
        }

    }
}
