package main.test;

import main.model.Account;
import main.exceptions.AccountNameNotSameException;
import main.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private Account account;

    @BeforeEach
    public void setup() throws AccountNameNotSameException {
        account = new Account("Afif");
        user = new User("Afif", "zebra123", account);
    }

    @Test
    public void testConstructorNoExceptions() {
        assertEquals("Afif", user.getUsername());
        assertEquals("zebra123", user.getPassword());
        assertEquals(account, user.getAccount());
    }

    @Test
    public void testConstructorNotSameNameAsAccount() {
        try {
            User user21 = new User("Azim","john123", account);
            fail("Expected AccountNotSameException");
        } catch (AccountNameNotSameException e) {
            // yay
        }
    }
}
