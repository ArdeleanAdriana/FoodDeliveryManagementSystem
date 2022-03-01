package BLL;

import java.io.Serializable;

public class Account implements Serializable{
    String username;
    String password;
    int id;
    
    public Account() {
    	
    }
    
    public Account( String username, String password, int id) {
        this.username = username;
        this.password = password;    
        this.id=id;
    }

    @Override
    public String toString() {
        return  username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }
}

