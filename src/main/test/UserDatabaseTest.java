package main.test;

import main.exceptions.AccountNameNotSameException;
import main.exceptions.UserAlreadyExistsException;
import main.exceptions.UserNotFoundException;
import main.model.User;
import main.model.UserDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class UserDatabaseTest {
    private UserDatabase userDatabase;
    private User user1;
    private User user2;


    @BeforeEach
    public void setup() throws AccountNameNotSameException, UserAlreadyExistsException {
        userDatabase = userDatabase.getInstance();
        user1 = new User("Afif","zebra123");
        user2 = new User("Azim", "john123");


    }

    @Test
    public void testFindUser() throws UserAlreadyExistsException {
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);
        try {
            assertTrue(userDatabase.findUser(user1));
        } catch (UserNotFoundException e) {
            fail("Unexpected UserNotFoundException");
        }
    }

    @Test
    public void testFindUserNotExistent() throws UserAlreadyExistsException {
        userDatabase.addUser(user1);
        try {
            assertTrue(userDatabase.findUser(user2));
            fail("Expected UserNotFoundException");
        } catch (UserNotFoundException e) {
            // yay
        }
    }

    @Test
    public void addUsersNoException() {
        try {
            userDatabase.addUser(user1);
        } catch (UserAlreadyExistsException e) {
            fail("Unexpected UserAlreadyExistsException");
        }
    }

    @Test
    public void addUsersAlreadyExists() {
        try {
            userDatabase.addUser(user1);
            userDatabase.addUser(user1);
            fail("User ALready Exists");
        } catch (UserAlreadyExistsException e) {
            // yay
        }
    }
}
