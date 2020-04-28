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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {



        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAdmin = username.equals("admin") && password.equals("password");
        boolean validAttempt = username.equals("user") && password.equals("password");
        HttpSession session = request.getSession();



        if (validAttempt) {
            name = "User1";
            request.getSession().setAttribute("isAdmin", false);
            request.setAttribute("name", name);
            response.sendRedirect("/profile");
//            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
        else if (isAdmin) {
//            name = "AdminAddy";
//            request.setAttribute("name", name);
            request.getSession().setAttribute("isAdmin", true);
            response.sendRedirect("/secret-admin-page");
//            request.getRequestDispatcher("/WEB-INF/secret-admin-page.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/login");
        }
//        request.setAttribute("name", name);
        System.out.println(name);
    }
}
