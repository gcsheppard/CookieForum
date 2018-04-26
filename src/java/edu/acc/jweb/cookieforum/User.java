package edu.acc.jweb.cookieforum;

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

    
}
