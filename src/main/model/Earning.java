package main.model;

import main.exceptions.InvalidPriceRangeException;

public class Earning extends Expenditure {
    public Earning(String reason, int price, String currency) throws InvalidPriceRangeException {
        super(reason, price, currency);
    }
}
