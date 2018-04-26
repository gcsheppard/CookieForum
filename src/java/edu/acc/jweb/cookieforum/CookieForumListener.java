package edu.acc.jweb.cookieforum;

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
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
    }
}
