package org.example;

import java.util.Collection;
import java.util.List;

public class User {
    private String username;
    private String email;
    private byte[] passwordHash;
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public byte[] getPasswordHash() {
        return passwordHash;
    }
    User(String username, String email, byte[] passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }
}

