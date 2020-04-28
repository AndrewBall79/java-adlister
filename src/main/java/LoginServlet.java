import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            response.sendRedirect("/profile");
        }else{
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAdmin = username.equals("admin") && password.equals("password");
        boolean validAttempt = username.equals("user") && password.equals("password");

        if (!validAttempt){
            validAttempt = username.equals("andy") && password.equals("password");
        }


        if (validAttempt) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            request.getSession().setAttribute("isAdmin", false);
            response.sendRedirect("/profile");
        }
        else if (isAdmin) {
            String name = "AdminAndy";
            request.setAttribute("name", username);
            request.getSession().setAttribute("isAdmin", true);
            response.sendRedirect("/secret-admin-page");
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
