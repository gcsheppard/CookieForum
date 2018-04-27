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
    public String flash;

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
        String password = (String) request.getParameter("password");
        String name = (String) request.getParameter("name");
        String email = (String) request.getParameter("email");
        UserManager userManager = (UserManager) getServletContext().getAttribute("userManager");
        User user = new User(username, password, name, email);
        String errors = userManager.validRegistration(user);
        if (errors.isEmpty()) {
            userManager.addUser(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            flash = "";
            response.sendRedirect("/CookieForum/home"); 
        }
        else {
            request.setAttribute("user", user);
            request.setAttribute("errors", errors);
            flash = "Registration failed.";
            request.setAttribute("flash", flash);
            getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }
    }                                                                                                                                                                                                                                               
    
}
