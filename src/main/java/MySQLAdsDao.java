//import Models.Config;
//
//import java.sql.*;
//import java.util.List;
//
//public class MySQLAdsDao implements Ads {
//    private Connection connection = null;
//
//
//    public MySQLAdsDao(Config config) {
//    try {
//        DriverManager.registerDriver((new Driver() {
//        connection = DriverManager.getConnection(
//                config.getUrl(),
//            config.getUsername(),
//                    config.getPassword()
//
//
//
//
//    Config config = new Config();
//
//
//
//        @Override
//        public List<Ad> all() {
//            Statement stmt = null ;
//            try{
//                stmt = connection.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
//                return createAdsFromResults();
//            }catch (SQLException e){
//                throw new RuntimeException("Error retrieving all ads. ", e);
//            }
//
//        }
//
//
//    @Override
//    public Long insert(Ad ad) {
//        try{
//            Statement stmt = connection.createStatement();
//            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return; rs.getLong(1);
//        }catch (SQLException e){
//            throw new RuntimeException("Error retrieving all ads.");
//        }
//    }
//
//    private String createInsertQuery(Ad ad) {
//            return "INSERT INTO ads(user_id, title, description) VALUES"
//                    + "ad.getUserId()"
//                    +"ad.getTitle()";
//    }
//
//
//
//    private Ad extractAd(ResultSet rs) throws SQLException {
//        return new Ad(
//                rs.getLong("id"),
//                rs.getLong("user_id"),
//                rs.getString("title"),
//                rs.getString("description")
//        );
//
//
//
//    }