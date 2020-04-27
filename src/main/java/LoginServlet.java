import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAdmin = username.equals("admin") && password.equals("password");
        boolean validAttempt = username.equals("user") && password.equals("password");
        HttpSession session = request.getSession();


        if (validAttempt) {
            session.setAttribute("name", "User");
            request.getSession().setAttribute("isAdmin", false);
            response.sendRedirect("/profile");
        }
        if (isAdmin) {
            session.setAttribute("name", "Admin");
            request.getSession().setAttribute("isAdmin", true);
            response.sendRedirect("/secret-admin-page");
        }
        else {
//            response.sendRedirect("/login");
        }
    }
}
