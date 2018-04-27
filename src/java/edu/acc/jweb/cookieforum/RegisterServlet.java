package edu.acc.jweb.cookieforum;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) { 
            getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        }
    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = (String) request.getParameter("username");
        String password1 = (String) request.getParameter("password1");
        String password2 = (String) request.getParameter("password2");
        String name = (String) request.getParameter("name");
        String email = (String) request.getParameter("email");
        UserManager userManager = (UserManager) getServletContext().getAttribute("userManager");
        User user = new User(username, password1, name, email);
        String errors = userManager.validRegistration(user, password2);
        if (errors.isEmpty()) {
            userManager.addUser(user);
            response.sendRedirect("/CookieForum/home"); 
        }
        else {
            request.setAttribute("user", user);
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }
    }                                                                                                                                                                                                                                               
    
}
