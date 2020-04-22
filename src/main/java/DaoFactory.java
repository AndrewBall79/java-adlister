    // This DAO class will provide access to out model data,
    // but will not require accessing the ListProductsDao class directly
    // Instead, we will reference the the Interface
    public class DaoFactory {

    private static Products productsDao;//interface to interact with data

    public static Products getProductsDao(){
       if(productsDao == null){
           productsDao = new ListProductsDao(); // this is the ONLY reference to the
           //ListProductsDao class
       }
       //if it is not null, return the productsDao that already exists
        //this is an instance of the ListProductsDao class
       return productsDao;
    }
}
