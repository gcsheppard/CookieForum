package edu.acc.jweb.cookieforum;

import javax.sql.DataSource;

public class UserManager {
    private final DataSource dataSource;
    
    public UserManager (DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void addUser(User user) {
        
    }
    
    public String validRegistration(User user, String password2) {
        String errors = "";
        if (user.username.isEmpty()) errors = errors + "Username not entered.<br>";
        if (user.password.isEmpty()) errors = errors + "Password not entered.<br>";
        if (user.name.isEmpty()) errors = errors + "Name not entered.<br>";
        if (user.email.isEmpty()) errors = errors + "Email not entered.<br>";
        if (!errors.isEmpty()) errors = "Error(s):<br>" + errors;
        
        return errors;
    }
}
