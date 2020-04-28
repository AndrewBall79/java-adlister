public class Config {
    // url host for mysql
    public String getUrl(){
        return "jdbc:mysql://localhost/contacts_db?serverTimezone=UTC&useSSL=false";

    }
    // mysql username
    public String getUserName(){
        return "root";
    }

    //mysql password
    public String getPasssword(){
        return "password";
    }
}
