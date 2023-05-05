package main.model;

import main.exceptions.InvalidPriceRangeException;

import java.time.LocalDate;

public abstract class Expenditure {
    private String reason;
    private int price;
    private LocalDate date;
    private CATEGORY category;
    private CURRENCY currency;

    // REQUIRES: price, quantity >= 0
    public Expenditure(String reason, int price, String currency) throws InvalidPriceRangeException {
        if (price < 0) {
            throw new InvalidPriceRangeException();
        }

        this.reason = reason;
        this.price = price;
        date = LocalDate.now();
        processCurrency(currency);
    }

    private void processCurrency(String currency) {
        String lowerCaseCurrency = currency.toLowerCase();
        if (lowerCaseCurrency.equals("aed")) {
            this.currency = CURRENCY.AED;
        } else if (lowerCaseCurrency.equals("cad")) {
            this.currency = CURRENCY.CAD;
        }
    }

    public String getReason() {
        return reason;
    }

    public int getPrice() {
        return this.price;
    }

    public CURRENCY getCurrency() {
        return this.currency;
    }


    private enum CATEGORY {
        TRAVEL, ENTERTAINMENT, FOOD, SCHOOL, OTHER
    }

    public enum CURRENCY {
        CAD, AED
    }

}
