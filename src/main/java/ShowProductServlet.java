// This servlet will be used to listen for users trying to view all of the Products - likely by going to a page like "/products" // "/poiducts/index.jsp

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "ShowProductServlet", urlPatterns = "/products/show")
public class ShowProductServlet extends HttpServlet{

    // This will require a doGet()

    // this method assumes that there IS a product id in the URL parameters
        // i.e. http://localhost:8080/products/show?id=27

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // check to see if there is an id passed in URL parameters
        long productId = Long.parseLong(request.getParameter("id")); //checking for "id" in URL parameters

        // Create the connection to the DaoFactory
        Products productDao = DaoFactory.getProductsDao();
            // This will give us access to all the products Interface methods

        // Get the product by its ID from ListProductsDao
        Product product = productDao.findById(productId);

        // set the attribute "product" to the object we just created.
        request.setAttribute("product", product);
        request.getRequestDispatcher("/products/product-show.jsp").forward(request,response);
        //

    }
}
