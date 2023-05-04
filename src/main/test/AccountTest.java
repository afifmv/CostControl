package main.test;

import main.model.Account;
import main.model.Earning;
import main.exceptions.InvalidCategoryException;
import main.exceptions.InvalidPriceRangeException;
import main.model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setup() {
        account = new Account("Afif");
    }

    @Test
    public void testConstructor() {
        assertEquals("Afif", account.getName());
        assertEquals(new ArrayList<>(), account.getEarnings());
        assertEquals(new ArrayList<>(), account.getExpenses());
    }

    @Test
    public void testAddExpense() throws InvalidPriceRangeException, InvalidCategoryException {
        Expense expense = null;
        expense = new Expense("Expense #1", 1200, "food");
        account.addExpenses(expense);

        ArrayList<Expense> assertList = new ArrayList<>();
        assertList.add(expense);

        assertEquals(assertList, account.getExpenses());
    }

    @Test
    public void testAddEarning() throws InvalidPriceRangeException {
        Earning earning = new Earning("Expense #1", 1200);
        account.addEarning(earning);

        ArrayList<Earning> assertList = new ArrayList<>();
        assertList.add(earning);

        assertEquals(assertList, account.getEarnings());
    }

    @Test
    public void testComputeEarning() throws InvalidPriceRangeException {
        Earning earning = new Earning("Expense #1", 1200);
        account.addEarning(earning);

        assertEquals(1200, account.computeEarnings());
    }

    @Test
    public void testComputeExpense() throws InvalidPriceRangeException, InvalidCategoryException {
        Expense expense = new Expense("Expense #1", 1200, "food");
        account.addExpenses(expense);

        assertEquals(1200, account.computeExpenses());
    }

    @Test
    public void testComputeNetAmount() throws InvalidPriceRangeException, InvalidCategoryException {
        Expense expense = new Expense("Expense #1", 1200, "travel");
        account.addExpenses(expense);

        Earning earning = new Earning("Expense #1", 1200);
        account.addEarning(earning);

        assertEquals(0, account.netAmount());

    }
}
