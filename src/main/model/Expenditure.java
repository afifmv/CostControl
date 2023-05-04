package main.model;

import main.exceptions.InvalidPriceRangeException;

import java.time.LocalDate;

public abstract class Expenditure {
    private String reason;
    private int price;
    private LocalDate date;
    private CATEGORY category;

    // TODO: CREATE USER AUTHENTICATION
    // REQUIRES: price, quantity >= 0
    public Expenditure(String reason, int price) throws InvalidPriceRangeException {
        if (price < 0) {
            throw new InvalidPriceRangeException();
        }

        this.reason = reason;
        this.price = price;
        date = LocalDate.now();
    }

    public String getReason() {
        return reason;
    }

    public int getPrice() {
        return this.price;
    }

    private enum CATEGORY {
        TRAVEL, ENTERTAINMENT, FOOD, SCHOOL, OTHER
    }

}
