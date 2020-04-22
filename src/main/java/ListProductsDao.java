import java.util.ArrayList;
import java.util.List;


//THis is out DAO(Data Access Object)
public class ListProductsDao implements Products {
    // list ass the products, find a product by ID, create a product

    //This will list all the products in the database table
    private List<Product> products;

    //Constructor for this DAO class
    public ListProductsDao(){
        this.products = new ArrayList<>();
        Product hammer = new Product();
        hammer.setId(1);
        hammer.setTitle("A Bad Hammer");
        hammer.setPriceInCents(3000);
        hammer.setDescription("A bad Hammer");
        products.add(hammer);

        Product xbox = new Product();
        xbox.setId(2);
        xbox.setTitle("Xbox something");
        xbox.setPriceInCents(5000);
        xbox.setDescription("Better than gaming PC");
        products.add(xbox);

        Product chiaPet = new Product();
        chiaPet.setId(3);
        chiaPet.setTitle("Chia Pet");
        chiaPet.setPriceInCents(8000);
        chiaPet.setDescription("mostly useless");
        products.add(chiaPet);
    }

    //Implement out interface requirements(from products.java)


    @Override
    public Product findById(long id) {
        //We want to return the 'Product' object for the ID passed in
        // This will return the full row in the database
        //i.e. id|title|priceInCents|description(the full row)
//        return products.get()
        return products.get((int)id-1);
    }

    @Override
    public long createProduct(Product product) {
        // create a product and insert into ArrayList (eventuall the database)
        // assign an ID
        product.setId(products.size()+1);//same as auto increment
        // add a new Product to the ArrayList
        products.add(product); // when we call the createProduct method,
                                //we are sending in a 'Product' type object
                                // this will add that object to the ArrayList
        return product.getId();

    }
}
