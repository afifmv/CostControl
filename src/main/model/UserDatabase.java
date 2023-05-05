package main.model;

import main.exceptions.UserAlreadyExistsException;
import main.exceptions.UserNotFoundException;

import java.util.ArrayList;

// Represents a list of users
public class UserDatabase {
    private static UserDatabase userDatabase;
    private ArrayList<User> users;

    private UserDatabase() {
        users = new ArrayList<>();
    }

    public static UserDatabase getInstance() {
        if (userDatabase == null) {
            userDatabase = new UserDatabase();
        }
        return userDatabase;
    }

    // EFFECTS: Returns true if user exists, else throws UserNotFoundException
    public boolean findUser(User user) throws UserNotFoundException {
        if (!users.contains(user)) {
            throw new UserNotFoundException();
        }
        return true;
    }

    // MODIFIES: this
    // EFFECTS: adds user to the users, if it doesn't exist else throws UserAlreadyExistsException
    public void addUser(User u) throws UserAlreadyExistsException {
        if (users.contains(u)) {
            throw new UserAlreadyExistsException();
        }
        users.add(u);
    }

    // REQUIRES: A user object
    // EFFECTS: Authenticates the user and returns true if exists, else false and prints out a message.
    public boolean authenticateUser(User user) {
        boolean returnBool = false;
        try {
            returnBool = findUser(user);
        } catch (UserNotFoundException e) {
            System.out.println("The given user details do not exist.");
        }
        return returnBool;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
