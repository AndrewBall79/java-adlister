import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/secret-admin-page")
public class ViewAdminProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirect if the user is not an admin

        if (request.getSession().getAttribute("isAdmin") == "false") {
            response.sendRedirect("/login");
        } else {
            request.getRequestDispatcher("/WEB-INF/secret-admin-page.jsp").forward(request, response);
        }
    }
    }
