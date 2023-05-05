package main.test;

import main.model.Earning;
import main.exceptions.InvalidPriceRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EarningTest {
    private Earning expense;

    @BeforeEach
    public void setup() {
        try {
            expense = new Earning("UBC tuition fees", 24000, "aed");
        } catch (InvalidPriceRangeException e) {
            fail("Unexpected InvalidPriceRangeException");
        }
    }

    @Test
    public void testPriceNegative() {
        try {
            Earning e = new Earning("Foo", -1, "aed");
            fail("Expected InvalidPriceRangeException");
        } catch (InvalidPriceRangeException ex) {
            assertTrue(true);
        }

    }
    @Test
    public void testConstructor() {
        assertEquals("UBC tuition fees", expense.getReason());
        assertEquals(24000, expense.getPrice());
    }
}
