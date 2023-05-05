package main.model;

import java.util.Objects;

// Represents a single user for authentication purposes
public class User {
    private String username;
    private String password;
    private final Account account;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.account = new Account(username);
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Account getAccount() {
        return this.account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(account, user.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, account);
    }
}
