package main.test;

import main.exceptions.InvalidCategoryException;
import main.exceptions.InvalidPriceRangeException;
import main.model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTest {
    private Expense expense;

    @BeforeEach
    public void setup() {
        try {
            expense = new Expense("UBC tuition fees", 24000, "Food", "cad");
        } catch (InvalidPriceRangeException e) {
            fail("Unexpected InvalidPriceRangeException");
        } catch (InvalidCategoryException e) {
            fail("Unexpected InvalidCategoryException");
        }
    }

    @Test
    public void testPriceNegative() {
        try {
            new Expense("Foo", -1, "entertainment", "aed");
            fail("Expected InvalidPriceRangeException");
        } catch (InvalidPriceRangeException ex) {
            assertTrue(true);
        } catch (InvalidCategoryException e) {
            fail("boo InvalidCategoryException");
        }
    }
    @Test
    public void testConstructor() {
        assertEquals("UBC tuition fees", expense.getReason());
        assertEquals(24000, expense.getPrice());
    }
}
