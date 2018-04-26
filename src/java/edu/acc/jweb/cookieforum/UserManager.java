package edu.acc.jweb.cookieforum;

import javax.sql.DataSource;

public class UserManager {
    private final DataSource dataSource;
    
    public UserManager (DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
