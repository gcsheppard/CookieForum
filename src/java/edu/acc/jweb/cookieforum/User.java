package edu.acc.jweb.cookieforum;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    public int id;
    public String username;
    public String password;
    public String name;
    public String email;
    public Date date;

    public User (String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
}
    
    public User () {
    }

    public int getId() {
        return this.id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getDate() {
        Format formatter = new SimpleDateFormat("MM/dd/yyyy");
        String string = formatter.format(this.date);
        return string;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
}
