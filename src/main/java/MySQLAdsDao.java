import Models.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLAdsDao implements Ads {
    private Connection connection;


    public MySQLAdsDao(Config config) {
        this.config = config;
    }
    Config config = new Config();


     DriverManager.registerDriver(new Driver());

    // Get a connection object
    this.connection = DriverManager.getConnection(
    Ads.all()



}
