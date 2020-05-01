package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: ensure the submitted information is valid
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        if (!validRegistrationInput(username, email, password, confirm)){
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        if(!confirm.equals(password)) {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        // TODO: create a new user based off of the submitted information
        User user = new User(username, email, password);


        // TODO: if a user was successfully created, send them to their profile
        DaoFactory.getUserDao().insert(user);
        request.getSession().setAttribute("user", user.getUsername());
        response.sendRedirect("/profile");
    }

    private boolean validRegistrationInput(String username, String email, String password, String confirm) {
        if (!(isValidUsername(username) && isValidEmail(email) && isValidPassword(password))) return false;
        return true;
    }

    private boolean isValidPassword(String password) {
        return true;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean isValidUsername(String username) {
        if (username.length() >= 4 && username.length() < 20 ) return true;
        Pattern pattern = Pattern.compile("[A-Za-z_][A-Za-z0-9_]+");
        return pattern.matcher(username).matches();
    }
}
