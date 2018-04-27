package edu.acc.jweb.cookieforum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class UserManager {
    private final DataSource dataSource;
    
    public UserManager (DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO Users (username, password, name, email) values (?,?,?,?)");
            statement.setString(1, user.username);
            statement.setString(2, PasswordHash.hashPassword(user.password));
            statement.setString(3, user.name);
            statement.setString(4, user.email);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            try {
                if (statement != null) { 
                    statement.close();
                } 
                if (connection != null) { 
                    connection.close();
                } 
            } catch (SQLException sqle) {
                throw new RuntimeException(sqle);
            }
        }   
    }
    
    public String validRegistration(User user) {
        String errors = "";
        User found = findUser(user.username);
        if (found != null) {
            errors = errors + "Username not available.<br>";
        } else {
            if (user.username.isEmpty()) errors = errors + "Username not entered.<br>";
        }
        if (user.password.isEmpty()) errors = errors + "Password not entered.<br>";
        if (user.name.isEmpty()) errors = errors + "Name not entered.<br>";
        if (user.email.isEmpty()) errors = errors + "Email not entered.<br>";
        if (!errors.isEmpty()) errors = "Error(s):<br>" + errors;
        
        return errors;
    }
    
    public User validateLogin(String username, String password) {
        User found = findUser(username);
        if (found != null) {
            if (found.getPassword().equals(PasswordHash.hashPassword(password))) {
                return found;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
    
    public User findUser(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setDate(resultSet.getDate("date"));
                return user;
            }
            else {
                return null;
            }
        } catch(SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            try {
                if (resultSet != null) { 
                    statement.close();
                }   
                if (statement != null) { 
                    statement.close();
                } 
                if (connection != null) { 
                    connection.close();
                } 
            } catch (SQLException sqle) {
                throw new RuntimeException(sqle);
            }
        }            
    }
}
