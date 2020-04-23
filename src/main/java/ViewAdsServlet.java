import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "ViewAdsServlet", urlPatterns = "/ads")
    public class ViewAdsServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            Ads siteAds = DaoFactory.getAdsDao();

            ArrayList<Ad> allSiteAds = (ArrayList<Ad>) siteAds.all();
            //now we have all site ads, and we can send them to the JSP template


            //setAttribute
            request.setAttribute("allTheAds", allSiteAds);


            // getRequestDispatcher

            request.getRequestDispatcher("ads/index.jsp").forward(request, response);



        }
    }


