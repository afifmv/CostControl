package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private List<Expense> expenses;
    private List<Earning> earnings;
    private String name;

    public Account(String name) {
        this.name = name;
        expenses = new ArrayList<>();
        earnings = new ArrayList<>();
    }

    // EFFECTS: Returns the total earnings
    public int computeEarnings() {
        int totalExpenses = 0;

        for (Earning earning: earnings) {
            totalExpenses += earning.getPrice();
        }

        return totalExpenses;
    }

    // EFFECTS: Returns the total expenses
    public int computeExpenses() {
        int totalExpenses = 0;

        for (Expense expense: expenses) {
            totalExpenses += expense.getPrice();
        }

        return totalExpenses;
    }

    // EFFECTS: Displays all expenses in a specific format
    public void displayExpenses() {
        for (Expense e: expenses) {
            System.out.println("You have spent: " + e.getPrice() + "\n for " + e.getReason());
        }
    }

    // EFFECTS: Display all earnings in a specific format
    public void displayEarnings() {
        for (Earning e: earnings) {
            System.out.println("You have spent: " + e.getPrice() + "\n for " + e.getReason());
        }
    }

    // EFFECTS: Returns the net amount, i.e, earnings - expenses.
    public int netAmount() {
        return computeEarnings() - computeExpenses();
    }

    // MODIFIES: this
    // EFFECTS: adds the given expense to expenses
    public void addExpenses(Expense expense){
        expenses.add(expense);
    }

    // MODIFIES: this
    // EFFECTS: adds the given earning to earnings
    public void addEarning(Earning earning) {
        earnings.add(earning);
    }

    public String getName() {
        return name;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<Earning> getEarnings() {
        return earnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(expenses, account.expenses) && Objects.equals(earnings, account.earnings) && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenses, earnings, name);
    }
}
