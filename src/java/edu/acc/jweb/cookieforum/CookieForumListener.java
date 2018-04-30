package edu.acc.jweb.cookieforum;

import java.util.ArrayList;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@DataSourceDefinition(
        name = "java:app/jdbc/CookieForum",
        className = "org.apache.derby.jdbc.ClientDataSource",
        url = "jdbc:derby://localhost:1527/",
        databaseName = "CookieForum",
        user = "app",
        password = "app")

@WebListener
public class CookieForumListener implements ServletContextListener {
    
    @Resource(lookup = "java:app/jdbc/CookieForum")
    DataSource dataSource;
    
    
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("userManager", new UserManager(dataSource));
        
        ArrayList<String> topics = new ArrayList<>();
        topics.add("Bar Cookies");
        topics.add("Chocolate Chip Cookies");
        topics.add("Christmas Cookies");
        topics.add("Drop Cookies");
        topics.add("Filled Cookies");
        topics.add("Sandwich Cookies");
        topics.add("Macaroons");
        topics.add("Nut Cookies");
        topics.add("Peanut Butter Cookies");
        topics.add("Sugar Cookies");
        sce.getServletContext().setAttribute("topics", topics);
        
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
    }
}
