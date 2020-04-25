import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAdminDashboardServlet extends LoginServlet{


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirect if the user is not an admin
        // might need to refactor if "false" string needs to be false boolean
        if (request.getSession().getAttribute("isAdmin") == "false") {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/secret-admin-page.jsp").forward(request, response);
    }


}
